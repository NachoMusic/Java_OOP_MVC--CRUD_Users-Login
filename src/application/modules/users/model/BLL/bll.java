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
    public static boolean validateDNI(){
        return dao.validateDNI();
    }
    public static boolean validateName(){
        return dao.validateName();
    }
    public static boolean validateSubname(){
        return dao.validateSubname();
    }
    public static boolean validatePhone(){
        return dao.validatePhone();
    }
    public static boolean validateEmail(){
        return dao.validateEmail();
    }
    public static boolean validateUsername(){
        return dao.validateUsername();
    }
    public static boolean validatePassword(){
        return dao.validatePassword();
    }
    public static boolean validateAvatar(){
        return dao.validateAvatar();
    }
    public static boolean validateStatus(){
        return dao.validateStatus();
    }
    public static boolean validateBirthday(){
        return dao.validateBirthday();
    }
    public static boolean validateHiringdate(){
        return dao.validateHiringdate();
    }
    public static boolean validateSalary(){
        return dao.validateSalary();
    }
    public static boolean validateActivity(){
        return dao.validateActivity();
    }
}
