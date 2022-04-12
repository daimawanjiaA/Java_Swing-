package main.java.EMRView.ext.Doctor;

import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class MainViewTableModel extends DefaultTableModel {
    static Vector<String> columns = new Vector<>();
    private static MainViewTableModel asssemblemodel = new MainViewTableModel();

    static {
        columns.addElement("病历号");
        columns.addElement("患者编号");
        columns.addElement("医生编号");
        columns.addElement("诊断疾病");
        columns.addElement("出院结果");
        columns.addElement("治疗经过");

    }

    public MainViewTableModel() {
        super(null, columns);
    }

    public static Vector<String> getColumns() {
        return columns;
    }

    public static MainViewTableModel assembleModel(Vector<Vector<Object>> data) {
        asssemblemodel.setDataVector(data, columns);
        return asssemblemodel;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
