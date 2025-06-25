package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {

    private static final String URL = "jdbc:sqlite:" +
        System.getProperty("user.dir") + System.getProperty("file.separator") +
        "src" + System.getProperty("file.separator") +
        "database" + System.getProperty("file.separator") +
        "simDB.db";

    public static Connection conectar() {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(URL);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro na conexão com o banco: " + e.getMessage(), e);
        }
    }
}

