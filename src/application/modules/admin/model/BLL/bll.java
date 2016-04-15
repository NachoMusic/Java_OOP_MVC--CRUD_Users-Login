/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.modules.admin.model.BLL;

import application.models.Dates;
import application.modules.admin.controller.admin_controller;
import application.modules.admin.model.DAO.dao;
import application.bbdd.ConexionBD;
import application.bbdd.pool;
import application.modules.admin.model.models.admin;
import application.modules.users.model.singleton;
import application.modules.admin.view.new_admin_view;
import static application.modules.admin.view.new_admin_view.activityField;
import static application.modules.admin.view.new_admin_view.avatarField;
import static application.modules.admin.view.new_admin_view.datebirthdayField;
import static application.modules.admin.view.new_admin_view.defaultAvatar;
import static application.modules.admin.view.new_admin_view.dniField;
import static application.modules.admin.view.new_admin_view.emailField;
import static application.modules.admin.view.new_admin_view.emptyButton;
import static application.modules.admin.view.new_admin_view.hiringdateField;
import static application.modules.admin.view.new_admin_view.nameField;
import static application.modules.admin.view.new_admin_view.passwordField;
import static application.modules.admin.view.new_admin_view.phoneField;
import static application.modules.admin.view.new_admin_view.salaryField;
import static application.modules.admin.view.new_admin_view.saveAdminButton;
import static application.modules.admin.view.new_admin_view.saveLabel;
import static application.modules.admin.view.new_admin_view.statusField;
import static application.modules.admin.view.new_admin_view.subnameField;
import static application.modules.admin.view.new_admin_view.usernameField;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.ImageIcon;
import static application.modules.admin.view.admin_view.Admintochange;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author nacho
 */
public class bll {

    public static boolean validateDNI() {
        return dao.validateDNI();
    }

    public static boolean validateName() {
        return dao.validateName();
    }

    public static boolean validateSubname() {
        return dao.validateSubname();
    }

    public static boolean validatePhone() {
        return dao.validatePhone();
    }

    public static boolean validateEmail() {
        return dao.validateEmail();
    }

    public static boolean validateUsername() {
        return dao.validateUsername();
    }

    public static boolean validatePassword() {
        return dao.validatePassword();
    }

    public static String validateAvatar() {
        return dao.validateAvatar();
    }

    public static boolean validateStatus() {
        return dao.validateStatus();
    }

    public static boolean validateBirthday() {
        return dao.validateBirthday();
    }

    public static boolean validateHiringdate() {
        return dao.validateHiringdate();
    }

    public static boolean validateSalary() {
        return dao.validateSalary();
    }

    public static boolean validateActivity() {
        return dao.validateActivity();
    }

    public static boolean editadmin() {
        boolean validA = false;
        if (singleton.pagerA.getSelected() != null) {
            Admintochange = Integer.parseInt(singleton.pagerA.getSelected());
            //new new_admin_view().setVisible(true);
            new admin_controller(new new_admin_view(), 1).init("f");
            saveAdminButton.setText("Edit Admin");
            emptyButton.setVisible(false);
            dniField.setText(singleton.admins.getData(Admintochange - 1).getDni());
            nameField.setText(singleton.admins.getData(Admintochange - 1).getName());
            subnameField.setText(singleton.admins.getData(Admintochange - 1).getSubname());
            phoneField.setText(singleton.admins.getData(Admintochange - 1).getPhone_number());
            emailField.setText(singleton.admins.getData(Admintochange - 1).getEmail());
            usernameField.setText(singleton.admins.getData(Admintochange - 1).getUser());
            passwordField.setText(singleton.admins.getData(Admintochange - 1).getPass());
            avatarField.setText(singleton.admins.getData(Admintochange - 1).getAvatar());
            statusField.setText(singleton.admins.getData(Admintochange - 1).getState());
            Dates b = new Dates(singleton.admins.getData(Admintochange - 1).getDate_birthday());
            datebirthdayField.setCalendar(b.DateToCalendar());
            Dates h = new Dates(singleton.admins.getData(Admintochange - 1).getHirin_date());
            hiringdateField.setCalendar(h.DateToCalendar());
            salaryField.setText(singleton.admins.getData(Admintochange - 1).getSalary() + "");
            activityField.setText(singleton.admins.getData(Admintochange - 1).getActivity() + "");
            try {
                ImageIcon icon = new ImageIcon(singleton.admins.getData(Admintochange - 1).getAvatar());
                Image imgn = icon.getImage();
                Image newimg = imgn.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
                ImageIcon newIcon = new ImageIcon(newimg);
                avatarField.setIcon(newIcon);
                avatarField.setText(singleton.admins.getData(Admintochange - 1).getAvatar());
            } catch (Exception E) {
                avatarField.setIcon(defaultAvatar);
                avatarField.setText("src/application/modules/admin/view/img/" + singleton.admins.getData(Admintochange - 1).getDni());
            }

            validA = true;
        }
        return validA;
    }

    public static boolean newAdmin() {
        boolean validA = true;
        String dni, name, subname, phone_number, email, user, pass, avatar,
                state, date_birthday, hiring_date;
        float salary;
        int activity;

        if (validateDNI() && validateName() && validateSubname() && validatePhone()
                && validateEmail() && validateUsername() && validatePassword()
                && validateStatus() && validateBirthday() && validateHiringdate()
                && validateSalary() && validateActivity()) {
            validA = true;
            dni = dniField.getText();
            name = nameField.getText();
            subname = subnameField.getText();
            phone_number = phoneField.getText();
            email = emailField.getText();
            user = usernameField.getText();
            pass = passwordField.getText();

            File origen = new File(avatarField.getText());
            File destino = new File("src/application/modules/admin/view/img/" + dniField.getText());
            try {
                InputStream in = new FileInputStream(origen);
                OutputStream out = new FileOutputStream(destino);
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                in.close();
                out.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            avatar = "src/application/modules/admin/view/img/" + dniField.getText();

            state = statusField.getText();
            Dates date = new Dates("");
            date_birthday = date.DateToString(datebirthdayField.getCalendar(), 0);
            hiring_date = date.DateToString(hiringdateField.getCalendar(), 0);
            salary = Float.parseFloat(salaryField.getText());
            activity = Integer.parseInt(activityField.getText());

            singleton.admins.addData(new admin(dni, name, subname, phone_number,
                    email, user, pass, avatar, state, date_birthday, hiring_date, salary, activity));
        } else {
            saveLabel.setVisible(true);
            saveLabel.setText("The admin was not created, check the errors in the fields");
            validA = false;
        }
        return validA;
    }

    public static boolean editAdmin() {
        boolean validA = true;
        String dni, name, subname, phone_number, email, user, pass, avatar,
                state, date_birthday, hiring_date;
        float salary;
        int activity;

        if (validateDNI() && validateName() && validateSubname() && validatePhone()
                && validateEmail() && validateUsername() && validatePassword()
                && validateStatus() && validateBirthday() && validateHiringdate()
                && validateSalary() && validateActivity()) {
            validA = true;
            dni = dniField.getText();
            name = nameField.getText();
            subname = subnameField.getText();
            phone_number = phoneField.getText();
            email = emailField.getText();
            user = usernameField.getText();
            pass = passwordField.getText();
            try {
                File origen = new File(avatarField.getText());
                File destino = new File("src/application/modules/admin/view/img/" + dniField.getText());
                String b = "src/application/modules/admin/view/img/" + dniField.getText();
                if (!avatarField.getText().equals(b)) {
                    InputStream in = new FileInputStream(origen);
                    OutputStream out = new FileOutputStream(destino);
                    byte[] buf = new byte[1024];
                    int len;
                    while ((len = in.read(buf)) > 0) {
                        out.write(buf, 0, len);
                    }
                    in.close();
                    out.close();
                }
            } catch (Exception e) {
            }
            avatar = "src/application/modules/admin/view/img/" + dniField.getText();

            state = statusField.getText();
            Dates date = new Dates("");
            date_birthday = date.DateToString(datebirthdayField.getCalendar(), 0);
            hiring_date = date.DateToString(hiringdateField.getCalendar(), 0);
            salary = Float.parseFloat(salaryField.getText());
            activity = Integer.parseInt(activityField.getText());
            singleton.admins.getData(Admintochange - 1).setDni(dni);
            singleton.admins.getData(Admintochange - 1).setName(name);
            singleton.admins.getData(Admintochange - 1).setSubname(subname);
            singleton.admins.getData(Admintochange - 1).setPhone_number(phone_number);
            singleton.admins.getData(Admintochange - 1).setEmail(email);
            singleton.admins.getData(Admintochange - 1).setUser(user);
            singleton.admins.getData(Admintochange - 1).setPass(pass);
            singleton.admins.getData(Admintochange - 1).setAvatar(avatar);
            singleton.admins.getData(Admintochange - 1).setState(state);
            singleton.admins.getData(Admintochange - 1).setDate_birthday(date_birthday);
            singleton.admins.getData(Admintochange - 1).setHirin_date(hiring_date);
            singleton.admins.getData(Admintochange - 1).setSalary(salary);
            singleton.admins.getData(Admintochange - 1).setActivity(activity);
        } else {
            saveLabel.setVisible(true);
            saveLabel.setText("The admin was not edited, check the errors in the fields");
            validA = false;
        }
        return validA;
    }

    public static boolean saveadminsBBDD() throws SQLException {
        Connection _con = null;
        boolean valid;
        
        _con = pool.getConexion();
        valid = dao.saveadminsBBDD(_con);
        pool.liberaConexion(_con);
        return valid;
    }
    
    public static boolean deleteadminBBDD(){
        Connection _con = null;
        boolean valid=true;

        _con = pool.getConexion();
        valid=dao.deleteadminBBDD(_con);
        pool.liberaConexion(_con);
        return valid;
    }

    public static boolean createadminBBDD(){
        boolean valid=true;
        Connection _con = null;

        _con = pool.getConexion();
        valid=dao.createadminBBDD(_con);
        pool.liberaConexion(_con);
        return valid;
    }
    
    public static boolean editadminBBDD(){
        boolean valid=true;
        Connection _con = null;
        _con = pool.getConexion();
        dao.editadminBBDD(_con);
        pool.liberaConexion(_con);

        return valid;
    }
    
    public static boolean readadminsBBDD(){
        boolean valid=true;
        Connection _con = null;

        _con = pool.getConexion();
        dao.readadminsBBDD(_con);
        pool.liberaConexion(_con);

        return valid;
    }
    
}
