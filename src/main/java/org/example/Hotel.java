package org.example;

import Room.Room;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String nombre;
    private List<Room> habitaciones;

    public Hotel(String nombre, int numHabitaciones) {
        this.nombre = nombre;
        habitaciones = new ArrayList<>();
        for (int i = 1; i <= numHabitaciones; i++) {
            habitaciones.add(new Room(i));
        }
    }

    public List<Room> mostrarHabitacionesDisponibles() {
        System.out.println("Habitaciones disponibles en " + nombre + ":");
        for (Room room : habitaciones) {
            if (room.estaDisponible()) {
                System.out.println("Habitación " + room.getNumero());
            }
        }
        return null;
    }

    public Room reservarHabitacion(int numero) {
        for (Room room : habitaciones) {
            if (room.getNumero() == numero && room.estaDisponible()) {
                room.reservar();
                return room;
            }
        }
        return null;
    }

    public void liberarHabitacion(int numero) {
        for (Room room : habitaciones) {
            if (room.getNumero() == numero) {
                room.liberar();
                break;
            }
        }
    }
}
