package main.java.handler.Adminhandler;

import main.java.EMRView.AdminView;
import main.java.EMRView.MenuView;
import main.java.EMRView.ext.AdminSonView.DoctorIfo;
import main.java.EMRView.ext.AdminSonView.EmrIfo;
import main.java.EMRView.ext.AdminSonView.PatientIfo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminViewHandler implements ActionListener {

    private AdminView adminView;

    public AdminViewHandler(AdminView adminView) {
        this.adminView = adminView;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        if ("医生管理".equals(text)) {
            new DoctorIfo();
            adminView.dispose();
        } else if ("患者管理".equals(text)) {
            new PatientIfo();
            adminView.dispose();
        } else if ("病历管理".equals(text)) {
            new EmrIfo();
            adminView.dispose();
        } else if ("返回".equals(text)) {

            new MenuView();
            adminView.dispose();
        }
    }
}
