package controller;

import org.example.Habitacion;
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
    public List<Habitacion> mostrarHabitacionesDisponibles() {
        return hotel.mostrarHabitacionesDisponibles();
    }

    @PostMapping("/reservar/{numero}")
    public ResponseEntity<String> reservarHabitacion(@PathVariable int numero) {
        Habitacion habitacionReservada = hotel.reservarHabitacion(numero);
        if (habitacionReservada != null) {
            return ResponseEntity.ok("Habitación " + numero + " reservada con éxito.");
        } else {
            return ResponseEntity.badRequest().body("Lo siento, la habitación no está disponible o no existe.");
        }
    }
}