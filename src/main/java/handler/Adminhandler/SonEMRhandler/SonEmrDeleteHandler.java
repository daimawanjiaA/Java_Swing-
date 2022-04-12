package main.java.handler.Adminhandler.SonEMRhandler;

import main.java.EMRView.Operation_Panel.AdminSonPanel.SonEmrInfoPanel.AdminEmrDel;
import main.java.SqlAction.AdminSqlService.EMRIfoAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SonEmrDeleteHandler implements ActionListener {

    AdminEmrDel adminEmrDel;

    public SonEmrDeleteHandler(AdminEmrDel adminEmrDel) {
        this.adminEmrDel = adminEmrDel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        if (text.equals("确定")) {
            String strdel = adminEmrDel.getDnofield().getText();
            if (strdel.equals("")) {
                JOptionPane.showMessageDialog(adminEmrDel, "请输入所删除病历编号！！");
            } else {
                EMRIfoAction emrIfoAction = new EMRIfoAction();
                if (emrIfoAction.delete(strdel)) {
                    JOptionPane.showMessageDialog(adminEmrDel, "操作成功");
                    adminEmrDel.flag = true;
                    adminEmrDel.dispose();
                } else {

                    JOptionPane.showMessageDialog(adminEmrDel, "删除失败，请重新输入！！");
                }
            }
        } else if (text.equals("重置")) {
            adminEmrDel.getDnofield().setText("");
        }
        String str = adminEmrDel.getDnofield().getText();

    }

}
