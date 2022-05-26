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
 * @author nay
 */
public class App {

    public static void main(String[] args) throws CollectingDvdsDaoException {
        UserIO myIo = new UserIOConsoleImpl();
        CollectingDvdsView myView= new CollectingDvdsView(myIo);
        CollectingDvdsDao myDao= new CollectingDvdsDaoFileImpl();
        CollectingDvdsController controller= new CollectingDvdsController(myView,myDao);
        controller.run();
       
    }
}
