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
 *
 * @author nay
 */
public class CollectingDvdsController {
    
    
     private final CollectingDvdsView view;
     private final CollectingDvdsDao dao ;
     
     
 public CollectingDvdsController(CollectingDvdsView v,CollectingDvdsDao d){
     this.dao=d;
     this.view=v;
 }

    public void run() throws CollectingDvdsDaoException {
        boolean keepGoing = true;
        int menuSelection=0;
        
        
      
        try{
            while (keepGoing) {
         
          
           menuSelection = getMenuSelection();

            switch (menuSelection) {
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
        }catch(CollectingDvdsDaoException e){
            view.displayErrorMessage(e.getMessage());
        }
               
    }
    
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void addingDvd()throws CollectingDvdsDaoException {
    view.displayAddDvdBanner();
    Dvd newDvd = view.getNewDvdInfo();
    dao.addDvd(newDvd);
    view.displayAddSuccessBanner();
}
    
    
    private void listDvds()throws CollectingDvdsDaoException{
        view.displayDisplayAllBanner();
        List<Dvd> list=dao.getAllDvds();
        view.displayDvdList(list);
    }
    
    private void viewDvdByTitle()throws CollectingDvdsDaoException{
        
        String title=view.getDVDByName();
        view.displayDisplayDvdBanner();
        view.displayDVD(dao.getDvdbyTitle(title));
        
    }
    
    private void removeDvd()throws CollectingDvdsDaoException {
       String title=view.getDVDByName();
        Dvd selectedDvd=dao.getDvdbyTitle(title);
        
        view.displayRemoveResult(dao.removeDvd(selectedDvd));
  
       
        

    //view.displayRemoveResult(dao.removeDvd(dao.getDvdbyTitle(title)));
    
}
    
    private void editDVD()throws CollectingDvdsDaoException{
        
        view.displayEditedDVDBanner();
        String title=view.getDVDByName();
        Dvd selectedDvd=dao.getDvdbyTitle(title);
        Dvd edited=view.editDVDresult(selectedDvd);
        
        if(edited != null){
            dao.removeDvd(selectedDvd);
            dao.addDvd(edited);
            
            
            view.displayDVD(edited);
        }else{
            view.displayDVD(selectedDvd);
        }
        
        
        
       
        
        
    }
    
//    private Dvd returnDvdSelection()throws CollectingDvdsDaoException{
//        Dvd selectedDVD;
//        String title=view.getDVDByName();
//        
//        if(dao.getNumOfDvdsWithSameTitle(title)>1){
//            String director=view.getDVDByDirector();
//            selectedDVD=dao.getDvdbyTitleAndDirector(title, director);
//        }else{
//            selectedDVD= dao.getDvdbyTitle(title);
//        }
//        
//        return selectedDVD;
//    }
    
    private void unknownCommand() {
    view.displayUnknownCommandBanner();
}

private void exitMessage() {
    view.displayExitBanner();
}


}


