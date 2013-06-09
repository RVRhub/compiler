package com.compiler.web.servlets;


import com.compiler.dao.hibernate.OracleAccountHibernateDAO;
import com.compiler.entity.GenericAccountInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Registration")
public class Registration extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String fname = request.getParameter("fname") ;
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        try{

            GenericAccountInfo a = new GenericAccountInfo();

            a.setFname(fname);
            a.setLname(lname);
            a.setEmail(email);
            a.setPass(password);

            new OracleAccountHibernateDAO().insertUser(a);
            getServletContext().getRequestDispatcher("/RegistrationOK!.jsp").forward(request, response);

        }catch(Exception e){
            throw new ServletException(e);
        }

    }

}
