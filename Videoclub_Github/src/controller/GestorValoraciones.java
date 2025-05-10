package controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import BBDD.DatabaseInsertion;
import BBDD.DatabaseUpdate;
import model.Pelicula;
import model.Usuario;
import model.Valoracion;

public class GestorValoraciones {

	private ArrayList<Valoracion> lista;
	private static GestorValoraciones miGV = new GestorValoraciones();
	
	private GestorValoraciones() {
		this.lista = new ArrayList<Valoracion>();
		
		Usuario usuario1 = new Usuario("ss","primero@hotmail.com", "123", new Date(1,1,1));
		Usuario usuario2 = new Usuario("ss","segundo@hotmail.com", "123", new Date(1,1,1));
		Usuario usuario3 = new Usuario("ss","tercero@hotmail.com", "123", new Date(1,1,1));
		
		Pelicula pelicula1 = new Pelicula(1, "a", "a", "a", 2000, "a", "a");
		Pelicula pelicula2 = new Pelicula(2, "b", "b", "b", 2000, "b", "b");
		Pelicula pelicula3 = new Pelicula(3, "c", "c", "c", 2000, "c", "c");
		
		lista.add(new Valoracion(usuario1, pelicula1, 0, "Mal"));
		lista.add(new Valoracion(usuario1, pelicula2, 10, "Recomendable"));
		lista.add(new Valoracion(usuario1, pelicula3, 5.5, "Meh"));
		lista.add(new Valoracion(usuario2, pelicula1, 6.4, "Bien"));
		lista.add(new Valoracion(usuario2, pelicula2, 1.2, "No me gusta"));
		lista.add(new Valoracion(usuario2, pelicula3, 1.6, "Desagradable"));
		lista.add(new Valoracion(usuario3, pelicula1, 0.1, "Pesima"));
		lista.add(new Valoracion(usuario3, pelicula2, 0.9, "Mala"));
		lista.add(new Valoracion(usuario3, pelicula3, 9.9, "Casi Perfecto"));
		

	}
	
	public static GestorValoraciones getGV() {
		return miGV;
	}

	public void anadirValoracion(Valoracion valoracion) {
		this.lista.add(valoracion);
	}
	
	public Iterator<Valoracion> getIterador(){
		return this.lista.iterator();
	}
	public List<Valoracion> getListaVal(){
		return lista;
	}
	
	public boolean anadirVal(String correo, Pelicula pPelicula, Double puntuacion, String resena) {
        for(Valoracion v : lista) {
            if(v.getPelicula().equals(pPelicula)) {
                return false;
                }
        }
        if(puntuacion >= 0 && puntuacion <= 10) {
            Usuario usuario = GestorUsuarios.getGUsuarios().buscarUsuario(correo);
            lista.add(new Valoracion(usuario, pPelicula, puntuacion, resena));
            DatabaseInsertion.insertarValoracion(correo, pPelicula.getCodPeli(), puntuacion, resena);
            return true;
                }
        else {
            return false;
        }
	}

	public void modificarValoracion(String pCorreo, Double pPuntuacion, String pResena) {
		for(Valoracion v : lista) {
			if(v.getUsuario().getCorreo().equalsIgnoreCase(pCorreo)) {
				if(pPuntuacion >= 0 && pPuntuacion <= 10) {
					v.setPuntuacion(pPuntuacion);
					DatabaseUpdate.updatePuntuacion(pCorreo, pPuntuacion);
				}
				if(!pResena.isEmpty()) {
					v.setResena(pResena);
					DatabaseUpdate.updateResena(pCorreo, pResena);
				}
			}
		}
		
	}

	public ArrayList<Valoracion> getListaValoracionPorPelicula(Pelicula pPelicula) {
		ArrayList<Valoracion> listaVal = null;
		
		for(Valoracion v: lista) {
			if(v.getPelicula().equals(pPelicula)) {
				listaVal.add(v);
			}
		}
		return listaVal;
	}
}
