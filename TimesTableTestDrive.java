/**
 *
 * Author:     Jason Angus
 * File:       TimesTableTestDrive.java
 * Last Edit:  09/10/2010
 */


public class TimesTableTestDrive {
   public static void main (String[] args) {
      TimesTable myTables = new TimesTable();
      Menu myMenu = new Menu();

      // main program loop here...
      while(true) {
         myMenu.displayMenu();
         myMenu.getMenuSelection();
         myMenu.goGoGO();
      } // end while
   }  // close main method
} // close TimesTableTestDrive class
