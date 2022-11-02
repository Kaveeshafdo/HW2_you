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

    static int floor = 3;
    static int row = 7;
    static int col = 7;
    public static Vehicle[][][] slots = new Vehicle[floor][row][col];

    public Vehicle[][][] getSlots() {
        return slots;
    }

    public void setSlots(Vehicle[][][] slots) {
        this.slots = slots;
    }

    public static boolean isOccupied(int floor, int row, int col) {
        if (slots[floor][row][col] == null) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        //CarParking cp = new CarParking();
        Vehicle v = new Vehicle();
        v.setType("SUV");
        v.setEntryTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        slots[2][2][2] = v;
        isOccupied(2, 2, 2);
        //cp.isOccupied(3, 2, 2);
    }

    public static void add(Vehicle v) {
        int floor = 0;
        int row = 0;
        int col = 0;

        for (floor = 0; floor < CarParking.floor; floor++) {
            for (row = 0; row < CarParking.row; row++) {
                for (col = 0; col < CarParking.col; col++) {
                    if (isOccupied(floor, row, col)) {
                        slots[floor][row][col] = v;
                    }
                }
            }
        }
    }

    public double remove(int floor, int row, int col, double rate) {

        Vehicle v = slots[floor][row][col];
        double dur = v.getDuration(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant())) / 60000;
        double fee = dur * rate;
        if (floor != 0) {
            fee = fee - (fee * 5 / 100);
        }
        slots[floor][row][col] = null;
        return fee;
    }

    public double getTotalExpectedRevenue(double[] rates, Date exitTime) {
        return 0;
    }

    public int getVehicleCount() {
        return 0;
    }

    public double getRevenue(String type, int floor, double rate) {
        return 0;
    }

    public boolean canOrganizeByType() {
        return false;
    }
}
