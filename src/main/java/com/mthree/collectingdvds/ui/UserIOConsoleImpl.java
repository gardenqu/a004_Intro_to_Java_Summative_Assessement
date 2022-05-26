/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.collectingdvds.ui;


/**
 *
 * @author Quanayzia Garden
 * Filename: UserIOConsoleImpl.java
 * Date: May 26,2022
 * Class: a004 Intro To Java
 * Description: 
 * Class that implements the UserIo interface. Add functionality to the methods defined in the interface. 
 */

import java.util.Scanner;



public class UserIOConsoleImpl implements UserIO{
    private Scanner console = new Scanner(System.in);
    
    
    
    /**
 *Function: print
 * 
 * Description:
 * prints out a string message
 *  
 * 
     * @param msg
 */

    @Override
    public void print(String msg) {
        System.out.println(msg);
        
    }
    
 /**
 *Function: print
 * 
 * Description:
 * prints message. uses returned input and converts it into an integer then returns the value. If input is invalid it return an error message 
 *  
 * 
     * @param prompt
     * @return int
 */

    @Override
    public int readInt(String prompt) {
        boolean invalidInput = true;
        int num = 0;
        while (invalidInput) {
            try {
              
                String stringValue = this.readString(prompt);
               
                num = Integer.parseInt(stringValue); 
                invalidInput = false; 
            } catch (NumberFormatException e) {
                // If it explodes, it'll go here and do this.
                this.print("Input error. Please try again.");
            }
        }
        return num;
        
    }
    
    
     /**
 *Function: readInt
 * 
 * Description:
 *  This function prompts the user and takes the return input and checks if it between the min and max values. 
 *  
 * 
 * @param prompt
 * @param min
 * @param max
 * @return int  
 */

    @Override
    public int readInt(String prompt, int min, int max) 
    {
                int result;
        do {
            result = readInt(prompt);
        } while (result < min || result > max);

        return result;
    }
    
    
     /**
 *Function: readString
 * 
 * Description:
 * prints out the param string to the console and returns a new line. 
 * 
 *  
 * 
 * @param prompt
 * @return 
 */

  
    @Override
    public String readString(String prompt) 
    {
        System.out.println( prompt);
        return console.nextLine();
        
    }
    
    
}
