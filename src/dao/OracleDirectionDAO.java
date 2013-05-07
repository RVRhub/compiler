package dao;

import Exception.InputException;
import entity.Direction;
import Error.ErrorConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OracleDirectionDAO implements DirectionDAO,ErrorConstants {

    private Management management = null;
    private Connection conn = null;

    public OracleDirectionDAO() {
        management = Management.getInstance();
        conn = management.getConnection();

    }

    public List<Direction> getDirection() {
        List<Direction> directions = new ArrayList<Direction>();
        Statement stmt = null;
        ResultSet rs = null;

        try {
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
        try {
            stmt = conn.prepareStatement("INSERT ALL" +
                    "INTO typeDir (type_id, typeDir_name) VALUES (typeDir_seq.nextval,?)" +
                    "INTO Dir (dir_id, type_id, Dir_name) VALUES (?, typeDir_seq.currval, ?)");
            try{
                if(dir.getTypedirname() != null){
                    stmt.setString(1, dir.getTypedirname());
                } else{
                    throw new InputException();
                }
            }catch (InputException e) {
                System.out.println("Неверно указано Тип директории" + e);
            }
            try{
                if(dir.getDirname() != null){
                    stmt.setString(2, dir.getDirname());
                } else{
                    throw new InputException();
                }
            }catch (InputException e) {
                System.out.println("Неверно указано Имя директории" + e);
            }
            stmt.execute();


        }catch (SQLException e) {
            System.err.println(INSERT_ERROR + getClass().getName());
        }

    }

    public boolean deleteDir(Direction dir) {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("DELETE FROM Dir WHERE dir_id=?");
            stmt.setInt(1, dir.getDir_id());

        } catch (SQLException e) {
            System.err.println(INSERT_ERROR + getClass().getName());
        }
        return false;
    }

    public void updateDir(Direction dir)  {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("UPDATE Dir SET" +
                    "type_id=?, Dir_name=?" +
                    "WHERE dir_id=?");
            try{
                if(dir.getDirname() != null){
                    stmt.setString(1, dir.getDirname());
                }else {
                    throw new InputException();
                }
            }catch (InputException e){
                System.out.println("Неверно указано Имя директории" + e);
            }
            stmt.execute();

        } catch (SQLException e) {
            System.err.println(INSERT_ERROR + getClass().getName());
        }
    }

    public void updateTypeDir (Direction dir){
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("UPDATE typeDir SET" +
                    "typeDir_name=?" +
                    "WHERE type_id=?");
            try{
                if(dir.getTypedirname() != null){
                    stmt.setString(1, dir.getTypedirname());
                }else {
                    throw new InputException();
                }
            }catch (InputException e){
                System.out.println("Неверно указано Имя типа директории" + e);
            }
            stmt.execute();

        } catch (SQLException e) {
            System.err.println(INSERT_ERROR + getClass().getName());
        }

    }



}
