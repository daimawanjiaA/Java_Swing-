package main.java.handler.Adminhandler.SonPatienthandler;

import main.java.EMRView.Operation_Panel.AdminSonPanel.SonPatientInfoPanel.AdminPatientUpdate;
import main.java.SqlAction.AdminSqlService.PatientIfoAction;
import main.java.entity.PatientDO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SonPatientUpdateHandler implements ActionListener {

    AdminPatientUpdate adminPatientUpdate;

    public SonPatientUpdateHandler(AdminPatientUpdate adminDoctorUpdate) {
        this.adminPatientUpdate = adminDoctorUpdate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Boolean flag = false;
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        if (text.equals("编辑")) {

            String Pno = adminPatientUpdate.getPnofield().getText();
            String Pname = adminPatientUpdate.getPnamefield().getText();
            String Oname = adminPatientUpdate.getOnamefield().getText();
            String Time = adminPatientUpdate.getTimefield().getText();
            String pwd = adminPatientUpdate.getPwdfield().getText();
            if (Pno.equals("") || "".equals(Pno.trim())) {
                JOptionPane.showMessageDialog(adminPatientUpdate, "请输入要修改的患者信息的患者编号!!!");
            } else if (
                    Pname.equals("") || "".equals(Pname.trim()) ||
                            Oname.equals("") || "".equals(Oname.trim()) ||
                            Time.equals("") || "".equals(Time.trim()) ||
                            pwd.equals("")) {
                JOptionPane.showMessageDialog(adminPatientUpdate, "请检查是否有空输入！！");
            } else {
                PatientIfoAction patientIfoAction = new PatientIfoAction();
                PatientDO patientDO = new PatientDO();
                patientDO.setPno(Pno);
                patientDO.setPname(Pname);
                patientDO.setOname(Oname);
                patientDO.setTime(Time);
                patientDO.setPassword(pwd);
                flag = patientIfoAction.update(patientDO);
                if (!flag) {
                    //给出 弹框提示
                    JOptionPane.showMessageDialog(adminPatientUpdate, "输入内容有误,请校对内容后重新输入！！");
                } else {
                    JOptionPane.showMessageDialog(adminPatientUpdate, "修改成功！！");
                    adminPatientUpdate.flag = true;
                }
            }
        } else if (text.equals("重置")) {

            adminPatientUpdate.getPnamefield().setText("");
            adminPatientUpdate.getOnamefield().setText("");
            adminPatientUpdate.getTimefield().setText("");
            adminPatientUpdate.getPwdfield().setText("");
        }

    }

}