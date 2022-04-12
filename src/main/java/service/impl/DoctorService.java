package main.java.service.impl;

import main.java.entity.DoctorDO;
import main.java.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorService implements main.java.service._DoctorService {

    public static Connection connection;

    public boolean validateDoctor(DoctorDO doctorDO) {

        String sql = "select pwd from doctors where Dno=?";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getConn();
            if (con == null) {
                return false;
            }
            ps = con.prepareStatement(sql);
            ps.setString(1, doctorDO.getDno());
            rs = ps.executeQuery();
            while (rs.next()) {
                String pwd = rs.getString(1);
                if (doctorDO.getPassword().equals(pwd)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeRs(rs);
            DBUtil.closePs(ps);
        }
        return false;
    }

    public void startservice() {
        DBUtil.setuser("EMRdoctor");
        connection = DBUtil.getConn();
    }

    public void retrieveDoctors() {
    }


}
