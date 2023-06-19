package com.example.hibernate;


import com.example.hibernate.models.Buyer;
import com.example.hibernate.models.Product;
import com.example.hibernate.models.Sale;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.File;

public class HibernateUtil {

        private static SessionFactory sessionFactory;
        private static Session session;

        public static SessionFactory createSessionFactory() {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Sale.class);
            configuration.addAnnotatedClass(Product.class);
            configuration.addAnnotatedClass(Buyer.class);
            String hibernteFilePath = "C:/Users/sergej/Desktop/ASSIGNMENT.JAVAWEB/shop/src/main/resources/hibernate.cfg.xml";
            File hibernatePropsFile = new File(hibernteFilePath);
            configuration.configure(hibernatePropsFile);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
                    .build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            return sessionFactory;
        }

        public static Session openSession() {
            if(session != null && session.isOpen()) return session;
            sessionFactory = HibernateUtil.createSessionFactory();
            session = sessionFactory.openSession();
            return session;
        }

        public static void closeAll() {
            if(session != null && session.isOpen()) session.close();
            if(sessionFactory != null) sessionFactory.close();
        }
    }

