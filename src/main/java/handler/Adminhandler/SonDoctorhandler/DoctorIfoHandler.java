package main.java.handler.Adminhandler.SonDoctorhandler;

import main.java.EMRView.AdminView;
import main.java.EMRView.Operation_Panel.AdminSonPanel.SonDoctorInfoPanel.AdminDoctorAdd;
import main.java.EMRView.Operation_Panel.AdminSonPanel.SonDoctorInfoPanel.AdminDoctorDel;
import main.java.EMRView.Operation_Panel.AdminSonPanel.SonDoctorInfoPanel.AdminDoctorUpdate;
import main.java.EMRView.ext.AdminSonView.DoctorIfo;
import main.java.EMRView.ext.Table_mo.MTable;
import main.java.EMRView.ext.Table_mo.MTableModel;
import main.java.SqlAction.AdminSqlService.DoctorIfoAction;
import main.java.util.ExcelExporter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class DoctorIfoHandler implements ActionListener {
    DoctorIfo doctorIfo;

    public DoctorIfoHandler(DoctorIfo doctorIfo) {
        this.doctorIfo = doctorIfo;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        if ("返回".equals(text)) {
            new AdminView();
            doctorIfo.dispose();
        } else if ("增加".equals(text)) {
            AdminDoctorAdd adminDoctorAdd = new AdminDoctorAdd(doctorIfo, "添加新医生", true);
            if (adminDoctorAdd.flag) {
                doctorIfo.dispose();
                new DoctorIfo();
            }

        } else if ("修改".equals(text)) {
            AdminDoctorUpdate adminDoctorUpdate = new AdminDoctorUpdate(doctorIfo, "医生信息修改", true);
            if (adminDoctorUpdate.flag) {
                doctorIfo.dispose();
                new DoctorIfo();
            }

        } else if ("查询(姓名\\编号)".equals(text)) {
            String ser = doctorIfo.getSearchTxt().getText().trim();//trim取消多余空格
            if (ser.equals("")) {
                JOptionPane.showMessageDialog(doctorIfo, "请输入病历号！！");
            } else {
                Vector<Vector<Object>> data = new Vector<>();
                DoctorIfoAction doctorIfoAction = new DoctorIfoAction();
                data = doctorIfoAction.search(ser);
                if (data.size() != 0) {
                    doctorIfo.dispose();
                    //开始建表
                    JDialog jdlg = new JDialog(doctorIfo, "查询成功", true);


                    Vector<String> rowVector0 = new Vector<>();
                    rowVector0.addElement("医生编号");
                    rowVector0.addElement("医生姓名");
                    rowVector0.addElement("医生电话");
                    rowVector0.addElement("所属科室");
                    rowVector0.addElement("用户密码");


                    data = doctorIfoAction.search(ser);

                    MTableModel mTableModel = new MTableModel(rowVector0);
                    mTableModel = mTableModel.assembleModel(data);

                    MTable mTable = new MTable();
                    mTable.setModel(mTableModel);
                    mTable.renderRule(mTableModel);
                    JScrollPane jScrollPane = new JScrollPane(mTable);
                    jdlg.add(jScrollPane, BorderLayout.CENTER);


                    //设置大小
                    jdlg.setSize(900, 600);
                    //设置居中
                    jdlg.setLocationRelativeTo(null);
                    //大小不可改变
                    jdlg.setResizable(false);
                    //关闭退出程序
                    //jdlg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    //设置可见
                    jdlg.setVisible(true);
                    if (!jdlg.isShowing()) {
                        new DoctorIfo();
                    }
                } else {
                    JOptionPane.showMessageDialog(doctorIfo, "查询失败！！！");

                }
            }
        } else if ("删除".equals(text)) {
            AdminDoctorDel adminDoctorDel = new AdminDoctorDel(doctorIfo, "医生信息删除", true);
            if (adminDoctorDel.flag) {

                doctorIfo.dispose();
                new DoctorIfo();
            }

        } else if ("打印".equals(text)) {

            try {
                ExcelExporter exp = new ExcelExporter();
                exp.exportTable(doctorIfo.getmTable(), new File("DoctorsInformation.xls"));
            } catch (IOException ioException) {
                System.out.println("打印失败");
                ioException.printStackTrace();
            }
        } else if ("上一页".equals(text)) {


        } else if ("下一页".equals(text)) {


        }
    }

}
