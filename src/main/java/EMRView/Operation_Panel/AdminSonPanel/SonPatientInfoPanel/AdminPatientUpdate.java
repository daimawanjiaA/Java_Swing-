package main.java.EMRView.Operation_Panel.AdminSonPanel.SonPatientInfoPanel;

import main.java.handler.Adminhandler.SonPatienthandler.SonPatientUpdateHandler;

import javax.swing.*;
import java.awt.*;

public class AdminPatientUpdate extends JDialog {

    public Boolean flag = false;
    Container container;
    SpringLayout springLayout = new SpringLayout();
    JPanel jPanel = new JPanel(springLayout);


    JLabel Pno = new JLabel("请输入患者编号：");
    JTextField Pnofield = new JTextField();
    JLabel Pname = new JLabel("患者姓名：");
    JTextField Pnamefield = new JTextField();
    JLabel Oname = new JLabel("上一次就诊科室：");
    JTextField Onamefield = new JTextField();
    JLabel Time = new JLabel("上一次就诊时间：");
    JTextField Timefield = new JTextField();
    JLabel pwd = new JLabel("密码：");
    JTextField pwdfield = new JTextField();

    JButton Submit = new JButton("编辑");
    JButton Cancel = new JButton("重置");

    SonPatientUpdateHandler sonPatientUpdateHandler = new SonPatientUpdateHandler(this);

    public AdminPatientUpdate(JFrame jFrame, String str1, boolean bool) {
        super(jFrame, str1, bool);
        //将组件加入面板
        jPanel.add(Pno);

        Pno.setForeground(Color.RED);
        jPanel.add(Pnofield);
        jPanel.add(Pname);
        jPanel.add(Pnamefield);
        jPanel.add(Oname);
        jPanel.add(Onamefield);
        jPanel.add(Time);
        jPanel.add(Timefield);
        jPanel.add(pwd);
        jPanel.add(pwdfield);

        jPanel.add(Submit);
        jPanel.add(Cancel);
        //加入监听器
        Submit.addActionListener(sonPatientUpdateHandler);
        Cancel.addActionListener(sonPatientUpdateHandler);
        //设置组件字体
        Font btnFont = new Font("黑体", Font.PLAIN, 20);
        Pno.setFont(btnFont);
        Pnofield.setFont(btnFont);
        Pname.setFont(btnFont);
        Pnamefield.setFont(btnFont);
        Oname.setFont(btnFont);
        Onamefield.setFont(btnFont);
        Time.setFont(btnFont);
        Timefield.setFont(btnFont);
        pwd.setFont(btnFont);
        pwdfield.setFont(btnFont);

        Submit.setFont(btnFont);
        Cancel.setFont(btnFont);
        //设置组件大小
        Pnofield.setPreferredSize(new Dimension(120, 30));
        Pnamefield.setPreferredSize(new Dimension(120, 30));
        Onamefield.setPreferredSize(new Dimension(120, 30));
        Timefield.setPreferredSize(new Dimension(120, 30));
        pwdfield.setPreferredSize(new Dimension(120, 30));
        //设置组件位置
        //Pno
        springLayout.putConstraint(springLayout.NORTH, Pno, 20, springLayout.NORTH, jPanel);
        springLayout.putConstraint(springLayout.WEST, Pno, 30, springLayout.WEST, jPanel);

        springLayout.putConstraint(springLayout.NORTH, Pnofield, 0, springLayout.NORTH, Pno);
        springLayout.putConstraint(springLayout.WEST, Pnofield, 0, springLayout.EAST, Pno);
        //Pname
        springLayout.putConstraint(springLayout.NORTH, Pname, 80, springLayout.NORTH, Pno);
        springLayout.putConstraint(springLayout.EAST, Pname, 0, springLayout.EAST, Pno);

        springLayout.putConstraint(springLayout.NORTH, Pnamefield, 0, springLayout.NORTH, Pname);
        springLayout.putConstraint(springLayout.WEST, Pnamefield, 0, springLayout.EAST, Pname);
        //Oname
        springLayout.putConstraint(springLayout.NORTH, Oname, 50, springLayout.NORTH, Pname);
        springLayout.putConstraint(springLayout.EAST, Oname, 0, springLayout.EAST, Pname);

        springLayout.putConstraint(springLayout.NORTH, Onamefield, 0, springLayout.NORTH, Oname);
        springLayout.putConstraint(springLayout.WEST, Onamefield, 0, springLayout.EAST, Oname);
        //Time
        springLayout.putConstraint(springLayout.NORTH, Time, 50, springLayout.NORTH, Oname);
        springLayout.putConstraint(springLayout.EAST, Time, 0, springLayout.EAST, Oname);

        springLayout.putConstraint(springLayout.NORTH, Timefield, 0, springLayout.NORTH, Time);
        springLayout.putConstraint(springLayout.WEST, Timefield, 0, springLayout.EAST, Time);

        //pwd
        springLayout.putConstraint(springLayout.NORTH, pwd, 50, springLayout.NORTH, Time);
        springLayout.putConstraint(springLayout.EAST, pwd, 0, springLayout.EAST, Time);

        springLayout.putConstraint(springLayout.NORTH, pwdfield, 0, springLayout.NORTH, pwd);
        springLayout.putConstraint(springLayout.WEST, pwdfield, 0, springLayout.EAST, pwd);
        //Submit
        springLayout.putConstraint(springLayout.SOUTH, Submit, -20, springLayout.SOUTH, jPanel);
        springLayout.putConstraint(springLayout.WEST, Submit, 40, springLayout.WEST, jPanel);
        //Cancel
        springLayout.putConstraint(springLayout.SOUTH, Cancel, -20, springLayout.SOUTH, jPanel);
        springLayout.putConstraint(springLayout.EAST, Cancel, -40, springLayout.EAST, jPanel);


        add(jPanel);
        //关闭退出程序
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置大小
        setSize(380, 400);
        //设置居中
        setLocationRelativeTo(null);
        //大小不可改变
        setResizable(false);
        //设置可见
        setVisible(true);
    }

    public static void main(String[] args) {
        new AdminPatientUpdate(null, null, true);
    }

    public JTextField getPnofield() {
        return Pnofield;
    }

    public void setPnofield(JTextField pnofield) {
        Pnofield = pnofield;
    }

    public JTextField getPnamefield() {
        return Pnamefield;
    }

    public void setPnamefield(JTextField pnamefield) {
        Pnamefield = pnamefield;
    }

    public JTextField getOnamefield() {
        return Onamefield;
    }

    public void setOnamefield(JTextField onamefield) {
        Onamefield = onamefield;
    }

    public JTextField getTimefield() {
        return Timefield;
    }

    public void setTimefield(JTextField timefield) {
        Timefield = timefield;
    }

    public JTextField getPwdfield() {
        return pwdfield;
    }

    public void setPwdfield(JTextField pwdfield) {
        this.pwdfield = pwdfield;
    }
}