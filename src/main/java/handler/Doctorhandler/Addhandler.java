package main.java.handler.Doctorhandler;

import main.java.EMRView.Operation_Panel.DoctorSonPanel.DoctorEMRAdd;
import main.java.SqlAction.DoctorSqlAction;
import main.java.entity.MrDO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Addhandler implements ActionListener {

    DoctorEMRAdd doctorEmrAdd;

    public Addhandler(DoctorEMRAdd doctorEmrAdd) {
        this.doctorEmrAdd = doctorEmrAdd;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Boolean flag = false;
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        if (text.equals("确认")) {

            String Dno = doctorEmrAdd.getDnofield().getText();
            String Pno = doctorEmrAdd.getPnofield().getText();
            String Disease = doctorEmrAdd.getIllfield().getText();
            String Result = doctorEmrAdd.getResfield().getText();
            String Treatment = doctorEmrAdd.getTreatfield().getText();
            String MRno = doctorEmrAdd.getMRnofield().getText();
            if (Dno.equals("") || "".equals(Dno.trim()) ||
                    Pno.equals("") || "".equals(Pno.trim()) ||
                    MRno.equals("") || "".equals(MRno.trim()) ||
                    Disease.equals("") || "".equals(Disease.trim())
            ) {
                JOptionPane.showMessageDialog(doctorEmrAdd, "请检查是否有空输入！！");
            } else {
                DoctorSqlAction doctorSqlAction = new DoctorSqlAction();
                MrDO mrDO = new MrDO();
                mrDO.setDno(Dno);
                mrDO.setPno(Pno);
                mrDO.setDisease(Disease);
                mrDO.setResult(Result);
                mrDO.setTreatment(Treatment);
                mrDO.setMRno(MRno);
                flag = doctorSqlAction.add(mrDO);
                if (!flag) {
                    //给出 弹框提示
                    JOptionPane.showMessageDialog(doctorEmrAdd, "输入内容有误,请校对内容后重新输入！！");
                } else {
                    JOptionPane.showMessageDialog(doctorEmrAdd, "添加成功！！");
                    doctorEmrAdd.flag = true;
                }
            }
        } else if (text.equals("重置")) {
            doctorEmrAdd.getDnofield().setText("");
            doctorEmrAdd.getIllfield().setText("");
            doctorEmrAdd.getPnofield().setText("");
            doctorEmrAdd.getResfield().setText("");
            doctorEmrAdd.getTreatfield().setText("");
            doctorEmrAdd.getMRnofield().setText("");
        }

    }
}
