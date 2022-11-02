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

    public static Vehicle[][][] slots = new Vehicle[3][7][7];

    public Vehicle[][][] getSlots() {
        return slots;
    }

    public void setSlots(Vehicle[][][] slots) {
        this.slots = slots;
    }
    
    public static void isOccupied(int floor, int row, int col){
        if(slots[floor][row][col] == null){
            System.out.println("index is null");
            
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
    
    public static void add(){
        
    }
}
