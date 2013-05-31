package com.example.test.web.servlets;

import com.example.test.dao.hibernate.OracleAccountHibernateDAO;
import com.example.test.entity.GenericAccountInfo;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

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
