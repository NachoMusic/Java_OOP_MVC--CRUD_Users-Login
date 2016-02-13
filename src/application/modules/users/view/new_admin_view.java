/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.modules.users.view;

import application.models.SingletonF;
import application.modules.users.model.kernel.GenericKernel;
import application.modules.users.model.models.admin;
import application.modules.users.model.models.singleton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author nacho
 */
public class new_admin_view extends javax.swing.JFrame {

    /**
     * Creates new form new_admin_view
     */
    public new_admin_view() {
        initComponents();
        closeWindow();
        this.setTitle("Create new admin");
        this.setLocationRelativeTo(null);
        saveLabel.setVisible(false);
        dnilabel.setVisible(false);
        namelabel.setVisible(false);
        subnamelabel.setVisible(false);
        emaillabel.setVisible(false);
        statuslabel.setVisible(false);
        usernamelabel.setVisible(false);
        passwordlabel.setVisible(false);
        salarylabel.setVisible(false);
        activitylabel.setVisible(false);
        datebirthdaylabel.setVisible(false);
        hiringdatelabel.setVisible(false);
        phonelabel.setVisible(false);
        avatarlabel.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        dnilabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        namelabel = new javax.swing.JLabel();
        dniField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        subnameField = new javax.swing.JTextField();
        subnamelabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        phoneField = new javax.swing.JTextField();
        phonelabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        emaillabel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        usernamelabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        passwordField = new javax.swing.JTextField();
        passwordlabel = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        avatarField = new javax.swing.JTextField();
        avatarlabel = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        datebirthdayField = new javax.swing.JTextField();
        datebirthdaylabel = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        hiringdateField = new javax.swing.JTextField();
        hiringdatelabel = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        salaryField = new javax.swing.JTextField();
        salarylabel = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        activityField = new javax.swing.JTextField();
        activitylabel = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        statusField = new javax.swing.JTextField();
        statuslabel = new javax.swing.JLabel();
        saveAdminButton = new javax.swing.JButton();
        discartButton = new javax.swing.JButton();
        emptyButton = new javax.swing.JButton();
        saveLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("DNI:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 22, -1, -1));

        dnilabel.setText("jLabel2");
        getContentPane().add(dnilabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, -1));

        jLabel3.setText("Name:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 78, -1, -1));

        namelabel.setText("jLabel4");
        getContentPane().add(namelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, -1, -1));
        getContentPane().add(dniField, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 12, 91, -1));
        getContentPane().add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 90, -1));

        jLabel5.setText("Subname:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 136, -1, -1));
        getContentPane().add(subnameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 131, 90, -1));

        subnamelabel.setText("jLabel4");
        getContentPane().add(subnamelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, -1, -1));

        jLabel7.setText("Phone:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 192, -1, -1));
        getContentPane().add(phoneField, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 187, 91, -1));

        phonelabel.setText("jLabel4");
        getContentPane().add(phonelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 220, -1, -1));

        jLabel9.setText("Email:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 254, -1, -1));
        getContentPane().add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 249, 91, -1));

        emaillabel.setText("jLabel4");
        getContentPane().add(emaillabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 282, -1, -1));

        jLabel11.setText("Username:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 321, -1, -1));
        getContentPane().add(usernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 311, 90, -1));

        usernamelabel.setText("jLabel4");
        getContentPane().add(usernamelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, -1, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 9, 416));
        getContentPane().add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 367, 90, -1));

        passwordlabel.setText("jLabel4");
        getContentPane().add(passwordlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, -1, -1));

        jLabel14.setText("Password:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 372, -1, -1));

        jLabel15.setText("Avatar:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));
        getContentPane().add(avatarField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 82, -1));

        avatarlabel.setText("jLabel4");
        getContentPane().add(avatarlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, -1, -1));

        jLabel17.setText("Date birthday:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, -1, -1));
        getContentPane().add(datebirthdayField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 83, -1));

        datebirthdaylabel.setText("jLabel4");
        getContentPane().add(datebirthdaylabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, -1, -1));

        jLabel19.setText("Hiring date:");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, -1, -1));
        getContentPane().add(hiringdateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 83, -1));

        hiringdatelabel.setText("jLabel4");
        getContentPane().add(hiringdatelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, -1, -1));

        jLabel21.setText("Base salary:");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, -1, -1));
        getContentPane().add(salaryField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, 83, -1));

        salarylabel.setText("jLabel4");
        getContentPane().add(salarylabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, -1, -1));

        jLabel23.setText("Initial Activity:");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, -1, -1));
        getContentPane().add(activityField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 370, 85, -1));

        activitylabel.setText("jLabel4");
        getContentPane().add(activitylabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, -1, -1));

        jLabel25.setText("Status:");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, -1, -1));
        getContentPane().add(statusField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 83, -1));

        statuslabel.setText("jLabel4");
        getContentPane().add(statuslabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, -1, 20));

        saveAdminButton.setText("Save");
        saveAdminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAdminButtonActionPerformed(evt);
            }
        });
        getContentPane().add(saveAdminButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 451, 70, -1));

        discartButton.setText("Discart");
        getContentPane().add(discartButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 450, -1, -1));

        emptyButton.setText("Empty all fields");
        emptyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emptyButtonActionPerformed(evt);
            }
        });
        getContentPane().add(emptyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 450, -1, -1));

        saveLabel.setText("jLabel2");
        getContentPane().add(saveLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveAdminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAdminButtonActionPerformed
        // TODO add your handling code here:

        String dni, name, subname, phone_number, email, user, pass,
                avatar, state, date_birthday, hiring_date;
        float salary = 0;
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
        System.out.print(0);
        dni = GenericKernel.insertDni(SingletonF.language.getProperty("typedni"), "DNI", dniField.getText());
        System.out.print(1);
        name = GenericKernel.insertText(SingletonF.language.getProperty("name"), SingletonF.language.getProperty("name2"), nameField.getText());
        System.out.print(2);
        subname = GenericKernel.insertText(SingletonF.language.getProperty("subname"), SingletonF.language.getProperty("subname2"), subnameField.getText());
        System.out.print(3);
        phone_number = GenericKernel.insertPhone(SingletonF.language.getProperty("insertphone"), SingletonF.language.getProperty("insertphone2"), phoneField.getText());
        System.out.print(4);
        email = GenericKernel.insertEmail(SingletonF.language.getProperty("email"), "Email", emailField.getText());
        user = usernameField.getText();

        pass = passwordField.getText();
        avatar = avatarField.getText();
        state = statusField.getText();
        date_birthday = GenericKernel.insertDateBirthday(SingletonF.language.getProperty("date_birthday") + dateFormat, SingletonF.language.getProperty("date_birthday2"), datebirthdayField.getText());
        hiring_date = GenericKernel.insertUpDate(SingletonF.language.getProperty("hiring_date") + dateFormat, SingletonF.language.getProperty("hiring_date2"), date_birthday, hiringdateField.getText());
        System.out.print(5);
        try {
            salary = Float.parseFloat(salaryField.getText());
        } catch (Exception E) {
        };
        System.out.print(6);
        activity = Integer.parseInt(activityField.getText());
        singleton.admins.addData(new admin(dni, name, subname, phone_number, email, user, pass, avatar, state,
                date_birthday, hiring_date, salary, activity));
        saveLabel.setText("The admin was created successfully");
        saveLabel.setVisible(true);
    }//GEN-LAST:event_saveAdminButtonActionPerformed

    private void emptyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emptyButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emptyButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    private void closeWindow() {
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //setVisible(false);
                dispose();
            }
        });
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(new_admin_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(new_admin_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(new_admin_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(new_admin_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new new_admin_view().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField activityField;
    private javax.swing.JLabel activitylabel;
    private javax.swing.JTextField avatarField;
    private javax.swing.JLabel avatarlabel;
    private javax.swing.JTextField datebirthdayField;
    private javax.swing.JLabel datebirthdaylabel;
    private javax.swing.JButton discartButton;
    private javax.swing.JTextField dniField;
    private javax.swing.JLabel dnilabel;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emaillabel;
    private javax.swing.JButton emptyButton;
    private javax.swing.JTextField hiringdateField;
    private javax.swing.JLabel hiringdatelabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel namelabel;
    private javax.swing.JTextField passwordField;
    private javax.swing.JLabel passwordlabel;
    private javax.swing.JTextField phoneField;
    private javax.swing.JLabel phonelabel;
    private javax.swing.JTextField salaryField;
    private javax.swing.JLabel salarylabel;
    private javax.swing.JButton saveAdminButton;
    private javax.swing.JLabel saveLabel;
    private javax.swing.JTextField statusField;
    private javax.swing.JLabel statuslabel;
    private javax.swing.JTextField subnameField;
    private javax.swing.JLabel subnamelabel;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernamelabel;
    // End of variables declaration//GEN-END:variables
}
