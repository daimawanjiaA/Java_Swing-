package main.java.handler.Patienthandler;

import main.java.EMRView.Operation_Panel.PatientSonPanel.PatientPaswordUpdate;
import main.java.SqlAction.PatientSqlAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatientPwdUpdateHandler implements ActionListener {
    PatientPaswordUpdate patientPaswordUpdate;

    public PatientPwdUpdateHandler(PatientPaswordUpdate patientPaswordUpdate) {
        this.patientPaswordUpdate = patientPaswordUpdate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        if (text.equals("确定")) {
            String strdel = patientPaswordUpdate.getPwdfield().getText();

            if (strdel.trim().equals("")) {
                JOptionPane.showMessageDialog(patientPaswordUpdate, "请输入新姓名>0<");
            } else {
                PatientSqlAction patientSqlAction = new PatientSqlAction();

                if (patientSqlAction.UpdatePwd(patientPaswordUpdate.getPno(), strdel)) {
                    patientPaswordUpdate.flag = true;
                    patientPaswordUpdate.dispose();
                }
            }
        } else if (text.equals("重置")) {
            patientPaswordUpdate.getPwdfield().setText("");
        }
        String str = patientPaswordUpdate.getPwdfield().getText();

    }
}
