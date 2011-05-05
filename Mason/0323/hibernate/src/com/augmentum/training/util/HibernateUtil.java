package com.augmentum.training.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * @author clay.zhong
 *
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    /**
     * Build Hibernate session factory from hibernate.cfg.xml.
     * 
     * @return
     */
    private static SessionFactory buildSessionFactory() {
        try {
            return new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Get Hibernate session factory.
     * 
     * @return
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Open new session for persistence operation.
     * 
     * @return
     */
    public static Session openSession() {
        return sessionFactory.getCurrentSession();
    }
}
