package main.java.EMRView;

import main.java.handler.Adminhandler.AdminViewHandler;
import test.java.one.JframeTest;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class AdminView extends JFrame {
    JLabel nameLable = new JLabel("病历管理系统", JLabel.CENTER);//居中显示
    JButton returnBtn = new JButton("返回");
    Container contentPane;
    SpringLayout springLayout = new SpringLayout();
    JPanel jPanel = new JPanel(springLayout);
    JButton adminBtn = new JButton("医生管理");
    JButton doctorBtn = new JButton("患者管理");
    JButton patientBtn = new JButton("病历管理");
    //监听类
    AdminViewHandler adminViewHandler;
    private int width = 300;
    private int heigh = 50;

    public AdminView() {
        super("管理员页面");

        AdminViewHandler adminViewHandler = new AdminViewHandler(this);

        contentPane = getContentPane();//得到内容面板

        //设置窗体图标
        URL resource = JframeTest.class.getClassLoader().getResource("main/resources/two.png");
        Image image = new ImageIcon(resource).getImage();
        setIconImage(image);

        //设置字体
        Font font = new Font("楷体", Font.PLAIN, 30);

        adminBtn.setFont(font);
        doctorBtn.setFont(font);
        patientBtn.setFont(font);
        returnBtn.setFont(font);

        //设置按钮大小

        adminBtn.setPreferredSize(new Dimension(width, heigh));
        doctorBtn.setPreferredSize(new Dimension(width, heigh));
        patientBtn.setPreferredSize(new Dimension(width, heigh));

        adminBtn.addActionListener(adminViewHandler);
        jPanel.add(adminBtn);
        doctorBtn.addActionListener(adminViewHandler);
        jPanel.add(doctorBtn);
        patientBtn.addActionListener(adminViewHandler);
        jPanel.add(patientBtn);
        returnBtn.addActionListener(adminViewHandler);
        jPanel.add(returnBtn);

        layoutCenter();
        contentPane.add(jPanel, BorderLayout.CENTER);


        setSize(600, 400);

        //居中
        setLocationRelativeTo(null);
        //大小不可改变
        setResizable(false);
        //关闭退出程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置可见
        setVisible(true);
    }

    public static void main(String[] args) {
        new AdminView();
    }

    private void layoutCenter() {
        //设置约束的另一种办法
        /*
        e1:要设置组建的那个边界(edgeName)
        c1:要设置的组件
        pad:距离值
        e2:参照的组件的边界名
        c2:参照物（组件）
         */


        //adminBtn
        springLayout.putConstraint(SpringLayout.WEST, adminBtn, -width / 2, SpringLayout.HORIZONTAL_CENTER, jPanel);
        springLayout.putConstraint(SpringLayout.NORTH, adminBtn, 40, SpringLayout.NORTH, jPanel);
        //doctorBtn
        springLayout.putConstraint(SpringLayout.WEST, doctorBtn, -width / 2, SpringLayout.HORIZONTAL_CENTER, jPanel);
        springLayout.putConstraint(SpringLayout.NORTH, doctorBtn, 80, SpringLayout.NORTH, adminBtn);
        //patientBtn
        springLayout.putConstraint(SpringLayout.WEST, patientBtn, -width / 2, SpringLayout.HORIZONTAL_CENTER, jPanel);
        springLayout.putConstraint(SpringLayout.NORTH, patientBtn, 80, SpringLayout.NORTH, doctorBtn);
        //returnBtn
        springLayout.putConstraint(SpringLayout.EAST, returnBtn, -30, springLayout.EAST, jPanel);

        springLayout.putConstraint(SpringLayout.SOUTH, returnBtn, -20, SpringLayout.SOUTH, jPanel);
        //边界布局

    }
}
