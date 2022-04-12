package main.java.handler.Adminhandler.SonDoctorhandler;

import main.java.EMRView.Operation_Panel.AdminSonPanel.SonDoctorInfoPanel.AdminDoctorUpdate;
import main.java.SqlAction.AdminSqlService.DoctorIfoAction;
import main.java.entity.DoctorDO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SonDoctorUpdateHandler implements ActionListener {

    AdminDoctorUpdate adminDoctorUpdate;

    public SonDoctorUpdateHandler(AdminDoctorUpdate adminDoctorUpdate) {
        this.adminDoctorUpdate = adminDoctorUpdate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Boolean flag = false;
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        if (text.equals("编辑")) {

            String Dno = adminDoctorUpdate.getDnofield().getText();
            String Dname = adminDoctorUpdate.getDnamefield().getText();
            String Dphone = adminDoctorUpdate.getDphonefield().getText();
            String Oname = adminDoctorUpdate.getOnamefield().getText();
            String pwd = adminDoctorUpdate.getPwdfield().getText();
            if (Dno.equals("") || "".equals(Dno.trim())) {
                JOptionPane.showMessageDialog(adminDoctorUpdate, "请输入要修改医生信息的医生编号!!!");
            } else if
            (
                    Dname.equals("") || "".equals(Dname.trim()) ||
                            Dphone.equals("") || "".equals(Dphone.trim()) ||
                            Oname.equals("") || "".equals(Oname.trim()) ||
                            pwd.equals("")) {
                JOptionPane.showMessageDialog(adminDoctorUpdate, "请检查是否有空输入！！");
            } else {
                DoctorIfoAction doctorIfoAction = new DoctorIfoAction();
                DoctorDO doctorDO = new DoctorDO();
                doctorDO.setDno(Dno);
                doctorDO.setDname(Dname);
                doctorDO.setDphone(Dphone);
                doctorDO.setOname(Oname);
                doctorDO.setPassword(pwd);
                flag = doctorIfoAction.update(doctorDO);
                if (!flag) {
                    //给出 弹框提示
                    JOptionPane.showMessageDialog(adminDoctorUpdate, "输入内容有误,请校对内容后重新输入！！");
                } else {
                    JOptionPane.showMessageDialog(adminDoctorUpdate, "修改成功！！");
                    adminDoctorUpdate.flag = true;
                }
            }
        } else if (text.equals("重置")) {

            adminDoctorUpdate.getDnamefield().setText("");
            adminDoctorUpdate.getDphonefield().setText("");
            adminDoctorUpdate.getOnamefield().setText("");
            adminDoctorUpdate.getPwdfield().setText("");
        }

    }
}
