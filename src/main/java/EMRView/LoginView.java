package main.java.EMRView;

import main.java.handler.LoginHandler;
import main.java.util.ValidCode;
import test.java.one.JframeTest;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class LoginView extends JFrame {

    JLabel nameLable = new JLabel("病历管理系统", JLabel.CENTER);//居中显示

    Container contentPane;

    SpringLayout springLayout = new SpringLayout();
    JPanel jPanel = new JPanel(springLayout);

    JLabel useLabel = new JLabel("用户名:");

    JTextField useField = new JTextField();
    JLabel passLabel = new JLabel("密码:");
    JPasswordField passField = new JPasswordField();
    //底下按钮
    JButton loginBtn = new JButton("登录");
    JButton resetBtn = new JButton("重置");
    JButton returnBtn = new JButton("返回");

    JLabel validLab = new JLabel("验证码:");
    JTextField validField = new JTextField();
    ValidCode validCode = new ValidCode();


    //监听类
    LoginHandler loginHandler;

    public LoginView(String Title) {
        super(Title);

        loginHandler = new LoginHandler(this);

        contentPane = getContentPane();//得到内容面板

        //设置窗体图标
        URL resource = JframeTest.class.getClassLoader().getResource("main/resources/two.png");
        Image image = new ImageIcon(resource).getImage();
        setIconImage(image);

        //设置字体
        nameLable.setFont(new Font("华文行楷", Font.PLAIN, 60));
        nameLable.setPreferredSize(new Dimension(0, 100));

        Font jcenterFont = new Font("楷体", Font.PLAIN, 20);

        useLabel.setFont(jcenterFont);
        passLabel.setFont(jcenterFont);
        loginBtn.setFont(jcenterFont);
        resetBtn.setFont(jcenterFont);
        returnBtn.setFont(jcenterFont);
        validLab.setFont(jcenterFont);
        validField.setFont(jcenterFont);

        /*
        流式布局
        JPanel jPanelbtn = new JPanel(new FlowLayout(FlowLayout.CENTER,80,30));
        设置jpanel的布局管理器为SpringLayout
        jPanelbtn.add(loginBtn);
        jPanelbtn.add(resetBtn);
        ...
        ...
        contentPane.add(jPanelbtn,BorderLayout.SOUTH);
        */
        //弹簧布局
        //加入到java中
        jPanel.add(useLabel);
        useField.setPreferredSize(new Dimension(200, 30));
        jPanel.add(useField);

        jPanel.add(passLabel);
        passField.setPreferredSize(new Dimension(200, 30));
        jPanel.add(passField);
        jPanel.add(validLab);
        jPanel.add(validField);
        validField.setPreferredSize(new Dimension(90, 30));
        jPanel.add(validCode);

        //按钮
        loginBtn.addActionListener(loginHandler);
        jPanel.add(loginBtn);
        resetBtn.addActionListener(loginHandler);
        jPanel.add(resetBtn);
        returnBtn.addActionListener(loginHandler);
        jPanel.add(returnBtn);

        //设置弹簧布局 面板颜色
        //jPanel.setBackground(Color.WHITE);

        layoutCenter();

        contentPane.add(nameLable, BorderLayout.NORTH);
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

    private void layoutCenter() {
    /*
    SpringLayout: 布局管理器
    SpringLayout.Constraints: 使用弹簧布局的容器里面的组件的布局约束，每个组件对应一个
    Spring： 可以理解为一个能够进行四则运算的整数
     */
        Spring useFablewidth = Spring.width(useLabel);
        Spring useTxtwidth = Spring.width(useField);
        Spring useSpace = Spring.constant(20);
        Spring usewidth = Spring.sum(Spring.sum(useFablewidth, useTxtwidth), useSpace);
        int offsetX = usewidth.getValue() / 2;

        //设置约束的第一种办     法较为麻烦

//        SpringLayout.Constraints useLabelC = springLayout.getConstraints(useLabel);
//        useLabelC.setConstraint(SpringLayout.NORTH,Spring.constant(40));
        //设置约束的另一种办法
        /*
        e1:要设置组建的那个边界(edgeName)
        c1:要设置的组件
        pad:距离值
        e2:参照的组件的边界名
        c2:参照物（组件）
         */

        //useLabel
        springLayout.putConstraint(SpringLayout.WEST, useLabel, -offsetX, SpringLayout.HORIZONTAL_CENTER, jPanel);
        springLayout.putConstraint(SpringLayout.NORTH, useLabel, 20, SpringLayout.NORTH, jPanel);
        //useField
        springLayout.putConstraint(SpringLayout.WEST, useField, 20, SpringLayout.EAST, useLabel);
        springLayout.putConstraint(SpringLayout.NORTH, useField, 0, SpringLayout.NORTH, useLabel);
        //passLabel
        springLayout.putConstraint(SpringLayout.EAST, passLabel, 0, SpringLayout.EAST, useLabel);
        springLayout.putConstraint(SpringLayout.NORTH, passLabel, 30, SpringLayout.SOUTH, useLabel);
        //passField
        springLayout.putConstraint(SpringLayout.WEST, passField, 20, SpringLayout.EAST, passLabel);
        springLayout.putConstraint(SpringLayout.NORTH, passField, 0, SpringLayout.NORTH, passLabel);
        //validLab
        springLayout.putConstraint(SpringLayout.EAST, validLab, 0, SpringLayout.EAST, passLabel);
        springLayout.putConstraint(SpringLayout.NORTH, validLab, 30, SpringLayout.SOUTH, passLabel);
        //validField
        springLayout.putConstraint(SpringLayout.WEST, validField, 20, SpringLayout.EAST, validLab);
        springLayout.putConstraint(SpringLayout.NORTH, validField, 0, SpringLayout.NORTH, validLab);
        //validCode
        springLayout.putConstraint(SpringLayout.WEST, validCode, 20, SpringLayout.EAST, validField);
        springLayout.putConstraint(SpringLayout.NORTH, validCode, -7, SpringLayout.NORTH, validField);
        //loginBtn
        springLayout.putConstraint(SpringLayout.EAST, loginBtn, -120, SpringLayout.HORIZONTAL_CENTER, jPanel);
        springLayout.putConstraint(SpringLayout.SOUTH, loginBtn, -20, SpringLayout.SOUTH, jPanel);
        //resetBtn
        springLayout.putConstraint(SpringLayout.WEST, resetBtn, 120, SpringLayout.HORIZONTAL_CENTER, jPanel);
        springLayout.putConstraint(SpringLayout.NORTH, resetBtn, 0, SpringLayout.NORTH, loginBtn);
        //returnBtn
        springLayout.putConstraint(SpringLayout.EAST, returnBtn, 40, SpringLayout.HORIZONTAL_CENTER, jPanel);
        springLayout.putConstraint(SpringLayout.NORTH, returnBtn, 0, SpringLayout.NORTH, loginBtn);
        //边界布局
    }


    public JTextField getUseField() {
        return useField;
    }

    public void setUseField(JTextField useField) {
        this.useField = useField;
    }

    public JPasswordField getPassField() {
        return passField;
    }

    public void setPassField(JPasswordField passField) {
        this.passField = passField;
    }

    public JTextField getValidField() {
        return validField;
    }

    public ValidCode getValidCode() {
        return validCode;
    }

    public boolean isValidCodeRight() {


        if (validCode == null) {
            return true;
        }
        if (validCode.getCode().equals(validField.getText())) {
            return true;
        }
        return false;
    }
}
