package main.java.handler.Patienthandler;

import main.java.EMRView.Operation_Panel.PatientSonPanel.PatientEMRInfoPanel;
import main.java.util.ExcelExporter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class PatientEMRIfoHandler implements ActionListener {
    PatientEMRInfoPanel patientEMRInfoPanel;

    public PatientEMRIfoHandler(PatientEMRInfoPanel patientEMRInfoPanel) {
        this.patientEMRInfoPanel = patientEMRInfoPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();

        if ("打印表格信息".equals(text)) {
            try {
                ExcelExporter exp = new ExcelExporter();
                exp.exportTable(patientEMRInfoPanel.getMainViewTable(), new File("Patient_" + patientEMRInfoPanel.getPno() + ".xls"));
            } catch (IOException ioException) {
                System.out.println("打印失败");
                ioException.printStackTrace();
            }
        }
    }
}

