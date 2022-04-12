package main.resources;

import javax.swing.*;
import java.awt.*;

public class Test {


    public static void main(String[] args) {
        SpringLayout springLayout = new SpringLayout();
        JDialog jdlg = new JDialog(new Frame(), "医生信息删除");
        jdlg.setLayout(springLayout);
        JLabel Dno = new JLabel("请输入医生编号: ");
        JTextField Dnofield = new JTextField();
        Dno.setFont(new Font("黑体", Font.BOLD, 20));
        Dnofield.setFont(new Font("黑体", Font.PLAIN, 20));
        Dnofield.setPreferredSize(new Dimension(100, 30));

        JButton submit = new JButton("确定");
        submit.setFont(new Font("黑体", Font.BOLD, 20));
        JPanel jPanel = new JPanel();
        jPanel.add(Dno);
        jPanel.add(Dnofield);
        jPanel.add(submit);
        jdlg.add(jPanel);
        //设置大小
        jdlg.setSize(400, 100);
        //设置居中
        jdlg.setLocationRelativeTo(null);
        //大小不可改变
        jdlg.setResizable(false);
        //关闭退出程序
        //jdlg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置可见
        jdlg.setVisible(true);
    }
}
