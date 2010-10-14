/**
 *  Some code to provide menu displaying for
 *    TimesTables program... :)
 * Author:     Jason Angus
 * File:       Menu.java
 * Last Edit:  10/10/2010
 */

import java.util.*;


public class Menu {

   private int menuSelection = 0;
   public static final int MENU_MAX = 3;
   public static final int MENU_MIN = 1;
   private boolean validChoice = false;

   public void displayMenu() {
      System.out.println("Times Tables Tester!");
      System.out.println("1. Single Times Table");
      System.out.println("2. All Times Tables");
      System.out.println("3. Exit");
      System.out.println("");
   } // close displayMenu method

   public void getMenuSelection() {
      Scanner in = new Scanner(System.in);
      int choice = 0;
      
      System.out.print("Make a Selection: ");
      if (in.hasNextInt()) 
         choice = in.nextInt();
         
      switch (choice)
      {
         case 3: case 2: case 1:
            this.validChoice = true;
            this.menuSelection = choice;
            break;
         default:
            this.validChoice = false;
            System.out.println("\nERROR: Not a valid choice!");
      }
      return;
   } // close  getMenuSelection method

   public void goGoGO() {
      if ( this.validChoice ) {
         if (this.menuSelection == 1) {
            goChoice1();
         } // close option 1
         else if (this.menuSelection == 2) {
            goChoice2();
         } // close option 2
         else if (this.menuSelection == 3) {
            goChoice3();
         }
      } // close outer if
   } // close goGoGO method

   public void goChoice1() {
      // ask user for the table they want to test then do it!
      while (true) {
         System.out.println("Single Times Tables! - Menu Item #1\n");
         System.out.print("Enter table to attempt (1 - 12), or zero to quit: ");
         Scanner in = new Scanner(System.in);
         int choice = 0;
         if (in.hasNextInt()) // Confirm user has entered an integer.
            choice = in.nextInt();
         else
            System.out.println("\nERROR: Invalid choice!\n");
         if (choice == 0)
            break;
         else if (choice >= TimesTable.TABLE_MIN &&
                  choice <= TimesTable.TABLE_MAX) {
            TimesTable myTable = new TimesTable(choice);
            System.out.println("You chose " + choice + " times table");
            int tries = 0;
            for (int i=TimesTable.TABLE_MIN; i<=TimesTable.TABLE_MAX; i++) {
               int answer = -1;
               do {
                  myTable.displaySum(i);
                  
                  // Check for integer input
                  if (in.hasNextInt()) {
                     answer = in.nextInt();
                     in.nextLine(); // Throw away the buffer
                     ++tries;
                  }
                  else {
                     System.out.println("\nERROR: Not an integer!!\n");
                     in.nextLine(); // Throw away the buffer
                  }
               } while (answer != myTable.getSum(i));
            } // end for
            System.out.printf("Great! You took %d goes!\n", tries);
         } else {
            System.out.println("Thats gotta be a table between 1 and 12 you Ninny!");
         } // end else
      } // end while
   } // close goChoice1 method

   public void goChoice2() {
      // throw random problems at the user until they've had enough
      System.out.println("You chose All Times Tables!! - menu #2");
   } // close goChoice2 method

   public void goChoice3() {
      System.out.println("You chose Exit!!! - menu #3");
      System.out.println("Goodbye then!");
      System.exit(0);
   } // close goChoice3 method
} // close Menu class

