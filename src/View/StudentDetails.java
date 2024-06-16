package View;


import Model.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class StudentDetails extends javax.swing.JFrame {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public StudentDetails() {
        initComponents();
        conn = DBConnection.getConnection();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        tableload();
    }

    public void tableload() {
        try {
            String sql = "SELECT StudentID, StudentName, DateOfBirth, Gender, Phone, Address FROM students";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }

    public void tabledata() {
        int r = table1.getSelectedRow();
        String StudentID = table1.getValueAt(r, 0).toString();
        String StudentName = (String) table1.getValueAt(r, 1);
        String DateOfBirth = (String) table1.getValueAt(r, 2);
        String Gender = (String) table1.getValueAt(r, 3);
        String Phone = (String) table1.getValueAt(r, 4);
        String Address = (String) table1.getValueAt(r, 5);

        idbox.setText(StudentID);
        name1.setText(StudentName);
        dob1.setText(DateOfBirth);
        if (Gender.equals("Male")) {
            smbtn1.setSelected(true);
        } else if (Gender.equals("Female")) {
            sfbtn1.setSelected(true);
        }
        phn1.setText(Phone);
        addressf1.setText(Address);
    }

    public void search() {
        String srch = searchbox.getText();
        try {
            String sql = "SELECT * FROM students where StudentID = '" + srch + "' OR StudentName LIKE '%" + srch + "%'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void update() {
        int StudentID = Integer.parseInt(idbox.getText());
        String StudentName = name1.getText();
        String DateOfBirth = dob1.getText();
        String gender = null;
        if (smbtn1.isSelected()) {
            gender = "Male";
        } else if (sfbtn1.isSelected()) {
            gender = "Female";
        }
        String Phone = phn1.getText();
        String Address = addressf1.getText();

        try {
            String sql = "UPDATE students SET StudentName = '" + StudentName + "', DateOfBirth = '" + DateOfBirth + "', Gender = '" + gender + "', Phone = '" + Phone + "', Address = '" + Address + "' WHERE StudentID = '" + StudentID + "'";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Successfully Updated!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Can't Update!");
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        name1 = new javax.swing.JTextField();
        dob1 = new javax.swing.JTextField();
        phn1 = new javax.swing.JTextField();
        addressf1 = new javax.swing.JTextField();
        updatebtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        insertbtn = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        idbox = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        smbtn1 = new javax.swing.JRadioButton();
        sfbtn1 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        searchbox = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(9, 113, 37));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Welcome,");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("__________________________");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 190, 170, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kusal\\Pictures\\New folder\\icons8-user-100.png")); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Admin");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));

        jLabel1.setBackground(new java.awt.Color(19, 110, 2));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 232, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setText("Student Name");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setText("Date of Birth");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setText("Gender");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel9.setText("Phone");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel10.setText("Address");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        name1.setToolTipText("Enter Your Name");
        name1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name1ActionPerformed(evt);
            }
        });
        jPanel2.add(name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 285, -1));

        dob1.setToolTipText("Enter Your Date Of Birth");
        jPanel2.add(dob1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 93, -1));

        phn1.setToolTipText("Enter Phone");
        jPanel2.add(phn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 128, -1));

        addressf1.setToolTipText("Enter Your address");
        jPanel2.add(addressf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 285, -1));

        updatebtn.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        updatebtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kusal\\Pictures\\New folder\\icons8-update-30.png")); // NOI18N
        updatebtn.setText("UPDATE");
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });
        jPanel2.add(updatebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, -1, -1));

        clearBtn.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        clearBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kusal\\Pictures\\New folder\\icons8-clear-30.png")); // NOI18N
        clearBtn.setText("CLEAR");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });
        jPanel2.add(clearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 480, 110, -1));

        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kusal\\Pictures\\New folder\\icons8-delete-30.png")); // NOI18N
        jButton5.setText("DELETE");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 480, -1, -1));

        insertbtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        insertbtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kusal\\Pictures\\New folder\\icons8-insert-30.png")); // NOI18N
        insertbtn.setText("Insert");
        insertbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertbtnActionPerformed(evt);
            }
        });
        jPanel2.add(insertbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 400, -1, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel11.setText("Student ID");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));
        jPanel2.add(idbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 110, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setText("Student Details");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        buttonGroup1.add(smbtn1);
        smbtn1.setText("Male");
        smbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smbtn1ActionPerformed(evt);
            }
        });
        jPanel2.add(smbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, -1, -1));

        buttonGroup1.add(sfbtn1);
        sfbtn1.setText("Female");
        jPanel2.add(sfbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 430, 740));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "StudentID", "StudentName", "DateOfBirth", "Gender", "Phone", "Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        table1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                table1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                table1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                table1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, 750, 640));

        jPanel3.setBackground(new java.awt.Color(0, 153, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 51, 51))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchboxActionPerformed(evt);
            }
        });
        searchbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchboxKeyReleased(evt);
            }
        });
        jPanel3.add(searchbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 260, 20));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 280, 60));

        jPanel6.setBackground(new java.awt.Color(3, 137, 28));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setBackground(new java.awt.Color(51, 204, 0));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kusal\\Pictures\\New folder\\icons8-back-30.png")); // NOI18N
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 650, -1, 40));

        jButton2.setBackground(new java.awt.Color(51, 204, 0));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kusal\\Pictures\\New folder\\icons8-home-24.png")); // NOI18N
        jButton2.setText("Home");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, -1));

        jButton8.setBackground(new java.awt.Color(51, 204, 0));
        jButton8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kusal\\Pictures\\New folder\\icons8-logout-32.png")); // NOI18N
        jButton8.setText("Logout");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 650, -1, -1));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 740));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1520, 740));

        setSize(new java.awt.Dimension(1386, 779));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchboxActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        
        setVisible (false);
        Login object = new Login();
        object.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        // TODO add your handling code here:
        
        tabledata();
    }//GEN-LAST:event_table1MouseClicked

    private void table1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table1KeyReleased
        // TODO add your handling code here:
        
        tabledata();
    }//GEN-LAST:event_table1KeyReleased

    private void searchboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchboxKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_searchboxKeyReleased

    private void table1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table1KeyPressed
        // TODO add your handling code here:
        tabledata();
        
        
    }//GEN-LAST:event_table1KeyPressed

    private void table1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table1KeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_table1KeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        setVisible (false);
        Home object = new Home();
        object.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        setVisible (false);
        Addstu object = new Addstu();
        object.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void insertbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertbtnActionPerformed
        // TODO add your handling code here:

        /*String StudentID = idbox.getText();
        String StudentName = name1.getText();
        String DateOfBirth = dob1.getText();
        String Gender =   (String) gender1.getSelectedItem();
        String Phone = phn1.getText();
        String Address = addressf1.getText();

        try {
            Connection con = DBconnector.getCone();
            Statement st = con.createStatement();

            st.executeUpdate("INSERT INTO students (StudentName,DateOfBirth,Gender,Phone,Address) VALUES('" + StudentName + "','" + DateOfBirth + "','" + Gender + "','" + Phone + "','" + Address + "')");

            JOptionPane.showMessageDialog(null, "Data Successfully Inserted");*/
            setVisible(false);
            new Addstu().setVisible(true);

            /*} catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " );
            setVisible(false);
            new StudentDetails().setVisible(true);
        }*/
    }//GEN-LAST:event_insertbtnActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int check= JOptionPane.showConfirmDialog(null, "Are You sure to DELETE this data?");
        if (check==0){
            //String StudentID = Integer.parseInt(idbox.getSelectedRow);
            String StudentID = idbox.getText();
            String sql = "delete from students where StudentID ='"+StudentID+"'";

            try{

                pst = conn.prepareStatement(sql);
                pst.execute();

                JOptionPane.showMessageDialog(null, "Data Successfully DELETED!");

                tableload();

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Data Can't DELETE!");

            }

        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        // TODO add your handling code here:
        idbox.setText("");
        name1.setText("");
        dob1.setText("");
        sfbtn1.setSelected(true);
        smbtn1.setSelected(true);
        phn1.setText("");
        addressf1.setText("");
    }//GEN-LAST:event_clearBtnActionPerformed

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
        // TODO add your handling code here:
        update(); tableload();
    }//GEN-LAST:event_updatebtnActionPerformed

    private void name1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name1ActionPerformed

    private void smbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smbtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_smbtn1ActionPerformed

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
            java.util.logging.Logger.getLogger(StudentDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressf1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton clearBtn;
    private javax.swing.JTextField dob1;
    private javax.swing.JTextField idbox;
    private javax.swing.JButton insertbtn;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton8;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name1;
    private javax.swing.JTextField phn1;
    private javax.swing.JTextField searchbox;
    private javax.swing.JRadioButton sfbtn1;
    private javax.swing.JRadioButton smbtn1;
    private javax.swing.JTable table1;
    private javax.swing.JButton updatebtn;
    // End of variables declaration//GEN-END:variables
}