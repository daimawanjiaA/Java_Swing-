package main.java.SqlAction;

import main.java.entity.MrDO;
import main.java.service.impl.DoctorService;
import main.java.util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class DoctorSqlAction {

    String string;

    public Vector<Vector<Object>> getData() {
        Vector<Vector<Object>> data = new Vector<>();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = DoctorService.connection.createStatement();
            rs = st.executeQuery("select * from mrs order by Dno");
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

    public Vector<Vector<Object>> search(String str) {
        Vector<Vector<Object>> data = new Vector<>();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = DoctorService.connection.createStatement();
            rs = st.executeQuery("select * from mrs " +
                    "where disease like '%" + str + "%' order by Dno");
            if (!rs.next()) {
                rs = st.executeQuery("select * from mrs " +
                        "where MRno = " + str + " order by Dno");
            }
            rs.previous();
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

    public Boolean add(MrDO mrDO) {
        Boolean flag = true;
        DoctorService doctorService = new DoctorService();
        doctorService.startservice();
        PreparedStatement st = null;
        String sql = "insert into mrs" +
                "(MRno,Pno,Dno,disease,result,Treatment) values" +
                "(?,?,?,?,?,?)";
        try {
            st = doctorService.connection.prepareStatement(sql);
            st.setString(1, mrDO.getMRno());
            st.setString(2, mrDO.getPno());
            st.setString(3, mrDO.getDno());
            st.setString(4, mrDO.getDisease());
            st.setString(5, mrDO.getResult());
            st.setString(6, mrDO.getTreatment());

            st.executeUpdate();
        } catch (SQLException throwables) {
            flag = false;
            throwables.printStackTrace();

        } finally {
            DBUtil.closeSt(st);
        }
        return flag;
    }

    public Boolean updata(MrDO mrDO) {

        Boolean flag = true;
        DoctorService doctorService = new DoctorService();
        doctorService.startservice();
        PreparedStatement st = null;
        String sql = "update mrs set Pno=?,Dno=?,Disease=?,Result=?,Treatment=? where MRno = ?";
        try {
            st = doctorService.connection.prepareStatement(sql);
            st.setString(1, mrDO.getPno());
            st.setString(2, mrDO.getDno());
            st.setString(3, mrDO.getDisease());
            st.setString(4, mrDO.getResult());
            st.setString(5, mrDO.getTreatment());
            st.setString(6, mrDO.getMRno());

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
