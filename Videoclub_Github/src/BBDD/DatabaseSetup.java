package BBDD;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseSetup {
    
	
	public static void createTables() {
        String sql = "CREATE TABLE IF NOT EXISTS Usuario("
        		+ "codigoUsuario TEXT PRIMARY KEY INCREMENTAL,"
        		+ "nombre TEXT NOT NULL,"
        		+ "CORREO TEXT NOT NULL,"
        		+ "CONTRASEnA TEXT NOT NULL,"
        		+ "fechaNacimiento Date NOT NULL,"
        		+ "ESADMIN VARCHAR(2) NOT NULL,"
        		+ "ACEPTADO TEXT)";

        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabla 'usuario' creada o ya existe.");
        } catch (Exception e) {
            System.out.println("Error al crear la tabla: " + e.getMessage());
        }
    }
}
