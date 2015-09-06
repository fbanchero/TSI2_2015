package com.practico.clases;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Version;

@Entity
public class Materia implements Serializable {
	
	@Id	
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO")
    private int codigo;
	
    private String codigoEnServicio;
    
    private String nombre;
    
    @Version
    private int version;
    
    @ManyToMany(mappedBy = "materias")
    private List<Usuario> usuarios;

	public Materia() {
		super();
	}

	public Materia(String codigoEnServicio, String nombre) {
		super();
		this.codigoEnServicio = codigoEnServicio;
		this.nombre = nombre;
		this.usuarios = new LinkedList<Usuario>();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCodigoEnServicio() {
		return codigoEnServicio;
	}

	public void setCodigoEnServicio(String codigoEnServicio) {
		this.codigoEnServicio = codigoEnServicio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
