
# Hotel Booking

Simple API on Java Spring Boot to provide bookings for hotel with users and rooms.


## API Reference

### Bookings

#### Get all bookings

```http
  GET /api/booking
```
Returns list of all bookings.

**Example output**
```JSON
[
    {
        "id": 1,
        "checkInDate": "2021-07-10",
        "checkOutDate": "2021-07-19",
        "user": {
            "id": 1,
            "firstName": "Rhonda",
            "lastName": "French",
            "email": "rfrench@gmail.com",
            "birthDate": "1994-05-18",
            "citizenship": "Poland"
        },
        "room": {
            "id": 2,
            "number": 152,
            "maxCapacity": 2,
            "type": "STANDART"
        },
        "status": "CANCELLED",
        "guestsCount": 1
    }
]
```

#### Open booking for room with room ID

For example we may use this endpoint in situation when user only try to book room in hotel to "lock" this room until confirmation or canceletion of the booking to avoid collision.

```http
  POST /api/booking/${roomId}
```


Body example :

```JSON
  {
    "checkInDate":"2021-07-10",
    "checkOutDate":"2021-07-16",
    "user":{
        "id":"1"
    },
    "guestsCount":2
}
```


| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `checkInDate`      | `Date` | Date of check in |
| `checkOutDate`      | `Date` | Date of check out |
| `user`      | `object` | User which book room |
| `guestsCount`      | `int` | Number of persons that will live in room |

#### Open booking for room with room number

Room number - hotel number of specific room.

```http
  POST /api/booking?roomNumber=${roomNumber}
```


Body example :

```JSON
  {
    "checkInDate":"2021-07-10",
    "checkOutDate":"2021-07-16",
    "user":{
        "id":"1"
    },
    "guestsCount":2
}
```


| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `checkInDate`      | `Date` | Date of check in |
| `checkOutDate`      | `Date` | Date of check out |
| `user`      | `object` | User which book room |
| `guestsCount`      | `int` | Number of persons that will live in room |

#### Confirm booking

In this case, we need this endpoint to confirm that user booked room for example after successful payment etc.

```http
  GET /api/booking/${bookingId}/confirm
```

#### Cancel booking


```http
  GET /api/booking/${bookingId}/cancel
```

### Users

#### Get all users

```http
  GET /api/user
```
Returns list of all users.


### Rooms

#### Get all rooms

```http
  GET /api/room
```
Returns list of all rooms.

**Example output**
```JSON
[
    {
        "id": 1,
        "number": 341,
        "maxCapacity": 4,
        "type": "ECONOMY"
    },
    {
        "id": 2,
        "number": 152,
        "maxCapacity": 2,
        "type": "STANDART"
    },
    {
        "id": 3,
        "number": 511,
        "maxCapacity": 1,
        "type": "LUX"
    },
    {
        "id": 4,
        "number": 278,
        "maxCapacity": 6,
        "type": "ROYAL"
    }
]
```



  
