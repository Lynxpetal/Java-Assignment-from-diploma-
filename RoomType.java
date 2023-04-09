
package hotelsystemassignment;

/**
 *
 * @author 2002c
 */
public class RoomType {
    private String roomType;
    private double roomPrice;
    private int numOfBeds;
    private int roomSize;
  
    
    public RoomType(String roomType, double roomPrice, int numOfBeds, int roomSize) {
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.numOfBeds = numOfBeds;
        this.roomSize = roomSize;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public int getNumOfBeds() {
        return numOfBeds;
    }

    public int getRoomSize() {
        return roomSize;
    }
    
    
    public String toString() {
        return String.format("| %-10s | %-12.2f | %-15d | %-15d |", roomType, roomPrice, numOfBeds, roomSize);
    }
}
