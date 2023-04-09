
/*https://stackoverflow.com/questions/33035213/room-booking-program*/
package hotelsystemassignment;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Scanner;

public class HotelSystemAssignment {

    
       public static void paymentModule(int reservation)
       {
            Scanner inputPayment = new Scanner(System.in);
            Payment[] payArr = new Payment[10];
            CreditCardPayment[] creditArr = new CreditCardPayment[30];
            CashPayment[] cashArr = new CashPayment[30];
            int method;
            double paymentAmount;
            String expDate;
            String cardNo;
       
       
            for(int i = 0; i < reservation; i++)
            {
                System.out.print("\n");
                System.out.printf("Payment %d\n", i+1);
                System.out.printf("%9s\n", "---------");
             
                System.out.print("Payment Amount : ");
                paymentAmount = inputPayment.nextDouble(); 
             
                System.out.print("\n");
                System.out.println(" -------------------------------------------------------------------------- ");
                System.out.println("| 2 types of payment method : Credit Card (1) or Cash (2)                  |");
                System.out.println("| Please input 1 if would like to use credit card or input 2 if using cash |");
                System.out.println(" -------------------------------------------------------------------------- ");
                System.out.print("\n");
                System.out.print("Payment Method : ");
             
             
             do
             { 
                 method = inputPayment.nextInt();
                    
                if(method == 1)                         //Credit Card Type
                { 
                        System.out.print("\nEnter your card holder name : ");
                        String name = inputPayment.next();
                    

                    do
                    {
                        System.out.print("\nEnter expire date of your card  (EX: MM/YYYY): ");
                        expDate = inputPayment.next();
                    
                
                        if(CreditCardPayment.validateCreditExpiryDate(expDate) == true)
                        {
                           System.out.println("Card with expiry Date " + expDate +" is valid.\n");

                        }
                        else 
                        {
                           System.out.println("Card with expiry Date " + expDate +" is invalid as it expires.\n");
                           System.out.println("Please enter again. ");

                        }
                    
                    }while(CreditCardPayment.validateCreditExpiryDate(expDate) == false);
                    
                    
                    do
                    {
                        System.out.print("Enter your card number ( in 16 digits ) : ");
                    
                        cardNo = inputPayment.next();
                    
                        if(CreditCardPayment.validateCreditCardNumber(cardNo) == true)      //check whether card number is valid or not 
                        {
                            System.out.println(cardNo + " number is valid.\n");
                            
                        }
                        else 
                        {
                            System.out.println(cardNo + " number is invalid.\n");
                            System.out.println("Please enter again. ");
                            
                        }
                        
                    }while(CreditCardPayment.validateCreditCardNumber(cardNo) == false);
                           
                    if(CreditCardPayment.validateCreditExpiryDate(expDate) == true && CreditCardPayment.validateCreditCardNumber(cardNo) == true)
                    {
                        creditArr[i] = new CreditCardPayment(paymentAmount, name, expDate, cardNo);
                        
                    }
                
                }
                    else if(method == 2)                    //Cash Type
                    {
                         cashArr[i] = new CashPayment(paymentAmount);
                    }
                    else                                    
                    {
                         System.out.println("Error ! Please enter again. ");
                         System.out.println(" -------------------------------------------------------------------------- ");
                         System.out.println("| 2 types of payment method : Credit Card (1) or Cash (2)                  |");
                         System.out.println("| Please input 1 if would like to use credit card or input 2 if using cash |");
                         System.out.println(" -------------------------------------------------------------------------- ");
                         System.out.println("\n");
                         
                    }
                    
             } while(method < 1 || method > 2);
 
       }
       
       /* 
       double grandTotal = 0;
       System.out.printf("%10s %-15s %-15s %-15s %-15s\n","Payment ID", "Payment Method", "Payment Date", "Payment Time", "Payment Amount");
       for(int j = 0; j < payment; j++)
       {
           System.out.println(payArr[j].toString());
           grandTotal += payArr[j].getPaymentAmount();
       }
       System.out.printf("%65s\n","-------------------------------------------------------------------------");
       System.out.printf("%58s RM%.2f\n", "Grand Total :", grandTotal);
       */
       
       
    }
        
        
       
       public static void reserveModule(RoomReserve[] roomArr) throws ParseException
       {
           int reservation;
           int lineNoForRoomType = 1;
           String checkInDateInput = "";
           String checkOutDateInput = "";
           int userRoomTypeInput;
           int userQuantityInput;
           boolean validDate = false;
           Reservation reservationArr[] = new Reservation[30];
           ReservationDetails reservationDetailsArr[] = new ReservationDetails[30];
           
           Scanner inputReserve = new Scanner(System.in);
           
           System.out.printf("How many reservation you want to make : ");
           reservation = inputReserve.nextInt();
           
           System.out.printf("\n");
           
           
           RoomType roomTypeArr[] = { new RoomType("Single", 250.00, 1, 23),
                                      new RoomType("Double", 500.00, 2, 40),
                                      new RoomType("Deluxe", 750.00, 3, 60) };

                 System.out.println(" -------------------------------------------------------------------- ");
                 System.out.printf("| %-2s | %-10s | %-12s | %-15s | %-15s |\n", "No", "Room Type", "Room Price", "Number of Beds", "Room Size (m^2)");
                 System.out.println(" -------------------------------------------------------------------- ");
           
                for(int i = 0 ; i < roomTypeArr.length; i++)
                {
                     System.out.printf("| %-2d %-60s\n", lineNoForRoomType, roomTypeArr[i].toString());
                     lineNoForRoomType++;
                
                }
                
                System.out.println(" -------------------------------------------------------------------- ");
                
           for(int j = 0; j < reservation; j++)
           {
               
                 System.out.printf("\n");
                 System.out.println("Welcome user! Please select the time range of your reservation.");
           
                do
                {
                        System.out.printf("\n");
                        System.out.printf("Please insert check-in date (EX: DD/MM/YYYY) : ");
               
                        try{
                              checkInDateInput = inputReserve.next();
                   
                    }catch(Exception e) {
                              continue;
                   
                   }    
               
                        validDate = Reservation.isValidCheckInOutDate(checkInDateInput, 0);
               
                        if(validDate == true) {
                               String[] splitted = checkInDateInput.split("/");
                   
                               System.out.printf("%s %s %s\n", splitted[0], splitted[1], splitted[2]);
                               System.out.printf("\n");
               
                    }
               
               }while(validDate == false);
           
               do
               {
                        System.out.printf("\n");
                        System.out.printf("Please insert check-out date (EX: DD/MM/YYYY) : ");
                
                        try{
                                checkOutDateInput = inputReserve.next();
                   
                          }catch(Exception e) {
                                continue;
                   
                        }
                        validDate = Reservation.isValidCheckInOutDate(checkOutDateInput, 1);
               
                        if(validDate == true) {
                               String[] splitted = checkOutDateInput.split("/");
                   
                               System.out.printf("%s %s %s\n", splitted[0], splitted[1], splitted[2]);
                               System.out.printf("\n");
               
                        }
               
               }while(validDate == false);
                   
               long totalDaysReserved = Reservation.calculateDaysReserved(checkInDateInput, checkOutDateInput);
              
               
               
                do
                {
                        System.out.printf("\n");
                        System.out.printf("Please key in your number to select the room type( 1 to 3 ) : ");
                        userRoomTypeInput = inputReserve.nextInt();
                     
                }while(userRoomTypeInput < 1 || userRoomTypeInput > 3);
                
                RoomType roomTypeUser = roomTypeArr[userRoomTypeInput-1];
                
                do
                {
                        System.out.printf("\n");
                        System.out.printf("Please key the quantity of room you want to reserve : ");
                        userQuantityInput = inputReserve.nextInt();
                        
                }while(userQuantityInput < 0);
           
                
                reservationArr[j] = new Reservation(checkInDateInput, checkOutDateInput, totalDaysReserved);
                
                String roomNumber;
                char inputRoomNo = 'Y';
           
           
                RoomReserve reserveRoom = new RoomReserve();
           
                System.out.printf("\n");
                System.out.printf("%-3s  %-12s\n", "No.",  "Room Number");
                
                reserveRoom.readFile(roomArr);
                
                
             for(int c = 0; c < userQuantityInput; c++)
             {
                do
                { 
                        System.out.println("\n");
                        System.out.printf("Room %d\n", ++c);
                        System.out.println("------");
                        System.out.printf("Please enter the room number that you want to reserve : ");
                        roomNumber = inputReserve.next();
           
                        if(reserveRoom.checkRoomNumber(roomNumber, roomArr) == 0)
                        {
                              System.out.println("This room has been booked.");
                              System.out.print("Do you want try to choose another room (Y/N) ? ");
                              inputRoomNo = inputReserve.next().charAt(0);
                              
                     
                        }
                        else if(reserveRoom.checkRoomNumber(roomNumber, roomArr) == 1)
                        {
                             System.out.println("This room is available."); 
                             reservationDetailsArr[j] = new ReservationDetails(reservationArr[j], roomTypeUser , userQuantityInput);
                             continue;
               
                        }
                        else {
                            System.out.println("This room is not inside the list.");
                            System.out.print("Do you want to input again (Y/N) ? ");
                            inputRoomNo = inputReserve.next().charAt(0);
                    
                        }
                
                }while(Character.toUpperCase(inputRoomNo) == 'Y');
                
             }

           }
           
       
           displayReservationDetails(reservationDetailsArr, reservation);
           
           paymentModule(reservation);
 
           
       }
   
      
       
       public static void displayReservationDetails(ReservationDetails[] reservationDetailsArr, int reservation){
            
            double sum = 0;
            int lineNoForReservationDetails = 0;
           
            System.out.printf("\n");
            System.out.println("Reservation Details:");
            System.out.println("--------------------");
            System.out.printf("\n");
            System.out.printf("%-3s %-15s  %-15s  %-10s  %-10s  %-10s  %-8s  %-10s\n", "No", "Check-In Date", "Check-Out Date", "Total Days", "Room Type", "Room Price", "Quantity", "Total Price (RM)");
            System.out.printf("%-3s %-15s  %-15s  %-10s  %-10s  %-10s  %-8s  %-10s\n", "--", "-------------", "--------------", "----------", "---------", "----------", "--------", "----------------");
            for(int k = 0; k < reservation; k++)
            {
                System.out.printf("%-3d %-78s\n", ++lineNoForReservationDetails, reservationDetailsArr[k].toString());
                sum += reservationDetailsArr[k].getSubtotal();
                
            }
            System.out.printf("%93s\n", "----------------------------------------------------------------------------------------------------");
            System.out.printf("%83s %.2f\n", "Sum (RM) :", sum);
            System.out.printf("%72s %10s\n", "", "----------------------------");
       }
       
       public static void main(String[] args) throws ParseException {
         RoomReserve[] roomArr = new RoomReserve[30];
         reserveModule(roomArr);
    }
      
}
    

