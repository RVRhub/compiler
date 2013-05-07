package test;

import dao.AccountDAO;
import dao.OracleAccountDAO;
import entity.GenericAccountInfo;

import java.sql.SQLException;

public class test {
    public static void main(String[] args) {

        GenericAccountInfo a = new GenericAccountInfo();
        //a.setUser_id(1);
        a.setFname("Гриша");
        a.setLname("Иванов");
        a.setEmail("grisha@gmail.com");
        a.setPass("ivanov");

        new OracleAccountDAO().insertUser(a);

    }
}
