package main.java.SqlAction.AdminSqlService;

import main.java.entity.PatientDO;
import main.java.service.impl.AdminService;
import main.java.util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class PatientIfoAction {

    public static void main(String[] args) {
        new DoctorIfoAction();
    }

    public Vector<Vector<Object>> getData() {
        Vector<Vector<Object>> data = new Vector<>();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = AdminService.connection.createStatement();
            rs = st.executeQuery("select * from patients order by Pno");
            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                String Pno = rs.getString("Pno");
                String Pname = rs.getString("Pname");
                String Oname = rs.getString("Oname");
                String Time = rs.getString("Time");
                String pwd = rs.getString("pwd");
                row.addElement(Pno);
                row.addElement(Pname);
                row.addElement(Oname);
                row.addElement(Time);
                row.addElement(pwd);
                data.add(row);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.closeRs(rs);
            DBUtil.closeSt(st);
        }
        return data;
    }

    public Vector<Vector<Object>> search(String str) {
        Vector<Vector<Object>> data = new Vector<>();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = AdminService.connection.createStatement();
            rs = st.executeQuery("select * from patients " +
                    "where Pname like '%" + str + "%' order by Pno");
            if (!rs.next()) {
                rs = st.executeQuery("select * from patients " +
                        "where Pno = " + str + " order by Pno");
            }
            rs.previous();
            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                String Pno = rs.getString("Pno");
                String Pname = rs.getString("Pname");
                String Oname = rs.getString("Oname");
                String Time = rs.getString("Time");
                String pwd = rs.getString("pwd");
                row.addElement(Pno);
                row.addElement(Pname);
                row.addElement(Oname);
                row.addElement(Time);
                row.addElement(pwd);
                data.add(row);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.closeRs(rs);
            DBUtil.closeSt(st);
        }
        return data;
    }

    public Boolean add(PatientDO patientDO) {
        Boolean flag = true;
        AdminService adminService = new AdminService();
        PreparedStatement st = null;
        String sql = "insert into patients" +
                "(Pno,Pname,Oname,Time,pwd) values" +
                "(?,?,?,?,?)";
        try {
            st = adminService.connection.prepareStatement(sql);
            st.setString(1, patientDO.getPno());
            st.setString(2, patientDO.getPname());
            st.setString(3, patientDO.getOname());
            st.setString(4, patientDO.getTime());
            st.setString(5, patientDO.getPassword());

            st.executeUpdate();
        } catch (SQLException throwables) {
            flag = false;
            throwables.printStackTrace();

        } finally {
            DBUtil.closeSt(st);
        }
        return flag;
    }

    public Boolean delete(String str) {
        Boolean flag = true;
        AdminService adminService = new AdminService();
        PreparedStatement st = null;
        String sql = "delete from patients where Pno = ?";
        try {
            st = adminService.connection.prepareStatement(sql);
            st.setString(1, str);
            st.executeUpdate();
        } catch (SQLException throwables) {
            flag = false;
            throwables.printStackTrace();
        } finally {
            DBUtil.closeSt(st);
        }
        return flag;
    }

    public Boolean update(PatientDO patientDO) {

        Boolean flag = true;
        AdminService adminService = new AdminService();
        adminService.startservice();
        PreparedStatement st = null;
        String sql = "update patients set Pname=?,Oname=?,Time=?,pwd=? where Pno = ?";
        try {
            st = adminService.connection.prepareStatement(sql);
            st.setString(1, patientDO.getPno());
            st.setString(2, patientDO.getOname());
            st.setString(3, patientDO.getTime());
            st.setString(4, patientDO.getPassword());
            st.setString(5, patientDO.getPno());

            st.executeUpdate();
        } catch (SQLException throwables) {
            flag = false;
            throwables.printStackTrace();

        } finally {
            DBUtil.closeSt(st);
        }
        return flag;
    }
}