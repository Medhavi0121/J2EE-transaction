package lk.java.jta;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ManagerFactory {
    public static EntityManagerFactory factory;

    static {
        factory = Persistence.createEntityManagerFactory("JTA-PU");
    }

    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }

    public static void close(){
        if(factory.isOpen()){
            factory.close();
        }
    }
}
