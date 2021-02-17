package ar.proyectofinal.proyectofinal.service;

import ar.proyectofinal.proyectofinal.model.Room;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IRoomService {
    public List<Room> getRoomsAvailable(Date checkIn, Date checkOut, int occupancy);
    public Optional<Room> findById(Long id);
    }
