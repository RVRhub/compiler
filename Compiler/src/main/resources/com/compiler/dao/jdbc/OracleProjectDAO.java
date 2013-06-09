//package com.compiler.dao.jdbc;
//
//import com.compiler.dao.ProjectDAO;
//import com.compiler.entity.GenericProjectInfo;
//import com.compiler.error.ErrorConstants;
//import com.compiler.error.handler.exception.InputException;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class OracleProjectDAO implements ProjectDAO, ErrorConstants{
//
//    public List<GenericProjectInfo> getProject()  {
//        List<GenericProjectInfo> projects = new ArrayList<GenericProjectInfo>();
//        Connection conn = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//
//        try {
//            conn = DBUtils.getConnection();
//            stmt = conn.createStatement();
//            rs = stmt.executeQuery("SELECT G.project_id, G.user_id, G.proglang, G.langplatform, P.projname, P.projtype, P.projcategory" +
//                    " FROM GenericProjectInfo G JOIN ProjectDetails P ON G.project_id = P.project_id");
//            while (rs.next()) {
//                GenericProjectInfo proj = new GenericProjectInfo();
//                proj.setProject_id(rs.getInt(1));
//                proj.setUser_id(rs.getInt(2));
//                proj.setProglang(rs.getString(3));
//                proj.setLangplatform(rs.getString(4));
//                proj.setProjname(rs.getString(5));
//                proj.setProjtype(rs.getString(6));
//                proj.setProjcategory(rs.getString(7));
//
//                projects.add(proj);
//
//            }
//        }  catch (SQLException e) {
//            System.err.println(SELECT_ERROR + getClass().getName());
//
//        }finally {
//            DBUtils.closeResultSet(rs);
//            DBUtils.closeStatement(stmt);
//            DBUtils.closeConnection(conn);
//        }
//        return projects;
//    }
//
//    public void insertProject(GenericProjectInfo projects)  {
//        PreparedStatement stmt = null;
//        Connection conn = null;
//        try {
//            conn = DBUtils.getConnection();
//            stmt = conn.prepareStatement("INSERT ALL " +
//                    "INTO GenericProjectInfo (project_id, user_id, proglang, langplatform) VALUES (projectid_seq.nextval, ?,?,?)" + //�������� user_id???
//                    "INTO ProjectDetails (project_id, projname, projtype, projcategory) VALUES (projectid_seq.currval,?,?,?)" +
//                    "SELECT * FROM dual");
//            try {
//                //TODO incorect fields
//                if (projects.getProjname() !=null) {
//                    stmt.setInt(1, projects.getUser_id());
//                    stmt.setString(2, projects.getProglang());
//                    stmt.setString(3, projects.getLangplatform());
//                    stmt.setString(4, projects.getProjname());
//                    stmt.setString(5, projects.getProjtype());
//                    stmt.setString(6, projects.getProjcategory());
//                    stmt.execute();
//                } else {
//                    throw new InputException();
//                }
//            } catch (InputException e) {
//                System.out.println("Введите правильное имя проекта" + e);
//            }
//        } catch (SQLException e) {
//            System.err.println(INSERT_ERROR + getClass().getName());
//        }finally {
//            DBUtils.closeStatement(stmt);
//            DBUtils.closeConnection(conn);
//        }
//    }
//
//    public void deleteProject(GenericProjectInfo projects)  {
//        PreparedStatement stmt = null;
//        Connection conn = null;
//        try {
//            conn = DBUtils.getConnection();
//            stmt = conn.prepareStatement("DELETE FROM GenericProjectInfo WHERE project_id=?");
//            if (projects.getProject_id() <= 0) {
//                stmt.setInt(1, projects.getProject_id());
//                stmt.execute();
//            } else {
//                throw new InputException();
//            }
//        } catch (InputException e) {
//            System.out.println("Введите правильный ID проекта" + e);      //
//        } catch (SQLException e) {
//            System.err.println(DELETE_ERROR + getClass().getName());
//        }finally {
//            DBUtils.closeStatement(stmt);
//            DBUtils.closeConnection(conn);
//        }
//    }
//
//    public void updateGenericProjectInfo(GenericProjectInfo projects)  {
//        PreparedStatement stmt = null;
//        Connection conn = null;
//        try {
//            conn = DBUtils.getConnection();
//            stmt = conn.prepareStatement("UPDATE GenericProjectInfo SET proglang=?, langplatform=? WHERE project_id=?");
//           try {
//               if (projects.getProglang() != null && projects.getLangplatform()!=null && projects.getProject_id()<=0) {
//                   stmt.setString(1, projects.getProglang());
//                   stmt.setString(2, projects.getLangplatform());
//                   stmt.execute();
//                } else {
//                    throw new InputException();
//                }
//            } catch (InputException e) {
//                System.out.println("Введите коректные данные проекта" + e);            }
//        } catch (SQLException e) {
//            System.err.println(UPDATE_ERROR + getClass().getName());
//        }finally {
//            DBUtils.closeStatement(stmt);
//            DBUtils.closeConnection(conn);
//        }
//    }
//
//    public void updateProjectDetails (GenericProjectInfo projects){
//        PreparedStatement stmt = null;
//        Connection conn = null;
//        try {
//            conn = DBUtils.getConnection();
//            stmt = conn.prepareStatement("UPDATE ProjectDetails SET progname=?, projtype=?, projcategory=?" +
//                    " WHERE project_id=?");
//            try {
//                if (projects.getProjname() != null) {
//                    stmt.setString(1, projects.getProjname());
//                    stmt.setString(2, projects.getProjtype());
//                    stmt.setString(3, projects.getProjcategory());
//                    stmt.execute();
//                } else {
//                    throw new InputException();
//                }
//            } catch (InputException e) {
//                System.out.println("Введите праильное имя проекта" + e);
//            }
//        } catch (SQLException e) {
//            System.err.println(UPDATE_ERROR + getClass().getName());
//        }finally {
//            DBUtils.closeStatement(stmt);
//            DBUtils.closeConnection(conn);
//        }
//    }
//
//}
