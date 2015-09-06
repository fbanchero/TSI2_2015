package com.practico.operaciones.interfaces;

import javax.ejb.Local;

import com.practico.datatypes.DatosUsuario;

@Local
public interface IOperBean {
	
	public DatosUsuario usuarioCorrecto(String user, String pas);
	
	public void altaUsuario(String nick, String pas, String mail, String nombre, String calle, int numPuerta);
	
	public void altaMateria(String codigoEnServicio, String nombre);
	
	public void agregarTelefonoUsuario(int codUsuario, String numero);
	
}
