/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.modules.users.model.BLL;

import application.models.Dates;
import application.modules.users.model.DAO.dao;
import application.modules.users.model.models.admin;
import application.modules.users.model.models.singleton;
import static application.modules.users.view.new_admin_view.activityField;
import static application.modules.users.view.new_admin_view.avatarField;
import static application.modules.users.view.new_admin_view.datebirthdayField;
import static application.modules.users.view.new_admin_view.dniField;
import static application.modules.users.view.new_admin_view.emailField;
import static application.modules.users.view.new_admin_view.hiringdateField;
import static application.modules.users.view.new_admin_view.nameField;
import static application.modules.users.view.new_admin_view.passwordField;
import static application.modules.users.view.new_admin_view.phoneField;
import static application.modules.users.view.new_admin_view.salaryField;
import static application.modules.users.view.new_admin_view.saveLabel;
import static application.modules.users.view.new_admin_view.statusField;
import static application.modules.users.view.new_admin_view.subnameField;
import static application.modules.users.view.new_admin_view.usernameField;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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

    public static boolean newAdmin() {
        System.out.println("new admin");
        boolean valid[] = new boolean[6];
        boolean validA = true;
        String dni = "", name = "", subname = "", phone_number = "", email = "", user = "", pass = "",
                avatar = "", state = "", date_birthday = "", hiring_date = "", sdate;
        float salary = 0;
        int activity = 0;
        String dateFormat = "";
        /*
        switch (SingletonF.configApp.getDate_config()) {
            case 0:
                dateFormat = "dd/mm/yyyy";
                break;
            case 1:
                dateFormat = "dd-mm-yyyy";
                break;
            case 2:
                dateFormat = "yyyy/mm/dd";
                break;
            case 3:
                dateFormat = "yyyy-mm-dd";
                break;
        }
        
        if (GenericKernel.insertDni(SingletonF.language.getProperty("typedni"), "DNI", dniField.getText())) {
            dni = dniField.getText();
            valid[0] = true;
        } else {
            valid[0] = false;
        }

        if (GenericKernel.insertText(SingletonF.language.getProperty("name"), SingletonF.language.getProperty("name2"), nameField.getText())) {
            name = nameField.getText();
            valid[1] = true;
        } else {
            valid[1] = false;
        }
        if (GenericKernel.insertText(SingletonF.language.getProperty("subname"), SingletonF.language.getProperty("subname2"), subnameField.getText())) {
            subname = subnameField.getText();
            valid[2] = true;
        } else {
            valid[2] = false;
        }

        if (GenericKernel.insertPhone(SingletonF.language.getProperty("insertphone"), SingletonF.language.getProperty("insertphone2"), phoneField.getText())) {
            phone_number = phoneField.getText();
            valid[3] = true;
        } else {
            valid[3] = false;
        }

        if (GenericKernel.insertEmail(SingletonF.language.getProperty("email"), "Email", emailField.getText())) {
            email = emailField.getText();
            emaillabel.setText("Correct");
            valid[4] = true;
        } else {
            emaillabel.setVerifyInputWhenFocusTarget(true);
            emaillabel.setText("Incorrect email");
            valid[4] = false;
        }
        user = usernameField.getText();
        pass = passwordField.getText();
        avatar = avatarField.getText();
        state = statusField.getText();
        Dates dateB = new Dates("");
        if (GenericKernel.insertDateBirthday(SingletonF.language.getProperty("date_birthday") + dateFormat, SingletonF.language.getProperty("date_birthday2"), dateB.DateToString(datebirthdayField.getCalendar(), 0))) {
            date_birthday = dateB.DateToString(datebirthdayField.getCalendar(), 0);
            datebirthdaylabel.setText("Correct");
            valid[5] = true;
        } else {
            datebirthdaylabel.setVisible(true);
            datebirthdaylabel.setText("Incorrect birthday");
            valid[5] = false;
        }
        if (GenericKernel.insertUpDate(SingletonF.language.getProperty("hiring_date") + dateFormat, SingletonF.language.getProperty("hiring_date2"), date_birthday, dateB.DateToString(hiringdateField.getCalendar(), 0))) {
            hiring_date = dateB.DateToString(hiringdateField.getCalendar(), 0);
            hiringdatelabel.setText("Correct");
        } else {
            hiringdatelabel.setText("Incorrect hiring date");
            hiringdatelabel.setVisible(true);
        }
        try {
            salary = Float.parseFloat(salaryField.getText());
        } catch (Exception E) {
        }
        try {
            activity = Integer.parseInt(activityField.getText());
        } catch (Exception E) {
        }*/
 /*for (int i = 0; i < valid.length; i++) {
            if (!valid[i]) {
                validA = false;
            }
        }*/
        System.out.print("a");
        //System.out.println(validateBirthday() + " ASFD");
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
            File destino = new File("src/application/modules/users/view/img/" + dniField.getText());
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
            //avatar = avatarField.getText();
            avatar = "src/application/modules/users/view/img/" + dniField.getText();
            state = statusField.getText();
            Dates date = new Dates("");
            date_birthday = date.DateToString(datebirthdayField.getCalendar(), 0);
            hiring_date = date.DateToString(hiringdateField.getCalendar(), 0);
            salary = Float.parseFloat(salaryField.getText());
            activity = Integer.parseInt(activityField.getText());

            singleton.admins.addData(new admin(dni, name, subname, phone_number, email, user, pass, avatar, state,
                    date_birthday, hiring_date, salary, activity));
            System.out.println("Admin created");
        } else {
            saveLabel.setVisible(true);
            saveLabel.setText("The admin was not created, check the errors in the fields");
            validA = false;
        }
        return validA;
    }
}
