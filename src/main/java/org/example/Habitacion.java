package org.example;


import javax.persistence.*;

@Entity
@Table(name = "habitaciones")
    public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int numero;
        private boolean disponible;

        public Habitacion(int numero) {
            this.numero = numero;
            this.disponible = true;
        }

        public int getNumero() {
            return numero;
        }

        public boolean estaDisponible() {
            return disponible;
        }

        public void reservar() {
            disponible = false;
        }

        public void liberar() {
            disponible = true;
        }
    }

