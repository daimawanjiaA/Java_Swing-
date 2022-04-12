package main.java.handler.Doctorhandler;

import main.java.EMRView.Operation_Panel.DoctorSonPanel.DoctorEMRUpdate;
import main.java.SqlAction.DoctorSqlAction;
import main.java.entity.MrDO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EMRUpdateHandler implements ActionListener {
    DoctorEMRUpdate doctorEmrUpdate;

    public EMRUpdateHandler(DoctorEMRUpdate doctorEmrUpdate) {
        this.doctorEmrUpdate = doctorEmrUpdate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Boolean flag = false;
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        if (text.equals("编辑")) {

            String Dno = doctorEmrUpdate.getDnofield().getText();
            String Pno = doctorEmrUpdate.getPnofield().getText();
            String Disease = doctorEmrUpdate.getIllfield().getText();
            String Result = doctorEmrUpdate.getResfield().getText();
            String Treatment = doctorEmrUpdate.getTreatfield().getText();
            String MRno = doctorEmrUpdate.getMRnofield().getText();
            if ("".equals(MRno.trim()) ||
                    MRno.equals("")) {
                JOptionPane.showMessageDialog(doctorEmrUpdate, "请输入要更改病历号！！");
            } else if (Dno.equals("") || "".equals(Dno.trim()) ||
                    Pno.equals("") || "".equals(Pno.trim()) ||
                    Disease.equals("") || "".equals(Disease.trim())
            ) {
                JOptionPane.showMessageDialog(doctorEmrUpdate, "请检查是否有空输入！！");
            } else {
                DoctorSqlAction doctorSqlAction = new DoctorSqlAction();
                MrDO mrDO = new MrDO();
                mrDO.setDno(Dno);
                mrDO.setPno(Pno);
                mrDO.setDisease(Disease);
                mrDO.setResult(Result);
                mrDO.setTreatment(Treatment);
                mrDO.setMRno(MRno);
                flag = doctorSqlAction.updata(mrDO);
                if (!flag) {
                    //给出 弹框提示
                    JOptionPane.showMessageDialog(doctorEmrUpdate, "输入内容有误,请校对内容后重新输入！！");
                } else {
                    JOptionPane.showMessageDialog(doctorEmrUpdate, "修改成功！！");
                    doctorEmrUpdate.flag = true;
                }
            }
        } else if (text.equals("重置")) {
            doctorEmrUpdate.getDnofield().setText("");
            doctorEmrUpdate.getIllfield().setText("");
            doctorEmrUpdate.getPnofield().setText("");
            doctorEmrUpdate.getResfield().setText("");
            doctorEmrUpdate.getTreatfield().setText("");
        }

    }
}
