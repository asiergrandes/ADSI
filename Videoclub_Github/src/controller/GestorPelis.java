package controller;

import java.util.ArrayList;
import java.util.Iterator;

import model.Alquiler;
import model.Pelicula;

public class GestorPelis {

	private ArrayList<Pelicula> lista;
	private static GestorPelis miGPelis = new GestorPelis();
	
	private GestorPelis() {
		this.lista = new ArrayList<Pelicula>();
		
		Pelicula pelicula1 = new Pelicula(1, "a", "a", "a", 2000, "a", "a");
		Pelicula pelicula2 = new Pelicula(2, "b", "b", "b", 2000, "b", "b");
		Pelicula pelicula3 = new Pelicula(3, "c", "c", "c", 2000, "c", "c");
		
		lista.add(pelicula1);
		lista.add(pelicula2);
		lista.add(pelicula3);
	}
	
	public static GestorPelis getGPelis() {
		return miGPelis;
	}

	public void anadirPelicula(Pelicula pelicula) {
		this.lista.add(pelicula);
	}
	
	public Iterator<Pelicula> getIterador(){
		return this.lista.iterator();
	}
	
	public Pelicula buscarPeliculaPorTitulo(String titulo) {
		Iterator<Pelicula> it = GestorPelis.getGPelis().getIterador();
		while (it.hasNext()) {
			Pelicula pelicula = it.next();
			if (pelicula.getTitulo().equals(titulo)) {
				return pelicula;
			}
		}
		return null;
	}
	
	public Pelicula buscarPeliculaPorCodigo(int codPelicula) {
		Iterator<Pelicula> it = GestorPelis.getGPelis().getIterador();
		while (it.hasNext()) {
			Pelicula pelicula = it.next();
			if (pelicula.getCodPeli() == codPelicula) {
				return pelicula;
			}
		}
		return null;
	}

}
