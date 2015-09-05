package com.practico.operaciones.interfaces;

import javax.ejb.Local;

import com.practico.datatypes.DatosUsuario;

@Local
public interface IOperBean {
	
	public DatosUsuario usuarioCorrecto(String user, String pas);
	
}
