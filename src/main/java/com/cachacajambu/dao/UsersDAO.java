package com.cachacajambu.dao;

import com.cachacajambu.entity.Users;
import com.cachacajambu.session.SessionContext;
import org.primefaces.model.SortOrder;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.*;
import java.util.List;
import java.util.Map;

public class UsersDAO {
    private EntityManagerFactory emf;
    private EntityManager em;
    private static UsersDAO instance;

    public static UsersDAO getInstance() {
        if(instance == null)
            instance = new UsersDAO();
        return instance;
    }

    public UsersDAO() {
        em = getEntityManager();
        //emf = Persistence.createEntityManagerFactory("databasejambu");
        //em = emf.createEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("databasejambu");
        if(em == null) {
            em = factory.createEntityManager();
        }
        return em;
    }

    public void update(Users u) {
        try {
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void salvar(Users u) {
        try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void remover(Users u) {
       try {
           em.getTransaction().begin();
           u = em.find(Users.class, u.getIdusers());
           em.remove(u);
           em.getTransaction().commit();

       } catch (Exception e) {
           e.printStackTrace();
           em.getTransaction().rollback();
       }
    }

    public void removerById(final int id) {
        try {
            Users user = getById(id);
            remover(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Users getById(final int id) {
        return em.find(Users.class, id);
    }

    public List listar() {
        return em.createQuery("FROM " + Users.class.getName()).getResultList();
       // em.getTransaction().begin();
       // Query consulta = em.createQuery("SELECT users FROM Users users");
       // List<Users> lista = consulta.getResultList();
       // em.getTransaction().commit();
       // emf.close();

     //   return lista;
    }



    public Users Login(Users user) {
        try {

            return (Users) em
                    .createQuery("SELECT u from Users u where u.login =:name and u.senha = :senha")
                    .setParameter("name", user.getLogin())
                    .setParameter("senha", user.getSenha()).getSingleResult();
        } catch (NoResultException e) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!",
                            "Erro no Login!"));
            return null;
        }
    }


}
