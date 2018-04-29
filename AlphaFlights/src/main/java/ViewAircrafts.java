/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abigail
 */
public class ViewAircrafts extends javax.swing.JFrame {

    /**
     * Creates new form ViewAircrafts
     */
    public ViewAircrafts() {
        initComponents();
        
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        CrudOperations.FillCmbs("SELECT AircraftName FROM Aircraft_tbl", cmbAircrafts);
        FillDetails();
    }
    
    public void FillDetails(){
        CrudOperations.ViewDetailsLbl("SELECT AircraftCode FROM Aircraft_tbl WHERE AircraftName = '" + cmbAircrafts.getSelectedItem() + "'", lblSetAircraftCode);
        CrudOperations.ViewDetailsLbl("SELECT NoOfAvSeats FROM Aircraft_tbl WHERE AircraftName = '" + cmbAircrafts.getSelectedItem() + "'", lblSetNoOfAvSeats);
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAircraftName = new javax.swing.JLabel();
        cmbAircrafts = new javax.swing.JComboBox<>();
        lblAircraftCode = new javax.swing.JLabel();
        lblSetAircraftCode = new javax.swing.JLabel();
        lblNoOfAvSeats = new javax.swing.JLabel();
        lblSetNoOfAvSeats = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblAircraftName.setText("Aircraft Name");

        cmbAircrafts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAircraftsActionPerformed(evt);
            }
        });

        lblAircraftCode.setText("Aircraft Code");

        lblNoOfAvSeats.setText("Number Of Available Seats");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNoOfAvSeats)
                        .addGap(18, 18, 18)
                        .addComponent(lblSetNoOfAvSeats))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAircraftName)
                            .addComponent(lblAircraftCode))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSetAircraftCode)
                            .addComponent(cmbAircrafts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(244, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAircraftName)
                    .addComponent(cmbAircrafts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAircraftCode)
                    .addComponent(lblSetAircraftCode))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNoOfAvSeats)
                    .addComponent(lblSetNoOfAvSeats))
                .addContainerGap(175, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbAircraftsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAircraftsActionPerformed
        // TODO add your handling code here:
        FillDetails();
    }//GEN-LAST:event_cmbAircraftsActionPerformed

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
            java.util.logging.Logger.getLogger(ViewAircrafts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAircrafts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAircrafts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAircrafts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAircrafts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbAircrafts;
    private javax.swing.JLabel lblAircraftCode;
    private javax.swing.JLabel lblAircraftName;
    private javax.swing.JLabel lblNoOfAvSeats;
    private javax.swing.JLabel lblSetAircraftCode;
    private javax.swing.JLabel lblSetNoOfAvSeats;
    // End of variables declaration//GEN-END:variables
}