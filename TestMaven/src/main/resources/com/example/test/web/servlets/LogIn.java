package com.example.test.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.test.dao.impl.OracleAccountDAO;
import com.example.test.entity.GenericAccountInfo;

@WebServlet("/login")

public class LogIn extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LogIn() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username") ;
        String password = request.getParameter("password");
        try{
            ArrayList<GenericAccountInfo> l = (ArrayList<GenericAccountInfo>) new OracleAccountDAO().getAccount();

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
