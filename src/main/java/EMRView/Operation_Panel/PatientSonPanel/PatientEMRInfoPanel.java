package main.java.EMRView.Operation_Panel.PatientSonPanel;

import main.java.EMRView.PatientView;
import main.java.EMRView.ext.Doctor.MainViewTable;
import main.java.EMRView.ext.Doctor.MainViewTableModel;
import main.java.SqlAction.PatientSqlAction;
import main.java.handler.Patienthandler.PatientEMRIfoHandler;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class PatientEMRInfoPanel extends JDialog {


    MainViewTable mainViewTable;
    JButton printBtn = printBtn = new JButton("打印表格信息");
    String Pno;
    PatientEMRIfoHandler ifoHandler;

    public PatientEMRInfoPanel(JFrame jFrame, String str, Boolean bool, String pno) {
        super(jFrame, str, bool);
        Pno = pno;
        PatientSqlAction patientSqlAction = new PatientSqlAction();
        Vector<Vector<Object>> data = new Vector<>();
        data = patientSqlAction.search(Pno);

        //加入监听器
        ifoHandler = new PatientEMRIfoHandler(this);
        printBtn.addActionListener(ifoHandler);
        //开始建表
        setLayout(new BorderLayout());

        printBtn.setFont(new Font("黑体", Font.PLAIN, 20));

        mainViewTable = new MainViewTable();
        MainViewTableModel mainViewTableModel = MainViewTableModel.assembleModel(data);
        mainViewTable.setModel(mainViewTableModel);
        mainViewTable.renderRule();

        add(BorderLayout.SOUTH, printBtn);
        add(BorderLayout.NORTH, mainViewTable);


        add(new JScrollPane(mainViewTable));
        //设置大小
        setSize(900, 600);
        //设置居中
        setLocationRelativeTo(null);
        //大小不可改变
        setResizable(false);
        //关闭退出程序
        //jdlg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置可见
        this.setVisible(true);
        if (!isShowing()) {
            new PatientView(Pno);
        }
    }

    public MainViewTable getMainViewTable() {
        return mainViewTable;
    }

    public String getPno() {
        return Pno;
    }
}
