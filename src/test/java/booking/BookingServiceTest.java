package booking;

import MongoDB.Booking;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static com.mongodb.assertions.Assertions.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.springframework.data.mongodb.core.aggregation.ConditionalOperators.Switch.CaseOperator.when;

@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private BookingService bookingService;

    @Test
    public void testGetAllBookings() {
        // Mocking data
        Booking booking1 = new Booking("1", "John Doe");
        Booking booking2 = new Booking("2", "Jane Smith");
        List<Booking> mockBookings = Arrays.asList(booking1, booking2);

        // Stubbing the repository method call
        when(bookingRepository.getAllBookings()).then(mockBookings);


        // Testing the service method
        List<Booking> bookings = bookingService.getAllBookings();
        assertEquals(2, bookings.size()); // Verifying the size of the returned list
    }

    @Test
    public void testGetBookingById() {
        // Mocking data
        Booking booking = new Booking("1", "John Doe");

        // Stubbing the repository method call
        when(bookingRepository.getBookingById("1")).then(booking);

        // Testing the service method
        Booking foundBooking = bookingService.getBookingById("1");
        assertNotNull(foundBooking); // Verifying the found booking is not null
        assertEquals("John Doe", foundBooking.getGuestName()); // Verifying guest name
    }

    // Write more test cases similarly for other methods in BookingService
}
