package com.cachacajambu.util;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;


public class HibernateUtil {

    private static final SessionFactory sessionFactory ;
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml)
            // config file.
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception.
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }


    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
