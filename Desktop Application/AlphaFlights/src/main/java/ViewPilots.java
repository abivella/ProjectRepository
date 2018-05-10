
import java.util.GregorianCalendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abigail
 */
public class ViewPilots extends javax.swing.JFrame {

    public static GregorianCalendar cl;
    public static String fdt;
    

    /**
     * Creates new form ViewPilots
     */
    public ViewPilots() {
        initComponents();
        
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        CrudOperations.FillCmbs("SELECT IDCardNumber FROM pilot_tbl", cmbPilots);
        ViewPilots();
    }
    
    public void ViewPilots(){
        CrudOperations.ViewDetailsLbl("SELECT PilotName FROM pilot_tbl WHERE IDCardNumber = '" + cmbPilots.getSelectedItem() + "'", lblSetName);
        CrudOperations.ViewDetailsLbl("SELECT PilotSurname FROM pilot_tbl WHERE IDCardNumber = '" + cmbPilots.getSelectedItem() + "'", lblSetSurname);
        CrudOperations.ViewDetailsLbl("SELECT Dob FROM pilot_tbl WHERE IDCardNumber = '" + cmbPilots.getSelectedItem() + "'", lblSetDob);
        CrudOperations.ViewDetailsLbl("SELECT ContactNo1 FROM pilot_tbl WHERE IDCardNumber = '" + cmbPilots.getSelectedItem() + "'", lblSetContactNumber1);
        CrudOperations.ViewDetailsLbl("SELECT ContactNo2 FROM pilot_tbl WHERE IDCardNumber = '" + cmbPilots.getSelectedItem() + "'", lblSetContactNumber2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFirstName = new javax.swing.JLabel();
        lblSetName = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        lblContactNumber1 = new javax.swing.JLabel();
        lblContactNumber2 = new javax.swing.JLabel();
        lblSetSurname = new javax.swing.JLabel();
        lblSetContactNumber1 = new javax.swing.JLabel();
        lblSetContactNumber2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblIDCardNumber = new javax.swing.JLabel();
        cmbPilots = new javax.swing.JComboBox<>();
        lblSetDob = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblFirstName.setText("First Name");

        lblLastName.setText("Last Name");

        lblContactNumber1.setText("Contact Number (1)");

        lblContactNumber2.setText("Contact Number (2)");

        jLabel1.setText("Dae Of Birth (yyyy-mm-dd):");

        lblIDCardNumber.setText("Pilot ID Card number");

        cmbPilots.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPilotsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFirstName)
                    .addComponent(lblContactNumber1)
                    .addComponent(lblContactNumber2)
                    .addComponent(lblLastName)
                    .addComponent(jLabel1)
                    .addComponent(lblIDCardNumber))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSetContactNumber2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbPilots, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSetName, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSetSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSetDob, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 26, Short.MAX_VALUE)))
                        .addGap(61, 61, 61))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSetContactNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIDCardNumber)
                    .addComponent(cmbPilots, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFirstName)
                    .addComponent(lblSetName, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLastName)
                    .addComponent(lblSetSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblContactNumber1)
                        .addGap(18, 18, 18)
                        .addComponent(lblContactNumber2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSetContactNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSetContactNumber2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblSetDob, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(117, 117, 117))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbPilotsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPilotsActionPerformed
        // TODO add your handling code here:
        ViewPilots();
    }//GEN-LAST:event_cmbPilotsActionPerformed

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
            java.util.logging.Logger.getLogger(ViewPilots.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPilots.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPilots.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPilots.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewPilots().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbPilots;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblContactNumber1;
    private javax.swing.JLabel lblContactNumber2;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblIDCardNumber;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblSetContactNumber1;
    private javax.swing.JLabel lblSetContactNumber2;
    private javax.swing.JLabel lblSetDob;
    private javax.swing.JLabel lblSetName;
    private javax.swing.JLabel lblSetSurname;
    // End of variables declaration//GEN-END:variables
}