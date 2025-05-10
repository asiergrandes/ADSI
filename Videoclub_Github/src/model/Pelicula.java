package model;

import java.util.*;

public class Pelicula {
    private int codPelicula;
    private String titulo;
    private String director;
    private String actor;
    private int anio;
    private String archivoVideo;
    private String descripcion;
    private List<Valoracion> peValoraciones;
    
    public Pelicula(int pCodPelicula,String pTitulo,String pDirector, String pActor, int pAnio,String pArchivoVideo
    ,String pDescripcion) {
    	this.codPelicula = pCodPelicula;
   	 	this.titulo = pTitulo;
   	 	this.director = pDirector;
   	    this.actor = pActor;
	 	this.anio = pAnio;
	 	this.archivoVideo = pArchivoVideo;
	 	this.descripcion = pDescripcion;
    }
    // Getters y setters
    // Similar a los anteriores, se deben implementar para todos los atributos
    public String getTitulo() {
    	return this.titulo;
    }
	public String getDirector() {
		return this.director;
	}
	public int getAnio() {
		return this.anio;
	}
	public int getCodPeli() {
		return this.codPelicula;
	}
}