package main.java.handler.Adminhandler.SonEMRhandler;

import main.java.EMRView.AdminView;
import main.java.EMRView.Operation_Panel.AdminSonPanel.SonEmrInfoPanel.AdminEmrAdd;
import main.java.EMRView.Operation_Panel.AdminSonPanel.SonEmrInfoPanel.AdminEmrDel;
import main.java.EMRView.Operation_Panel.AdminSonPanel.SonEmrInfoPanel.AdminEmrUpdate;
import main.java.EMRView.ext.AdminSonView.EmrIfo;
import main.java.EMRView.ext.Doctor.MainViewTable;
import main.java.EMRView.ext.Doctor.MainViewTableModel;
import main.java.SqlAction.AdminSqlService.EMRIfoAction;
import main.java.util.ExcelExporter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class EMRIfoHandler implements ActionListener {
    EmrIfo emrIfo;

    public EMRIfoHandler(EmrIfo emrIfo) {
        this.emrIfo = emrIfo;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        if ("返回".equals(text)) {
            new AdminView();
            emrIfo.dispose();
        } else if ("增加".equals(text)) {

            AdminEmrAdd adminEmrAdd = new AdminEmrAdd(emrIfo, "病历添加", true);
            if (adminEmrAdd.flag) {
                emrIfo.dispose();
                new EmrIfo();
            }

        } else if ("修改".equals(text)) {

            AdminEmrUpdate adminEmrUpdate = new AdminEmrUpdate(emrIfo, "病历更新", true);
            if (adminEmrUpdate.flag) {
                emrIfo.dispose();
                new EmrIfo();
            }

        } else if ("查询(疾病\\病历号))".equals(text)) {
            String ser = emrIfo.getSearchTxt().getText().trim();//trim取消多余空格
            if (ser.equals("")) {
                JOptionPane.showMessageDialog(emrIfo, "请输入病历号！！");
            } else {
                Vector<Vector<Object>> data = new Vector<>();
                EMRIfoAction emrIfoAction = new EMRIfoAction();
                data = emrIfoAction.search(ser);
                if (data.size() != 0) {
                    emrIfo.dispose();
                    //开始建表
                    JDialog jdlg = new JDialog(emrIfo, "查询成功", true);
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
                        new EmrIfo();
                    }
                } else {
                    JOptionPane.showMessageDialog(emrIfo, "查询失败！！！");
                }
            }
        } else if ("打印".equals(text)) {

            try {
                ExcelExporter exp = new ExcelExporter();
                exp.exportTable(emrIfo.getmTable(), new File("EMRInformation.xls"));
            } catch (IOException ioException) {
                System.out.println("打印失败");
                ioException.printStackTrace();
            }
        } else if ("删除".equals(text)) {
            AdminEmrDel adminEmrDel = new AdminEmrDel(emrIfo, "病历信息删除", true);
            if (adminEmrDel.flag) {

                emrIfo.dispose();
                new EmrIfo();
            }

        } else if ("上一页".equals(text)) {


        } else if ("下一页".equals(text)) {


        }
    }

}