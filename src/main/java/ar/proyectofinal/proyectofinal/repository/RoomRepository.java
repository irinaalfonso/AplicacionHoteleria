package ar.proyectofinal.proyectofinal.repository;

import ar.proyectofinal.proyectofinal.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;

import java.util.Date;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("Select r From Room r where r.occupancy >= :occupancy and r.availability > " +
            "(Select count(b) From Booking b where b.room = r and b.checkIn between :checkIn and :checkOut)")
    public List<Room> getRoomsAvailable(@Param("checkIn") Date checkIn, @Param("checkOut") Date checkOut, @Param("occupancy") int occupancy);

    @Query("Select r From Room r where r.id = :roomId and r.availability > " +
            "(Select count(b) From Booking b where b.room = r and b.checkIn between :checkIn and :checkOut)")
    public Room isRoomAvailable(@Param("checkIn") Date checkIn, @Param("checkOut") Date checkOut, @Param("roomId") Long roomId);


}
