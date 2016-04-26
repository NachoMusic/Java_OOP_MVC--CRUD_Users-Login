/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.modules.login.model.BLL;

import application.modules.login.model.DAO.daoLogin;

/**
 *
 * @author nacho
 */
public class bllLogin {
    public static boolean sign_in_Admin() {
        return daoLogin.sign_in_Admin();
    }
    
    public static boolean sign_in_Usreg() {
        return daoLogin.sign_in_Usreg();
    }
}
