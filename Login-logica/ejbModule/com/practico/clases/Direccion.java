package com.practico.clases;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "direcciones")
public class Direccion implements Serializable {
	
	@Id	
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO")
	private int codigo;
	
    @Column(name = "CALLE")
	private String calle;
    
    @Column(name = "NUMERO")
	private int numero;
    
    @Version
    @Column(name = "VERSION")
	private int version;
    
    @OneToMany (fetch = FetchType.LAZY, mappedBy = "direccion")
    private List<Usuario> usuarios;
    
    public Direccion() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	public Direccion(String calle, int numero) {
		super();
		this.calle = calle;
		this.numero = numero;
		this.usuarios = new LinkedList<Usuario>();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
}
