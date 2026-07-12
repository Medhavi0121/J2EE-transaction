package lk.java.jta;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet("/test")
public class Test extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       EntityManager em = ManagerFactory.getEntityManager();

        List<Objects[]> resultList = em.createNativeQuery("select * from user").getResultList();
        resultList.forEach(r->{
            System.out.println(r[0] +" : "+r[1]+" : "+r[2]+" : "+r[3]);
        });
    }
}
