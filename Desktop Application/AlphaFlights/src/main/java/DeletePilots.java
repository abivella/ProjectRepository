
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
public class DeletePilots extends javax.swing.JFrame {

    /**
     * Creates new form DeletePilots
     */
    public DeletePilots() {
        initComponents();
        
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        CrudOperations.FillCmbs("SELECT IDCardNumber FROM Pilot_tbl", cmbPilots);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblId = new javax.swing.JLabel();
        cmbPilots = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblId.setText("ID Card Number");

        jButton1.setText("DELETE");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblId)
                        .addGap(18, 18, 18)
                        .addComponent(cmbPilots, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jButton1)))
                .addContainerGap(190, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(cmbPilots, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addComponent(jButton1)
                .addContainerGap(128, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Object[] options = {"Delete", "Cancel"};
        Object[] options2 = {"Ok"};
        boolean found = CrudOperations.CheckRow("SELECT PilotId FROM flightpilot_tbl WHERE PilotId = (SELECT PilotId FROM Pilot_tbl WHERE IDCardNumber = '" + cmbPilots.getSelectedItem()+ "')", "DELETE FROM Pilot_tbl WHERE IDCardNumber= '" + cmbPilots.getSelectedItem() + "'");
        
        if (found == true){
            JOptionPane.showOptionDialog(null, "Pilot cannot be deleted! Please delete all flights assigned to pilot!", "Please confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,options2,options2[0]);
        }
        else if(found == false){
            int option = JOptionPane.showOptionDialog(null, "Are you sure you want to delete the record?", "Please confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            if(option == JOptionPane.YES_OPTION){
                CrudOperations.CheckRow("SELECT PilotId FROM flightpilot_tbl WHERE PilotId = (SELECT PilotId FROM Pilot_tbl WHERE IDCardNumber = '" + cmbPilots.getSelectedItem()+ "')", "DELETE FROM Pilot_tbl WHERE IDCardNumber= '" + cmbPilots.getSelectedItem() + "'");
                
                JOptionPane.showMessageDialog(null, "Pilot Deleted Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                new Home().setVisible(true);
            }
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
            java.util.logging.Logger.getLogger(DeletePilots.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeletePilots.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeletePilots.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeletePilots.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeletePilots().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbPilots;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblId;
    // End of variables declaration//GEN-END:variables
}
