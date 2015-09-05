package com.comunicacion;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.practico.operaciones.interfaces.IOperBean;

public class Comunicacion {
	
	private static Comunicacion inst = null;
	private Context ctx;
	
	public Comunicacion() throws NamingException {
		super();
		this.ctx = new InitialContext();
	}
	
	public static Comunicacion getInstance() throws NamingException {
		if (Comunicacion.inst == null) {
			Comunicacion.inst = new Comunicacion();
		}
		return Comunicacion.inst;
	}
		
	public IOperBean getIOperBean() throws NamingException {
		return (IOperBean)this.ctx.lookup("java:app/Login-logica/OperBean!com.practico.operaciones.interfaces.IOperBean");
	}

}
