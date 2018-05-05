

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author b42203
 */
public class EditFlight extends javax.swing.JFrame {
    
    public int year = GregorianCalendar.getInstance().get(GregorianCalendar.YEAR);
    public int year2 = GregorianCalendar.getInstance().get(GregorianCalendar.YEAR) + 1;
    public int year3 = GregorianCalendar.getInstance().get(GregorianCalendar.YEAR) + 2;
    
    public static GregorianCalendar cl;
    public static String fdt;

    /**
     * Creates new form EditFlight
     */
    public EditFlight() {
        initComponents();
        
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        CrudOperations.FillCmbs("SELECT FlightNo FROM flights_tbl", cmbFlightNumber);
        CrudOperations.FillCmbs("SELECT AircraftName FROM Aircraft_tbl", cmbAircraft);
        CrudOperations.FillCmbs("SELECT CountryName FROM Country_tbl", cmbDepCountry);
        CrudOperations.FillCmbs("SELECT CountryName FROM Country_tbl", cmbDestCountry);

        cmbYears.addItem(Integer.toString(year));
        cmbYears.addItem(Integer.toString(year2));
        cmbYears.addItem(Integer.toString(year3));

        updateDay();
        FillDetails();
    }
    
    public void updateDay(){
        cmbDays.removeAllItems();
        
        int userYear = Integer.parseInt((String)cmbYears.getSelectedItem());
        System.out.println(userYear);
        
        YearMonth selectedMonth = YearMonth.of(userYear, cmbMonths.getSelectedIndex() + 1);
        for(int i = 0; i < selectedMonth.lengthOfMonth(); i++){
            cmbDays.addItem(Integer.toString(i + 1));
        }
    }
    
    public void FillDetails(){
        CrudOperations.SetSelectedItem("SELECT AircraftName FROM Aircraft_tbl WHERE AircraftId IN (SELECT AircraftId FROM Flights_tbl WHERE FlightNo = '" + cmbFlightNumber.getSelectedItem() + "')", cmbAircraft);
        
        //Dep
        CrudOperations.SetSelectedItem("SELECT CountryName FROM country_tbl WHERE CountryId IN (SELECT CountryId FROM City_tbl WHERE CityName = '" + cmbDepCity.getSelectedItem() + "')", cmbDepCountry);
        CrudOperations.SetSelectedItem("SELECT CityName from city_tbl WHERE CityId IN (SELECT CityId FROM Airport_tbl WHERE AirportName = '" + cmbDepAirport.getSelectedItem() + "')", cmbDepCity);
        CrudOperations.SetSelectedItem("SELECT AirportName FROM Airport_tbl WHERE AirportId IN (SELECT AirportDep FROM Flights_tbl WHERE FlightNo = '" + cmbFlightNumber.getSelectedItem() + "')", cmbDepAirport);
        
        //Dest
        CrudOperations.SetSelectedItem("SELECT CountryName FROM country_tbl WHERE CountryId IN (SELECT CountryId FROM City_tbl WHERE CityName = '" + cmbDestCity.getSelectedItem() + "')", cmbDestCountry);
        CrudOperations.SetSelectedItem("SELECT CityName from city_tbl WHERE CityId IN (SELECT CityId FROM Airport_tbl WHERE AirportName = '" + cmbDestAirport.getSelectedItem() + "')", cmbDestCity);
        CrudOperations.SetSelectedItem("SELECT AirportName FROM Airport_tbl WHERE AirportId IN (SELECT AirportDest FROM Flights_tbl WHERE FlightNo = '" + cmbFlightNumber.getSelectedItem() + "')", cmbDestAirport);
        
        //Hr
        CrudOperations.SetSelectedItem("SELECT HOUR(TimeFrom) FROM Flights_tbl WHERE FlightNo = '" + cmbFlightNumber.getSelectedItem() + "'", cmbTimeFromHr);
        CrudOperations.SetSelectedItem("SELECT HOUR(TimeTo) FROM Flights_tbl WHERE FlightNo = '" + cmbFlightNumber.getSelectedItem() + "'", cmbTimeToHr);
        
        //Min
        CrudOperations.SetSelectedItem("SELECT MINUTE(TimeFrom) FROM Flights_tbl WHERE FlightNo = '" + cmbFlightNumber.getSelectedItem() + "'", cmbTimeFromMins);
        CrudOperations.SetSelectedItem("SELECT MINUTE(TimeTo) FROM Flights_tbl WHERE FlightNo = '" + cmbFlightNumber.getSelectedItem() + "'", cmbTimeToMins);
        
        //Day
        CrudOperations.SetSelectedItem("SELECT DAY(FlightDate) FROM Flights_tbl WHERE FlightNo = '" + cmbFlightNumber.getSelectedItem() + "'", cmbDays);
        
        //Month
        CrudOperations.SetSelectedItem("SELECT MONTHNAME(FlightDate) FROM Flights_tbl WHERE FlightNo = '" + cmbFlightNumber.getSelectedItem() + "'", cmbMonths);
        
        //Year
        CrudOperations.SetSelectedItem("SELECT YEAR(FlightDate) FROM Flights_tbl WHERE FlightNo = '" + cmbFlightNumber.getSelectedItem() + "'", cmbYears);

        CrudOperations.ViewDetailsTxt("SELECT Price FROM Flights_tbl WHERE FlightNo = '" + cmbFlightNumber.getSelectedItem() + "'", txtPrice);
        CrudOperations.ViewDetailsTxt("SELECT NoOfCrew FROM flights_tbl WHERE FlightNo = '" + cmbFlightNumber.getSelectedItem() + "'" , txtNoOfCrew);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNoOfCrew = new javax.swing.JLabel();
        lblAircraft = new javax.swing.JLabel();
        lblDep = new javax.swing.JLabel();
        lblDest = new javax.swing.JLabel();
        lblDuration = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblMonth = new javax.swing.JLabel();
        lblDay = new javax.swing.JLabel();
        lblYear = new javax.swing.JLabel();
        lblTimeFrom = new javax.swing.JLabel();
        lblTimeTo = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        txtNoOfCrew = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        cmbAircraft = new javax.swing.JComboBox<>();
        cmbDepCountry = new javax.swing.JComboBox<>();
        cmbDepCity = new javax.swing.JComboBox<>();
        cmbDepAirport = new javax.swing.JComboBox<>();
        cmbDestCountry = new javax.swing.JComboBox<>();
        cmbDestCity = new javax.swing.JComboBox<>();
        cmbDestAirport = new javax.swing.JComboBox<>();
        cmbMonths = new javax.swing.JComboBox<>();
        cmbDays = new javax.swing.JComboBox<>();
        cmbYears = new javax.swing.JComboBox<>();
        cmbTimeFromHr = new javax.swing.JComboBox<>();
        cmbTimeFromMins = new javax.swing.JComboBox<>();
        cmbTimeToHr = new javax.swing.JComboBox<>();
        cmbTimeToMins = new javax.swing.JComboBox<>();
        cmbFlightNumber = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        lblFlightNumberChoose = new javax.swing.JLabel();
        txtDuration1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNoOfCrew.setText("Number Of Crew");

        lblAircraft.setText("Aircraft");

        lblDep.setText("Departure");

        lblDest.setText("Destination");

        lblDuration.setText("Duration");

        lblDate.setText("Date");

        lblMonth.setText("Month");

        lblDay.setText("Day");

        lblYear.setText("Year");

        lblTimeFrom.setText("Time From");

        lblTimeTo.setText("Time To");

        lblPrice.setText("Price (€)");

        cmbAircraft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAircraftActionPerformed(evt);
            }
        });

        cmbDepCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDepCountryActionPerformed(evt);
            }
        });

        cmbDepCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDepCityActionPerformed(evt);
            }
        });

        cmbDestCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDestCountryActionPerformed(evt);
            }
        });

        cmbDestCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDestCityActionPerformed(evt);
            }
        });

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

        cmbTimeFromHr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));

        cmbTimeFromMins.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));

        cmbTimeToHr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));

        cmbTimeToMins.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));

        cmbFlightNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFlightNumberActionPerformed(evt);
            }
        });

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblFlightNumberChoose.setText("Flight Number");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNoOfCrew)
                            .addComponent(lblAircraft)
                            .addComponent(lblDest)
                            .addComponent(lblDuration)
                            .addComponent(lblDate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 382, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPrice)
                                .addGap(18, 18, 18)
                                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTimeFrom)
                                    .addComponent(lblTimeTo))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbTimeToHr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cmbTimeToMins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbTimeFromHr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cmbTimeFromMins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(85, 85, 85))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDep)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblMonth)
                                .addGap(68, 68, 68)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(cmbYears, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblDay)
                                            .addGap(67, 67, 67)
                                            .addComponent(lblYear))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtNoOfCrew, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cmbAircraft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cmbDepCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cmbDestCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cmbFlightNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(60, 60, 60))))))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbDepCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbDestCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbDepAirport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbDestAirport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbMonths, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblFlightNumberChoose)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(126, 126, 126)
                    .addComponent(txtDuration1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(490, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFlightNumberChoose)
                    .addComponent(cmbFlightNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTimeFrom)
                    .addComponent(cmbTimeFromHr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTimeFromMins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNoOfCrew)
                    .addComponent(lblTimeTo)
                    .addComponent(txtNoOfCrew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTimeToHr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTimeToMins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAircraft)
                    .addComponent(lblPrice)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbAircraft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDep)
                    .addComponent(cmbDepCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDepCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDepAirport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDest)
                    .addComponent(cmbDestCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDestCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDestAirport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblDuration)
                .addGap(18, 18, 18)
                .addComponent(lblDate)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMonth)
                    .addComponent(lblDay)
                    .addComponent(lblYear))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMonths, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbYears, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(249, Short.MAX_VALUE)
                    .addComponent(txtDuration1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(184, 184, 184)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbAircraftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAircraftActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbAircraftActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        
        int yr = (int) Integer.parseInt(cmbYears.getSelectedItem().toString());
        int month = cmbMonths.getSelectedIndex();
        int day = (int) Integer.parseInt(cmbDays.getSelectedItem().toString());
        
        cl = new GregorianCalendar(yr, month, day);
        fdt = df.format(cl.getTime());
        
        String timeFrom = cmbTimeFromHr.getSelectedItem() + ":" + cmbTimeFromMins.getSelectedItem();
        String timeTo = cmbTimeToHr.getSelectedItem() + ":" + cmbTimeToMins.getSelectedItem();
        
        CrudOperations.EditDetails("UPDATE flights_tbl SET NoOfCrew = " + txtNoOfCrew.getText() + ","+ 
        "FlightDate = '" + fdt + "'" + "," +
        "TimeFrom = '" + timeFrom + "'" + "," +
        "TimeTo = '" + timeTo + "'" + "," +
        "AircraftId = (SELECT AircraftId FROM aircraft_tbl WHERE AircraftName = '" + cmbAircraft.getSelectedItem() + "')" + "," +
        "AirportDep = (SELECT AirportId FROM Airport_tbl WHERE AirportName = '" + cmbDepAirport.getSelectedItem() + "')" + "," +
        "AirportDest = (SELECT AirportId FROM Airport_tbl WHERE AirportName = '" + cmbDestAirport.getSelectedItem() + "')" + "," +
        "Price = " + txtPrice.getText() + " " + 
        "WHERE FlightNo = '" + cmbFlightNumber.getSelectedItem() + "'");
        
        JOptionPane.showMessageDialog(null, "Flight Updated Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
        new Home().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbFlightNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFlightNumberActionPerformed
        // TODO add your handling code here:
        //CrudOperations.FillCmbs("SELECT AircraftName FROM Aircraft_tbl", cmbAircraft);
        //CrudOperations.FillCmbs("SELECT CountryName FROM Country_tbl", cmbDepCountry);
        //CrudOperations.FillCmbs("SELECT CountryName FROM Country_tbl", cmbDestCountry);
        
        cmbYears.addItem(Integer.toString(year));
        cmbYears.addItem(Integer.toString(year2));
        cmbYears.addItem(Integer.toString(year3));
        
        updateDay();
        FillDetails();
    }//GEN-LAST:event_cmbFlightNumberActionPerformed

    private void cmbDepCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDepCountryActionPerformed
        // TODO add your handling code here:
        CrudOperations.FillCmbs("SELECT CityName FROM City_tbl WHERE CountryId IN (SELECT CountryId FROM country_tbl WHERE CountryName = '" + cmbDepCountry.getSelectedItem() +  "')", cmbDepCity);
    }//GEN-LAST:event_cmbDepCountryActionPerformed

    private void cmbDepCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDepCityActionPerformed
        // TODO add your handling code here:
        CrudOperations.FillCmbs("SELECT AirportName FROM Airport_tbl WHERE CityId IN (SELECT CityId FROM city_tbl WHERE CityName = '" + cmbDepCity.getSelectedItem() + "')", cmbDepAirport);
    }//GEN-LAST:event_cmbDepCityActionPerformed

    private void cmbDestCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDestCountryActionPerformed
        // TODO add your handling code here:
        CrudOperations.FillCmbs("SELECT CityName FROM City_tbl WHERE CountryId IN (SELECT CountryId FROM country_tbl WHERE CountryName = '" + cmbDestCountry.getSelectedItem() +  "')", cmbDestCity);
    }//GEN-LAST:event_cmbDestCountryActionPerformed

    private void cmbDestCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDestCityActionPerformed
        // TODO add your handling code here:
        CrudOperations.FillCmbs("SELECT AirportName FROM Airport_tbl WHERE CityId IN (SELECT CityId FROM city_tbl WHERE CityName = '" + cmbDestCity.getSelectedItem() + "')", cmbDestAirport);
    }//GEN-LAST:event_cmbDestCityActionPerformed

    private void cmbMonthsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMonthsActionPerformed
        // TODO add your handling code here:
        updateDay();    
    }//GEN-LAST:event_cmbMonthsActionPerformed

    private void cmbDaysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDaysActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDaysActionPerformed

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
            java.util.logging.Logger.getLogger(EditFlight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditFlight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditFlight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditFlight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditFlight().setVisible(true);
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
    private javax.swing.JComboBox<String> cmbFlightNumber;
    private javax.swing.JComboBox<String> cmbMonths;
    private javax.swing.JComboBox<String> cmbTimeFromHr;
    private javax.swing.JComboBox<String> cmbTimeFromMins;
    private javax.swing.JComboBox<String> cmbTimeToHr;
    private javax.swing.JComboBox<String> cmbTimeToMins;
    private javax.swing.JComboBox<String> cmbYears;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblAircraft;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDay;
    private javax.swing.JLabel lblDep;
    private javax.swing.JLabel lblDest;
    private javax.swing.JLabel lblDuration;
    private javax.swing.JLabel lblFlightNumberChoose;
    private javax.swing.JLabel lblMonth;
    private javax.swing.JLabel lblNoOfCrew;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblTimeFrom;
    private javax.swing.JLabel lblTimeTo;
    private javax.swing.JLabel lblYear;
    private javax.swing.JTextField txtDuration1;
    private javax.swing.JTextField txtNoOfCrew;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}