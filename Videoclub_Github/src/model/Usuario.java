package model;

import java.sql.Date;
import java.util.*;

public class Usuario {
    private int codUsuario;
    private String correo;
    private Date fechaNacimiento;
    private String contrasena;
    private String nombre;
    private boolean esAdmin;
    private List<Alquiler> susAlquileres;
    private List<Valoracion> susValoraciones;
    private List<Pelicula> susAnadidasP;
    private List<Pelicula> susEliminadasP;
    private List<Usuario> susEliminadosU;
    private List<Usuario> susAceptadosU;
    private boolean esAceptado = false;
    
    
    public Usuario(String nombre, String correo, String contrasena, Date fechaN) {
    	this.nombre = nombre;
    	this.correo = correo;
    	this.contrasena = contrasena;
    	this.fechaNacimiento = fechaN;
    	this.esAdmin = false;
    	this.susAlquileres = new ArrayList<>();
    	this.susValoraciones = new ArrayList<>();
    	this.susAnadidasP = new ArrayList<>();
        this.susEliminadasP = new ArrayList<>();
    	this.susEliminadosU = new ArrayList<>();
    	this.susAceptadosU = new ArrayList<>();
    	
    }
    public void marcarRegistrado() {
    	this.esAceptado = true;
    }
    public boolean esValidoUsuario() {
    	return this.esAceptado;
    }
    
    // Getters y setters
    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

    public List<Alquiler> getSusAlquileres() {
        return susAlquileres;
    }

    public void setSusAlquileres(List<Alquiler> susAlquileres) {
        this.susAlquileres = susAlquileres;
    }

    public List<Valoracion> getSusValoraciones() {
        return susValoraciones;
    }

    public void setSusValoraciones(List<Valoracion> susValoraciones) {
        this.susValoraciones = susValoraciones;
    }

    public List<Pelicula> getSusAnadidasP() {
        return susAnadidasP;
    }

    public void setSusAnadidasP(List<Pelicula> susAnadidasP) {
        this.susAnadidasP = susAnadidasP;
    }

    public List<Pelicula> getSusEliminadasP() {
        return susEliminadasP;
    }

    public void setSusEliminadasP(List<Pelicula> susEliminadasP) {
        this.susEliminadasP = susEliminadasP;
    }

    public List<Usuario> getSusEliminadosU() {
        return susEliminadosU;
    }

    public void setSusEliminadosU(List<Usuario> susEliminadosU) {
        this.susEliminadosU = susEliminadosU;
    }

    public List<Usuario> getSusAceptadosU() {
        return susAceptadosU;
    }

    public void setSusAceptadosU(List<Usuario> susAceptadosU) {
        this.susAceptadosU = susAceptadosU;
    }
    
    public boolean laHeAlquilado(int codPelicula) {
    	boolean alquilada = false;
    	if(this.susAlquileres == null) {
    		
    	}
    		for (Alquiler al : this.susAlquileres) {
    			if (al.getPelicula().getCodPeli() == codPelicula) {
    				alquilada = true;
    				break;
    			}
    		}
    	return alquilada;
    }
	public void anadirAlquiler(Alquiler alquiler) {
		this.susAlquileres.add(alquiler);		
	}
}