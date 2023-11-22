package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

    private static final String URL = "jdbc:postgresql://localhost:5432/ecoleta";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "admin";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

}
