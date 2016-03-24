/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.modules.menu.controller;

import application.models.SingletonF;
import application.modules.config.view.config_view;
import application.modules.menu.view.app_view;
import static application.modules.menu.view.app_view.configview;
import application.modules.users.view.admin_view;
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
public class controller implements ActionListener {

    public static app_view menu;

    public controller(JFrame inicio) {
        menu = (app_view) inicio;
    }

    public enum action {
        adminsButton,
        clientsButton,
        usregButton,
        confButton
    }

    public void init() {
        menu.setVisible(true);
        menu.setTitle(SingletonF.language.getProperty("application_users"));
        menu.setLocationRelativeTo(null);

        menu.adminsButton.setActionCommand("adminsButton");
        menu.adminsButton.addActionListener(this);
        menu.clientsButton.setActionCommand("clientsButton");
        menu.clientsButton.addActionListener(this);
        menu.usregButton.setActionCommand("usregButton");
        menu.usregButton.addActionListener(this);
        menu.confButton.setActionCommand("confButton");
        menu.confButton.addActionListener(this);
        closeM();
    }

    public void closeM() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.out.println("Close");
                menu.dispose();
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (action.valueOf(ae.getActionCommand())) {
            case adminsButton:
                menu.setVisible(false);
                new admin_view().setVisible(true);
                break;

            case clientsButton:
                System.out.println("Clients");
                break;

            case usregButton:
                System.out.println("Usreg");
                break;

            case confButton:
                configview = new config_view();
                configview.setVisible(true);
                break;
        }
    }
}
