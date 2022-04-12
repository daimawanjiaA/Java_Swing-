package main.java.handler.Adminhandler.SonPatienthandler;

import main.java.EMRView.Operation_Panel.AdminSonPanel.SonPatientInfoPanel.AdminPatientAdd;
import main.java.SqlAction.AdminSqlService.PatientIfoAction;
import main.java.entity.PatientDO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SonPatientAddHandler implements ActionListener {
    AdminPatientAdd adminPatientAdd;

    public SonPatientAddHandler(AdminPatientAdd adminPatientAdd) {
        this.adminPatientAdd = adminPatientAdd;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Boolean flag = false;
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        if (text.equals("确认")) {

            String Pno = adminPatientAdd.getPnofield().getText();
            String Pname = adminPatientAdd.getPnamefield().getText();
            String Oname = adminPatientAdd.getOnamefield().getText();
            String Time = adminPatientAdd.getTimefield().getText();
            String pwd = adminPatientAdd.getPwdfield().getText();
            if (Pno.equals("") || "".equals(Pno.trim()) ||
                    Pname.equals("") || "".equals(Pname.trim()) ||
                    Oname.equals("") || "".equals(Oname.trim()) ||
                    Time.equals("") || "".equals(Time.trim()) ||
                    pwd.equals(" ")
            ) {
                JOptionPane.showMessageDialog(adminPatientAdd, "请检查是否有空输入！！");
            } else {
                PatientIfoAction patientIfoAction = new PatientIfoAction();
                PatientDO patientDO = new PatientDO();
                patientDO.setPno(Pno);
                patientDO.setPname(Pname);
                patientDO.setOname(Oname);
                patientDO.setTime(Time);
                patientDO.setPassword(pwd);
                flag = patientIfoAction.add(patientDO);
                if (!flag) {
                    //给出 弹框提示
                    JOptionPane.showMessageDialog(adminPatientAdd, "输入内容有误,请校对内容后重新输入！！");
                } else {
                    JOptionPane.showMessageDialog(adminPatientAdd, "添加成功！！");
                    adminPatientAdd.flag = true;
                }
            }
        } else if (text.equals("重置")) {
            adminPatientAdd.getPnamefield().setText("");
            adminPatientAdd.getPnofield().setText("");
            adminPatientAdd.getOnamefield().setText("");
            adminPatientAdd.getTimefield().setText("");
            adminPatientAdd.getPwdfield().setText("");
        }

    }
}

