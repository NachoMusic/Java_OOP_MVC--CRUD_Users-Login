/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.modules.admin.controller;

import application.models.SingletonF;
import application.modules.menu_config.controller.controller;
import application.modules.menu_config.view.app_view;
import static application.modules.admin.controller.admin_controller.admin_f;
import static application.modules.admin.controller.admin_controller.admin_v;
import application.modules.admin.model.BLL.bll;
import application.modules.admin.model.BLL.lib_files.json;
import application.modules.admin.model.BLL.lib_files.txt;
import application.modules.admin.model.BLL.lib_files.xml;
import application.modules.users.model.singleton;
import application.modules.admin.model.pager.Pager;
import application.modules.admin.view.admin_view;
import static application.modules.admin.view.admin_view.admincreated;
import static application.modules.admin.view.admin_view.adminstable;
import static application.modules.admin.view.admin_view.backwards;
import static application.modules.admin.view.admin_view.beginning;
import static application.modules.admin.view.admin_view.combopage;
import static application.modules.admin.view.admin_view.end;
import static application.modules.admin.view.admin_view.forward;
import static application.modules.admin.view.admin_view.list;
import static application.modules.admin.view.admin_view.numtab1;
import static application.modules.admin.view.admin_view.numtab2;
import static application.modules.admin.view.admin_view.numtab3;
import static application.modules.admin.view.admin_view.numtab4;
import static application.modules.admin.view.admin_view.numtab5;
import static application.modules.admin.view.admin_view.numtab6;
import static application.modules.admin.view.admin_view.numtab7;
import static application.modules.admin.view.admin_view.tabbedtable;
import application.modules.admin.view.new_admin_view;
import static application.modules.admin.view.new_admin_view.activitylabel;
import static application.modules.admin.view.new_admin_view.avatarlabel;
import static application.modules.admin.view.new_admin_view.datebirthdaylabel;
import static application.modules.admin.view.new_admin_view.dnilabel;
import static application.modules.admin.view.new_admin_view.emaillabel;
import static application.modules.admin.view.new_admin_view.emptyButton;
import static application.modules.admin.view.new_admin_view.hiringdatelabel;
import static application.modules.admin.view.new_admin_view.namelabel;
import static application.modules.admin.view.new_admin_view.passwordlabel;
import static application.modules.admin.view.new_admin_view.phonelabel;
import static application.modules.admin.view.new_admin_view.salarylabel;
import static application.modules.admin.view.new_admin_view.saveLabel;
import static application.modules.admin.view.new_admin_view.statuslabel;
import static application.modules.admin.view.new_admin_view.subnamelabel;
import static application.modules.admin.view.new_admin_view.usernamelabel;
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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

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
        backA,
        adminstable,
        autocompletefield,
        test,
        //Admin_f
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
                singleton.pagerA = new Pager();
                singleton.pagerA.setPage(0);
                Timer timer = new Timer(10000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        admincreated.setVisible(false);
                    }
                });

                admin_view.adminstable.setName("adminstable");
                admin_view.createAButton.setActionCommand("createAButton");
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
                admin_view.backA.setActionCommand("backA");
                admin_view.backA.addActionListener(this);
                admin_view.numtab1.setActionCommand("numtab1");
                admin_view.numtab1.addActionListener(this);
                admin_view.numtab2.setActionCommand("numtab2");
                admin_view.numtab2.addActionListener(this);
                admin_view.numtab3.setActionCommand("numtab3");
                admin_view.numtab3.addActionListener(this);
                admin_view.numtab4.setActionCommand("numtab4");
                admin_view.numtab4.addActionListener(this);
                admin_view.numtab5.setActionCommand("numtab5");
                admin_view.numtab5.addActionListener(this);
                admin_view.numtab6.setActionCommand("numtab6");
                admin_view.numtab6.addActionListener(this);
                admin_view.numtab7.setActionCommand("numtab7");
                admin_view.numtab7.addActionListener(this);
                admin_view.test.setActionCommand("test");
                admin_view.test.addActionListener(this);
                admin_view.autocompletefield.setActionCommand("autocompletefield");
                admin_view.autocompletefield.addActionListener(this);
                admin_view.createAButton.setText(SingletonF.language.getProperty("create"));
                admin_view.changeDataAButton.setText(SingletonF.language.getProperty("change_data"));
                admin_view.deleteDataAButton.setText(SingletonF.language.getProperty("delete"));
                admin_view.backA.setText(SingletonF.language.getProperty("go_back"));
                admin_view.findAButton.setText(SingletonF.language.getProperty("find"));
                admin_view.sortbyAButton.setText(SingletonF.language.getProperty("sortby"));
                admin_view.exportAButton.setText(SingletonF.language.getProperty("export"));
                admin_view.importAButton.setText(SingletonF.language.getProperty("import"));
                admin_view.filemenu.setText(SingletonF.language.getProperty("filemenu"));
                admin_view.exportmenu.setText(SingletonF.language.getProperty("export"));
                admin_view.importmenu.setText(SingletonF.language.getProperty("import"));
                admin_view.viewsmenu.setText(SingletonF.language.getProperty("views"));
                admin_view.sortmenu.setText(SingletonF.language.getProperty("sort"));
                admin_view.autocompletefield.addKeyListener(new java.awt.event.KeyAdapter() {
                    @Override
                    public void keyTyped(java.awt.event.KeyEvent evt) {
                        autocompletefieldKeyTyped(evt);
                    }

                    @Override
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        autocompletefieldKeyPressed(evt);
                    }

                    @Override
                    public void keyReleased(java.awt.event.KeyEvent evt) {
                        autocompletefieldKeyReleased(evt);
                    }
                });
                updatetable(0);
                timer.start();
                break;
            case "f":
                admin_f.setTitle("Create new admin");
                admin_f.setLocationRelativeTo(null);
                admin_f.setVisible(true);
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
                new_admin_view.saveAdminButton.setActionCommand("saveAdminButton");
                new_admin_view.saveAdminButton.addActionListener(this);
                new_admin_view.discartButton.setActionCommand("discartButton");
                new_admin_view.discartButton.addActionListener(this);
                new_admin_view.emptyButton.setActionCommand("emptyButton");
                new_admin_view.emptyButton.addActionListener(this);
                new_admin_view.dniField.setActionCommand("dniField");
                new_admin_view.dniField.addActionListener(this);
                new_admin_view.nameField.setActionCommand("nameField");
                new_admin_view.nameField.addActionListener(this);
                new_admin_view.subnameField.setActionCommand("subnameField");
                new_admin_view.subnameField.addActionListener(this);
                new_admin_view.phoneField.setActionCommand("phoneField");
                new_admin_view.phoneField.addActionListener(this);
                new_admin_view.emailField.setActionCommand("emailField");
                new_admin_view.emailField.addActionListener(this);
                new_admin_view.usernameField.setActionCommand("usernameField");
                new_admin_view.usernameField.addActionListener(this);
                new_admin_view.passwordField.setActionCommand("passwordField");
                new_admin_view.passwordField.addActionListener(this);
                new_admin_view.avatarbutton.setActionCommand("avatarbutton");
                new_admin_view.avatarbutton.addActionListener(this);
                new_admin_view.statusField.setActionCommand("statusField");
                new_admin_view.statusField.addActionListener(this);
                new_admin_view.salaryField.setActionCommand("salaryField");
                new_admin_view.salaryField.addActionListener(this);
                new_admin_view.activityField.setActionCommand("activityField");
                new_admin_view.activityField.addActionListener(this);
                new_admin_view.dniField.addKeyListener(new java.awt.event.KeyAdapter() {
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
                new_admin_view.nameField.addKeyListener(new java.awt.event.KeyAdapter() {
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
                new_admin_view.subnameField.addKeyListener(new java.awt.event.KeyAdapter() {
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
                new_admin_view.phoneField.addKeyListener(new java.awt.event.KeyAdapter() {
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
                new_admin_view.emailField.addKeyListener(new java.awt.event.KeyAdapter() {
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
                new_admin_view.usernameField.addKeyListener(new java.awt.event.KeyAdapter() {
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
                new_admin_view.salaryField.addKeyListener(new java.awt.event.KeyAdapter() {
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
                new_admin_view.activityField.addKeyListener(new java.awt.event.KeyAdapter() {
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
                new_admin_view.statusField.addKeyListener(new java.awt.event.KeyAdapter() {
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
                new_admin_view.passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
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
            //admin_view
            case createAButton:
                admin_v.dispose();
                new admin_controller(new new_admin_view(), 1).init("f");
                break;
            case changeDataAButton:
                singleton.pagerA.selectadmin();
                if (bll.editadmin()) {
                    admin_v.dispose();
                }
                break;
            case deleteDataAButton:
                singleton.pagerA.selectadmin();
                if (singleton.pagerA.getSelected() != null) {
                    //singleton.admins.deleteData(Integer.parseInt(singleton.pagerA.getSelected()));
                    updatetable(0);
                    json.createjson_auto();
                    xml.createxml_auto();
                    txt.createtxt_auto();
                    Config_json.create_conf_json();
                    bll.deleteadminBBDD();
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
                singleton.pagerA.backwards();
                updatetable(0);
                break;
            case forward:
                singleton.pagerA.forward();
                updatetable(0);
                break;
            case beginning:
                singleton.pagerA.setPage(0);
                forward.setEnabled(true);
                end.setEnabled(true);
                updatetable(0);
                break;
            case end:
                singleton.pagerA.setPage(singleton.admins.size() / singleton.pagerA.getMovepage());
                backwards.setEnabled(true);
                beginning.setEnabled(true);
                updatetable(0);
                break;
            case numtab1:
                numtab1.setForeground(Color.BLUE);
                singleton.pagerA.setSelectedpage(Integer.parseInt(numtab1.getText()) - 1);
                singleton.pagerA.setPage(Integer.parseInt(numtab1.getText()) - 1);
                updatetable(0);
                break;
            case numtab2:
                numtab2.setForeground(Color.BLUE);
                singleton.pagerA.setSelectedpage(Integer.parseInt(numtab2.getText()) - 1);
                singleton.pagerA.setPage(Integer.parseInt(numtab2.getText()) - 1);
                updatetable(0);
                break;
            case numtab3:
                numtab3.setForeground(Color.BLUE);
                singleton.pagerA.setSelectedpage(Integer.parseInt(numtab3.getText()) - 1);
                singleton.pagerA.setPage(Integer.parseInt(numtab3.getText()) - 1);
                updatetable(0);
                break;
            case numtab4:
                numtab4.setForeground(Color.BLUE);
                singleton.pagerA.setSelectedpage(Integer.parseInt(numtab4.getText()) - 1);
                singleton.pagerA.setPage(Integer.parseInt(numtab4.getText()) - 1);
                updatetable(0);
                break;
            case numtab5:
                numtab5.setForeground(Color.BLUE);
                singleton.pagerA.setSelectedpage(Integer.parseInt(numtab5.getText()) - 1);
                singleton.pagerA.setPage(Integer.parseInt(numtab5.getText()) - 1);
                updatetable(0);
                break;
            case numtab6:
                numtab6.setForeground(Color.BLUE);
                singleton.pagerA.setSelectedpage(Integer.parseInt(numtab6.getText()) - 1);
                singleton.pagerA.setPage(Integer.parseInt(numtab6.getText()) - 1);
                updatetable(0);
                break;
            case numtab7:
                numtab7.setForeground(Color.BLUE);
                singleton.pagerA.setSelectedpage(Integer.parseInt(numtab7.getText()) - 1);
                singleton.pagerA.setPage(Integer.parseInt(numtab7.getText()) - 1);
                updatetable(0);
                break;
            case pagefield:
                singleton.pagerA.pagefield();
                updatetable(0);
                break;
            case combopage:
                switch (combopage.getSelectedIndex()) {
                    case 0:
                        singleton.pagerA.setMovepage(10);
                        singleton.pagerA.setPage(0);
                        break;
                    case 1:
                        singleton.pagerA.setMovepage(20);
                        singleton.pagerA.setPage(0);
                        break;
                    case 2:
                        singleton.pagerA.setMovepage(50);
                        singleton.pagerA.setPage(0);
                    case 3:
                        singleton.pagerA.setMovepage(100);
                        singleton.pagerA.setPage(0);
                }
                updatetable(0);
                break;
            case listmenu:
                tabbedtable.setSelectedIndex(0);
                break;
            case formmenu:
                tabbedtable.setSelectedIndex(1);
                break;
            case backA:
                admin_v.dispose();
                new controller(new app_view(), 0).init("menu");
                break;
            case autocompletefield:
                singleton.admins.find(1, admin_view.autocompletefield.getText());
                break;
            case test: 
                try {
                    bll.saveadminsBBDD();
                } catch (SQLException ex) {
                    Logger.getLogger(admin_controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            break;
            //new_admin_view form
            case discartButton:
                admin_f.dispose();
                new admin_controller(new admin_view(), 0).init("v");
                break;
            case emptyButton:
                break;
            case saveAdminButton:
                if (emptyButton.isVisible()) {
                    if (bll.newAdmin()) {
                        admin_f.dispose();
                        new admin_controller(new admin_view(), 0).init("v");
                        admincreated.setText("Created");
                        admincreated.setVisible(true);
                        json.createjson_auto();
                        xml.createxml_auto();
                        txt.createtxt_auto();
                        Config_json.create_conf_json();
                    }
                } else if (bll.editAdmin()) {
                    admin_f.dispose();
                    new admin_controller(new admin_view(), 0).init("v");
                    admincreated.setText("Edited");
                    admincreated.setVisible(true);
                    System.out.println("fuera2");
                    json.createjson_auto();
                    xml.createxml_auto();
                    txt.createtxt_auto();
                    Config_json.create_conf_json();
                }
                break;
            case dniField:
                bll.validateDNI();
                break;
            case nameField:
                bll.validateName();
                break;
            case subnameField:
                bll.validateSubname();
                break;
            case phoneField:
                bll.validatePhone();
                break;
            case emailField:
                bll.validateEmail();
                break;
            case usernameField:
                bll.validateUsername();
                break;
            case passwordField:
                bll.validatePassword();
                break;
            case avatarbutton:
                bll.validateAvatar();
                break;
            case statusField:
                bll.validateStatus();
                break;
            case datebirthdayField:
                break;
            case hiringdateField:
                break;
            case salaryField:
                bll.validateSalary();
                break;
            case activityField:
                bll.validateActivity();
                break;
        }
    }

    private void dniFieldKeyTyped(java.awt.event.KeyEvent evt) {
        bll.validateDNI();
        bll.validateBirthday();
        bll.validateHiringdate();
    }

    private void dniFieldKeyPressed(java.awt.event.KeyEvent evt) {
        bll.validateDNI();
        bll.validateBirthday();
        bll.validateHiringdate();
    }

    private void dniFieldKeyReleased(java.awt.event.KeyEvent evt) {
        bll.validateDNI();
        bll.validateBirthday();
        bll.validateHiringdate();
    }

    private void nameFieldKeyPressed(java.awt.event.KeyEvent evt) {
        bll.validateName();
    }

    private void nameFieldKeyReleased(java.awt.event.KeyEvent evt) {
        bll.validateName();
    }

    private void nameFieldKeyTyped(java.awt.event.KeyEvent evt) {
        bll.validateName();
    }

    private void subnameFieldKeyPressed(java.awt.event.KeyEvent evt) {
        bll.validateSubname();
    }

    private void subnameFieldKeyReleased(java.awt.event.KeyEvent evt) {
        bll.validateSubname();
    }

    private void subnameFieldKeyTyped(java.awt.event.KeyEvent evt) {
        bll.validateSubname();
    }

    private void phoneFieldKeyPressed(java.awt.event.KeyEvent evt) {
        bll.validatePhone();
    }

    private void phoneFieldKeyReleased(java.awt.event.KeyEvent evt) {
        bll.validatePhone();
    }

    private void phoneFieldKeyTyped(java.awt.event.KeyEvent evt) {
        bll.validatePhone();
    }

    private void emailFieldKeyPressed(java.awt.event.KeyEvent evt) {
        bll.validateEmail();
    }

    private void emailFieldKeyReleased(java.awt.event.KeyEvent evt) {
        bll.validateEmail();
    }

    private void emailFieldKeyTyped(java.awt.event.KeyEvent evt) {
        bll.validateEmail();
    }

    private void usernameFieldKeyPressed(java.awt.event.KeyEvent evt) {
        bll.validateUsername();
    }

    private void usernameFieldKeyReleased(java.awt.event.KeyEvent evt) {
        bll.validateUsername();
    }

    private void usernameFieldKeyTyped(java.awt.event.KeyEvent evt) {
        bll.validateUsername();
    }

    private void passwordFieldKeyPressed(java.awt.event.KeyEvent evt) {
        bll.validatePassword();
    }

    private void passwordFieldKeyReleased(java.awt.event.KeyEvent evt) {
        bll.validatePassword();
    }

    private void passwordFieldKeyTyped(java.awt.event.KeyEvent evt) {
        bll.validatePassword();
    }

    private void statusFieldKeyPressed(java.awt.event.KeyEvent evt) {
        bll.validateStatus();
    }

    private void statusFieldKeyReleased(java.awt.event.KeyEvent evt) {
        bll.validateStatus();
    }

    private void statusFieldKeyTyped(java.awt.event.KeyEvent evt) {
        bll.validateStatus();
    }

    private void salaryFieldKeyPressed(java.awt.event.KeyEvent evt) {
        bll.validateSalary();
    }

    private void salaryFieldKeyReleased(java.awt.event.KeyEvent evt) {
        bll.validateSalary();
    }

    private void salaryFieldKeyTyped(java.awt.event.KeyEvent evt) {
        bll.validateSalary();
    }

    private void activityFieldKeyReleased(java.awt.event.KeyEvent evt) {
        bll.validateActivity();
    }

    private void activityFieldKeyTyped(java.awt.event.KeyEvent evt) {
        bll.validateActivity();
    }

    private void activityFieldKeyPressed(java.awt.event.KeyEvent evt) {
        bll.validateActivity();
    }

    private void autocompletefieldKeyReleased(java.awt.event.KeyEvent evt) {
        singleton.admins.find(1, admin_view.autocompletefield.getText());
    }

    private void autocompletefieldKeyTyped(java.awt.event.KeyEvent evt) {
        singleton.admins.find(1, admin_view.autocompletefield.getText());
    }

    private void autocompletefieldKeyPressed(java.awt.event.KeyEvent evt) {
        singleton.admins.find(1, admin_view.autocompletefield.getText());
    }

    public static void updatetable(int option) {
        JTable jTable = new JTable() {
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        adminstable = jTable;
        adminstable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Num", "DNI", "Name", "Surname", "Phone", "Email", "User", "Status", "Birthday", "Age", "Hiring Date", "Salary", "Activity"
                }
        ));
        adminstable.addMouseListener(new MouseAdapter() {
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
        adminstable.setColumnSelectionAllowed(true);
        adminstable.getTableHeader().setReorderingAllowed(false);

        adminstable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminstableMouseClicked(evt);
            }

            private void adminstableMouseClicked(MouseEvent evt) {
                singleton.pagerA.selectadmin();
            }
        });

        list.setViewportView(adminstable);
        adminstable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        singleton.pagerA.setModel((DefaultTableModel) adminstable.getModel());
        // Creamos un ordenador de filas para el modelo
        TableRowSorter sorter = new TableRowSorter(singleton.pagerA.getModel());
        adminstable.setRowSorter(sorter);
        adminstable.setColumnSelectionAllowed(false);
        if (option == 0) {
            singleton.pagerA.updatetable2();
        }
        singleton.pagerA.pagenum();
    }
}
