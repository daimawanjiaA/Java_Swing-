package main.java.handler.Adminhandler.SonDoctorhandler;

import main.java.EMRView.Operation_Panel.AdminSonPanel.SonDoctorInfoPanel.AdminDoctorDel;
import main.java.SqlAction.AdminSqlService.DoctorIfoAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SonDoctorDeleteHandler implements ActionListener {
    AdminDoctorDel adminDoctorDel;

    public SonDoctorDeleteHandler(AdminDoctorDel adminDoctorDel) {
        this.adminDoctorDel = adminDoctorDel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        if (text.equals("确定")) {
            String strdel = adminDoctorDel.getDnofield().getText();
            if (strdel.equals("")) {
                JOptionPane.showMessageDialog(adminDoctorDel, "请输入所删除医生编号！！");
            } else {

                DoctorIfoAction doctorIfoAction = new DoctorIfoAction();
                if (doctorIfoAction.delete(strdel)) {
                    JOptionPane.showMessageDialog(adminDoctorDel, "操作成功");
                    adminDoctorDel.flag = true;
                    adminDoctorDel.dispose();
                } else {

                    JOptionPane.showMessageDialog(adminDoctorDel, "删除失败，请重新输入！！");
                }
            }
        } else if (text.equals("重置")) {
            adminDoctorDel.getDnofield().setText("");
        }
        String str = adminDoctorDel.getDnofield().getText();

    }
}
