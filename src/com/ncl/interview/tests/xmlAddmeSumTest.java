//***************************************************************************
// xmlAddmeSumTest.java
//
// JUnit unit tests for xmlAddmeSum class
//*******************************************************************************
// NCL Confidential
// OCO Source Materials
// (C) Copyright Norwegian Cruise Line Corporation Ltd., 2015.
// 
// The source code for this program is not published or otherwise
// divested of its trade secrets, irrespective of what has
// been deposited with the U.S. Copyright Office.
//***************************************************************************
// Maintainence Log:
//
// Date      Src Ctrl#  Who  Description
// --------  ---------  ---  ----------------------------------------------
// 04/05/15  000002     KM   Initial creation, PII separation, build.xml, JUnit testcases.
//***************************************************************************

package com.ncl.interview.tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.*;


import com.ncl.interview.*;

public class xmlAddmeSumTest
{
    private static String TestData="<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n<invoice>\n<addme>14.0</addme>\n<addme>15.0</addme>\n<addme>13.0</addme>\n</invoice>";

    @Test
    public void basicSum() 
    {
        System.out.println("\nTest: basicSum() ...");

        // Sum data from test data xml string
        xmlAddmeSum prob1 = new xmlAddmeSum();
        float sum = prob1.sum(TestData);

        // Check total equals the expected 42!
        assertEquals(42.0, sum, 0.0);
        System.out.println("Test basicSum() successful.");
    }

    @Test
    public void basicSumViaFile() throws IOException
    {
        File   testDataFile = null;
        Writer out = null;

        System.out.println("\nTest: basicSumViaFile() ...");
        // Create tmp xml file from test data
        try 
        {
            testDataFile = File.createTempFile("addme_testData_", ".xml");
            testDataFile.deleteOnExit();
            out = new OutputStreamWriter(new FileOutputStream(testDataFile), "UTF-8");
            out.write(TestData);
            out.close();
        }
        catch (Exception e) 
        {
            System.err.println("Error writting test data file ('"+testDataFile.getAbsolutePath()+"')");
            throw e;
        }

        // Sum data from file
        xmlAddmeSum prob1 = new xmlAddmeSum();
        float sum = prob1.sum(testDataFile);

        // Check total equals the expected 42!
        assertEquals(42.0, sum, 0.0);
        System.out.println("Test basicSumViaFile() successful.");
    }
}
