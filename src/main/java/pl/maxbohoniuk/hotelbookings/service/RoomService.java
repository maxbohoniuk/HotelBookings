package pl.maxbohoniuk.hotelbookings.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.maxbohoniuk.hotelbookings.model.Room;
import pl.maxbohoniuk.hotelbookings.repository.RoomRepository;

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
}
