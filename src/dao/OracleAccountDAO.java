package dao;

import entity.GenericAccountInfo;
import Error.ErrorConstants;
import Exception.InputException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OracleAccountDAO implements AccountDAO, ErrorConstants {

    private Management management = null;
    private Connection conn = null;

    public OracleAccountDAO() {
        // инициализация
        management = Management.getInstance();
        conn = management.getConnection();
    }

    public List<GenericAccountInfo> getAccount() {
        List<GenericAccountInfo> users = new ArrayList<GenericAccountInfo>();

        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT user_id, fname, lname, email, pass, birthday," +
                    " workplace, city, state, knowproglang, country FROM GenericAccountInfo G JOIN FullAccountInfo F " +
                    "ON G.user_id = F.user_id");
            while (rs.next()) {
                GenericAccountInfo acc = new GenericAccountInfo();
                acc.setUser_id(rs.getInt(1));
                acc.setFname(rs.getString(2));
                acc.setLname(rs.getString(3));
                acc.setEmail(rs.getString(4));
                acc.setPass(rs.getString(4));
                acc.setBirth(rs.getDate(4));
                acc.setWorkplace(rs.getString(4));
                acc.setCity(rs.getString(4));
                acc.setState(rs.getString(4));
                acc.setCountry(rs.getString(4));
                acc.setKnowproglang(rs.getString(4));

                users.add(acc);
            }
        } catch (SQLException e) {
            System.err.println(INSERT_ERROR + getClass().getName());

        }
        return users;
    }

    public void insertUser(GenericAccountInfo users) {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("INSERT ALL" +
                    "INTO GenericAccountInfo (user_id, fname, lname, email, pass) VALUES (userid_seq.nextval, ?,?,?,?)" +
                    "INTO FullAccountInfo (user_id, birthday, workplace, city, state, knowproglang, country) VALUES (userid_seq.currval, ?,?,?,?,?,?)" + //id тоже???
                    "SELECT * FROM dual");
            try {
                if (users.getFname() != null) {
                    stmt.setString(1, users.getFname());
                } else {
                    throw new InputException();
                }
            } catch (InputException e) {
                System.out.println("Неверно указано Имя пользователя" + e);
            }
            try {
                if (users.getLname() != null) {
                    stmt.setString(2, users.getLname());
                } else {
                    throw new InputException();
                }
            } catch (InputException e) {
                System.out.println("Неверно указано Фамилия пользователя" + e);
            }
            try {
                if (users.getEmail() != null) {
                    stmt.setString(3, users.getEmail());
                } else {
                    throw new InputException();
                }
            } catch (InputException e) {
                System.out.println("Неверно указано Email пользователя" + e);
            }
            try {
                if (users.getPass() != null) {
                    stmt.setString(1, users.getPass());
                } else {
                    throw new InputException();
                }
            } catch (InputException e) {
                System.out.println("Неверно указан Пароль пользователя" + e);
            }
            stmt.execute();

        } catch (SQLException e) {
            System.err.println(INSERT_ERROR + getClass().getName());

        }
    }

    public boolean deleteUser(GenericAccountInfo users) {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("DELETE FROM GenericAccountInfo WHERE user_id=?");
            if (users.getUser_id() <= 0) {
                stmt.setInt(1, users.getUser_id());
            } else {
                throw new InputException();
            }
            stmt.execute();

        } catch (InputException e) {

            System.out.println("Неверно указан ID пользователя" + e);      //

        } catch (SQLException e) {
            System.err.println(INSERT_ERROR + getClass().getName());

        }
        return false;
    }

    public void updateGenericAccountInfo(GenericAccountInfo users)  {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("UPDATE GenericAccountInfo SET" +
                    "fname=?, lname=?, email=?, pass=?" + "WHERE user_id=?; " +
                    "");
            try {
                if (users.getFname() != null) {
                    stmt.setString(1, users.getFname());
                } else {
                    throw new InputException();
                }
            } catch (InputException e) {
                System.out.println("Неверно указано Имя пользователя" + e);
            }
            try {
                if (users.getLname() != null) {
                    stmt.setString(2, users.getLname());
                } else {
                    throw new InputException();
                }
            } catch (InputException e) {
                System.out.println("Неверно указано Фамилия пользователя" + e);
            }
            try {
                if (users.getEmail() != null) {
                    stmt.setString(3, users.getEmail());
                } else {
                    throw new InputException();
                }
            } catch (InputException e) {
                System.out.println("Неверно указано Email пользователя" + e);
            }
            try {
                if (users.getPass() != null) {
                    stmt.setString(1, users.getPass());
                } else {
                    throw new InputException();
                }
            } catch (InputException e) {
                System.out.println("Неверно указан Пароль пользователя" + e);
            }
            stmt.execute();

        } catch (SQLException e) {
            System.err.println(INSERT_ERROR + getClass().getName());

        }

    }

    public void updateFullAccountInfo(GenericAccountInfo users){
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("UPDATE FullAccountInfo SET" +
                    "birthday=?, workplace=?, city=?, state=?, knowproglang=?, country=?" + "WHERE user_id=?"
                    );
            try {
                if (users.getBirth() != null) {
                    stmt.setString(1, String.valueOf(users.getBirth()));
                } else {
                    throw new InputException();
                }
            } catch (InputException e) {
                System.out.println("Неверно указано ДР пользователя" + e);
            }
            try {
                if (users.getWorkplace() != null) {
                    stmt.setString(2, users.getWorkplace());
                } else {
                    throw new InputException();
                }
            } catch (InputException e) {
                System.out.println("Неверно указано Место работы пользователя" + e);
            }
            try {
                if (users.getCity() != null) {
                    stmt.setString(3, users.getCity());
                } else {
                    throw new InputException();
                }
            } catch (InputException e) {
                System.out.println("Неверно указано Город пользователя" + e);
            }
            try {
                if (users.getState() != null) {
                    stmt.setString(1, users.getState());
                } else {
                    throw new InputException();
                }
            } catch (InputException e) {
                System.out.println("Неверно указан Область пользователя" + e);
            }
            try {
                if (users.getKnowproglang() != null) {
                    stmt.setString(1, users.getKnowproglang());
                } else {
                    throw new InputException();
                }
            } catch (InputException e) {
                System.out.println("Неверно указан Язык пользователя" + e);
            }
            try {
                if (users.getCountry() != null) {
                    stmt.setString(1, users.getCountry());
                } else {
                    throw new InputException();
                }
            } catch (InputException e) {
                System.out.println("Неверно указана Страна пользователя" + e);
            }
            stmt.execute();

        } catch (SQLException e) {
            System.err.println(INSERT_ERROR + getClass().getName());

        }

    }




}