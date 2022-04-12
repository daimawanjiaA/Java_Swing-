package test.java.EMR;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.Vector;

public class JtableDemo extends JFrame {

    public JtableDemo() {
        super("病历单");


        Vector<Vector<Object>> data = new Vector<>();

        Vector<Object> rowVector1 = new Vector<>();
        rowVector1.addElement("001");
        rowVector1.addElement("001");
        rowVector1.addElement("001");
        rowVector1.addElement("肺炎");
        rowVector1.addElement("治疗成功");
        rowVector1.addElement("无");

        Vector<Object> rowVector2 = new Vector<>();
        rowVector2.addElement("002");
        rowVector2.addElement("002");
        rowVector2.addElement("002");
        rowVector2.addElement("候炎");
        rowVector2.addElement("治疗成功");
        rowVector2.addElement("无");

        Vector<Object> rowVector3 = new Vector<>();
        rowVector3.addElement("002");
        rowVector3.addElement("002");
        rowVector3.addElement("002");
        rowVector3.addElement("候炎");
        rowVector3.addElement("治疗成功");
        rowVector3.addElement("无");

        data.add(rowVector1);
        data.add(rowVector2);
        data.add(rowVector3);

        //tablemodel:和jtable关联后，之后只需要更新model就可以把数据的变化反应到jtable中
        TableModel emTableModel = EMTablemodel.assembleModel(data);
        //jtable和tablemodel关联
        JTable jTable = new JTable(emTableModel);
        //设置表头字体
        JTableHeader tableHeader = jTable.getTableHeader();
        tableHeader.setFont(new Font("宋体", Font.BOLD, 26));
        tableHeader.setForeground(Color.RED);
        //设置表格字体
        jTable.setFont(new Font("黑体", Font.PLAIN, 24));
        jTable.setForeground(Color.black);
        jTable.setGridColor(Color.BLACK);
        jTable.setRowHeight(30);
        //设置多行选择
        jTable.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        //重置表格列的渲染方式
        Vector<String> columns = EMTablemodel.getColumns();
        EMCellRender emCellRender = new EMCellRender();
        for (int i = 0; i < columns.size(); i++) {
            //getColumn(columns.get(i)返回类型是 String 需要的类型是column
            TableColumn column = jTable.getColumn(columns.get(i));
            column.setCellRenderer(emCellRender);
            if (i == 0) {
                column.setPreferredWidth(30);
                column.setResizable(false);
            }
        }


        Container contentPane = getContentPane();
        //需要将表格放在滚动面板上，表头会自动显示，而且方便换页
        JScrollPane jScrollPane = new JScrollPane(jTable);
        contentPane.add(jScrollPane);

        setSize(900, 500);
        //居中
        setLocationRelativeTo(null);
        //关闭退出程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //大小不可改变
        //setResizable(false);
        //设置可见
        setVisible(true);


    }

    public static void main(String[] args) {
        new JtableDemo();
    }


}


class EMCellRender extends DefaultTableCellRenderer {
    //在每一行每一列显示之前都会调用----
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (row % 2 == 0) {
            setBackground(Color.LIGHT_GRAY);
        } else {
            setBackground(Color.WHITE);
        }
        setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}//默认实现了

//自定义tablemodel
class EMTablemodel extends DefaultTableModel {

    static Vector<String> columns = new Vector<>();
    private static EMTablemodel asssemblemodel = new EMTablemodel();

    static {
        columns.addElement("病历号");
        columns.addElement("患者编号");
        columns.addElement("医生编号");
        columns.addElement("诊断疾病");
        columns.addElement("出院结果");
        columns.addElement("治疗经过");

    }

    public EMTablemodel() {
        super(null, columns);
    }

    public static Vector<String> getColumns() {
        return columns;
    }

    public static EMTablemodel assembleModel(Vector<Vector<Object>> data) {
        asssemblemodel.setDataVector(data, columns);
        return asssemblemodel;
    }


    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

}