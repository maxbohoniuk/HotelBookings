package pl.maxbohoniuk.hotelbookings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.maxbohoniuk.hotelbookings.model.Booking;
import pl.maxbohoniuk.hotelbookings.service.BookingService;
import pl.maxbohoniuk.hotelbookings.service.RoomService;

import java.util.List;

@RestController
@RequestMapping("api/booking")
public class BookingController {

    private final BookingService bookingService;

    private final RoomService roomService;

    @Autowired
    public BookingController(BookingService bookingService,RoomService roomService){
        this.bookingService = bookingService;
        this.roomService = roomService;
    }

    @GetMapping
    public List<Booking> getAllBookings(){
        return bookingService.getAllBookings();
    }

    @PostMapping(path = "/{roomId}")
    public ResponseEntity<Booking> openBookingById(@PathVariable("roomId") long roomId,@RequestBody Booking booking){


        return ResponseEntity.ok(booking);
    }

    @PostMapping
    public ResponseEntity<Booking> openBookingByNumber(@RequestParam(name = "roomNumber") int roomNumber,@RequestBody Booking booking){
        return openBookingById(roomService.getRoomByNumber(roomNumber).getId(),booking);
    }
}
