package com.example.test.dao.impl;

import com.example.test.dao.AccountDAO;
import com.example.test.dao.DBUtils;
import com.example.test.entity.GenericAccountInfo;
import com.example.test.error.ErrorConstants;
import com.example.test.exception.InputException;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class OracleAccountDAO implements AccountDAO, ErrorConstants {

    public List<GenericAccountInfo> getAccount() {
        List<GenericAccountInfo> users = new ArrayList<GenericAccountInfo>();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            System.out.println("OK " + conn);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT G.user_id, G.fname, G.lname, G.email, G.pass, F.birth, F.workplace, F.city, F.state" +
                    "F.country, F.knowproglang  FROM GenericAccountInfo G JOIN FullAccountInfo F "
                    + "ON G.user_id = F.user_id");
            while (rs.next()) {
                GenericAccountInfo acc = new GenericAccountInfo();
                acc.setUser_id(rs.getInt(1));
                acc.setFname(rs.getString(2));
                acc.setLname(rs.getString(3));
                acc.setEmail(rs.getString(4));
                acc.setPass(rs.getString(5));
                acc.setBirth(rs.getDate(6));
                acc.setWorkplace(rs.getString(7));
                acc.setCity(rs.getString(8));
                acc.setState(rs.getString(9));
                acc.setCountry(rs.getString(10));
                acc.setKnowproglang(rs.getString(11));

                users.add(acc);
            }
        } catch (SQLException e) {
            System.err.println(SELECT_ERROR + getClass().getName());

        } finally {
            DBUtils.closeResultSet(rs);
            DBUtils.closeStatement(stmt);
            DBUtils.closeConnection(conn);
        }
        return users;
    }

    public void insertUser(GenericAccountInfo users) {
        PreparedStatement stmt = null;
        Connection conn = null;

        try {
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement("INSERT ALL "
                    +"INTO GenericAccountInfo (user_id, fname, lname, email, pass)"
                    +"VALUES (userid_seq.nextval,?,?,?,?)"
                    +"INTO FullAccountInfo (user_id, birthday, workplace, city, state, knowproglang, country)"
                    +"VALUES (userid_seq.currval,?,?,?,?,?,?)"
                    +"SELECT * FROM dual");
            try {
                if (isGenericParams(users)) {
                    stmt.setString(1, users.getFname());
                    stmt.setString(2, users.getLname());
                    stmt.setString(3, users.getEmail());
                    stmt.setString(4, users.getPass());
                    stmt.setDate(5, (Date) (users.getBirth()));
                    stmt.setString(6, users.getWorkplace());
                    stmt.setString(7, users.getCity());
                    stmt.setString(8, users.getState());
                    stmt.setString(9, users.getKnowproglang());
                    stmt.setString(10, users.getCountry());
                    stmt.execute();

                } else {
                    throw new InputException();
                }
            } catch (InputException e) {
                System.out.println("Введите корректные данные пользователя " + e);
            }
        } catch (SQLException e) {
            System.err.println(INSERT_ERROR + getClass().getName());

        }finally {
            DBUtils.closeStatement(stmt);
            DBUtils.closeConnection(conn);
        }
    }

    public boolean deleteUser(GenericAccountInfo users) {
        PreparedStatement stmt = null;
        Connection conn = null;

        try {
            stmt = conn.prepareStatement("DELETE FROM GenericAccountInfo WHERE user_id=?");
            if (users.getUser_id() <= 0) {
                stmt.setInt(1, users.getUser_id());
            } else {
                throw new InputException();
            }
            stmt.execute();

        } catch (InputException e) {

            System.out.println("Неправильно указан ID пользователя" + e);

        } catch (SQLException e) {
            System.err.println(DELETE_ERROR + getClass().getName());

        }finally {
            DBUtils.closeStatement(stmt);
            DBUtils.closeConnection(conn);
        }
        return false;
    }

    public GenericAccountInfo getUserById(int user_id) {
        GenericAccountInfo user = null;
        Connection conn = null;

        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT user_id, fname, lname, email, pass "
                            + "FROM GenericACoountInfo " + "WHERE user_id = ? ");
            stmt.setInt(1, user_id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                user = new GenericAccountInfo();
            }
            rs.close();
            stmt.close();
            return user;

        } catch (SQLException e) {
            System.err.println(INSERT_ERROR + getClass().getName());
        }finally {
            DBUtils.closeConnection(conn);
        }
        return user;
    }

    public void updateGenericAccountInfo(GenericAccountInfo users) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            stmt = conn.prepareStatement("UPDATE GenericAccountInfo SET"
                    + " fname=?, lname=?, email=?, pass=? WHERE user_id=?");
            try {
                if (isGenericParams(users)) {
                    stmt.setString(2, users.getLname());
                    stmt.setString(3, users.getEmail());
                    stmt.setString(4, users.getPass());
                    stmt.execute();

                } else {
                    throw new InputException();
                }
            } catch (InputException e) {
                System.out.println("Введите корректные данные пользователя" + e);
            }

        } catch (SQLException e) {
            System.err.println(UPDATE_ERROR + getClass().getName());
        } finally {
            DBUtils.closeStatement(stmt);
            DBUtils.closeConnection(conn);
        }

    }

    public void updateFullAccountInfo(GenericAccountInfo users) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            stmt = conn.prepareStatement("UPDATE FullAccountInfo SET"
                            + " birthday=?, workplace=?, city=?, state=?, knowproglang=?, country=?"
                            + "WHERE user_id=?");
            try {
                if (isGenericParams(users)) {
                    stmt.setDate(1, (Date) users.getBirth());
                    stmt.setString(2, users.getWorkplace());
                    stmt.setString(3, users.getCity());
                    stmt.setString(4, users.getState());
                    stmt.setString(5, users.getKnowproglang());
                    stmt.setString(6, users.getCountry());
                    stmt.execute();
                } else {
                    throw new InputException();
                }
            } catch (InputException e) {
                System.out.println("Введите корректные данные пользователя" + e);
            }
        } catch (SQLException e) {
            System.err.println(UPDATE_ERROR + getClass().getName());
        }finally {
            DBUtils.closeStatement(stmt);
            DBUtils.closeConnection(conn);
        }

    }

    public boolean isGenericParams(GenericAccountInfo users) {
        return users.getFname() != null && users.getEmail() != null
                && users.getPass() != null;
    }

}