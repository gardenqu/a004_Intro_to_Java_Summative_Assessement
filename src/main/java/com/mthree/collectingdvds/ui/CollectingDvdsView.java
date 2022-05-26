/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.collectingdvds.ui;

import com.mthree.collectingdvds.dto.Dvd;
import java.util.List;

/**
 *
 * @author nay
 */
public class CollectingDvdsView {

    private UserIO io;

    public CollectingDvdsView(UserIO io) {
        this.io = io;

    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List DVDs");
        io.print("2. Add DVD to collection");
        io.print("3. View a DVD by title");
        io.print("4. Edit DVD");
        io.print("5. Remove a DVD");
        io.print("6. Exit");

        return io.readInt("Please select from the"
                + " above choices.", 1, 6);
    }

    public Dvd getNewDvdInfo() {
        String title = io.readString("Please enter movie title");
        String director = io.readString("Please enter the movie director ");
        String MPAARating = io.readString("Please enter in movie MPAA rating");
        String date = io.readString("Please enter in the date the movie was released");
        String studio = io.readString("Please enter in the studio the movie is from");
        String userRating = io.readString("Please enter in how you would rate the movie");

        //String title,String contentRating, String date,String studio,String rating
        Dvd newDvd = new Dvd(title, director, MPAARating, date, studio, userRating);
        return newDvd;

    }

    public void displayAddDvdBanner() {
        io.print("=== Add DVD ===");
    }

    public void displayAddSuccessBanner() {
        io.readString(
                "Dvd successfully Added.  Please hit enter to continue");
    }

    public void displayDvdList(List<Dvd> dvdList) {

        for (Dvd dvd : dvdList) {
            String dvdInfo = String.format("#%s: %s, %s, %s %s, %s",
                    dvd.getTitle(),
                    dvd.getDirectorName(),
                    dvd.getMPAARating(),
                    dvd.getReleaseDate(),
                    dvd.getStudio(),
                    dvd.getUserRating());

            io.print(dvdInfo);

        }
        io.readString("Please hit enter to continue.");

    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All DVDs ===");
    }

    public void displayDisplayDvdBanner() {
        io.print("=== Display DVD ===");
    }

    public String getDVDByName() {
        return io.readString("Please enter the DVD title.");

    }

    public String getDVDByDirector() {
        return io.readString("Please enter the name of the  movie director.");
    }

    public void displayDVD(Dvd dvd) {

        if (dvd != null) {

            String dvdInfo = String.format("#%s: %s, %s, %s %s, %s",
                    dvd.getTitle(),
                    dvd.getDirectorName(),
                    dvd.getMPAARating(),
                    dvd.getReleaseDate(),
                    dvd.getStudio(),
                    dvd.getUserRating());

            io.print(dvdInfo);
//        io.print(dvd.getTitle());
//        io.print(dvd.getDirectorName());
//        io.print(dvd.getMPAARating());
//        io.print(dvd.getReleaseDate());
//        io.print(dvd.getStudio());
//        io.print(dvd.getUserRating());
            io.print("");
        } else {
            io.print("DVD is not in the List.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveDVDBanner() {
        io.print("=== Remove Dvd ===");
    }

    public void displayRemoveResult(boolean dvd) {
        
        if (dvd) {
            io.print("DVD successfully removed.");
        } else {
            io.print("DVD is not in list.");
        }
        io.readString("Please hit enter to continue.");
    }

    public Dvd editDVDresult(Dvd dvd) {
        boolean exit = false;

        if (dvd != null) {
            while (!exit) {
                int selection = displayEditMenu();

                switch (selection) {
                    case 1:
                        dvd.setTitle(io.readString("Please enter movie title"));
                        io.print(" ");
                        io.print("Edited title");
                        break;
                    case 2:
                        dvd.setReleaseDate(io.readString("Please enter in the date the movie was released(mm/dd/yyyy)"));
                        io.print(" ");
                        io.print("Edited Release date");
                        break;
                    case 3:
                        dvd.setMPAARating(io.readString("Please enter in movie MPAA rating"));
                        io.print(" ");
                        io.print("Edited MPAA rating");
                        break;

                    case 4:
                        dvd.setDirectorName(io.readString("Please enter in the name of the movie director"));
                        io.print(" ");
                        io.print("Edited MPAA rating");
                        break;
                    case 5:
                        dvd.setStudio(io.readString("Please enter in the studio the movie is from"));
                        io.print(" ");
                        io.print("Edited studio");
                        break;

                    case 6:
                        dvd.setUserRating(io.readString("Please enter in you rating of the movie"));
                        io.print(" ");
                        io.print("Edited MPAA rating");
                        break;

                    case 7:
                        exit = true;
                        break;
                    default:
                        io.print("UNKNOWN COMMAND");

                }

            }
            return dvd;

        } 
        return null;

    }

    public int displayEditMenu() {
        io.print("1). Edit the Title");
        io.print("2). Edit the Release date");
        io.print("3). Edit the MPAA rating");
        io.print("4). Edit the Director's name");
        io.print("5). Edit the Studio");
        io.print("6). Edit the User rating");
        io.print("7). Exiting out of Editor");

        return io.readInt("Please select from the"
                + " above choices.", 1, 7);

    }

    public void displayEditedDVDBanner() {
        io.print("===Dvd Edited ===");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
