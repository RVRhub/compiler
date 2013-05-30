package com.example.test.test;

import com.example.test.dao.hibernate.OracleAccountHibernateDAO;
import com.example.test.entity.GenericAccountInfo;

public class Test {
        public static void main(String[] args) {

        GenericAccountInfo a = new GenericAccountInfo();

           a.setFname("aaa");
           a.setLname("aaa");
           a.setEmail("a@gmail.com");
           a.setPass("11111");



        new OracleAccountHibernateDAO().insertUser(a);

    }
}
