
package hotelsystemassignment;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Payment {
    private int paymentID;
    protected double paymentAmount;         
    private String paymentMethod;
    private String paymentDate;
    private String paymentTime;
    
    private static int nextPaymentID = 1001;


    public Payment(double paymentAmount) {
        paymentID = nextPaymentID;
        this.paymentAmount = paymentAmount;   
        LocalDateTime oldFormatDateTime = LocalDateTime.now();                              //get current date and time but old pattern
        DateTimeFormatter newFormatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");        //get current date with new pattern
        DateTimeFormatter newFormatTime = DateTimeFormatter.ofPattern("HH:mm:ss");          //get current time with new pattern
        paymentDate = oldFormatDateTime.format(newFormatDate);                              //store the payment date inside the variable paymentDate
        paymentTime = oldFormatDateTime.format(newFormatTime);                              //store the payment time inside the variable paymentTime
        nextPaymentID++;                                                                    //add one payment ID
        
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public static int getNextPaymentID() {
        return nextPaymentID;
    }


    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
    
    
}


