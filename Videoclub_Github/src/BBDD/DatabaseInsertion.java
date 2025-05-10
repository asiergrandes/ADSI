package BBDD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class DatabaseInsertion {
    public static void insertarUsuario(String nombre, String correo, String contrasena,Date fechaN) {
        String sql = "INSERT INTO Usuario(nombre, correo, contrasena, fechaNacimiento) VALUES(?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, correo);
            pstmt.setString(3, contrasena);
            pstmt.setDate(4, fechaN);
            pstmt.executeUpdate();
            System.out.println("Estudiante añadido correctamente.");
        } catch (Exception e) {
            System.out.println("Error al insertar datos: " + e.getMessage());
        }
    }
    
    public static void insertarValoracion(String correo, int codPelicula, Double puntuacion,String resena) { 
        String sql = "INSERT INTO Valoracion(correo, codPelicula, puntuacion, resena) VALUES(?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, correo);
            pstmt.setInt(2, codPelicula);
            pstmt.setDouble(3, puntuacion);
            pstmt.setString(4, resena);
            pstmt.executeUpdate();
            System.out.println("Valoracion añadida correctamente.");
        } catch (Exception e) {
            System.out.println("Error al insertar datos: " + e.getMessage());
        }
    }
    
    public static void insertarPelicula() { 
        String sql = "INSERT INTO PELICULA(correo, codPelicula, puntuacion, resena) VALUES(?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            /*
        	pstmt.setString(1, correo);
            pstmt.setInt(2, codPelicula);
            pstmt.setDouble(3, puntuacion);
            pstmt.setString(4, resena);
            pstmt.executeUpdate();
            */
            System.out.println("Peliccula añadida correctamente.");
        } catch (Exception e) {
            System.out.println("Error al insertar datos: " + e.getMessage());
        }
    }
}

