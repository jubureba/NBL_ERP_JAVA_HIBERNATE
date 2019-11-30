package com.cachacajambu.dao;

import com.cachacajambu.entity.Users;
import com.cachacajambu.util.HibernateUtil;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.util.List;


public class UsersDAO {



    public void salvar(Users u){
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            sessao.persist(u);

            sessao.getTransaction().commit();
            sessao.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }



    public List<Users> listar() {
            Session sessao = HibernateUtil.getSessionFactory().openSession();

            List<Users> user = sessao.getNamedQuery("Users.findAll").list();

            sessao.close();

            return user;

    }

    public void alterar(Users user) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();

        sessao.merge(user);

        sessao.getTransaction().commit();
        sessao.close();
    }

    public void deletar(Long id) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();

        sessao.delete(sessao.get(Users.class, id));

        sessao.getTransaction().commit();
        sessao.close();
    }

    public Users pesquisarPorId(Long id) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();

        Users user = (Users) sessao.merge(sessao.get(Users.class, id));

        sessao.getTransaction().commit();
        sessao.close();

        return user;
    }



}
