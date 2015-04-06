//***************************************************************************
// xmlAddmeSumDriver.java
//
// Test driver for xmlAddmeSum class
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
// 04/04/15  000001     KM   Initial creation.
//***************************************************************************

package com.ncl.interview;
import java.io.File;

/**
 * 'Driver' class with a main() that is used for manual testing 
 * of / experimentation with the xmlAddmeSum class. 
 * 
 * @version 0.1
 */
public class xmlAddmeSumDriver
{
    private static xmlAddmeSum summer = null;

    public static void main (String[] argv)
    {
        summer = new xmlAddmeSum();
        float sum = summer.sum("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n<invoice>\n<addme>14.0</addme>\n<addme>15.0</addme>\n<addme>13.0</addme>\n</invoice>");
        System.out.println("Sum="+sum);
        float sum2 = summer.sum(new File("..\\addme.xml"));
        System.out.println("Sum2="+sum2);
        float sum3 = summer.sum(new File("..\\addme_badvalue.xml"));
        System.out.println("Sum3="+sum3);
    }
}
