/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.modules.users.controller;

import application.models.SingletonF;
import application.modules.menu_config.controller.controller;
import application.modules.menu_config.view.app_view;
import static application.modules.users.controller.admin_controller.admin_f;
import static application.modules.users.controller.admin_controller.admin_v;
import application.modules.users.model.BLL.bll;
import static application.modules.users.model.BLL.bll.updatetable;
import application.modules.users.model.BLL.lib_files.json;
import application.modules.users.model.BLL.lib_files.txt;
import application.modules.users.model.BLL.lib_files.xml;
import application.modules.users.model.models.singleton;
import application.modules.users.model.pager.Pager;
import application.modules.users.view.admin_view;
import static application.modules.users.view.admin_view.admincreated;
import static application.modules.users.view.admin_view.backwards;
import static application.modules.users.view.admin_view.beginning;
import static application.modules.users.view.admin_view.combopage;
import static application.modules.users.view.admin_view.end;
import static application.modules.users.view.admin_view.forward;
import static application.modules.users.view.admin_view.numtab1;
import static application.modules.users.view.admin_view.numtab2;
import static application.modules.users.view.admin_view.numtab3;
import static application.modules.users.view.admin_view.numtab4;
import static application.modules.users.view.admin_view.numtab5;
import static application.modules.users.view.admin_view.numtab6;
import static application.modules.users.view.admin_view.numtab7;
import static application.modules.users.view.admin_view.tabbedtable;
import application.modules.users.view.new_admin_view;
import application.utils.Config_json;
import application.utils.Functions;
import application.utils.Menus;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author nacho
 */
public class admin_controller implements ActionListener/*, MouseClicked */ {

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
        backA,
        //Admin_f
    }

    public void init(String type) {
        switch (type) {
            case "v":
                closeV();
                admin_v.setTitle("Administrators");
                admin_v.setLocationRelativeTo(null);
                admin_v.setVisible(true);
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
                if (singleton.pager.getSelected() != null) {
                    singleton.admins.deleteData(Integer.parseInt(singleton.pager.getSelected()));
                    updatetable();
                    json.createjson_auto();
                    xml.createxml_auto();
                    txt.createtxt_auto();
                    Config_json.create_conf_json();
                }
                break;
            case findAButton:
                String[] find = {SingletonF.language.getProperty("bydni"), SingletonF.language.getProperty("byname"),
                    SingletonF.language.getProperty("go_back")};
                int option = Menus.menu(find, SingletonF.language.getProperty("searchadmins"),
                        SingletonF.language.getProperty("search"));
                switch (option) {
                    case 0://By dni
                        singleton.admins.find(0, Functions.validatestring("insert dni", "insert dni"));
                        break;
                    case 1://By name
                        singleton.admins.find(1, Functions.validatestring("insert name", "insert name"));
                        break;
                    case 2://Go back
                }
                break;
            case sortbyAButton:
                String[] sortBy = {"By DNI", "By name", "By birthday", SingletonF.language.getProperty("go_back")};
                int optionS = Menus.menu(sortBy, SingletonF.language.getProperty("sortadmins"),
                        SingletonF.language.getProperty("sort"));
                switch (optionS) {
                    case 0://By dni
                        singleton.admins.sortData(0);
                        break;
                    case 1://By name
                        singleton.admins.sortData(1);
                        break;
                    case 2://By date birthday
                        singleton.admins.sortData(2);
                        break;
                    case 3://Go back
                }
                updatetable();
                break;
            case exportAButton:
                switch (SingletonF.configApp.getSavingextension()) {
                    case "json"://json
                        json.createjson();
                        break;
                    case "xml"://xml
                        xml.createxml();
                        break;
                    case "txt"://txt
                        txt.createtxt();
                        break;
                }
                break;
            case importAButton:
                switch (SingletonF.configApp.getSavingextension()) {
                    case "json"://json
                        json.load_json();
                        break;
                    case "xml"://xml
                        xml.load_xml();
                        break;
                    case "txt": //txt
                        txt.load_txt();
                        break;
                }
                break;
            case backwards:
                singleton.pager.backwards();
                updatetable();
                break;
            case forward:
                singleton.pager.forward();
                updatetable();
                break;
            case beginning:
                singleton.pager.setPage(0);
                forward.setEnabled(true);
                end.setEnabled(true);
                updatetable();
                break;
            case end:
                singleton.pager.setPage(singleton.admins.size() / singleton.pager.getMovepage());
                backwards.setEnabled(true);
                beginning.setEnabled(true);
                updatetable();
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
                singleton.pager.pagefield();
                updatetable();
                break;
            case combopage:
                switch (combopage.getSelectedIndex()) {
                    case 0:
                        singleton.pager.setMovepage(10);
                        singleton.pager.setPage(0);
                        break;
                    case 1:
                        singleton.pager.setMovepage(20);
                        singleton.pager.setPage(0);
                        break;
                    case 2:
                        singleton.pager.setMovepage(50);
                        singleton.pager.setPage(0);
                    case 3:
                        singleton.pager.setMovepage(100);
                        singleton.pager.setPage(0);
                }
                updatetable();
                break;
            case listmenu:
                tabbedtable.setSelectedIndex(0);
                break;
            case formmenu:
                tabbedtable.setSelectedIndex(1);
                break;
        }
    }
    /*
    @Override
    public void MouseClicked (MouseEvent ae) {
        switch (action.valueOf(ae.getActionCommand())) {

        }
    }*/
}
