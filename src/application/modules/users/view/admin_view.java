/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.modules.users.view;

import application.models.SingletonF;
import application.modules.users.model.BLL.lib_files.json;
import application.modules.users.model.BLL.lib_files.txt;
import application.modules.users.model.BLL.lib_files.xml;
import application.modules.users.model.DAO.functions_users;
import application.modules.users.model.models.singleton;
import application.utils.Menus;
import application.view.app_view;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author nacho
 */
public class admin_view extends javax.swing.JFrame {

    /**
     * Creates new form admin_view
     */
    public admin_view() {
        initComponents();
        closeWindow();
        this.setTitle("Administrators");
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        createAButton = new javax.swing.JButton();
        changeDataAButtorn = new javax.swing.JButton();
        printDataAButton = new javax.swing.JButton();
        deleteDataAButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        findAButton = new javax.swing.JButton();
        sortbyAButton = new javax.swing.JButton();
        exportAButton = new javax.swing.JButton();
        importAButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        createAButton.setText("Create");
        createAButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAButtonActionPerformed(evt);
            }
        });

        changeDataAButtorn.setText("Change Data");
        changeDataAButtorn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeDataAButtornActionPerformed(evt);
            }
        });

        printDataAButton.setText("Print Data");
        printDataAButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printDataAButtonActionPerformed(evt);
            }
        });

        deleteDataAButton.setText("Delete");
        deleteDataAButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDataAButtonActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        findAButton.setText("Find");
        findAButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findAButtonActionPerformed(evt);
            }
        });

        sortbyAButton.setText("Sort By");
        sortbyAButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortbyAButtonActionPerformed(evt);
            }
        });

        exportAButton.setText("Export");
        exportAButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportAButtonActionPerformed(evt);
            }
        });

        importAButton.setText("Import");
        importAButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importAButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(findAButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(createAButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(changeDataAButtorn)
                            .addComponent(sortbyAButton))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(printDataAButton)
                                .addGap(92, 92, 92)
                                .addComponent(deleteDataAButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(exportAButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(importAButton)))))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createAButton)
                    .addComponent(changeDataAButtorn)
                    .addComponent(printDataAButton)
                    .addComponent(deleteDataAButton))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(findAButton)
                    .addComponent(sortbyAButton)
                    .addComponent(exportAButton)
                    .addComponent(importAButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createAButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAButtonActionPerformed
        // TODO add your handling code here:
        singleton.admins.addData(functions_users.newadmin());
    }//GEN-LAST:event_createAButtonActionPerformed

    private void changeDataAButtornActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeDataAButtornActionPerformed
        // TODO add your handling code here:
        singleton.admins.changeData();
    }//GEN-LAST:event_changeDataAButtornActionPerformed

    private void printDataAButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printDataAButtonActionPerformed
        // TODO add your handling code here:
        singleton.admins.printArraylist();
    }//GEN-LAST:event_printDataAButtonActionPerformed

    private void deleteDataAButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDataAButtonActionPerformed
        // TODO add your handling code here:
        singleton.admins.deleteData();
    }//GEN-LAST:event_deleteDataAButtonActionPerformed

    private void findAButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findAButtonActionPerformed
        // TODO add your handling code here:
        String[] find = {SingletonF.language.getProperty("bydni"), SingletonF.language.getProperty("byname"),
            SingletonF.language.getProperty("go_back")};
        int option = Menus.menu(find, SingletonF.language.getProperty("searchadmins"),
                SingletonF.language.getProperty("search"));
        switch (option) {
            case 0://By dni
                singleton.admins.find(0);
                break;
            case 1://By name
                singleton.admins.find(1);
                break;
            case 2://Go back
        }
    }//GEN-LAST:event_findAButtonActionPerformed

    private void exportAButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportAButtonActionPerformed
        // TODO add your handling code here:
        switch (SingletonF.configApp.getSavingextension()) {
            case "json"://json
                json.createjson();
                break;
            case "xml"://xml
                xml.createxml();
                break;
            case "txt"://txt
                txt.createtxt();
                break;
        }
    }//GEN-LAST:event_exportAButtonActionPerformed

    private void importAButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importAButtonActionPerformed
        // TODO add your handling code here:
        switch (SingletonF.configApp.getSavingextension()) {
            case "json"://json
                json.load_json();
                break;
            case "xml"://xml
                xml.load_xml();
                break;
            case "txt": //txt
                txt.load_txt();
                break;
        }
    }//GEN-LAST:event_importAButtonActionPerformed

    private void sortbyAButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortbyAButtonActionPerformed
        // TODO add your handling code here:
        String[] sortBy = {"By DNI", "By name", "By birthday", SingletonF.language.getProperty("go_back")};
        int option = Menus.menu(sortBy, SingletonF.language.getProperty("sortadmins"),
                SingletonF.language.getProperty("sort"));
        switch (option) {
            case 0://By dni
                singleton.admins.sortData(0);
                break;
            case 1://By name
                singleton.admins.sortData(1);
                break;
            case 2://By date birthday
                singleton.admins.sortData(2);
                break;
            case 3://Go back
        }
    }//GEN-LAST:event_sortbyAButtonActionPerformed

    private void closeWindow() {
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //setVisible(false);
                dispose();
                new app_view().setVisible(true);
            }
        });
    }

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(admin_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_view().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changeDataAButtorn;
    private javax.swing.JButton createAButton;
    private javax.swing.JButton deleteDataAButton;
    private javax.swing.JButton exportAButton;
    private javax.swing.JButton findAButton;
    private javax.swing.JButton importAButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton printDataAButton;
    private javax.swing.JButton sortbyAButton;
    // End of variables declaration//GEN-END:variables
}
