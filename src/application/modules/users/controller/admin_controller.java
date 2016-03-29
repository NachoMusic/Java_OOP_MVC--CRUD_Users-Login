/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.modules.users.controller;

import application.modules.menu_config.controller.controller;
import application.modules.menu_config.view.app_view;
import static application.modules.users.controller.admin_controller.admin_f;
import static application.modules.users.controller.admin_controller.admin_v;
import application.modules.users.model.models.singleton;
import application.modules.users.model.pager.Pager;
import application.modules.users.view.admin_view;
import static application.modules.users.view.admin_view.admincreated;
import static application.modules.users.view.admin_view.numtab1;
import static application.modules.users.view.admin_view.numtab2;
import static application.modules.users.view.admin_view.numtab3;
import static application.modules.users.view.admin_view.numtab4;
import static application.modules.users.view.admin_view.numtab5;
import static application.modules.users.view.admin_view.numtab6;
import static application.modules.users.view.admin_view.numtab7;
import application.modules.users.view.new_admin_view;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author nacho
 */
public class admin_controller implements ActionListener {

    public static admin_view admin_v;
    public static new_admin_view admin_f;

    public admin_controller(JFrame inicio, int i) {
        switch (i) {
            case 0:
                admin_v = (admin_view) inicio;
                break;
            case 1:
                admin_f = (new_admin_view) inicio;
                break;
        }
    }

    public enum action {
        //Admin_v
        createAButton,
        changeDataAButton,
        deleteDataAButton,
        findAButton,
        sortbyAButton,
        exportAButton,
        importAButton,
        backwards,
        forward,
        beginning,
        end,
        numtab1,
        numtab2,
        numtab3,
        numtab4,
        numtab5,
        numtab6,
        numtab7,
        pagefield,
        combopage,
        listmenu,
        formmenu,
        //Admin_f
    }

    public void init(String type) {
        switch (type) {
            case "v":
                admin_v.setTitle("Administrators");
                admin_v.setLocationRelativeTo(null);
                numtab1.setVisible(false);
                numtab2.setVisible(false);
                numtab3.setVisible(false);
                numtab4.setVisible(false);
                numtab5.setVisible(false);
                numtab6.setVisible(false);
                numtab7.setVisible(false);
                singleton.pager = new Pager();
                singleton.pager.setPage(0);
                //updatetable();
                Timer timer = new Timer(10000, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        admincreated.setVisible(false);
                    }
                });
                timer.start();
                break;
            case "f":
                break;
        }
    }

    public void closeV() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                admin_v.dispose();
                new controller(new app_view(), 0).init("menu");
            }
        });
    }

    public void closeF() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                admin_f.dispose();
                new admin_controller(new app_view(), 0).init("menu");
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (controller.action.valueOf(ae.getActionCommand())) {

        }
    }
}
