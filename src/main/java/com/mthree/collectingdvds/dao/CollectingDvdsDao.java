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
    
    public void addDvd(Dvd newDvd);
    public List<Dvd> getAllDvds();
    public Dvd getDvdbyTitle(String title);
    public Dvd removeDvd(String title);
    
}
