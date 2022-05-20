/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.collectingdvds.controller;

import com.mthree.collectingdvds.dao.CollectingDvdsDao;
import com.mthree.collectingdvds.dao.CollectingDvdsDaoFileImpl;
import com.mthree.collectingdvds.dto.Dvd;
import com.mthree.collectingdvds.ui.CollectingDvdsView;
import com.mthree.collectingdvds.ui.UserIO;
import com.mthree.collectingdvds.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author nay
 */
public class CollectingDvdsController {
     private CollectingDvdsView view= new CollectingDvdsView();
     private UserIO io = new UserIOConsoleImpl();
     private CollectingDvdsDao dao = new CollectingDvdsDaoFileImpl();
 

    public void run() {
        boolean keepGoing = true;
        int menuSelection=0;
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
                    io.print("VIEW DVD");
                    break;
                case 4:
                    io.print("REMOVE DVD");
                    break;
                case 5:
                    keepGoing = false;
                    break;
                default:
                    io.print("UNKNOWN COMMAND");
            }

        }
        io.print("GOOD BYE");
    }
    
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void addingDvd() {
    view.displayAddDvdBanner();
    Dvd newDvd = view.getNewDvdInfo();
    dao.addDvd(newDvd);
    view.displayAddSuccessBanner();
}
    
    
    private void listDvds(){
        view.displayDisplayAllBanner();
        List<Dvd> list=dao.getAllDvds();
        view.displayDvdList(list);
    }
}
