package ar.proyectofinal.proyectofinal.service;

import ar.proyectofinal.proyectofinal.model.Room;
import ar.proyectofinal.proyectofinal.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImp implements IRoomService{
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<Room> getRoomsAvailable(Date checkIn, Date checkOut, int occupancy) {
        return roomRepository.getRoomsAvailable(checkIn,checkOut,occupancy);
    }

    @Override
    public Optional<Room> findById(Long id) {
        return roomRepository.findById(id);
    }
}
