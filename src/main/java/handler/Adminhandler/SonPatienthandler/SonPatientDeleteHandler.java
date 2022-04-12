package main.java.handler.Adminhandler.SonPatienthandler;

import main.java.EMRView.Operation_Panel.AdminSonPanel.SonPatientInfoPanel.AdminPatientDel;
import main.java.SqlAction.AdminSqlService.PatientIfoAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SonPatientDeleteHandler implements ActionListener {

    AdminPatientDel adminPatientDel;

    public SonPatientDeleteHandler(AdminPatientDel adminPatientDel) {
        this.adminPatientDel = adminPatientDel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        if (text.equals("确定")) {
            String strdel = adminPatientDel.getDnofield().getText();
            if (strdel.equals("")) {
                JOptionPane.showMessageDialog(adminPatientDel, "请输入所删除患者编号！！");
            } else {
                PatientIfoAction patientIfoAction = new PatientIfoAction();
                if (patientIfoAction.delete(strdel)) {
                    JOptionPane.showMessageDialog(adminPatientDel, "操作成功");
                    adminPatientDel.flag = true;
                    adminPatientDel.dispose();
                } else {

                    JOptionPane.showMessageDialog(adminPatientDel, "删除失败，请重新输入！！");
                }
            }
        } else if (text.equals("重置")) {
            adminPatientDel.getDnofield().setText("");
        }
        String str = adminPatientDel.getDnofield().getText();

    }

}
