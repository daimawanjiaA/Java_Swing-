package main.java.EMRView.ext.Doctor;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Vector;

public class MainViewTable extends JTable {

    public MainViewTable() {


        //设置表头字体
        JTableHeader tableHeader = getTableHeader();
        tableHeader.setFont(new Font("宋体", Font.BOLD, 24));
        tableHeader.setForeground(Color.RED);
        //设置表格字体
        setFont(new Font("黑体", Font.PLAIN, 20));
        setForeground(Color.black);
        setGridColor(Color.BLACK);
        setRowHeight(30);
        //设置多行选择
        getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

    }


    public void renderRule() {
        //重置表格列的渲染方式
        Vector<String> columns = MainViewTableModel.getColumns();
        MainViewCellRender render = new MainViewCellRender();
        for (int i = 0; i < columns.size(); i++) {
            //getColumn(columns.get(i)返回类型是 String 需要的类型是column
            TableColumn column = getColumn(columns.get(i));
            column.setCellRenderer(render);
            if (i == 0) {
                column.setPreferredWidth(140);
                column.setMaxWidth(140);
                column.setResizable(false);
            }

        }
    }

}
