package dao;

import model.Professor;
import model.Escola;
import java.sql.*;
import java.util.ArrayList;

public class ProfessorDAO {

    public void inserir(Professor professor) {
        String sql = "INSERT INTO Professores (nome_professor, email, materia, senha, id_escola) VALUES (?, ?, ?, ?, ?)";
        Connection con = Conexao.conectar();

        if (con == null) {
            System.out.println("Erro: conexão nula!");
            return;
        }

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEmail());
            stmt.setString(3, professor.getMateria());
            stmt.setString(4, professor.getSenha());
            stmt.setInt(5, professor.getEscola().getId_escola());
            stmt.executeUpdate();
            System.out.println("Professor inserido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir professor: " + e.getMessage());
        }
    }

    public ArrayList<Professor> listar() {
        ArrayList<Professor> lista = new ArrayList<>();
        String sql = "SELECT * FROM Professores p JOIN Escola e ON p.id_escola = e.id_escola";

        Connection con = Conexao.conectar();

        if (con == null) {
            System.out.println("Erro: conexão nula!");
            return lista;
        }

        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Escola escola = new Escola(rs.getInt("id_escola"), rs.getString("nome_escola"));
                Professor professor = new Professor(
                        rs.getInt("RP"),
                        rs.getString("nome_professor"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("materia"),
                        escola
                );
                lista.add(professor);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar professores: " + e.getMessage());
        }

        return lista;
    }
}


