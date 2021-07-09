package pl.maxbohoniuk.hotelbookings.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.maxbohoniuk.hotelbookings.model.Booking;
import pl.maxbohoniuk.hotelbookings.model.BookingStatus;
import pl.maxbohoniuk.hotelbookings.repository.BookingRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService {

    private BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }

    public boolean openBooking(Booking booking)throws Exception{
        if(checkAvailabilityOfRoom(booking)){ //room is available
            if(booking.getCheckInDate().isBefore(LocalDate.now())){
                throw new Exception("Room cannot be booked for past time.");
            }
            if(booking.getCheckInDate().isAfter(booking.getCheckOutDate())){
                throw new Exception("Bad check in or check out date");
            }
            bookingRepository.save(booking);
            return true;
        }
        else{
            throw new Exception("Room is not available in that period of time.");
        }
    }

    public boolean checkAvailabilityOfRoom(Booking booking){
        return getAllBookings().stream().noneMatch((b) -> {
            if(b.getRoom().getId() == booking.getRoom().getId()){
                if(b.getStatus() != BookingStatus.CANCELLED){
                    boolean condition1 = b.getCheckInDate().isBefore(booking.getCheckInDate()) && b.getCheckOutDate().isAfter(booking.getCheckInDate());
                    boolean condition2 = b.getCheckInDate().isEqual(booking.getCheckInDate()) || b.getCheckOutDate().equals(booking.getCheckOutDate());
                    boolean condition3 = b.getCheckInDate().isBefore(booking.getCheckOutDate()) && b.getCheckOutDate().isAfter(booking.getCheckOutDate());
                    boolean condition4 = b.getCheckInDate().isAfter(booking.getCheckInDate()) && b.getCheckOutDate().isBefore(booking.getCheckOutDate());
                    return condition1 || condition2 || condition3 || condition4;
                }
            }
            return false;
        });
    }

    public boolean confirmBooking(Booking booking)throws Exception{
        if(booking.getStatus() == BookingStatus.PENDING){
            booking.setStatus(BookingStatus.BOOKED);
            return true;
        }
        else{
            throw new Exception("Booking was not opened");
        }
    }

    public boolean existsById(long id){
        return bookingRepository.existsById(id);
    }

    public Booking getById(long id)throws Exception{
        if(existsById(id)){
            return bookingRepository.getById(id);
        }
        else{
            throw new Exception("Booking does not exist");
        }
    }



}
