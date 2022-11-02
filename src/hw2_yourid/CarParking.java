/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2_yourid;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author Chandramal
 */
public class CarParking {

    int floor = 3;
    int row = 7;
    int col = 7;
    public Vehicle[][][] slots = new Vehicle[floor][row][col];

    public Vehicle[][][] getSlots() {
        return slots;
    }

    public void setSlots(Vehicle[][][] slots) {
        this.slots = slots;
    }

    public void showSlots() {
        for (Vehicle[][] m : slots) {
            System.out.print("[");
            for (Vehicle[] a : m) {
                System.out.print("[");
                for (Vehicle n : a) {
                    if (n != null) {
                        System.out.print(n.getType() + " ");
                    } else {
                        System.out.print(" ");
                    }// printing each item
                }
                System.out.print("]");
            }
            System.out.print("]\n");
        }
    }

    public int emptySlots(int floor) {
        int count = 0;
        int row = 0;
        int col = 0;
        for (row = 0; row < this.row; row++) {
            for (col = 0; col < this.col; col++) {
                if (slots[floor][row][col] == null) {
                    count = count + 1;
                }
            }
        }
        return count;
    }

    public boolean isOccupied(int floor, int row, int col) {
        if (slots[floor][row][col] == null) {
            return false;
        } else {
            return true;
        }
    }

    public void add(Vehicle v) {
        int floor = 0;
        int row = 0;
        int col = 0;

        for (floor = 0; floor < this.floor; floor++) {
            for (row = 0; row < this.row; row++) {
                for (col = 0; col < this.col; col++) {
                    if (!isOccupied(floor, row, col)) {
                        slots[floor][row][col] = v;
                        floor = this.floor;
                        row = this.row;
                        col = this.col;
                    }
                }
            }
        }
        showSlots();
    }

    public double remove(int floor, int row, int col, double rate) {
        double fee = 0;
        Vehicle v = slots[floor][row][col];
        double dur = v.getDuration(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant())) / 60000;
        fee = dur * rate;
        if (floor != 0) {
            fee = fee - (fee * 5 / 100);
        }
        slots[floor][row][col] = null;
        showSlots();
        return fee;
    }

    public double getTotalExpectedRevenue(double[] rates, Date exitTime) {
        int floor = 0;
        int row = 0;
        int col = 0;
        double rev = 0;
        for (floor = 0; floor < this.floor; floor++) {
            for (row = 0; row < this.row; row++) {
                for (col = 0; col < this.col; col++) {
                    if (isOccupied(floor, row, col)) {
                        double fee = 0;
                        Vehicle v = slots[floor][row][col];
                        double dur = v.getDuration(exitTime) / 60000;
                        double rate = 0;
                        switch (v.getType()) {
                            case "Sedan":
                                rate = rates[0];
                                break;
                            case "SUV":
                                rate = rates[1];
                                break;
                            case "Truck":
                                rate = rates[2];
                                break;
                        }
                        fee = dur * rate;
                        if (floor != 0) {
                            fee = fee - (fee * 5 / 100);
                        }
                        rev = rev + fee;
                        //slots[floor][row][col] = v;
                    }
                }
            }
        }
        return rev;
    }

    public int getVehicleCount(String type, int floor) {
        int count = 0;
        int row = 0;
        int col = 0;
        for (row = 0; row < this.row; row++) {
            for (col = 0; col < this.col; col++) {
                if (isOccupied(floor, row, col)) {
                    if (slots[floor][row][col].getType().equals(type)) {
                        count = count + 1;
                    }
                }
            }
        }
        return count;
    }

    public double getRevenue(String type, int floor, double rate) {
        double rev = 0;
        int row = 0;
        int col = 0;
        for (row = 0; row < this.row; row++) {
            for (col = 0; col < this.col; col++) {
                if (isOccupied(floor, row, col)) {
                    if (slots[floor][row][col].getType().equals(type)) {
                        Vehicle v = slots[floor][row][col];
                        double dur = v.getDuration(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant())) / 60000;
                        double fee = dur * rate;
                        if (floor != 0) {
                            fee = fee - (fee * 5 / 100);
                        }
                        rev = rev + fee;
                    }
                }
            }
        }
        return rev;
    }

    public boolean canOrganizeByType() {
        int floor = 0;
        int row = 0;
        int col = 0;

        for (floor = 0; floor < this.floor; floor++) {
            for (row = 0; row < this.row; row++) {
                for (col = 0; col < this.col; col++) {
                    if (isOccupied(floor, row, col)) {
                        if (slots[floor][row][col].getType().equals("Sedan")) {

                        }
                    }
                }
            }
        }
        return false;
    }
}
