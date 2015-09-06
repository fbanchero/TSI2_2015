package com.practico.clases;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;


@SuppressWarnings("serial")
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
	
//	@Id	
//  @Column(name = "CODIGO")
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Usuario_SEQ")
//	@SequenceGenerator(name = "Usuario_SEQ", sequenceName = "Usuario_SEQ", allocationSize = 1)
//	private int codigo;
	
	@Id	
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    
    @Version
    private int version;
    
    @OneToMany (fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinTable (name = "Usuarios_telefonos",
    		joinColumns = @JoinColumn(name = "codUsuario"),
    		inverseJoinColumns = @JoinColumn(name = "codTelefono"))
    private List<Telefono> telefonos;
    
    @ManyToOne
    @JoinColumn(name = "codDireccion")
    private Direccion direccion;
    
    @ManyToMany
    @JoinTable (name = "Usuarios_Materias", joinColumns = @JoinColumn(name = "codUsuario"), inverseJoinColumns = @JoinColumn(name = "codMateria"))
    private List<Materia> materias;
    
    public Usuario() {
		super();
	}

	public Usuario(String nick, String password, String mail,
			String nombre, Direccion direccion) {
		super();
		this.nick = nick;
		this.password = password;
		this.mail = mail;
		this.nombre = nombre;
		this.telefonos = new LinkedList<Telefono>();
		this.direccion = direccion;
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

	public List<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
}
