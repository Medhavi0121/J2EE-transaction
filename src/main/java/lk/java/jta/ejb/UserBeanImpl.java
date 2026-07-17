package lk.java.jta.ejb;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lk.java.jta.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Stateless
public class UserBeanImpl implements UserBean {

    @PersistenceContext(unitName = "JTA-PU")
    private EntityManager em;

    @Override
    public boolean login(String username, String password) {
        return false;
    }

    @Override
    public boolean register(String name, String email, String password) {

//        Session session = em.unwrap(Session.class);

//       Transaction transaction = session.beginTransaction();

//        em.getTransaction().begin();

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

//        em.persist(user);
        em.persist(user);
//        em.getTransaction().commit();

//        transaction.commit();

        return true;
    }
}
