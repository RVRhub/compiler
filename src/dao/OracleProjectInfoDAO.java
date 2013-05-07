package dao;

import entity.GenericProjectInfo;
import Error.ErrorConstants;
import Exception.InputException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class OracleProjectInfoDAO implements ProjectDAO,ErrorConstants {
    private Management management = null;
    private Connection conn = null;

    public OracleProjectInfoDAO() {
        management = Management.getInstance();
        conn = management.getConnection();
    }

    public List<GenericProjectInfo> getProject()  {
        List<GenericProjectInfo> projects = new ArrayList<GenericProjectInfo>();

        Statement stmn = null;
        ResultSet rs = null;

        try {
            stmn = conn.createStatement();
            rs = stmn.executeQuery("SELECT project_id, user_id, proglang, langplatform, projname " +
                    "projtype, projcategory FROM GenericProjectInfo G JOIN ProjectDetails P ON G.project_id = P.project_id");
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
        try {
            stmt = conn.prepareStatement("INSERT ALL" +
                    "INTO GenericProjectInfo (project_id, user_id, proglang, langplatform) VALUES (projectid_seq.nextval, ?,?,?)" + //значение user_id???
                    "INTO ProjectDetails (project_id, projname, projtype, projcategory) VALUES (projectid_seq.currval,?,?,?)" +
                    "SELECT * FROM dual");
            try {
                if (projects.getProject_id() <= 0) {
                    stmt.setInt(1, projects.getProject_id());
                } else {
                    throw new InputException();
                }
            } catch (InputException e) {
                System.out.println("Неверно указано ID проекта" + e);
            }
            try {
                if (projects.getProglang() != null) {
                    stmt.setString(2, projects.getProglang());
                } else {
                    throw new InputException();
                }
            } catch (InputException e) {
                System.out.println("Неверно указан Язык проекта" + e);
            }
            try {
                if (projects.getLangplatform() != null) {
                    stmt.setString(3, projects.getLangplatform());
                } else {
                    throw new InputException();
                }
            } catch (InputException e) {
                System.out.println("Неверно указано Платформа языка проекта" + e);
            }
            try {
                if (projects.getProjname() != null) {
                    stmt.setString(4, projects.getProjname());
                } else {
                    throw new InputException();
                }
            } catch (InputException e) {
                System.out.println("Неверно указано Имя проекта" + e);
            }
            try {
                if (projects.getProjtype() != null) {
                    stmt.setString(5, projects.getProjtype());
                } else {
                    throw new InputException();
                }
            } catch (InputException e) {
                System.out.println("Неверно указан Тип проекта" + e);
            }
            try {
                if (projects.getProjcategory() != null) {
                    stmt.setString(6, projects.getProjcategory());
                } else {
                    throw new InputException();
                }
            } catch (InputException e) {
                System.out.println("Неверно указано Категория проекта" + e);
            }
            stmt.execute();

        } catch (SQLException e) {
            System.err.println(INSERT_ERROR + getClass().getName());

        }

    }

    public void deleteProject(GenericProjectInfo projects)  {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("DELETE FROM GenericProjectInfo WHERE project_id=?");
            if (projects.getProject_id() <= 0) {
                stmt.setInt(1, projects.getProject_id());
            } else {
                throw new InputException();
            }
            stmt.execute();

        } catch (InputException e) {

            System.out.println("Неверно указан ID проекта" + e);      //

        } catch (SQLException e) {
            System.err.println(INSERT_ERROR + getClass().getName());

        }

    }

    public void updateGenericProjectInfo(GenericProjectInfo projects)  {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("UPDATE GenericProjectInfo SET" +
                    "(user_id=?, proglang=?, langplatform=?)" + "WHERE project_id=?");
            try {
                if (projects.getProglang() != null) {
                    stmt.setString(1, projects.getProglang());
                } else {
                    throw new InputException();
                }
            } catch (InputException e) {
                System.out.println("Неверно указан Язык проекта" + e);
            }
            try {
                if (projects.getLangplatform() != null) {
                    stmt.setString(2, projects.getLangplatform());
                } else {
                    throw new InputException();
                }
            } catch (InputException e) {
                System.out.println("Неверно указано Платформа языка проекта" + e);
            }

        } catch (SQLException e) {
            System.err.println(INSERT_ERROR + getClass().getName());

        }

    }

    public void updateProjectDetails (GenericProjectInfo projects){
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("UPDATE ProjectDetails SET" +
                    "(user_id=?, progname=?, projtype=?, projcategory=?)" + "WHERE project_id=?");
            try {
                if (projects.getProjname() != null) {
                    stmt.setString(1, projects.getProjname());
                } else {
                    throw new InputException();
                }
            } catch (InputException e) {
                System.out.println("Неверно указано Имя проекта" + e);
            }
            try {
                if (projects.getProjtype() != null) {
                    stmt.setString(2, projects.getProjtype());
                } else {
                    throw new InputException();
                }
            } catch (InputException e) {
                System.out.println("Неверно указан Тип проекта" + e);
            }
            try {
                if (projects.getProjcategory() != null) {
                    stmt.setString(2, projects.getProjcategory());
                } else {
                    throw new InputException();
                }
            } catch (InputException e) {
                System.out.println("Неверно указана Категория проекта" + e);
            }

        } catch (SQLException e) {
            System.err.println(INSERT_ERROR + getClass().getName());

        }


    }


}
