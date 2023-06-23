package test;

import com.example.hotel.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class HotelTest {

    private HotelAdministrator administrator;
    private Room room1;
    private Room room2;
    private Room room3;
    private Service service1;
    private Service service2;
    private Guest guest1;
    private Guest guest2;

    @BeforeEach
    public void setup() {
        administrator = new HotelAdministrator();

        room1 = new Room(101, 100.0, 2, 4);
        room2 = new Room(102, 150.0, 3, 5);
        room3 = new Room(103, 200.0, 4, 6);

        service1 = new Service("WiFi", 10.0);
        service2 = new Service("Breakfast", 20.0);

        guest1 = new Guest("John", room1, new Date());
        guest2 = new Guest("Alice", room2, new Date());

        administrator.setGuests(createGuestList());
        administrator.addService(service1);
        administrator.addService(service2);
        administrator.setRooms(createRoomMap());
        administrator.checkIn(room1);
        administrator.checkOut(room2);
    }

    private Map<Integer, Room> createRoomMap() {
        Map<Integer, Room> roomMap = new HashMap<>();
        roomMap.put(room1.getRoomNumber(), room1);
        roomMap.put(room2.getRoomNumber(), room2);
        roomMap.put(room3.getRoomNumber(), room3);
        return roomMap;
    }

    private List<Guest> createGuestList() {
        return List.of(guest1, guest2);
    }


    @Test
    public void testCheckIn() {
        administrator.checkIn(room3);
        assertEquals(RoomStatus.OCCUPIED, room3.getStatus());
    }

    @Test
    public void testCheckOut() {
        administrator.checkOut(room1);
        assertEquals(RoomStatus.AVAILABLE, room1.getStatus());
    }

    @Test
    public void testChangeRoomStatus() {
        administrator.changeRoomStatus(room1, RoomStatus.UNDER_REPAIR);
        assertEquals(RoomStatus.UNDER_REPAIR, room1.getStatus());
    }

    @Test
    public void testChangeRoomPrice() {
        administrator.changeRoomPrice(room1, 120.0);
        assertEquals(120.0, room1.getPrice());
    }

    @Test
    public void testAddRoom() {
        Room newRoom = new Room(104, 250.0, 5, 5);
        administrator.addRoom(newRoom);
        assertEquals(newRoom, administrator.getRooms().get(newRoom.getRoomNumber()));
    }

    @Test
    public void testChangeServicePrice() {
        administrator.changeServicePrice(service1, 15.0);
        assertEquals(15.0, administrator.getServiceDetails(service1).getPrice());
    }

    @Test
    public void testAddService() {
        Service newService = new Service("Laundry", 30.0);
        administrator.addService(newService);
        assertEquals(newService, administrator.getServices().get(newService.getServiceName()));
    }

    @Test
    public void testGetRoomsSortedByPrice() {
        assertEquals(room1, administrator.getRoomsSortedByPrice().get(0));
        assertEquals(room2, administrator.getRoomsSortedByPrice().get(1));
    }

    @Test
    public void testGetRoomsSortedByCapacity() {
        assertEquals(room1, administrator.getRoomsSortedByCapacity().get(0));
        assertEquals(room2, administrator.getRoomsSortedByCapacity().get(1));
    }

    @Test
    public void testGetRoomsSortedByStars() {
        assertEquals(room1, administrator.getRoomsSortedByStars().get(0));
        assertEquals(room2, administrator.getRoomsSortedByStars().get(1));
    }

    @Test
    public void testGetAvailableRoomsSortedByPrice() {
        administrator.changeRoomStatus(room1, RoomStatus.UNDER_REPAIR);
        assertEquals(room2, administrator.getAvailableRoomsSortedByPrice().get(0));
    }

    @Test
    public void testGetAvailableRoomsSortedByCapacity() {
        administrator.changeRoomStatus(room1, RoomStatus.UNDER_REPAIR);
        assertEquals(room2, administrator.getAvailableRoomsSortedByCapacity().get(0));
    }

    @Test
    public void testGetAvailableRoomsSortedByStars() {
        administrator.changeRoomStatus(room1, RoomStatus.UNDER_REPAIR);
        assertEquals(room2, administrator.getAvailableRoomsSortedByStars().get(0));
    }

    @Test
    public void testGetGuestsSortedAlphabetically() {
        assertEquals(guest2, administrator.getGuestsSortedAlphabetically().get(0));
        assertEquals(guest1, administrator.getGuestsSortedAlphabetically().get(1));
    }

    @Test
    public void testGetGuestsSortedByCheckOutDate() {
        assertEquals(guest1, administrator.getGuestsSortedByCheckOutDate().get(0));
        assertEquals(guest2, administrator.getGuestsSortedByCheckOutDate().get(1));
    }

    @Test
    public void testGetTotalAvailableRooms() {
        administrator.changeRoomStatus(room3, RoomStatus.UNDER_REPAIR);
        assertEquals(1, administrator.getTotalAvailableRooms());
    }

    @Test
    public void testGetTotalGuests() {
        assertEquals(2, administrator.getTotalGuests());
    }

    @Test
    public void testGetAvailableRoomsOnDate() {
        assertEquals(room2, administrator.getAvailableRoomsOnDate(new Date()).get(0));
        administrator.checkOut(room1);
        administrator.checkIn(room2);
        assertEquals(room1, administrator.getAvailableRoomsOnDate(new Date()).get(0));
        administrator.checkIn(room1);
        administrator.checkIn(room2);
        administrator.checkIn(room3);
        assertEquals(0, administrator.getAvailableRoomsOnDate(new Date()).size());
    }

    @Test
    public void testGetRoomPayment() {
        assertEquals(room1.getPrice(), administrator.getRoomPayment(room1));
        assertEquals(150, administrator.getRoomPayment(room2));
        administrator.getGuests().get(0).getServices().add(new GuestService(service1, new Date()));
        administrator.getGuests().get(0).getServices().add(new GuestService(service2, new Date()));
        assertEquals(room1.getPrice() + service1.getPrice() + service2.getPrice(), administrator.getRoomPayment(room1));
    }

    @Test
    public void testGetLastThreeGuests() {
        assertEquals(guest1, administrator.getLastThreeGuests(room1).get(0));
        assertEquals(guest2, administrator.getLastThreeGuests(room2).get(0));
    }

    @Test
    public void testGetGuestServicesSortedByPrice() {
        GuestService guestService1 = new GuestService(service2, new Date());
        GuestService guestService2 = new GuestService(service1, new Date());
        administrator.getGuests().get(0).getServices().add(guestService1);
        administrator.getGuests().get(1).getServices().add(guestService2);
        assertEquals(guestService2, administrator.getGuestServicesSortedByPrice().get(0));
        assertEquals(guestService1, administrator.getGuestServicesSortedByPrice().get(1));
    }

    @Test
    public void testGetServicesSortedByPrice() {
        assertEquals(service1, administrator.getServicesSortedByPrice().get(0));
        assertEquals(service2, administrator.getServicesSortedByPrice().get(1));
    }

    @Test
    public void testGetRoomDetails() {
        assertEquals(room1, administrator.getRoomDetails(room1.getRoomNumber()));
        assertEquals(room2, administrator.getRoomDetails(room2.getRoomNumber()));
    }
}
