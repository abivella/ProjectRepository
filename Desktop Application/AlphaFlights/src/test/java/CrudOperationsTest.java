/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Abigail
 */
public class CrudOperationsTest {
    
    public CrudOperationsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of Validation method, of class CrudOperations.
     */
    @Test
    public void testValidation() {
        System.out.println("Validation");
        JTextField txt = null;
        String typeOfVal = "";
        boolean expResult = false;
        boolean result = CrudOperations.Validation(txt, typeOfVal);
        assertTrue(expResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of CreateRecord method, of class CrudOperations.
     */
    @Test
    public void testCreateRecord() {
        System.out.println("CreateRecord");
        String qry = "";
        CrudOperations.CreateRecord(qry);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of FillCmbs method, of class CrudOperations.
     */
    @Test
    public void testFillCmbs() {
        System.out.println("FillCmbs");
        String qry = "";
        JComboBox cmb = null;
        CrudOperations.FillCmbs(qry, cmb);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of ViewDetails method, of class CrudOperations.
     */
    @Test
    public void testViewDetails() {
        System.out.println("ViewDetails");
        String qry = "";
        ResultSet expResult = null;
        ResultSet result = CrudOperations.ViewDetails(qry);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of ViewDetailsLbl method, of class CrudOperations.
     */
    @Test
    public void testViewDetailsLbl() {
        System.out.println("ViewDetailsLbl");
        String qry = "";
        JLabel lbl = null;
        CrudOperations.ViewDetailsLbl(qry, lbl);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of ViewDetailsTxt method, of class CrudOperations.
     */
    @Test
    public void testViewDetailsTxt() {
        System.out.println("ViewDetailsTxt");
        String qry = "";
        JTextField txt = null;
        CrudOperations.ViewDetailsTxt(qry, txt);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of ViewDetailsCmb method, of class CrudOperations.
     */
    @Test
    public void testViewDetailsCmb() {
        System.out.println("ViewDetailsCmb");
        String qry = "";
        JComboBox cmb = null;
        CrudOperations.ViewDetailsCmb(qry, cmb);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of SetSelectedItem method, of class CrudOperations.
     */
    @Test
    public void testSetSelectedItem() {
        System.out.println("SetSelectedItem");
        String qry = "";
        JComboBox cmb = null;
        CrudOperations.SetSelectedItem(qry, cmb);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of EditDetails method, of class CrudOperations.
     */
    @Test
    public void testEditDetails() {
        System.out.println("EditDetails");
        String qry = "";
        CrudOperations.EditDetails(qry);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of DeleteRecord method, of class CrudOperations.
     */
    @Test
    public void testDeleteRecord() {
        System.out.println("DeleteRecord");
        String qry = "";
        CrudOperations.DeleteRecord(qry);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
