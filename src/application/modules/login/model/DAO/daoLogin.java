/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.modules.login.model.DAO;

import static application.modules.login.controller.login_controller.login;
import application.modules.login.view.login_view;
import application.modules.registered.model.BLL.bllR;
import application.modules.registered.model.models.registered_user;
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
            /*login.dispose();
            new controller(new app_view(), 0).init("menu");*/
            if (bllR.editadmin()) {
                    login.dispose();
                }
        } else {
            login_view.wrongpass.setVisible(true);
        }
        return valid;
    }
}
