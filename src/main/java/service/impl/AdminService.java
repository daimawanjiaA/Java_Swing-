package main.java.service.impl;

import main.java.entity.AdminDO;
import main.java.util.DBUtil;

import java.sql.Connection;

public class AdminService implements main.java.service._AdminService {

    public static Connection connection;

    public boolean validateAdmin(AdminDO adminDo) {
        if (adminDo.getUsername().equals("admin") && adminDo.getPassward().equals("123456"))
            return true;
        else return false;
    }

    public void startservice() {
        DBUtil.setuser("EMRadmin");
        connection = DBUtil.getConn();
    }


}
