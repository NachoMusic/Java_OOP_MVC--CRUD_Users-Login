/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import application.bbdd.pool;
import application.modules.menu_config.model.Config;
import application.modules.menu_config.model.Language;
import application.models.SingletonF;
import static application.models.SingletonF.mongo;
import application.modules.menu_config.controller.controller;
import application.modules.admin.model.BLL.lib_files.json;
import application.modules.admin.model.BLL.lib_files.txt;
import application.modules.admin.model.BLL.lib_files.xml;
import application.modules.admin.view.new_admin_view;
import application.modules.client.model.BLL.lib_files.jsonC;
import application.utils.Config_json;
import application.modules.menu_config.view.app_view;
import application.modules.registered.model.BLL.lib_files.jsonR;
import application.mongodb.Mongo_DB;

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
        jsonC.load_json_auto();
        jsonR.load_json_auto();
        pool.inicializa_BasicDataSourceFactory();
        //mongo
        SingletonF.mongo = new Mongo_DB();
        SingletonF.nom_bd = mongo.getNom_bd();
        SingletonF.nom_table = mongo.getNom_table();
        SingletonF.client = Mongo_DB.connect();
        if (SingletonF.client != null) {
            SingletonF.db = mongo.getDb();
            SingletonF.collection = mongo.getCollection();
        }
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(new_admin_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(new_admin_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(new_admin_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(new_admin_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new controller(new app_view(),0).init("menu");
            }
        }
        );
    }
}
