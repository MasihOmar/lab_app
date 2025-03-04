/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package labapp;
import java.awt.Color;
import java.sql.*;
//import java.awt.event.*;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.table.DefaultTableModel;
import javax.swing.BorderFactory;

/**
 *
 * @author masihullahomar
 */
public class Tests extends javax.swing.JFrame {

    /**
     * Creates new form Tests
     */
    
    private Connection connection;
    private Statement stm;
    private ResultSet rs;
    private DefaultTableModel model;
    
    public Tests() {
        initComponents();
//        setShape(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),20,20));
//        this.getContentPane().setBackground(Color.white);
        setLocationRelativeTo(null); // Center the window
        connection = new DatabaseConnection().connect();
        model = new DefaultTableModel();
        testTable.setModel(model);
        showTests();
//        getContentPane().setBackground(Color.white);
    }
    
   private void showTests() {
        try {
            // Initialize table columns
            model.setColumnCount(0); // Reset the columns before adding new ones
            model.addColumn("Test ID");
            model.addColumn("Test Name");
            model.addColumn("Test Cost");
            model.addColumn("Test Description");

            // Execute query to fetch data
            stm = connection.createStatement();
            rs = stm.executeQuery("SELECT * FROM testTbl");

            // Clear previous rows
            model.setRowCount(0); // Reset the rows before populating them

            // Populate the table with data
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("testId"),
                    rs.getString("testName"),
                    rs.getString("testCost"),
                    rs.getString("testDescription")
                });
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    
     private void clearInputFields() {
        testIdField.setText("");
        testNameField.setText("");
        testCostField.setText("");
        testDescriptionField.setText("");
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new RoundedPanel(0,30,0,30);
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        testIdField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        testNameField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        testCostField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        updateTestBtn = new RoundedButton(20);
        deleteTestBtn = new RoundedButton(20);
        addTestBtn = new RoundedButton(20);
        jScrollPane1 = new javax.swing.JScrollPane();
        testTable = new javax.swing.JTable();
        testDescriptionField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1100, 550));

        jPanel1.setBackground(new java.awt.Color(255, 25, 25));
        jPanel1.setPreferredSize(new java.awt.Dimension(150, 0));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labapp/Statics/patient_w.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labapp/Statics/result_w.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labapp/Statics/test_w.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labapp/Statics/laboratorian_w.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labapp/Statics/log_out.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labapp/Statics/lab.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(jLabel8))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(66, 66, 66)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        testIdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testIdFieldActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 25, 25));
        jLabel4.setText("Test ID");

        testNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testNameFieldActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setText("Test Name");

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 51, 51));
        jLabel11.setText("Test Cost");

        updateTestBtn.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        updateTestBtn.setForeground(new java.awt.Color(255, 51, 51));
        updateTestBtn.setText("Update Test");
        updateTestBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateTestBtnMouseClicked(evt);
            }
        });
        updateTestBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateTestBtnActionPerformed(evt);
            }
        });

        deleteTestBtn.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        deleteTestBtn.setForeground(new java.awt.Color(255, 51, 51));
        deleteTestBtn.setText("Delete Test");
        deleteTestBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteTestBtnMouseClicked(evt);
            }
        });
        deleteTestBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTestBtnActionPerformed(evt);
            }
        });

        addTestBtn.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        addTestBtn.setForeground(new java.awt.Color(255, 51, 51));
        addTestBtn.setText("Add Test");
        addTestBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addTestBtnMouseClicked(evt);
            }
        });
        addTestBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTestBtnActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        //jScrollPane1.getViewport().setBackground(Color.WHITE);

        testTable.setAutoCreateRowSorter(true);
        testTable.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        testTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Test ID", "Test Name", "Test Cost", "Test Description"
            }
        ));
        jScrollPane1.setViewportView(testTable);

        testDescriptionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testDescriptionFieldActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setText("Test Description");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labapp/Statics/x-circle.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labapp/Statics/minus-circle.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labapp/Statics/minimize.png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 3, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 25, 25));
        jLabel14.setText("Marmara Medical Lab");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(updateTestBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addTestBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deleteTestBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(testCostField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(testDescriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(testIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(testNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)
                        .addGap(82, 82, 82))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(418, 418, 418)
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13)
                    .addComponent(jLabel3))
                .addGap(36, 36, 36)
                .addComponent(jLabel14)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(testIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(testNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(testCostField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(testDescriptionField))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(addTestBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(deleteTestBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateTestBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void testIdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testIdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_testIdFieldActionPerformed

    private void testNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_testNameFieldActionPerformed

    private void updateTestBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateTestBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateTestBtnActionPerformed

    private void deleteTestBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTestBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteTestBtnActionPerformed

    private void addTestBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTestBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addTestBtnActionPerformed

    private void testDescriptionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testDescriptionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_testDescriptionFieldActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        this.setExtendedState(Tests.ICONIFIED);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
        if(this.getExtendedState()!=Tests.MAXIMIZED_BOTH){
            this.setExtendedState(Tests.MAXIMIZED_BOTH);
        }else{
            this.setExtendedState(Tests.NORMAL);
        }
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        new Patients().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        new Tests().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        new Results().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        new Laboratorians().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        new DashBoard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void addTestBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addTestBtnMouseClicked
        // TODO add your handling code here:
        try {
        // Get input from the fields
        String testId = testIdField.getText();
        String testName = testNameField.getText();
        String testCost = testCostField.getText();
        String testDescription = testDescriptionField.getText();

        // Validate that the testId is a valid integer
        if (testId.isEmpty() || testName.isEmpty() || testCost.isEmpty() || testDescription.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return;
        }

        try {
            Integer.parseInt(testId);  // Try to parse testId as integer
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Test ID must be a valid number.");
            return;
        }

        // Prepare the SQL query to insert the data, including the manually entered testId
        String query = "INSERT INTO testTbl (testId, testName, testCost, testDescription) VALUES (?, ?, ?, ?)";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setInt(1, Integer.parseInt(testId));  // Set the manually provided testId
        pst.setString(2, testName);
        pst.setString(3, testCost);
        pst.setString(4, testDescription);

        // Execute the query
        pst.executeUpdate();

        // Show success message and refresh the table
        JOptionPane.showMessageDialog(this, "Test added successfully.");
        showTests(); // Refresh the table
        clearInputFields(); // Clear input fields after adding the test
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
    }
    }//GEN-LAST:event_addTestBtnMouseClicked

    private void deleteTestBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteTestBtnMouseClicked
        try {
        int selectedRow = testTable.getSelectedRow();
        if (selectedRow != -1) {
            String testId = model.getValueAt(selectedRow, 0).toString(); // Get testId from the selected row
            
            // Start a transaction to ensure data consistency
            connection.setAutoCommit(false);
            
            // Delete dependent rows from resultsTbl
            String deleteResultsQuery = "DELETE FROM resultsTbl WHERE testId = ?";
            PreparedStatement pstResults = connection.prepareStatement(deleteResultsQuery);
            pstResults.setString(1, testId);
            pstResults.executeUpdate();
            
            // Delete the test from testTbl
            String deleteTestQuery = "DELETE FROM testTbl WHERE testId = ?";
            PreparedStatement pstTest = connection.prepareStatement(deleteTestQuery);
            pstTest.setString(1, testId);
            pstTest.executeUpdate();
            
            // Commit the transaction
            connection.commit();
            
            // Remove the row from the table model
            model.removeRow(selectedRow);
            
            JOptionPane.showMessageDialog(this, "Test and related results deleted successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "Please select a test to delete.");
        }
    } catch (SQLException ex) {
        try {
            // Rollback the transaction in case of an error
            connection.rollback();
        } catch (SQLException rollbackEx) {
            JOptionPane.showMessageDialog(this, "Rollback Error: " + rollbackEx.getMessage());
        }
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
    } finally {
        try {
            // Reset auto-commit to true
            connection.setAutoCommit(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error resetting auto-commit: " + ex.getMessage());
        }
    }
    }//GEN-LAST:event_deleteTestBtnMouseClicked

    private void updateTestBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateTestBtnMouseClicked
        // TODO add your handling code here:
        try {
            int selectedRow = testTable.getSelectedRow();
            if (selectedRow != -1) {
                String testId = model.getValueAt(selectedRow, 0).toString(); // Get testId from the selected row
                String testName = testNameField.getText();
                String testCost = testCostField.getText();
                String testDescription = testDescriptionField.getText();

                String query = "UPDATE testTbl SET testName = ?, testCost = ?, testDescription = ? WHERE testId = ?";
                PreparedStatement pst = connection.prepareStatement(query);
                pst.setString(1, testName);
                pst.setString(2, testCost);
                pst.setString(3, testDescription);
                pst.setString(4, testId);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Test updated successfully.");
                showTests(); // Refresh the table
                clearInputFields(); // Clear input fields
            } else {
                JOptionPane.showMessageDialog(this, "Please select a test to update.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_updateTestBtnMouseClicked

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Tests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Tests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Tests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Tests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Tests().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTestBtn;
    private javax.swing.JButton deleteTestBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField testCostField;
    private javax.swing.JTextField testDescriptionField;
    private javax.swing.JTextField testIdField;
    private javax.swing.JTextField testNameField;
    private javax.swing.JTable testTable;
    private javax.swing.JButton updateTestBtn;
    // End of variables declaration//GEN-END:variables
}
