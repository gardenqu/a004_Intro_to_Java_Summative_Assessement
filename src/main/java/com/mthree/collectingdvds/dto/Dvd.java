/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.collectingdvds.dto;

/**
 *
 * @author Quanayzia Garden
 * Filename: Dvd.java
 * Date: May 26,2022
 * Class: a004 Intro To Java
 * Description: 
 * the Model : model comprises all the components in the application that deal with representing and storing data. Many of the function are getter/setter
 * functions that allow the object information to stored or retrieved  without having direct access to the member variables 
 * */
public class Dvd {
      private String title;
      private String MPAArating;
      private String releaseDate;
      private String directorName;
      private String studio;
      private String userRating;
      
      
      
      
       /**
 *Function: Dvd
 * 
 * Description:
 *  constructor that initializes the title,director,MPAA rating,date,studio,and user rating. 
 *  
 *
     * @param title
     * @param director
     * @param contentRating
     * @param date
     * @param studio
     * @param rating
 */
      
       public Dvd(String title,String director,String contentRating, String date,String studio,String rating){
          this.title=title;
          this.directorName=director;
          this.MPAArating=contentRating;
          this.releaseDate=date; 
          this.studio=studio;
          this.userRating=rating;
      }
       

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }
      
     
     

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMPAARating() {
        return MPAArating;
    }

    public void setMPAARating(String contentRating) {
        this.MPAArating = contentRating;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String release) {
        this.releaseDate = release;
    }
     
      
      
    
    
}
