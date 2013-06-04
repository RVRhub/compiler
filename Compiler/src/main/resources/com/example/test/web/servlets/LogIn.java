package com.example.test.web.servlets;

<<<<<<< HEAD:Compiler/src/main/resources/com/example/test/web/servlets/LogIn.java
import com.example.test.dao.hibernate.OracleAccountHibernateDAO;
import com.example.test.entity.GenericAccountInfo;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;
=======
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
>>>>>>> 3f450e23d87742140533f1abbea551f835a8e9af:Compiler/src/main/resources/com/example/test/web/servlets/LogIn.java

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD:Compiler/src/main/resources/com/example/test/web/servlets/LogIn.java
import java.io.IOException;
import java.util.ArrayList;
=======

import com.example.test.dao.hibernate.OracleAccountHibernateDAO;
import com.example.test.dao.impl.OracleAccountDAO;
import com.example.test.entity.Direction;
import com.example.test.entity.GenericAccountInfo;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
>>>>>>> 3f450e23d87742140533f1abbea551f835a8e9af:Compiler/src/main/resources/com/example/test/web/servlets/LogIn.java

@WebServlet("/login")

public class LogIn extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static SessionFactory factory;
    private static ServiceRegistry serviceRegistry;
    private static Logger log = Logger.getLogger(LogIn.class);

    public LogIn() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username") ;
        String password = request.getParameter("password");

        log.info("Login user: " + username);

        try{
            ArrayList<GenericAccountInfo> l = (ArrayList<GenericAccountInfo>) new OracleAccountHibernateDAO().getAccount();

            for(GenericAccountInfo account : l){
                if(account.getEmail().equals(username) && account.getPass().equals(password)) {
                    request.setAttribute("accountInfo", account);
                    getServletContext().getRequestDispatcher("/AccountInfo.jsp").forward(request, response);
                }
            }
        getServletContext().getRequestDispatcher("/LogOut.jsp").forward(request, response);
        }catch(Exception e){
            throw new ServletException(e);

        }
    }


}
