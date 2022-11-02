/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hw2_yourid;

import java.util.Scanner;

public class Main {
    static Vehicle v;
    static CarParking cp = new CarParking();
    static double rates[] = new double[3];

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
                    System.out.println("Select a type");
                    System.out.println("1. Sedan");
                    System.out.println("2. Suv");
                    System.out.println("3. Truck");
                    int type = sc.nextInt();
                    switch (type) {
                        case 1:
                            v = new Vehicle("Sedan");
                            cp.add(v);
                            break;

                        case 2:

                            break;

                        case 3:

                            break;
                    }

                    break;
                case 2:
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("Select Option");
                    System.out.println("1. Total expected revenue");
                    System.out.println("2. Number of sedans, SUVs and trucks per floor");
                    System.out.println("3. Revenue of sedans, SUVs and trucks per floor");
                    System.out.println("4. Number of empty slots per floor");
                    int statistics = sc.nextInt();
                    switch (statistics) {
                        case 1:

                            break;

                        case 2:

                            break;

                        case 3:

                            break;
                        case 4:

                            break;
                    }
                    break;
                case 4:
                    System.out.println("Select Option");
                    System.out.println("1. Cars can be arranged based on their type");
                    System.out.println("2. Not possible to rearrange cars based on their type.");
                     int check = sc.nextInt();
                    switch (check) {
                        case 1:

                            break;

                        case 2:

                            break;

                      
                    }
                    break;
                case 5:
                    System.exit(0);
                    break;

            }
        }

    }
}
