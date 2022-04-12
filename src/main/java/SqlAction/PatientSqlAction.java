package main.java.SqlAction;

import main.java.service.impl.PatientService;
import main.java.util.DBUtil;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class PatientSqlAction {
    String string;

    public Vector<Vector<Object>> search(String str) {
        Vector<Vector<Object>> data = new Vector<>();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = PatientService.connection.createStatement();

            rs = st.executeQuery("select * from mrs " +
                    "where Pno = " + str + " order by Pno");
            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                String MRno = rs.getString("MRno");
                String Pno = rs.getString("Pno");
                String Dno = rs.getString("Dno");
                String disease = rs.getString("disease");
                String result = rs.getString("result");
                String Treatment = rs.getString("Treatment");
                row.add(MRno);
                row.add(Pno);
                row.add(Dno);
                row.add(disease);
                row.add(result);
                row.add(Treatment);
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

    public Vector<String> getData(String ser) {

        Vector<String> data = new Vector<>();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = PatientService.connection.createStatement();
            rs = st.executeQuery("select * from patients " +
                    "where Pno = " + ser + " order by Pno");
            if (rs.next()) {
                String Pno = rs.getString("Pno");
                String Pname = rs.getString("Pname");
                String Oname = rs.getString("Oname");
                String Time = rs.getString("Time");
                data.addElement(Pno);
                data.addElement(Pname);
                data.addElement(Oname);
                data.addElement(Time);
            } else {
                JOptionPane.showMessageDialog(null, "无此用户");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.closeRs(rs);
            DBUtil.closeSt(st);
        }
        return data;
    }

    public Boolean UpdatePname(String pno, String pname) {
        Boolean flag = true;
        PreparedStatement st = null;
        String sql = "update patients set Pname = ? where Pno = ?";

        try {
            st = PatientService.connection.prepareStatement(sql);
            st.setString(1, pname);
            st.setString(2, pno);
            st.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            flag = false;
        }
        return flag;
    }

    public Boolean UpdatePwd(String pno, String Pwd) {
        Boolean flag = true;
        PreparedStatement st = null;
        String sql = "update patients set pwd = ? where Pno = ?";

        try {
            st = PatientService.connection.prepareStatement(sql);
            st.setString(1, Pwd);
            st.setString(2, pno);
            st.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            flag = false;
        }


        return flag;
    }
}
