
package hotelsystemassignment;

import java.util.*;
import java.util.Scanner;
import java.util.Date;


public class ReservationDetails {
    private Reservation reservation;
    private RoomType roomType;
    private int quantity;
    private double subtotal;
    
    private static int lineNoForReservationDetails = 0;

  
    public ReservationDetails() {
        
    }
    
    public ReservationDetails(Reservation reservation, RoomType roomType, int quantity)
    {
        this.reservation = reservation;
        this.roomType = roomType;
        this.quantity = quantity;
        lineNoForReservationDetails++;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public double getRoomPriceBasedOnType(){
        double price = 0.0;
        
        if(roomType.getRoomType().compareTo("Single") == 0) {
                price = roomType.getRoomPrice();
                
        }
        else if(roomType.getRoomType().compareTo("Double") == 0) {
                  price = roomType.getRoomPrice();
                
        }
        else {
                  price = roomType.getRoomPrice();
        }
        
        return price;
    }
    
    public double getSubtotal() {
        return getRoomPriceBasedOnType() * quantity * reservation.getTotalDaysReserved();
        
    }
      
    
    public String toString() {
        return String.format("%-15s  %-15s  %-10d  %-10s  %-10.2f  %-8d  %-10.2f",reservation.getCheckInDate(), reservation.getCheckOutDate(),reservation.getTotalDaysReserved(), roomType.getRoomType(), roomType.getRoomPrice(), quantity, getSubtotal());
    }
    
}
