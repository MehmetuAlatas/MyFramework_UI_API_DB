package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Room {

    /**{
     "createdBy": "mark",
     "createdDate": "2022-03-02T15:16:36.005709Z",
     "id": 11552,
     "roomNumber": 777,
     "roomType": "TWIN",
     "status": false,
     "price": 5.00,
     "description": "Jack"
     }*/

  private String createdBy;
  private String createdDate;
  private int id;
  private int roomNumber;
  private String roomType;
  private boolean status;
  private double price;
  private int priceint;
  private String description;

    public Room(String createdBy, String createdDate, int id, int roomNumber, String roomType, boolean status, double price, String description) {
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.id = id;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.status = status;
        this.price = price;
        this.description = description;
    }

    public Room(String createdBy, String createdDate, int id, int roomNumber, String roomType, boolean status, int priceint, String description) {
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.id = id;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.status = status;
        this.priceint = priceint;
        this.description = description;
    }

    public Room() {
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPriceint() {
        return priceint;
    }

    public void setPriceint(int priceint) {
        this.priceint = priceint;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Room{" +
                "createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", id=" + id +
                ", roomNumber=" + roomNumber +
                ", roomType='" + roomType + '\'' +
                ", status=" + status +
                ", description='" + description + '\'' +
                '}';
    }
}
