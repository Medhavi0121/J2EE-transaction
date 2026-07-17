package lk.java.jta;

import jakarta.ejb.EJB;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.java.jta.ejb.UserBean;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet("/test")
public class Test extends HttpServlet {

    @EJB
    private UserBean userBean;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        userBean.register("Dasun", "dasun@example.com", "4562");

    }
}
