/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.modules.users.model.DAO;

import application.models.Dates;
import static application.modules.users.view.new_admin_view.*;
import application.utils.Validate;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

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
            validate = true;
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

    public static String validateAvatar() {
        boolean validate = false;
        /*if (avatarField.getText().isEmpty()) {
            avatarlabel.setVisible(true);
            avatarlabel.setIcon(warning);
        } else {
            avatarlabel.setVisible(true);
            avatarlabel.setIcon(valid);
            validate = true;
        }*/
        FileNameExtensionFilter img = new FileNameExtensionFilter("JPG image", "jpg");
        JFileChooser avatar = new JFileChooser();
        avatar.setFileFilter(img);
        int option = avatar.showOpenDialog(null);
        String image = "";

        if (option == JFileChooser.APPROVE_OPTION) {
            image = avatar.getSelectedFile().getPath();

            //String file = avatar.getSelectedFile().toString();
            //avatarField.setIcon(new ImageIcon(image));
            ImageIcon icon = new ImageIcon(image);
            Image imgn = icon.getImage();
            Image newimg = imgn.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newimg);
            avatarField.setIcon(newIcon);
            avatarField.setSize(150, 150);
            avatarField.setText(image);

            avatarlabel.setVisible(true);
            avatarlabel.setIcon(valid);
            avatarField.setText(image);
            validate = true;
        }
        return image;
    }

    /*
    public static boolean validateAvatar1() {
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
     */
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

        try {
            Dates date0 = new Dates("");
            Dates date1 = new Dates(date0.DateToString(datebirthdayField.getCalendar(), 0)); //Cambiar el 0 por la de la confi

            validate = true;
            if (date1.compareWith(date1.DateToCalendar(), date1.SystemDate()) != 1) {
                validate = false;
                date1 = new Dates(date1.insertDate(date0.DateToString(datebirthdayField.getCalendar(), 0))); //Cambiar el 0 por la de la confi
            }
            if (date1.timeBetweetDates(date1.DateToCalendar(), date1.SystemDate(), 1) < 18) {
                //JOptionPane.showMessageDialog(null, "You can't register until you're 18 years old");
                saveLabel.setText("You can't register until you're 18 years old");
                saveLabel.setVisible(true);
                validate = false;
                date1 = new Dates(date1.insertDate(date0.DateToString(datebirthdayField.getCalendar(), 0))); //Cambiar el 0 por la de la confi
            }
        } catch (Exception e) {
            validate = false;
        }
        if (validate) {
            datebirthdaylabel.setIcon(valid);
            datebirthdaylabel.setVisible(true);
        } else {
            datebirthdaylabel.setIcon(warning);
            datebirthdaylabel.setVisible(true);
        }
        return validate;
    }

    public static boolean validateHiringdate() {
        boolean validate = true;

        int yearsDif = 0;
        Dates date1 = null;
        Dates date0 = new Dates("");
        try {
            date1 = new Dates(date0.insertDate(date0.DateToString(hiringdateField.getCalendar(), 0)));//Cambiar el 0 por la de la confi
            Dates date2 = new Dates(date0.insertDate(date0.DateToString(datebirthdayField.getCalendar(), 0)));//Cambiar el 0 por la de la confi

            if (date1.compareWith(date1.DateToCalendar(), date1.SystemDate()) != 1) {
                validate = false;
                date1 = new Dates(date1.insertDate(date0.DateToString(datebirthdayField.getCalendar(), 0)));//Cambiar el 0 por la de la confi
            }
            yearsDif = date1.timeBetweetDates(date1.DateToCalendar(), date2.DateToCalendar(), 1);
            if (yearsDif < 18) {
                validate = false;
                //JOptionPane.showMessageDialog(null, "You could not be hired until you were 18");
                saveLabel.setText("You could not be hired until you were 18");
                saveLabel.setVisible(true);
                date1 = new Dates(date1.insertDate(date0.DateToString(datebirthdayField.getCalendar(), 0)));//Cambiar el 0 por la de la confi
            }

            if (date1.compareWith(date1.DateToCalendar(), date2.DateToCalendar()) == 1) {
                validate = false;
                //JOptionPane.showMessageDialog(null, "The date can not be before your date birthday");
                saveLabel.setText("The hiring date can not be before your date birthday");
                saveLabel.setVisible(true);
                date1 = new Dates(date1.insertDate(date0.DateToString(datebirthdayField.getCalendar(), 0)));//Cambiar el 0 por la de la confi
            }
        } catch (Exception e) {
            validate = false;
        }
        if (validate) {
            hiringdatelabel.setIcon(valid);
            hiringdatelabel.setVisible(true);
        } else {
            hiringdatelabel.setIcon(warning);
            hiringdatelabel.setVisible(true);
        }
        return validate;
    }

    public static boolean validateSalary() {
        boolean validate = false;
        if (Validate.validateFloat(salaryField.getText())) {
            salarylabel.setVisible(true);
            salarylabel.setIcon(valid);
            validate = true;
        } else {
            salarylabel.setVisible(true);
            salarylabel.setIcon(warning);
        }
        return validate;
    }

    public static boolean validateActivity() {
        boolean validate = false;
        if (Validate.validateInt(activityField.getText())) {
            activitylabel.setVisible(true);
            activitylabel.setIcon(valid);
            validate = true;
        } else {
            activitylabel.setVisible(true);
            activitylabel.setIcon(warning);
        }
        return validate;
    }
}
