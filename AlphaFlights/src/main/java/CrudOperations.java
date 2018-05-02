/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.sql.*;

/**
 *
 * @author Abigail
 */
public class CrudOperations {

    public static boolean Validation(JTextField txt, String typeOfVal){
        Object[] options = {"Ok" , "Cancel"};
        
        boolean contains = false;
        String textBox = txt.getText();
        
        if(typeOfVal == "NoStringEmptyY"){
            for(char c : textBox.toCharArray()){
                if(Character.isAlphabetic(c)){
                    contains = true;
                }
            }
            if(contains == true){
                JOptionPane.showOptionDialog(null, "Field should not contain letters", "Error", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, options, null);
            }
        }       
        else if(typeOfVal == "NoDigit"){
            for(char c : textBox.toCharArray()){
                if(Character.isDigit(c)){
                    contains = true;
                }
            }
            if(txt.getText().equals("")){
                JOptionPane.showOptionDialog(null, "Field should not be empty", "Error", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, options, null);
            }
            else if(contains == true){
                JOptionPane.showOptionDialog(null, "Field should not contain digits", "Error", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, options, null);
            }
        }
        else if(typeOfVal == "NoString"){
            for(char c : textBox.toCharArray()){
                if(Character.isAlphabetic(c)){
                    contains = true;
                }
            }
            if(txt.getText().equals("")){
                JOptionPane.showOptionDialog(null, "Field should not be empty", "Error", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, options, null);
            }
            else if(contains == true){
                JOptionPane.showOptionDialog(null, "Field should not contain letters", "Error", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, options, null);
            }
        }
        else if(typeOfVal == "DigitStringY"){
            if(txt.getText().equals("")){
                JOptionPane.showOptionDialog(null, "Field should not be empty", "Error", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, options, null);
                contains = true;
            }
            else if(contains == true){
                JOptionPane.showOptionDialog(null, "Field should not contain letters", "Error", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, options, null);
            }
        }
        
        
        return contains;
    }
    
    public static boolean CheckRow(String qry, String delQry){
        DbConnection.conn();
        Connection conn = DbConnection.conn;
        
        boolean found = false;
        
        try{
            Statement st = conn.createStatement();
            String query = qry;
            ResultSet rs = st.executeQuery(query);
            int count = 0;
            
            if(rs.next()){
                count = rs.getInt(1);
                System.out.println(count);
            }
            
            if(count > 0){
                found = true;
            }
            else {
                found = false;
                CrudOperations.DeleteRecord(delQry);
            }
            
        }
        catch (SQLException ex) {
            System.out.println("ERROR: " + ex);
        }
        return found;
    }
    
    public static void CreateRecord(String qry){
        DbConnection.conn();
        Connection conn = DbConnection.conn;
        
        try{
            String query = qry;
            
            Statement st = conn.createStatement();
            st.executeUpdate(query);

        }
        catch (SQLException ex) {
            System.out.println("ERROR: " + ex);
        }
    }

    public static void FillCmbs(String qry, JComboBox cmb){
       DbConnection.conn();
        Connection conn = DbConnection.conn;
        try{
            Statement st = conn.createStatement();
            
            String query = qry;
            ResultSet rs = st.executeQuery(query);

            cmb.removeAllItems();
            
            while(rs.next()){
                System.out.println(rs.getString(1));
                cmb.addItem(rs.getString(1));
            }
            
            conn.close();
        }
        catch (SQLException ex) {
            System.out.println("ERROR: " + ex);
        } 
    }
    
    public static ResultSet ViewDetails(String qry){
        ResultSet rs = null; 
        DbConnection.conn();
        Connection conn = DbConnection.conn;
        try{
            Statement st = conn.createStatement();
            
            String query = qry;
            rs = st.executeQuery(query);
        }
        catch (SQLException ex) {
            System.out.println("ERROR: " + ex);  
        }
        
        return rs;
    }
    
    public static void ViewDetailsLbl(String qry, JLabel lbl){
        ResultSet rs = ViewDetails(qry);
        try{
            lbl.setText("");
            while(rs.next()){
                lbl.setText(rs.getString(1));
            } 
        }
        catch (SQLException ex) {
            System.out.println("ERROR: " + ex);  
        }
        
    }
    
    public static void ViewDetailsTxt(String qry, JTextField txt){
        ResultSet rs = ViewDetails(qry);
        try{
            txt.setText("");
            while(rs.next()){
                txt.setText(rs.getString(1));
            } 
        }
        catch (SQLException ex) {
            System.out.println("ERROR: " + ex);  
        }
        
    }
    
    public static void ViewDetailsCmb(String qry, JComboBox cmb){
        ResultSet rs = ViewDetails(qry);
        try{
            cmb.removeAllItems();
            while(rs.next()){
                cmb.addItem(rs.getString(1));
            } 
        }
        catch (SQLException ex) {
            System.out.println("ERROR: " + ex);  
        }
        
    }
    
    public static void SetSelectedItem(String qry, JComboBox cmb){
        ResultSet rs = ViewDetails(qry);
        try{
            while(rs.next()){
                cmb.setSelectedItem(rs.getString(1));
            } 
        }
        catch (SQLException ex) {
            System.out.println("ERROR: " + ex);  
        }
    }
            
    
    public static void EditDetails(String qry){
        DbConnection.conn();
        Connection conn = DbConnection.conn;
        
        try{
            Statement st = conn.createStatement();
            
            String query = qry;
            
            st.executeUpdate(query);

            
            conn.close();
            
        }
        catch (SQLException ex) {
            System.out.println("ERROR: " + ex);
        }
        
    }
    
    public static void DeleteRecord(String qry){
        DbConnection.conn();
        Connection conn = DbConnection.conn;
        
        try{
            Statement st = conn.createStatement();
            String query = qry;
            st.execute(query);
        }
        catch (SQLException ex) {
            System.out.println("ERROR: " + ex);
        }
    }
    
}
