package controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Alquiler;
import model.Pelicula;
import model.Usuario;
import model.Valoracion;

public class GestorAlquileres {

	private static GestorAlquileres miGAlquileres = new GestorAlquileres();
	private ArrayList<Alquiler> lista;
	
	private GestorAlquileres() {
		lista = new ArrayList<Alquiler>();
	}
	
	public static GestorAlquileres getGAlquileres() {
		return miGAlquileres;
	}
	
	private Iterator<Alquiler> getIterador(){
		return this.lista.iterator();
	}
	
	public Alquiler crearAlquiler(Usuario usuario, Pelicula pelicula) {
		return Alquiler.crearAlquiler(usuario,pelicula);
	}
	
	public void anadirAlquiler(Usuario usuario,Alquiler alquiler) {
		this.lista.add(alquiler);
		usuario.anadirAlquiler(alquiler);
	}
	
	public void finalizarAlquiler(){
		Iterator<Alquiler> itr = this.getIterador();
		Alquiler unAlquiler;
		while(itr.hasNext()) {
			unAlquiler = itr.next();
			if (unAlquiler.haFinalizado()) {
				itr.remove();
			}
		}
	}

}
