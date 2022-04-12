package main.java.handler.Patienthandler;

import main.java.EMRView.Operation_Panel.PatientSonPanel.InfomationSonPanel;
import main.java.EMRView.Operation_Panel.PatientSonPanel.PatientNameUpdate;
import main.java.EMRView.Operation_Panel.PatientSonPanel.PatientPaswordUpdate;
import main.java.EMRView.PatientView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrivateIfoViewHandler implements ActionListener {
    InfomationSonPanel infomationSonPanel;

    public PrivateIfoViewHandler(InfomationSonPanel infomationSonPanel) {
        this.infomationSonPanel = infomationSonPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jbutton = (JButton) e.getSource();
        String Pno = infomationSonPanel.getPno().getText();
        String text = jbutton.getText();
        if (text.equals("编辑")) {
            PatientNameUpdate pa = new PatientNameUpdate(infomationSonPanel, "信息修改", true, Pno);

            if (pa.flag) {
                JOptionPane.showMessageDialog(infomationSonPanel, "修改成功");
                infomationSonPanel.dispose();
                new InfomationSonPanel(null, "个人信息中心", true, infomationSonPanel.getPno().getText());
            }
        } else if (text.equals("返回")) {

            infomationSonPanel.dispose();
            new PatientView(Pno);
        } else if (text.equals("更改密码")) {
            PatientPaswordUpdate patientNameUpdate = new PatientPaswordUpdate(infomationSonPanel, "更改密码", true, Pno);

            if (patientNameUpdate.flag) {
                JOptionPane.showMessageDialog(infomationSonPanel, "修改成功");
                infomationSonPanel.dispose();
                new InfomationSonPanel(null, "个人信息中心", true, infomationSonPanel.getPno().getText());
            }
        }


    }
}
