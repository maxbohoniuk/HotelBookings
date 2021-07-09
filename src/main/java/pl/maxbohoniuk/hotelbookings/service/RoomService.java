package pl.maxbohoniuk.hotelbookings.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.maxbohoniuk.hotelbookings.model.Room;
import pl.maxbohoniuk.hotelbookings.model.User;
import pl.maxbohoniuk.hotelbookings.repository.RoomRepository;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class RoomService {

    private RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }

    public Room addRoom(Room room){
        return roomRepository.save(room);
    }

    public void addRooms(Room... rooms){
        Arrays.asList(rooms).forEach((r)->roomRepository.save(r));
    }

    public Room getRoomByNumber(int number){
        //exists check!
        return roomRepository.getByNumber(number);
    }

}
