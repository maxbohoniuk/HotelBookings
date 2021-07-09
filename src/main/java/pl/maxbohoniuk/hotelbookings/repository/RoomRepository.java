package pl.maxbohoniuk.hotelbookings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.maxbohoniuk.hotelbookings.model.Room;

public interface RoomRepository extends JpaRepository<Room,Long> {


    boolean existsByNumber(int number);

    Room getByNumber(int number);



}
