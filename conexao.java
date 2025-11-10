package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    public static Connection conectar() {
        Connection conexao = null;

        try {
            String url = "jdbc:mysql://127.0.0.1:3306/banco?useSSL=false&serverTimezone=UTC";
            String usuario = "root";
            String senha = "";

            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conectado!");
        } catch (Exception e) {
            System.out.println("Erro na conexão: " + e.getMessage());
        }

        return conexao;
    }
}


