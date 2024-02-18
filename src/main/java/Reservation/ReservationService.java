package Reservation;

import java.util.List;

public class ReservationService {
    private ReservationRepository reservaRepository;

    public ReservationService(ReservationRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public boolean realizarReserva(String habitacionId, String cliente) {
        // Lógica para realizar la reserva
        // ...

        // Guardar la reserva en el repositorio
        Reservation reserva = new Reservation(habitacionId, cliente, "101");
        return reservaRepository.guardarReserva(reserva);
    }

    public List<Reservation> findByGuestName(String guestName) {
        return null;
    }

    public Reservation saveReservation(Reservation reservation) {
        return null;
    }
}
