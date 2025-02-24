package labapp;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

//

import java.awt.Color;
import java.sql.*;
//import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.table.DefaultTableModel;
import labapp.DatabaseConnection;
import java.util.Date; 
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.Image;
import java.io.FileOutputStream;
import javax.swing.BorderFactory;

/**
 *
 * @author masihullahomar
 */
public final class Results extends javax.swing.JFrame {

    /**
     * Creates new form Results
     */
    private Connection connection;
    private Statement stm;
    private ResultSet rs;
    private DefaultTableModel model;

    public Results() {
        initComponents();
        
        setLocationRelativeTo(null); 
//        setShape(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),20,20));
//        this.getContentPane().setBackground(Color.white);
        connection = new DatabaseConnection().connect();
        model = new DefaultTableModel();
        resultTable.setModel(model); // Assuming your table is named 'resultTable'
        populateAllComboBoxes();
        showResults(); // Load results into the table
    }
    
    private void showResults() {
        try {
            // Initialize table columns
            model.setColumnCount(0); // Reset the columns before adding new ones
            model.addColumn("Result ID");
            model.addColumn("Patient ID");
            model.addColumn("Test ID");
            model.addColumn("Laboratorian ID");
            model.addColumn("Test Date");
            model.addColumn("Remarks");

            // Execute query to fetch data
            stm = connection.createStatement();
            rs = stm.executeQuery("SELECT * FROM resultsTbl");

            // Clear previous rows
            model.setRowCount(0); // Reset the rows before populating them

            // Populate the table with data
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("resultId"),
                    rs.getString("patientId"),
                    rs.getString("testId"),
                    rs.getString("laboratorianId"),
                    rs.getDate("testResultDate"),
                    rs.getString("remarks")
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void clearInputFields() {
        resultIdField.setText("");
        patientIdBox.setSelectedIndex(0);
        testIdBox.setSelectedIndex(0);
        laboratorianIdBox.setSelectedIndex(0);
        testResultDateField.setDate(null);
        remarksField.setText("");
    }
    
 private void populateComboBox(javax.swing.JComboBox<String> comboBox, String query, String columnName) {
    try {
        comboBox.removeAllItems(); // Clear existing items

        stm = connection.createStatement();
        rs = stm.executeQuery(query);

        while (rs.next()) {
            comboBox.addItem(rs.getString(columnName)); // Add each item from the specified column
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
    }
}


    
   public void populateAllComboBoxes() {
    populateComboBox(patientIdBox, "SELECT patientId FROM patientTbl", "patientId");
    populateComboBox(testIdBox, "SELECT testId FROM testTbl", "testId");
    populateComboBox(laboratorianIdBox, "SELECT laboratorianId FROM laboratorians", "laboratorianId");
}

    
//    private void populateComboBoxWithPatients() {
//        try {
//            jComboBox1.removeAllItems(); // Clear existing items
//
//            stm = connection.createStatement();
//            rs = stm.executeQuery("SELECT patientId FROM patientTbl");
//
//            while (rs.next()) {
//                jComboBox1.addItem(rs.getString("patientId")); // Add each patient ID
//            }
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
//        }
//    }
//    
//    private void populateComboBoxWithTests() {
//        try {
//            jComboBox2.removeAllItems(); // Clear existing items
//
//            stm = connection.createStatement();
//            rs = stm.executeQuery("SELECT testId FROM testTbl");
//
//            while (rs.next()) {
//                jComboBox2.addItem(rs.getString("testId")); // Add each patient ID
//            }
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
//        }
//    }
//    
//        private void populateComboBoxWithLaboratorians() {
//        try {
//            jComboBox3.removeAllItems(); // Clear existing items
//
//            stm = connection.createStatement();
//            rs = stm.executeQuery("SELECT laboratorianId FROM laboratorians");
//
//            while (rs.next()) {
//                jComboBox3.addItem(rs.getString("laboratorianId")); // Add each patient ID
//            }
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
//        }
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        testResultDateField = new com.toedter.calendar.JDateChooser();
        resultIdField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        remarksField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        printResultBtn = new RoundedButton(20);
        deleteResultBtn = new RoundedButton(20);
        addResultBtn = new RoundedButton(20);
        jScrollPane1 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        patientIdBox = new javax.swing.JComboBox<>();
        testIdBox = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        laboratorianIdBox = new javax.swing.JComboBox<>();
        jPanel1 = new RoundedPanel(0,30,0,30);
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1100, 550));

        resultIdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultIdFieldActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("Result ID");

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 51, 51));
        jLabel9.setText("Test Result Date");

        remarksField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remarksFieldActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setText("Patient ID");

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 51, 51));
        jLabel11.setText("Test ID");

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setText("Remarks");

        printResultBtn.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        printResultBtn.setForeground(new java.awt.Color(255, 51, 51));
        printResultBtn.setText("Print Result");
        printResultBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                printResultBtnMouseClicked(evt);
            }
        });
        printResultBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printResultBtnActionPerformed(evt);
            }
        });

        deleteResultBtn.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        deleteResultBtn.setForeground(new java.awt.Color(255, 51, 51));
        deleteResultBtn.setText("Delete Result");
        deleteResultBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteResultBtnMouseClicked(evt);
            }
        });
        deleteResultBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteResultBtnActionPerformed(evt);
            }
        });

        addResultBtn.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        addResultBtn.setForeground(new java.awt.Color(255, 51, 51));
        addResultBtn.setText("Add Result");
        addResultBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addResultBtnMouseClicked(evt);
            }
        });

        jScrollPane1.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        //jScrollPane1.getViewport().setBackground(Color.WHITE);

        resultTable.setAutoCreateRowSorter(true);
        resultTable.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Result ID", "Patient ID", "Test ID", "Remarks", "Test Result Date"
            }
        ));
        resultTable.setFocusable(false);
        jScrollPane1.setViewportView(resultTable);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labapp/Statics/x-circle.png"))); // NOI18N
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labapp/Statics/minus-circle.png"))); // NOI18N
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labapp/Statics/minimize.png"))); // NOI18N
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 3, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 25, 25));
        jLabel14.setText("Marmara Medical Lab");

        testIdBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testIdBoxActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("Laboratorian ID");

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
                        .addGap(79, 79, 79)))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(493, 493, 493)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jLabel15))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(testIdBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(resultIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(testResultDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addResultBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(deleteResultBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(laboratorianIdBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(patientIdBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(remarksField, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(printResultBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)))
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
                        .addGap(7, 7, 7)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addResultBtn, testIdBox});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel16)
                        .addComponent(jLabel15))
                    .addComponent(jLabel17))
                .addGap(37, 37, 37)
                .addComponent(jLabel14)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(resultIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patientIdBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(testIdBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(laboratorianIdBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(remarksField)
                            .addComponent(testResultDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(addResultBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(printResultBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteResultBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addGap(42, 42, 42))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resultIdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultIdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resultIdFieldActionPerformed

    private void remarksFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remarksFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_remarksFieldActionPerformed

    private void printResultBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printResultBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_printResultBtnActionPerformed

    private void deleteResultBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteResultBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteResultBtnActionPerformed

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
        this.setExtendedState(Tests.ICONIFIED);
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        // TODO add your handling code here:
        if(this.getExtendedState()!=Tests.MAXIMIZED_BOTH){
            this.setExtendedState(Tests.MAXIMIZED_BOTH);
        }else{
            this.setExtendedState(Tests.NORMAL);
        }
    }//GEN-LAST:event_jLabel17MouseClicked

    private void testIdBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testIdBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_testIdBoxActionPerformed

    private void addResultBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addResultBtnMouseClicked
        // TODO add your handling code here:
        try {
        // Get input from the fields
        String resultId = resultIdField.getText();
        String patientId = (String) patientIdBox.getSelectedItem();
        String testId = (String) testIdBox.getSelectedItem();
        String laboratorianId = (String) laboratorianIdBox.getSelectedItem();
        Date testResultDate = testResultDateField.getDate();
        String remarks = remarksField.getText();

        // Validate that all fields are filled
        if (resultId.isEmpty() || patientId == null || testId == null || laboratorianId == null || testResultDate == null || remarks.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return;
        }

        // Validate that the resultId is a valid number
        try {
            Integer.parseInt(resultId);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Result ID must be a valid number.");
            return;
        }

        // Convert date to SQL date
        java.sql.Date sqlDate = new java.sql.Date(testResultDate.getTime());

        // Prepare the SQL query to insert the data
        String query = "INSERT INTO resultsTbl (resultId, patientId, testId, laboratorianId, testResultDate, remarks) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setInt(1, Integer.parseInt(resultId));  // Set the manually provided resultId
        pst.setString(2, patientId);
        pst.setString(3, testId);
        pst.setString(4, laboratorianId);
        pst.setDate(5, sqlDate);
        pst.setString(6, remarks);

        // Execute the query
        pst.executeUpdate();

        // Show success message and refresh the table
        JOptionPane.showMessageDialog(this, "Result added successfully.");
        showResults(); // Refresh the table
        clearInputFields(); // Clear input fields after adding the result
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
    }
    }//GEN-LAST:event_addResultBtnMouseClicked

    private void deleteResultBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteResultBtnMouseClicked
        // TODO add your handling code here:
        try {
        // Get the selected row from the result table
        int selectedRow = resultTable.getSelectedRow();

        // Ensure a row is selected
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a result to delete.");
            return;
        }

        // Get the result ID from the selected row
        String resultId = model.getValueAt(selectedRow, 0).toString();

        // Confirm deletion
        int confirmation = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to delete this result?",
                "Confirm Deletion",
                JOptionPane.YES_NO_OPTION);

        if (confirmation != JOptionPane.YES_OPTION) {
            return; // If user chooses "No," exit the method
        }

        // Prepare and execute the delete query
        String query = "DELETE FROM resultsTbl WHERE resultId = ?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, resultId);
        pst.executeUpdate();

        // Show success message and refresh the table
        JOptionPane.showMessageDialog(this, "Result deleted successfully.");
        showResults(); // Refresh the table
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
    }
    }//GEN-LAST:event_deleteResultBtnMouseClicked

    private void printResultBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printResultBtnMouseClicked
        // TODO add your handling code here:
        try {
        // Get the selected row from the result table
        int selectedRow = resultTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a result to print.");
            return;
        }

        // Retrieve result details from the selected row
        String resultId = model.getValueAt(selectedRow, 0).toString();
        String patientId = model.getValueAt(selectedRow, 1).toString();
        String testId = model.getValueAt(selectedRow, 2).toString();
        String laboratorianId = model.getValueAt(selectedRow, 3).toString();
        String testDate = model.getValueAt(selectedRow, 4).toString();
        String remarks = model.getValueAt(selectedRow, 5).toString();
        
        LineSeparator line = new LineSeparator();
        line.setLineWidth(1f); // Set the thickness of the line
        line.setPercentage(90); // Set the width of the line relative to the page width (80%)
        line.setAlignment(Element.ALIGN_CENTER); // Align the line to the center
        line.setLineColor(BaseColor.RED); // Set the color of the line
        
        Image img = Image.getInstance("src/labapp/Statics/logo_pdf.png");

        // Set image properties (optional)
        img.scaleToFit(200, 200); // Scale the image to fit a certain size
        img.setAlignment(Image.ALIGN_CENTER);
    
        // Fetch patient information
        String patientInfo = "";
        String queryPatient = "SELECT * FROM patientTbl WHERE patientId = ?";
        try (PreparedStatement pst = connection.prepareStatement(queryPatient)) {
            pst.setInt(1, Integer.parseInt(patientId));
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                patientInfo = 
                              "Name: " + rs.getString("patientName") +
                              "\nPhone: " + rs.getString("patientPhone") +
                              "\nAddress: " + rs.getString("patientAddress") +
                              "\nGender: " + rs.getString("gender") +
                              "\nDate of Birth: " + rs.getDate("dateOfBirth");
            } else {
                patientInfo = "No patient information found.";
            }
        }

        // Fetch test information
        String testInfo = "";
        String queryTest = "SELECT * FROM testTbl WHERE testId = ?";
        try (PreparedStatement pst = connection.prepareStatement(queryTest)) {
            pst.setInt(1, Integer.parseInt(testId));
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                testInfo = 
                           "Name: " + rs.getString("testName") +
                           "\nCost: " + rs.getString("testCost") +
                           "\nDescription: " + rs.getString("testDescription");
            } else {
                testInfo = "No test information found.";
            }
        }

        // Fetch laboratorian information
        String laboratorianInfo = "";
        String queryLaboratorian = "SELECT * FROM laboratorians WHERE laboratorianId = ?";
        try (PreparedStatement pst = connection.prepareStatement(queryLaboratorian)) {
            pst.setInt(1, Integer.parseInt(laboratorianId));
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                laboratorianInfo =
                                   "Name: " + rs.getString("laboratorianName") +
                                   "\nContact Info: " + rs.getString("contactInfo") +
                                   "\nSpecialization: " + rs.getString("specialization");
            } else {
                laboratorianInfo = "No laboratorian information found.";
            }
        }

        // Ask user to choose where to save the PDF
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save PDF");
        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection != JFileChooser.APPROVE_OPTION) {
            return; // User canceled the file save dialog
        }

        String filePath = fileChooser.getSelectedFile().getAbsolutePath() + ".pdf";

        // Create a PDF document using iText
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filePath));

        // Open the document for writing
        document.open();

        // Add content to the PDF
        Font titleFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
        Font subTitleFont = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
        Font contentFont = new Font(Font.FontFamily.HELVETICA, 8);
        
        document.add(img);
        document.add(new Paragraph("Test Result Report", titleFont));
        document.add(new Paragraph("Date: " + testDate, contentFont));
//        document.add(new Paragraph(" "));
        document.add(new Chunk(line));
        
        document.add(new Paragraph("Patient Details:", subTitleFont));
        document.add(new Paragraph(patientInfo, contentFont));
        document.add(new Paragraph(" "));
        document.add(new Chunk(line));
        
        document.add(new Paragraph("Laboratorian Details:", subTitleFont));
        document.add(new Paragraph(laboratorianInfo, contentFont));
        document.add(new Paragraph(" "));
        document.add(new Chunk(line));

        document.add(new Paragraph("Test Details:", subTitleFont));
        document.add(new Paragraph(testInfo, contentFont));
        document.add(new Paragraph(" "));
        document.add(new Chunk(line));

        
        document.add(new Paragraph("Result Details:", subTitleFont));
        document.add(new Paragraph("Remarks: " + remarks, contentFont));
        document.add(new Paragraph(" "));
        document.add(new Chunk(line));
        
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        document.add(new Paragraph("Laboratorian's Signature", contentFont));
        document.add(new Paragraph(" "));


        // Close the document
        document.close();

        JOptionPane.showMessageDialog(this, "PDF generated successfully: " + filePath);

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
    }
    }//GEN-LAST:event_printResultBtnMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        new Patients().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        new Results().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        new Tests().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        new Laboratorians().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        new DashBoard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

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
//            java.util.logging.Logger.getLogger(Results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
////        UIManager.put("Component.innerFocusWidth", 2);
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Results().setVisible(true);
//                
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addResultBtn;
    private javax.swing.JButton deleteResultBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> laboratorianIdBox;
    private javax.swing.JComboBox<String> patientIdBox;
    private javax.swing.JButton printResultBtn;
    private javax.swing.JTextField remarksField;
    private javax.swing.JTextField resultIdField;
    private javax.swing.JTable resultTable;
    private javax.swing.JComboBox<String> testIdBox;
    private com.toedter.calendar.JDateChooser testResultDateField;
    // End of variables declaration//GEN-END:variables
}
