package application.modules.users.model.kernel;

import javax.swing.JOptionPane;
import application.models.Dates;
import application.utils.Functions;
import application.utils.Validate;

public class GenericKernel {

    public static boolean insertDni(String arg1, String arg2, String dni) {
        String DNIletters = "TRWAGMYFPDXBNJZSQVHLCKET";
        String number = "";
        int numberint;
        char lettercalc = ' ', lettergiven = ' ';
        boolean validate = false;
        //String dni="";

        //do{
        //do{
        validate = Validate.validateDni(dni/*=Functions.validatestring(arg1,arg2)*/);
        //if(!validate)
        //JOptionPane.showMessageDialog(null, "You have not introduced a valid argument");
        //}while(!validate);
        int[] vec = new int[dni.length() - 1];
        for (int i = 0; i < dni.length() - 1; i++) {
            vec[i] = dni.charAt(i) - '0';
        }
        for (int i = 0; i < dni.length() - 1; i++) {
            number += vec[i];
        }
        numberint = Integer.parseInt(number);
        lettercalc = DNIletters.charAt(numberint % 23);

        lettergiven = (dni.toUpperCase()).charAt(8);

        if (lettercalc != lettergiven) {
            validate = false;
            lettergiven = ' ';
            numberint = 0;
            lettercalc = ' ';
            number = "";
            dni = "";
            vec = null;
        }
        //}while(!validate);
        return validate;
    }

    public static boolean insertText(String arg1, String arg2, String text) {
        boolean validate = false;

        validate = Validate.validateText(text);
        return validate;
    }

    public static boolean insertPhone(String arg1, String arg2, String phone) {
        boolean validate = false;

            validate = Validate.validatePhone(phone);
        return validate;
    }

    public static boolean insertEmail(String arg1, String arg2, String email) {
        boolean validate = false;

            validate = Validate.validateEmail(email);
        return validate;
    }

    /**
     * Insert Date
     *
     * @param arg1 Message
     * @param arg2 Title
     * @return the date in a String This function is used by
     * insertDateBirthday() and insertUpDate()
     */

    /**
     * InsertDateBirthday
     *
     * @param arg1	Message
     * @param arg2	Title
     * @return	The date in a String
     */
    public static String insertDateBirthday(String arg1, String arg2, String date) {
        boolean valid = true;
        Dates date0 = new Dates("");
        Dates date1 = new Dates(date0.insertDate(arg1, arg2, date));

            valid = true;
            if (date1.compareWith(date1.DateToCalendar(), date1.SystemDate()) != 1) {
                valid = false;
                JOptionPane.showMessageDialog(null, "You have not introduced a valid argument");
                date1 = new Dates(date1.insertDate(arg1, arg2, date));
            }
            if (date1.timeBetweetDates(date1.DateToCalendar(), date1.SystemDate(), 1) < 18) {
                JOptionPane.showMessageDialog(null, "You can't register until you're 18 years old");
                valid = false;
                date1 = new Dates(date1.insertDate(arg1, arg2, date));
            }
        return date1.getDate();
    }

    /**
     * Insert hiring date and discharge date
     *
     * @param arg1 Message
     * @param arg2 Title
     * @param date_birthday
     * @return The date in a String
     */

    public static String insertUpDate(String arg1, String arg2, String date_birthday, String date) {
        boolean valid = true;
        int yearsDif = 0;
        Dates date1 = null;
        Dates date0 = new Dates("");
        date1 = new Dates(date0.insertDate(arg1, arg2, date));
        Dates date2 = new Dates(date_birthday);

            valid = true;
            if (date1.compareWith(date1.DateToCalendar(), date1.SystemDate()) != 1) {
                valid = false;
                JOptionPane.showMessageDialog(null, "You have not introduced a valid argument");
                date1 = new Dates(date1.insertDate(arg1, arg2, date));
            }
            yearsDif = date1.timeBetweetDates(date1.DateToCalendar(), date2.DateToCalendar(), 1);
            if (yearsDif < 18) {
                valid = false;
                JOptionPane.showMessageDialog(null, "You could not be hired until you were 18");
                date1 = new Dates(date1.insertDate(arg1, arg2, date));
            }

            if (date1.compareWith(date1.DateToCalendar(), date2.DateToCalendar()) == 1) {
                valid = false;
                JOptionPane.showMessageDialog(null, "The date can not be before your date birthday");
                date1 = new Dates(date1.insertDate(arg1, arg2, date));
            }
        return date1.getDate();
    }
}
