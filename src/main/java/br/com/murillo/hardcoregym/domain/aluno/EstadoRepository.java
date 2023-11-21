package br.com.murillo.hardcoregym.domain.aluno;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.murillo.hardcoregym.domain.interfaces.EstadoInterface;


@Stateless
public class EstadoRepository implements EstadoInterface {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Estado> listEstados(){
		return em.createQuery("SELECT e FROM Estado e ORDER BY e.nome", Estado.class).getResultList();
		
	}

}
