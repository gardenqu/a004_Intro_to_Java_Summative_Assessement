/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.collectingdvds.ui;

import com.mthree.collectingdvds.dto.Dvd;
import java.util.List;

/**
 *
 * @author nay
 */
public class CollectingDvdsView {
    
    private UserIO io = new UserIOConsoleImpl();
    
        public int printMenuAndGetSelection() {
            io.print("Main Menu");
            io.print("1. List DVDs");
            io.print("2. Add DVD to collection");
            io.print("3. View a DVD by title");
            io.print("4. Remove a DVD");
            io.print("5. Exit");

            return io.readInt("Please select from the"
                    + " above choices.", 1, 5);
        }
        
        public Dvd getNewDvdInfo(){
            String title=io.readString("Please enter movie title");
            String cRating=io.readString("Please enter in movie content rating");
            String year=io.readString("Please eneter in the year the movie was released");
            int releaseYear=Integer.parseInt(year);
            
            Dvd newDvd= new Dvd(title,cRating,releaseYear);
            return newDvd;
       
        }
    public void displayAddDvdBanner() {
    io.print("=== Add DVD ===");
}
    public void displayAddSuccessBanner() {
    io.readString(
            "Dvd successfully Added.  Please hit enter to continue");
}
    
    
    public void displayDvdList(List<Dvd> dvdList){
        
        for(Dvd dvd:dvdList){
            String dvdInfo= String.format("#%s : %s %s",
              dvd.getTitle(),
              dvd.getReleaseYear(),
              dvd.getContentRating());
             io.print(dvdInfo);
        
        }
        io.readString("Please hit enter to continue.");
           
    }
    
    public void displayDisplayAllBanner() {
    io.print("=== Display All Dvds ===");
}
}
