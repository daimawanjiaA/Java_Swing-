package main.java.util;

import main.java.service.impl.AdminService;
import main.java.service.impl.DoctorService;
import main.java.service.impl.PatientService;

import java.sql.*;

public class DBUtil {


    private static final String URL = "jdbc:mysql://localhost:3306/emr?useSSL=false&serverTimezone=UTC";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String PWD = "123456";
    public static Connection connection;
    private static int kind;
    private static String USER_NAME = "root";

    static {
        try {
            //加载JDBC驱动 执行com.mysql.jdbc.Driver这个类里面的静态代码块
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public DBUtil() {
    }

    public static int getKind() {
        return kind;
    }

    public static void setKind(int kind) {
        DBUtil.kind = kind;
    }

    //获取数据库连接
    public static Connection getConn() {
        try {
            return DriverManager.getConnection(URL, USER_NAME, PWD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConn(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closePs(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeRs(ResultSet rs) {
        if (rs != null) {

            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public static void closeSt(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void setuser(String name) {
        USER_NAME = name;
    }

    public static void reset() {
        kind = 1;
        setuser("root");
        if (AdminService.connection != null) {
            closeConn(AdminService.connection);
        }
        if (DoctorService.connection != null) {
            closeConn(DoctorService.connection);
        }
        if (PatientService.connection != null) {
            closeConn(PatientService.connection);
        }

    }
}
