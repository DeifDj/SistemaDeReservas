package org.example;

import Room.Room;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;


@SpringBootApplication
class SistemaReservaHotel {
    public static void main(String[] args) {
        SpringApplication.run(SistemaReservaHotel.class, args);
        Hotel hotel = new Hotel(" Hotel la Fragancia", 10);

        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Bienvenido al Sistema de Reserva de Habitaciones");
            System.out.println("1. Mostrar habitaciones disponibles");
            System.out.println("2. Reservar habitación");
            System.out.println("3. Liberar habitación");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    hotel.mostrarHabitacionesDisponibles();
                    break;
                case 2:
                    System.out.print("Ingrese el número de habitación que desea reservar: ");
                    int numReserva = scanner.nextInt();
                    Room roomReservada = hotel.reservarHabitacion(numReserva);
                    if (roomReservada != null) {
                        System.out.println("¡Habitación " + numReserva + " reservada con éxito!");
                    } else {
                        System.out.println("Lo siento, la habitación no está disponible o no existe.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el número de habitación que desea liberar: ");
                    int numLiberar = scanner.nextInt();
                    hotel.liberarHabitacion(numLiberar);
                    System.out.println("¡Habitación " + numLiberar + " liberada con éxito!");
                    break;
                case 4:
                    System.out.println("Gracias por utilizar el Sistema de Reserva. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (opcion != 4);

        scanner.close();
    }
}