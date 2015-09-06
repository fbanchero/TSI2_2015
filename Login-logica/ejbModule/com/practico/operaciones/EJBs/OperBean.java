package com.practico.operaciones.EJBs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import com.practico.clases.Direccion;
import com.practico.clases.Materia;
import com.practico.clases.Telefono;
import com.practico.clases.Usuario;
import com.practico.datatypes.DatosUsuario;
import com.practico.operaciones.interfaces.IOperBean;

@Stateless
public class OperBean implements IOperBean {

	@PersistenceContext(unitName = "BaseLogica")
	private EntityManager em;

	public DatosUsuario usuarioCorrecto(String user, String pas) {
		String consulta = " SELECT u FROM Usuario u"
				+ " WHERE u.nick = :user AND u.password = :pass";
		Query query = em.createQuery(consulta, Usuario.class);
		query.setParameter("user", user);
		query.setParameter("pass", pas);
		List<Usuario> result = query.getResultList();
		DatosUsuario datosUsuario = null;
		for (Usuario usr : result) {
			datosUsuario = new DatosUsuario(usr.getCodigo(), usr.getNick(),
					usr.getPassword(), usr.getMail(), usr.getNombre());
		}

		return datosUsuario;
	}
	
	public void altaUsuario(String nick, String pas, String mail,
			String nombre, String calle, int numPuerta) {
		Direccion dir = new Direccion(calle, numPuerta);
		Usuario usr = new Usuario(nick, pas, mail, nombre, dir);
		dir.getUsuarios().add(usr);
		em.persist(dir);
		em.persist(usr);
		
	}
	
	public void altaMateria(String codigoEnServicio, String nombre) {
		Materia mat = new Materia(codigoEnServicio, nombre);
		em.persist(mat);
	}
	
	public void agregarTelefonoUsuario(int codUsuario, String numero) {
		Telefono tel = new Telefono(numero);
		em.persist(tel);
		Usuario usr = em.find(Usuario.class, codUsuario);
		if (usr!=null) {
			usr.getTelefonos().add(tel);
		}
		em.merge(usr);
	}


}
