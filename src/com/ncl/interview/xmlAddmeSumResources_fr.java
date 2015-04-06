//***************************************************************************
// xmlAddmeSumResources_fr.java
//
// Solution to interview problem 1, resources (French, faked)
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
 * ResourceBundle class containing 'French' PII used by the 
 * xmlAddmeSum class. Currently just the English strings with 
 * '(Not yet translated to fr): ' prepended. :-)
 * 
 * @version 0.1
 */
public class xmlAddmeSumResources_fr extends ListResourceBundle
{
    protected Object[][] getContents() 
    {
        return new Object[][]
        {
             // LOCALIZE THE SECOND STRING OF EACH ARRAY
             {"ADDME00001", "(Not yet translated to fr): Initializing xmlAddmeSum instance."},
             {"ADDME00002", "(Not yet translated to fr): Creating Document from xml string:"},
             {"ADDME00003", "(Not yet translated to fr): Creating Document from xml file \"{0}\""},
             {"ADDME00004", "(Not yet translated to fr):   Node Value = {0,number,0.0}"},
             {"ADDME00005", "(Not yet translated to fr):   Sum = {0,number,0.0}"},
             {"ERR_ADDME00001", "(Not yet translated to fr): Error: creating DOM builder."},
             {"ERR_ADDME00002", "(Not yet translated to fr): Error: parsing input xml."},
             {"ERR_ADDME00003", "(Not yet translated to fr): Error: Cannot parse float from current node string (\"{0}\")."},
             {"ERR_ADDME00004", "(Not yet translated to fr): Error: Value in this node not added to sum!"}
             // END OF MATERIAL TO LOCALIZE
        };
    }
}
