package main.java.EMRView.Operation_Panel.PatientSonPanel;

import main.java.SqlAction.PatientSqlAction;
import main.java.handler.Patienthandler.PrivateIfoViewHandler;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class InfomationSonPanel extends JDialog {
    public Boolean flag = false;
    Container container;
    SpringLayout springLayout = new SpringLayout();
    JPanel jPanel = new JPanel(springLayout);
    JLabel Pno = new JLabel("个人密号：");
    JLabel Pnofield;
    JLabel Pname = new JLabel("姓名：");
    JLabel Pnamefield;
    JLabel Oname = new JLabel("最近挂号科室：");
    JLabel Onamefield;
    JLabel Time = new JLabel("最近挂号时间：");
    JLabel Timefield;


    JButton Update = new JButton("编辑");
    JButton Cancel = new JButton("返回");
    JButton PwdUpdate = new JButton("更改密码");

    PrivateIfoViewHandler ifoViewHandler = new PrivateIfoViewHandler(this);

    public InfomationSonPanel(JFrame jFrame, String str1, boolean bool, String str) {
        super(jFrame, str1, bool);

        Vector<String> data = new Vector<>();
        PatientSqlAction patientSqlAction = new PatientSqlAction();
        data = patientSqlAction.getData(str);

        Pnofield = new JLabel(data.get(0));
        Pnamefield = new JLabel(data.get(1));
        Onamefield = new JLabel(data.get(2));
        Timefield = new JLabel(data.get(3));
        //将组件加入面板
        jPanel.add(Pno);
        jPanel.add(Pnofield);
        jPanel.add(Pname);
        jPanel.add(Pnamefield);
        jPanel.add(Oname);
        jPanel.add(Onamefield);
        jPanel.add(Time);
        jPanel.add(Timefield);
        jPanel.add(Update);
        jPanel.add(Cancel);
        jPanel.add(PwdUpdate);

        //加入监听器
        Update.addActionListener(ifoViewHandler);
        Cancel.addActionListener(ifoViewHandler);
        PwdUpdate.addActionListener(ifoViewHandler);

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

        Update.setFont(btnFont);
        PwdUpdate.setFont(btnFont);
        Cancel.setFont(btnFont);
        //设置组件大小

        //设置组件位置
        //MRno
        springLayout.putConstraint(springLayout.NORTH, Pno, 40, springLayout.NORTH, jPanel);
        springLayout.putConstraint(springLayout.WEST, Pno, 80, springLayout.WEST, jPanel);

        springLayout.putConstraint(springLayout.NORTH, Pnofield, 0, springLayout.NORTH, Pno);
        springLayout.putConstraint(springLayout.WEST, Pnofield, 0, springLayout.EAST, Pno);
        //Pno
        springLayout.putConstraint(springLayout.NORTH, Pname, 60, springLayout.NORTH, Pno);
        springLayout.putConstraint(springLayout.EAST, Pname, 0, springLayout.EAST, Pno);

        springLayout.putConstraint(springLayout.NORTH, Pnamefield, 0, springLayout.NORTH, Pname);
        springLayout.putConstraint(springLayout.WEST, Pnamefield, 0, springLayout.EAST, Pname);
        //Dno
        springLayout.putConstraint(springLayout.NORTH, Oname, 60, springLayout.NORTH, Pname);
        springLayout.putConstraint(springLayout.EAST, Oname, 0, springLayout.EAST, Pname);

        springLayout.putConstraint(springLayout.NORTH, Onamefield, 0, springLayout.NORTH, Oname);
        springLayout.putConstraint(springLayout.WEST, Onamefield, 0, springLayout.EAST, Oname);
        //Ill
        springLayout.putConstraint(springLayout.NORTH, Time, 60, springLayout.NORTH, Oname);
        springLayout.putConstraint(springLayout.EAST, Time, 0, springLayout.EAST, Oname);

        springLayout.putConstraint(springLayout.NORTH, Timefield, 0, springLayout.NORTH, Time);
        springLayout.putConstraint(springLayout.WEST, Timefield, 0, springLayout.EAST, Time);


        //Update
        springLayout.putConstraint(springLayout.SOUTH, Update, -80, springLayout.SOUTH, jPanel);
        springLayout.putConstraint(springLayout.WEST, Update, 50, springLayout.WEST, jPanel);
        //Cancle
        springLayout.putConstraint(springLayout.SOUTH, Cancel, -80, springLayout.SOUTH, jPanel);
        springLayout.putConstraint(springLayout.EAST, Cancel, -50, springLayout.EAST, jPanel);
        //PwdUpdate
        springLayout.putConstraint(springLayout.SOUTH, PwdUpdate, -20, springLayout.SOUTH, jPanel);
        springLayout.putConstraint(springLayout.WEST, PwdUpdate, -0, springLayout.WEST, Cancel);


        add(jPanel);
        //关闭退出程序
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置大小
        setSize(320, 450);
        //设置居中
        setLocationRelativeTo(null);
        //大小不可改变
        setResizable(false);
        //设置可见
        setVisible(true);
    }

    public JLabel getPnofield() {
        return Pnofield;
    }

    public JLabel getPnamefield() {
        return Pnamefield;
    }

    public JLabel getOnamefield() {
        return Onamefield;
    }

    public JLabel getTimefield() {
        return Timefield;
    }

    public JLabel getPno() {
        return Pnofield;
    }
}
