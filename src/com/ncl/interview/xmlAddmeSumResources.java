//***************************************************************************
// xmlAddmeSumResources.java
//
// Solution to interview problem 1, resources.
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

package com.ncl.interview;

import java.util.*;

/**
 * ResourceBundle class containing English PII used by the 
 * xmlAddmeSum class. 
 * 
 * @version 0.1
 */
public class xmlAddmeSumResources extends ListResourceBundle
{
    protected Object[][] getContents() 
    {
        return new Object[][]
        {
             // LOCALIZE THE SECOND STRING OF EACH ARRAY
             {"ADDME00001", "Initializing xmlAddmeSum instance."},
             {"ADDME00002", "Creating Document from xml string:"},
             {"ADDME00003", "Creating Document from xml file \"{0}\""},
             {"ADDME00004", "  Node Value = {0,number,0.0}"},
             {"ADDME00005", "  Sum = {0,number,0.0}"},
             {"ERR_ADDME00001", "Error: creating DOM builder."},
             {"ERR_ADDME00002", "Error: parsing input xml."},
             {"ERR_ADDME00003", "Error: Cannot parse float from current node string (\"{0}\")."},
             {"ERR_ADDME00004", "Error: Value in this node not added to sum!"}
             // END OF MATERIAL TO LOCALIZE
        };
    }
}
