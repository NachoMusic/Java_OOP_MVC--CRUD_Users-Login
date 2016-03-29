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
import application.modules.users.model.BLL.bll;
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
                System.out.println("1");
                closeV();
                admin_v.setTitle("Administrators");
                admin_v.setLocationRelativeTo(null);
                admin_v.setVisible(true);
                System.out.println("2");
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
                admin_view.createAButton.setActionCommand("createAButtons");
                admin_view.createAButton.addActionListener(this);
                admin_view.changeDataAButton.setActionCommand("changeDataAButton");
                admin_view.changeDataAButton.addActionListener(this);
                admin_view.deleteDataAButton.setActionCommand("deleteDataAButton");
                admin_view.deleteDataAButton.addActionListener(this);
                admin_view.findAButton.setActionCommand("findAButton");
                admin_view.findAButton.addActionListener(this);
                admin_view.sortbyAButton.setActionCommand("sortbyAButton");
                admin_view.sortbyAButton.addActionListener(this);
                admin_view.exportAButton.setActionCommand("exportAButton");
                admin_view.exportAButton.addActionListener(this);
                admin_view.importAButton.setActionCommand("importAButton");
                admin_view.importAButton.addActionListener(this);
                admin_view.backwards.setActionCommand("backwards");
                admin_view.backwards.addActionListener(this);
                admin_view.forward.setActionCommand("forward");
                admin_view.forward.addActionListener(this);
                admin_view.beginning.setActionCommand("beginning");
                admin_view.beginning.addActionListener(this);
                admin_view.end.setActionCommand("end");
                admin_view.end.addActionListener(this);
                admin_view.pagefield.setActionCommand("pagefield");
                admin_view.pagefield.addActionListener(this);
                admin_view.combopage.setActionCommand("combopage");
                admin_view.combopage.addActionListener(this);
                admin_view.listmenu.setActionCommand("listmenu");
                admin_view.listmenu.addActionListener(this);
                admin_view.formmenu.setActionCommand("formmenu");
                admin_view.formmenu.addActionListener(this);

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
        switch (action.valueOf(ae.getActionCommand())) {
            case createAButton:
                new new_admin_view().setVisible(true);
                admin_v.dispose();
                break;
            case changeDataAButton:
                if (bll.editadmin()) {
                    admin_v.dispose();
                }
                break;
            case deleteDataAButton:
                break;
            case findAButton:
                break;
            case sortbyAButton:
                break;
            case exportAButton:
                break;
            case importAButton:
                break;
            case backwards:
                break;
            case forward:
                break;
            case beginning:
                break;
            case end:
                break;
            case numtab1:
                break;
            case numtab2:
                break;
            case numtab3:
                break;
            case numtab4:
                break;
            case numtab5:
                break;
            case numtab6:
                break;
            case numtab7:
                break;
            case pagefield:
                break;
            case combopage:
                break;
            case listmenu:
                break;
            case formmenu:
                break;
        }
    }
}
