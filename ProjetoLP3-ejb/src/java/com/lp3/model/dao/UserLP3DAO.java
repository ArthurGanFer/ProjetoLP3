package com.lp3.model.dao;

import com.br.lp3.model.entities.UserLP3;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author 31338283
 */
public class UserLP3DAO implements GenericDAO<UserLP3> {

    private EntityManager em;

    public UserLP3DAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LP3PU");
        em = emf.createEntityManager();
    }

    @Override
    public boolean create(UserLP3 e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public List<UserLP3> readAll() {
        Query query = em.createQuery("SELECT u FROM UserLP3 u");
        List<UserLP3> lista = query.getResultList();
        return lista;
    }

    @Override
    public UserLP3 readById(long id) {
        Query query = em.createQuery("SELECT u FROM UserLP3 u WHERE u.id_user = :id");
        query.setParameter("id", id);
        return (UserLP3) query.getSingleResult();
    }

    public UserLP3 readByUsername(String username) {
        Query query = em.createQuery("SELECT u FROM UserLP3 u WHERE u.username = :username");
        query.setParameter("username", username);
        return (UserLP3) query.getSingleResult();
    }

    @Override
    public boolean update(UserLP3 e) {
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public boolean delete(UserLP3 e) {
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
        return true;
    }

}
