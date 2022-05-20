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
      private String contentRating;
      private int releaseYear;
      
      public Dvd(String title, int year){
          this.title=title;
          this.releaseYear=year;
          
      }
      public Dvd(String title,String contentRating,int year){
          this.title=title;
          this.contentRating=contentRating;
          this.releaseYear=year;  
      }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentRating() {
        return contentRating;
    }

    public void setContentRating(String contentRating) {
        this.contentRating = contentRating;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
     
      
      
    
    
}
