package main.java.EMRView;

import main.java.EMRView.ext.Doctor.MainViewTable;
import main.java.EMRView.ext.Doctor.MainViewTableModel;
import main.java.SqlAction.DoctorSqlAction;
import main.java.handler.Doctorhandler.MainViewHandler;
import main.java.util.DimensionUtil;
import test.java.one.JframeTest;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Vector;

public class MainView extends JFrame {
    JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 30));

    JButton addBtn = new JButton("增加");
    JButton updateBtn = new JButton("修改");
    //JButton delBtn = new JButton("删除");
    JTextField searchTxt = new JTextField(15);
    JButton searchBtn = new JButton("查询(病历号\\疾病)");
    JButton returnBtn = new JButton("返回");
    SpringLayout springLayout = new SpringLayout();
    JPanel southPanel = new JPanel(springLayout);
    JButton preBtn = new JButton("上一页");
    JButton nextBtn = new JButton("下一页");
    MainViewTable mainViewTable = new MainViewTable();
    MainViewHandler mainViewHandler = new MainViewHandler(this);

    public MainView() {
        super("主界面");
        Container contentPane = getContentPane();
        //设置北边组件
        layoutNorth(contentPane);
        //设置中间组件
        layoutCenter(contentPane);
        //设置南边的组件
        layoutSouth(contentPane);
        //设置字体
        Font btnFont = new Font("黑体", Font.PLAIN, 20);
        searchTxt.setPreferredSize(new Dimension(80, 30));
        searchTxt.setFont(btnFont);
        addBtn.setFont(btnFont);
        updateBtn.setFont(btnFont);
        //delBtn.setFont(btnFont);
        searchBtn.setFont(btnFont);
        preBtn.setFont(btnFont);
        nextBtn.setFont(btnFont);
        returnBtn.setFont(btnFont);

        //设置监听器
        addBtn.addActionListener(mainViewHandler);
        //delBtn.addActionListener(mainViewHandler);
        updateBtn.addActionListener(mainViewHandler);
        searchBtn.addActionListener(mainViewHandler);
        returnBtn.addActionListener(mainViewHandler);

        //设置窗体图标
        URL resource = JframeTest.class.getClassLoader().getResource("main/resources/two.png");
        Image image = new ImageIcon(resource).getImage();
        setIconImage(image);
        //根据屏幕大小设置主界面大小
        setBounds(DimensionUtil.getBounds());
        //设置窗体完全充满整个屏幕的可见大小
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //居中
        setLocationRelativeTo(null);
        //大小不可改变
        setResizable(true);
        //关闭退出程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置可见
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainView();
    }

    public JTextField getSearchTxt() {
        return searchTxt;
    }

    private void layoutCenter(Container contentPane) {

        //数据库连接
        Vector<Vector<Object>> data = new Vector<>();
        DoctorSqlAction doctorSqlAction = new DoctorSqlAction();
        data = doctorSqlAction.getData();

        //建表
        MainViewTableModel mainViewTableModel = MainViewTableModel.assembleModel(data);
        mainViewTable.setModel(mainViewTableModel);
        mainViewTable.renderRule();
        JScrollPane jScrollPane = new JScrollPane(mainViewTable);
        contentPane.add(jScrollPane, BorderLayout.CENTER);
    }

    private void layoutSouth(Container contentPane) {
        southPanel.add(preBtn);
        southPanel.add(nextBtn);
        southPanel.setPreferredSize(new Dimension(0, 80));
        springLayout.putConstraint(springLayout.WEST, preBtn, 40, springLayout.WEST, southPanel);
        springLayout.putConstraint(springLayout.SOUTH, preBtn, -20, springLayout.SOUTH, southPanel);
        springLayout.putConstraint(springLayout.EAST, nextBtn, -40, springLayout.EAST, southPanel);
        springLayout.putConstraint(springLayout.SOUTH, nextBtn, -20, springLayout.SOUTH, southPanel);
        contentPane.add(southPanel, BorderLayout.SOUTH);
    }

    private void layoutNorth(Container contentPane) {
        northPanel.add(addBtn);
        northPanel.add(updateBtn);
        //northPanel.add(delBtn);
        northPanel.add(searchTxt);
        northPanel.add(searchBtn);
        northPanel.add(returnBtn);
        contentPane.add(northPanel, BorderLayout.NORTH);
    }

}
