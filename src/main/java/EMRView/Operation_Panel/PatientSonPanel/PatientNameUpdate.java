package main.java.EMRView.Operation_Panel.PatientSonPanel;

import main.java.handler.Patienthandler.PatientNameUpdateHandler;

import javax.swing.*;
import java.awt.*;

public class PatientNameUpdate extends JDialog {
    public Boolean flag = false;
    String Pno;
    JLabel Pname = new JLabel("请输入新姓名: ");
    JButton submit = new JButton("确定");
    JButton reset = new JButton("重置");
    JTextField Pnamefield = new JTextField();

    JPanel jPanel1 = new JPanel();
    JPanel jPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 70, 20));
    Container container = getContentPane();

    PatientNameUpdateHandler nameUpdateHandler;

    public PatientNameUpdate(JDialog jDialog, String str, boolean bool, String Pno) {
        super(jDialog, str, bool);
        this.Pno = Pno;
        //设置监听器
        nameUpdateHandler = new PatientNameUpdateHandler(this);
        submit.addActionListener(nameUpdateHandler);
        reset.addActionListener(nameUpdateHandler);

        Font font = new Font("黑体", Font.BOLD, 20);
        Pname.setFont(font);
        Pnamefield.setFont(new Font("黑体", Font.PLAIN, 20));
        submit.setFont(font);
        reset.setFont(font);
        Pnamefield.setPreferredSize(new Dimension(100, 30));


        jPanel1.add(Pname);
        jPanel1.add(Pnamefield);
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

    public String getPno() {
        return Pno;
    }

    public JTextField getPnamefield() {
        return Pnamefield;
    }

    public void setPnamefield(JTextField pnamefield) {
        Pnamefield = pnamefield;
    }
}
