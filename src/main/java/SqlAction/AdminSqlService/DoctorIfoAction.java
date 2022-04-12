package main.java.SqlAction.AdminSqlService;

import main.java.entity.DoctorDO;
import main.java.service.impl.AdminService;
import main.java.util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class DoctorIfoAction {

    public static void main(String[] args) {
        new DoctorIfoAction();
    }

    public Vector<Vector<Object>> getData() {
        Vector<Vector<Object>> data = new Vector<>();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = AdminService.connection.createStatement();
            rs = st.executeQuery("select * from doctors order by Dno");
            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                String Dno = rs.getString("Dno");
                String Dname = rs.getString("Dname");
                String Dphone = rs.getString("Dphone");
                String Oname = rs.getString("Oname");
                String pwd = rs.getString("pwd");
                row.addElement(Dno);
                row.addElement(Dname);
                row.addElement(Dphone);
                row.addElement(Oname);
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
            rs = st.executeQuery("select * from doctors " +
                    "where Dname like '%" + str + "%' order by Dno");
            if (!rs.next()) {
                rs = st.executeQuery("select * from doctors " +
                        "where Dno = " + str + " order by Dno");
            }
            rs.previous();
            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                String Dno = rs.getString("Dno");
                String Dname = rs.getString("Dname");
                String Dphone = rs.getString("Dphone");
                String Oname = rs.getString("Oname");
                String pwd = rs.getString("pwd");
                row.addElement(Dno);
                row.addElement(Dname);
                row.addElement(Dphone);
                row.addElement(Oname);
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

    public Boolean search(DoctorDO doctorDO) {
        Boolean flag = true;

        return flag;
    }

    public Boolean add(DoctorDO doctorDO) {
        Boolean flag = true;
        AdminService adminService = new AdminService();
        adminService.startservice();
        PreparedStatement st = null;
        String sql = "insert into doctors" +
                "(Dno,Dname,Dphone,Oname,pwd) values" +
                "(?,?,?,?,?)";
        try {
            st = adminService.connection.prepareStatement(sql);
            st.setString(1, doctorDO.getDno());
            st.setString(2, doctorDO.getDname());
            st.setString(3, doctorDO.getDphone());
            st.setString(4, doctorDO.getOname());
            st.setString(5, doctorDO.getPassword());


            st.executeUpdate();
        } catch (SQLException throwables) {
            flag = false;
            throwables.printStackTrace();

        } finally {
            DBUtil.closeSt(st);
        }
        return flag;
    }

    public Boolean update(DoctorDO doctorDO) {
        Boolean flag = true;
        AdminService adminService = new AdminService();
        adminService.startservice();
        PreparedStatement st = null;
        String sql = "update doctors set Dname=?,Dphone=?,Oname=?,pwd=? where Dno = ?";
        try {
            st = adminService.connection.prepareStatement(sql);
            st.setString(1, doctorDO.getDname());
            st.setString(2, doctorDO.getDphone());
            st.setString(3, doctorDO.getOname());
            st.setString(4, doctorDO.getPassword());
            st.setString(5, doctorDO.getDno());
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
        adminService.startservice();
        PreparedStatement st = null;
        String sql = "delete from doctors where Dno = ?";
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
}