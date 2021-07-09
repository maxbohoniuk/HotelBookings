package pl.maxbohoniuk.hotelbookings.model;

import javax.persistence.*;
import java.util.List;


@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int number; //room number in hotel

    private int maxCapacity; //maximum number of guests in room

    private RoomType type;

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
    private List<Booking> bookings;

    public Room() {
    }

    public Room(int number, int maxCapacity, RoomType type) {
        this.number = number;
        this.maxCapacity = maxCapacity;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }
}
