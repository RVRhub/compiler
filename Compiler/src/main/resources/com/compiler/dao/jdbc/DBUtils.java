//package com.compiler.dao.jdbc;
//
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.Locale;
//
//public class DBUtils {
//    private static final String JNDI_NAME = "java:comp/env/jdbc/AccountsDS";
//
//    private static DataSource dataSource;
//
//    /**
//     * Initialization of data source.
//     */
//    static {
//        try {
//            Locale.setDefault(Locale.ENGLISH);
//            InitialContext context = new InitialContext();
//            dataSource = (DataSource) context.lookup(JNDI_NAME);
//        } catch (NamingException e) {
//            System.out.println("DataSource not found.");
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * Returns connection to DB from connection pool.
//     *
//     * @return Connection to DB from connection pool.
//     */
//    public static Connection getConnection() {
//        Connection connection = null;
//
//        if (dataSource != null) {
//            try {
//                connection = dataSource.getConnection();
//            } catch (SQLException e) {
//                System.out.println("Error while receiving connection from connection pool.");
//                e.printStackTrace();
//            }
//        }
//
//        return connection;
//    }
//
//    /**
//     * Closes resultset.
//     *
//     * @param resultSet - {@link java.sql.ResultSet}
//     */
//    public static void closeResultSet(ResultSet resultSet) {
//        if (resultSet != null) {
//            try {
//                resultSet.close();
//            } catch (SQLException e) {
//                System.out.println("Error while closing resultset.");
//                e.printStackTrace();
//            }
//        }
//    }
//
//    /**
//     * Closes statement.
//     *
//     * @param statement - {@link java.sql.Statement}
//     */
//    public static void closeStatement(Statement statement) {
//        if (statement != null) {
//            try {
//                statement.close();
//            } catch (SQLException e) {
//                System.out.println("Error while closing statement.");
//                e.printStackTrace();
//            }
//        }
//    }
//
//    /**
//     * Closes connection.
//     *
//     * @param connection - {@link java.sql.Connection}
//     */
//    public static void closeConnection(Connection connection) {
//        if (connection != null) {
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                System.out.println("Error while closing connection.");
//                e.printStackTrace();
//            }
//        }
//    }
//}
