/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mthree.collectingdvds;

import com.mthree.collectingdvds.controller.CollectingDvdsController;
import com.mthree.collectingdvds.dao.CollectingDvdsDao;
import com.mthree.collectingdvds.dao.CollectingDvdsDaoException;
import com.mthree.collectingdvds.dao.CollectingDvdsDaoFileImpl;
import com.mthree.collectingdvds.ui.CollectingDvdsView;
import com.mthree.collectingdvds.ui.UserIO;
import com.mthree.collectingdvds.ui.UserIOConsoleImpl;

/**
 *
 * @author Quanayzia Garden
 * Filename: App.java
 * Date: May 26,2022
 * Class: a004 Intro To Java
 * Description: 
 * This application allows the user to add,edit,and delete Dvds in a collection. 
 */
public class App {
    
    /**
 *Function: main  
 * 
 * Description: The main function is the first method that gets invoked.This main function is used
 to initialize the USERIO and the CollectingDvdsDao interfaces as well as to intitialize  the CollectingDvdsView and the CollectingDvdsController classes. It also runs the controllers run method to start up the functionality of the application. 
 * 
 *@param args  
 * 
 * @throws com.mthree.collectingdvds.dao.CollectingDvdsDaoException 
 * 
 * 
 * 
 */

    public static void main(String[] args) throws CollectingDvdsDaoException {
        UserIO myIo = new UserIOConsoleImpl();
        CollectingDvdsView myView= new CollectingDvdsView(myIo);
        CollectingDvdsDao myDao= new CollectingDvdsDaoFileImpl();
        CollectingDvdsController controller= new CollectingDvdsController(myView,myDao);
        controller.run();
       
    }
}
