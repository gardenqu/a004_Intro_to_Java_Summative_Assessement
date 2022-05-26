/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.collectingdvds.dto;

/**
 *
 * @author nay
 */
public class Dvd {
      private String title;
      private String MPAArating;
      private String releaseDate;
      private String directorName;
      private String studio;
      private String userRating;
      
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
