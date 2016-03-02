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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
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
    int page, movepage;

    public admin_view() {
        initComponents();
        closeWindow();

        this.setTitle("Administrators");
        this.setLocationRelativeTo(null);
        page = 10;
        movepage = 10;
        updatetable();
        //messages();
        //admincreated.setVisible(false);
        timer.start();
        /*model = (DefaultTableModel) adminstable.getModel();

        for (int i = 0; i < singleton.admins.size(); i++) {
            model.insertRow(model.getRowCount(), new Object[]{i+1,singleton.admins.getData(i).getDni(),
                singleton.admins.getData(i).getName(), singleton.admins.getData(i).getSubname(),
                singleton.admins.getData(i).getPhone_number(), singleton.admins.getData(i).getEmail(),
                singleton.admins.getData(i).getUser(), singleton.admins.getData(i).getState(),
                singleton.admins.getData(i).getDate_birthday(), singleton.admins.getData(i).getHirin_date(),
                singleton.admins.getData(i).getSalary(), singleton.admins.getData(i).getActivity()
            });
        }*/
    }

    public void updatetable() {
        adminstable = new javax.swing.JTable();
        adminstable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Num", "DNI", "Name", "Surname", "Phone", "Email", "User", "Status", "Birthday", "Age", "Hiring Date", "Salary", "Activity"
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

        model = (DefaultTableModel) adminstable.getModel();

        int maxpage = singleton.admins.size();
        if (movepage > maxpage) {
            movepage = maxpage;
        }
        if (maxpage < 10) {
            for (int i = 0; i < singleton.admins.size(); i++) {
                model.insertRow(model.getRowCount(), new Object[]{i + 1, singleton.admins.getData(i).getDni(),
                    singleton.admins.getData(i).getName(), singleton.admins.getData(i).getSubname(),
                    singleton.admins.getData(i).getPhone_number(), singleton.admins.getData(i).getEmail(),
                    singleton.admins.getData(i).getUser(), singleton.admins.getData(i).getState(),
                    singleton.admins.getData(i).getDate_birthday(), singleton.admins.getData(i).getAge(),
                    singleton.admins.getData(i).getHirin_date(), singleton.admins.getData(i).getSalary(),
                    singleton.admins.getData(i).getActivity()
                });
            }
        } else {
            if (movepage - page < 0 || movepage < 0) {
                movepage = 10;
                page = 10;
                combopage.setSelectedIndex(0);
                for (int i = 0; i < 10; i++) {
                    model.insertRow(model.getRowCount(), new Object[]{i + 1, singleton.admins.getData(i).getDni(),
                        singleton.admins.getData(i).getName(), singleton.admins.getData(i).getSubname(),
                        singleton.admins.getData(i).getPhone_number(), singleton.admins.getData(i).getEmail(),
                        singleton.admins.getData(i).getUser(), singleton.admins.getData(i).getState(),
                        singleton.admins.getData(i).getDate_birthday(), singleton.admins.getData(i).getAge(),
                        singleton.admins.getData(i).getHirin_date(), singleton.admins.getData(i).getSalary(),
                        singleton.admins.getData(i).getActivity()
                    });
                }
            }
            for (int i = (movepage - page); i < movepage; i++) {
                model.insertRow(model.getRowCount(), new Object[]{i + 1, singleton.admins.getData(i).getDni(),
                    singleton.admins.getData(i).getName(), singleton.admins.getData(i).getSubname(),
                    singleton.admins.getData(i).getPhone_number(), singleton.admins.getData(i).getEmail(),
                    singleton.admins.getData(i).getUser(), singleton.admins.getData(i).getState(),
                    singleton.admins.getData(i).getDate_birthday(), singleton.admins.getData(i).getAge(),
                    singleton.admins.getData(i).getHirin_date(), singleton.admins.getData(i).getSalary(),
                    singleton.admins.getData(i).getActivity()
                });
            }
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
        tabbedtable = new javax.swing.JTabbedPane();
        panelviews = new javax.swing.JPanel();
        list = new javax.swing.JScrollPane();
        adminstable = new javax.swing.JTable();
        beginning = new javax.swing.JButton();
        backwards = new javax.swing.JButton();
        forward = new javax.swing.JButton();
        end = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        combopage = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        dniform = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nameform = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        surnameform = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        phoneform = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        emailform = new javax.swing.JTextField();
        userform = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        stateform = new javax.swing.JTextField();
        birthdayform = new javax.swing.JTextField();
        hiringdateform = new javax.swing.JTextField();
        salaryform = new javax.swing.JTextField();
        activityform = new javax.swing.JTextField();
        avatarform = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ageform = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        admincreated = new javax.swing.JLabel();
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
        panelviews.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        adminstable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num", "DNI", "Name", "Surname", "Phone", "Email", "User", "Status", "Birthday", "Age", "Hiring Date", "Salary", "Activity"
            }
        ));
        adminstable.setColumnSelectionAllowed(true);
        adminstable.getTableHeader().setReorderingAllowed(false);
        adminstable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                adminstableMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminstableMouseClicked(evt);
            }
        });
        list.setViewportView(adminstable);
        adminstable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        panelviews.add(list, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 1130, 190));

        beginning.setText("|<");
        panelviews.add(beginning, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, -1, -1));

        backwards.setText("<");
        backwards.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backwardsActionPerformed(evt);
            }
        });
        panelviews.add(backwards, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, -1, -1));

        forward.setText(">");
        forward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forwardActionPerformed(evt);
            }
        });
        panelviews.add(forward, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 190, -1, -1));

        end.setText(">|");
        panelviews.add(end, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 190, -1, -1));
        panelviews.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 190, 51, -1));

        combopage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Show 10 Admins", "Show 5 Admins" }));
        combopage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combopageActionPerformed(evt);
            }
        });
        panelviews.add(combopage, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 190, -1, -1));

        tabbedtable.addTab("List", panelviews);

        jLabel2.setText("DNI:");

        dniform.setEditable(false);

        jLabel4.setText("Name:");

        nameform.setEditable(false);

        jLabel6.setText("Surname:");

        surnameform.setEditable(false);

        jLabel1.setText("Phone:");

        phoneform.setEditable(false);

        jLabel3.setText("Email:");

        jLabel5.setText("User:");

        emailform.setEditable(false);

        userform.setEditable(false);

        jLabel7.setText("Status:");

        jLabel8.setText("Birthday:");

        jLabel9.setText("Hiring date:");

        jLabel10.setText("Salary:");

        jLabel11.setText("Activity:");

        stateform.setEditable(false);

        birthdayform.setEditable(false);

        hiringdateform.setEditable(false);

        salaryform.setEditable(false);

        activityform.setEditable(false);

        avatarform.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel12.setText("Age:");

        ageform.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nameform)
                            .addComponent(dniform)
                            .addComponent(surnameform)
                            .addComponent(phoneform, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stateform, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(birthdayform, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(emailform, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userform, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(hiringdateform)
                    .addComponent(salaryform)
                    .addComponent(activityform)
                    .addComponent(ageform, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                .addGap(89, 89, 89)
                .addComponent(avatarform, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(dniform, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(nameform, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(surnameform, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(phoneform, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailform, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel12)
                            .addComponent(ageform, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(userform, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(stateform, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(birthdayform, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(hiringdateform, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(salaryform, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(activityform, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(avatarform, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedtable.addTab("Form", jPanel1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1132, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 224, Short.MAX_VALUE)
        );

        tabbedtable.addTab("Kanban", jPanel3);

        admincreated.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        admincreated.setForeground(new java.awt.Color(18, 107, 1));
        admincreated.setText("Admins");

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
                        .addComponent(tabbedtable))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(findAButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(createAButton, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(111, 111, 111)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(changeDataAButtorn)
                            .addComponent(sortbyAButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(exportAButton)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(printDataAButton)
                                .addGap(216, 216, 216)))
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(deleteDataAButton)
                            .addComponent(importAButton))
                        .addGap(138, 138, 138)
                        .addComponent(jButton1)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(552, 552, 552)
                .addComponent(admincreated)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabbedtable, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(admincreated)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(findAButton)
                            .addComponent(sortbyAButton)
                            .addComponent(exportAButton)
                            .addComponent(importAButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createAButton)
                            .addComponent(changeDataAButtorn)
                            .addComponent(printDataAButton)
                            .addComponent(deleteDataAButton))
                        .addGap(60, 60, 60)))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createAButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAButtonActionPerformed
        // TODO add your handling code here:
        //singleton.admins.addData(functions_users.newadmin());
        new new_admin_view().setVisible(true);
        dispose();
    }//GEN-LAST:event_createAButtonActionPerformed

    private void changeDataAButtornActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeDataAButtornActionPerformed
        // TODO add your handling code here:
        //singleton.admins.changeData();
        if (selected != null) {
            Admintochange = Integer.parseInt(selected);
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
            dispose();
        }
    }//GEN-LAST:event_changeDataAButtornActionPerformed

    private void printDataAButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printDataAButtonActionPerformed
        singleton.admins.printArraylist();
    }//GEN-LAST:event_printDataAButtonActionPerformed

    private void deleteDataAButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDataAButtonActionPerformed
        if (selected != null) {
            singleton.admins.deleteData(Integer.parseInt(selected));
            updatetable();
        }
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
        updatetable();
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
        updatetable();
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
        dniform.setText(String.valueOf(model.getValueAt(adminstable.getSelectedRow(), 1)));
        nameform.setText(String.valueOf(model.getValueAt(adminstable.getSelectedRow(), 2)));
        surnameform.setText(String.valueOf(model.getValueAt(adminstable.getSelectedRow(), 3)));
        phoneform.setText(String.valueOf(model.getValueAt(adminstable.getSelectedRow(), 4)));
        emailform.setText(String.valueOf(model.getValueAt(adminstable.getSelectedRow(), 5)));
        userform.setText(String.valueOf(model.getValueAt(adminstable.getSelectedRow(), 6)));
        stateform.setText(String.valueOf(model.getValueAt(adminstable.getSelectedRow(), 7)));
        birthdayform.setText(String.valueOf(model.getValueAt(adminstable.getSelectedRow(), 8)));
        ageform.setText(String.valueOf(model.getValueAt(adminstable.getSelectedRow(), 9)));
        hiringdateform.setText(String.valueOf(model.getValueAt(adminstable.getSelectedRow(), 10)));
        salaryform.setText(String.valueOf(model.getValueAt(adminstable.getSelectedRow(), 11)));
        activityform.setText(String.valueOf(model.getValueAt(adminstable.getSelectedRow(), 12)));
    }//GEN-LAST:event_adminstableMouseClicked

    private void adminstableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminstableMousePressed
        //Poner que al clicar doble entre en el form
    }//GEN-LAST:event_adminstableMousePressed

    private void forwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forwardActionPerformed
        // TODO add your handling code here:
        movepage += page;
        if (movepage > singleton.admins.size() + page) {
            //movepage -= page;
            movepage = 10;
        }
        updatetable();
    }//GEN-LAST:event_forwardActionPerformed

    private void backwardsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backwardsActionPerformed
        // TODO add your handling code here:
        movepage -= page;
        if (movepage < page) {
            movepage = page;
        }
        updatetable();
    }//GEN-LAST:event_backwardsActionPerformed

    private void combopageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combopageActionPerformed
        // TODO add your handling code here:

        switch (combopage.getSelectedIndex()) {
            case 0:
                movepage = 10;
                page = 10;
                break;
            case 1:
                movepage = 10;
                page = 5;
                break;
            /*case 2:
                if (singleton.admins.size() > 20) {
                    movepage = 10;
                    page = 20;
                }
                break;
            case 3:
                if (singleton.admins.size() > 50) {
                    movepage = 10;
                    page = 50;
                }
                break;*/
        }
        updatetable();
    }//GEN-LAST:event_combopageActionPerformed

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

    Timer timer = new Timer(30000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                admincreated.setVisible(false);
            }
        });
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField activityform;
    public static javax.swing.JLabel admincreated;
    private javax.swing.JTable adminstable;
    private javax.swing.JTextField ageform;
    private javax.swing.JLabel avatarform;
    private javax.swing.JButton backwards;
    private javax.swing.JButton beginning;
    private javax.swing.JTextField birthdayform;
    private javax.swing.JButton changeDataAButtorn;
    private javax.swing.JComboBox<String> combopage;
    private javax.swing.JButton createAButton;
    private javax.swing.JButton deleteDataAButton;
    private javax.swing.JTextField dniform;
    private javax.swing.JTextField emailform;
    private javax.swing.JButton end;
    private javax.swing.JButton exportAButton;
    private javax.swing.JMenuItem exportmenu;
    private javax.swing.JMenu filemenu;
    private javax.swing.JButton findAButton;
    private javax.swing.JMenuItem formmenu;
    private javax.swing.JButton forward;
    private javax.swing.JTextField hiringdateform;
    private javax.swing.JButton importAButton;
    private javax.swing.JMenuItem importmenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JMenuItem kanbanmenu;
    private javax.swing.JScrollPane list;
    private javax.swing.JMenuItem listmenu;
    private javax.swing.JTextField nameform;
    private javax.swing.JPanel panelviews;
    private javax.swing.JTextField phoneform;
    private javax.swing.JButton printDataAButton;
    private javax.swing.JTextField salaryform;
    private javax.swing.JButton sortbyAButton;
    private javax.swing.JMenu sortmenu;
    private javax.swing.JTextField stateform;
    private javax.swing.JTextField surnameform;
    private javax.swing.JTabbedPane tabbedtable;
    private javax.swing.JTextField userform;
    // End of variables declaration//GEN-END:variables
}
