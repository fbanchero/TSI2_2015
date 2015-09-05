package com.practico.fabrica;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Named;

import com.practico.operaciones.interfaces.IOperBean;

@Stateless
@Named
public class HomeFactoryBean implements HomeFactory {
	
	@Resource
	public SessionContext ctx;
	
	@Override
	public IOperBean getOperBean() {
		return (IOperBean) ctx.lookup("java:module/OperBean!com.practico.operaciones.interfaces.IOperBean");
	}

}
