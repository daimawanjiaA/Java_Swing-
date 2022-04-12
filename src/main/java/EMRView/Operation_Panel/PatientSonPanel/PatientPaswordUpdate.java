package main.java.EMRView.Operation_Panel.PatientSonPanel;

import main.java.handler.Patienthandler.PatientPwdUpdateHandler;

import javax.swing.*;
import java.awt.*;

public class PatientPaswordUpdate extends JDialog {
    public Boolean flag = false;
    JLabel Pwd = new JLabel("请输入新密码: ");
    JButton submit = new JButton("确定");
    JButton reset = new JButton("重置");
    JTextField Pwdfield = new JTextField();
    JPanel jPanel1 = new JPanel();
    JPanel jPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 70, 20));
    Container container = getContentPane();
    PatientPwdUpdateHandler patientPwdUpdateHandler;
    private String Pno;

    public PatientPaswordUpdate(JDialog jDialog, String str, boolean bool, String pno) {
        super(jDialog, str, bool);
        this.Pno = pno;
        //设置监听器
        patientPwdUpdateHandler = new PatientPwdUpdateHandler(this);
        submit.addActionListener(patientPwdUpdateHandler);
        reset.addActionListener(patientPwdUpdateHandler);

        Font font = new Font("黑体", Font.BOLD, 20);
        Pwd.setFont(font);
        Pwdfield.setFont(new Font("黑体", Font.PLAIN, 20));
        submit.setFont(font);
        reset.setFont(font);
        Pwdfield.setPreferredSize(new Dimension(100, 30));


        jPanel1.add(Pwd);
        jPanel1.add(Pwdfield);
        jPanel2.add(submit);
        jPanel2.add(reset);
        submit.setLocation(200, 80);
        container.add(jPanel1, BorderLayout.NORTH);
        container.add(jPanel2, BorderLayout.SOUTH);
        //设置大小
        setSize(300, 150);
        //设置居中
        setLocationRelativeTo(null);
        //大小不可改变
        setResizable(false);
        //关闭退出程序
        //jdlg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置可见
        setVisible(true);
    }

    public JTextField getPwdfield() {
        return Pwdfield;
    }

    public String getPno() {
        return Pno;
    }
}
