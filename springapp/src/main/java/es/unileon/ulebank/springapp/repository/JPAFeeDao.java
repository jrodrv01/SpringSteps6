package es.unileon.ulebank.springapp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.ulebank.springapp.domain.Fee;

@Repository(value = "feeDao")
public class JPAFeeDao implements FeeDao {

    private EntityManager em = null;

    /*
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
	public List<Fee> getFeeList() {
		return em.createQuery("select p from Fee p order by p.id").getResultList();
	}


    @Transactional(readOnly = false)
    public void saveFees(Fee comm)  {
        em.merge(comm);
    }
}