/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hw2_yourid;

import java.util.Scanner;

/**
 *
 * @author Chandramal
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean keepGoing = true;
        int menuItem;
        while (keepGoing) {
            System.out.println("Please select an option from the menu:");
            System.out.println("1. Add a vehicle");
            System.out.println("2. Remove a vehicle");
            System.out.println("3. Display statistics");
            System.out.println("4. Check arrangement");
            System.out.println("5. Exit the program");

            menuItem = sc.nextInt();
            switch (menuItem) {
                case 1:
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("");
                    break;
                case 4:
                    System.out.println("");
                    break;
                case 5:
                   System.exit(1);
                    
                    break;

            }
        }

    }
}
