/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.modules.registered.controller;

import application.models.SingletonF;
import application.modules.menu_config.controller.controller;
import application.modules.menu_config.view.app_view;
import application.modules.admin.model.BLL.lib_files.json;
import application.modules.admin.model.BLL.lib_files.txt;
import application.modules.admin.model.BLL.lib_files.xml;
import application.modules.admin.model.models.singleton;
import application.modules.registered.model.BLL.bllR;
import application.modules.registered.model.pager.PagerR;
import application.modules.registered.view.new_registered_view;
import static application.modules.registered.view.new_registered_view.activitylabel;
import static application.modules.registered.view.new_registered_view.avatarlabel;
import static application.modules.registered.view.new_registered_view.datebirthdaylabel;
import static application.modules.registered.view.new_registered_view.dnilabel;
import static application.modules.registered.view.new_registered_view.emaillabel;
import static application.modules.registered.view.new_registered_view.emptyButton;
import static application.modules.registered.view.new_registered_view.hiringdatelabel;
import static application.modules.registered.view.new_registered_view.namelabel;
import static application.modules.registered.view.new_registered_view.passwordlabel;
import static application.modules.registered.view.new_registered_view.phonelabel;
import static application.modules.registered.view.new_registered_view.salarylabel;
import static application.modules.registered.view.new_registered_view.saveLabel;
import static application.modules.registered.view.new_registered_view.statuslabel;
import static application.modules.registered.view.new_registered_view.subnamelabel;
import static application.modules.registered.view.new_registered_view.usernamelabel;
import application.modules.registered.view.registered_view;
import static application.modules.registered.view.registered_view.backwards;
import static application.modules.registered.view.registered_view.beginning;
import static application.modules.registered.view.registered_view.combopage;
import static application.modules.registered.view.registered_view.end;
import static application.modules.registered.view.registered_view.forward;
import static application.modules.registered.view.registered_view.list;
import static application.modules.registered.view.registered_view.numtab1;
import static application.modules.registered.view.registered_view.numtab2;
import static application.modules.registered.view.registered_view.numtab3;
import static application.modules.registered.view.registered_view.numtab4;
import static application.modules.registered.view.registered_view.numtab5;
import static application.modules.registered.view.registered_view.numtab6;
import static application.modules.registered.view.registered_view.numtab7;
import static application.modules.registered.view.registered_view.registeredtable;
import static application.modules.registered.view.registered_view.tabbedtable;
import application.utils.Config_json;
import application.utils.Functions;
import application.utils.Menus;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import static application.modules.registered.view.registered_view.registeredcreated;

/**
 *
 * @author nacho
 */
public class registered_controller implements ActionListener {

    public static registered_view registered_v;
    public static new_registered_view registered_f;

    public registered_controller(JFrame inicio, int i) {
        switch (i) {
            case 0:
                registered_v = (registered_view) inicio;
                break;
            case 1:
                registered_f = (new_registered_view) inicio;
                break;
        }
    }

    public enum action {
        //Registered_v
        createRButton,
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
        registeredtable,
        //Registered_f
        discartButton,
        emptyButton,
        saveAdminButton,
        dniField,
        nameField,
        subnameField,
        phoneField,
        emailField,
        usernameField,
        passwordField,
        avatarField,
        avatarbutton,
        statusField,
        datebirthdayField,
        hiringdateField,
        salaryField,
        activityField,
    }

    public void init(String type) {
        switch (type) {
            case "v":
                closeV();
                registered_v.setTitle("Registered Users");
                registered_v.setLocationRelativeTo(null);
                registered_v.setVisible(true);
                numtab1.setVisible(false);
                numtab2.setVisible(false);
                numtab3.setVisible(false);
                numtab4.setVisible(false);
                numtab5.setVisible(false);
                numtab6.setVisible(false);
                numtab7.setVisible(false);
                singleton.pagerR = new PagerR();
                singleton.pagerR.setPage(0);
                Timer timer = new Timer(10000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        registeredcreated.setVisible(false);
                    }
                });

                registered_view.registeredtable.setName("registeredtable");
                registered_view.createRButton.setActionCommand("createRButton");
                registered_view.createRButton.addActionListener(this);
                registered_view.changeDataAButton.setActionCommand("changeDataAButton");
                registered_view.changeDataAButton.addActionListener(this);
                registered_view.deleteDataAButton.setActionCommand("deleteDataAButton");
                registered_view.deleteDataAButton.addActionListener(this);
                registered_view.findAButton.setActionCommand("findAButton");
                registered_view.findAButton.addActionListener(this);
                registered_view.sortbyAButton.setActionCommand("sortbyAButton");
                registered_view.sortbyAButton.addActionListener(this);
                registered_view.exportAButton.setActionCommand("exportAButton");
                registered_view.exportAButton.addActionListener(this);
                registered_view.importAButton.setActionCommand("importAButton");
                registered_view.importAButton.addActionListener(this);
                registered_view.backwards.setActionCommand("backwards");
                registered_view.backwards.addActionListener(this);
                registered_view.forward.setActionCommand("forward");
                registered_view.forward.addActionListener(this);
                registered_view.beginning.setActionCommand("beginning");
                registered_view.beginning.addActionListener(this);
                registered_view.end.setActionCommand("end");
                registered_view.end.addActionListener(this);
                registered_view.pagefield.setActionCommand("pagefield");
                registered_view.pagefield.addActionListener(this);
                registered_view.combopage.setActionCommand("combopage");
                registered_view.combopage.addActionListener(this);
                registered_view.listmenu.setActionCommand("listmenu");
                registered_view.listmenu.addActionListener(this);
                registered_view.formmenu.setActionCommand("formmenu");
                registered_view.formmenu.addActionListener(this);
                registered_view.backA.setActionCommand("backA");
                registered_view.backA.addActionListener(this);
                registered_view.numtab1.setActionCommand("numtab1");
                registered_view.numtab1.addActionListener(this);
                registered_view.numtab2.setActionCommand("numtab2");
                registered_view.numtab2.addActionListener(this);
                registered_view.numtab3.setActionCommand("numtab3");
                registered_view.numtab3.addActionListener(this);
                registered_view.numtab4.setActionCommand("numtab4");
                registered_view.numtab4.addActionListener(this);
                registered_view.numtab5.setActionCommand("numtab5");
                registered_view.numtab5.addActionListener(this);
                registered_view.numtab6.setActionCommand("numtab6");
                registered_view.numtab6.addActionListener(this);
                registered_view.numtab7.setActionCommand("numtab7");
                registered_view.numtab7.addActionListener(this);
                updatetable();
                timer.start();
                break;
            case "f":
                registered_f.setTitle("Create new Registered User");
                registered_f.setLocationRelativeTo(null);
                registered_f.setVisible(true);
                saveLabel.setVisible(false);
                dnilabel.setVisible(false);
                namelabel.setVisible(false);
                subnamelabel.setVisible(false);
                emaillabel.setVisible(false);
                statuslabel.setVisible(false);
                usernamelabel.setVisible(false);
                passwordlabel.setVisible(false);
                salarylabel.setVisible(false);
                activitylabel.setVisible(false);
                datebirthdaylabel.setVisible(false);
                hiringdatelabel.setVisible(false);
                phonelabel.setVisible(false);
                avatarlabel.setVisible(false);
                new_registered_view.saveRegisteredButton.setActionCommand("saveAdminButton");
                new_registered_view.saveRegisteredButton.addActionListener(this);
                new_registered_view.discartButton.setActionCommand("discartButton");
                new_registered_view.discartButton.addActionListener(this);
                new_registered_view.emptyButton.setActionCommand("emptyButton");
                new_registered_view.emptyButton.addActionListener(this);
                new_registered_view.dniField.setActionCommand("dniField");
                new_registered_view.dniField.addActionListener(this);
                new_registered_view.nameField.setActionCommand("nameField");
                new_registered_view.nameField.addActionListener(this);
                new_registered_view.subnameField.setActionCommand("subnameField");
                new_registered_view.subnameField.addActionListener(this);
                new_registered_view.phoneField.setActionCommand("phoneField");
                new_registered_view.phoneField.addActionListener(this);
                new_registered_view.emailField.setActionCommand("emailField");
                new_registered_view.emailField.addActionListener(this);
                new_registered_view.usernameField.setActionCommand("usernameField");
                new_registered_view.usernameField.addActionListener(this);
                new_registered_view.passwordField.setActionCommand("passwordField");
                new_registered_view.passwordField.addActionListener(this);
                new_registered_view.avatarbutton.setActionCommand("avatarbutton");
                new_registered_view.avatarbutton.addActionListener(this);
                new_registered_view.statusField.setActionCommand("statusField");
                new_registered_view.statusField.addActionListener(this);
                new_registered_view.salaryField.setActionCommand("salaryField");
                new_registered_view.salaryField.addActionListener(this);
                new_registered_view.activityField.setActionCommand("activityField");
                new_registered_view.activityField.addActionListener(this);
                new_registered_view.dniField.addKeyListener(new java.awt.event.KeyAdapter() {
                    @Override
                    public void keyTyped(java.awt.event.KeyEvent evt) {
                        dniFieldKeyTyped(evt);
                    }

                    @Override
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        dniFieldKeyPressed(evt);
                    }

                    @Override
                    public void keyReleased(java.awt.event.KeyEvent evt) {
                        dniFieldKeyReleased(evt);
                    }
                });
                new_registered_view.nameField.addKeyListener(new java.awt.event.KeyAdapter() {
                    @Override
                    public void keyTyped(java.awt.event.KeyEvent evt) {
                        nameFieldKeyTyped(evt);
                    }

                    @Override
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        nameFieldKeyPressed(evt);
                    }

                    @Override
                    public void keyReleased(java.awt.event.KeyEvent evt) {
                        nameFieldKeyReleased(evt);
                    }
                });
                new_registered_view.subnameField.addKeyListener(new java.awt.event.KeyAdapter() {
                    @Override
                    public void keyTyped(java.awt.event.KeyEvent evt) {
                        subnameFieldKeyTyped(evt);
                    }

                    @Override
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        subnameFieldKeyPressed(evt);
                    }

                    @Override
                    public void keyReleased(java.awt.event.KeyEvent evt) {
                        subnameFieldKeyReleased(evt);
                    }
                });
                new_registered_view.phoneField.addKeyListener(new java.awt.event.KeyAdapter() {
                    @Override
                    public void keyTyped(java.awt.event.KeyEvent evt) {
                        phoneFieldKeyTyped(evt);
                    }

                    @Override
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        phoneFieldKeyPressed(evt);
                    }

                    @Override
                    public void keyReleased(java.awt.event.KeyEvent evt) {
                        phoneFieldKeyReleased(evt);
                    }
                });
                new_registered_view.emailField.addKeyListener(new java.awt.event.KeyAdapter() {
                    @Override
                    public void keyTyped(java.awt.event.KeyEvent evt) {
                        emailFieldKeyTyped(evt);
                    }

                    @Override
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        emailFieldKeyPressed(evt);
                    }

                    @Override
                    public void keyReleased(java.awt.event.KeyEvent evt) {
                        emailFieldKeyReleased(evt);
                    }
                });
                new_registered_view.usernameField.addKeyListener(new java.awt.event.KeyAdapter() {
                    @Override
                    public void keyTyped(java.awt.event.KeyEvent evt) {
                        usernameFieldKeyTyped(evt);
                    }

                    @Override
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        usernameFieldKeyPressed(evt);
                    }

                    @Override
                    public void keyReleased(java.awt.event.KeyEvent evt) {
                        usernameFieldKeyReleased(evt);
                    }
                });
                new_registered_view.salaryField.addKeyListener(new java.awt.event.KeyAdapter() {
                    @Override
                    public void keyTyped(java.awt.event.KeyEvent evt) {
                        salaryFieldKeyTyped(evt);
                    }

                    @Override
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        salaryFieldKeyPressed(evt);
                    }

                    @Override
                    public void keyReleased(java.awt.event.KeyEvent evt) {
                        salaryFieldKeyReleased(evt);
                    }
                });
                new_registered_view.activityField.addKeyListener(new java.awt.event.KeyAdapter() {
                    @Override
                    public void keyTyped(java.awt.event.KeyEvent evt) {
                        activityFieldKeyTyped(evt);
                    }

                    @Override
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        activityFieldKeyPressed(evt);
                    }

                    @Override
                    public void keyReleased(java.awt.event.KeyEvent evt) {
                        activityFieldKeyReleased(evt);
                    }
                });
                new_registered_view.statusField.addKeyListener(new java.awt.event.KeyAdapter() {
                    @Override
                    public void keyTyped(java.awt.event.KeyEvent evt) {
                        statusFieldKeyTyped(evt);
                    }

                    @Override
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        statusFieldKeyPressed(evt);
                    }

                    @Override
                    public void keyReleased(java.awt.event.KeyEvent evt) {
                        statusFieldKeyReleased(evt);
                    }
                });
                new_registered_view.passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
                    @Override
                    public void keyTyped(java.awt.event.KeyEvent evt) {
                        passwordFieldKeyTyped(evt);
                    }

                    @Override
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        passwordFieldKeyPressed(evt);
                    }

                    @Override
                    public void keyReleased(java.awt.event.KeyEvent evt) {
                        passwordFieldKeyReleased(evt);
                    }
                });
                break;
        }
    }

    public void closeV() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                registered_v.dispose();
                new controller(new app_view(), 0).init("menu");
            }
        });
    }

    public void closeF() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                registered_f.dispose();
                new registered_controller(new app_view(), 0).init("menu");
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (action.valueOf(ae.getActionCommand())) {
            //admin_view
            case createRButton:
                registered_v.dispose();
                new registered_controller(new new_registered_view(), 1).init("f");
                break;
            case changeDataAButton:
                singleton.pagerR.selectadmin();
                if (bllR.editadmin()) {
                    registered_v.dispose();
                }
                break;
            case deleteDataAButton:
                singleton.pagerR.selectadmin();
                if (singleton.pagerR.getSelected() != null) {
                    singleton.admins.deleteData(Integer.parseInt(singleton.pagerR.getSelected()));
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
                singleton.pagerR.backwards();
                updatetable();
                break;
            case forward:
                singleton.pagerR.forward();
                updatetable();
                break;
            case beginning:
                singleton.pagerR.setPage(0);
                forward.setEnabled(true);
                end.setEnabled(true);
                updatetable();
                break;
            case end:
                singleton.pagerR.setPage(singleton.admins.size() / singleton.pagerR.getMovepage());
                backwards.setEnabled(true);
                beginning.setEnabled(true);
                updatetable();
                break;
            case numtab1:
                numtab1.setForeground(Color.BLUE);
                singleton.pagerR.setSelectedpage(Integer.parseInt(numtab1.getText()) - 1);
                singleton.pagerR.setPage(Integer.parseInt(numtab1.getText()) - 1);
                updatetable();
                break;
            case numtab2:
                numtab2.setForeground(Color.BLUE);
                singleton.pagerR.setSelectedpage(Integer.parseInt(numtab2.getText()) - 1);
                singleton.pagerR.setPage(Integer.parseInt(numtab2.getText()) - 1);
                updatetable();
                break;
            case numtab3:
                numtab3.setForeground(Color.BLUE);
                singleton.pagerR.setSelectedpage(Integer.parseInt(numtab3.getText()) - 1);
                singleton.pagerR.setPage(Integer.parseInt(numtab3.getText()) - 1);
                updatetable();
                break;
            case numtab4:
                numtab4.setForeground(Color.BLUE);
                singleton.pagerR.setSelectedpage(Integer.parseInt(numtab4.getText()) - 1);
                singleton.pagerR.setPage(Integer.parseInt(numtab4.getText()) - 1);
                updatetable();
                break;
            case numtab5:
                numtab5.setForeground(Color.BLUE);
                singleton.pagerR.setSelectedpage(Integer.parseInt(numtab5.getText()) - 1);
                singleton.pagerR.setPage(Integer.parseInt(numtab5.getText()) - 1);
                updatetable();
                break;
            case numtab6:
                numtab6.setForeground(Color.BLUE);
                singleton.pagerR.setSelectedpage(Integer.parseInt(numtab6.getText()) - 1);
                singleton.pagerR.setPage(Integer.parseInt(numtab6.getText()) - 1);
                updatetable();
                break;
            case numtab7:
                numtab7.setForeground(Color.BLUE);
                singleton.pagerR.setSelectedpage(Integer.parseInt(numtab7.getText()) - 1);
                singleton.pagerR.setPage(Integer.parseInt(numtab7.getText()) - 1);
                updatetable();
                break;
            case pagefield:
                singleton.pagerR.pagefield();
                updatetable();
                break;
            case combopage:
                switch (combopage.getSelectedIndex()) {
                    case 0:
                        singleton.pagerR.setMovepage(10);
                        singleton.pagerR.setPage(0);
                        break;
                    case 1:
                        singleton.pagerR.setMovepage(20);
                        singleton.pagerR.setPage(0);
                        break;
                    case 2:
                        singleton.pagerR.setMovepage(50);
                        singleton.pagerR.setPage(0);
                    case 3:
                        singleton.pagerR.setMovepage(100);
                        singleton.pagerR.setPage(0);
                }
                updatetable();
                break;
            case listmenu:
                tabbedtable.setSelectedIndex(0);
                break;
            case formmenu:
                tabbedtable.setSelectedIndex(1);
                break;
            case backA:
                registered_v.dispose();
                new controller(new app_view(), 0).init("menu");
                break;
            //new_admin_view form
            case discartButton:
                registered_f.dispose();
                new registered_controller(new registered_view(), 0).init("v");
                break;
            case emptyButton:
                break;
            case saveAdminButton:
                if (emptyButton.isVisible()) {
                    if (bllR.newAdmin()) {
                        registered_f.dispose();
                        new registered_controller(new registered_view(), 0).init("v");
                        registeredcreated.setText("Created");
                        registeredcreated.setVisible(true);
                        json.createjson_auto();
                        xml.createxml_auto();
                        txt.createtxt_auto();
                        Config_json.create_conf_json();
                    }
                } else if (bllR.editAdmin()) {
                    registered_f.dispose();
                    new registered_controller(new registered_view(), 0).init("v");
                    registeredcreated.setText("Edited");
                    registeredcreated.setVisible(true);
                    json.createjson_auto();
                    xml.createxml_auto();
                    txt.createtxt_auto();
                    Config_json.create_conf_json();
                }
                break;
            case dniField:
                bllR.validateDNI();
                break;
            case nameField:
                bllR.validateName();
                break;
            case subnameField:
                bllR.validateSubname();
                break;
            case phoneField:
                bllR.validatePhone();
                break;
            case emailField:
                bllR.validateEmail();
                break;
            case usernameField:
                bllR.validateUsername();
                break;
            case passwordField:
                bllR.validatePassword();
                break;
            case avatarbutton:
                bllR.validateAvatar();
                break;
            case statusField:
                bllR.validateStatus();
                break;
            case datebirthdayField:
                break;
            case hiringdateField:
                break;
            case salaryField:
                bllR.validateSalary();
                break;
            case activityField:
                bllR.validateActivity();
                break;
        }
    }

    private void dniFieldKeyTyped(java.awt.event.KeyEvent evt) {
        bllR.validateDNI();
        bllR.validateBirthday();
        bllR.validateHiringdate();
    }

    private void dniFieldKeyPressed(java.awt.event.KeyEvent evt) {
        bllR.validateDNI();
        bllR.validateBirthday();
        bllR.validateHiringdate();
    }

    private void dniFieldKeyReleased(java.awt.event.KeyEvent evt) {
        bllR.validateDNI();
        bllR.validateBirthday();
        bllR.validateHiringdate();
    }

    private void nameFieldKeyPressed(java.awt.event.KeyEvent evt) {
        bllR.validateName();
    }

    private void nameFieldKeyReleased(java.awt.event.KeyEvent evt) {
        bllR.validateName();
    }

    private void nameFieldKeyTyped(java.awt.event.KeyEvent evt) {
        bllR.validateName();
    }

    private void subnameFieldKeyPressed(java.awt.event.KeyEvent evt) {
        bllR.validateSubname();
    }

    private void subnameFieldKeyReleased(java.awt.event.KeyEvent evt) {
        bllR.validateSubname();
    }

    private void subnameFieldKeyTyped(java.awt.event.KeyEvent evt) {
        bllR.validateSubname();
    }

    private void phoneFieldKeyPressed(java.awt.event.KeyEvent evt) {
        bllR.validatePhone();
    }

    private void phoneFieldKeyReleased(java.awt.event.KeyEvent evt) {
        bllR.validatePhone();
    }

    private void phoneFieldKeyTyped(java.awt.event.KeyEvent evt) {
        bllR.validatePhone();
    }

    private void emailFieldKeyPressed(java.awt.event.KeyEvent evt) {
        bllR.validateEmail();
    }

    private void emailFieldKeyReleased(java.awt.event.KeyEvent evt) {
        bllR.validateEmail();
    }

    private void emailFieldKeyTyped(java.awt.event.KeyEvent evt) {
        bllR.validateEmail();
    }

    private void usernameFieldKeyPressed(java.awt.event.KeyEvent evt) {
        bllR.validateUsername();
    }

    private void usernameFieldKeyReleased(java.awt.event.KeyEvent evt) {
        bllR.validateUsername();
    }

    private void usernameFieldKeyTyped(java.awt.event.KeyEvent evt) {
        bllR.validateUsername();
    }

    private void passwordFieldKeyPressed(java.awt.event.KeyEvent evt) {
        bllR.validatePassword();
    }

    private void passwordFieldKeyReleased(java.awt.event.KeyEvent evt) {
        bllR.validatePassword();
    }

    private void passwordFieldKeyTyped(java.awt.event.KeyEvent evt) {
        bllR.validatePassword();
    }

    private void statusFieldKeyPressed(java.awt.event.KeyEvent evt) {
        bllR.validateStatus();
    }

    private void statusFieldKeyReleased(java.awt.event.KeyEvent evt) {
        bllR.validateStatus();
    }

    private void statusFieldKeyTyped(java.awt.event.KeyEvent evt) {
        bllR.validateStatus();
    }

    private void salaryFieldKeyPressed(java.awt.event.KeyEvent evt) {
        bllR.validateSalary();
    }

    private void salaryFieldKeyReleased(java.awt.event.KeyEvent evt) {
        bllR.validateSalary();
    }

    private void salaryFieldKeyTyped(java.awt.event.KeyEvent evt) {
        bllR.validateSalary();
    }

    private void activityFieldKeyReleased(java.awt.event.KeyEvent evt) {
        bllR.validateActivity();
    }

    private void activityFieldKeyTyped(java.awt.event.KeyEvent evt) {
        bllR.validateActivity();
    }

    private void activityFieldKeyPressed(java.awt.event.KeyEvent evt) {
        bllR.validateActivity();
    }

    public static void updatetable() {
        JTable jTable = new JTable() {
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        registeredtable = jTable;
        registeredtable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Num", "DNI", "Name", "Surname", "Phone", "Email", "User",
                    "Status", "Birthday", "Karma", "Activity"
                }
        ));
        registeredtable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                JTable table = (JTable) me.getSource();
                Point p = me.getPoint();
                int row = table.rowAtPoint(p);
                if (me.getClickCount() == 2) {
                    tabbedtable.setSelectedIndex(1);
                }
            }
        });
        registeredtable.setColumnSelectionAllowed(true);
        registeredtable.getTableHeader().setReorderingAllowed(false);

        registeredtable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminstableMouseClicked(evt);
            }

            private void adminstableMouseClicked(MouseEvent evt) {
                singleton.pagerR.selectadmin();
            }
        });

        list.setViewportView(registeredtable);
        registeredtable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        singleton.pagerR.setModel((DefaultTableModel) registeredtable.getModel());
        // Creamos un ordenador de filas para el modelo
        TableRowSorter sorter = new TableRowSorter(singleton.pagerR.getModel());
        registeredtable.setRowSorter(sorter);
        registeredtable.setColumnSelectionAllowed(false);
        singleton.pagerR.updatetable2();
        singleton.pagerR.pagenum();
    }
}
