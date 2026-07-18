package lk.java.jta.ejb;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import lk.java.jta.entity.Account;

import java.math.BigDecimal;

@Stateless
public class AccountBeanImpl implements AccountBean {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void creditAmount(Long accountNo, BigDecimal amount) {
        // Implementation for crediting amount

        EntityTransaction transaction = em.getTransaction();
        System.out.println("creditAmount: "+ System.identityHashCode(transaction));

        try {
            Account account = em.createNamedQuery("Account.findByAccountNo", Account.class)
                    .setParameter("accountNumber", accountNo)
                    .getSingleResult();

            account.setBalance(account.getBalance().add(amount));

            em.merge(account);

        } catch (NoResultException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void debitAmount(Long accountNo, BigDecimal amount) {
        // Implementation for debiting amount

        EntityTransaction transaction = em.getTransaction();
        System.out.println("debitAmount: "+ System.identityHashCode(transaction));

        try {
            Account account = em.createNamedQuery("Account.findByAccountNo", Account.class)
                    .setParameter("accountNumber", accountNo)
                    .getSingleResult();

            account.setBalance(account.getBalance().subtract(amount));

            em.merge(account);

        } catch (NoResultException e) {
            e.printStackTrace();
        }
    }
}
