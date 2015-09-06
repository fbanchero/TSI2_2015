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
	private String nombre;
	private String mail;
	private String calle;
	private int numPuerta;
	
	
	public LoginBB() {
		super();
	}
	
	@PostConstruct
	private void init() {
		this.mostrarAdvertencia = false;
	}
	
	public String ingresar() {
		String retorno = "loginOk";
		this.mostrarAdvertencia = false;
		try {
			this.usuario = Comunicacion.getInstance().getIOperBean().usuarioCorrecto(nick, pass);
			if (this.usuario == null) {
				this.mostrarAdvertencia = true;
				retorno = "loginError";
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retorno;
	}
	
	public String registrarse() {
		return "Registrarse";
	}
	
	public String altaUsr() {
		this.mostrarAdvertencia = false;
		try {
			Comunicacion.getInstance().getIOperBean().altaUsuario(this.nick, this.pass, this.mail, this.nombre, this.calle, this.numPuerta);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "altaOk";
	}
	
	
	
	public String logout() {
		this.nick = null;
		this.pass = null;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumPuerta() {
		return numPuerta;
	}

	public void setNumPuerta(int numPuerta) {
		this.numPuerta = numPuerta;
	}
	
}
