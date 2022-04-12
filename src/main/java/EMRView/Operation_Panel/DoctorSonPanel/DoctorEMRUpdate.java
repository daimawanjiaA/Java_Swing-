package main.java.EMRView.Operation_Panel.DoctorSonPanel;


import main.java.handler.Doctorhandler.EMRUpdateHandler;

import javax.swing.*;
import java.awt.*;

public class DoctorEMRUpdate extends JDialog {

    public Boolean flag = false;
    Container container;
    SpringLayout springLayout = new SpringLayout();
    JPanel jPanel = new JPanel(springLayout);
    JLabel MRno = new JLabel("请输入要更改的病历号：");
    JTextField MRnofield = new JTextField();


    JLabel Pno = new JLabel("患者编号：");
    JTextField Pnofield = new JTextField();
    JLabel Dno = new JLabel("医生编号：");
    JTextField Dnofield = new JTextField();
    JLabel Ill = new JLabel("诊断疾病：");
    JTextField Illfield = new JTextField();
    JLabel Res = new JLabel("出院结果：");
    JTextField Resfield = new JTextField();
    JLabel Treat = new JLabel("治疗经过：");
    JTextField Treatfield = new JTextField();

    JButton Submit = new JButton("编辑");
    JButton Cancel = new JButton("重置");

    EMRUpdateHandler emrUpdateHandler = new EMRUpdateHandler(this);

    public DoctorEMRUpdate(JFrame jFrame, String str1, boolean bool) {
        super(jFrame, str1, bool);
        //将组件加入面板
        jPanel.add(MRno);
        MRno.setForeground(Color.RED);
        jPanel.add(MRnofield);
        jPanel.add(Pno);
        jPanel.add(Pnofield);
        jPanel.add(Dno);
        jPanel.add(Dnofield);
        jPanel.add(Ill);
        jPanel.add(Illfield);
        jPanel.add(Treat);
        jPanel.add(Treatfield);
        jPanel.add(Res);
        jPanel.add(Resfield);

        jPanel.add(Submit);
        jPanel.add(Cancel);
        //加入监听器
        Submit.addActionListener(emrUpdateHandler);
        Cancel.addActionListener(emrUpdateHandler);
        //设置组件字体
        Font btnFont = new Font("黑体", Font.PLAIN, 20);
        MRno.setFont(btnFont);
        MRnofield.setFont(btnFont);
        Pno.setFont(btnFont);
        Pnofield.setFont(btnFont);
        Dno.setFont(btnFont);
        Dnofield.setFont(btnFont);
        Ill.setFont(btnFont);
        Illfield.setFont(btnFont);
        Treat.setFont(btnFont);
        Treatfield.setFont(btnFont);
        Res.setFont(btnFont);
        Resfield.setFont(btnFont);

        Submit.setFont(btnFont);
        Cancel.setFont(btnFont);
        //设置组件大小
        MRnofield.setPreferredSize(new Dimension(120, 30));
        Pnofield.setPreferredSize(new Dimension(120, 30));
        Dnofield.setPreferredSize(new Dimension(120, 30));
        Illfield.setPreferredSize(new Dimension(120, 30));
        Treatfield.setPreferredSize(new Dimension(120, 30));
        Resfield.setPreferredSize(new Dimension(120, 30));
        //设置组件位置
        //MRno
        springLayout.putConstraint(springLayout.NORTH, MRno, 20, springLayout.NORTH, jPanel);
        springLayout.putConstraint(springLayout.WEST, MRno, 60, springLayout.WEST, jPanel);

        springLayout.putConstraint(springLayout.NORTH, MRnofield, 0, springLayout.NORTH, MRno);
        springLayout.putConstraint(springLayout.WEST, MRnofield, 0, springLayout.EAST, MRno);
        //Pno
        springLayout.putConstraint(springLayout.NORTH, Pno, 80, springLayout.NORTH, MRno);
        springLayout.putConstraint(springLayout.EAST, Pno, 0, springLayout.EAST, MRno);

        springLayout.putConstraint(springLayout.NORTH, Pnofield, 0, springLayout.NORTH, Pno);
        springLayout.putConstraint(springLayout.WEST, Pnofield, 0, springLayout.EAST, Pno);
        //Dno
        springLayout.putConstraint(springLayout.NORTH, Dno, 50, springLayout.NORTH, Pno);
        springLayout.putConstraint(springLayout.EAST, Dno, 0, springLayout.EAST, Pno);

        springLayout.putConstraint(springLayout.NORTH, Dnofield, 0, springLayout.NORTH, Dno);
        springLayout.putConstraint(springLayout.WEST, Dnofield, 0, springLayout.EAST, Dno);
        //Ill
        springLayout.putConstraint(springLayout.NORTH, Ill, 50, springLayout.NORTH, Dno);
        springLayout.putConstraint(springLayout.EAST, Ill, 0, springLayout.EAST, Dno);

        springLayout.putConstraint(springLayout.NORTH, Illfield, 0, springLayout.NORTH, Ill);
        springLayout.putConstraint(springLayout.WEST, Illfield, 0, springLayout.EAST, Ill);

        //Res
        springLayout.putConstraint(springLayout.NORTH, Res, 50, springLayout.NORTH, Ill);
        springLayout.putConstraint(springLayout.EAST, Res, 0, springLayout.EAST, Ill);

        springLayout.putConstraint(springLayout.NORTH, Resfield, 0, springLayout.NORTH, Res);
        springLayout.putConstraint(springLayout.WEST, Resfield, 0, springLayout.EAST, Res);
        //Treat
        springLayout.putConstraint(springLayout.NORTH, Treat, 50, springLayout.NORTH, Res);
        springLayout.putConstraint(springLayout.EAST, Treat, 0, springLayout.EAST, Res);

        springLayout.putConstraint(springLayout.NORTH, Treatfield, 0, springLayout.NORTH, Treat);
        springLayout.putConstraint(springLayout.WEST, Treatfield, 0, springLayout.EAST, Treat);
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
        setSize(600, 450);
        //设置居中
        setLocationRelativeTo(null);
        //大小不可改变
        setResizable(false);
        //设置可见
        setVisible(true);
    }

    public static void main(String[] args) {

        new DoctorEMRUpdate(null, null, true);
    }

    public JTextField getMRnofield() {
        return MRnofield;
    }

    public void setMRnofield(JTextField MRnofield) {
        this.MRnofield = MRnofield;
    }

    public JTextField getPnofield() {
        return Pnofield;
    }

    public void setPnofield(JTextField pnofield) {
        Pnofield = pnofield;
    }

    public JTextField getDnofield() {
        return Dnofield;
    }

    public void setDnofield(JTextField dnofield) {
        Dnofield = dnofield;
    }

    public JTextField getIllfield() {
        return Illfield;
    }

    public void setIllfield(JTextField illfield) {
        Illfield = illfield;
    }

    public JTextField getResfield() {
        return Resfield;
    }

    public void setResfield(JTextField resfield) {
        Resfield = resfield;
    }

    public JTextField getTreatfield() {
        return Treatfield;
    }

    public void setTreatfield(JTextField treatfield) {
        Treatfield = treatfield;
    }
}