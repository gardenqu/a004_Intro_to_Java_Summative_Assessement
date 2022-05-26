/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mthree.collectingdvds.dao;

import com.mthree.collectingdvds.dto.Dvd;
import java.util.List;

/**
 *
 * @author Quanayzia Garden
 * Filename: CollectingDvdsDao.java
 * Date: May 26,2022
 * Class: a004 Intro To Java
 * Description: 
 * The Dao ( Data access object) interface : classes that handle retrieving and storing the data
 */
public interface CollectingDvdsDao {
    
    
   
    
    public void addDvd(Dvd newDvd) throws CollectingDvdsDaoException;
    public List<Dvd> getAllDvds()throws CollectingDvdsDaoException;
    public Dvd getDvdbyTitle(String title) throws CollectingDvdsDaoException;
    public boolean removeDvd(Dvd dvd) throws CollectingDvdsDaoException;
   
    
}
