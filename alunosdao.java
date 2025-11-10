package dao;

import model.Alunos;
import model.Escola;
import java.sql.*;
import java.util.ArrayList;

public class AlunosDAO {

    public void inserir(Alunos aluno) {
        String sql = "INSERT INTO Alunos (nome_aluno, email, ano_escolar, senha, id_escola) VALUES (?, ?, ?, ?, ?)";
        Connection con = Conexao.conectar();

        if (con == null) {
            System.out.println("Erro: conexão nula!");
            return;
        }

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setString(3, aluno.getAno_escolar());
            stmt.setString(4, aluno.getSenha());
            stmt.setInt(5, aluno.getEscola().getId_escola());
            stmt.executeUpdate();
            System.out.println("Aluno inserido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir aluno: " + e.getMessage());
        }
    }

    public ArrayList<Alunos> listar() {
        ArrayList<Alunos> lista = new ArrayList<>();
        String sql = "SELECT * FROM Alunos a JOIN Escola e ON a.id_escola = e.id_escola";

        try (Connection con = Conexao.conectar();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Escola escola = new Escola(rs.getInt("id_escola"), rs.getString("nome_escola"));
                Alunos aluno = new Alunos(
                        rs.getInt("RA"),
                        rs.getString("nome_aluno"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("ano_escolar"),
                        escola
                );
                lista.add(aluno);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar alunos: " + e.getMessage());
        }
        return lista;
    }
}

