package pl.maxbohoniuk.hotelbookings.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.maxbohoniuk.hotelbookings.model.Room;
import pl.maxbohoniuk.hotelbookings.model.RoomType;
import pl.maxbohoniuk.hotelbookings.service.RoomService;

import java.util.List;


@RestController
@RequestMapping("api/room")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;

        Room r1 = new Room(341,4, RoomType.ECONOMY);
        Room r2 = new Room(152,2, RoomType.STANDART);
        Room r3 = new Room(511,1, RoomType.LUX);
        Room r4 = new Room(278,6, RoomType.ROYAL);

        try {
            roomService.addRooms(r1,r2,r3,r4);
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
    }

    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }
}