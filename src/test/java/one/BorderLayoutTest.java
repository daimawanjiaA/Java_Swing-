package test.java.one;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutTest extends JFrame {


    JButton northBtn = new JButton("北边按钮");
    JLabel southlabel = new JLabel("南边的label");
    JRadioButton westRadioBtn = new JRadioButton("男");
    JTextArea eastArea = new JTextArea("输入内容", 10, 20);
    JButton centerBtn = new JButton("中间按钮");

    public BorderLayoutTest() {
        super("测试边界布局");
        //容器组件：jframe，jpanel，jscrollpane  非容器组件：jbutton，jlabel，jtextfield。。。
        Container contentPane = getContentPane();//面板
        //设置布局管理器
        contentPane.setLayout(new BorderLayout());
        contentPane.add(northBtn, BorderLayout.NORTH);
        contentPane.add(southlabel, BorderLayout.SOUTH);
        contentPane.add(westRadioBtn, BorderLayout.WEST);
        westRadioBtn.setPreferredSize(new Dimension(200, 0));//设置某个组件的优先大小，
        // 但是有些是无效的，因为他是尽可能的要把整个区域充满
        contentPane.add(eastArea, BorderLayout.EAST);
        contentPane.add(centerBtn, BorderLayout.CENTER);


        setSize(600, 400);
        //居中
        setLocationRelativeTo(null);
        //关闭退出程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //大小不可改变
        setResizable(false);
        //设置可见
        setVisible(true);


    }

    public static void main(String[] args) {
        new BorderLayoutTest();
    }
}