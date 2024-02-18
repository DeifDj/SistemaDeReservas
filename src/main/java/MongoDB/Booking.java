package MongoDB;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Deif")
public class Booking {

    @Id
    private String id;

    private String userId;

    private String details;

    private Date bookingDate;

    public Booking(String id, String userId, String details, Date bookingDate) {
        this.id = id;
        this.userId = userId;
        this.details = details;
        this.bookingDate = bookingDate;
    }

    public Booking(String number, String johnDoe) {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", details='" + details + '\'' +
                ", bookingDate=" + bookingDate +
                '}';
    }

    public String getGuestName() {
        return null;
    }
}
