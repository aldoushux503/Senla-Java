package com.example.hotel;

import java.util.Date;
import java.util.List;

public class HotelAdministratorTest {
    public static void main(String[] args) {
        // Create an instance of the HotelAdministrator
        HotelAdministrator administrator = new HotelAdministrator();

        // Create some rooms
        Room room1 = new Room(101, 100.0, 2, 5);
        Room room2 = new Room(102, 150.0, 4, 4);

        // Add rooms to the administrator
        administrator.addRoom(room1);
        administrator.addRoom(room2);

        // Change the status and price of a room
        administrator.changeRoomStatus(room1, RoomStatus.OCCUPIED);
        administrator.changeRoomPrice(room2, 200.0);

        // Create some services
        Service service1 = new Service("Room Cleaning", 20.0);
        Service service2 = new Service("Laundry", 15.0);

        // Add services to the administrator
        administrator.addService(service1);
        administrator.addService(service2);

        // Change the price of a service
        administrator.changeServicePrice(service2, 18.0);

        // Perform check-in and check-out
        administrator.checkIn(room1);
        administrator.checkOut(room1);

        // Print the room and service details
        for (Room room : administrator.getRooms()) {
            System.out.println(room);
        }
        for (Service service : administrator.getServices()) {
            System.out.println(service);
        }

        System.out.println("Rooms sorted by price: ");
        List<Room> availableRoomsSortedByPrice = administrator.getAvailableRoomsSortedByPrice();
        for (Room room : availableRoomsSortedByPrice) {
            System.out.println(room);
        }

        System.out.println("Rooms sorted by capacity: ");
        List<Room> availableRoomsSortedByCapacity = administrator.getAvailableRoomsSortedByCapacity();
        for (Room room : availableRoomsSortedByCapacity) {
            System.out.println(room);
        }


        System.out.println("Rooms sorted by stars: ");
        List<Room> availableRoomsSortedByStars = administrator.getAvailableRoomsSortedByStars();
        for (Room room : availableRoomsSortedByStars) {
            System.out.println(room);
        }

        int totalAvailableRooms = administrator.getTotalAvailableRooms();
        System.out.println("Total available rooms: " + totalAvailableRooms);


        int totalGuests = administrator.getTotalGuests();
        System.out.println("Total guests: " + totalGuests);



    }
}

