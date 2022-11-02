/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hw2_yourid;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author Chandramal
 */
public class Vehicle {
    private String type;
    private Date entryTime;
    
    public Vehicle(String type){
        this.type = type;
        entryTime = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }
    
    public double getDuration(Date exitTime){
        return (exitTime.getTime() - entryTime.getTime());
    }
    
    enum type{
       Sedan,SUV,Truck
    }
}
