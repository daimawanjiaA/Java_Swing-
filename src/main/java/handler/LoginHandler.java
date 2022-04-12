package main.java.handler;


import main.java.EMRView.*;
import main.java.entity.AdminDO;
import main.java.entity.DoctorDO;
import main.java.entity.PatientDO;
import main.java.service.impl.AdminService;
import main.java.service.impl.DoctorService;
import main.java.service.impl.PatientService;
import main.java.util.DBUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginHandler implements ActionListener {

    private LoginView loginview;

    public LoginHandler(LoginView loginview) {
        this.loginview = loginview;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        String user = loginview.getUseField().getText();
        char[] chars = loginview.getPassField().getPassword();
        if ("重置".equals(text)) {
            loginview.getUseField().setText("");
            loginview.getPassField().setText("");
        } else if ("登录".equals(text)) {
            String password = new String(chars);

            if (loginview.getValidField().getText().trim().equals("")) {
                JOptionPane.showMessageDialog(loginview, "验证码不可为空！！");
            } else if (loginview.isValidCodeRight()) {
                if (user.equals(null) || "".equals(user.trim())
                        || password.equals(null) || "".equals(password.trim())) {
                    JOptionPane.showMessageDialog(loginview, "用户或密码不能为空");
                } else {//查询id
                    boolean flag = false;

                    if (DBUtil.getKind() == 1) {
                        AdminDO adminDO = new AdminDO();
                        adminDO.setUsername(user);
                        adminDO.setPassward(new String(chars));
                        AdminService adminService = new AdminService();
                        if (adminService.validateAdmin(adminDO)) {
                            flag = true;
                            JOptionPane.showMessageDialog(loginview, "登录成功!!");
                            //开启服务
                            adminService.startservice();

                            new AdminView();
                            loginview.dispose();
                        }
                    } else if (DBUtil.getKind() == 2) {


                        PatientService patientService = new PatientService();
                        PatientDO patientDO = new PatientDO();
                        patientDO.setPno(user);
                        patientDO.setPassword(password);
                        if (patientService.validatePatient(patientDO)) {
                            flag = true;
                            JOptionPane.showMessageDialog(loginview, "登录成功!!");
                            //开启服务
                            patientService.startservice();

                            new PatientView(user);
                            loginview.dispose();
                        }
                    } else if (DBUtil.getKind() == 3) {

                        DoctorService doctorService = new DoctorService();
                        DoctorDO doctorDO = new DoctorDO();
                        doctorDO.setDno(user);
                        doctorDO.setPassword(password);
                        if (doctorService.validateDoctor(doctorDO)) {
                            flag = true;
                            JOptionPane.showMessageDialog(loginview, "登录成功!!");
                            //开启服务
                            doctorService.startservice();
                            new MainView();
                            loginview.dispose();
                        }
                    }
                    if (!flag) {
                        //给出 弹框提示
                        JOptionPane.showMessageDialog(loginview, "用户名密码错误!!");
                    }
                }

            } else {
                JOptionPane.showMessageDialog(loginview, "验证码错误！！");
                loginview.getValidCode().nextCode();
            }


        } else if ("返回".equals(text)) {
            new MenuView();
            loginview.dispose();
        }
    }
}
