package main.java.handler.Patienthandler;

import main.java.EMRView.Operation_Panel.PatientSonPanel.PatientNameUpdate;
import main.java.SqlAction.PatientSqlAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatientNameUpdateHandler implements ActionListener {

    PatientNameUpdate patientNameUpdate;

    public PatientNameUpdateHandler(PatientNameUpdate patientNameUpdate) {
        this.patientNameUpdate = patientNameUpdate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        if (text.equals("确定")) {
            String strdel = patientNameUpdate.getPnamefield().getText();
            if (strdel.trim().equals("")) {
                JOptionPane.showMessageDialog(patientNameUpdate, "请输入新密码>0<");
            } else {
                PatientSqlAction patientSqlAction = new PatientSqlAction();

                if (patientSqlAction.UpdatePname(patientNameUpdate.getPno(), strdel)) {
                    patientNameUpdate.flag = true;
                    patientNameUpdate.dispose();
                }
            }
        } else if (text.equals("重置")) {
            patientNameUpdate.getPnamefield().setText("");
        }
        String str = patientNameUpdate.getPnamefield().getText();
    }
}