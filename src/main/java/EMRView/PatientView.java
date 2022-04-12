package main.java.EMRView;

import main.java.handler.Patienthandler.PatientViewHandle;
import test.java.one.JframeTest;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class PatientView extends JFrame {
    JLabel nameLable = new JLabel("个人中心", JLabel.CENTER);//居中显示
    Container contentPane;
    SpringLayout springLayout = new SpringLayout();
    JPanel jPanel = new JPanel(springLayout);
    JButton adminBtn = new JButton("个人信息");
    JButton doctorBtn = new JButton("病历信息");
    JButton retBtn = new JButton("返回页面");
    //监听类
    PatientViewHandle patientViewHandle;
    private int width = 155;
    private int heigh = 45;
    private String Pno = null;

    public PatientView(String str) {
        super("登陆页面");
        Pno = str;

        contentPane = getContentPane();//得到内容面板
        //设置监听器
        patientViewHandle = new PatientViewHandle(this);
        adminBtn.addActionListener(patientViewHandle);
        doctorBtn.addActionListener(patientViewHandle);
        retBtn.addActionListener(patientViewHandle);
        //设置窗体图标
        URL resource = JframeTest.class.getClassLoader().getResource("main/resources/two.png");
        Image image = new ImageIcon(resource).getImage();
        setIconImage(image);

        layoutNorth();
        layoutSouth();


        setSize(300, 400);

        //居中
        setLocationRelativeTo(null);
        //大小不可改变
        setResizable(false);
        //关闭退出程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置可见
        setVisible(true);
    }

    private void layoutSouth() {

        //设置字体
        Font font = new Font("楷体", Font.PLAIN, 30);
        adminBtn.setFont(font);
        doctorBtn.setFont(font);
        retBtn.setFont(font);


        //设置按钮大小

        adminBtn.setPreferredSize(new Dimension(width, heigh));
        doctorBtn.setPreferredSize(new Dimension(width, heigh));
        retBtn.setPreferredSize(new Dimension(width, heigh));

        //adminBtn.addActionListener(menuViewHandle);
        jPanel.add(adminBtn);
        // doctorBtn.addActionListener(menuViewHandle);
        jPanel.add(doctorBtn);
        jPanel.add(retBtn);
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

        //adminBtn
        springLayout.putConstraint(SpringLayout.WEST, adminBtn, -width / 2, SpringLayout.HORIZONTAL_CENTER, jPanel);
        springLayout.putConstraint(SpringLayout.NORTH, adminBtn, 20, SpringLayout.NORTH, jPanel);
        //doctorBtn
        springLayout.putConstraint(SpringLayout.WEST, doctorBtn, -width / 2, SpringLayout.HORIZONTAL_CENTER, jPanel);
        springLayout.putConstraint(SpringLayout.NORTH, doctorBtn, 70, SpringLayout.NORTH, adminBtn);
        //patientBtn
        springLayout.putConstraint(SpringLayout.WEST, retBtn, -width / 2, SpringLayout.HORIZONTAL_CENTER, jPanel);
        springLayout.putConstraint(SpringLayout.NORTH, retBtn, 70, SpringLayout.NORTH, doctorBtn);

        contentPane.add(jPanel, BorderLayout.CENTER);

    }

    private void layoutNorth() {
        nameLable.setFont(new Font("宋体", Font.PLAIN, 50));
        nameLable.setPreferredSize(new Dimension(300, 100));
        contentPane.add(BorderLayout.NORTH, nameLable);
    }

    public String getPno() {
        return Pno;
    }

}
