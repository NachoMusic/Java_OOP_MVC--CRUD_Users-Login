/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import application.models.Config;
import application.models.Language;
import application.models.SingletonF;
import application.modules.users.model.BLL.lib_files.json;
import application.modules.users.model.BLL.lib_files.txt;
import application.modules.users.model.BLL.lib_files.xml;
import application.utils.Config_json;
import application.view.app_view;

/**
 *
 * @author nacho
 */
public class main {

    public static void main(String[] args) {
        SingletonF.configApp = new Config();
        Config_json.load_conf_json();
        SingletonF.language = new Language(SingletonF.configApp.getLanguage_config());
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
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new app_view().setVisible(true);
            }
        }
        );
        
        
    }
}
