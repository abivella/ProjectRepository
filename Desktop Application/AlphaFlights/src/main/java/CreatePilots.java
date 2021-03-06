
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abigail
 */
public class CreatePilots extends javax.swing.JFrame {
    
    public int year = GregorianCalendar.getInstance().get(GregorianCalendar.YEAR) - 18;
    public int yearMargin  = GregorianCalendar.getInstance().get(GregorianCalendar.YEAR) - 70;

    public static GregorianCalendar cl;
    public static String fdt;

    /**
     * Creates new form CreatePilots
     */
    public CreatePilots() {
        initComponents();
        
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        for(int i = year; i > yearMargin; i--){
            System.out.println(i);
            cmbYears.addItem(Integer.toString(i));
        }
    }
    
    public void updateDay(){
        cmbDays.removeAllItems();

        int userYear = Integer.parseInt((String)cmbYears.getSelectedItem());
        YearMonth selectedMonth = YearMonth.of(userYear, cmbMonths.getSelectedIndex() + 1);
        for(int i = 0; i < selectedMonth.lengthOfMonth(); i++){
            cmbDays.addItem(Integer.toString(i + 1));
        }
    }
    
    public void CreatePilot(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        
        int yr = (int) Integer.parseInt(cmbYears.getSelectedItem().toString());
        int month = cmbMonths.getSelectedIndex();
        int day = (int) Integer.parseInt(cmbDays.getSelectedItem().toString());
        
        cl = new GregorianCalendar(yr, month, day);
        fdt = df.format(cl.getTime());
        
        CrudOperations.CreateRecord("INSERT INTO pilot_tbl (PilotId, IDCardNumber, PilotName, PilotSurname, Dob, ContactNo1, ContactNo2)"
                + "VALUES (NULL," + "'" + txtIdNumber.getText() + "'" + "," + "'" + txtFirstName.getText() + "'" + "," + "'" + txtLastName.getText() + "'" + "," + "'" 
                + fdt + "'" + "," + "'" + txtContactNumber1.getText() + "'" + "," + "'" + txtContactNumber2.getText() + "')");
        
        JOptionPane.showMessageDialog(null, "Pilot Created Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
        new Home().setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        lblFirstName = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        lblLastName = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        lblDob = new javax.swing.JLabel();
        lblMonths = new javax.swing.JLabel();
        lblDays = new javax.swing.JLabel();
        lblYears = new javax.swing.JLabel();
        cmbMonths = new javax.swing.JComboBox<>();
        cmbDays = new javax.swing.JComboBox<>();
        cmbYears = new javax.swing.JComboBox<>();
        lblContactNumber1 = new javax.swing.JLabel();
        lblContactNumber2 = new javax.swing.JLabel();
        txtContactNumber2 = new javax.swing.JTextField();
        txtContactNumber1 = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtIdNumber = new javax.swing.JTextField();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblFirstName.setText("First Name");

        txtLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLastNameActionPerformed(evt);
            }
        });

        lblLastName.setText("Last Name");

        txtFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstNameActionPerformed(evt);
            }
        });

        lblDob.setText("Date Of Birth:");

        lblMonths.setText("Month");

        lblDays.setText("Day");

        lblYears.setText("Year");

        cmbMonths.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        cmbMonths.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMonthsActionPerformed(evt);
            }
        });

        cmbDays.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDaysActionPerformed(evt);
            }
        });

        cmbYears.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbYearsActionPerformed(evt);
            }
        });

        lblContactNumber1.setText("Contact Number (1)");

        lblContactNumber2.setText("Contact Number (2)");

        txtContactNumber2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContactNumber2ActionPerformed(evt);
            }
        });

        txtContactNumber1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContactNumber1ActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel1.setText("ID Card Number");

        txtIdNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdNumberActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDob)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbMonths, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDays))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblYears)
                            .addComponent(cmbYears, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSave)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblLastName)
                                .addComponent(lblFirstName)
                                .addComponent(lblMonths))
                            .addGap(28, 28, 28)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(48, 48, 48)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblContactNumber2)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtContactNumber2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblContactNumber1)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtContactNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtIdNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFirstName)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblContactNumber1)
                    .addComponent(txtContactNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLastName)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblContactNumber2)
                    .addComponent(txtContactNumber2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDob)
                    .addComponent(jLabel1)
                    .addComponent(txtIdNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMonths)
                    .addComponent(lblDays)
                    .addComponent(lblYears))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMonths, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbYears, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLastNameActionPerformed

    private void txtFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstNameActionPerformed

    private void txtContactNumber2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContactNumber2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContactNumber2ActionPerformed

    private void txtContactNumber1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContactNumber1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContactNumber1ActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        CrudOperations.Validation(txtFirstName, "NoDigit");
        boolean NameContains = CrudOperations.Validation(txtFirstName, "NoDigit");
        
        CrudOperations.Validation(txtLastName, "NoDigit");
        boolean SurnameContains = CrudOperations.Validation(txtLastName, "NoDigit");
        
        CrudOperations.Validation(txtContactNumber1, "NoString");
        boolean ContNo1Contains = CrudOperations.Validation(txtContactNumber1, "NoString");
        
        CrudOperations.Validation(txtContactNumber2, "NoStringEmptyY");
        boolean ContNo2Contains = CrudOperations.Validation(txtContactNumber2, "NoStringEmptyY");
        
        boolean found = CrudOperations.CheckRow2("SELECT COUNT(*) FROM pilot_tbl WHERE IDCardNumber='" + txtIdNumber.getText() + "'");
        
        if(found == true){
            JOptionPane.showMessageDialog(null, "Pilot Already Exist!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(found == false){
            if(NameContains == false && SurnameContains == false && ContNo1Contains == false && ContNo2Contains == false){
                CreatePilot();
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void cmbDaysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDaysActionPerformed
        // TODO add your handling code here:    
    }//GEN-LAST:event_cmbDaysActionPerformed

    private void cmbYearsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbYearsActionPerformed
        // TODO add your handling code here:
        updateDay();
    }//GEN-LAST:event_cmbYearsActionPerformed

    private void cmbMonthsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMonthsActionPerformed
        // TODO add your handling code here:
        updateDay();
    }//GEN-LAST:event_cmbMonthsActionPerformed

    private void txtIdNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdNumberActionPerformed

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
            java.util.logging.Logger.getLogger(CreatePilots.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreatePilots.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreatePilots.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreatePilots.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreatePilots().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbDays;
    private javax.swing.JComboBox<String> cmbMonths;
    private javax.swing.JComboBox<String> cmbYears;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblContactNumber1;
    private javax.swing.JLabel lblContactNumber2;
    private javax.swing.JLabel lblDays;
    private javax.swing.JLabel lblDob;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblMonths;
    private javax.swing.JLabel lblYears;
    private javax.swing.JTextField txtContactNumber1;
    private javax.swing.JTextField txtContactNumber2;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtIdNumber;
    private javax.swing.JTextField txtLastName;
    // End of variables declaration//GEN-END:variables
}
