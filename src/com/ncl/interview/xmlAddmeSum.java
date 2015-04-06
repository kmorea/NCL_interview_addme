//***************************************************************************
// xmlAddmeSum.java
//
// Solution to interview test problem 1, sum 'addme' elements in XML string.
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
// 04/05/15  000002     KM   PII separation, build.xml, JUnit testcases.
//***************************************************************************

package com.ncl.interview;

import java.util.*;
import java.io.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.text.MessageFormat;

/**
 * Main class that is used for summing 'addme' elements in a 
 * given XML string of file.
 * 
 * @version 0.1
 */
public class xmlAddmeSum
{
    protected static ResourceBundle         addmeResources;
    private          DocumentBuilderFactory factory;
    private          DocumentBuilder        builder;

    /**
     * Constructor 
     */
    public xmlAddmeSum ()
    {
        // Load reasource bundle
        // tmp - forcing to fr_FR locale to pick up faked 'fr' bundle for testing
        /*tmp*/System.out.println("tmp - Loading fr_FR resource bundle!");
        addmeResources = ResourceBundle.getBundle("com.ncl.interview.xmlAddmeSumResources", new Locale("fr","FR"));
        System.out.println(addmeResources.getString("ADDME00001"));

        // create DOM factory and builder
        try
        {
            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
        }
        catch (Exception e) 
        {
            System.err.println(addmeResources.getString("ERR_ADDME00001"));
            e.printStackTrace();
        }
    }

    /**
     * XML String sum - 
     * Creates a Document from String, then calls the sum(Document) method to do actual sum 
     * @param  xml  A string containing the xml with 'addme's to sum
     * @return      The float sum
     */
    public float sum (String xml)
    {
        // Create Document from xml string
        System.out.println(""); 
        System.out.println(addmeResources.getString("ADDME00002"));
        System.out.println(xml+"\n"); 

        try 
        {
            Document xmlDOMDoc = builder.parse(new ByteArrayInputStream(xml.getBytes("UTF-8")));
            return sum (xmlDOMDoc);
        } 
        catch (Exception e) 
        {
            System.err.println(addmeResources.getString("ERR_ADDME00002"));
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * XML File sum - 
     * Creates a Document from File, then calls the sum(Document)
     * method to do actual sum
     * @param  xmlFile  A File containing the xml with 'addme's to 
     *                  sum
     * @return          The float sum
     */ 
    public float sum (File xmlFile)
    {
        // Creating Document from xml file
        System.out.println(""); 
        System.out.println(MessageFormat.format(addmeResources.getString("ADDME00003"), (String) xmlFile.getAbsolutePath()));
        System.out.println(""); 
        try 
        {
            Document xmlDOMDoc = builder.parse(xmlFile);
            return sum (xmlDOMDoc);
        } 
        catch (Exception e) 
        {
            System.err.println(addmeResources.getString("ERR_ADDME00002"));
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * XML Document sum -                       
     * The 'real' summing work takes place here 
     * @param  xmlDOMDoc  A DOM Document with 'addme's to sum 
     * @return          The float sum
     */ 
    protected float sum (Document xmlDOMDoc)
    {
        float xmlSum = 0;
        float nodeValue = 0;

        try 
        {
            // get list of 'addme' nodes in the doc
            NodeList addmes = xmlDOMDoc.getElementsByTagName("addme");

            // Iterate over the 'addme's, summing them up
            for (int i = 0; i < addmes.getLength(); i++)
            {
                Node addme = addmes.item(i);
                try 
                {
                    nodeValue = Float.parseFloat(addme.getTextContent());
                    System.out.println(MessageFormat.format(addmeResources.getString("ADDME00004"), new Double(nodeValue)));
                    System.out.println(nodeValue);
                    xmlSum+=nodeValue;
                } 
                catch (NumberFormatException nfe) 
                {
                    System.out.println(MessageFormat.format(addmeResources.getString("ERR_ADDME00003"), (String) addme.getTextContent()));
                    System.err.println(addmeResources.getString("ERR_ADDME00004"));
                }
            }
            System.out.println(MessageFormat.format(addmeResources.getString("ADDME00005"), xmlSum));
        } 
        catch (Exception e) 
        {
            System.err.println(addmeResources.getString("ERR_ADDME00002"));
            e.printStackTrace();
        }
        return xmlSum;
    }
}
