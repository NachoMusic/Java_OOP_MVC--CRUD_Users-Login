/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.modules.users.view;

import application.models.Dates;
import application.models.SingletonF;
import application.modules.users.model.BLL.lib_files.json;
import application.modules.users.model.BLL.lib_files.txt;
import application.modules.users.model.BLL.lib_files.xml;
import application.modules.users.model.models.singleton;
import application.utils.Functions;
import application.utils.Menus;
import application.modules.menu.view.app_view;
import static application.modules.users.view.new_admin_view.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nacho
 */
public class admin_view extends javax.swing.JFrame {

    /**
     * Creates new form admin_view
     */
    DefaultTableModel model;
    String selected;

    public admin_view() {
        initComponents();
        closeWindow();
        this.setTitle("Administrators");
        this.setLocationRelativeTo(null);
        model = (DefaultTableModel) adminstable.getModel();

        for (int i = 0; i < singleton.admins.size(); i++) {
            model.insertRow(model.getRowCount(), new Object[]{singleton.admins.getData(i).getDni(),
                singleton.admins.getData(i).getName(), singleton.admins.getData(i).getSubname(),
                singleton.admins.getData(i).getPhone_number(), singleton.admins.getData(i).getEmail(),
                singleton.admins.getData(i).getUser(), singleton.admins.getData(i).getState(),
                singleton.admins.getData(i).getDate_birthday(), singleton.admins.getData(i).getHirin_date(),
                singleton.admins.getData(i).getSalary(), singleton.admins.getData(i).getActivity()
            });
        }
    }
    public static int Admintochange;

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
        findAButton = new javax.swing.JButton();
        sortbyAButton = new javax.swing.JButton();
        exportAButton = new javax.swing.JButton();
        importAButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelviews = new javax.swing.JPanel();
        list = new javax.swing.JScrollPane();
        adminstable = new javax.swing.JTable();
        beginning = new javax.swing.JButton();
        backwards = new javax.swing.JButton();
        forward = new javax.swing.JButton();
        end = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        filemenu = new javax.swing.JMenu();
        importmenu = new javax.swing.JMenuItem();
        exportmenu = new javax.swing.JMenuItem();
        sortmenu = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        listmenu = new javax.swing.JMenuItem();
        formmenu = new javax.swing.JMenuItem();
        kanbanmenu = new javax.swing.JMenuItem();

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

        jButton1.setText("Test button");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        panelviews.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(101, 101, 101)));

        adminstable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "Name", "Surname", "Phone", "Email", "User", "Status", "Birthday", "Hiring Date", "Salary", "Activity"
            }
        ));
        adminstable.setColumnSelectionAllowed(true);
        adminstable.getTableHeader().setReorderingAllowed(false);
        adminstable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminstableMouseClicked(evt);
            }
        });
        list.setViewportView(adminstable);
        adminstable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        beginning.setText("|<");

        backwards.setText("<");

        forward.setText(">");

        end.setText(">|");

        javax.swing.GroupLayout panelviewsLayout = new javax.swing.GroupLayout(panelviews);
        panelviews.setLayout(panelviewsLayout);
        panelviewsLayout.setHorizontalGroup(
            panelviewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelviewsLayout.createSequentialGroup()
                .addGap(324, 324, 324)
                .addComponent(beginning)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backwards)
                .addGap(34, 34, 34)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(forward)
                .addGap(18, 18, 18)
                .addComponent(end))
            .addComponent(list, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 923, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        panelviewsLayout.setVerticalGroup(
            panelviewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelviewsLayout.createSequentialGroup()
                .addComponent(list, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelviewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(beginning)
                    .addComponent(backwards)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(forward)
                    .addComponent(end))
                .addGap(22, 22, 22))
        );

        jTabbedPane1.addTab("List", panelviews);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 940, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 194, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Form", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 940, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 194, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Kanbas", jPanel2);

        filemenu.setText("File");

        importmenu.setText("Import");
        importmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importmenuActionPerformed(evt);
            }
        });
        filemenu.add(importmenu);

        exportmenu.setText("Export");
        exportmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportmenuActionPerformed(evt);
            }
        });
        filemenu.add(exportmenu);

        jMenuBar1.add(filemenu);

        sortmenu.setText("Sort");
        jMenuBar1.add(sortmenu);

        jMenu1.setText("Views");

        listmenu.setText("List");
        listmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listmenuActionPerformed(evt);
            }
        });
        jMenu1.add(listmenu);

        formmenu.setText("Form");
        jMenu1.add(formmenu);

        kanbanmenu.setText("Kanban");
        jMenu1.add(kanbanmenu);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(findAButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(createAButton, javax.swing.GroupLayout.Alignment.LEADING))
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
                                .addComponent(importAButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createAButton)
                            .addComponent(changeDataAButtorn)
                            .addComponent(printDataAButton)
                            .addComponent(deleteDataAButton))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(11, 11, 11)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(findAButton)
                    .addComponent(sortbyAButton)
                    .addComponent(exportAButton)
                    .addComponent(importAButton))
                .addGap(78, 78, 78))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createAButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAButtonActionPerformed
        // TODO add your handling code here:
        //singleton.admins.addData(functions_users.newadmin());
        new new_admin_view().setVisible(true);
    }//GEN-LAST:event_createAButtonActionPerformed

    private void changeDataAButtornActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeDataAButtornActionPerformed
        // TODO add your handling code here:
        //singleton.admins.changeData();

        Admintochange = Functions.validateint(SingletonF.language.getProperty("adminchange"), SingletonF.language.getProperty("adminchange2"));
        new new_admin_view().setVisible(true);
        saveAdminButton.setText("Edit Admin");
        emptyButton.setVisible(false);
        dniField.setText(singleton.admins.getData(Admintochange - 1).getDni());
        nameField.setText(singleton.admins.getData(Admintochange - 1).getName());
        subnameField.setText(singleton.admins.getData(Admintochange - 1).getSubname());
        phoneField.setText(singleton.admins.getData(Admintochange - 1).getPhone_number());
        emailField.setText(singleton.admins.getData(Admintochange - 1).getEmail());
        usernameField.setText(singleton.admins.getData(Admintochange - 1).getUser());
        passwordField.setText(singleton.admins.getData(Admintochange - 1).getPass());
        avatarField.setText(singleton.admins.getData(Admintochange - 1).getAvatar());
        statusField.setText(singleton.admins.getData(Admintochange - 1).getState());
        Dates b = new Dates(singleton.admins.getData(Admintochange - 1).getDate_birthday());
        datebirthdayField.setCalendar(b.DateToCalendar());
        Dates h = new Dates(singleton.admins.getData(Admintochange - 1).getHirin_date());
        hiringdateField.setCalendar(h.DateToCalendar());
        salaryField.setText(singleton.admins.getData(Admintochange - 1).getSalary() + "");
        activityField.setText(singleton.admins.getData(Admintochange - 1).getActivity() + "");
    }//GEN-LAST:event_changeDataAButtornActionPerformed

    private void printDataAButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printDataAButtonActionPerformed
        singleton.admins.printArraylist();
    }//GEN-LAST:event_printDataAButtonActionPerformed

    private void deleteDataAButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDataAButtonActionPerformed
        singleton.admins.deleteData();
    }//GEN-LAST:event_deleteDataAButtonActionPerformed

    private void findAButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findAButtonActionPerformed
        String[] find = {SingletonF.language.getProperty("bydni"), SingletonF.language.getProperty("byname"),
            SingletonF.language.getProperty("go_back")};
        int option = Menus.menu(find, SingletonF.language.getProperty("searchadmins"),
                SingletonF.language.getProperty("search"));
        switch (option) {
            case 0://By dni
                singleton.admins.find(0, Functions.validatestring("insert dni", "insert dni"));
                break;
            case 1://By name
                singleton.admins.find(1, Functions.validatestring("insert name", "insert name"));
                break;
            case 2://Go back
        }
    }//GEN-LAST:event_findAButtonActionPerformed

    private void exportAButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportAButtonActionPerformed
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

    private void exportmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportmenuActionPerformed
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
    }//GEN-LAST:event_exportmenuActionPerformed

    private void importmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importmenuActionPerformed
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
    }//GEN-LAST:event_importmenuActionPerformed

    private void listmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listmenuActionPerformed
        adminstable.setVisible(true);
    }//GEN-LAST:event_listmenuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.out.print(selected);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void adminstableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminstableMouseClicked
        // TODO add your handling code here:
        selected = String.valueOf(model.getValueAt(adminstable.getSelectedRow(), 0));
    }//GEN-LAST:event_adminstableMouseClicked

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable adminstable;
    private javax.swing.JButton backwards;
    private javax.swing.JButton beginning;
    private javax.swing.JButton changeDataAButtorn;
    private javax.swing.JButton createAButton;
    private javax.swing.JButton deleteDataAButton;
    private javax.swing.JButton end;
    private javax.swing.JButton exportAButton;
    private javax.swing.JMenuItem exportmenu;
    private javax.swing.JMenu filemenu;
    private javax.swing.JButton findAButton;
    private javax.swing.JMenuItem formmenu;
    private javax.swing.JButton forward;
    private javax.swing.JButton importAButton;
    private javax.swing.JMenuItem importmenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JMenuItem kanbanmenu;
    private javax.swing.JScrollPane list;
    private javax.swing.JMenuItem listmenu;
    private javax.swing.JPanel panelviews;
    private javax.swing.JButton printDataAButton;
    private javax.swing.JButton sortbyAButton;
    private javax.swing.JMenu sortmenu;
    // End of variables declaration//GEN-END:variables
}
