package ar.proyectofinal.proyectofinal.repository;

import ar.proyectofinal.proyectofinal.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
