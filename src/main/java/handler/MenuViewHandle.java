package main.java.handler;

import main.java.EMRView.LoginView;
import main.java.EMRView.MenuView;
import main.java.util.DBUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuViewHandle implements ActionListener {

    private MenuView menuView;

    public MenuViewHandle(MenuView menuView) {
        this.menuView = menuView;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        if ("管理员登录".equals(text)) {

            DBUtil.setKind(1);
            new LoginView("管理员登陆");
            menuView.dispose();
        } else if ("患者登录".equals(text)) {
            DBUtil.setKind(2);
            new LoginView("患者登录");
            menuView.dispose();
        } else if ("医生登录".equals(text)) {
            DBUtil.setKind(3);
            new LoginView("医生登录");
            menuView.dispose();
        }
    }
}
