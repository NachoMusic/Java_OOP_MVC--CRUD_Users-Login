/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.modules.client.model.DAO;

import application.models.Dates;
import application.models.SingletonF;
import static application.models.SingletonF.collection;
import application.modules.client.model.models.client;
import application.modules.client.view.new_client_view;
import static application.modules.client.view.new_client_view.*;
import application.modules.users.model.singleton;
import application.utils.Validate;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import static java.awt.Color.red;
import static java.awt.Color.white;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author nacho
 */
public class daoC {

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

    public static boolean validateDischargedate() {
        boolean validate = true;

        int yearsDif = 0;
        Dates date1 = null;
        Dates date0 = new Dates("");
        try {
            date1 = new Dates(date0.insertDate(date0.DateToString(dischargedateField.getCalendar(), 0)));//Cambiar el 0 por la de la confi
            Dates date2 = new Dates(date0.insertDate(date0.DateToString(datebirthdayField.getCalendar(), 0)));//Cambiar el 0 por la de la confi

            if (date1.compareWith(date1.DateToCalendar(), date1.SystemDate()) != 1) {
                validate = false;
                date1 = new Dates(date1.insertDate(date0.DateToString(datebirthdayField.getCalendar(), 0)));//Cambiar el 0 por la de la confi
            }
            yearsDif = date1.timeBetweetDates(date1.DateToCalendar(), date2.DateToCalendar(), 1);
            if (yearsDif < 18) {
                validate = false;
                saveLabel.setText("You could not be registered until you were 18");
                saveLabel.setVisible(true);
                date1 = new Dates(date1.insertDate(date0.DateToString(datebirthdayField.getCalendar(), 0)));//Cambiar el 0 por la de la confi
            }

            if (date1.compareWith(date1.DateToCalendar(), date2.DateToCalendar()) == 1) {
                validate = false;
                saveLabel.setText("The discharge date can not be before your date birthday");
                saveLabel.setVisible(true);
                date1 = new Dates(date1.insertDate(date0.DateToString(datebirthdayField.getCalendar(), 0)));//Cambiar el 0 por la de la confi
            }
        } catch (Exception e) {
            validate = false;
        }
        if (validate) {
            dischargedatelabel.setIcon(valid);
            dischargedatelabel.setVisible(true);
            dischargedateField.setBackground(white);
        } else {
            dischargedatelabel.setIcon(warning);
            dischargedatelabel.setVisible(true);
            dischargedateField.setBackground(red);
        }
        return validate;
    }

    public static boolean validateClient_type() {
        boolean validate = false;
        if (!client_typeField.getText().isEmpty()) {
            client_typelabel.setVisible(true);
            client_typelabel.setIcon(valid);
            client_typeField.setBackground(white);
            validate = true;
        } else {
            client_typelabel.setVisible(true);
            client_typelabel.setIcon(warning);
            client_typeField.setBackground(red);
        }
        return validate;
    }

    public static boolean validateShopping() {
        boolean validate = false;
        if (Validate.validateFloat(shoppingField.getText())) {
            shoppinglabel.setVisible(true);
            shoppinglabel.setIcon(valid);
            shoppingField.setBackground(white);
            validate = true;
        } else {
            shoppinglabel.setVisible(true);
            shoppinglabel.setIcon(warning);
            shoppingField.setBackground(red);
        }
        return validate;
    }

    public static void insert_client(client c) {
        SingletonF.collection.insert(c.client_to_BD());
    }

    public static void delete_worker(String dni) {
        SingletonF.collection.remove(new BasicDBObject().append("dni", dni));
    }

    public static void update_worker(String dni) {
        //Prepara para insertar un nuevo campo
        BasicDBObject updateDni = new BasicDBObject(), updateName = new BasicDBObject(),
                updateSurname = new BasicDBObject(), updatePhone = new BasicDBObject(),
                updateEmail = new BasicDBObject(), updateUser = new BasicDBObject(),
                updatePass = new BasicDBObject(), updateAvatar = new BasicDBObject(),
                updateState = new BasicDBObject(), updateDate_birthday = new BasicDBObject(),
                updateClient_type = new BasicDBObject(), updatePremium = new BasicDBObject(),
                updateDischarge_date = new BasicDBObject();
        updateDni.append("$set", new BasicDBObject().append("dni", new_client_view.dniField.getText()));
        updateName.append("$set", new BasicDBObject().append("name", new_client_view.nameField.getText()));
        updateSurname.append("$set", new BasicDBObject().append("subname", new_client_view.subnameField.getText()));
        updatePhone.append("$set", new BasicDBObject().append("phone_number", new_client_view.phoneField.getText()));
        updateEmail.append("$set", new BasicDBObject().append("email", new_client_view.emailField.getText()));
        updateUser.append("$set", new BasicDBObject().append("user", new_client_view.usernameField.getText()));
        updatePass.append("$set", new BasicDBObject().append("pass", new_client_view.passwordField.getText()));
        updateAvatar.append("$set", new BasicDBObject().append("avatar", new_client_view.avatarField.getText()));
        updateState.append("$set", new BasicDBObject().append("state", new_client_view.statusField.getText()));
        updateClient_type.append("$set", new BasicDBObject().append("client_type", new_client_view.client_typeField.getText()));
        Dates d = new Dates("");
        updateDate_birthday.append("$set", new BasicDBObject().append("date_birthday", d.DateToString(new_client_view.datebirthdayField.getCalendar(), 0)));
        updateDischarge_date.append("discharge_date", d.DateToString(new_client_view.dischargedateField.getCalendar(), 0));
        updatePremium.append("$set", new BasicDBObject().append("premium", new_client_view.premiumCheckbox.isSelected()));
        //Busca el/los registro/s con el nombre indicado
        BasicDBObject searchById = new BasicDBObject();
        searchById.append("dni", dni);

        //Realiza la actualización
        SingletonF.collection.updateMulti(searchById, updateDni);
        SingletonF.collection.updateMulti(searchById, updateName);
        SingletonF.collection.updateMulti(searchById, updateSurname);
        SingletonF.collection.updateMulti(searchById, updatePhone);
        SingletonF.collection.updateMulti(searchById, updateEmail);
        SingletonF.collection.updateMulti(searchById, updateUser);
        SingletonF.collection.updateMulti(searchById, updatePass);
        SingletonF.collection.updateMulti(searchById, updateAvatar);
        SingletonF.collection.updateMulti(searchById, updateState);
        SingletonF.collection.updateMulti(searchById, updateDate_birthday);
        SingletonF.collection.updateMulti(searchById, updateClient_type);
        SingletonF.collection.updateMulti(searchById, updatePremium);
    }

    /*
    public static void update_worker2(String dni, client c) {
        //Prepara para insertar un nuevo campo
        BasicDBObject updateClient = new BasicDBObject();
        updateClient.append("$set", new BasicDBObject().append("user", c));
        //Busca el/los registro/s con el nombre indicado
        BasicDBObject searchById = new BasicDBObject();
        searchById.append("dni", dni);

        //Realiza la actualización
        SingletonF.collection.updateMulti(searchById, updateClient);
    }*/

    public static void retrieve_admins() {
        //DBCollection dbCollection = db.getCollection(tableName);
        client c = new client();
        DBCursor cur = collection.find();
        for (int i = 0; i<cur.size();i++) {
            BasicDBObject document = (BasicDBObject) cur.next();
            c = c.DB_to_client(document);
            client d = new client(c.getDni(),c.getName(),c.getSubname(), c.getPhone_number(),
                    c.getEmail(), c.getUser(), c.getPass(), c.getAvatar(), c.getState(), c.getDate_birthday(),
                    c.getDischarge_date(), c.getClient_type(), c.getShopping(), c.isPremium());
            singleton.clients.getClients().add(d);
        }
    }

}
