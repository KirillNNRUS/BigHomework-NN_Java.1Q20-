package ent.pks.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionHibernate {
    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();
    
    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
