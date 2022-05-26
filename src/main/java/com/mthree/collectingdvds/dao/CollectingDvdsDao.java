/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mthree.collectingdvds.dao;

import com.mthree.collectingdvds.dto.Dvd;
import java.util.List;

/**
 *
 * @author nay
 */
public interface CollectingDvdsDao {
    
    public void addDvd(Dvd newDvd) throws CollectingDvdsDaoException;
    public List<Dvd> getAllDvds()throws CollectingDvdsDaoException;
    public Dvd getDvdbyTitle(String title) throws CollectingDvdsDaoException;
    //public Dvd getDvdbyTitleAndDirector(String title, String year) throws CollectingDvdsDaoException;
//    public int getNumOfDvdsWithSameTitle(String title) throws CollectingDvdsDaoException;
    public boolean removeDvd(Dvd dvd) throws CollectingDvdsDaoException;
   
    
}
