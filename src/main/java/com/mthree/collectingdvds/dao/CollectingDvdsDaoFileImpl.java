/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.collectingdvds.dao;

import com.mthree.collectingdvds.dto.Dvd;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nay
 */
public class CollectingDvdsDaoFileImpl implements CollectingDvdsDao {
    private final List<Dvd> dvds= new ArrayList<>();

    @Override
    public void addDvd(Dvd newDvd) {
        dvds.add(newDvd);
  
    }

    @Override
    public List<Dvd> getAllDvds() {
        return dvds;
    }

    @Override
    public Dvd getDvdbyTitle(String title) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Dvd removeDvd(String title) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
