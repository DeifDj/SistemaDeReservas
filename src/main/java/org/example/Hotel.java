package org.example;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String nombre;
    private List<Habitacion> habitaciones;

    public Hotel(String nombre, int numHabitaciones) {
        this.nombre = nombre;
        habitaciones = new ArrayList<>();
        for (int i = 1; i <= numHabitaciones; i++) {
            habitaciones.add(new Habitacion(i));
        }
    }

    public List<Habitacion> mostrarHabitacionesDisponibles() {
        System.out.println("Habitaciones disponibles en " + nombre + ":");
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.estaDisponible()) {
                System.out.println("Habitación " + habitacion.getNumero());
            }
        }
        return null;
    }

    public Habitacion reservarHabitacion(int numero) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero() == numero && habitacion.estaDisponible()) {
                habitacion.reservar();
                return habitacion;
            }
        }
        return null;
    }

    public void liberarHabitacion(int numero) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero() == numero) {
                habitacion.liberar();
                break;
            }
        }
    }
}
