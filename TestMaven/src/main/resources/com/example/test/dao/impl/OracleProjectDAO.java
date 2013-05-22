package com.example.test.dao.impl;

import com.example.test.dao.DBUtils;
import com.example.test.dao.ProjectDAO;
import com.example.test.entity.GenericProjectInfo;
import com.example.test.error.ErrorConstants;
import com.example.test.exception.InputException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class OracleProjectDAO implements ProjectDAO, ErrorConstants{

    public List<GenericProjectInfo> getProject()  {
        List<GenericProjectInfo> projects = new ArrayList<GenericProjectInfo>();
        Connection conn = null;
        Statement stmn = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            stmn = conn.createStatement();
            rs = stmn.executeQuery("SELECT project_id, user_id, proglang, langplatform, projname, projtype, projcategory" +
                    " FROM GenericProjectInfo G JOIN ProjectDetails P ON G.project_id = P.project_id");
            while (rs.next()) {
                GenericProjectInfo proj = new GenericProjectInfo();
                proj.setProject_id(rs.getInt(1));
                proj.setProjname(rs.getString(2));
                proj.setProglang(rs.getString(3));
                proj.setLangplatform(rs.getString(4));
                proj.setProjtype(rs.getString(5));
                proj.setProjcategory(rs.getString(6));

                projects.add(proj);

            }
        }  catch (SQLException e) {
            System.err.println(INSERT_ERROR + getClass().getName());

        }
        return projects;
    }

    public void insertProject(GenericProjectInfo projects)  {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement("INSERT ALL " +
                    "INTO GenericProjectInfo (project_id, user_id, proglang, langplatform) VALUES (projectid_seq.nextval, ?,?,?)" + //�������� user_id???
                    "INTO ProjectDetails (project_id, projname, projtype, projcategory) VALUES (projectid_seq.currval,?,?,?)" +
                    "SELECT * FROM dual");
            //   stmt.setInt(1, projects.);   user_id?????????????
            stmt.setString(2, projects.getProglang());
            stmt.setString(3, projects.getLangplatform());
            stmt.setString(4, projects.getProjname());
            stmt.setString(5, projects.getProjtype());
            stmt.setString(6, projects.getProjcategory());
            stmt.execute();
//            try {
//                if (projects.getProject_id() <= 0) {
//
//                } else {
//                    throw new com.example.test.exception.InputException();
//                }
//            } catch (com.example.test.exception.InputException e) {
//                System.out.println("������� ������� ID �������" + e);
//            }
//

        } catch (SQLException e) {
            System.err.println(INSERT_ERROR + getClass().getName());

        }

    }

    public void deleteProject(GenericProjectInfo projects)  {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement("DELETE FROM GenericProjectInfo WHERE project_id=?");
            if (projects.getProject_id() <= 0) {
                stmt.setInt(1, projects.getProject_id());
            } else {
                throw new InputException();
            }
            stmt.execute();

        } catch (InputException e) {

            System.out.println("������� ������ ID �������" + e);      //

        } catch (SQLException e) {
            System.err.println(INSERT_ERROR + getClass().getName());

        }

    }

    public void updateGenericProjectInfo(GenericProjectInfo projects)  {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement("UPDATE GenericProjectInfo SET proglang=?, langplatform=? WHERE project_id=?");
            stmt.setString(1, projects.getProglang());
            stmt.setString(2, projects.getLangplatform());
            stmt.execute();
//            try {
//                if (projects.getProglang() != null) {
//
//                } else {
//                    throw new com.example.test.exception.InputException();
//                }
//            } catch (com.example.test.exception.InputException e) {
//                System.out.println("������� ������ ���� �������" + e);
//            }

        } catch (SQLException e) {
            System.err.println(INSERT_ERROR + getClass().getName());

        }

    }

    public void updateProjectDetails (GenericProjectInfo projects){
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement("UPDATE ProjectDetails SET progname=?, projtype=?, projcategory=?" +
                    " WHERE project_id=?");
            stmt.setString(1, projects.getProjname());
            stmt.setString(2, projects.getProjtype());
            stmt.setString(3, projects.getProjcategory());
            stmt.execute();
//            try {
//                if (projects.getProjname() != null) {
//
//                } else {
//                    throw new com.example.test.exception.InputException();
//                }
//            } catch (com.example.test.exception.InputException e) {
//                System.out.println("������� ������� ��� �������" + e);
//            }

        } catch (SQLException e) {
            System.err.println(INSERT_ERROR + getClass().getName());

        }


    }

//    public boolean isGenericParams(com.example.test.entity.GenericProjectInfo users) {
//        return users.getFname() != null && users.getEmail() != null && users.getPass() != null;
//    }


}
