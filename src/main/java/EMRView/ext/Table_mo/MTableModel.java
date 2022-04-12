package main.java.EMRView.ext.Table_mo;

import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class MTableModel extends DefaultTableModel {

    private static MTableModel asssemblemodel = new MTableModel();
    private static Vector<String> columns = new Vector<>();


    public MTableModel() {
    }

    public MTableModel(Vector<String> columns) {
        super(null, columns);
        this.columns = columns;
    }

    public Vector<String> getColumns() {
        return columns;
    }

    public MTableModel assembleModel(Vector<Vector<Object>> data) {
        asssemblemodel.setDataVector(data, columns);
        return asssemblemodel;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
