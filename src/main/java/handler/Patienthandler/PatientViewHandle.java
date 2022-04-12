package main.java.handler.Patienthandler;

import main.java.EMRView.MenuView;
import main.java.EMRView.Operation_Panel.PatientSonPanel.InfomationSonPanel;
import main.java.EMRView.Operation_Panel.PatientSonPanel.PatientEMRInfoPanel;
import main.java.EMRView.PatientView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatientViewHandle implements ActionListener {
    PatientView patientView;

    public PatientViewHandle(PatientView patientView) {
        this.patientView = patientView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        if ("返回页面".equals(text)) {
            patientView.dispose();
            new MenuView();


        } else if ("个人信息".equals(text)) {
            //patientView.dispose();
            new InfomationSonPanel(patientView, "个人信息中心", true, patientView.getPno());


        } else if ("病历信息".equals(text)) {
            patientView.dispose();
            new PatientEMRInfoPanel(patientView, "病历信息", true, patientView.getPno());

//            PatientSqlAction patientSqlAction = new PatientSqlAction();
//            Vector<Vector<Object>> data = new Vector<>();
//            String Pno = patientView.getPno();
//            data = patientSqlAction.search(Pno);
//                patientView.dispose();
//                //开始建表
//                JDialog jdlg = new JDialog(patientView, "病历信息", true);
//                jdlg.setLayout(new BorderLayout());
//                JButton printBtn = new JButton("打印表格信息");
//                printBtn.setFont(new Font("黑体",Font.PLAIN,20));
//
//                MainViewTable mainViewTable = new MainViewTable();
//                MainViewTableModel mainViewTableModel = MainViewTableModel.assembleModel(data);
//                mainViewTable.setModel(mainViewTableModel);
//                mainViewTable.renderRule();
//
//                jdlg.add(BorderLayout.SOUTH,printBtn);
//                jdlg.add(BorderLayout.NORTH,mainViewTable);
//
//
//                jdlg.add(new JScrollPane(mainViewTable));
//                //设置大小
//                jdlg.setSize(900, 600);
//                //设置居中
//                jdlg.setLocationRelativeTo(null);
//                //大小不可改变
//                jdlg.setResizable(false);
//                //关闭退出程序
//                //jdlg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                //设置可见
//                jdlg.setVisible(true);
//                if (!jdlg.isShowing()) {
//                    new PatientView(Pno);
//                }
        }
    }
}
