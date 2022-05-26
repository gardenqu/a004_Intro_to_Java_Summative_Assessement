/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.collectingdvds.dao;

import com.mthree.collectingdvds.dto.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Quanayzia Garden
 * Filename: CollectingDvdsDaoImpl.java
 * Date: May 26,2022
 * Class: a004 Intro To Java
 * Description: 
 * Implementation file for the Dao. Add the functionality to the defined methods. 
 */


public class CollectingDvdsDaoFileImpl implements CollectingDvdsDao {
    private  List<Dvd> dvds=new ArrayList<>();
    public static final String COLLECTION_FILE = "DvdCollection.txt";
    public static final String DELIMITER = "#";
    

    
    
/**
 *Function: addDvd 
 * 
 * Description:
 * adds a new DVD object to the list
 *  
 * @param newDvd
 * @throws com.mthree.collectingdvds.dao.CollectingDvdsDaoException
 */
    @Override
    public void addDvd(Dvd newDvd) throws CollectingDvdsDaoException  
    {
        loadCollection();
        dvds.add(newDvd);
        writeCollection();
 
    }
    
    
    /**
 *Function: getAllDvds
 * 
 * Description:
 * Returns the list of DVDs
 * 
 * @return  List<Dvd>
 * @throws com.mthree.collectingdvds.dao.CollectingDvdsDaoException
 */

    @Override
    public List<Dvd> getAllDvds() throws CollectingDvdsDaoException {
        loadCollection();
        return dvds;
    }
    
    /**
 *Function: getDvdbyTitle
 * 
 * Description:
 *  Loops through the DVD list. Tries to match the title string with a DVD title. 
 *  
 * 
 * @param title
 * @return Dvd
 * @throws com.mthree.collectingdvds.dao.CollectingDvdsDaoException
 */

    @Override
    public Dvd getDvdbyTitle(String title) throws CollectingDvdsDaoException 
    {
         loadCollection();
       for(Dvd dvd: dvds)
       {
           if(dvd.getTitle().equals(title))
           {
               return dvd;
           }
           
       }
       return null;
    }
    
/**
 *Function: removeDvd
 * 
 * Description:
 * removes the DVD from the list of DVDs. returns true if the DVD is removed. Returns false if it has not
 *  
 * 
 * @param dvd
 * @return  bool
 * @throws com.mthree.collectingdvds.dao.CollectingDvdsDaoException
 */
       
    @Override
    public boolean removeDvd(Dvd dvd) throws CollectingDvdsDaoException 
    {
              
                boolean bool =dvds.remove(dvd);
          
                writeCollection();
                return bool;
                
                

    }
    
    
    /**
 *Function: unmarshallDvd 
 * 
 * Description:
 * Breaks a string via delimiters into a string array. Uses the string array to create a DVD object and return it. 
 *  
 * @param text
 * 
 */
    
    private Dvd unmarshallDvd(String text)
    {
       
        String[] fileDvd=text.split(DELIMITER);
        
    // creates DVD object
        Dvd dvdFromFile = new Dvd(fileDvd[0],fileDvd[1],fileDvd[2],fileDvd[3],fileDvd[4],fileDvd[5]);
        
        
        return dvdFromFile;
        
    }
    
    /**
 *Function: loadCollection
 * 
 * Description:
 * reads the file line by line. That data is unmarshalled and return as a DVD. the DVD is stored into a Set then into a List. 
 *  The scanner is closes once all the objects have been created and stored into a list. 
 * 
 * @throws com.mthree.collectingdvds.dao.CollectingDvdsDaoException
 */
    
    private void loadCollection() throws CollectingDvdsDaoException{
        Scanner scanner;

    try {
        // Create Scanner for reading the file
        scanner = new Scanner(
                new BufferedReader(
                        new FileReader(COLLECTION_FILE)));
    } catch (FileNotFoundException e) {
        throw new CollectingDvdsDaoException(
                "Could not load DVD collection data into memory.", e);
    }
    
    
    String currentLine;
    // creats a Set that will be used to store the DVD objects. this is done to prevent dubplicate objects from being stored. 
    Set<Dvd> hold= new HashSet<>();
   
    Dvd currentDvd;
    
    while (scanner.hasNextLine()) 
    {
        // get the next line in the file
        currentLine = scanner.nextLine();
        //System.out.println(currentLine);
        // unmarshall the line into a Dvd
        currentDvd=unmarshallDvd(currentLine);
      // DVD is first stored in a Set
        hold.add(currentDvd);
       // Then the DVD are places stored in a list
        dvds=new ArrayList(hold);
        
        
      
    }
      scanner.close();
    
    }
    
    
    /**
 *Function: marshallDvd 
 * 
 * Description:
 *  Takes the DVD information and stored it in a string with delimters added to it
 * 
 *  
 * @param aDvd
 * @return String
 * @throws com.mthree.collectingdvds.dao.CollectingDvdsDaoException
 */
    private String marshallDvd(Dvd aDvd){
        String DvdAsText = aDvd.getTitle() + DELIMITER;
        DvdAsText += aDvd.getDirectorName() + DELIMITER;
        DvdAsText += aDvd.getMPAARating() + DELIMITER;
        DvdAsText += aDvd.getReleaseDate() + DELIMITER;
        DvdAsText += aDvd.getStudio() + DELIMITER;
        DvdAsText += aDvd.getUserRating();
        return  DvdAsText;
        
    }
    
    /**
 *Function: writeCollection
 * 
 * Description:
 * Writes the DVD information to a file to be stored. Then closes the connection to the file. 
 *  
 * 
 * @throws com.mthree.collectingdvds.dao.CollectingDvdsDaoException
 */
    
    private void writeCollection() throws CollectingDvdsDaoException {
        PrintWriter out;
        
        try {
        out = new PrintWriter(new FileWriter(COLLECTION_FILE));
    } catch (IOException e) {
        throw new CollectingDvdsDaoException(
                "Could not save student data.", e);
    }
        String DvdAsText;
        List<Dvd> DvdList = this.getAllDvds();
        for(Dvd dvd: DvdList){
            DvdAsText=marshallDvd(dvd);
           
            out.println(DvdAsText);
            out.flush();
        }
        out.close();
        
    }
    
   
}
