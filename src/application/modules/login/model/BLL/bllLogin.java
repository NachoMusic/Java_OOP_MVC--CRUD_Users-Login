/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.modules.login.model.BLL;

import application.bbdd.pool;
import application.modules.login.model.DAO.daoLogin;
import java.sql.Connection;

/**
 *
 * @author nacho
 */
public class bllLogin {
    public static boolean sign_in_Admin() {
        boolean valid = true;
        Connection _con = null;
        _con = pool.getConexion();
        daoLogin.sign_in_Admin(_con);
        pool.liberaConexion(_con);
        return valid;
    }
    
    public static boolean sign_in_Usreg() {
        return daoLogin.sign_in_Usreg();
    }
    
    public static boolean sign_in_Cliente() {
        return daoLogin.sign_in_Client();
    }
}
