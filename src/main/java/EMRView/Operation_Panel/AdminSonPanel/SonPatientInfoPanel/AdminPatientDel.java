package main.java.EMRView.Operation_Panel.AdminSonPanel.SonPatientInfoPanel;

import main.java.handler.Adminhandler.SonPatienthandler.SonPatientDeleteHandler;

import javax.swing.*;
import java.awt.*;

public class AdminPatientDel extends JDialog {

    public Boolean flag = false;
    JLabel Dno = new JLabel("请输入患者编号: ");
    JButton submit = new JButton("确定");
    JButton reset = new JButton("重置");
    JTextField Dnofield = new JTextField();

    JPanel jPanel1 = new JPanel();
    JPanel jPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 70, 20));
    Container container = getContentPane();

    SonPatientDeleteHandler deleteHandler;

    public AdminPatientDel(JFrame jfram, String str, boolean bool) {
        super(jfram, str, bool);
        //设置监听器
        deleteHandler = new SonPatientDeleteHandler(this);
        submit.addActionListener(deleteHandler);
        reset.addActionListener(deleteHandler);

        Font font = new Font("黑体", Font.BOLD, 20);
        Dno.setFont(font);
        Dnofield.setFont(new Font("黑体", Font.PLAIN, 20));
        submit.setFont(font);
        reset.setFont(font);
        Dnofield.setPreferredSize(new Dimension(100, 30));


        jPanel1.add(Dno);
        jPanel1.add(Dnofield);
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

    public JTextField getDnofield() {
        return Dnofield;
    }

    public void setDnofield(JTextField dnofield) {
        Dnofield = dnofield;
    }
}
