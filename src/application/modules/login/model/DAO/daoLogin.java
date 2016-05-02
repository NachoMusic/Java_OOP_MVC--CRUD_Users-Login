/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.modules.login.model.DAO;

import application.models.Dates;
import application.models.SingletonF;
import application.modules.client.controller.client_controller;
import application.modules.client.model.models.client;
import application.modules.client.view.new_client_view;
import static application.modules.login.controller.login_controller.login;
import application.modules.login.view.login_view;
import application.modules.menu_config.controller.controller;
import application.modules.menu_config.view.app_view;
import application.modules.registered.controller.registered_controller;
import application.modules.registered.model.models.registered_user;
import application.modules.registered.view.new_registered_view;
import static application.modules.registered.view.new_registered_view.*;
import application.modules.users.model.singleton;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author nacho
 */
public class daoLogin {
    /**
     * Tries to sign in with a username and a password from the view comparing it
     * with the admins from the database mysql
     * 
     * @param _con The connection given by the bll
     * @return true if it was well done
     */
    public static boolean sign_in_Admin(Connection _con) {
        boolean valid = true;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = _con.prepareStatement("SELECT * FROM admins WHERE user ='" + login_view.usernameLogin.getText() + "'");
            rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.getString("pass").equals(login_view.passwordLogin.getText())) {
                    new controller(new app_view(), 0).init("menu");
                    login.dispose();
                } else {
                    login_view.wrongpass.setVisible(true);
                }
                valid = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al leer los admins");
            valid=false;
        }
        return valid;
    }
    /**
     * Tries to sign in with a username and a password from the view comparing it
     * with the registered users from the arraylist of the files
     * 
     * @return true, if it was well done
     */
    public static boolean sign_in_Usreg() {
        boolean valid = true;
        try {
            registered_user usreg = singleton.registered_users.find(2, login_view.usernameLogin.getText());
            if (usreg.getPass().equals(login_view.passwordLogin.getText())) {
                new registered_controller(new new_registered_view(), 1).init("f");
                saveRegisteredButton.setText("Edit your profile");
                emptyButton.setVisible(false);
                dniField.setText(usreg.getDni());
                nameField.setText(usreg.getName());
                subnameField.setText(usreg.getSubname());
                phoneField.setText(usreg.getPhone_number());
                emailField.setText(usreg.getEmail());
                usernameField.setText(usreg.getUser());
                passwordField.setText(usreg.getPass());
                avatarField.setText(usreg.getAvatar());
                statusField.setText(usreg.getState());
                Dates b = new Dates(usreg.getDate_birthday());
                datebirthdayField.setCalendar(b.DateToCalendar());
                karmaField.setText(usreg.getKarma());
                activityField.setText(usreg.getActivity() + "");
                login.dispose();
                discartButton.setText("Sign Out");
                SingletonF.usernameConnected = usreg.getUser();
            } else {
                login_view.wrongpass.setVisible(true);
                valid=false;
            }
        } catch(Exception e) {
            login_view.wrongpass.setVisible(true);
            valid=false;
        }
        return valid;
    }
    /**
     * Tries to sign in with a username and a password from the view comparing it
     * with the clients from the database mongo
     * @return true, if it was well done
     */
    public static boolean sign_in_Client() {
        boolean valid = true;
        try{
            client c = new client();
            DBCursor cur = SingletonF.collection.find(new BasicDBObject().append("user", login_view.usernameLogin.getText()));
            BasicDBObject document = (BasicDBObject) cur.next();
            c = c.DB_to_client(document);
            if(c.getPass().equals(login_view.passwordLogin.getText())){
                SingletonF.usernameConnected=login_view.usernameLogin.getText();
                login.dispose();
                new client_controller(new new_client_view(), 1).init("f");
                new_client_view.emptyButton.setVisible(false);
                new_client_view.saveClientButton.setText("Edit your profile");
                new_client_view.dniField.setText(c.getDni());
                new_client_view.nameField.setText(c.getName());
                new_client_view.subnameField.setText(c.getSubname());
                new_client_view.phoneField.setText(c.getPhone_number());
                new_client_view.emailField.setText(c.getEmail());
                new_client_view.usernameField.setText(c.getUser());
                new_client_view.passwordField.setText(c.getPass());
                new_client_view.avatarField.setText(c.getAvatar());
                new_client_view.statusField.setText(c.getState());
                Dates b = new Dates(c.getDate_birthday());
                new_client_view.datebirthdayField.setCalendar(b.DateToCalendar());
                b = new Dates(c.getDischarge_date());
                new_client_view.dischargedateField.setCalendar(b.DateToCalendar());
                new_client_view.client_typeField.setText(c.getClient_type());
                new_client_view.shoppingField.setText(c.getShopping()+"");
                new_client_view.premiumCheckbox.setSelected(c.isPremium());
                new_client_view.discartButton.setText("Sign Out");
            } else {
                login_view.wrongpass.setVisible(true);
                valid=false;
            }
        } catch (Exception e){
            login_view.wrongpass.setVisible(true);
            valid=false;
        }
        return valid;
    }
}
