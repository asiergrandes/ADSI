package controller;



import java.sql.Date;

import BBDD.DatabaseConnection;
import BBDD.DatabaseInsertion;
import BBDD.DatabaseSetup;

public class VideoClub {

	private static VideoClub miVideoClub = new VideoClub();
	
	private VideoClub() {
		DatabaseSetup.createTables();
		DatabaseInsertion.insertarUsuario("first", "first@firstmai.first", "first123",new Date(1,1,1));
	}
	
	public static VideoClub getVC() {
		return miVideoClub;
	}
	
	public void startVC() {
		
	}
}
