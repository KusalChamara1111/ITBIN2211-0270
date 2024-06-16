package View;


import Model.DBConnection;
import com.sun.org.apache.bcel.internal.generic.Select;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kusal
 */
public class Teacher extends javax.swing.JFrame {
     Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    


    /**
     * Creates new form Teacher
     */
    public Teacher() {
        initComponents();
        conn = DBConnection.getConnection();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        tableload();
    }
    
     public void tableload(){
        
        try{
           String sql = "SELECT TeacherID,TeacherName,NICNo,Gender,DateOfBirth,Subject,Phone,Address FROM teachers"; 
           
           pst = conn.prepareStatement(sql);
           rs = pst.executeQuery();
           table2.setModel(DbUtils.resultSetToTableModel (rs));
        
        
        }catch(Exception e){
        JOptionPane.showMessageDialog(rootPane, e);
        }
        }
        
        public void tabledata(){
        int r = table2.getSelectedRow();
        
        String TeacherID = table2.getValueAt(r, 0).toString();
        String TeacherName = (String) table2.getValueAt(r, 1);
        String NICNo = (String) table2.getValueAt(r, 2);
        String Gender =   (String) table2.getValueAt(r, 3);
        String DateOfBirth = (String) table2.getValueAt(r, 4);
        String Subject = (String) table2.getValueAt(r, 5);
        String Phone = (String) table2.getValueAt(r, 6);
        String Address = (String) table2.getValueAt(r, 7);
        
        tid.setText(TeacherID);
        tname.setText(TeacherName);
        tnic.setText(NICNo);
        
        if (Gender.equals("Male")) {
            
            mbutton.setSelected(true);
 
 } else if (Gender.equals("Female")) {
     
     fbutton.setSelected(true);
 
 }
        sbox.setSelectedItem(Subject);
        tphn.setText(Phone);
  
        tdob.setText(DateOfBirth);
        taddress.setText(Address);
       }
        
      public void search(){
        String srch = searchbox1.getText();
        
        try
        {
          String  sql = "SELECT * FROM teachers where TeacherID  = '"+srch+"' OR TeacherName LIKE '%"+srch+"%'" ; 
          pst = conn.prepareStatement(sql);
          rs = pst.executeQuery();
          table2.setModel(DbUtils.resultSetToTableModel(rs));
        
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        
        }
    
    }   
        
        
    
    public void update(){
        
        
        int TeacherID = Integer.parseInt(tid.getText()); 
        String TeacherName = tname.getText(); 
        String NICNo = tnic.getText();
         
        String gender = null;
 if (mbutton.isSelected()) {
 gender = "Male";
 } else if (fbutton.isSelected()) {
 gender = "Female";
 }
        String DateOfBirth = tdob.getText();
        String Phone= tphn.getText();
        String Subject = (String) sbox.getSelectedItem();
        String Address = taddress.getText();
       
        
        
           
        
        try
        {
            String sql= "UPDATE teachers SET TeacherID='"+TeacherID+"', TeacherName= '"+TeacherName+"',NICNo = '"+NICNo+"',Gender= '"+gender+"',DateOfBirth='"+DateOfBirth+"',Subject='"+Subject+"',Phone='"+Phone+"',Address = '"+Address+"' WHERE TeacherID = '"+TeacherID+"'";
            pst = conn.prepareStatement(sql);
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Data Successfully Updated!");
            
            
        
        }catch(Exception e){
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
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        HomeButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();
        LogoutButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tid = new javax.swing.JTextField();
        tname = new javax.swing.JTextField();
        tnic = new javax.swing.JTextField();
        tdob = new javax.swing.JTextField();
        tphn = new javax.swing.JTextField();
        taddress = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        mbutton = new javax.swing.JRadioButton();
        fbutton = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        sbox = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        UpdateButton = new javax.swing.JButton();
        AddButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        searchbox1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(3, 137, 28));
        jPanel3.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(740, 230));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcome,");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Admin");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("____________________________");

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kusal\\Pictures\\New folder\\icons8-user-100.png")); // NOI18N

        HomeButton.setBackground(new java.awt.Color(51, 204, 0));
        HomeButton.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        HomeButton.setForeground(new java.awt.Color(255, 255, 255));
        HomeButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kusal\\Pictures\\New folder\\icons8-home-24.png")); // NOI18N
        HomeButton.setText("Home");
        HomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeButtonActionPerformed(evt);
            }
        });

        BackButton.setBackground(new java.awt.Color(51, 204, 0));
        BackButton.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        BackButton.setForeground(new java.awt.Color(255, 255, 255));
        BackButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kusal\\Pictures\\New folder\\icons8-back-30.png")); // NOI18N
        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        LogoutButton.setBackground(new java.awt.Color(51, 204, 0));
        LogoutButton.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        LogoutButton.setForeground(new java.awt.Color(255, 255, 255));
        LogoutButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kusal\\Pictures\\New folder\\icons8-logout-32.png")); // NOI18N
        LogoutButton.setText("Logout");
        LogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(HomeButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BackButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LogoutButton))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel4)
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(HomeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 318, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BackButton)
                    .addComponent(LogoutButton))
                .addGap(59, 59, 59))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 240, 740));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("Teacher ID");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 107, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setText("Teacher Name");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 155, -1, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setText("NIC No.");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 214, 50, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setText("Date Of Birth");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel9.setText("Phone");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 421, -1, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel10.setText("Address");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 473, -1, -1));

        tid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tidActionPerformed(evt);
            }
        });
        jPanel4.add(tid, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 104, 150, -1));

        tname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnameActionPerformed(evt);
            }
        });
        jPanel4.add(tname, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 152, 154, -1));
        jPanel4.add(tnic, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 211, 154, -1));
        jPanel4.add(tdob, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 317, 84, -1));
        jPanel4.add(tphn, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 418, 121, -1));

        taddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taddressActionPerformed(evt);
            }
        });
        jPanel4.add(taddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 470, 154, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel11.setText("Gender");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 276, -1, -1));

        buttonGroup1.add(mbutton);
        mbutton.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        mbutton.setText("Male");
        mbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbuttonActionPerformed(evt);
            }
        });
        jPanel4.add(mbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 273, -1, -1));

        buttonGroup1.add(fbutton);
        fbutton.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        fbutton.setText("Female");
        jPanel4.add(fbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 273, -1, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel12.setText("Subject");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 371, -1, -1));

        sbox.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        sbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "English", "Mathematics", "Science", "IT" }));
        jPanel4.add(sbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 369, -1, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setText("Techers Details");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 32, -1, -1));

        UpdateButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        UpdateButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kusal\\Pictures\\New folder\\icons8-update-30.png")); // NOI18N
        UpdateButton.setText("UPDATE");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });
        jPanel4.add(UpdateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 528, -1, -1));

        AddButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        AddButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kusal\\Pictures\\New folder\\icons8-add-30.png")); // NOI18N
        AddButton.setText("ADD");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });
        jPanel4.add(AddButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 528, 117, -1));

        ClearButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ClearButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kusal\\Pictures\\New folder\\icons8-clear-30.png")); // NOI18N
        ClearButton.setText("CLEAR");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });
        jPanel4.add(ClearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 585, 119, -1));

        DeleteButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        DeleteButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kusal\\Pictures\\New folder\\icons8-delete-30.png")); // NOI18N
        DeleteButton.setText("DELETE");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });
        jPanel4.add(DeleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 585, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 430, 740));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(0, 102, 0));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchbox1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(searchbox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 260, 50));

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "TeacherID", "TeacherName", "NICNo", "Gender", "DateOfbirth", "Subject", "Phone", "Address"
            }
        ));
        table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table2);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 710, 670));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 720, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbuttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mbuttonActionPerformed

    private void tidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tidActionPerformed

    private void tnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnameActionPerformed

    private void taddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_taddressActionPerformed

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
        // TODO add your handling code here:
        tid.setText("");
        tname.setText("");
        tdob.setText("");
        sbox.setSelectedItem("Select");
        
        tphn.setText("");
        taddress.setText("");
        
        mbutton.setSelected(false);
        fbutton.setSelected(false);
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        // TODO add your handling code here:
        update(); tableload();
        
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        // TODO add your handling code here:
        int check= JOptionPane.showConfirmDialog(null, "Are You sure to DELETE this data?");
        if (check==0){
            //String TeacherID = Integer.parseInt(idbox.getSelectedRow);
            String TeacherID = tid.getText();
            String sql = "delete from teachers where TeacherID ='"+TeacherID+"'";

            try{

                pst = conn.prepareStatement(sql);
                pst.execute();

                JOptionPane.showMessageDialog(null, "Data Successfully DELETED!");

                tableload();
                tid.setText("");
        tname.setText("");
        tdob.setText("");
        sbox.setSelectedItem("Select");
        
        tphn.setText("");
        taddress.setText("");
        
        mbutton.setSelected(false);
        fbutton.setSelected(false);

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Data Can't DELETE!");

            }

        }
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        // TODO add your handling code here:
        
        setVisible (false);
        Addteacher object = new Addteacher();
        object.setVisible(true);
    }//GEN-LAST:event_AddButtonActionPerformed

    private void table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table2MouseClicked
        tabledata();
    }//GEN-LAST:event_table2MouseClicked

    private void HomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeButtonActionPerformed
        // TODO add your handling code here:
        
         setVisible (false);
        Home object = new Home();
        object.setVisible(true);
    }//GEN-LAST:event_HomeButtonActionPerformed

    private void LogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutButtonActionPerformed
        // TODO add your handling code here:
         setVisible (false);
        Login object = new Login();
        object.setVisible(true);
    }//GEN-LAST:event_LogoutButtonActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        // TODO add your handling code here:
        
         setVisible (false);
        Addstu object = new Addstu();
        object.setVisible(true);
    }//GEN-LAST:event_BackButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Teacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Teacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Teacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Teacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Teacher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton BackButton;
    private javax.swing.JButton ClearButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton HomeButton;
    private javax.swing.JButton LogoutButton;
    private javax.swing.JButton UpdateButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JRadioButton fbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton mbutton;
    private javax.swing.JComboBox<String> sbox;
    private javax.swing.JTextField searchbox1;
    private javax.swing.JTable table2;
    private javax.swing.JTextField taddress;
    private javax.swing.JTextField tdob;
    private javax.swing.JTextField tid;
    private javax.swing.JTextField tname;
    private javax.swing.JTextField tnic;
    private javax.swing.JTextField tphn;
    // End of variables declaration//GEN-END:variables
}