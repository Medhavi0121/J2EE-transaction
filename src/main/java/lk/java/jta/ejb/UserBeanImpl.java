package lk.java.jta.ejb;

import jakarta.annotation.Resource;
import jakarta.ejb.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.*;
import lk.java.jta.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class UserBeanImpl implements UserBean {

    @PersistenceContext(unitName = "JTA-PU")
    private EntityManager em;

    @EJB
    private AccountBean accountBean;

//    @Resource
//    private UserTransaction tr;

    @Override
    public boolean login(String username, String password) {
        return false;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void register(String name, String email, String password) {

//        Session session = em.unwrap(Session.class);

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        em.persist(user);

    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public void transfer(Long from, Long to, BigDecimal amount) {

//        EntityTransaction transaction = em.getTransaction();
//        System.out.println("transfer: "+ System.identityHashCode(transaction));

//        transaction.commit();

        //REQUIRES_NEW & NOT_SUPPORTED

        //        System.out.println(transaction);

        accountBean.debitAmount(from, amount); // JTA + IIOP
        accountBean.creditAmount(to, amount);


    }
}
