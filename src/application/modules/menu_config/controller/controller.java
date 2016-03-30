/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.modules.menu_config.controller;

import application.models.SingletonF;
import application.modules.menu_config.view.config_view;
import static application.modules.menu_config.view.config_view.comboCurrency;
import static application.modules.menu_config.view.config_view.dateCombo;
import static application.modules.menu_config.view.config_view.decimalsCombo;
import static application.modules.menu_config.view.config_view.dummiesOff;
import static application.modules.menu_config.view.config_view.dummiesOn;
import static application.modules.menu_config.view.config_view.howmanyDummies;
import static application.modules.menu_config.view.config_view.jsonbutton;
import static application.modules.menu_config.view.config_view.languageCombo;
import static application.modules.menu_config.view.config_view.successAddDum;
import static application.modules.menu_config.view.config_view.txtbutton;
import static application.modules.menu_config.view.config_view.xmlbutton;
import application.modules.menu_config.view.app_view;
import application.modules.users.controller.admin_controller;
import application.modules.users.model.BLL.Arraylist_admin;
import application.modules.users.model.BLL.lib_files.json;
import application.modules.users.model.BLL.lib_files.txt;
import application.modules.users.model.BLL.lib_files.xml;
import application.modules.users.model.kernel.Dummies;
import application.modules.users.model.models.singleton;
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
    public static config_view config;

    public controller(JFrame inicio, int i) {
        switch (i) {
            case 0:
                menu = (app_view) inicio;
                break;
            case 1:
                config =  (config_view) inicio;
                break;
        }
    }

    public enum action {
        //Menu
        adminsButton,
        clientsButton,
        usregButton,
        confButton,
        //Config
        comboCurrency,
        decimalsCombo,
        dateCombo,
        languageCombo,
        jsonbutton,
        txtbutton,
        xmlbutton,
        dummiesOn,
        dummiesOff,
        addRandomDummies,
        resetConf,
        closeC,
    }

    public void init(String type) {
        switch (type) {
            case "menu":
                menu.setLocationRelativeTo(null);
                menu.setVisible(true);
                menu.setTitle(SingletonF.language.getProperty("application_users"));
                app_view.adminsButton.setActionCommand("adminsButton");
                app_view.adminsButton.addActionListener(this);
                app_view.clientsButton.setActionCommand("clientsButton");
                app_view.clientsButton.addActionListener(this);
                app_view.usregButton.setActionCommand("usregButton");
                app_view.usregButton.addActionListener(this);
                app_view.confButton.setActionCommand("confButton");
                app_view.confButton.addActionListener(this);
                closeM();
                break;
            case "config":
                config.setLocationRelativeTo(null);
                config.setVisible(true);
                config_view.comboCurrency.setActionCommand("comboCurrency");
                config_view.comboCurrency.addActionListener(this);
                config_view.decimalsCombo.setActionCommand("decimalsCombo");
                config_view.decimalsCombo.addActionListener(this);
                config_view.dateCombo.setActionCommand("dataCombo");
                config_view.dateCombo.addActionListener(this);
                config_view.languageCombo.setActionCommand("languageCombo");
                config_view.languageCombo.addActionListener(this);
                config_view.jsonbutton.setActionCommand("jsonbutton");
                config_view.jsonbutton.addActionListener(this);
                config_view.txtbutton.setActionCommand("txtbutton");
                config_view.txtbutton.addActionListener(this);
                config_view.xmlbutton.setActionCommand("xmlbutton");
                config_view.xmlbutton.addActionListener(this);
                config_view.dummiesOn.setActionCommand("dummiesOn");
                config_view.dummiesOn.addActionListener(this);
                config_view.dummiesOff.setActionCommand("dummeisOff");
                config_view.dummiesOff.addActionListener(this);
                config_view.addRandomDummies.setActionCommand("addRandomDummies");
                config_view.addRandomDummies.addActionListener(this);
                config_view.resetConf.setActionCommand("resetConf");
                config_view.resetConf.addActionListener(this);
                config_view.closeC.setActionCommand("closeC");
                config_view.closeC.addActionListener(this);

                config.setTitle(SingletonF.language.getProperty("config"));
                switch (SingletonF.configApp.getCurrency_config()) {
                    case '€':
                        comboCurrency.setSelectedIndex(0);
                        break;
                    case '$':
                        comboCurrency.setSelectedIndex(1);
                        break;
                    case '£':
                        comboCurrency.setSelectedIndex(2);
                }
                decimalsCombo.setSelectedIndex(SingletonF.configApp.getDecimals_config()-1);
                try{
                    dateCombo.setSelectedIndex(SingletonF.configApp.getDate_config());
                }catch(Exception e){}
                switch (SingletonF.configApp.getLanguage_config()) {
                    case "English":
                        languageCombo.setSelectedIndex(0);
                        break;
                    case "Spanish":
                        languageCombo.setSelectedIndex(1);
                        break;
                }
                
                if (SingletonF.configApp.getDummiesmode()) {
                    dummiesOn.setSelected(true);
                } else {
                    dummiesOff.setSelected(true);
                }
                
                switch (SingletonF.configApp.getSavingextension()) {
                    case "json":
                        jsonbutton.setSelected(true);
                        break;
                    case "xml":
                        xmlbutton.setSelected(true);
                        break;
                    case "txt":
                        txtbutton.setSelected(true);
                        break;
                }
                closeC();
                break;
        }
    }

    public void closeM() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                menu.dispose();
                System.exit(0);
            }
        });
    }
    
    public void closeC() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                config.dispose();
                new controller(new app_view(),0).init("menu");
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (action.valueOf(ae.getActionCommand())) {
            //Menu
            case adminsButton:
                new admin_controller(new admin_view(), 0).init("v");
                break;

            case clientsButton:
                System.out.println("Clients");
                break;

            case usregButton:
                System.out.println("Usreg");
                break;

            case confButton:
                menu.dispose();
                new controller(new config_view(), 1).init("config");
                break;
            //Config
            case comboCurrency:
                char monedaAnterior;
                switch (comboCurrency.getSelectedIndex()) {
                    case 0:
                        monedaAnterior = SingletonF.configApp.getCurrency_config();
                        SingletonF.configApp.setCurrency_config('€');
                        singleton.admins.changeFormatCurrency(monedaAnterior);
                        break;
                    case 1:
                        monedaAnterior = SingletonF.configApp.getCurrency_config();
                        SingletonF.configApp.setCurrency_config('$');
                        singleton.admins.changeFormatCurrency(monedaAnterior);
                        break;
                    case 2:
                        monedaAnterior = SingletonF.configApp.getCurrency_config();
                        SingletonF.configApp.setCurrency_config('£');
                        singleton.admins.changeFormatCurrency(monedaAnterior);
                        break;
                }
                break;
            case decimalsCombo:
                SingletonF.configApp.setDecimals_config(decimalsCombo.getSelectedIndex() + 1);
                break;
            case dateCombo:
                SingletonF.configApp.setDate_config(dateCombo.getSelectedIndex());
                break;
            case languageCombo:
                switch (languageCombo.getSelectedIndex()) {
                    case 0:// English
                        SingletonF.configApp.setLanguage_config("English");
                        SingletonF.language.setIdioma(SingletonF.configApp.getLanguage_config());
                        break;
                    case 1:// Spanish
                        SingletonF.configApp.setLanguage_config("Spanish");
                        SingletonF.language.setIdioma(SingletonF.configApp.getLanguage_config());
                        break;
                }
                break;
            case jsonbutton:
                SingletonF.configApp.setSavingextension("json");
                break;
            case txtbutton:
                SingletonF.configApp.setSavingextension("txt");
                break;
            case xmlbutton:
                SingletonF.configApp.setSavingextension("xml");
                break;
            case dummiesOn:
                json.createjson_auto();
                xml.createxml_auto();
                txt.createtxt_auto();
                SingletonF.configApp.setDummiesmode(true);
                singleton.admins = new Arraylist_admin();
                switch (SingletonF.configApp.getSavingextension()) {
                    case "json"://json
                        json.load_json_auto();
                        break;
                    case "xml"://xml
                        xml.load_xml_auto();
                        break;
                    case "txt": //txt
                        txt.load_txt_auto();
                        break;
                }
                break;
            case dummiesOff:
                json.createjson_auto();
                xml.createxml_auto();
                txt.createtxt_auto();
                SingletonF.configApp.setDummiesmode(false);
                singleton.admins = new Arraylist_admin();
                switch (SingletonF.configApp.getSavingextension()) {
                    case "json"://json
                        json.load_json_auto();
                        break;
                    case "xml"://xml
                        xml.load_xml_auto();
                        break;
                    case "txt": //txt
                        txt.load_txt_auto();
                        break;
                }
                break;
            case addRandomDummies:
                Dummies.generatedummies(Integer.parseInt(howmanyDummies.getValue().toString()));
                successAddDum.setVisible(true);
                break;
            case resetConf:
                char monedaAnterior2 = SingletonF.configApp.getCurrency_config();
                SingletonF.language.setIdioma(SingletonF.configApp.getLanguage_config());
                for (int i = 0; i < singleton.admins.getAdmins().size(); i++) {
                    singleton.admins.getData(i).changeCurrency(monedaAnterior2);
                }
                SingletonF.configApp.setSavingextension("json");
                SingletonF.configApp.setDecimals_config(2);
                SingletonF.configApp.setLookandfeel(0);
                break;
            case closeC:
                config.dispose();
                new controller(new app_view(),0).init("menu");
        }
    }
}
