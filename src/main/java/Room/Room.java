package Room;


import jakarta.persistence.*;

@Entity
@Table(name = "habitaciones")
    public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int numero;
        private boolean disponible;

        public Room(int numero) {
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

