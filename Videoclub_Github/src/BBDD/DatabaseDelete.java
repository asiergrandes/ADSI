package BBDD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class DatabaseDelete {
	public static void borrarUsuario(String correo) {
        String sql = "DELETE FROM Usuario WHERE correo = ?";

        try (Connection conn = DatabaseConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, correo);
            System.out.println("Usuario -> "+ correo + ": borrado correctamente");
            conn.abort(null);
        } catch (Exception e) {
            System.out.println("Error al insertar datos: " + e.getMessage());
        }
    }
}
