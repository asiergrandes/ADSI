package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DB_URL = "jdbc:sqlite:videoclub.db"; // Nombre de archivo .db

    public static Connection connect() {
        Connection conn = null;
        try {
            // Establecer la conexión
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Conexión a la base de datos establecida.");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return conn;
    }
}
