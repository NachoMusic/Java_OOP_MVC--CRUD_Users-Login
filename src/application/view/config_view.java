/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.view;

import application.models.SingletonF;
import application.modules.users.model.BLL.Arraylist_admin;
import application.modules.users.model.BLL.lib_files.json;
import application.modules.users.model.BLL.lib_files.txt;
import application.modules.users.model.BLL.lib_files.xml;
import application.modules.users.model.kernel.Dummies;
import application.modules.users.model.models.singleton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author nacho
 */
public class config_view extends javax.swing.JFrame {

    /**
     * Creates new form config_view
     */
    public config_view() {
        initComponents();
        closeWindow();
        successAddDum.setVisible(false);
        this.setTitle(SingletonF.language.getProperty("config"));
        this.setLocationRelativeTo(null);
        switch (SingletonF.configApp.getCurrency_config()) {
            case '€':
                comboCurrency.setSelectedIndex(0);
                break;
            case '$':
                comboCurrency.setSelectedIndex(1);
                break;
            case '£':
                comboCurrency.setSelectedIndex(2);
        }
        decimalsCombo.setSelectedIndex(SingletonF.configApp.getDecimals_config() - 1);
        dateCombo.setSelectedIndex(SingletonF.configApp.getDate_config());
        if (SingletonF.configApp.getDummiesmode()) {
            dummiesOn.setSelected(true);
        } else {
            dummiesOff.setSelected(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        confpane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboCurrency = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        decimalsCombo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        dateCombo = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        dummiesOn = new javax.swing.JRadioButton();
        dummiesOff = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        addRandomDummies = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        howmanyDummies = new javax.swing.JSpinner();
        successAddDum = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        resetConf = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Currency:");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        comboCurrency.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "€", "$", "£" }));
        comboCurrency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCurrencyActionPerformed(evt);
            }
        });

        jLabel6.setText("Decimals:");
        jLabel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        decimalsCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));
        decimalsCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decimalsComboActionPerformed(evt);
            }
        });

        jLabel7.setText("Date format:");
        jLabel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        dateCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "dd/mm/yyyy", "dd-mm-yyyy", "yyyy/mm/dd", "yyyy-mm-dd" }));
        dateCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comboCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(decimalsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 169, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(decimalsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(dateCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(144, Short.MAX_VALUE))
        );

        confpane.addTab("General", jPanel1);

        buttonGroup1.add(dummiesOn);
        dummiesOn.setText("Activated");
        dummiesOn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dummiesOnActionPerformed(evt);
            }
        });

        buttonGroup1.add(dummiesOff);
        dummiesOff.setText("Deactivate");
        dummiesOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dummiesOffActionPerformed(evt);
            }
        });

        jLabel5.setText("Dummies mode:");
        jLabel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        addRandomDummies.setText("Add random dummies");
        addRandomDummies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRandomDummiesActionPerformed(evt);
            }
        });

        jLabel2.setText("You can add random dummies with generated fields");
        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        howmanyDummies.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                howmanyDummiesStateChanged(evt);
            }
        });

        successAddDum.setForeground(new java.awt.Color(6, 124, 15));
        successAddDum.setText("Added dummies");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(dummiesOn)
                                .addGap(72, 72, 72)
                                .addComponent(dummiesOff))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel2)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(94, 94, 94)
                                    .addComponent(howmanyDummies, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(addRandomDummies)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(12, 12, 12)
                                            .addComponent(successAddDum, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabel5)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dummiesOff)
                    .addComponent(dummiesOn))
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addRandomDummies)
                    .addComponent(howmanyDummies, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(successAddDum, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        confpane.addTab("Dummies", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 381, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 273, Short.MAX_VALUE)
        );

        confpane.addTab("Look n' Feel", jPanel3);

        jLabel4.setText("Warning, if you reset the config you will lose all the configuration");

        resetConf.setBackground(new java.awt.Color(255, 0, 0));
        resetConf.setText("Reset Configuration");
        resetConf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetConfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(resetConf, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(resetConf, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
        );

        confpane.addTab("Reset Config", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(confpane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(confpane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboCurrencyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCurrencyActionPerformed
        // TODO add your handling code here:
        char monedaAnterior;
        switch (comboCurrency.getSelectedIndex()) {
            case 0:
                monedaAnterior = SingletonF.configApp.getCurrency_config();
                SingletonF.configApp.setCurrency_config('€');
                singleton.admins.changeFormatCurrency(monedaAnterior);
                break;
            case 1:
                monedaAnterior = SingletonF.configApp.getCurrency_config();
                SingletonF.configApp.setCurrency_config('$');
                singleton.admins.changeFormatCurrency(monedaAnterior);
                break;
            case 2:
                monedaAnterior = SingletonF.configApp.getCurrency_config();
                SingletonF.configApp.setCurrency_config('£');
                singleton.admins.changeFormatCurrency(monedaAnterior);
                break;
        }
    }//GEN-LAST:event_comboCurrencyActionPerformed

    private void resetConfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetConfActionPerformed
        char monedaAnterior = SingletonF.configApp.getCurrency_config();
        SingletonF.language.setIdioma(SingletonF.configApp.getLanguage_config());
        for (int i = 0; i < singleton.admins.getAdmins().size(); i++) {
            singleton.admins.getData(i).changeCurrency(monedaAnterior);
        }
        SingletonF.configApp.setSavingextension("json");
        SingletonF.configApp.setDecimals_config(2);
        SingletonF.configApp.setLookandfeel(0);
    }//GEN-LAST:event_resetConfActionPerformed

    private void decimalsComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decimalsComboActionPerformed
        // TODO add your handling code here:
        SingletonF.configApp.setDecimals_config(decimalsCombo.getSelectedIndex() + 1);
    }//GEN-LAST:event_decimalsComboActionPerformed

    private void dummiesOnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dummiesOnActionPerformed
        // TODO add your handling code here:
        json.createjson_auto();
        xml.createxml_auto();
        txt.createtxt_auto();
        SingletonF.configApp.setDummiesmode(true);
        singleton.admins = new Arraylist_admin();
        switch (SingletonF.configApp.getSavingextension()) {
            case "json"://json
                json.load_json_auto();
                break;
            case "xml"://xml
                xml.load_xml_auto();
                break;
            case "txt": //txt
                txt.load_txt_auto();
                break;
        }
    }//GEN-LAST:event_dummiesOnActionPerformed

    private void dummiesOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dummiesOffActionPerformed
        // TODO add your handling code here:
        json.createjson_auto();
        xml.createxml_auto();
        txt.createtxt_auto();
        SingletonF.configApp.setDummiesmode(false);
        singleton.admins = new Arraylist_admin();
        switch (SingletonF.configApp.getSavingextension()) {
            case "json"://json
                json.load_json_auto();
                break;
            case "xml"://xml
                xml.load_xml_auto();
                break;
            case "txt": //txt
                txt.load_txt_auto();
                break;
        }
    }//GEN-LAST:event_dummiesOffActionPerformed

    private void addRandomDummiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRandomDummiesActionPerformed
        // TODO add your handling code here:
        Dummies.generatedummies(Integer.parseInt(howmanyDummies.getValue().toString()));
        successAddDum.setVisible(true);
    }//GEN-LAST:event_addRandomDummiesActionPerformed

    private void howmanyDummiesStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_howmanyDummiesStateChanged
        // TODO add your handling code here:
        if(Integer.parseInt(howmanyDummies.getValue().toString())<0){
            howmanyDummies.setValue(0);
        }
    }//GEN-LAST:event_howmanyDummiesStateChanged

    private void dateComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateComboActionPerformed
        // TODO add your handling code here:
        SingletonF.configApp.setDate_config(dateCombo.getSelectedIndex());
    }//GEN-LAST:event_dateComboActionPerformed

    private void closeWindow() {
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
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
            java.util.logging.Logger.getLogger(config_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(config_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(config_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(config_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new config_view().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRandomDummies;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comboCurrency;
    private javax.swing.JTabbedPane confpane;
    private javax.swing.JComboBox<String> dateCombo;
    private javax.swing.JComboBox<String> decimalsCombo;
    private javax.swing.JRadioButton dummiesOff;
    private javax.swing.JRadioButton dummiesOn;
    private javax.swing.JSpinner howmanyDummies;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton resetConf;
    private javax.swing.JLabel successAddDum;
    // End of variables declaration//GEN-END:variables
}
