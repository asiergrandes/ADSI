package model;

public class Valoracion {
    private Usuario usuario;
    private Pelicula pelicula;
    private double puntuacion;
    private String resena;
    
    
	public Valoracion(Usuario usuario, Pelicula pelicula, double puntuacion, String resena) {
		this.usuario = usuario;
		this.pelicula = pelicula;
		this.puntuacion = puntuacion;
		this.resena = resena;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Pelicula getPelicula() {
		return pelicula;
	}


	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}


	public double getPuntuacion() {
		return puntuacion;
	}


	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}


	public String getResena() {
		return resena;
	}


	public void setResena(String resena) {
		this.resena = resena;
	}

    // Getters y setters
    
	
}