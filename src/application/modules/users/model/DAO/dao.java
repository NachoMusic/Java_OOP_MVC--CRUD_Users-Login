/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.modules.users.model.DAO;

import static application.modules.users.view.new_admin_view.dniField;
import static application.modules.users.view.new_admin_view.dnilabel;
import application.utils.Validate;

/**
 *
 * @author nacho
 */
public class dao {
    public static void validateDNI(){
        String DNIletters = "TRWAGMYFPDXBNJZSQVHLCKET";
        String number = "";
        int numberint;
        char lettercalc = ' ', lettergiven = ' ';
        boolean validate = false;

        validate = Validate.validateDni(dniField.getText());

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
        
        if (lettercalc != lettergiven) {
            dnilabel.setText("Incorrect DNI");
        } else{
            dnilabel.setText("Ok");
        }
    }
}
