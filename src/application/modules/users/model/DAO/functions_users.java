package application.modules.users.model.DAO;

import application.models.Dates;
import application.models.SingletonF;
import application.modules.users.model.kernel.GenericKernel;
import application.modules.users.model.models.admin;
import application.modules.users.model.models.client;
import application.modules.users.model.models.registered_user;
import application.modules.users.model.models.singleton;
import application.modules.users.model.models.users;
import static application.modules.users.view.new_admin_view.*;
import application.utils.Functions;
import application.utils.Menus;

public class functions_users {

    public static boolean newAdmin() {
        boolean valid[] = new boolean[6];
        boolean validA = true;
        String dni = "", name = "", subname = "", phone_number = "", email = "", user = "", pass = "",
                avatar = "", state = "", date_birthday = "", hiring_date = "", sdate;
        float salary = 0;
        int activity = 0;
        String dateFormat = "";

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
        }
        for (int i = 0; i < valid.length; i++) {
            if (!valid[i]) {
                validA = false;
            }
        }
        if (validA) {
            singleton.admins.addData(new admin(dni, name, subname, phone_number, email, user, pass, avatar, state,
                    date_birthday, hiring_date, salary, activity));
        } else {
            saveLabel.setVisible(true);
            saveLabel.setText("The admin was not created, check the errors in the fields");
        }
        return validA;
    }

    public static admin newadmin() {
        String dni, name, subname, phone_number, email, user, pass,
                avatar, state, date_birthday, hiring_date;
        float salary;
        int activity;
        String dateFormat = "";

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
        dni = Functions.validatestring("dni", "dni");
        name = Functions.validatestring("name", "name");
        subname = Functions.validatestring("subname", "subname");
        phone_number = Functions.validatestring("phone", "phone");
        email = Functions.validatestring("email", "email");
        user = Functions.validatestring(SingletonF.language.getProperty("user"), SingletonF.language.getProperty("user2"));
        pass = Functions.validatestring(SingletonF.language.getProperty("pass"), SingletonF.language.getProperty("pass2"));
        avatar = Functions.validatestring(SingletonF.language.getProperty("avatar"), SingletonF.language.getProperty("avatar2"));
        state = Functions.validatestring(SingletonF.language.getProperty("state"), SingletonF.language.getProperty("state2"));
        date_birthday = Functions.validatestring("datebirthday", "datebirthday");
        hiring_date = Functions.validatestring("diring date", "hiring date");
        salary = Functions.validatefloat(SingletonF.language.getProperty("salary"), SingletonF.language.getProperty("salary2"));
        activity = Functions.validateint(SingletonF.language.getProperty("activity"), SingletonF.language.getProperty("activity2"));
        return new admin(dni, name, subname, phone_number, email, user, pass, avatar, state,
                date_birthday, hiring_date, salary, activity);
    }

    public static client newclient() {
        String dni, name, subname, phone_number, email, user, pass,
                avatar, state, date_birthday, discharge_date, client_type;
        float shopping;
        boolean premium;
        String dateFormat = "";

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
        dni = Functions.validatestring("dni", "dni");
        name = Functions.validatestring("name", "name");
        subname = Functions.validatestring("subname", "subname");
        phone_number = Functions.validatestring("phone", "phone");
        email = Functions.validatestring("email", "email");
        user = Functions.validatestring("Type your username", "Username");
        pass = Functions.validatestring("Type your password", "Password");
        avatar = Functions.validatestring("Type the link to the avatar", "Avatar");
        state = Functions.validatestring("Type your state", "State");
        date_birthday = Functions.validatestring("datebirthday", "datebirthday");
        discharge_date = Functions.validatestring("hiring date", "hiring date");
        client_type = Functions.validatestring("Type your client type", "Client Type");
        shopping = Functions.validatefloat("Type your shopping", "Shopping");
        premium = Functions.validateboolean("Type if you are premium or not", "Premium");
        return new client(dni, name, subname, phone_number, email, user, pass, avatar, state,
                date_birthday, discharge_date, client_type, shopping, premium);
    }

    public static registered_user newregistered_user() {
        String dni, name, subname, phone_number, email, user, pass,
                avatar, state, date_birthday, karma = "";
        int activity;
        String dateFormat = "";

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
        dni = Functions.validatestring("dni", "dni");
        name = Functions.validatestring("name", "name");
        subname = Functions.validatestring("subname", "subname");
        phone_number = Functions.validatestring("phone", "phone");
        email = Functions.validatestring("email", "email");
        user = Functions.validatestring("Type your username", "Username");
        pass = Functions.validatestring("Type your password", "Password");
        avatar = Functions.validatestring("Type the link to the avatar", "Avatar");
        state = Functions.validatestring("Type your state", "State");
        date_birthday = Functions.validatestring("datebirthday", "datebirthday");
        String[] vec = {"Alto", "Medio", "Bajo"};
        switch (Menus.menu(vec, "Choose the Karma", "Karma")) {
            case 0:
                karma = "High";
                break;
            case 1:
                karma = "Medium";
                break;
            case 2:
                karma = "Low";
                break;
        }
        activity = Functions.validateint("Type your activity", "Activity");

        return new registered_user(dni, name, subname, phone_number, email, user, pass, avatar, state,
                date_birthday, karma, activity);
    }

    public static void getuser(users param, int a) {
        int edit = 14;
        String dateFormat = "";
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

        switch (a) {
            case 0:
                edit = Functions.validateint("Type a number for editing:\n"
                        + " 1 -> DNI\n 2 -> Name\n 3 -> Subname\n 4 -> Phone number\n 5 -> Email"
                        + " \n 6 -> Username\n 7 -> Pass\n 8 -> Avatar\n 9 -> State\n"
                        + " 10 -> Date Birthday\n 11 -> Hirin Date\n 12 -> Salary"
                        + " \n 13 -> Activity", "EDIT");

                switch (edit) {
                    case 11:
                        ((admin) param).setHirin_date(Functions.validatestring("up date", "up date"));
                        break;
                    case 12:
                        ((admin) param).setSalary(Functions.validatefloat(SingletonF.language.getProperty("salary"), SingletonF.language.getProperty("salary2")));
                        break;
                    case 13:
                        ((admin) param).setActivity(Functions.validateint(SingletonF.language.getProperty("activity"), SingletonF.language.getProperty("activity2")));
                        break;
                }
                break;
            case 1:
                edit = Functions.validateint("Type a number for editing:\n"
                        + " 1 -> DNI\n 2 -> Name\n 3 -> Subname\n 4 -> Phone number\n 5 -> Email"
                        + " 6 -> Username\n 7 -> Pass\n 8 -> Avatar\n 9 -> State\n"
                        + " 10 -> Date Birthday\n 11 -> Discharge date\n"
                        + " 12 -> Client type\n 13 Shopping\n 14-> Premium", "EDIT");
                switch (edit) {
                    case 11:
                        ((client) param).setDischarge_date(Functions.validatestring("discharge date", "discharge date"));
                        break;
                    case 12:
                        ((client) param).setClient_type(Functions.validatestring("Introduce el nuevo client type", "client type"));
                        break;
                    case 13:
                        ((client) param).setShopping(Functions.validateint("Introduce el nuevo Shopping", "Shopping"));
                        break;
                    case 14:
                        ((client) param).setPremium(Functions.validateboolean("Introduce si es Premium", "Premium"));
                }
                break;
            case 2:
                edit = Functions.validateint("Type a number for editing:\n"
                        + " 0 -> DNI\n 1 -> Name\n 2 -> Subname\n 3 -> Phone number\n 4 -> Email"
                        + " 5 -> Username\n 6 -> Pass\n 7 -> Avatar\n 8 -> State\n"
                        + " 9 -> Date Birthday\n 10 -> Karma\n 11 -> Activity\n", "EDIT");
                switch (edit) {
                    case 10:
                        String[] vec = {"Alto", "Medio", "Bajo"};
                        String karma = null;
                        switch (Menus.menu(vec, "Choose the Karma", "Karma")) {
                            case 0:
                                karma = "High";
                                break;
                            case 1:
                                karma = "Medium";
                                break;
                            case 2:
                                karma = "Low";
                                break;
                        }
                        ((registered_user) param).setKarma(karma);
                        break;
                    case 11:
                        ((registered_user) param).setActivity(Functions.validateint("Introduce el nuevo activity", "activity"));
                        break;
                }
                break;
        }
        switch (edit) {
            case 1:
                param.setDni(Functions.validatestring("dni", "dni"));
                break;
            case 2:
                param.setName(Functions.validatestring("name", "name"));
                break;
            case 3:
                param.setSubname(Functions.validatestring("subname", "subname"));
                break;
            case 4:
                param.setPhone_number(Functions.validatestring("phone", "phone"));
                break;
            case 5:
                param.setEmail(Functions.validatestring("email", "email"));
                break;
            case 6:
                param.setUser(Functions.validatestring(SingletonF.language.getProperty("user"), SingletonF.language.getProperty("user2")));
                break;
            case 7:
                param.setPass(Functions.validatestring(SingletonF.language.getProperty("pass"), SingletonF.language.getProperty("pass2")));
                break;
            case 8:
                param.setAvatar(Functions.validatestring(SingletonF.language.getProperty("avatar"), SingletonF.language.getProperty("avatar2")));
                break;
            case 9:
                param.setState(Functions.validatestring(SingletonF.language.getProperty("state"), SingletonF.language.getProperty("state2")));
                break;
            case 10:
                param.setDate_birthday(Functions.validatestring("datebirthday", "datebirthday"));
                break;
        }
    }
}
