package main.java.handler.Doctorhandler;

import main.java.EMRView.MainView;
import main.java.EMRView.MenuView;
import main.java.EMRView.Operation_Panel.DoctorSonPanel.DoctorEMRAdd;
import main.java.EMRView.Operation_Panel.DoctorSonPanel.DoctorEMRUpdate;
import main.java.EMRView.ext.Doctor.MainViewTable;
import main.java.EMRView.ext.Doctor.MainViewTableModel;
import main.java.SqlAction.DoctorSqlAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class MainViewHandler implements ActionListener {


    private MainView mainView;

    public MainViewHandler(MainView mainView) {
        this.mainView = mainView;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        if ("返回".equals(text)) {
            new MenuView();
            mainView.dispose();
        } else if ("增加".equals(text)) {

            DoctorEMRAdd doctorEmrAdd = new DoctorEMRAdd(mainView, "填写病历信息", true);
            if (doctorEmrAdd.flag) {
                mainView.dispose();
                new MainView();
            }

        } else if ("修改".equals(text)) {

            DoctorEMRUpdate doctorEmrUpdate = new DoctorEMRUpdate(mainView, "修改病历信息", true);
            if (doctorEmrUpdate.flag) {
                mainView.dispose();
                new MainView();
            }


        } else if ("查询(病历号\\疾病)".equals(text)) {

            String ser = mainView.getSearchTxt().getText().trim();//trim取消多余空格
            if (ser.equals("")) {
                JOptionPane.showMessageDialog(mainView, "请输入病历号！！");
            } else {
                Vector<Vector<Object>> data = new Vector<>();
                DoctorSqlAction doctorSqlAction = new DoctorSqlAction();
                data = doctorSqlAction.search(ser);
                if (data.size() != 0) {
                    mainView.dispose();
                    //开始建表
                    JDialog jdlg = new JDialog(mainView, "查询成功", true);
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
                        new MainView();
                    }
                } else {
                    JOptionPane.showMessageDialog(mainView, "查询失败！！！");
                }

            }
        } else if ("删除".equals(text)) {


        } else if ("上一页".equals(text)) {


        } else if ("下一页".equals(text)) {


        }
    }
}
