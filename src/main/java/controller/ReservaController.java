package controller;

import Room.Room;
import org.example.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final Hotel hotel;


@Autowired
    public ReservaController(Hotel hotel) {
        this.hotel = hotel;
    }

    @GetMapping("/habitaciones-disponibles")
    public List<Room> mostrarHabitacionesDisponibles() {
        return hotel.mostrarHabitacionesDisponibles();
    }

    @PostMapping("/reservar/{numero}")
    public ResponseEntity<String> reservarHabitacion(@PathVariable int numero) {
        Room roomReservada = hotel.reservarHabitacion(numero);
        if (roomReservada != null) {
            return ResponseEntity.ok("Habitación " + numero + " reservada con éxito.");
        } else {
            return ResponseEntity.badRequest().body("Lo siento, la habitación no está disponible o no existe.");
        }
    }
}