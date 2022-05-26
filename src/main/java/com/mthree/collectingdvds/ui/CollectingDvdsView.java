/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.collectingdvds.ui;

import com.mthree.collectingdvds.dto.Dvd;
import java.util.List;

/**
 *
 * @author Quanayzia Garden
 * Filename: CollectingDvdsView.java
 * Date: May 26,2022
 * Class: a004 Intro To Java
 * Description: 
 *The View: Responsible for interacting with the UI. No other component in the application is allowed to interact with the user 
 */




public class CollectingDvdsView {

    private UserIO io;

    
     /**
 *Function: CollectindDvdsView  
 * 
 * Description:
 *  This a constructor that initializes the UserIO
 * 
 *@param io  
 * 
 */
    public CollectingDvdsView(UserIO io) 
    {
        this.io = io;

    }

   
    
    
 /**
 * Function:  printMenuAndGetSelection
 * 
 * Description:
 *  Prints the menu for the user to see and allows the user to select from the menu 
 * 
 * @return int 
 *        
 */
    public int printMenuAndGetSelection() 
    {
        io.print("Main Menu");
        io.print("1. List DVDs");
        io.print("2. Add DVD to collection");
        io.print("3. View a DVD by title");
        io.print("4. Edit DVD");
        io.print("5. Remove a DVD");
        io.print("6. Exit");

        return io.readInt("Please select from the"
                + " above choices.", 1, 6);
    }
    
    
    
    
 /**
 * Function:  getNewDvdInfo
 * 
 * Description:
 *  Asks the user to input information about the DVD and uses that information to create a Dvd object
 * 
 * @param: none 
 * 
 * @return Dvd 
 *        
 */

    public Dvd getNewDvdInfo() 
    {
        String title = io.readString("Please enter movie title");
        String director = io.readString("Please enter the movie director ");
        String MPAARating = io.readString("Please enter in movie MPAA rating");
        String date = io.readString("Please enter in the date the movie was released");
        String studio = io.readString("Please enter in the studio the movie is from");
        String userRating = io.readString("Please enter in how you would rate the movie");

        //String title,String contentRating, String date,String studio,String rating
        Dvd newDvd = new Dvd(title, director, MPAARating, date, studio, userRating);
        return newDvd;

    }
    
    /**
 * Function:  displayAddDvdBanner
 * 
 * Description:
 *  Displays a banner for the user to see 
 *
 *        
 */
    public void displayAddDvdBanner() 
    {
        io.print("=== Add DVD ===");
    }
    
    /**
 * Function:  displayAddSuccessBanner
 * 
 * Description:
 *  Displays a banner for the user to see 
 *
 *        
 */

    public void displayAddSuccessBanner() {
        io.readString(
                "DVD successfully Added.  Please hit enter to continue");
    }
    
    
    /**
 * Function:  displayDvdList
 * 
 * Description:
 *  Displays a list of Dvds to the user
 *
 * @param dvdList
 * 
 *        
 */

    public void displayDvdList(List<Dvd> dvdList) 
    {

        for (Dvd dvd : dvdList) 
        {
            String dvdInfo = String.format("#%s: %s, %s, %s, %s, %s",
                    dvd.getTitle(),
                    dvd.getDirectorName(),
                    dvd.getMPAARating(),
                    dvd.getReleaseDate(),
                    dvd.getStudio(),
                    dvd.getUserRating());

            io.print(dvdInfo);

        }
        io.readString("Please hit enter to continue.");

    }
    
/**
 * Function:  displayDisplayAllBanner
 * Description:
 *  Displays a banner for the user to see 
 *
 *        
 */
    public void displayDisplayAllBanner() 
    {
        io.print("=== Display All DVDs ===");
    }
    
    
/**
 * Function:  displayDisplayDvdBanner
 * Description:
 *  Displays a banner for the user to see 
 */
    public void displayDisplayDvdBanner() {
        io.print("=== Display DVD ===");
    }
/**
 * Function:  getDVDByName
 * Description:
 *  Prompts the user to enter in a Dvd title then returns the user input as a string
 *
 *        
 * @return String 
 */
    public String getDVDByName() 
    {
        return io.readString("Please enter the DVD title.");

    }
    
 /**
 * Function:  displayDVD
 * Description:
 * Displays information for a specified DVD to the user. If the DVD is not found it will notify the user
 *
 *        
 * @param dvd
 */

    public void displayDVD(Dvd dvd) 
    {

        if (dvd != null)
        {

            String dvdInfo = String.format("#%s: %s, %s, %s %s, %s",
                    dvd.getTitle(),
                    dvd.getDirectorName(),
                    dvd.getMPAARating(),
                    dvd.getReleaseDate(),
                    dvd.getStudio(),
                    dvd.getUserRating());

            io.print(dvdInfo);
            io.print("");
        } else {
            io.print("DVD is not in the List.");
        }
        io.readString("Please hit enter to continue.");
    }
/**
 * Function:  displayRemoveDVDBanner
 * Description:
 *  Displays a banner for the user to see 
 */
    public void displayRemoveDVDBanner() {
        io.print("=== Remove Dvd ===");
    }
    
    /**
 * Function:  displayRemoveResult
 * Description:
 * Lets the user know if the specified DVD was removed from the list. If it is not then the DVD was not in the list
 *
 *        
 * @param dvd
 */

    public void displayRemoveResult(boolean dvd) 
    {
        
        if (dvd) 
        {
            io.print("DVD successfully removed.");
        } else {
            io.print("DVD is not in list.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    
    
    
     /**
 * Function:  editDVDResults
 * Description:
 * If the Dvd specified by the user is in the list this function will allow the user to edit that Dvd. It allows the user to 
 * to use a menu to select what they would like to change and prompts them for input. That input is then stored used the Dvds setter functions. 
 *
 *        
 * @param dvd
 * @return Dvd
 */
    public Dvd editDVDResult(Dvd dvd) 
    {
        boolean exit = false;

        if (dvd != null) 
        {
            while (!exit) 
            {
                int selection = displayEditMenu();

                switch (selection) {
                    case 1:
                        dvd.setTitle(io.readString("Please enter movie title"));
                        io.print(" ");
                        io.print("Edited title");
                        break;
                    case 2:
                        dvd.setReleaseDate(io.readString("Please enter in the date the movie was released(mm/dd/yyyy)"));
                        io.print(" ");
                        io.print("Edited Release date");
                        break;
                    case 3:
                        dvd.setMPAARating(io.readString("Please enter in movie MPAA rating"));
                        io.print(" ");
                        io.print("Edited MPAA rating");
                        break;

                    case 4:
                        dvd.setDirectorName(io.readString("Please enter in the name of the movie director"));
                        io.print(" ");
                        io.print("Edited MPAA rating");
                        break;
                    case 5:
                        dvd.setStudio(io.readString("Please enter in the studio the movie is from"));
                        io.print(" ");
                        io.print("Edited studio");
                        break;

                    case 6:
                        dvd.setUserRating(io.readString("Please enter in you rating of the movie"));
                        io.print(" ");
                        io.print("Edited MPAA rating");
                        break;

                    case 7:
                        exit = true;
                        break;
                    default:
                        io.print("UNKNOWN COMMAND");

                }

            }
            return dvd;

        } 
        return null;

    }
    
    
    
    
     /**
 * Function:  displayEditMenu
 * Description:
 * Prints the menu for the user to see and allows the user to select from the menu 
 *
 *        
 *
 * @return int 
 */
    public int displayEditMenu() 
    {
        io.print("1). Edit the Title");
        io.print("2). Edit the Release date");
        io.print("3). Edit the MPAA rating");
        io.print("4). Edit the Director's name");
        io.print("5). Edit the Studio");
        io.print("6). Edit the User rating");
        io.print("7). Exiting out of Editor");

        return io.readInt("Please select from the"
                + " above choices.", 1, 7);

    }

    /**
 * Function:  displayEditedDvdBanner
 * Description:
 *  Displays a banner for the user to see 
 */
    public void displayEditingDVDBanner() 
    {
        io.print("===DVD Editing ===");
    }
    /**
 * Function:  displayDisplayExitBanner
 * Description:
 *  Displays a banner for the user to see 
 */

    public void displayExitBanner() 
    {
        io.print("Good Bye!!!");
    }
/**
 * Function:  displayUnknownCommandBanner
 * Description:
 *  Displays a banner for the user to see 
 */
    public void displayUnknownCommandBanner() 
    {
        io.print("Unknown Command!!!");
    }
/**
 * Function:  displayErrorMessage
 * Description:
 *  prints out an Error message when a user inputs a incorrect value 
 * @param errorMsg
 */
    public void displayErrorMessage(String errorMsg)
    {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
