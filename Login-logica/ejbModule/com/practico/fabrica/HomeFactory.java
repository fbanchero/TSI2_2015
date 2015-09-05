package com.practico.fabrica;

import javax.ejb.Local;

import com.practico.operaciones.interfaces.IOperBean;


@Local
public interface HomeFactory {
	
	public IOperBean getOperBean();
	
}
