/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.modules.users.model.DAO;

import application.models.Dates;
import static application.modules.users.view.new_admin_view.*;
import application.utils.Validate;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author nacho
 */
public class dao {

    public static ImageIcon warning = new ImageIcon("src/application/view/img/warning.png");
    public static ImageIcon valid = new ImageIcon("src/application/view/img/ok.png");

    public static boolean validateDNI() {
        String DNIletters = "TRWAGMYFPDXBNJZSQVHLCKET";
        String number = "";
        int numberint;
        char lettercalc = ' ', lettergiven = ' ';
        boolean validate = false;

        validate = Validate.validateDni(dniField.getText());
        if (validate) {
            int[] vec = new int[dniField.getText().length() - 1];
            for (int i = 0; i < dniField.getText().length() - 1; i++) {
                vec[i] = dniField.getText().charAt(i) - '0';
            }
            for (int i = 0; i < dniField.getText().length() - 1; i++) {
                number += vec[i];
            }
            numberint = Integer.parseInt(number);
            lettercalc = DNIletters.charAt(numberint % 23);

            lettergiven = (dniField.getText().toUpperCase()).charAt(8);

            if (lettercalc == lettergiven) {
                dnilabel.setVisible(true);
                dnilabel.setIcon(valid);
            } else {
                dnilabel.setVisible(true);
                dnilabel.setIcon(warning);
            }
        } else {
            dnilabel.setVisible(true);
            dnilabel.setIcon(warning);
        }
        return validate;
    }

    public static boolean validateName() {
        boolean validate = false;
        if (Validate.validateText(nameField.getText())) {
            namelabel.setVisible(true);
            namelabel.setIcon(valid);
            validate= true;
        } else {
            namelabel.setVisible(true);
            namelabel.setIcon(warning);
        }
        return validate;
    }

    public static boolean validateSubname() {
        boolean validate = false;
        if (Validate.validateText(subnameField.getText())) {
            subnamelabel.setVisible(true);
            subnamelabel.setIcon(valid);
            validate = true;
        } else {
            subnamelabel.setVisible(true);
            subnamelabel.setIcon(warning);
        }
        return validate;
    }

    public static boolean validatePhone() {
        boolean validate = false;
        if (Validate.validatePhone(phoneField.getText())) {
            phonelabel.setVisible(true);
            phonelabel.setIcon(valid);
            validate = true;
        } else {
            phonelabel.setVisible(true);
            phonelabel.setIcon(warning);
        }
        return validate;
    }

    public static boolean validateEmail() {
        boolean validate = false;
        if (Validate.validateEmail(emailField.getText())) {
            emaillabel.setVisible(true);
            emaillabel.setIcon(valid);
            validate = true;
        } else {
            emaillabel.setVisible(true);
            emaillabel.setIcon(warning);
        }
        return validate;
    }

    public static boolean validateUsername() {
        boolean validate = false;
        if (usernameField.getText().isEmpty()) {
            usernamelabel.setVisible(true);
            usernamelabel.setIcon(warning);
        } else {
            usernamelabel.setVisible(true);
            usernamelabel.setIcon(valid);
            validate = true;
        }
        return validate;
    }

    public static boolean validatePassword() {
        boolean validate = false;
        if (passwordField.getText().isEmpty()) {
            passwordlabel.setVisible(true);
            passwordlabel.setIcon(warning);
        } else {
            passwordlabel.setVisible(true);
            passwordlabel.setIcon(valid);
            validate = true;
        }
        return validate;
    }

    public static boolean validateAvatar() {
        boolean validate = false;
        if (avatarField.getText().isEmpty()) {
            avatarlabel.setVisible(true);
            avatarlabel.setIcon(warning);
        } else {
            avatarlabel.setVisible(true);
            avatarlabel.setIcon(valid);
            validate = true;
        }
        return validate;
    }

    public static boolean validateStatus() {
        boolean validate = false;
        if (statusField.getText().isEmpty()) {
            statuslabel.setVisible(true);
            statuslabel.setIcon(warning);
        } else {
            statuslabel.setVisible(true);
            statuslabel.setIcon(valid);
            validate = true;
        }
        return validate;
    }

    public static boolean validateBirthday() {
        boolean validate = true;
        Dates date0 = new Dates("");
        Dates date1 = new Dates(date0.insertDate(datebirthdayField.getDateFormatString()));

        if (date1.compareWith(date1.DateToCalendar(), date1.SystemDate()) != 1) {
            validate = false;
            date1 = new Dates(date1.insertDate(datebirthdayField.getDateFormatString()));
        }
        if (date1.timeBetweetDates(date1.DateToCalendar(), date1.SystemDate(), 1) < 18) {
            JOptionPane.showMessageDialog(null, "You can't register until you're 18 years old");
            validate = false;
            date1 = new Dates(date1.insertDate(datebirthdayField.getDateFormatString()));
        }
        if (validate) {
            datebirthdaylabel.setVisible(true);
            datebirthdaylabel.setIcon(valid);
        } else {
            datebirthdaylabel.setVisible(true);
            datebirthdaylabel.setIcon(warning);
        }
        return validate;
    }

    public static boolean validateHiringdate() {
        boolean validate = true;
        int yearsDif = 0;
        Dates date1 = null;
        Dates date0 = new Dates("");
        date1 = new Dates(date0.insertDate(hiringdateField.getDateFormatString()));
        Dates date2 = new Dates(datebirthdayField.getDateFormatString());

        validate = true;
        if (date1.compareWith(date1.DateToCalendar(), date1.SystemDate()) != 1) {
            validate = false;
            date1 = new Dates(date1.insertDate(hiringdateField.getDateFormatString()));
        }
        yearsDif = date1.timeBetweetDates(date1.DateToCalendar(), date2.DateToCalendar(), 1);
        if (yearsDif < 18) {
            validate = false;
            JOptionPane.showMessageDialog(null, "You could not be hired until you were 18");
            date1 = new Dates(date1.insertDate(hiringdateField.getDateFormatString()));
        }

        if (date1.compareWith(date1.DateToCalendar(), date2.DateToCalendar()) == 1) {
            validate = false;
            JOptionPane.showMessageDialog(null, "The date can not be before your date birthday");
            date1 = new Dates(date1.insertDate(hiringdateField.getDateFormatString()));
        }
        if (validate) {
            hiringdatelabel.setVisible(true);
            hiringdatelabel.setIcon(valid);
        } else {
            hiringdatelabel.setVisible(true);
            hiringdatelabel.setIcon(warning);
        }
        return validate;
    }
    
    public static boolean validateSalary(){
        boolean validate = false;
        if (salaryField.getText().isEmpty()) {
            salarylabel.setVisible(true);
            salarylabel.setIcon(warning);
        } else {
            salarylabel.setVisible(true);
            salarylabel.setIcon(valid);
            validate = true;
        }
        return validate;
    }
    public static boolean validateActivity(){
        boolean validate = false;
        if (activityField.getText().isEmpty()) {
            activitylabel.setVisible(true);
            activitylabel.setIcon(warning);
        } else {
            activitylabel.setVisible(true);
            activitylabel.setIcon(valid);
            validate = true;
        }
        return validate;
    }
}
