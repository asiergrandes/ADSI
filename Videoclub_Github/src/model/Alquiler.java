package model;

import java.util.*;

//Clase Alquiler
public class Alquiler {
 private Date fechaHora;
 private Pelicula pelicula;
 private Usuario usuario;

 public Alquiler(Date pFechaHora, Pelicula pPeli, Usuario pUs) {
	 this.fechaHora = pFechaHora;
	 this.pelicula = pPeli;
	 this.usuario = pUs;
 }
 
 // Getters y setters
 public Date getFechaHora() {
     return fechaHora;
 }

 public void setFechaHora(Date fechaHora) {
     this.fechaHora = fechaHora;
 }
 
 public Pelicula getPelicula() {
     return pelicula;
 }

 public void setPelicula(Pelicula pelicula) {
     this.pelicula = pelicula;
 }
 
 public Usuario getUsuario() {
     return usuario;
 }

 public void setUsuario(Usuario usuario) {
     this.usuario = usuario;
 }
 
 public static Alquiler crearAlquiler(Usuario usuario, Pelicula pelicula) {
	 Date fechaAlquiler = new Date();
	 Alquiler al = new Alquiler(fechaAlquiler, pelicula, usuario);
	 return al;
 }

public boolean haFinalizado() {
	Date ahora = new Date();
	
	long diferenciaEnMilisegundos = ahora.getTime() - this.fechaHora.getTime();
	long diferenciaEnHoras = diferenciaEnMilisegundos / (1000 * 60 * 60);
	
	
	return diferenciaEnHoras > 48;
}
 
 
 
 
 
}