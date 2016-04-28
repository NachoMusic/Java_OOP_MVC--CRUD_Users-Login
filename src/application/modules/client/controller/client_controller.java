/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.modules.client.controller;

import application.models.SingletonF;
import application.modules.menu_config.controller.controller;
import application.modules.menu_config.view.app_view;
import application.modules.admin.model.BLL.lib_files.json;
import application.modules.admin.model.BLL.lib_files.txt;
import application.modules.admin.model.BLL.lib_files.xml;
import application.modules.users.model.singleton;
import application.modules.client.model.BLL.bllC;
import application.modules.client.model.BLL.lib_files.jsonC;
import application.modules.client.model.DAO.daoC;
import application.modules.client.model.pager.PagerC;
import application.modules.client.view.client_view;
import static application.modules.client.view.client_view.backwards;
import static application.modules.client.view.client_view.beginning;
import static application.modules.client.view.client_view.clientstable;
import static application.modules.client.view.client_view.combopage;
import static application.modules.client.view.client_view.end;
import static application.modules.client.view.client_view.forward;
import static application.modules.client.view.client_view.list;
import static application.modules.client.view.client_view.numtab1;
import static application.modules.client.view.client_view.numtab2;
import static application.modules.client.view.client_view.numtab3;
import static application.modules.client.view.client_view.numtab4;
import static application.modules.client.view.client_view.numtab5;
import static application.modules.client.view.client_view.numtab6;
import static application.modules.client.view.client_view.numtab7;
import static application.modules.client.view.client_view.tabbedtable;
import application.modules.client.view.new_client_view;
import static application.modules.client.view.new_client_view.avatarlabel;
import static application.modules.client.view.new_client_view.datebirthdaylabel;
import static application.modules.client.view.new_client_view.dnilabel;
import static application.modules.client.view.new_client_view.emaillabel;
import static application.modules.client.view.new_client_view.emptyButton;
import static application.modules.client.view.new_client_view.namelabel;
import static application.modules.client.view.new_client_view.passwordlabel;
import static application.modules.client.view.new_client_view.phonelabel;
import static application.modules.client.view.new_client_view.saveLabel;
import static application.modules.client.view.new_client_view.statuslabel;
import static application.modules.client.view.new_client_view.subnamelabel;
import static application.modules.client.view.new_client_view.usernamelabel;
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
import static application.modules.client.view.client_view.clientcreated;
import static application.modules.client.view.new_client_view.client_typelabel;
import static application.modules.client.view.new_client_view.dischargedatelabel;
import application.modules.login.controller.login_controller;
import application.modules.login.view.login_view;
import javax.swing.JOptionPane;

/**
 *
 * @author nacho
 */
public class client_controller implements ActionListener {

    public static client_view client_v;
    public static new_client_view client_f;

    public client_controller(JFrame inicio, int i) {
        switch (i) {
            case 0:
                client_v = (client_view) inicio;
                break;
            case 1:
                client_f = (new_client_view) inicio;
                break;
        }
    }

    public enum action {
        //Client_v
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
        clientstable,
        //Client_f
        discartButton,
        emptyButton,
        saveClientButton,
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
        dischargedateField,
        hiringdateField,
        client_typeField,
        shoppingField,
    }

    public void init(String type) {
        switch (type) {
            case "v":
                closeV();
                client_v.setTitle("Clients");
                client_v.setLocationRelativeTo(null);
                client_v.setVisible(true);
                numtab1.setVisible(false);
                numtab2.setVisible(false);
                numtab3.setVisible(false);
                numtab4.setVisible(false);
                numtab5.setVisible(false);
                numtab6.setVisible(false);
                numtab7.setVisible(false);
                singleton.pagerC = new PagerC();
                singleton.pagerC.setPage(0);
                Timer timer = new Timer(10000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        clientcreated.setVisible(false);
                    }
                });

                client_view.clientstable.setName("clientstable");
                client_view.createAButton.setActionCommand("createAButton");
                client_view.createAButton.addActionListener(this);
                client_view.changeDataAButton.setActionCommand("changeDataAButton");
                client_view.changeDataAButton.addActionListener(this);
                client_view.deleteDataAButton.setActionCommand("deleteDataAButton");
                client_view.deleteDataAButton.addActionListener(this);
                client_view.findAButton.setActionCommand("findAButton");
                client_view.findAButton.addActionListener(this);
                client_view.sortbyAButton.setActionCommand("sortbyAButton");
                client_view.sortbyAButton.addActionListener(this);
                client_view.exportAButton.setActionCommand("exportAButton");
                client_view.exportAButton.addActionListener(this);
                client_view.importAButton.setActionCommand("importAButton");
                client_view.importAButton.addActionListener(this);
                client_view.backwards.setActionCommand("backwards");
                client_view.backwards.addActionListener(this);
                client_view.forward.setActionCommand("forward");
                client_view.forward.addActionListener(this);
                client_view.beginning.setActionCommand("beginning");
                client_view.beginning.addActionListener(this);
                client_view.end.setActionCommand("end");
                client_view.end.addActionListener(this);
                client_view.pagefield.setActionCommand("pagefield");
                client_view.pagefield.addActionListener(this);
                client_view.combopage.setActionCommand("combopage");
                client_view.combopage.addActionListener(this);
                client_view.listmenu.setActionCommand("listmenu");
                client_view.listmenu.addActionListener(this);
                client_view.formmenu.setActionCommand("formmenu");
                client_view.formmenu.addActionListener(this);
                client_view.backA.setActionCommand("backA");
                client_view.backA.addActionListener(this);
                client_view.numtab1.setActionCommand("numtab1");
                client_view.numtab1.addActionListener(this);
                client_view.numtab2.setActionCommand("numtab2");
                client_view.numtab2.addActionListener(this);
                client_view.numtab3.setActionCommand("numtab3");
                client_view.numtab3.addActionListener(this);
                client_view.numtab4.setActionCommand("numtab4");
                client_view.numtab4.addActionListener(this);
                client_view.numtab5.setActionCommand("numtab5");
                client_view.numtab5.addActionListener(this);
                client_view.numtab6.setActionCommand("numtab6");
                client_view.numtab6.addActionListener(this);
                client_view.numtab7.setActionCommand("numtab7");
                client_view.numtab7.addActionListener(this);
                updatetable();
                timer.start();
                break;
            case "f":
                client_f.setTitle("Create new client");
                client_f.setLocationRelativeTo(null);
                client_f.setVisible(true);
                saveLabel.setVisible(false);
                dnilabel.setVisible(false);
                namelabel.setVisible(false);
                subnamelabel.setVisible(false);
                emaillabel.setVisible(false);
                statuslabel.setVisible(false);
                usernamelabel.setVisible(false);
                passwordlabel.setVisible(false);
                client_typelabel.setVisible(false);
                datebirthdaylabel.setVisible(false);
                dischargedatelabel.setVisible(false);
                phonelabel.setVisible(false);
                avatarlabel.setVisible(false);
                new_client_view.saveClientButton.setActionCommand("saveClientButton");
                new_client_view.saveClientButton.addActionListener(this);
                new_client_view.discartButton.setActionCommand("discartButton");
                new_client_view.discartButton.addActionListener(this);
                new_client_view.emptyButton.setActionCommand("emptyButton");
                new_client_view.emptyButton.addActionListener(this);
                new_client_view.dniField.setActionCommand("dniField");
                new_client_view.dniField.addActionListener(this);
                new_client_view.nameField.setActionCommand("nameField");
                new_client_view.nameField.addActionListener(this);
                new_client_view.subnameField.setActionCommand("subnameField");
                new_client_view.subnameField.addActionListener(this);
                new_client_view.phoneField.setActionCommand("phoneField");
                new_client_view.phoneField.addActionListener(this);
                new_client_view.emailField.setActionCommand("emailField");
                new_client_view.emailField.addActionListener(this);
                new_client_view.usernameField.setActionCommand("usernameField");
                new_client_view.usernameField.addActionListener(this);
                new_client_view.passwordField.setActionCommand("passwordField");
                new_client_view.passwordField.addActionListener(this);
                new_client_view.avatarbutton.setActionCommand("avatarbutton");
                new_client_view.avatarbutton.addActionListener(this);
                new_client_view.statusField.setActionCommand("statusField");
                new_client_view.statusField.addActionListener(this);
                new_client_view.client_typeField.setActionCommand("client_typeField");
                new_client_view.client_typeField.addActionListener(this);
                new_client_view.shoppingField.setActionCommand("shoppingField");
                new_client_view.shoppingField.addActionListener(this);

                new_client_view.dniField.addKeyListener(new java.awt.event.KeyAdapter() {
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
                new_client_view.nameField.addKeyListener(new java.awt.event.KeyAdapter() {
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
                new_client_view.subnameField.addKeyListener(new java.awt.event.KeyAdapter() {
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
                new_client_view.phoneField.addKeyListener(new java.awt.event.KeyAdapter() {
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
                new_client_view.emailField.addKeyListener(new java.awt.event.KeyAdapter() {
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
                new_client_view.usernameField.addKeyListener(new java.awt.event.KeyAdapter() {
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
                new_client_view.client_typeField.addKeyListener(new java.awt.event.KeyAdapter() {
                    @Override
                    public void keyTyped(java.awt.event.KeyEvent evt) {
                        client_typeFieldKeyTyped(evt);
                    }

                    @Override
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        client_typeFieldKeyPressed(evt);
                    }

                    @Override
                    public void keyReleased(java.awt.event.KeyEvent evt) {
                        client_typeFieldKeyReleased(evt);
                    }
                });
                new_client_view.statusField.addKeyListener(new java.awt.event.KeyAdapter() {
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
                new_client_view.passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
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
                new_client_view.shoppingField.addKeyListener(new java.awt.event.KeyAdapter() {
                    @Override
                    public void keyTyped(java.awt.event.KeyEvent evt) {
                        shoppingFieldKeyTyped(evt);
                    }

                    @Override
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        shoppingFieldKeyPressed(evt);
                    }

                    @Override
                    public void keyReleased(java.awt.event.KeyEvent evt) {
                        shoppingFieldKeyReleased(evt);
                    }
                });
                break;
        }
    }

    public void closeV() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                client_v.dispose();
                new controller(new app_view(), 0).init("menu");
            }
        });
    }

    public void closeF() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                client_f.dispose();
                new client_controller(new app_view(), 0).init("menu");
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (action.valueOf(ae.getActionCommand())) {
            //client_view
            case createAButton:
                client_v.dispose();
                new client_controller(new new_client_view(), 1).init("f");
                break;
            case changeDataAButton:
                singleton.pagerC.selectclient();
                if (bllC.editclient()) {
                    client_v.dispose();
                }
                break;
            case deleteDataAButton:
                singleton.pagerC.selectclient();
                if (singleton.pagerC.getSelected() != null) {
                    bllC.delete_clientMongo(singleton.clients.getClients().get(Integer.parseInt(singleton.pagerC.getSelected()) - 1).getDni());
                    singleton.clients.deleteData(Integer.parseInt(singleton.pagerC.getSelected()));
                    updatetable();
                    jsonC.createjson_auto();
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
                singleton.pagerC.backwards();
                updatetable();
                break;
            case forward:
                singleton.pagerC.forward();
                updatetable();
                break;
            case beginning:
                singleton.pagerC.setPage(0);
                forward.setEnabled(true);
                end.setEnabled(true);
                updatetable();
                break;
            case end:
                singleton.pagerC.setPage(singleton.admins.size() / singleton.pagerC.getMovepage());
                backwards.setEnabled(true);
                beginning.setEnabled(true);
                updatetable();
                break;
            case numtab1:
                numtab1.setForeground(Color.BLUE);
                singleton.pagerC.setSelectedpage(Integer.parseInt(numtab1.getText()) - 1);
                singleton.pagerC.setPage(Integer.parseInt(numtab1.getText()) - 1);
                updatetable();
                break;
            case numtab2:
                numtab2.setForeground(Color.BLUE);
                singleton.pagerC.setSelectedpage(Integer.parseInt(numtab2.getText()) - 1);
                singleton.pagerC.setPage(Integer.parseInt(numtab2.getText()) - 1);
                updatetable();
                break;
            case numtab3:
                numtab3.setForeground(Color.BLUE);
                singleton.pagerC.setSelectedpage(Integer.parseInt(numtab3.getText()) - 1);
                singleton.pagerC.setPage(Integer.parseInt(numtab3.getText()) - 1);
                updatetable();
                break;
            case numtab4:
                numtab4.setForeground(Color.BLUE);
                singleton.pagerC.setSelectedpage(Integer.parseInt(numtab4.getText()) - 1);
                singleton.pagerC.setPage(Integer.parseInt(numtab4.getText()) - 1);
                updatetable();
                break;
            case numtab5:
                numtab5.setForeground(Color.BLUE);
                singleton.pagerC.setSelectedpage(Integer.parseInt(numtab5.getText()) - 1);
                singleton.pagerC.setPage(Integer.parseInt(numtab5.getText()) - 1);
                updatetable();
                break;
            case numtab6:
                numtab6.setForeground(Color.BLUE);
                singleton.pagerC.setSelectedpage(Integer.parseInt(numtab6.getText()) - 1);
                singleton.pagerC.setPage(Integer.parseInt(numtab6.getText()) - 1);
                updatetable();
                break;
            case numtab7:
                numtab7.setForeground(Color.BLUE);
                singleton.pagerC.setSelectedpage(Integer.parseInt(numtab7.getText()) - 1);
                singleton.pagerC.setPage(Integer.parseInt(numtab7.getText()) - 1);
                updatetable();
                break;
            case pagefield:
                singleton.pagerC.pagefield();
                updatetable();
                break;
            case combopage:
                switch (combopage.getSelectedIndex()) {
                    case 0:
                        singleton.pagerC.setMovepage(10);
                        singleton.pagerC.setPage(0);
                        break;
                    case 1:
                        singleton.pagerC.setMovepage(20);
                        singleton.pagerC.setPage(0);
                        break;
                    case 2:
                        singleton.pagerC.setMovepage(50);
                        singleton.pagerC.setPage(0);
                    case 3:
                        singleton.pagerC.setMovepage(100);
                        singleton.pagerC.setPage(0);
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
                client_v.dispose();
                new controller(new app_view(), 0).init("menu");
                break;
            //new_client_view form
            case discartButton:
                if ("client".equals(SingletonF.typeconnected)) {
                    client_f.dispose();
                    new login_controller(new login_view()).init();
                } else {
                    client_f.dispose();
                    new client_controller(new client_view(), 0).init("v");
                }
                break;
            case emptyButton:
                break;
            case saveClientButton:
                if ("client".equals(SingletonF.typeconnected)) {
                    if (bllC.editClient()) {
                        client_f.dispose();
                        new login_controller(new login_view()).init();
                        jsonC.createjson_auto();
                        Config_json.create_conf_json();
                    }
                } else if (emptyButton.isVisible()) {
                    if (bllC.newClient()) {
                        client_f.dispose();
                        new client_controller(new client_view(), 0).init("v");
                        clientcreated.setText("Created");
                        clientcreated.setVisible(true);
                        jsonC.createjson_auto();
                        Config_json.create_conf_json();
                    }
                } else if (bllC.editClient()) {
                    client_f.dispose();
                    new client_controller(new client_view(), 0).init("v");
                    clientcreated.setText("Edited");
                    clientcreated.setVisible(true);
                    jsonC.createjson_auto();
                    Config_json.create_conf_json();
                }
                break;
            case dniField:
                bllC.validateDNI();
                break;
            case nameField:
                bllC.validateName();
                break;
            case subnameField:
                bllC.validateSubname();
                break;
            case phoneField:
                bllC.validatePhone();
                break;
            case emailField:
                bllC.validateEmail();
                break;
            case usernameField:
                bllC.validateUsername();
                break;
            case passwordField:
                bllC.validatePassword();
                break;
            case avatarbutton:
                bllC.validateAvatar();
                break;
            case statusField:
                bllC.validateStatus();
                break;
            case dischargedateField:
                break;
            case client_typeField:

                break;
            case shoppingField:
                bllC.validateShopping();
                break;
        }
    }

    private void dniFieldKeyTyped(java.awt.event.KeyEvent evt) {
        bllC.validateDNI();
        bllC.validateBirthday();
        bllC.validateDischargedate();
    }

    private void dniFieldKeyPressed(java.awt.event.KeyEvent evt) {
        bllC.validateDNI();
        bllC.validateBirthday();
        bllC.validateDischargedate();
    }

    private void dniFieldKeyReleased(java.awt.event.KeyEvent evt) {
        bllC.validateDNI();
        bllC.validateBirthday();
        bllC.validateDischargedate();
    }

    private void nameFieldKeyPressed(java.awt.event.KeyEvent evt) {
        bllC.validateName();
    }

    private void nameFieldKeyReleased(java.awt.event.KeyEvent evt) {
        bllC.validateName();
    }

    private void nameFieldKeyTyped(java.awt.event.KeyEvent evt) {
        bllC.validateName();
    }

    private void subnameFieldKeyPressed(java.awt.event.KeyEvent evt) {
        bllC.validateSubname();
    }

    private void subnameFieldKeyReleased(java.awt.event.KeyEvent evt) {
        bllC.validateSubname();
    }

    private void subnameFieldKeyTyped(java.awt.event.KeyEvent evt) {
        bllC.validateSubname();
    }

    private void phoneFieldKeyPressed(java.awt.event.KeyEvent evt) {
        bllC.validatePhone();
    }

    private void phoneFieldKeyReleased(java.awt.event.KeyEvent evt) {
        bllC.validatePhone();
    }

    private void phoneFieldKeyTyped(java.awt.event.KeyEvent evt) {
        bllC.validatePhone();
    }

    private void emailFieldKeyPressed(java.awt.event.KeyEvent evt) {
        bllC.validateEmail();
    }

    private void emailFieldKeyReleased(java.awt.event.KeyEvent evt) {
        bllC.validateEmail();
    }

    private void emailFieldKeyTyped(java.awt.event.KeyEvent evt) {
        bllC.validateEmail();
    }

    private void usernameFieldKeyPressed(java.awt.event.KeyEvent evt) {
        bllC.validateUsername();
    }

    private void usernameFieldKeyReleased(java.awt.event.KeyEvent evt) {
        bllC.validateUsername();
    }

    private void usernameFieldKeyTyped(java.awt.event.KeyEvent evt) {
        bllC.validateUsername();
    }

    private void passwordFieldKeyPressed(java.awt.event.KeyEvent evt) {
        bllC.validatePassword();
    }

    private void passwordFieldKeyReleased(java.awt.event.KeyEvent evt) {
        bllC.validatePassword();
    }

    private void passwordFieldKeyTyped(java.awt.event.KeyEvent evt) {
        bllC.validatePassword();
    }

    private void statusFieldKeyPressed(java.awt.event.KeyEvent evt) {
        bllC.validateStatus();
    }

    private void statusFieldKeyReleased(java.awt.event.KeyEvent evt) {
        bllC.validateStatus();
    }

    private void statusFieldKeyTyped(java.awt.event.KeyEvent evt) {
        bllC.validateStatus();
    }

    private void client_typeFieldKeyPressed(java.awt.event.KeyEvent evt) {
        bllC.validateClient_type();
    }

    private void client_typeFieldKeyReleased(java.awt.event.KeyEvent evt) {
        bllC.validateClient_type();
    }

    private void client_typeFieldKeyTyped(java.awt.event.KeyEvent evt) {
        bllC.validateClient_type();
    }

    private void shoppingFieldKeyReleased(java.awt.event.KeyEvent evt) {
        bllC.validateShopping();
    }

    private void shoppingFieldKeyTyped(java.awt.event.KeyEvent evt) {
        bllC.validateShopping();
    }

    private void shoppingFieldKeyPressed(java.awt.event.KeyEvent evt) {
        bllC.validateShopping();
    }

    public static void updatetable() {
        singleton.clients.getClients().clear();
        daoC.retrieve_admins();
        JTable jTable = new JTable() {
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        clientstable = jTable;
        clientstable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Num", "DNI", "Name", "Surname", "Phone", "Email", "User",
                    "Status", "Birthday", "Age", "Discharge Date", "Client Type",
                    "years_service", "shopping", "premium"
                }
        ));
        clientstable.addMouseListener(new MouseAdapter() {
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
        clientstable.setColumnSelectionAllowed(true);
        clientstable.getTableHeader().setReorderingAllowed(false);

        clientstable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clientstableMouseClicked(evt);
            }

            private void clientstableMouseClicked(MouseEvent evt) {
                singleton.pagerC.selectclient();
            }
        });

        list.setViewportView(clientstable);
        clientstable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        singleton.pagerC.setModel((DefaultTableModel) clientstable.getModel());
        // Creamos un ordenador de filas para el modelo
        TableRowSorter sorter = new TableRowSorter(singleton.pagerC.getModel());
        clientstable.setRowSorter(sorter);
        clientstable.setColumnSelectionAllowed(false);
        singleton.pagerC.updatetable2();
        singleton.pagerC.pagenum();
    }
}
