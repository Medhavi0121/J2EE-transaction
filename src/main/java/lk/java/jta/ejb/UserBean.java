package lk.java.jta.ejb;

import jakarta.ejb.Local;

@Local
public interface UserBean {
    boolean login(String username, String password);


    boolean register(String name, String email, String password);
}
