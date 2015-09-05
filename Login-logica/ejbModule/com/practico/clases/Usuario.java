package com.practico.clases;
import java.io.Serializable;

import javax.persistence.*;


@SuppressWarnings("serial")
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
	
	@Id	
    @Column(name = "CODIGO")
	private int codigo;
	
    @Column(name = "NICK")
	private String nick;
	
    @Column(name = "PASSWORD")
	private String password;
	
    @Column(name = "MAIL")
	private String mail;
	
    @Column(name = "NOMBRE")
	private String nombre;
    
    public Usuario() {
		super();
	}

	public Usuario(String nick, String password, String mail,
			String nombre) {
		super();
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
