package com.zmo.helper;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.SessionFactory;

public class FactoryProduct {
    private static EntityManagerFactory emf;

    public static SessionFactory getSessionFactory() {
        if (emf == null) {
            try {
                // persistence.xml ke unit name ke sath connection banana
                emf = Persistence.createEntityManagerFactory("my_persistence_unit");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return emf.unwrap(SessionFactory.class);
    }

    public static void closeFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}