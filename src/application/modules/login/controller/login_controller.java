/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.modules.login.controller;

import application.modules.login.model.BLL.bllLogin;
import application.modules.login.view.login_view;
import application.modules.menu_config.controller.controller;
import application.modules.menu_config.view.app_view;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author nacho
 */
public class login_controller implements ActionListener {

    public static login_view login;
    private String type = "client";

    public login_controller(JFrame init) {
        login = (login_view) init;
    }

    public enum action {
        typecombo,
        usernameLogin,
        passwordLogin,
        loginbutton
    }

    public void init() {
        login.setTitle("Administrators");
        login.setLocationRelativeTo(null);
        login_view.wrongpass.setVisible(false);
        login.setVisible(true);
        login_view.typecombo.setActionCommand("typecombo");
        login_view.typecombo.addActionListener(this);
        login_view.usernameLogin.setActionCommand("usernameLogin");
        login_view.usernameLogin.addActionListener(this);
        login_view.passwordLogin.setActionCommand("passwordLogin");
        login_view.passwordLogin.addActionListener(this);
        login_view.loginbutton.setActionCommand("loginbutton");
        login_view.loginbutton.addActionListener(this);
    }

    public void close() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (action.valueOf(ae.getActionCommand())) {
            case typecombo:
                switch(login_view.typecombo.getSelectedIndex()){
                    case 0:
                        type = "client";
                        break;
                    case 1:
                        type = "usreg";
                        break;
                    case 2:
                        type = "admin";
                        break;
                }
                break;
            case usernameLogin:
                break;
            case passwordLogin:
                break;
            case loginbutton:
                switch(login_view.typecombo.getSelectedIndex()){
                    case 0:
                        break;
                    case 1:
                        bllLogin.sign_in_Usreg();
                        break;
                    case 2:
                        login.dispose();
                        new controller(new app_view(),0).init("menu");
                        break;
                }
                break;
        }
    }
}
