package main.java.service.impl;

import main.java.entity.PatientDO;
import main.java.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientService {

    public static Connection connection;

    public boolean validatePatient(PatientDO patientDO) {

        String sql = "select pwd from Patients where Pno=?";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getConn();
            if (con == null) {
                return false;
            }
            ps = con.prepareStatement(sql);
            ps.setString(1, patientDO.getPno());
            rs = ps.executeQuery();
            while (rs.next()) {
                String pwd = rs.getString(1);
                if (patientDO.getPassword().equals(pwd)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeRs(rs);
            DBUtil.closePs(ps);
            DBUtil.closeConn(con);
        }
        return false;
    }

    public void startservice() {
        DBUtil.setuser("EMRpatient");
        connection = DBUtil.getConn();
    }

}
