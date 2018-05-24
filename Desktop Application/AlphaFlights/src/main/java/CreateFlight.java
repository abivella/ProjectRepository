/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.time.*;
import java.util.GregorianCalendar;

/**
 *
 * @author b42203
 */
public class CreateFlight extends javax.swing.JFrame {
    
    public int year = GregorianCalendar.getInstance().get(GregorianCalendar.YEAR);
    public int year2 = GregorianCalendar.getInstance().get(GregorianCalendar.YEAR) + 1;
    public int year3 = GregorianCalendar.getInstance().get(GregorianCalendar.YEAR) + 2;
    
    public static GregorianCalendar cl;
    public static String fdt;

    /**
     * Creates new form CreateFlight
     */
    public CreateFlight() {
        initComponents();
        
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        
        CrudOperations.FillCmbs("SELECT AircraftName FROM Aircraft_tbl", cmbAircraft);
        CrudOperations.FillCmbs("SELECT CountryName FROM Country_tbl", cmbDepCountry);
        CrudOperations.FillCmbs("SELECT CountryName FROM Country_tbl", cmbDestCountry);
        CrudOperations.FillCmbs("SELECT IDCardNumber FROM Pilot_tbl", cmbPilots);
        
        FillDepCities();
        FillDepAirports();
        
        cmbYears.addItem(Integer.toString(year));
        cmbYears.addItem(Integer.toString(year2));
        cmbYears.addItem(Integer.toString(year3));
    }
    
    public void insertFlight(){
        DbConnection.conn();
        Connection conn = DbConnection.conn;
        
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        
        int yr = (int) Integer.parseInt(cmbYears.getSelectedItem().toString());
        int month = cmbMonths.getSelectedIndex();
        int day = (int) Integer.parseInt(cmbDays.getSelectedItem().toString());
        
        cl = new GregorianCalendar(yr, month, day);
        fdt = df.format(cl.getTime());
        
        String timeFrom = cmbTimeFromHrs.getSelectedItem() + ":" + cmbTimeFromMins.getSelectedItem();
        String timeTo = cmbTimeToHrs.getSelectedItem() + ":" + cmbTimeToMins.getSelectedItem();

        
        CrudOperations.CreateRecord("INSERT INTO Flights_tbl(FlightId, FlightNo, NoOfCrew, FlightDate, TimeFrom, "
                    + "TimeTo, Duration, AircraftId, AirportDep, AirportDest, Price) "
                    + "VALUES (NULL," + "'" + txtFlightNumber.getText() + "'" + "," + "'" + txtNoOfCrew.getText() + "'" + "," + "'" + fdt + "'" +  "," + "'" + timeFrom + "'" + "," 
                    + "'" + timeTo + "'" + "," + "'" + txtDuration.getText() + "'" + "," 
                    + "(SELECT AircraftId FROM Aircraft_tbl WHERE AircraftName = '" + cmbAircraft.getSelectedItem() +  "')" + "," 
                    + "(SELECT AirportId FROM Airport_tbl WHERE AirportName = '" + cmbDepAirport.getSelectedItem() +  "')" + "," 
                    + "(SELECT AirportId FROM Airport_tbl WHERE AirportName = '" + cmbDestAirport.getSelectedItem() +  "')" + "," 
                    + "'" + txtPrice.getText() + "'" + ")");
        
        
        JOptionPane.showMessageDialog(null, "Flight Created Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
        new Home().setVisible(true);
        
        System.out.println(txtFlightNumber.getText());
        
        CrudOperations.CreateRecord("INSERT INTO flightpilot_tbl(FlightId, PilotId) VALUES((SELECT FlightId FROM Flights_tbl WHERE FlightNo = '" + txtFlightNumber.getText() + "'" + "), (SELECT PilotId FROM Pilot_tbl WHERE IDCardNumber = '" + cmbPilots.getSelectedItem() + "')" + ")");

        
    }
    
    public void updateDay(){
        cmbDays.removeAllItems();

        int userYear = Integer.parseInt((String)cmbYears.getSelectedItem());
        YearMonth selectedMonth = YearMonth.of(userYear, cmbMonths.getSelectedIndex() + 1);
        for(int i = 0; i < selectedMonth.lengthOfMonth(); i++){
            cmbDays.addItem(Integer.toString(i + 1));
        }
    }
    
    
    public void FillDepAirports(){
        CrudOperations.FillCmbs("SELECT AirportName FROM Airport_tbl WHERE CityId IN (SELECT CityId FROM city_tbl WHERE CityName = '" + cmbDepCity.getSelectedItem() + "')", cmbDepAirport);
    }
    
    public void FillDepCities(){
        CrudOperations.FillCmbs("SELECT CityName FROM City_tbl WHERE CountryId IN (SELECT CountryId FROM country_tbl WHERE CountryName = '" + cmbDepCountry.getSelectedItem() +  "')", cmbDepCity);
    }
    
    public void FillDestCities(){
        CrudOperations.FillCmbs("SELECT CityName FROM City_tbl WHERE CountryId IN (SELECT CountryId FROM country_tbl WHERE CountryName = '" + cmbDestCountry.getSelectedItem() +  "')", cmbDestCity);
    }
    
    public void FillDestAirports(){
        CrudOperations.FillCmbs("SELECT AirportName FROM Airport_tbl WHERE CityId IN (SELECT CityId FROM city_tbl WHERE CityName = '" + cmbDestCity.getSelectedItem() + "')", cmbDestAirport);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFlightNumber = new javax.swing.JLabel();
        txtNoOfCrew = new javax.swing.JTextField();
        lblNoOfCrew = new javax.swing.JLabel();
        lblAircraft = new javax.swing.JLabel();
        lblDep = new javax.swing.JLabel();
        lblDest = new javax.swing.JLabel();
        lblDuration = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblDay = new javax.swing.JLabel();
        lblMonth = new javax.swing.JLabel();
        lblYear = new javax.swing.JLabel();
        lblTimeFrom = new javax.swing.JLabel();
        lblTimeTo = new javax.swing.JLabel();
        cmbAircraft = new javax.swing.JComboBox<>();
        cmbDepCountry = new javax.swing.JComboBox<>();
        cmbDestCountry = new javax.swing.JComboBox<>();
        txtDuration = new javax.swing.JTextField();
        cmbDays = new javax.swing.JComboBox<>();
        cmbMonths = new javax.swing.JComboBox<>();
        cmbYears = new javax.swing.JComboBox<>();
        txtFlightNumber = new javax.swing.JTextField();
        cmbTimeFromHrs = new javax.swing.JComboBox<>();
        cmbTimeFromMins = new javax.swing.JComboBox<>();
        cmbTimeToHrs = new javax.swing.JComboBox<>();
        cmbTimeToMins = new javax.swing.JComboBox<>();
        cmbDepCity = new javax.swing.JComboBox<>();
        cmbDepAirport = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        cmbDestCity = new javax.swing.JComboBox<>();
        cmbDestAirport = new javax.swing.JComboBox<>();
        lblPrice = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        lblPilot = new javax.swing.JLabel();
        cmbPilots = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblFlightNumber.setText("Flight Number");

        lblNoOfCrew.setText("Number of Crew");

        lblAircraft.setText("Aircraft");

        lblDep.setText("Departure");

        lblDest.setText("Destination");

        lblDuration.setText("Duration ");

        lblDate.setText("Date:");

        lblDay.setText("Day");

        lblMonth.setText("Month");

        lblYear.setText("Year");

        lblTimeFrom.setText("Time From");

        lblTimeTo.setText("Time To");

        cmbAircraft.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbDepCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDepCountryActionPerformed(evt);
            }
        });

        cmbDestCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDestCountryActionPerformed(evt);
            }
        });

        cmbMonths.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        cmbMonths.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMonthsActionPerformed(evt);
            }
        });

        cmbYears.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbYearsActionPerformed(evt);
            }
        });

        cmbTimeFromHrs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));

        cmbTimeFromMins.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));

        cmbTimeToHrs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));

        cmbTimeToMins.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));

        cmbDepCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDepCityActionPerformed(evt);
            }
        });

        cmbDepAirport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDepAirportActionPerformed(evt);
            }
        });

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cmbDestCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDestCityActionPerformed(evt);
            }
        });

        cmbDestAirport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDestAirportActionPerformed(evt);
            }
        });

        lblPrice.setText("Price (€)");

        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });

        lblPilot.setText("Pilot");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDate)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFlightNumber)
                            .addComponent(lblNoOfCrew)
                            .addComponent(lblAircraft)
                            .addComponent(lblDep)
                            .addComponent(lblDest)
                            .addComponent(lblDuration))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbDestCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmbDestCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmbDestAirport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbAircraft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFlightNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNoOfCrew, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbDepCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cmbDepCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cmbDepAirport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(74, 74, 74)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPilot)
                                    .addComponent(lblPrice)
                                    .addComponent(lblTimeTo)
                                    .addComponent(lblTimeFrom))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbTimeFromHrs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cmbTimeFromMins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbTimeToHrs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cmbTimeToMins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbPilots, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDay)
                            .addComponent(cmbDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMonth)
                            .addComponent(cmbMonths, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbYears, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblYear))))
                .addContainerGap(470, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFlightNumber)
                            .addComponent(lblTimeFrom)
                            .addComponent(cmbTimeFromHrs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbTimeFromMins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtFlightNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNoOfCrew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNoOfCrew)
                            .addComponent(lblTimeTo)
                            .addComponent(cmbTimeToHrs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbTimeToMins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAircraft)
                            .addComponent(cmbAircraft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPrice)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDep)
                            .addComponent(cmbDepCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbDepCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbDepAirport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPilot)
                            .addComponent(cmbPilots, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDest)
                            .addComponent(cmbDestCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbDestCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbDestAirport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblDuration))
                    .addComponent(txtDuration, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblDate)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDay)
                    .addComponent(lblMonth)
                    .addComponent(lblYear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbMonths, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbYears, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbDepAirportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDepAirportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDepAirportActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        CrudOperations.Validation(txtFlightNumber, "DigitStringY");
        boolean FlightNoContains = CrudOperations.Validation(txtFlightNumber, "DigitStringY");
        
        CrudOperations.Validation(txtNoOfCrew, "NoString");
        boolean CrewNoContains = CrudOperations.Validation(txtNoOfCrew, "NoString");
        
        CrudOperations.Validation(txtPrice, "NoString");
        boolean PriceContains = CrudOperations.Validation(txtPrice, "NoString");
   
        boolean found = CrudOperations.CheckRow2("SELECT COUNT(*) FROM flights_tbl WHERE FlightNo='" + txtFlightNumber.getText() + "'");
        System.out.println(found);
        
        if(found == true){
            JOptionPane.showMessageDialog(null, "Flight Number Already Exist!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(found == false){
            if(FlightNoContains == false && CrewNoContains == false && PriceContains == false){
                insertFlight(); 
            }
            
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbDestAirportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDestAirportActionPerformed
        // TODO add your handling code here:
        FillDepAirports();
    }//GEN-LAST:event_cmbDestAirportActionPerformed

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceActionPerformed

    private void cmbDepCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDepCountryActionPerformed
        // TODO add your handling code here:
        FillDepCities();
        
    }//GEN-LAST:event_cmbDepCountryActionPerformed

    private void cmbDepCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDepCityActionPerformed
        // TODO add your handling code here:
        FillDepAirports();
    }//GEN-LAST:event_cmbDepCityActionPerformed

    private void cmbDestCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDestCountryActionPerformed
        // TODO add your handling code here:
        FillDestCities();
    }//GEN-LAST:event_cmbDestCountryActionPerformed

    private void cmbDestCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDestCityActionPerformed
        // TODO add your handling code here:
        FillDestAirports();

    }//GEN-LAST:event_cmbDestCityActionPerformed

    private void cmbMonthsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMonthsActionPerformed
        // TODO add your handling code here:
        updateDay();
    }//GEN-LAST:event_cmbMonthsActionPerformed

    private void cmbYearsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbYearsActionPerformed
        // TODO add your handling code here:
        updateDay();
    }//GEN-LAST:event_cmbYearsActionPerformed

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
            java.util.logging.Logger.getLogger(CreateFlight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateFlight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateFlight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateFlight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateFlight().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbAircraft;
    private javax.swing.JComboBox<String> cmbDays;
    private javax.swing.JComboBox<String> cmbDepAirport;
    private javax.swing.JComboBox<String> cmbDepCity;
    private javax.swing.JComboBox<String> cmbDepCountry;
    private javax.swing.JComboBox<String> cmbDestAirport;
    private javax.swing.JComboBox<String> cmbDestCity;
    private javax.swing.JComboBox<String> cmbDestCountry;
    private javax.swing.JComboBox<String> cmbMonths;
    private javax.swing.JComboBox<String> cmbPilots;
    private javax.swing.JComboBox<String> cmbTimeFromHrs;
    private javax.swing.JComboBox<String> cmbTimeFromMins;
    private javax.swing.JComboBox<String> cmbTimeToHrs;
    private javax.swing.JComboBox<String> cmbTimeToMins;
    private javax.swing.JComboBox<String> cmbYears;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblAircraft;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDay;
    private javax.swing.JLabel lblDep;
    private javax.swing.JLabel lblDest;
    private javax.swing.JLabel lblDuration;
    private javax.swing.JLabel lblFlightNumber;
    private javax.swing.JLabel lblMonth;
    private javax.swing.JLabel lblNoOfCrew;
    private javax.swing.JLabel lblPilot;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblTimeFrom;
    private javax.swing.JLabel lblTimeTo;
    private javax.swing.JLabel lblYear;
    private javax.swing.JTextField txtDuration;
    private javax.swing.JTextField txtFlightNumber;
    private javax.swing.JTextField txtNoOfCrew;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
