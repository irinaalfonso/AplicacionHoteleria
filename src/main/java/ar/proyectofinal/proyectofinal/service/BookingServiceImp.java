package ar.proyectofinal.proyectofinal.service;
import ar.proyectofinal.proyectofinal.model.Booking;
import ar.proyectofinal.proyectofinal.model.Room;
import ar.proyectofinal.proyectofinal.repository.BookingRepository;
import ar.proyectofinal.proyectofinal.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BookingServiceImp implements IBookingService{
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    BookingRepository bookingRepository;

    public void createBooking(Booking booking) throws Exception {
        booking.setRoom(roomRepository.findById(booking.getRoom().getId()).get());
        booking.setCost(booking.getRoom().getPrice());
        Room room = roomRepository.isRoomAvailable(booking.getCheckIn(), booking.getCheckOut(), booking.getRoom().getId());
        if (booking.getCheckIn().before(new Date()) || booking.getCheckIn().after(booking.getCheckOut())){
            throw new Exception("Incorrect dates");
        }
        if( room != null){
            bookingRepository.save(booking);
        }
        else{
            throw new Exception("Room is no longer available");
        }

    }
}
