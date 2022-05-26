/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mthree.collectingdvds.ui;

/**
 *
 * @author Quanayzia Garden
 * Filename: UserIO.java
 * Date: May 26,2022
 * Class: a004 Intro To Java
 * Description: 
 * The interface for the UI. Alow for user to interact with the application. 
 */
public interface UserIO {
    
    void print(String msg);
    int readInt(String prompt);
    int readInt(String prompt, int min, int max);
    String readString(String prompt);
}
   
