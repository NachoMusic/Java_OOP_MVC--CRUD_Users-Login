/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.modules.users.model.DAO;

import static application.modules.users.view.new_admin_view.*;
import application.utils.Validate;
import javax.swing.ImageIcon;

/**
 *
 * @author nacho
 */
public class dao {

    public static ImageIcon warning = new ImageIcon("src/application/view/img/warning.png");
    public static ImageIcon valid = new ImageIcon("src/application/view/img/ok.png");

    public static void validateDNI() {
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
    }

    public static void validateName() {
        if (Validate.validateText(nameField.getText())) {
            namelabel.setVisible(true);
            namelabel.setIcon(valid);
        } else{
            namelabel.setVisible(true);
            namelabel.setIcon(warning);
        }
    }
    
    public static void validateSubname(){
        if (Validate.validateText(subnameField.getText())) {
            subnamelabel.setVisible(true);
            subnamelabel.setIcon(valid);
        } else{
            subnamelabel.setVisible(true);
            subnamelabel.setIcon(warning);
        }
    }
}
