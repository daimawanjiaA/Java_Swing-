package main.java.handler.Adminhandler.SonDoctorhandler;

import main.java.EMRView.Operation_Panel.AdminSonPanel.SonDoctorInfoPanel.AdminDoctorAdd;
import main.java.SqlAction.AdminSqlService.DoctorIfoAction;
import main.java.entity.DoctorDO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SonDoctorAddHandler implements ActionListener {
    AdminDoctorAdd adminDoctorAdd;

    public SonDoctorAddHandler(AdminDoctorAdd adminDoctorAdd) {
        this.adminDoctorAdd = adminDoctorAdd;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Boolean flag = false;
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        if (text.equals("确认")) {

            String Dno = adminDoctorAdd.getDnofield().getText();
            String Dname = adminDoctorAdd.getDnamefield().getText();
            String Dphone = adminDoctorAdd.getDphonefield().getText();
            String Oname = adminDoctorAdd.getOnamefield().getText();
            String pwd = adminDoctorAdd.getPwdfield().getText();
            if (Dno.equals("") || "".equals(Dno.trim()) ||
                    Dname.equals("") || "".equals(Dname.trim()) ||
                    Dphone.equals("") || "".equals(Dphone.trim()) ||
                    Oname.equals("") || "".equals(Oname.trim()) ||
                    pwd.equals("")) {
                JOptionPane.showMessageDialog(adminDoctorAdd, "请检查是否有空输入！！");
            } else {
                DoctorIfoAction doctorIfoAction = new DoctorIfoAction();
                DoctorDO doctorDO = new DoctorDO();
                doctorDO.setDno(Dno);
                doctorDO.setDname(Dname);
                doctorDO.setDphone(Dphone);
                doctorDO.setOname(Oname);
                doctorDO.setPassword(pwd);
                flag = doctorIfoAction.add(doctorDO);
                if (!flag) {
                    //给出 弹框提示
                    JOptionPane.showMessageDialog(adminDoctorAdd, "输入内容有误,请校对内容后重新输入！！");
                } else {
                    JOptionPane.showMessageDialog(adminDoctorAdd, "添加成功！！");
                    adminDoctorAdd.flag = true;
                }
            }
        } else if (text.equals("重置")) {
            adminDoctorAdd.getDnofield().setText("");
            adminDoctorAdd.getDnamefield().setText("");
            adminDoctorAdd.getDphonefield().setText("");
            adminDoctorAdd.getOnamefield().setText("");
            adminDoctorAdd.getPwdfield().setText("");
        }

    }
}
