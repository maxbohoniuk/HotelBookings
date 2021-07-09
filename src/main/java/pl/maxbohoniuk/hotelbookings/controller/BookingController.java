package pl.maxbohoniuk.hotelbookings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.maxbohoniuk.hotelbookings.model.Booking;
import pl.maxbohoniuk.hotelbookings.model.BookingStatus;
import pl.maxbohoniuk.hotelbookings.service.BookingService;
import pl.maxbohoniuk.hotelbookings.service.RoomService;
import pl.maxbohoniuk.hotelbookings.service.UserService;

import java.util.List;

@RestController
@RequestMapping("api/booking")
public class BookingController {

    private final BookingService bookingService;

    private final RoomService roomService;

    private final UserService userService;

    @Autowired
    public BookingController(BookingService bookingService,RoomService roomService, UserService userService){
        this.bookingService = bookingService;
        this.roomService = roomService;
        this.userService = userService;
    }

    @GetMapping
    public List<Booking> getAllBookings(){
        return bookingService.getAllBookings();
    }

    @PostMapping(path = "/{roomId}")
    public ResponseEntity<String> openBookingById(@PathVariable("roomId") long roomId,@RequestBody Booking booking){
        try {
            booking.setRoom(roomService.getRoomById(roomId)); //include room exist check

            if(booking.getRoom().getMaxCapacity() < booking.getGuestsCount()){
                return ResponseEntity.badRequest().body("Chosen room is too small for that number of guests.");
            }

            long userId = booking.getUser().getId();
            booking.setUser(userService.getUserById(userId)); //include user exist check
            booking.setStatus(BookingStatus.PENDING);
            bookingService.openBooking(booking); //include room availability check
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("Booking with id = " + booking.getId() + " opened for room " + booking.getRoom().getNumber() + "\n by " + booking.getUser());
    }

    @PostMapping
    public ResponseEntity<String> openBookingByNumber(@RequestParam(name = "roomNumber") int roomNumber,@RequestBody Booking booking){
        try {
            return openBookingById(roomService.getRoomByNumber(roomNumber).getId(),booking);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
