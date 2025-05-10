package controller;

public class GestorUsuarios {

	
	private static GestorUsuarios miGUsuarios = new GestorUsuarios();
	
	private GestorUsuarios() {
		
	}
	
	public static GestorUsuarios getGUsuarios() {
		return miGUsuarios;
	}
}
