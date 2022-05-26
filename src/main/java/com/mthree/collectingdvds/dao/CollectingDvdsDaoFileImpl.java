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
 * @author nay
 */
public class CollectingDvdsDaoFileImpl implements CollectingDvdsDao {
    private  List<Dvd> dvds=new ArrayList<>();
    public static final String COLLECTION_FILE = "DvdCollection.txt";
    public static final String DELIMITER = "#";
    

    @Override
    public void addDvd(Dvd newDvd) throws CollectingDvdsDaoException  {
        
        
        loadCollection();
      
        dvds.add(newDvd);
        writeCollection();
 
    }

    @Override
    public List<Dvd> getAllDvds() throws CollectingDvdsDaoException {
        loadCollection();
        return dvds;
    }

    @Override
    public Dvd getDvdbyTitle(String title) throws CollectingDvdsDaoException {
         loadCollection();
       for(Dvd dvd: dvds){
           if(dvd.getTitle().equals(title)){
               return dvd;
         
           }
           
       }
       return null;
    }
    
//    @Override
//    public int getNumOfDvdsWithSameTitle(String title) throws CollectingDvdsDaoException{
//      
//        
//        int dvdCount=0;
//        for (Dvd dvd : dvds) {
//            if(dvd.getTitle().equals(title)){
//                loadCollection();
//                dvdCount++;
//            }
//        }
//        return dvdCount;
        
    //}
//    @Override
//    public Dvd getDvdbyTitleAndDirector(String title, String director) throws CollectingDvdsDaoException{
//         
//        for(int i=0;i<dvds.size();i++){
//           if(dvds.get(i).getTitle().equals(title) && dvds.get(i).getDirectorName().equals(director)){
//               loadCollection();
//               return dvds.get(i);
//           }
//           
//       }
//         return null;
//    }
    
       
    @Override
    public boolean removeDvd(Dvd dvd) throws CollectingDvdsDaoException {
                //loadCollection();
                
                
                boolean bool =dvds.remove(dvd);
                
               
                writeCollection();
                return bool;
                
                

    }
    private Dvd unmarshallDvd(String text){
        
        String[] fileDvd=text.split(DELIMITER);
        //String fileDvd = DvdTokens[0];
    
        Dvd dvdFromFile = new Dvd(fileDvd[0],fileDvd[1],fileDvd[2],fileDvd[3],fileDvd[4],fileDvd[5]);
        
        
        return dvdFromFile;
        
    }
    
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
    
    
    Set<Dvd> hold= new HashSet<>();
   
    Dvd currentDvd;
    
    while (scanner.hasNextLine()) {
        // get the next line in the file
        currentLine = scanner.nextLine();
        //System.out.println(currentLine);
        // unmarshall the line into a Dvd
        currentDvd=unmarshallDvd(currentLine);
        
        
        hold.add(currentDvd);
        
        dvds=new ArrayList(hold);
        
        
      
    }
      scanner.close();
    
    }
    
    private String marshallDvd(Dvd aDvd){
        String DvdAsText = aDvd.getTitle() + DELIMITER;
        DvdAsText += aDvd.getDirectorName() + DELIMITER;
        DvdAsText += aDvd.getMPAARating() + DELIMITER;
        DvdAsText += aDvd.getReleaseDate() + DELIMITER;
        DvdAsText += aDvd.getStudio() + DELIMITER;
        DvdAsText += aDvd.getUserRating();
        return  DvdAsText;
        
    }
    
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
