package com.sistema.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/pmdi", "sa", "");
        } catch (SQLException e) {
            System.out.println("Problemas ao conectar no banco de dados");
            JOptionPane.showMessageDialog(null, "Problemas ao conectar no banco de dados");
        } catch (ClassNotFoundException e) {
            System.out.println("O driver não foi configurado corretamente");
            JOptionPane.showMessageDialog(null, "O driver não foi configurado corretamente");
        }

        return conn;
    }
}
