/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.collectingdvds.controller;

import com.mthree.collectingdvds.dao.CollectingDvdsDao;
import com.mthree.collectingdvds.dao.CollectingDvdsDaoException;
import com.mthree.collectingdvds.dto.Dvd;
import com.mthree.collectingdvds.ui.CollectingDvdsView;
import java.util.List;

/**
 *@author Quanayzia Garden
 * Filename: CollectingDvdsController.java
 * Date: May 26,2022
 * Class: a004 Intro To Java
 * Description: 
 * The controller: The controller orchestrates the actions of the other components in the application in a way that accomplishes the application's goals.
 */
public class CollectingDvdsController {
    
    
     private final CollectingDvdsView view;
     private final CollectingDvdsDao dao ;
     
     
     
 /**
 *Function: CollectindDvdsView  
 * 
 * Description:
 *  This a constructor that initializes the CollectindDvdsView and CollectindDvdsdao
 * 
 * 
 * 
 * @param view
 * @param dao
 */
     
 public CollectingDvdsController(CollectingDvdsView view,CollectingDvdsDao dao)
 {
     this.dao=dao;
     this.view=view;
 }

 
 /**
 *Function: run 
 * 
 * Description:
 *  Making use of a switch-case this function allows the user selection to implement an action. Will throw an exception if input is incorrect 
 * 
 * @throws com.mthree.collectingdvds.dao.CollectingDvdsDaoException
 */
     
    public void run() throws CollectingDvdsDaoException 
    {
        boolean keepGoing = true;
        int menuSelection=0;
        
        
      
        try
        {
            
            while (keepGoing) 
            {
         
          
           menuSelection = getMenuSelection();

                switch (menuSelection) 
                {
                    case 1:
                        listDvds();
                        break;
                    case 2:
                        addingDvd();
                        break;
                    case 3:
                        viewDvdByTitle();
                        break;

                    case 4:editDVD();

                        break;
                    case 5:
                        removeDvd();
                        break;

                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
 
            }
            exitMessage();
        }catch(CollectingDvdsDaoException e)
        {
            view.displayErrorMessage(e.getMessage());
        }
               
    }
    
    
 /**
 *Function: getMenuSelection  
 * 
 * Description:
 *  displays the menu and return the user selection 
 * @params int
 * 
 */
     
    private int getMenuSelection() 
    {
        return view.printMenuAndGetSelection();
    }
    
    
 /**
 *Function: addingDvd 
 * 
 * Description:
 *  Displays the AddDvdBannerc collects the user input and uses it to create a DVD object. That DVD object is then stored in a list and a success banner is displayed   
 * 
 */
    private void addingDvd()throws CollectingDvdsDaoException 
    {
        view.displayAddDvdBanner();
        Dvd newDvd = view.getNewDvdInfo();
        dao.addDvd(newDvd);
        view.displayAddSuccessBanner();
    }
    /**
 *Function: listDvds  
 * 
 * Description:
 *  Displays a banner then displays  a list of all of the DVDs.  
 * 
 */
    private void listDvds()throws CollectingDvdsDaoException
    {
        view.displayDisplayAllBanner();
        List<Dvd> list=dao.getAllDvds();
        view.displayDvdList(list);
    }
    
    /**
 *Function: viewDvdByTitle 
 * 
 * Description:
 *  Takes user input, finds the DVD title matching that input, then displays it. 
 * 
 */
    private void viewDvdByTitle()throws CollectingDvdsDaoException
    {
        
        String title=view.getDVDByName();
        view.displayDisplayDvdBanner();
        view.displayDVD(dao.getDvdbyTitle(title));
        
    }
    
    
    /**
 *Function: removeDvd  
 * 
 * Description:
 *  Takes user input. Finds the DVD matching the user input. removes that DVD from the list of DVDs. Then displays a success banner if the 
 * DVD is found and removed. 
 * 
 * 
 */
  
    private void removeDvd()throws CollectingDvdsDaoException 
    {
       String title=view.getDVDByName();
        Dvd selectedDvd=dao.getDvdbyTitle(title);
        
        view.displayRemoveResult(dao.removeDvd(selectedDvd));
  
       
    }
    
    
    
    
    /**
 *Function: editDVD  
 * 
 * Description:
 * Editing banner is displayed. Takes user input. Finds the DVD matching the user input. If the DVD is in the list of DVDs it takes the users input and creates a DVD using that input. The old DVD is replaced with the edited version. 
 *  Displays edited DVD information. If the DVD is not found then it displays a message letting the user now that the DVD was not found. 
 * @params int
 * 
 */
   
    
    private void editDVD()throws CollectingDvdsDaoException
    {
        
        view.displayEditingDVDBanner();
        String title=view.getDVDByName();
        Dvd selectedDvd=dao.getDvdbyTitle(title);
        Dvd edited=view.editDVDResult(selectedDvd);
        
        // If the edited DVD is null it means that it was not found in the list and cannot be edited.
        if(edited != null)
        {
            //removes the orginal DVD and adds the edited version of that same DVD. thus replacing the old with the new. 
            dao.removeDvd(selectedDvd);
            dao.addDvd(edited);
            
            
            view.displayDVD(edited);
        }else
        {
            view.displayDVD(selectedDvd);
        }
    }
    
/**
 * Function:  unknownCommand
 * Description:
 *  Displays a banner from the view for the user to see 
 *
 *        
 */
    
    private void unknownCommand() 
    {
        view.displayUnknownCommandBanner();
    }
    
    /**
 * Function:  exitMessage
 * Description:
 * Displays a banner from the view for the user to see 
 *
 *        
 */

    private void exitMessage() 
    {
        view.displayExitBanner();
    }


}


