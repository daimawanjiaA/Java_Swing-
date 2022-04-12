package main.java.handler.Adminhandler.SonEMRhandler;

import main.java.EMRView.Operation_Panel.AdminSonPanel.SonEmrInfoPanel.AdminEmrAdd;
import main.java.SqlAction.AdminSqlService.EMRIfoAction;
import main.java.entity.MrDO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SonEmrAddHandler implements ActionListener {
    AdminEmrAdd adminEmrAdd;

    public SonEmrAddHandler(AdminEmrAdd adminEmrAdd) {
        this.adminEmrAdd = adminEmrAdd;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Boolean flag = false;
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        if (text.equals("确认")) {

            String Dno = adminEmrAdd.getDnofield().getText();
            String Pno = adminEmrAdd.getPnofield().getText();
            String Disease = adminEmrAdd.getIllfield().getText();
            String Result = adminEmrAdd.getResfield().getText();
            String Treatment = adminEmrAdd.getTreatfield().getText();
            String MRno = adminEmrAdd.getMRnofield().getText();
            if (Dno.equals("") || "".equals(Dno.trim()) ||
                    Pno.equals("") || "".equals(Pno.trim()) ||
                    MRno.equals("") || "".equals(MRno.trim()) ||
                    Disease.equals("") || "".equals(Disease.trim())
            ) {
                JOptionPane.showMessageDialog(adminEmrAdd, "请检查是否有空输入！！");
            } else {
                EMRIfoAction emrIfoAction = new EMRIfoAction();
                MrDO mrDO = new MrDO();
                mrDO.setDno(Dno);
                mrDO.setPno(Pno);
                mrDO.setDisease(Disease);
                mrDO.setResult(Result);
                mrDO.setTreatment(Treatment);
                mrDO.setMRno(MRno);
                flag = emrIfoAction.add(mrDO);
                if (!flag) {
                    //给出 弹框提示
                    JOptionPane.showMessageDialog(adminEmrAdd, "输入内容有误,请校对内容后重新输入！！");
                } else {
                    JOptionPane.showMessageDialog(adminEmrAdd, "添加成功！！");
                    adminEmrAdd.flag = true;
                }
            }
        } else if (text.equals("重置")) {
            adminEmrAdd.getDnofield().setText("");
            adminEmrAdd.getIllfield().setText("");
            adminEmrAdd.getPnofield().setText("");
            adminEmrAdd.getResfield().setText("");
            adminEmrAdd.getTreatfield().setText("");
            adminEmrAdd.getMRnofield().setText("");
        }

    }
}
