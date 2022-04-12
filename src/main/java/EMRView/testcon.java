package main.java.EMRView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class testcon {
    private static final String URL = "jdbc:mysql://localhost:3306/emr?useSSL=false&serverTimezone=UTC";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String PWD = "123456";
    private static String USER_NAME = "EMRadmin";

    static {
        try {
            //加载JDBC驱动 执行com.mysql.jdbc.Driver这个类里面的静态代码块
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection(URL, USER_NAME, PWD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
