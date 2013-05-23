package com.example.test.dao.impl;

import com.example.test.dao.DBUtils;
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
            stmt = conn.prepareStatement("SELECT dir_id, type_id, Dir_name, typeDir_name FROM Dir D JOIN typeDir T ON D.type_id = T.type_id");
            while (rs.next()) {
                Direction dir = new Direction();
                dir.setDir_id(rs.getInt(1));
                dir.setTypedir_id(rs.getInt(2));
                dir.setDirname(rs.getString(3));
                dir.setTypedirname(rs.getString(4));

                directions.add(dir);
            }

        } catch (SQLException e) {
            System.err.println(INSERT_ERROR + getClass().getName());

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
                if(dir.getTypedirname() != null){
                    stmt.setInt(1, dir.getTypedir_id());
                    stmt.setString(1, dir.getTypedirname());      ///
                } else{
                    throw new InputException();
                }
            }catch (InputException e) {
                System.out.println("������� ������� ��� ����������" + e);
            }
            try{
                if(dir.getDirname() != null){
                    stmt.setString(2, dir.getDirname());
                } else{
                    throw new InputException();
                }
            }catch (InputException e) {
                System.out.println("������� ������� ��� ����������" + e);
            }
            stmt.execute();


        }catch (SQLException e) {
            System.err.println(INSERT_ERROR + getClass().getName());
        }

    }

    public boolean deleteDir(Direction dir) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement("DELETE FROM Dir WHERE dir_id=?");
            stmt.setInt(1, dir.getDir_id());

        } catch (SQLException e) {
            System.err.println(INSERT_ERROR + getClass().getName());
        }
        return false;
    }

    public void updateDir(Direction dir)  {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement("UPDATE Dir SET " +
                    "Dir_name=?" +
                    "WHERE dir_id=?");
            try{
                if(dir.getDirname() != null){
                    stmt.setString(1, dir.getDirname());
                }else {
                    throw new InputException();
                }
            }catch (InputException e){
                System.out.println("������� ������� ��� ����������" + e);
            }
            stmt.execute();

        } catch (SQLException e) {
            System.err.println(INSERT_ERROR + getClass().getName());
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
                if(dir.getTypedirname() != null){
                    stmt.setString(1, dir.getTypedirname());
                }else {
                    throw new InputException();
                }
            }catch (InputException e){
                System.out.println("������� ������� ��� ���� ����������" + e);
            }
            stmt.execute();

        } catch (SQLException e) {
            System.err.println(INSERT_ERROR + getClass().getName());
        }

    }



}
