package com.compiler.dao.hibernate;

import com.compiler.dao.AccountDAO;

public class Factory {
    private static AccountDAO studentDAO = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance(){
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }

    public AccountDAO getStudentDAO(){
        if (studentDAO == null){
            studentDAO = new OracleAccountHibernateDAO();
        }
        return studentDAO;
    }
}
