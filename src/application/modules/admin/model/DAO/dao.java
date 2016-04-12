/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.modules.admin.model.DAO;

import application.models.Dates;
import application.bbdd.ConexionBD;
import application.modules.users.model.singleton;
import application.modules.admin.model.pager.Pager;
import static application.modules.admin.view.new_admin_view.*;
import application.utils.Validate;
import static java.awt.Color.red;
import static java.awt.Color.white;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
                dniField.setBackground(white);
            } else {
                dnilabel.setVisible(true);
                dnilabel.setIcon(warning);
                dniField.setBackground(red);
            }
        } else {
            dnilabel.setVisible(true);
            dnilabel.setIcon(warning);
            dniField.setBackground(red);
        }
        return validate;
    }

    public static boolean validateName() {
        boolean validate = false;
        if (Validate.validateText(nameField.getText())) {
            namelabel.setVisible(true);
            namelabel.setIcon(valid);
            nameField.setBackground(white);
            validate = true;
        } else {
            namelabel.setVisible(true);
            namelabel.setIcon(warning);
            nameField.setBackground(red);
        }
        return validate;
    }

    public static boolean validateSubname() {
        boolean validate = false;
        if (Validate.validateText(subnameField.getText())) {
            subnamelabel.setVisible(true);
            subnamelabel.setIcon(valid);
            subnameField.setBackground(white);
            validate = true;
        } else {
            subnamelabel.setVisible(true);
            subnamelabel.setIcon(warning);
            subnameField.setBackground(red);
        }
        return validate;
    }

    public static boolean validatePhone() {
        boolean validate = false;
        if (Validate.validatePhone(phoneField.getText())) {
            phonelabel.setVisible(true);
            phonelabel.setIcon(valid);
            phoneField.setBackground(white);
            validate = true;
        } else {
            phonelabel.setVisible(true);
            phonelabel.setIcon(warning);
            phoneField.setBackground(red);
        }
        return validate;
    }

    public static boolean validateEmail() {
        boolean validate = false;
        if (Validate.validateEmail(emailField.getText())) {
            emaillabel.setVisible(true);
            emaillabel.setIcon(valid);
            emailField.setBackground(white);
            validate = true;
        } else {
            emaillabel.setVisible(true);
            emaillabel.setIcon(warning);
            emailField.setBackground(red);
        }
        return validate;
    }

    public static boolean validateUsername() {
        boolean validate = false;
        if (usernameField.getText().isEmpty()) {
            usernamelabel.setVisible(true);
            usernamelabel.setIcon(warning);
            usernameField.setBackground(red);
        } else {
            usernamelabel.setVisible(true);
            usernamelabel.setIcon(valid);
            usernameField.setBackground(white);
            validate = true;
        }
        return validate;
    }

    public static boolean validatePassword() {
        boolean validate = false;
        if (passwordField.getText().isEmpty()) {
            passwordlabel.setVisible(true);
            passwordlabel.setIcon(warning);
            passwordField.setBackground(red);
        } else {
            passwordlabel.setVisible(true);
            passwordlabel.setIcon(valid);
            passwordField.setBackground(white);
            validate = true;
        }
        return validate;
    }

    public static String validateAvatar() {
        boolean validate = false;
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

    public static boolean validateStatus() {
        boolean validate = false;
        if (statusField.getText().isEmpty()) {
            statuslabel.setVisible(true);
            statuslabel.setIcon(warning);
            statusField.setBackground(red);
        } else {
            statuslabel.setVisible(true);
            statuslabel.setIcon(valid);
            statusField.setBackground(white);
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
            datebirthdayField.setBackground(white);
        } else {
            datebirthdaylabel.setIcon(warning);
            datebirthdaylabel.setVisible(true);
            datebirthdayField.setBackground(red);
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
            hiringdateField.setBackground(white);
        } else {
            hiringdatelabel.setIcon(warning);
            hiringdatelabel.setVisible(true);
            hiringdateField.setBackground(red);
        }
        return validate;
    }

    public static boolean validateSalary() {
        boolean validate = false;
        if (Validate.validateFloat(salaryField.getText())) {
            salarylabel.setVisible(true);
            salarylabel.setIcon(valid);
            salaryField.setBackground(white);
            validate = true;
        } else {
            salarylabel.setVisible(true);
            salarylabel.setIcon(warning);
            salaryField.setBackground(red);
        }
        return validate;
    }

    public static boolean validateActivity() {
        boolean validate = false;
        if (Validate.validateInt(activityField.getText())) {
            activitylabel.setVisible(true);
            activitylabel.setIcon(valid);
            activityField.setBackground(white);
            validate = true;
        } else {
            activitylabel.setVisible(true);
            activitylabel.setIcon(warning);
            activityField.setBackground(red);
        }
        return validate;
    }

    public static boolean saveadminsBBDD(Connection _con) throws SQLException {
        PreparedStatement stmt = null;
        boolean valid = true;

        try {
            
            for (int i = 0; i < singleton.admins.size(); i++) {
                stmt = _con.prepareStatement("INSERT INTO admins"
                        + "(dni,name,subname,phone_number,email,user,pass,"
                        + "avatar,state,date_birthday,age,hirin_date,salary,years_of_service,activity) "
                        + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                //System.out.println(i+" "+singleton.admins.getAdmins().get(i).getUser());
                stmt.setString(1, singleton.admins.getAdmins().get(i).getDni());
                stmt.setString(2, singleton.admins.getAdmins().get(i).getName());
                stmt.setString(3, singleton.admins.getAdmins().get(i).getSubname());
                stmt.setString(4, singleton.admins.getAdmins().get(i).getPhone_number());
                stmt.setString(5, singleton.admins.getAdmins().get(i).getEmail());
                stmt.setString(6, singleton.admins.getAdmins().get(i).getUser());
                stmt.setString(7, singleton.admins.getAdmins().get(i).getPass());
                stmt.setString(8, singleton.admins.getAdmins().get(i).getAvatar());
                stmt.setString(9, singleton.admins.getAdmins().get(i).getState());
                stmt.setString(10, singleton.admins.getAdmins().get(i).getDate_birthday());
                stmt.setInt(11, singleton.admins.getAdmins().get(i).getAge());
                stmt.setString(12, singleton.admins.getAdmins().get(i).getHirin_date());
                stmt.setFloat(13, singleton.admins.getAdmins().get(i).getSalary());
                stmt.setInt(14, singleton.admins.getAdmins().get(i).getYears_of_service());
                stmt.setInt(15, singleton.admins.getAdmins().get(i).getActivity());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema con la bbdd");
            valid = false;
        }
        return valid;
    }
    public static boolean deleteadminBBDD(Connection _con){
        PreparedStatement stmt = null;
        boolean valid = false;

        try {
            stmt = _con.prepareStatement("DELETE FROM application.admins WHERE dni=?");
            stmt.setString(1, singleton.admins.getAdmins().get(Integer.parseInt(singleton.pagerA.getSelected())-1).getDni());
            stmt.executeUpdate();
            valid = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un error al eliminar el usuario!");
        }
        return valid;
    }
}
