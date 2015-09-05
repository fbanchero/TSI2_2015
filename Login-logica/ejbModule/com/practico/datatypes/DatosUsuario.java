package com.practico.datatypes;

public class DatosUsuario {

	private int codigo;

	private String nick;

	private String password;

	private String mail;

	private String nombre;

	public DatosUsuario() {
		super();
	}
	
	public DatosUsuario(int codigo, String nick, String password, String mail,
			String nombre) {
		super();
		this.codigo = codigo;
		this.nick = nick;
		this.password = password;
		this.mail = mail;
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
