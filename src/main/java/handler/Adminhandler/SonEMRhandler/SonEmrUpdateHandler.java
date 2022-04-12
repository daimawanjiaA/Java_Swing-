package main.java.handler.Adminhandler.SonEMRhandler;

import main.java.EMRView.Operation_Panel.AdminSonPanel.SonEmrInfoPanel.AdminEmrUpdate;
import main.java.SqlAction.AdminSqlService.EMRIfoAction;
import main.java.entity.MrDO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SonEmrUpdateHandler implements ActionListener {
    AdminEmrUpdate adminEmrUpdate;

    public SonEmrUpdateHandler(AdminEmrUpdate adminEmrUpdate) {
        this.adminEmrUpdate = adminEmrUpdate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Boolean flag = false;
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        if (text.equals("编辑")) {

            String Dno = adminEmrUpdate.getDnofield().getText();
            String Pno = adminEmrUpdate.getPnofield().getText();
            String Disease = adminEmrUpdate.getIllfield().getText();
            String Result = adminEmrUpdate.getResfield().getText();
            String Treatment = adminEmrUpdate.getTreatfield().getText();
            String MRno = adminEmrUpdate.getMRnofield().getText();
            if ("".equals(MRno.trim()) ||
                    MRno.equals("")) {
                JOptionPane.showMessageDialog(adminEmrUpdate, "请输入要更改病历号！！");
            } else if (Dno.equals("") || "".equals(Dno.trim()) ||
                    Pno.equals("") || "".equals(Pno.trim()) ||
                    Disease.equals("") || "".equals(Disease.trim())
            ) {
                JOptionPane.showMessageDialog(adminEmrUpdate, "请检查是否有空输入！！");
            } else {
                EMRIfoAction emrIfoAction = new EMRIfoAction();
                MrDO mrDO = new MrDO();
                mrDO.setDno(Dno);
                mrDO.setPno(Pno);
                mrDO.setDisease(Disease);
                mrDO.setResult(Result);
                mrDO.setTreatment(Treatment);
                mrDO.setMRno(MRno);
                flag = emrIfoAction.update(mrDO);
                if (!flag) {
                    //给出 弹框提示
                    JOptionPane.showMessageDialog(adminEmrUpdate, "输入内容有误,请校对内容后重新输入！！");
                } else {
                    JOptionPane.showMessageDialog(adminEmrUpdate, "修改成功！！");
                    adminEmrUpdate.flag = true;
                }
            }
        } else if (text.equals("重置")) {
            adminEmrUpdate.getDnofield().setText("");
            adminEmrUpdate.getIllfield().setText("");
            adminEmrUpdate.getPnofield().setText("");
            adminEmrUpdate.getResfield().setText("");
            adminEmrUpdate.getTreatfield().setText("");
        }

    }
}