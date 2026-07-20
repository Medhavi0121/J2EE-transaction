package lk.java.jta.ejb;

import jakarta.ejb.Local;

import java.math.BigDecimal;

@Local
public interface UserBean {
    boolean login(String username, String password);


    void register(String name, String email, String password);


    void transfer(Long from, Long to, BigDecimal amount);
}
