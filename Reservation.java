
package hotelsystemassignment;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private String checkInDate;
    private String checkOutDate;
    private long totalDaysReserved;

    private static Date dayV, dayL;
    
    public Reservation() {
        
    }
    
    public Reservation(String checkInDate, String checkOutDate, long totalDaysReserved)
    {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalDaysReserved = totalDaysReserved;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public long getTotalDaysReserved() {
        return totalDaysReserved;
    }
    
    public Date getDOV() {
        return dayV;
    }
    
    public Date getDOL() {
        return dayL;
    }
 
    public void setDOV(Date dayV) {
        this.dayV = dayV;
    }
    
    public void setDOL(Date dayL) {
        this.dayL = dayL;
    }
    
    public void setTotalDays(long totalDaysReserved) {
        this.totalDaysReserved = totalDaysReserved;
    }
    
    public static boolean isValidCheckInOutDate(String date, int alternate) {
        Reservation reservation = new Reservation();
        
        boolean condition = true;
        Date date1;
        Date date2 = new Date();
        
        SimpleDateFormat check = new SimpleDateFormat("dd/MM/yyyy");
        
        check.setLenient(false);
        
        try {
            date1 = check.parse(date);
            
        }catch (ParseException pe) {
            System.out.println(pe.getMessage());
            condition = false;
            return condition;
            
        }
        
        if(alternate == 0) {
                if(date1.after(date2)) {
                    System.out.println("Date registered");
                    reservation.setDOV(date1);
                    
                }
                else {
                    System.out.println("Invalid data entered");
                    condition = false;
                    
                }
        }
        
        if(alternate == 1) {
                date2 = reservation.getDOV();
                if(date1.after(date2)) {
                     System.out.println("Date registered");
                     reservation.setDOL(date1);
                     
                }
                else {
                     System.out.println("Noted -> Check Out Date must be after Check In Date.");
                     condition = false;
                     
                }         
        }
        
        return condition;
 
    }
    
    public static long calculateDaysReserved(String checkInDate, String checkOutDate) throws ParseException {
            Reservation reservation = new Reservation();
            
            SimpleDateFormat check = new SimpleDateFormat("dd/MM/yyyy");
            Date dateCheckIn = check.parse(checkInDate);
            Date dateCheckOut = check.parse(checkOutDate);
            long timeDifference;
            long daysDifference;
            
           
            timeDifference = dateCheckOut.getTime() - dateCheckIn.getTime();
            
            daysDifference = TimeUnit.MILLISECONDS.toDays(timeDifference)%365; 
            
            return daysDifference;
            
    }
    
    public String toString() {
        return String.format("%-20s   %-20s   %-3d", checkInDate, checkOutDate, totalDaysReserved);
    }
}       
