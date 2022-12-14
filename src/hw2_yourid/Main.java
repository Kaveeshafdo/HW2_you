/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hw2_yourid;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class Main {

    static Vehicle v;
    static CarParking cp = new CarParking();
    static double rates[] = new double[3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean keepGoing = true;
        int menuItem;
        System.out.println("Please input vehicle rates : ");
        System.out.print("Rate for Sedans : ");
        rates[0] = sc.nextInt();
        System.out.print("Rate for SUVs : ");
        rates[1] = sc.nextInt();
        System.out.print("Rate for Trucks : ");
        rates[2] = sc.nextInt();

        while (keepGoing) {
            System.out.println("Please select an option from the menu:");
            System.out.println("1. Add a vehicle");
            System.out.println("2. Remove a vehicle");
            System.out.println("3. Display statistics");
            System.out.println("4. Check arrangement");
            System.out.println("5. Exit the program");

            menuItem = sc.nextInt();

            if (menuItem == 1) {
                System.out.println("Select a type");
                System.out.println("1. Sedan");
                System.out.println("2. Suv");
                System.out.println("3. Truck");
                int type = sc.nextInt();
                if (type == 1) {
                    v = new Vehicle("Sedan");
                    cp.add(v);
                    System.out.println("Sedan Vehicle Added");
                } else if (type == 2) {
                    v = new Vehicle("SUV");
                    cp.add(v);
                    System.out.println("Suv Vehicle Added");
                } else if (type == 3) {
                    v = new Vehicle("Truck");
                    cp.add(v);
                    System.out.println("Truck Vehicle Added");
                }
            } else if (menuItem == 2) {
                System.out.println("Please input vehicle location : ");
                System.out.print("floor of location : ");
                int floor = sc.nextInt();
                System.out.print("row of location : ");
                int row = sc.nextInt();
                System.out.print("col of location : ");
                int col = sc.nextInt();
                double rate = 0;
                Vehicle v;
                if (cp.isOccupied(floor, row, col)) {
                    v = cp.slots[floor][row][col];

                    if (cp.slots[floor][row][col].getType().equals("Sedan")) {
                        rate = rates[0];
                    } else if (cp.slots[floor][row][col].getType().equals("SUV")) {
                        rate = rates[1];
                    } else if (cp.slots[floor][row][col].getType().equals("Truck")) {
                        rate = rates[2];
                    }
                    System.out.print("Fee is : " + cp.remove(floor, row, col, rate) + ".");
                    System.out.println("Location : Floor=" + floor + ", Row=" + row + ", Column=" + col + ". " + v.getType() + " Vehicle is removed.");
                } else {
                    System.out.println("No vehicles found on given location.");
                }
            } else if (menuItem == 3) {
                System.out.println("Select Option");
                System.out.println("1. Total expected revenue");
                System.out.println("2. Number of sedans, SUVs and trucks per floor");
                System.out.println("3. Revenue of sedans, SUVs and trucks per floor");
                System.out.println("4. Number of empty slots per floor");
                int statistics = sc.nextInt();
                if (statistics == 1) {
                    System.out.println("Total Expected Revenue is : " + cp.getTotalExpectedRevenue(rates, Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant())));
                } else if (statistics == 2) {
                    System.out.println("Vehicle Counts");

                    System.out.println("sedans on first floor = " + cp.getVehicleCount("Sedan", 0));
                    System.out.println("Suv on first floor = " + cp.getVehicleCount("SUV", 0));
                    System.out.println("Truck on first floor = " + cp.getVehicleCount("Truck", 0));

                    System.out.println("sedans on second floor = " + cp.getVehicleCount("Sedan", 1));
                    System.out.println("Suv on second floor = " + cp.getVehicleCount("SUV", 1));
                    System.out.println("Truck on second floor = " + cp.getVehicleCount("Truck", 1));

                    System.out.println("sedans on third floor = " + cp.getVehicleCount("Sedan", 2));
                    System.out.println("Suv on third floor = " + cp.getVehicleCount("SUV", 2));
                    System.out.println("Truck on third floor = " + cp.getVehicleCount("Truck", 2));
                } else if (statistics == 3) {
                    System.out.println("Vehicle Revenues");
                    System.out.println("Revenue of First floor Sedans = " + cp.getRevenue("Sedan", 0, rates[0]));
                    System.out.println("Revenue of Second floor Sedans = " + cp.getRevenue("Sedan", 1, rates[0]));
                    System.out.println("Revenue of Third floor Sedans = " + cp.getRevenue("Sedan", 2, rates[0]));

                    System.out.println("Revenue of First floor SUV = " + cp.getRevenue("SUV", 0, rates[1]));
                    System.out.println("Revenue of Second floor SUV = " + cp.getRevenue("SUV", 1, rates[1]));
                    System.out.println("Revenue of Third floor SUV = " + cp.getRevenue("SUV", 2, rates[1]));

                    System.out.println("Revenue of First floor Truck = " + cp.getRevenue("Truck", 0, rates[2]));
                    System.out.println("Revenue of Second floor Truck = " + cp.getRevenue("Truck", 1, rates[2]));
                    System.out.println("Revenue of Third floor Truck = " + cp.getRevenue("Truck", 2, rates[2]));
                } else if (statistics == 4) {
                    for (int i = 0; i < 3; i++) {
                        System.out.println("Number of empty slots " + i + " floor = " + cp.emptySlots(i));
                    }
                }

            } else if (menuItem == 4) {
                System.out.println("Can organize or not");
                //int check = sc.nextInt();
                if (cp.canOrganizeByType()) {
                    System.out.println("1. Cars can be arranged based on their type");
                } else {
                    System.out.println("2. Not possible to rearrange cars based on their type.");
                }
            } else if (menuItem == 5) {
                System.exit(0);
            }
        }

    }
}
