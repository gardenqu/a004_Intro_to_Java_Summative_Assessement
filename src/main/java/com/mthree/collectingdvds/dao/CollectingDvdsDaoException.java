/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.collectingdvds.dao;

/**
 *
 * @author Quanayzia Garden
 * Filename: CollectingDvdsDao.java
 * Date: May 26,2022
 * Class: a004 Intro To Java
 * Description: 
 * Exceptions handling class for the Dao
 */
public class CollectingDvdsDaoException extends Exception {
    
    public CollectingDvdsDaoException(String message) {
        super(message);
    }
    
    public CollectingDvdsDaoException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
