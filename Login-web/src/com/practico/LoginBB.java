package com.practico;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.naming.NamingException;

import com.comunicacion.Comunicacion;
import com.practico.datatypes.DatosUsuario;

@ManagedBean
public class LoginBB {
	
	private String nick;
	private String pass;
	private DatosUsuario usuario;
	private boolean mostrarAdvertencia;
	
	public LoginBB() {
		super();
	}
	
	@PostConstruct
	private void init() {
		this.mostrarAdvertencia = false;
	}
	
	public String submit() {
		String retorno = "loginError";
		this.mostrarAdvertencia = false;
		try {
			this.usuario = Comunicacion.getInstance().getIOperBean().usuarioCorrecto(nick, pass);
			if (this.usuario != null) {
				this.mostrarAdvertencia = true;
				retorno = "loginOk";
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retorno;
	}
	
	public String logout() {
		return "Salir";
	}

	public String getNick() {
		return nick;
	}
	
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}

	public DatosUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(DatosUsuario usuario) {
		this.usuario = usuario;
	}

	public boolean isMostrarAdvertencia() {
		return mostrarAdvertencia;
	}

	public void setMostrarAdvertencia(boolean mostrarAdvertencia) {
		this.mostrarAdvertencia = mostrarAdvertencia;
	}
	
}
