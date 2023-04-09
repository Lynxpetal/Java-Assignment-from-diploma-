
package hotelsystemassignment;

import java.io.File;
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class RoomReserve {
    private String roomType;
    private String roomNumber;
    private double roomPrice;
    private String roomAvailable;
     
    
    public RoomReserve(String roomType, String roomNumber, double roomPrice, String roomAvailable) {
        this.roomType = roomType;
        this.roomNumber = roomNumber;
        this.roomPrice = roomPrice;
        this.roomAvailable = roomAvailable;
    }

    public RoomReserve(String roomType, double roomPrice)
    {
        this.roomType = roomType;
        this.roomPrice = roomPrice;
    }
    
    public String getRoomType() {
        return roomType;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public double getRoomPrice() {
        return roomPrice;
    }
    
    public String getRoomAvailable() {
        return roomAvailable;
    }
    
    public RoomReserve()
    {
        
    }
    
    /*declare*/
    private Scanner x;
   
    public void readFile(RoomReserve[] roomArr){
    try{                 //open file
          x = new Scanner(new File("C:\\Users\\2002c\\OneDrive\\Desktop\\test.txt"));
              
    }
    catch(Exception e){
          System.out.println("Error ! Could not find the file.");
    }
       
    int lineNoForRoom = 0, j = 0;
    
       
    while(x.hasNext()){      //do while loop - read file content
           String roomType = x.next();
           String roomNumber = x.next();
           double roomPrice = x.nextDouble();
           String roomAvailable = x.next();
           
           roomArr[j] = new RoomReserve(roomType, roomNumber, roomPrice, roomAvailable);
           
  
           System.out.printf("%-3d   %-12s\n", ++lineNoForRoom, roomNumber);
           j++;

       }
       
       x.close();       //close file
       
    }
   
    public static int checkRoomNumber(String roomNo, RoomReserve[] roomArr) {
       int existSearchRecord = 0;
       int roomAvailability = 0;
       
       for(int k = 0; k < roomArr.length; k++)
       {  

           if(roomNo.compareTo(roomArr[k].roomNumber) == 0)
           {
               existSearchRecord++;             //count of search record
               if((roomArr[k].roomAvailable).compareTo("Yes")== 0)
               {
                   roomAvailability = 1;
                   
               }
               else
                   roomAvailability = 0;
           }

       }
       

       //If room number doesn't find in the text file
       if(existSearchRecord == 0)
       {
           roomAvailability = 2;
       }

       
       if(roomAvailability == 0)
       {
            return roomAvailability;
       }
       else if(roomAvailability == 1)
       {
            return roomAvailability;
       }
       else
           return roomAvailability;
       
           
       
       
    }

}
