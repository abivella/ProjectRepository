
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
public class EditAircrafts extends javax.swing.JFrame {

    /**
     * Creates new form EditAircrafts
     */
    public EditAircrafts() {
        initComponents();
        
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        CrudOperations.FillCmbs("SELECT AircraftName FROM Aircraft_tbl", cmbAircrafts);
        FillDetails();
    }
    
    public void FillDetails(){
        CrudOperations.ViewDetailsTxt("SELECT AircraftName FROM Aircraft_tbl WHERE AircraftName = '" + cmbAircrafts.getSelectedItem() + "'", txtAircraftName);
        CrudOperations.ViewDetailsTxt("SELECT AircraftCode FROM Aircraft_tbl WHERE AircraftName = '" + cmbAircrafts.getSelectedItem() + "'", txtAircraftCode);
        CrudOperations.ViewDetailsTxt("SELECT NoOfAvSeats FROM Aircraft_tbl WHERE AircraftName = '" + cmbAircrafts.getSelectedItem() + "'", txtNoOfAvSeats);    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAircraftName01 = new javax.swing.JLabel();
        lblAircraftName02 = new javax.swing.JLabel();
        lblAircraftCode = new javax.swing.JLabel();
        lblNoOfAvSeats = new javax.swing.JLabel();
        txtNoOfAvSeats = new javax.swing.JTextField();
        cmbAircrafts = new javax.swing.JComboBox<>();
        txtAircraftCode = new javax.swing.JTextField();
        txtAircraftName = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblAircraftName01.setText("Aircraft Name");

        lblAircraftName02.setText("Aircraft Name");

        lblAircraftCode.setText("Aircraft Code");

        lblNoOfAvSeats.setText("Number Of Available Seats");

        cmbAircrafts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAircraftsActionPerformed(evt);
            }
        });

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNoOfAvSeats)
                    .addComponent(lblAircraftName01)
                    .addComponent(lblAircraftName02)
                    .addComponent(lblAircraftCode))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAircraftCode, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbAircrafts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNoOfAvSeats, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAircraftName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(144, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblAircraftName01)
                    .addComponent(cmbAircrafts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAircraftName02)
                    .addComponent(txtAircraftName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAircraftCode)
                    .addComponent(txtAircraftCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNoOfAvSeats)
                    .addComponent(txtNoOfAvSeats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbAircraftsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAircraftsActionPerformed
        // TODO add your handling code here:
        FillDetails();
    }//GEN-LAST:event_cmbAircraftsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        CrudOperations.Validation(txtAircraftCode, "DigitStringY");
        boolean Ccontains = CrudOperations.Validation(txtAircraftCode, "DigitStringY");
        
        CrudOperations.Validation(txtAircraftName, "NoDigit");
        boolean Ncontains = CrudOperations.Validation(txtAircraftName, "NoDigit");
        
        CrudOperations.Validation(txtNoOfAvSeats, "NoString");
        boolean Scontains = CrudOperations.Validation(txtNoOfAvSeats, "NoString");
        
        if(Ccontains == false && Ncontains == false && Scontains == false){
            CrudOperations.EditDetails("UPDATE Aircraft_tbl SET AircraftName = '" + txtAircraftName.getText() +
                    "', AircraftCode = '" + txtAircraftCode.getText() +
                    "', NoOfAvSeats = '" + txtNoOfAvSeats.getText() +
                    "' WHERE AircraftName = '" + cmbAircrafts.getSelectedItem() + "'");

            JOptionPane.showMessageDialog(null, "Aircraft Details Updated Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            new Home().setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(EditAircrafts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditAircrafts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditAircrafts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditAircrafts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditAircrafts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbAircrafts;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblAircraftCode;
    private javax.swing.JLabel lblAircraftName01;
    private javax.swing.JLabel lblAircraftName02;
    private javax.swing.JLabel lblNoOfAvSeats;
    private javax.swing.JTextField txtAircraftCode;
    private javax.swing.JTextField txtAircraftName;
    private javax.swing.JTextField txtNoOfAvSeats;
    // End of variables declaration//GEN-END:variables
}
