/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.modules.registered.model.BLL;

import application.models.Dates;
import application.modules.admin.controller.admin_controller;
import application.modules.admin.model.models.singleton;
import application.modules.admin.view.new_admin_view;
import application.modules.registered.controller.registered_controller;
import application.modules.registered.model.DAO.daoR;
import application.modules.registered.model.models.registered_user;
import application.modules.registered.view.new_registered_view;
import static application.modules.registered.view.new_registered_view.activityField;
import static application.modules.registered.view.new_registered_view.avatarField;
import static application.modules.registered.view.new_registered_view.datebirthdayField;
import static application.modules.registered.view.new_registered_view.defaultAvatar;
import static application.modules.registered.view.new_registered_view.dniField;
import static application.modules.registered.view.new_registered_view.emailField;
import static application.modules.registered.view.new_registered_view.emptyButton;
import static application.modules.registered.view.new_registered_view.nameField;
import static application.modules.registered.view.new_registered_view.passwordField;
import static application.modules.registered.view.new_registered_view.phoneField;
import static application.modules.registered.view.new_registered_view.saveLabel;
import static application.modules.registered.view.new_registered_view.saveRegisteredButton;
import static application.modules.registered.view.new_registered_view.statusField;
import static application.modules.registered.view.new_registered_view.subnameField;
import static application.modules.registered.view.new_registered_view.usernameField;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.ImageIcon;
import static application.modules.registered.view.new_registered_view.karmaField;
import static application.modules.admin.view.admin_view.Admintochange;
import static application.modules.registered.view.registered_view.Registeredtochange;

/**
 *
 * @author nacho
 */
public class bllR {

    public static boolean validateDNI() {
        return daoR.validateDNI();
    }

    public static boolean validateName() {
        return daoR.validateName();
    }

    public static boolean validateSubname() {
        return daoR.validateSubname();
    }

    public static boolean validatePhone() {
        return daoR.validatePhone();
    }

    public static boolean validateEmail() {
        return daoR.validateEmail();
    }

    public static boolean validateUsername() {
        return daoR.validateUsername();
    }

    public static boolean validatePassword() {
        return daoR.validatePassword();
    }

    public static String validateAvatar() {
        return daoR.validateAvatar();
    }

    public static boolean validateStatus() {
        return daoR.validateStatus();
    }

    public static boolean validateBirthday() {
        return daoR.validateBirthday();
    }

    public static boolean validateKarma() {
        return daoR.validateKarma();
    }

    public static boolean validateActivity() {
        return daoR.validateActivity();
    }

    public static boolean editadmin() {
        boolean validA = false;
        if (singleton.pagerA.getSelected() != null) {
            Registeredtochange = Integer.parseInt(singleton.pagerA.getSelected());
            new registered_controller(new new_registered_view(), 1).init("f");
            saveRegisteredButton.setText("Edit Registered User");
            emptyButton.setVisible(false);
            dniField.setText(singleton.registered_users.getData(Registeredtochange - 1).getDni());
            nameField.setText(singleton.registered_users.getData(Registeredtochange - 1).getName());
            subnameField.setText(singleton.registered_users.getData(Registeredtochange - 1).getSubname());
            phoneField.setText(singleton.registered_users.getData(Registeredtochange - 1).getPhone_number());
            emailField.setText(singleton.registered_users.getData(Registeredtochange - 1).getEmail());
            usernameField.setText(singleton.registered_users.getData(Registeredtochange - 1).getUser());
            passwordField.setText(singleton.registered_users.getData(Registeredtochange - 1).getPass());
            avatarField.setText(singleton.registered_users.getData(Registeredtochange - 1).getAvatar());
            statusField.setText(singleton.registered_users.getData(Registeredtochange - 1).getState());
            Dates b = new Dates(singleton.registered_users.getData(Registeredtochange - 1).getDate_birthday());
            datebirthdayField.setCalendar(b.DateToCalendar());
            karmaField.setText(singleton.registered_users.getData(Admintochange - 1).getKarma());
            activityField.setText(singleton.registered_users.getData(Admintochange - 1).getActivity() + "");

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

    public static boolean newRegistered() {
        boolean validA = true;
        String dni, name, subname, phone_number, email, user, pass, avatar,
                state, date_birthday, karma;
        int activity;

        if (validateDNI() && validateName() && validateSubname() && validatePhone()
                && validateEmail() && validateUsername() && validatePassword()
                && validateStatus() && validateBirthday()
                && validateKarma() && validateActivity()) {
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
            karma = karmaField.getText();
            activity = Integer.parseInt(activityField.getText());

            singleton.registered_users.addData(new registered_user(dni, name, subname, phone_number,
                    email, user, pass, avatar, state, date_birthday, karma, activity));
        } else {
            saveLabel.setVisible(true);
            saveLabel.setText("The registered user was not created, check the errors in the fields");
            validA = false;
        }
        return validA;
    }

    public static boolean editAdmin() {
        boolean validA = true;
        String dni, name, subname, phone_number, email, user, pass, avatar,
                state, date_birthday, karma;
        int activity;

        if (validateDNI() && validateName() && validateSubname() && validatePhone()
                && validateEmail() && validateUsername() && validatePassword()
                && validateStatus() && validateBirthday()
                && validateKarma() && validateActivity()) {
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
            karma = karmaField.getText();
            activity = Integer.parseInt(activityField.getText());

            singleton.registered_users.getData(Admintochange - 1).setDni(dni);
            singleton.registered_users.getData(Admintochange - 1).setName(name);
            singleton.registered_users.getData(Admintochange - 1).setSubname(subname);
            singleton.registered_users.getData(Admintochange - 1).setPhone_number(phone_number);
            singleton.registered_users.getData(Admintochange - 1).setEmail(email);
            singleton.registered_users.getData(Admintochange - 1).setUser(user);
            singleton.registered_users.getData(Admintochange - 1).setPass(pass);
            singleton.registered_users.getData(Admintochange - 1).setAvatar(avatar);
            singleton.registered_users.getData(Admintochange - 1).setState(state);
            singleton.registered_users.getData(Admintochange - 1).setDate_birthday(date_birthday);
            singleton.registered_users.getData(Admintochange - 1).setKarma(karma);
            singleton.registered_users.getData(Admintochange - 1).setActivity(activity);
            
        } else {
            saveLabel.setVisible(true);
            saveLabel.setText("The registered user was not edited, check the errors in the fields");
            validA = false;
        }
        return validA;
    }
}
