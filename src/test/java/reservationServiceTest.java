import Reservation.Reservation;
import Reservation.ReservationRepository;
import Reservation.ReservationService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ReservationServiceTest {

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private ReservationService reservationService;

    // Aquí puedes tener un método de configuración o anotación si es necesario

    @Test
    void testFindByGuestName() {
        // Arrange
        String guestName = "John Doe";
        Reservation reservation1 = new Reservation("1", "Katherine", "101");
        Reservation reservation2 = new Reservation("2", "Def", "202");
        List<Reservation> reservations = Arrays.asList(reservation1, reservation2).reversed();

        when(reservationRepository.findByGuestName(guestName)).thenReturn(reservations);

        // Act
        List<Reservation> result = reservationService.findByGuestName(guestName);

        // Assert
        assertEquals(reservations, result);
        verify(reservationRepository, times(1)).findByGuestName(guestName);
    }

    @Test
    void testSaveReservation() {
        // Arrange
        Reservation reservation = new Reservation("1", "Def", "101");

        when(reservationRepository.save(reservation)).thenReturn(reservation);

        // Act
        Reservation result = reservationService.saveReservation(reservation);

        // Assert
        assertEquals(reservation, result);
        verify(reservationRepository, times(1)).save(reservation);
    }
    
}

