package br.com.murillo.hardcoregym.domain.acesso;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.com.murillo.hardcoregym.domain.aluno.Aluno;
import br.com.murillo.hardcoregym.domain.interfaces.AcessoInterface;

@Stateless
public class AcessoRepository implements AcessoInterface{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Acesso findUltimoAcesso(Aluno aluno) {
		try {
		return em.createQuery("SELECT a FROM Acesso a WHERE a.aluno.matricula = :matricula ORDER BY a.id DESC",Acesso.class)
				.setParameter("matricula", aluno.getMatricula())
				.setMaxResults(1)
				.getSingleResult();
	          }catch(NoResultException e) {
	        	  return null;
	          }
		}
	
	@Override
	public void store(Acesso acesso) {
		em.persist(acesso);
	}
	
	
}
