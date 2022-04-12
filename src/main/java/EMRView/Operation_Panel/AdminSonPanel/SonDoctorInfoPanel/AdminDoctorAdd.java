package main.java.EMRView.Operation_Panel.AdminSonPanel.SonDoctorInfoPanel;

import main.java.handler.Adminhandler.SonDoctorhandler.SonDoctorAddHandler;

import javax.swing.*;
import java.awt.*;

public class AdminDoctorAdd extends JDialog {

    public Boolean flag = false;
    //Container container;
    SpringLayout springLayout = new SpringLayout();
    JPanel jPanel = new JPanel(springLayout);
    JLabel Dno = new JLabel("医生编号：");
    JTextField Dnofield = new JTextField();


    JLabel Dname = new JLabel("医生姓名：");
    JTextField Dnamefield = new JTextField();
    JLabel Dphone = new JLabel("医生电话：");
    JTextField Dphonefield = new JTextField();
    JLabel Oname = new JLabel("所属科室：");
    JTextField Onamefield = new JTextField();
    JLabel pwd = new JLabel("登录密码：");
    JTextField pwdfield = new JTextField();


    JButton Submit = new JButton("确认");
    JButton Cancel = new JButton("重置");

    SonDoctorAddHandler addhandler = new SonDoctorAddHandler(this);

    public AdminDoctorAdd(JFrame jFrame, String str1, boolean bool) {
        super(jFrame, str1, bool);
        //将组件加入面板
        jPanel.add(Dno);
        jPanel.add(Dnofield);
        jPanel.add(Dname);
        jPanel.add(Dnamefield);
        jPanel.add(Dphone);
        jPanel.add(Dphonefield);
        jPanel.add(Oname);
        jPanel.add(Onamefield);
        jPanel.add(pwd);
        jPanel.add(pwdfield);

        jPanel.add(Submit);
        jPanel.add(Cancel);
        //加入监听器
        Submit.addActionListener(addhandler);
        Cancel.addActionListener(addhandler);
        //设置组件字体
        Font btnFont = new Font("黑体", Font.PLAIN, 20);
        Dno.setFont(btnFont);
        Dnofield.setFont(btnFont);
        Dname.setFont(btnFont);
        Dnamefield.setFont(btnFont);
        Dphone.setFont(btnFont);
        Dphonefield.setFont(btnFont);
        Oname.setFont(btnFont);
        Onamefield.setFont(btnFont);
        pwd.setFont(btnFont);
        pwdfield.setFont(btnFont);

        Submit.setFont(btnFont);
        Cancel.setFont(btnFont);
        //设置组件大小
        Dnofield.setPreferredSize(new Dimension(120, 30));
        Dnamefield.setPreferredSize(new Dimension(120, 30));
        Dphonefield.setPreferredSize(new Dimension(120, 30));
        Onamefield.setPreferredSize(new Dimension(120, 30));
        pwdfield.setPreferredSize(new Dimension(120, 30));
        //设置组件位置
        //Dno
        springLayout.putConstraint(springLayout.NORTH, Dno, 40, springLayout.NORTH, jPanel);
        springLayout.putConstraint(springLayout.WEST, Dno, 30, springLayout.WEST, jPanel);

        springLayout.putConstraint(springLayout.NORTH, Dnofield, 0, springLayout.NORTH, Dno);
        springLayout.putConstraint(springLayout.WEST, Dnofield, 0, springLayout.EAST, Dno);
        //Dname
        springLayout.putConstraint(springLayout.NORTH, Dname, 60, springLayout.NORTH, Dno);
        springLayout.putConstraint(springLayout.EAST, Dname, 0, springLayout.EAST, Dno);

        springLayout.putConstraint(springLayout.NORTH, Dnamefield, 0, springLayout.NORTH, Dname);
        springLayout.putConstraint(springLayout.WEST, Dnamefield, 0, springLayout.EAST, Dname);
        //Dphone
        springLayout.putConstraint(springLayout.NORTH, Dphone, 60, springLayout.NORTH, Dname);
        springLayout.putConstraint(springLayout.EAST, Dphone, 0, springLayout.EAST, Dname);

        springLayout.putConstraint(springLayout.NORTH, Dphonefield, 0, springLayout.NORTH, Dphone);
        springLayout.putConstraint(springLayout.WEST, Dphonefield, 0, springLayout.EAST, Dphone);
        //Oname
        springLayout.putConstraint(springLayout.NORTH, Oname, 60, springLayout.NORTH, Dphone);
        springLayout.putConstraint(springLayout.EAST, Oname, 0, springLayout.EAST, Dphone);

        springLayout.putConstraint(springLayout.NORTH, Onamefield, 0, springLayout.NORTH, Oname);
        springLayout.putConstraint(springLayout.WEST, Onamefield, 0, springLayout.EAST, Oname);

        //pwd
        springLayout.putConstraint(springLayout.NORTH, pwd, 60, springLayout.NORTH, Oname);
        springLayout.putConstraint(springLayout.EAST, pwd, 0, springLayout.EAST, Oname);

        springLayout.putConstraint(springLayout.NORTH, pwdfield, 0, springLayout.NORTH, pwd);
        springLayout.putConstraint(springLayout.WEST, pwdfield, 0, springLayout.EAST, pwd);
        //Submit
        springLayout.putConstraint(springLayout.SOUTH, Submit, -40, springLayout.SOUTH, jPanel);
        springLayout.putConstraint(springLayout.WEST, Submit, 20, springLayout.WEST, jPanel);
        //Cancel
        springLayout.putConstraint(springLayout.SOUTH, Cancel, -40, springLayout.SOUTH, jPanel);
        springLayout.putConstraint(springLayout.EAST, Cancel, -20, springLayout.EAST, jPanel);


        add(jPanel);
        //关闭退出程序
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置大小
        setSize(280, 450);
        //设置居中
        setLocationRelativeTo(null);
        //大小不可改变
        setResizable(false);
        //设置可见
        setVisible(true);
    }


    public static void main(String[] args) {

        new AdminDoctorAdd(null, null, true);
    }

    public JTextField getDnofield() {
        return Dnofield;
    }

    public void setDnofield(JTextField dnofield) {
        Dnofield = dnofield;
    }

    public JTextField getDnamefield() {
        return Dnamefield;
    }

    public void setDnamefield(JTextField dnamefield) {
        Dnamefield = dnamefield;
    }

    public JTextField getDphonefield() {
        return Dphonefield;
    }

    public void setDphonefield(JTextField dphonefield) {
        Dphonefield = dphonefield;
    }

    public JTextField getOnamefield() {
        return Onamefield;
    }

    public void setOnamefield(JTextField onamefield) {
        Onamefield = onamefield;
    }

    public JTextField getPwdfield() {
        return pwdfield;
    }

    public void setPwdfield(JTextField pwdfield) {
        this.pwdfield = pwdfield;
    }
}
