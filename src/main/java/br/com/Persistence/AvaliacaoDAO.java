package br.com.Persistence;

import jakarta.persistence.EntityManager;
import java.util.List;

import br.com.Entidade.Avaliacao;
import br.com.Entidade.JPAUtil;

public class AvaliacaoDAO {
    public AvaliacaoDAO(EntityManager em) {
		
	}

	public void salvar(Avaliacao avaliacao) {
        EntityManager em = (EntityManager) JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(avaliacao);
        em.getTransaction().commit();
        em.close();
    }

    public Avaliacao buscarPorId(Long id) {
        EntityManager em = (EntityManager) JPAUtil.getEntityManager();
        Avaliacao avaliacao = em.find(Avaliacao.class, id);
        avaliacao.getComentarios().size();
        em.close();
        return avaliacao;
    }

    public List<Avaliacao> listar() {
        EntityManager em = (EntityManager) JPAUtil.getEntityManager();
        List<Avaliacao> avaliacoes = em.createQuery("FROM Avaliacao", Avaliacao.class).getResultList();
        em.close();
        return avaliacoes;
    }

    public void atualizar(Avaliacao avaliacao) {
        EntityManager em = (EntityManager) JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(avaliacao);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Long id) {
        EntityManager em = (EntityManager) JPAUtil.getEntityManager();
        em.getTransaction().begin();
        Avaliacao avaliacao = em.find(Avaliacao.class, id);
        if (avaliacao != null) {
            em.remove(avaliacao);
        }
        em.getTransaction().commit();
        em.close();
    }
}
