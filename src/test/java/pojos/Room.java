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
  private int roomNumber;
  private int id;
  private String roomType;
  private boolean status;
  private int price;
  private String description;

    public Room(String createdBy, String createdDate,String description, int price, int roomNumber, String roomType, boolean status ) {
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.status = status;
        this.price = price;
        this.description = description;
    }

    public Room(String createdBy, String createdDate, int roomNumber, int id, String roomType, boolean status, int price, String description) {
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.roomNumber = roomNumber;
        this.id = id;
        this.roomType = roomType;
        this.status = status;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
