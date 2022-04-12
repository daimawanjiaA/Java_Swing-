package main.java.EMRView.ext.AdminSonView;

import main.java.EMRView.ext.Table_mo.MTable;
import main.java.EMRView.ext.Table_mo.MTableModel;
import main.java.SqlAction.AdminSqlService.DoctorIfoAction;
import main.java.handler.Adminhandler.SonDoctorhandler.DoctorIfoHandler;
import main.java.service.impl.AdminService;
import test.java.one.JframeTest;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Vector;

public class DoctorIfo extends JFrame {
    JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 30));

    JButton addBtn = new JButton("增加");
    JButton updateBtn = new JButton("修改");
    JButton delBtn = new JButton("删除");
    JTextField searchTxt = new JTextField(15);
    JButton searchBtn = new JButton("查询(姓名\\编号)");
    JButton returnBtn = new JButton("返回");
    JButton printBtn = new JButton("打印");
    SpringLayout springLayout = new SpringLayout();
    JPanel southPanel = new JPanel(springLayout);

    JButton preBtn = new JButton("上一页");
    JButton nextBtn = new JButton("下一页");
    MTable mTable = new MTable();
    //监听器
    DoctorIfoHandler doctorIfoHandler = new DoctorIfoHandler(this);

    public DoctorIfo() {
        super("医生信息管理");
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
        delBtn.setFont(btnFont);
        searchBtn.setFont(btnFont);
        printBtn.setFont(btnFont);
        nextBtn.setFont(btnFont);
        preBtn.setFont(btnFont);
        returnBtn.setFont(btnFont);

        //设置监听器
        addBtn.addActionListener(doctorIfoHandler);
        delBtn.addActionListener(doctorIfoHandler);
        updateBtn.addActionListener(doctorIfoHandler);
        searchBtn.addActionListener(doctorIfoHandler);
        returnBtn.addActionListener(doctorIfoHandler);
        printBtn.addActionListener(doctorIfoHandler);

        //设置窗体图标
        URL resource = JframeTest.class.getClassLoader().getResource("main/resources/two.png");
        Image image = new ImageIcon(resource).getImage();
        setIconImage(image);
        setSize(new Dimension(1000, 600));
        //根据屏幕大小设置主界面大小
        //setBounds(DimensionUtil.getBounds());
        //设置窗体完全充满整个屏幕的可见大小
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
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
        new DoctorIfo();
    }

    public JTextField getSearchTxt() {
        return searchTxt;
    }

    private void layoutCenter(Container contentPane) {


        Vector<Vector<Object>> data = new Vector<>();

        Vector<String> rowVector0 = new Vector<>();
        rowVector0.addElement("医生编号");
        rowVector0.addElement("医生姓名");
        rowVector0.addElement("医生电话");
        rowVector0.addElement("所属科室");
        rowVector0.addElement("用户密码");

        AdminService adminService = new AdminService();
        adminService.startservice();

        DoctorIfoAction doctorIfoAction = new DoctorIfoAction();
        data = doctorIfoAction.getData();

        MTableModel mTableModel = new MTableModel(rowVector0);
        mTableModel = mTableModel.assembleModel(data);

        mTable.setModel(mTableModel);
        mTable.renderRule(mTableModel);
        JScrollPane jScrollPane = new JScrollPane(mTable);
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
        northPanel.add(delBtn);
        northPanel.add(searchTxt);
        northPanel.add(searchBtn);
        northPanel.add(returnBtn);
        northPanel.add(printBtn);

        contentPane.add(northPanel, BorderLayout.NORTH);
    }

    public MTable getmTable() {
        return mTable;
    }


}
