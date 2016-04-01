/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.modules.users.view;

import application.modules.users.controller.admin_controller;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author nacho
 */
public class new_admin_view extends javax.swing.JFrame {

    /**
     * Creates new form new_admin_view
     */
    public static ImageIcon defaultAvatar = new ImageIcon("src/application/modules/users/view/img/anonymous_add.png");

    public new_admin_view() {
        initComponents();
        closeWindow();
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
        passwordlabel = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        avatarlabel = new javax.swing.JLabel();
        namebirthdaylabel = new javax.swing.JLabel();
        datebirthdaylabel = new javax.swing.JLabel();
        namehiringdatelabel = new javax.swing.JLabel();
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
        hiringdateField = new com.toedter.calendar.JDateChooser();
        datebirthdayField = new com.toedter.calendar.JDateChooser();
        passwordField = new javax.swing.JPasswordField();
        avatarField = new javax.swing.JLabel();
        avatarbutton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("DNI:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        dnilabel.setText(" ");
        getContentPane().add(dnilabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 27, 20, 20));

        jLabel3.setText("Name:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        namelabel.setText(" ");
        getContentPane().add(namelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 20, -1));
        getContentPane().add(dniField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 140, -1));
        getContentPane().add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 140, -1));

        jLabel5.setText("Subname:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));
        getContentPane().add(subnameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 140, -1));

        subnamelabel.setText(" ");
        getContentPane().add(subnamelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 147, 20, 20));

        jLabel7.setText("Phone:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));
        getContentPane().add(phoneField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 140, -1));

        phonelabel.setText(" ");
        getContentPane().add(phonelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 197, 20, 20));

        jLabel9.setText("Email:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));
        getContentPane().add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 140, -1));

        emaillabel.setText(" ");
        getContentPane().add(emaillabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 257, 20, 20));

        jLabel11.setText("Username:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, 20));
        getContentPane().add(usernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 140, -1));

        usernamelabel.setText(" ");
        getContentPane().add(usernamelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 317, 20, 20));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 9, 416));

        passwordlabel.setText(" ");
        getContentPane().add(passwordlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 377, 20, 20));

        jLabel14.setText("Password:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, -1));

        jLabel15.setText("Avatar:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, -1, -1));

        avatarlabel.setText(" ");
        getContentPane().add(avatarlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 20, -1));

        namebirthdaylabel.setText("Date birthday:");
        getContentPane().add(namebirthdaylabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, -1, -1));

        datebirthdaylabel.setText(" ");
        getContentPane().add(datebirthdaylabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 200, 20, 20));

        namehiringdatelabel.setText("Hiring date:");
        getContentPane().add(namehiringdatelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, -1, -1));

        hiringdatelabel.setText(" ");
        getContentPane().add(hiringdatelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 260, 20, -1));

        jLabel21.setText("Base salary:");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, -1, -1));
        getContentPane().add(salaryField, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, 120, -1));

        salarylabel.setText(" ");
        getContentPane().add(salarylabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 320, 20, -1));

        jLabel23.setText("Initial Activity:");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, -1, -1));
        getContentPane().add(activityField, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 370, 120, -1));

        activitylabel.setText(" ");
        getContentPane().add(activitylabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 380, 20, -1));

        jLabel25.setText("Status:");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, -1, 20));
        getContentPane().add(statusField, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 120, -1));

        statuslabel.setText(" ");
        getContentPane().add(statuslabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 140, 20, 20));

        saveAdminButton.setText("Save");
        getContentPane().add(saveAdminButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 451, 100, -1));

        discartButton.setText("Discart");
        getContentPane().add(discartButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 450, 90, -1));

        emptyButton.setText("Empty all fields");
        getContentPane().add(emptyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 450, -1, -1));

        saveLabel.setText(" ");
        getContentPane().add(saveLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 540, 20));

        hiringdateField.setDateFormatString("dd/MM/yyyy");
        hiringdateField.setMaxSelectableDate(new java.util.Date(4070908882000L));
        hiringdateField.setMinSelectableDate(new java.util.Date(-2208984234000L));
        getContentPane().add(hiringdateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 170, -1));

        datebirthdayField.setDateFormatString("dd/MM/yyyy");
        datebirthdayField.setMaxSelectableDate(new java.util.Date(4070908882000L));
        datebirthdayField.setMinSelectableDate(new java.util.Date(-2208984234000L));
        getContentPane().add(datebirthdayField, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 170, -1));
        getContentPane().add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 140, -1));

        avatarField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(avatarField, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 90, 80));

        avatarbutton.setText("Select avatar");
        getContentPane().add(avatarbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 70, 120, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    private void closeWindow() {
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new admin_controller(new admin_view(), 0).init("v");
                dispose();
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField activityField;
    public static javax.swing.JLabel activitylabel;
    public static javax.swing.JLabel avatarField;
    public static javax.swing.JButton avatarbutton;
    public static javax.swing.JLabel avatarlabel;
    public static com.toedter.calendar.JDateChooser datebirthdayField;
    public static javax.swing.JLabel datebirthdaylabel;
    public static javax.swing.JButton discartButton;
    public static javax.swing.JTextField dniField;
    public static javax.swing.JLabel dnilabel;
    public static javax.swing.JTextField emailField;
    public static javax.swing.JLabel emaillabel;
    public static javax.swing.JButton emptyButton;
    public static com.toedter.calendar.JDateChooser hiringdateField;
    public static javax.swing.JLabel hiringdatelabel;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel11;
    public static javax.swing.JLabel jLabel14;
    public static javax.swing.JLabel jLabel15;
    public static javax.swing.JLabel jLabel21;
    public static javax.swing.JLabel jLabel23;
    public static javax.swing.JLabel jLabel25;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel7;
    public static javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JTextField nameField;
    public static javax.swing.JLabel namebirthdaylabel;
    public static javax.swing.JLabel namehiringdatelabel;
    public static javax.swing.JLabel namelabel;
    public static javax.swing.JPasswordField passwordField;
    public static javax.swing.JLabel passwordlabel;
    public static javax.swing.JTextField phoneField;
    public static javax.swing.JLabel phonelabel;
    public static javax.swing.JTextField salaryField;
    public static javax.swing.JLabel salarylabel;
    public static javax.swing.JButton saveAdminButton;
    public static javax.swing.JLabel saveLabel;
    public static javax.swing.JTextField statusField;
    public static javax.swing.JLabel statuslabel;
    public static javax.swing.JTextField subnameField;
    public static javax.swing.JLabel subnamelabel;
    public static javax.swing.JTextField usernameField;
    public static javax.swing.JLabel usernamelabel;
    // End of variables declaration//GEN-END:variables
}
