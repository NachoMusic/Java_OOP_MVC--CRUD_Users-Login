/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.modules.login.model.DAO;

import application.models.Dates;
import application.models.SingletonF;
import static application.modules.login.controller.login_controller.login;
import application.modules.login.view.login_view;
import application.modules.registered.controller.registered_controller;
import application.modules.registered.model.models.registered_user;
import application.modules.registered.view.new_registered_view;
import static application.modules.registered.view.new_registered_view.*;
import application.modules.users.model.singleton;

/**
 *
 * @author nacho
 */
public class daoLogin {

    public static boolean sign_in_Admin() {
        boolean valid = true;

        return valid;
    }

    public static boolean sign_in_Usreg() {
        boolean valid = true;
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
            SingletonF.usernameConnected=usreg.getUser();
        } else {
            login_view.wrongpass.setVisible(true);
        }
        return valid;
    }
}
