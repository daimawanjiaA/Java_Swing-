package main.java.EMRView;

import main.java.handler.LoginHandler;
import main.java.handler.MenuViewHandle;
import main.java.util.DBUtil;
import test.java.one.JframeTest;

import javax.swing.*;
import java.awt.*;
import java.net.URL;


public class MenuView extends JFrame {

    Container contentPane;
    SpringLayout springLayout = new SpringLayout();
    JPanel jPanel = new JPanel(springLayout);
    JButton adminBtn = new JButton("管理员登录");
    JButton doctorBtn = new JButton("医生登录");
    JButton patientBtn = new JButton("患者登录");
    //监听类
    LoginHandler loginHandler;
    private int width = 300;
    private int heigh = 50;

    public MenuView() {
        super("登陆页面");

        //重置
        DBUtil.reset();

        MenuViewHandle menuViewHandle = new MenuViewHandle(this);

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

        //设置按钮大小

        adminBtn.setPreferredSize(new Dimension(width, heigh));
        doctorBtn.setPreferredSize(new Dimension(width, heigh));
        patientBtn.setPreferredSize(new Dimension(width, heigh));

        adminBtn.addActionListener(menuViewHandle);
        jPanel.add(adminBtn);
        doctorBtn.addActionListener(menuViewHandle);
        jPanel.add(doctorBtn);
        patientBtn.addActionListener(menuViewHandle);
        jPanel.add(patientBtn);

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
        new MenuView();
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

        int adminwidth = adminBtn.getWidth();
        int doctowideh = doctorBtn.getWidth();
        int patientwidth = patientBtn.getWidth();
        //adminBtn
        springLayout.putConstraint(SpringLayout.WEST, adminBtn, -width / 2, SpringLayout.HORIZONTAL_CENTER, jPanel);
        springLayout.putConstraint(SpringLayout.NORTH, adminBtn, 80, SpringLayout.NORTH, jPanel);
        //doctorBtn
        springLayout.putConstraint(SpringLayout.WEST, doctorBtn, -width / 2, SpringLayout.HORIZONTAL_CENTER, jPanel);
        springLayout.putConstraint(SpringLayout.NORTH, doctorBtn, 80, SpringLayout.NORTH, adminBtn);
        //patientBtn
        springLayout.putConstraint(SpringLayout.WEST, patientBtn, -width / 2, SpringLayout.HORIZONTAL_CENTER, jPanel);
        springLayout.putConstraint(SpringLayout.NORTH, patientBtn, 80, SpringLayout.NORTH, doctorBtn);
        //边界布局
    }
}
