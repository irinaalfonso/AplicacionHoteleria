package ar.proyectofinal.proyectofinal.controller;

import ar.proyectofinal.proyectofinal.dto.*;
import ar.proyectofinal.proyectofinal.model.Booking;
import ar.proyectofinal.proyectofinal.model.Room;
import ar.proyectofinal.proyectofinal.model.User;
import ar.proyectofinal.proyectofinal.service.IBookingService;
import ar.proyectofinal.proyectofinal.service.IRoomService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/bookings")
public class BookingController {

    private IRoomService roomService;
    private ModelMapper modelMapper;
    private IBookingService bookingService;

    @Autowired
    public BookingController(IRoomService roomService, ModelMapper modelMapper, IBookingService bookingService){
        this.roomService = roomService;
        this.modelMapper = modelMapper;
        this.bookingService = bookingService;
    }

    @GetMapping("/availability")
    public String availability(Model model){
        model.addAttribute("roomAvailability", new RoomAvailabilityDTO());
        model.addAttribute("roomsAvailable", new ArrayList<RoomAvailabilityDTO>());
        return "bookings/availability";
    }

    @PostMapping("/availability")
    public String getRoomsAvailable(@ModelAttribute RoomAvailabilityDTO roomAvailabilityDTO, Model model){
        List<Room> roomsAvailable = new ArrayList<Room>();
        try{
            roomsAvailable = roomService.getRoomsAvailable(roomAvailabilityDTO.getCheckInDateConverted(), roomAvailabilityDTO.getCheckOutDateConverted(), roomAvailabilityDTO.getOccupancy());
        }
        catch (Exception e){}

        List<RoomAvailableDTO> roomsAvailableDTO =  roomsAvailable.stream()
                .map(room -> modelMapper.map(room, RoomAvailableDTO.class))
                .collect(Collectors.toList());

        model.addAttribute("roomAvailability", roomAvailabilityDTO);
        model.addAttribute("roomsAvailable",roomsAvailableDTO);
        model.addAttribute("booking",new NewBookingRequestDTO());
        return "bookings/availability";
    }

    @PostMapping("/new")
    public String newBooking(Model model, @ModelAttribute NewBookingRequestDTO newBookingRequestDTO) throws ParseException {
        NewBookingResponseDTO booking = new NewBookingResponseDTO();
        NewRoomDTO room = modelMapper.map(roomService.findById(newBookingRequestDTO.getRoomId()).get(), NewRoomDTO.class);
        booking.setRoom(room);
        booking.setCheckIn(newBookingRequestDTO.getCheckIn());
        booking.setCheckOut(newBookingRequestDTO.getCheckOut());
        booking.setOccupancy(newBookingRequestDTO.getOccupancy());
        model.addAttribute("booking", booking);
        return "bookings/new";
    }

    @PostMapping("/confirmation")
    public String createBooking(@ModelAttribute NewBookingRequestDTO bookingDTO, Authentication authentication){
        Booking booking = modelMapper.map(bookingDTO, Booking.class);
        booking.setGuest((User)authentication.getPrincipal());
        try{
            bookingService.createBooking(booking);
            return "/bookings/confirmationSuccessful";
        }
        catch (Exception e) {
            return "/bookings/confirmationFailed";
        }

    }

}
