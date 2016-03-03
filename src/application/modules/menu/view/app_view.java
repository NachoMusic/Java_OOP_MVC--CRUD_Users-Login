/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.modules.menu.view;

import application.modules.config.view.config_view;
import application.models.SingletonF;
import application.modules.users.view.admin_view;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author nacho
 */
public class app_view extends javax.swing.JFrame {

    /**
     * Creates new form app_view
     */
    public static config_view configview;

    public app_view() {
        initComponents();
        
        this.setTitle(SingletonF.language.getProperty("application_users"));
        this.setLocationRelativeTo(null);
        close();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        adminsButton = new javax.swing.JButton();
        clientsButton = new javax.swing.JButton();
        usregButton = new javax.swing.JButton();
        confButton = new javax.swing.JButton();
        labelMenu = new javax.swing.JLabel();
        conflabel = new javax.swing.JLabel();
        adminlabel = new javax.swing.JLabel();
        clientslabel = new javax.swing.JLabel();
        userslabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        adminsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/application/modules/menu/view/img/user_admin.png"))); // NOI18N
        adminsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminsButtonActionPerformed(evt);
            }
        });

        clientsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/application/modules/menu/view/img/users.png"))); // NOI18N

        usregButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/application/modules/menu/view/img/user_man.png"))); // NOI18N

        confButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/application/modules/menu/view/img/configuration.png"))); // NOI18N
        confButton.setToolTipText("");
        confButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confButtonActionPerformed(evt);
            }
        });

        labelMenu.setFont(new java.awt.Font("Droid Sans", 1, 18)); // NOI18N
        labelMenu.setText("Choose an option:");

        conflabel.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        conflabel.setText("Configuration");

        adminlabel.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        adminlabel.setText("Admins");

        clientslabel.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        clientslabel.setText("Clients");

        userslabel.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        userslabel.setText("Registered users");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usregButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(adminsButton))
                        .addComponent(adminlabel)
                        .addComponent(userslabel))
                    .addComponent(labelMenu))
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(clientslabel)
                    .addComponent(conflabel)
                    .addComponent(confButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clientsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(labelMenu)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adminsButton)
                    .addComponent(clientsButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adminlabel)
                    .addComponent(clientslabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usregButton)
                    .addComponent(confButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(conflabel)
                    .addComponent(userslabel))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adminsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminsButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new admin_view().setVisible(true);

    }//GEN-LAST:event_adminsButtonActionPerformed

    private void confButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confButtonActionPerformed
        // TODO add your handling code here:
        //this.setVisible(false);
        //dispose();

        configview = new config_view();
        configview.setVisible(true);
    }//GEN-LAST:event_confButtonActionPerformed
    public void close(){
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adminlabel;
    private javax.swing.JButton adminsButton;
    private javax.swing.JButton clientsButton;
    private javax.swing.JLabel clientslabel;
    private javax.swing.JButton confButton;
    private javax.swing.JLabel conflabel;
    private javax.swing.JLabel labelMenu;
    private javax.swing.JLabel userslabel;
    private javax.swing.JButton usregButton;
    // End of variables declaration//GEN-END:variables
}
