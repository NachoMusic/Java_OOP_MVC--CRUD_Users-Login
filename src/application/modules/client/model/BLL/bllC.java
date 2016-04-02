/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.modules.client.model.BLL;

import application.models.Dates;
import application.modules.admin.model.models.singleton;
import application.modules.client.controller.client_controller;
import application.modules.client.model.DAO.daoC;
import application.modules.client.model.models.client;
import application.modules.client.view.new_client_view;
import static application.modules.client.view.new_client_view.activityField;
import static application.modules.client.view.new_client_view.avatarField;
import static application.modules.client.view.new_client_view.datebirthdayField;
import static application.modules.client.view.new_client_view.defaultAvatar;
import static application.modules.client.view.new_client_view.dniField;
import static application.modules.client.view.new_client_view.emailField;
import static application.modules.client.view.new_client_view.emptyButton;
import static application.modules.client.view.new_client_view.hiringdateField;
import static application.modules.client.view.new_client_view.nameField;
import static application.modules.client.view.new_client_view.passwordField;
import static application.modules.client.view.new_client_view.phoneField;
import static application.modules.client.view.new_client_view.salaryField;
import static application.modules.client.view.new_client_view.saveClientButton;
import static application.modules.client.view.new_client_view.saveLabel;
import static application.modules.client.view.new_client_view.statusField;
import static application.modules.client.view.new_client_view.subnameField;
import static application.modules.client.view.new_client_view.usernameField;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.ImageIcon;
import static application.modules.client.view.client_view.Clienttochange;

/**
 *
 * @author nacho
 */
public class bllC {

    public static boolean validateDNI() {
        return daoC.validateDNI();
    }

    public static boolean validateName() {
        return daoC.validateName();
    }

    public static boolean validateSubname() {
        return daoC.validateSubname();
    }

    public static boolean validatePhone() {
        return daoC.validatePhone();
    }

    public static boolean validateEmail() {
        return daoC.validateEmail();
    }

    public static boolean validateUsername() {
        return daoC.validateUsername();
    }

    public static boolean validatePassword() {
        return daoC.validatePassword();
    }

    public static String validateAvatar() {
        return daoC.validateAvatar();
    }

    public static boolean validateStatus() {
        return daoC.validateStatus();
    }

    public static boolean validateBirthday() {
        return daoC.validateBirthday();
    }
/*
    public static boolean validateHiringdate() {
        return daoC.validateHiringdate();
    }

    public static boolean validateSalary() {
        return daoC.validateSalary();
    }

    public static boolean validateActivity() {
        return daoC.validateActivity();
    }
*/
    public static boolean editclient() {
        boolean validA = false;
        if (singleton.pagerA.getSelected() != null) {
            Clienttochange = Integer.parseInt(singleton.pagerA.getSelected());
            new client_controller(new new_client_view(), 1).init("f");
            saveClientButton.setText("Edit Client");
            emptyButton.setVisible(false);
            dniField.setText(singleton.clients.getData(Clienttochange - 1).getDni());
            nameField.setText(singleton.clients.getData(Clienttochange - 1).getName());
            subnameField.setText(singleton.clients.getData(Clienttochange - 1).getSubname());
            phoneField.setText(singleton.clients.getData(Clienttochange - 1).getPhone_number());
            emailField.setText(singleton.clients.getData(Clienttochange - 1).getEmail());
            usernameField.setText(singleton.clients.getData(Clienttochange - 1).getUser());
            passwordField.setText(singleton.clients.getData(Clienttochange - 1).getPass());
            avatarField.setText(singleton.clients.getData(Clienttochange - 1).getAvatar());
            statusField.setText(singleton.clients.getData(Clienttochange - 1).getState());
            Dates b = new Dates(singleton.clients.getData(Clienttochange - 1).getDate_birthday());
            datebirthdayField.setCalendar(b.DateToCalendar());
            /*
            Dates h = new Dates(singleton.admins.getData(Clienttochange - 1).getHirin_date());
            hiringdateField.setCalendar(h.DateToCalendar());
            salaryField.setText(singleton.admins.getData(Clienttochange - 1).getSalary() + "");
            activityField.setText(singleton.admins.getData(Clienttochange - 1).getActivity() + "");*/
            try {
                ImageIcon icon = new ImageIcon(singleton.admins.getData(Clienttochange - 1).getAvatar());
                Image imgn = icon.getImage();
                Image newimg = imgn.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
                ImageIcon newIcon = new ImageIcon(newimg);
                avatarField.setIcon(newIcon);
                avatarField.setText(singleton.admins.getData(Clienttochange - 1).getAvatar());
            } catch (Exception E) {
                avatarField.setIcon(defaultAvatar);
                avatarField.setText("src/application/modules/admin/view/img/" + singleton.clients.getData(Clienttochange - 1).getDni());
            }

            validA = true;
        }
        return validA;
    }

    public static boolean newClient() {
        boolean validA = true;
        String dni, name, subname, phone_number, email, user, pass, avatar,
                state, date_birthday, hiring_date;
        float salary;
        int activity;

        if (validateDNI() && validateName() && validateSubname() && validatePhone()
                && validateEmail() && validateUsername() && validatePassword()
                && validateStatus() && validateBirthday() /*&& validateHiringdate()
                && validateSalary() && validateActivity()*/) {
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
            //"dischargedate","clienttype","yearsservice","shopping","premium"
            singleton.clients.addData(new client(dni, name, subname, phone_number,
                    email, user, pass, avatar, state, date_birthday,"dischargedate","clienttype",100.0f,true));
        } else {
            saveLabel.setVisible(true);
            saveLabel.setText("The client was not created, check the errors in the fields");
            validA = false;
        }
        return validA;
    }

    public static boolean editClient() {
        boolean validA = true;
        String dni, name, subname, phone_number, email, user, pass, avatar,
                state, date_birthday, hiring_date;
        float salary;
        int activity;

        if (validateDNI() && validateName() && validateSubname() && validatePhone()
                && validateEmail() && validateUsername() && validatePassword()
                && validateStatus() && validateBirthday() /*&& validateHiringdate()
                && validateSalary() && validateActivity()*/) {
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

            singleton.clients.getData(Clienttochange - 1).setDni(dni);
            singleton.clients.getData(Clienttochange - 1).setName(name);
            singleton.clients.getData(Clienttochange - 1).setSubname(subname);
            singleton.clients.getData(Clienttochange - 1).setPhone_number(phone_number);
            singleton.clients.getData(Clienttochange - 1).setEmail(email);
            singleton.clients.getData(Clienttochange - 1).setUser(user);
            singleton.clients.getData(Clienttochange - 1).setPass(pass);
            singleton.clients.getData(Clienttochange - 1).setAvatar(avatar);
            singleton.clients.getData(Clienttochange - 1).setState(state);
            singleton.clients.getData(Clienttochange - 1).setDate_birthday(date_birthday);
            /*
            singleton.admins.getData(Clienttochange - 1).setHirin_date(hiring_date);
            singleton.admins.getData(Clienttochange - 1).setSalary(salary);
            singleton.admins.getData(Clienttochange - 1).setActivity(activity);*/
        } else {
            saveLabel.setVisible(true);
            saveLabel.setText("The client was not edited, check the errors in the fields");
            validA = false;
        }
        return validA;
    }
}
