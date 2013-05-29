package com.example.test.dao.impl;

import com.example.test.dao.DirectionDAO;
import com.example.test.error.ErrorConstants;
import com.example.test.exception.InputException;
import com.example.test.entity.Direction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OracleDirectionDAO implements DirectionDAO, ErrorConstants {


    public List<Direction> getDirection() {
        List<Direction> directions = new ArrayList<Direction>();
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            //TODO incorect fields
            stmt = conn.prepareStatement("SELECT D.dir_id, D.type_id, D.Dir_name, T.typeDir_name, T.type_id " +
                    "FROM Dir D JOIN typeDir T ON D.type_id = T.type_id");
            while (rs.next()) {
                Direction dir = new Direction();
                dir.setDir_id(rs.getInt(1));
                dir.setTypedir_id(rs.getInt(2));
                dir.setDirname(rs.getString(3));
                dir.setTypedirname(rs.getString(4));

                directions.add(dir);
            }

        } catch (SQLException e) {
            System.err.println(SELECT_ERROR + getClass().getName());

        }finally {
            DBUtils.closeResultSet(rs);
            DBUtils.closeStatement(stmt);
            DBUtils.closeConnection(conn);
        }

        return directions;
    }

    public void insertDir(Direction dir)  {
        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement("INSERT INTO Dir (dir_id, type_id, Dir_name) VALUES (Dir_seq.nextval,?,?)");
            try{
                //TODO incorect fields
                if(dir.getDirname() != null){
                    stmt.setInt(1, dir.getDir_id());
                    //stmt.setInt(2, dir.getTypedir_id());
                    stmt.setString(2, dir.getDirname());
                    stmt.execute();
                } else{
                    throw new InputException();
                }
            }catch (InputException e) {
                System.out.println("Введите коректные данные директории" + e);
            }
        }catch (SQLException e) {
            System.err.println(INSERT_ERROR + getClass().getName());
        }finally {
            DBUtils.closeResultSet(rs);
            DBUtils.closeStatement(stmt);
            DBUtils.closeConnection(conn);
        }

    }

    public boolean deleteDir(Direction dir) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement("DELETE FROM Dir WHERE dir_id=?");
            try{
                if(dir.getDir_id()<=0){

                    stmt.setInt(1, dir.getDir_id());
                    stmt.execute();
                }else {
                    throw new InputException();
                }
            }catch (InputException e) {
                System.out.println("Неверно указан ID директории" + e);
            }
        }catch (SQLException e) {
            System.err.println(DELETE_ERROR + getClass().getName());
        }finally {
            DBUtils.closeStatement(stmt);
            DBUtils.closeConnection(conn);
        }
        return false;
    }

    public void updateDir(Direction dir)  {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement("UPDATE Dir SET " +
                    "Dir_name=?, type_id=?" +
                    "WHERE dir_id=?  ");
            try{
                if(dir.getDirname() != null && dir.getDir_id()<=0 && dir.getTypedir_id()<=0){
                    stmt.setString(1, dir.getDirname());
                    stmt.setInt(2, dir.getDir_id());
                    stmt.setInt(3, dir.getTypedir_id());
                    stmt.execute();
                }else {
                    throw new InputException();
                }
            }catch (InputException e){
                System.out.println("Введите корректные данные директории" + e);
            }
        } catch (SQLException e) {
            System.err.println(UPDATE_ERROR + getClass().getName());
        }finally {
            DBUtils.closeStatement(stmt);
            DBUtils.closeConnection(conn);
        }
    }

    public void updateTypeDir (Direction dir){
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement("UPDATE typeDir SET " +
                    "typeDir_name=?" +
                    "WHERE type_id=?");
            try{
                if(dir.getTypedirname() != null && dir.getTypedir_id()<=0){
                    stmt.setString(1, dir.getTypedirname());
                    stmt.setInt(2, dir.getTypedir_id());
                    stmt.execute();
                }else {
                    throw new InputException();
                }
            }catch (InputException e){
                System.out.println("Введите коректные данные типа директории" + e);
            }
        } catch (SQLException e) {
            System.err.println(UPDATE_ERROR + getClass().getName());
        }finally {
            DBUtils.closeStatement(stmt);
            DBUtils.closeConnection(conn);
        }
    }
}
