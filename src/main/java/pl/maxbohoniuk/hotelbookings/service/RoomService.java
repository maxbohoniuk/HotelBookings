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

    public Room addRoom(Room room)throws Exception{
        if(getAllRooms().stream().noneMatch((r) -> { //check for unique id and number
             return r.getId() == room.getId() || r.getNumber() == room.getNumber();
        })){
            return roomRepository.save(room);
        }
        else{
            throw new Exception("Room with this number ( " + room.getNumber() +  " ) already exists");
        }

    }

    public void addRooms(Room... rooms)throws Exception{
        for(Room r : rooms){
            addRoom(r);
        }

    }

    public Room getRoomByNumber(int number) throws Exception{
        if(roomRepository.existsByNumber(number)){
            return roomRepository.getByNumber(number);
        }
        else{
            throw new Exception("Room number " + number + " does not exist");
        }
    }

    public Room getRoomById(long id)throws Exception{
        if(roomRepository.existsById(id)) {
            return roomRepository.getById(id);
        }
        else{
            throw new Exception("Room with id = " + id + " not found");
        }
    }

    public boolean roomExistsById(long id){
        return roomRepository.existsById(id);
    }

}
