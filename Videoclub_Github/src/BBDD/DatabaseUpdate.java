package BBDD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class DatabaseUpdate {
	public static void updateNombre(String correo, String nombre) {
        String sql = "UPDATE USUARIO WHERE correo = ? SET nombre = ?";

        try (Connection conn = DatabaseConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, correo);
            pstmt.setString(2, nombre);
            
            pstmt.executeUpdate();
            System.out.println("Estudiante añadido correctamente.");
        } catch (Exception e) {
            System.out.println("Error al insertar datos: " + e.getMessage());
        }
    }
	
	public static void updateContra(String correo, String contrasena) {
        String sql = "UPDATE USUARIO WHERE correo = ? SET contrasena = ?";

        try (Connection conn = DatabaseConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, correo);
            pstmt.setString(2, contrasena);
            
            pstmt.executeUpdate();
            System.out.println("Estudiante añadido correctamente.");
        } catch (Exception e) {
            System.out.println("Error al insertar datos: " + e.getMessage());
        }
    }

	public static void updatePuntuacion(String pCorreo, Double pPuntuacion) {
		 String sql = "UPDATE VALORACION WHERE correo = ? SET puntuacion = ?";

	        try (Connection conn = DatabaseConnection.connect();
	            PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, pCorreo);
	            pstmt.setDouble(2, pPuntuacion);
	            
	            pstmt.executeUpdate();
	            System.out.println("Valoración modificado correctamente.");
	        } catch (Exception e) {
	            System.out.println("Error al insertar datos: " + e.getMessage());
	        }
	}
	
	public static void updateResena(String pCorreo, String pResena) {
		String sql = "UPDATE VALORACION WHERE correo = ? SET resena = ?";

        try (Connection conn = DatabaseConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, pCorreo);
            pstmt.setString(2, pResena);
            
            pstmt.executeUpdate();
            System.out.println("Valoracion modificado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al insertar datos: " + e.getMessage());
        }
	}
}
