/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.modules.users.model.BLL;

import application.modules.users.model.DAO.dao;

/**
 *
 * @author nacho
 */
public class bll {
    public static void validateDNI(){
        dao.validateDNI();
    }
    public static void validateName(){
        dao.validateName();
    }
    public static void validateSubname(){
        dao.validateSubname();
    }
}
