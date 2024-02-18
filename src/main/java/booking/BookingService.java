package booking;

import MongoDB.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAllBookings() {
        return (List<Booking>) bookingRepository.getAllBookings();
    }

    public Booking getBookingById(String id) {
        return (Booking) bookingRepository.getBookingById(id);
    }


}