
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
public class DeleteAirports extends javax.swing.JFrame {

    /**
     * Creates new form DeleteAirports
     */
    public DeleteAirports() {
        initComponents();
        
        CrudOperations.FillCmbs("SELECT CountryName FROM Country_tbl", cmbCountry);
        CrudOperations.FillCmbs("SELECT CityName FROM City_tbl WHERE CountryId IN (SELECT CountryId FROM country_tbl WHERE CountryName = '" + cmbCountry.getSelectedItem() +  "')", cmbCity);
        CrudOperations.FillCmbs("SELECT AirportName FROM Airport_tbl WHERE CityId IN (SELECT CityId FROM city_tbl WHERE CityName = '" + cmbCity.getSelectedItem() + "')", cmbAirports);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCountry = new javax.swing.JLabel();
        lblCity = new javax.swing.JLabel();
        lblAirport = new javax.swing.JLabel();
        cmbCountry = new javax.swing.JComboBox<>();
        cmbCity = new javax.swing.JComboBox<>();
        cmbAirports = new javax.swing.JComboBox<>();
        btnDel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblCountry.setText("Country");

        lblCity.setText("City");

        lblAirport.setText("Airport");

        cmbCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCountryActionPerformed(evt);
            }
        });

        cmbCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCityActionPerformed(evt);
            }
        });

        btnDel.setText("DELETE");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCountry)
                    .addComponent(cmbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(149, 149, 149)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCity)
                            .addComponent(cmbCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbAirports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAirport))))
                .addContainerGap(488, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCountry)
                    .addComponent(lblCity)
                    .addComponent(lblAirport))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbAirports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(btnDel)
                .addGap(84, 84, 84))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        // TODO add your handling code here:
        Object[] options = {"Delete", "Cancel"};
        Object[] options2 = {"Ok"};
        boolean found = CrudOperations.CheckRow("SELECT AirportDep, AirportDest FROM flights_tbl WHERE AirportDep = (SELECT AirportId FROM airport_tbl WHERE AirportName = '" + cmbAirports.getSelectedItem()+ "') OR AirportDest = (SELECT AirportId FROM airport_tbl WHERE AirportName = '" + cmbAirports.getSelectedItem()+ "')", "DELETE FROM airport_tbl WHERE AirportName= '" + cmbAirports.getSelectedItem() + "'");
        
        if (found == true){
            JOptionPane.showOptionDialog(null, "Airport cannot be deleted! Flight has a departure or destination with the chosen airport!", "Please confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,options2,options2[0]);
        }
        else if(found == false){
            int option = JOptionPane.showOptionDialog(null, "Are you sure you want to delete the record?", "Please confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                if(option == JOptionPane.YES_OPTION){
                CrudOperations.DeleteRecord("DELETE FROM Airport_tbl WHERE AirportName= '" + cmbAirports.getSelectedItem() + "'");

                JOptionPane.showMessageDialog(null, "Airport Deleted Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                new Home().setVisible(true);
            } 
        }
       
    }//GEN-LAST:event_btnDelActionPerformed

    private void cmbCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCountryActionPerformed
        // TODO add your handling code here:
        CrudOperations.FillCmbs("SELECT CityName FROM City_tbl WHERE CountryId IN (SELECT CountryId FROM country_tbl WHERE CountryName = '" + cmbCountry.getSelectedItem() +  "')", cmbCity);
    }//GEN-LAST:event_cmbCountryActionPerformed

    private void cmbCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCityActionPerformed
        // TODO add your handling code here:
        CrudOperations.FillCmbs("SELECT AirportName FROM Airport_tbl WHERE CityId IN (SELECT CityId FROM city_tbl WHERE CityName = '" + cmbCity.getSelectedItem() + "')", cmbAirports);
    }//GEN-LAST:event_cmbCityActionPerformed

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
            java.util.logging.Logger.getLogger(DeleteAirports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeleteAirports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeleteAirports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeleteAirports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeleteAirports().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDel;
    private javax.swing.JComboBox<String> cmbAirports;
    private javax.swing.JComboBox<String> cmbCity;
    private javax.swing.JComboBox<String> cmbCountry;
    private javax.swing.JLabel lblAirport;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblCountry;
    // End of variables declaration//GEN-END:variables
}
