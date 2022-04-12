package main.java.handler.Adminhandler.SonPatienthandler;

import main.java.EMRView.AdminView;
import main.java.EMRView.Operation_Panel.AdminSonPanel.SonPatientInfoPanel.AdminPatientAdd;
import main.java.EMRView.Operation_Panel.AdminSonPanel.SonPatientInfoPanel.AdminPatientDel;
import main.java.EMRView.Operation_Panel.AdminSonPanel.SonPatientInfoPanel.AdminPatientUpdate;
import main.java.EMRView.ext.AdminSonView.PatientIfo;
import main.java.EMRView.ext.Doctor.MainViewTable;
import main.java.EMRView.ext.Doctor.MainViewTableModel;
import main.java.EMRView.ext.Table_mo.MTable;
import main.java.EMRView.ext.Table_mo.MTableModel;
import main.java.SqlAction.AdminSqlService.PatientIfoAction;
import main.java.util.ExcelExporter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class PatientIfoHandler implements ActionListener {
    PatientIfo patientIfo;

    public PatientIfoHandler(PatientIfo patientIfo) {
        this.patientIfo = patientIfo;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        if ("返回".equals(text)) {
            new AdminView();
            patientIfo.dispose();
        } else if ("增加".equals(text)) {
            AdminPatientAdd adminPatientAdd = new AdminPatientAdd(patientIfo, "用户添加", true);
            if (adminPatientAdd.flag) {
                patientIfo.dispose();
                new PatientIfo();
            }

        } else if ("修改".equals(text)) {

            AdminPatientUpdate adminDoctorUpdate = new AdminPatientUpdate(patientIfo, "患者信息修改", true);
            if (adminDoctorUpdate.flag) {
                patientIfo.dispose();
                new PatientIfo();
            }


        } else if ("查询(患者姓名\\编号)".equals(text)) {
            String ser = patientIfo.getSearchTxt().getText().trim();//trim取消多余空格
            if (ser.equals("")) {
                JOptionPane.showMessageDialog(patientIfo, "请输入病历号！！");
            } else {
                Vector<Vector<Object>> data = new Vector<>();
                PatientIfoAction patientIfoAction = new PatientIfoAction();
                data = patientIfoAction.search(ser);
                if (data.size() != 0) {
                    patientIfo.dispose();
                    //开始建表
                    JDialog jdlg = new JDialog(patientIfo, "查询成功", true);
                    Vector<String> rowVector0 = new Vector<>();
                    rowVector0.addElement("患者编号");
                    rowVector0.addElement("患者姓名");
                    rowVector0.addElement("最近就诊科室");
                    rowVector0.addElement("最近诊察时间");
                    rowVector0.addElement("用户密码");


                    MTableModel mTableModel = new MTableModel(rowVector0);
                    mTableModel = mTableModel.assembleModel(data);

                    MTable mTable = new MTable();
                    mTable.setModel(mTableModel);
                    mTable.renderRule(mTableModel);
                    JScrollPane jScrollPane = new JScrollPane(mTable);
                    jdlg.add(jScrollPane, BorderLayout.CENTER);


                    MainViewTable mainViewTable = new MainViewTable();
                    MainViewTableModel mainViewTableModel = MainViewTableModel.assembleModel(data);
                    mainViewTable.setModel(mainViewTableModel);
                    mainViewTable.renderRule();

                    jdlg.add(new JScrollPane(mainViewTable));
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
                        new PatientIfo();
                    }
                } else {
                    JOptionPane.showMessageDialog(patientIfo, "查询失败！！！");
                }
            }

        } else if ("打印".equals(text)) {

            try {
                ExcelExporter exp = new ExcelExporter();
                exp.exportTable(patientIfo.getmTable(), new File("PatientsInformation.xls"));
            } catch (IOException ioException) {
                System.out.println("打印失败");
                ioException.printStackTrace();
            }
        } else if ("删除".equals(text)) {
            AdminPatientDel adminPatientDel = new AdminPatientDel(patientIfo, "患者信息删除", true);
            if (adminPatientDel.flag) {

                patientIfo.dispose();
                new PatientIfo();
            }

        } else if ("上一页".equals(text)) {


        } else if ("下一页".equals(text)) {


        }
    }

}