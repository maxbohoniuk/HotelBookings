package pl.maxbohoniuk.hotelbookings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.maxbohoniuk.hotelbookings.model.Booking;

public interface BookingRepository extends JpaRepository<Booking,Long> {


}
