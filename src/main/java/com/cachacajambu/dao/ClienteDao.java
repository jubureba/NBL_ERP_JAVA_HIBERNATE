package com.cachacajambu.dao;
import com.cachacajambu.entity.Cliente;
import com.cachacajambu.entity.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ClienteDao {

    private EntityManager emf;
    private EntityManager em;
    private static ClienteDao instance;


    public ClienteDao () {
        em = getEntityManager();
    }
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("databasejambu");
        if(em == null) {
            em = factory.createEntityManager();
        }
        return em;
    }


    public List listar () {
        return em.createQuery("FROM " + Cliente.class.getName()).getResultList();
    }

    public void salvar(Cliente c) {
        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void remover(Cliente u) {
        try {
            em.getTransaction().begin();
            u = em.find(Cliente.class, u.getIdcliente());
            em.remove(u);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void removerById(final int id) {
        try {
            Cliente cliente = getById(id);
            remover(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Cliente getById(final int id) {
        return em.find(Cliente.class, id);
    }
}
