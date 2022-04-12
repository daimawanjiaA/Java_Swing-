package test.java.one;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JframeTest extends JFrame {
    Container contentPane;

    public JframeTest() {
        super("这是frame的标题");
        //容器组件：jframe，jpanel，jscrollpane  非容器组件：jbutton，jlabel，jtextfield。。。
        contentPane = getContentPane();//面板

        JButton jButton1 = new JButton("这是一个按钮");
        contentPane.add(jButton1);//将按钮放在面板中


        //设置窗体图标
        URL resource = JframeTest.class.getClassLoader().getResource("main/resources/two.png");
        Image image = new ImageIcon(resource).getImage();
        setIconImage(image);
        setSize(600, 400);
        //居中
        //1.
        setLocationRelativeTo(null);
        //自己计算位置来居中
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        int offsetX = (screenSize.width - 600) / 2;
//        int offsetY = (screenSize.height - 400) / 2;
//        jFrame.setLocation(offsetX,offsetX);
        //关闭退出程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //大小不可改变
        setResizable(false);
        //设置可见
        setVisible(true);


    }

    public static void main(String[] args) {
        new JframeTest();
    }
}