package controller;

import java.sql.Date;
import java.util.ArrayList;

import BBDD.DatabaseDelete;
import BBDD.DatabaseInsertion;
import BBDD.DatabaseUpdate;
import model.*;

public class GestorUsuarios {

	
	private static GestorUsuarios miGUsuarios = new GestorUsuarios();
	private ArrayList<Usuario> listaUsuarios;
	
	private GestorUsuarios() {
		listaUsuarios = new ArrayList<Usuario>();
		listaUsuarios.add(new Usuario("ss","primero@hotmail.com", "123", new Date(1,1,1)));
		listaUsuarios.add(new Usuario("ss","segundo@hotmail.com", "123", new Date(1,1,1)));
		listaUsuarios.add(new Usuario("ss","tercero@hotmail.com", "123", new Date(1,1,1)));
	}
	
	public static GestorUsuarios getGUsuarios() {
		return miGUsuarios;
	}
	
	
	public void eliminarUsuario(String pCorreo, String correoAdm) {
		Usuario unUs = null;
		boolean marcado = false;
		Usuario admin = null;
		for(Usuario u : listaUsuarios) {
			if(u.getCorreo().equalsIgnoreCase(pCorreo) && (listaUsuarios.indexOf(u) != listaUsuarios.size())) {
				unUs = u;
				
			}
		}
		for(Usuario u2 : listaUsuarios) {
			if(u2.getCorreo().equalsIgnoreCase(correoAdm)) {
				admin = u2;
			}
		}
		if(unUs != null) {
			admin.getSusEliminadosU().add(unUs);
			listaUsuarios.remove(unUs);
			DatabaseDelete.borrarUsuario(pCorreo);
		}
	}
	
	
	public boolean esAdmin(String pCorreo) {
		for (Usuario u : listaUsuarios) {
			if(u.getCorreo().equalsIgnoreCase(pCorreo)) {
				return u.isEsAdmin();
			}
		}
		return false;
	}
	
	
	public void modificarDatosUser(String pCorreo, String pNombre, String pContrasena) {
		for(Usuario u : listaUsuarios) {
			if(u.getCorreo().equalsIgnoreCase(pCorreo)) {
				if(!pNombre.isEmpty()) {
					u.setNombre(pNombre);
					DatabaseUpdate.updateNombre(pCorreo, pNombre);
				}
				if(!pContrasena.isEmpty()) {
					u.setContrasena(pContrasena);
					DatabaseUpdate.updateContra(pCorreo, pContrasena);
				}
			}
		}
	}
	
	public void marcarRegistrado(String correo, String correoAdm) {
		boolean marcado = false;
		Usuario admin = null;
		Usuario unUsuario = null;
		for(Usuario u : listaUsuarios) {
			if(u.getCorreo().equalsIgnoreCase(correo)) {
				marcado = true;
				unUsuario = u;
			}	
		}
		
		for(Usuario u2 : listaUsuarios) {
			if(u2.getCorreo().equalsIgnoreCase(correoAdm)) {
				admin = u2;
			}
		}
		unUsuario.marcarRegistrado();
		admin.getSusAceptadosU().add(unUsuario);
	}
	
	
	public boolean esAceptadoUsuario(int codUser) {
		boolean valido = false;
		
		for(Usuario u : listaUsuarios) {
			if(u.getCodUsuario() == codUser) {
				if(u.esValidoUsuario()) {
					return true; 
				}
			}
		}
		return valido;
		
	}
	
	public boolean anadirRegistro(String nombre, String correo, String contrasena, String fechaN) {
		//MODFICAR STRING INTO DATE(INT,INT,INT)
		int dia = 1;
		int mes = 1;
		int ano = 1;
		if (ano >= 1) { // Validar año
		    if (mes >= 1 && mes <= 12) { // Validar mes
		        if (dia >= 1 && dia <= diasEnMes(mes, ano)) { // Validar día según mes y año
		            System.out.println("La fecha es válida: " + dia + "/" + mes + "/" + ano);
		        } else {
		            return false;
		        }
		    } else {
		    	return false;
		    }
		} else {
		    return false;
		}
	
		
		for(Usuario u : listaUsuarios) {
			if(u.getCorreo().equalsIgnoreCase(correo)) {
				return false;
			}
		}
		Date fechaAdaptada = new Date(dia,mes,ano);
		listaUsuarios.add(new Usuario(nombre, correo, contrasena, fechaAdaptada));
		DatabaseInsertion.insertarUsuario(nombre, correo, contrasena, fechaAdaptada);
		return true;
	}
	
	
	public int diasEnMes(int mes, int ano) {
	    switch (mes) {
	        case 1: case 3: case 5: case 7: case 8: case 10: case 12:
	            return 31; // Meses con 31 días
	        case 4: case 6: case 9: case 11:
	            return 30; // Meses con 30 días
	        case 2:
	            return esBisiesto(ano) ? 29 : 28; // Febrero
	        default:
	            return 0; // Mes inválido
	    }
	}
	
	
	public boolean esBisiesto(int ano) {
	    return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
	}
	
	public boolean checkLogIn(String email, String password) {
		boolean logInCorrecto = false; 
		for (Usuario u : listaUsuarios) {
			if(u.getCorreo().equalsIgnoreCase(email) && u.getContrasena().equalsIgnoreCase(password)) {
				return true;
			}
			
		}
		return logInCorrecto;
	}
	
	public ArrayList<Usuario> getListaUsuarios(){
		return listaUsuarios;
	}

	public Usuario buscarUsuario(String correoUsuario) { 
		for (Usuario u : listaUsuarios) {
			if(correoUsuario == u.getCorreo()) {
				return u;
			}
		}
		return null;
	}
}
