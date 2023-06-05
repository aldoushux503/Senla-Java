package Task_4;

import java.util.ArrayList;
import java.util.List;

public class HotelAdministrator {
    private List<Room> rooms;
    private List<Service> services;

    public HotelAdministrator() {
        this.rooms = new ArrayList<>();
        this.services = new ArrayList<>();
    }

    public void checkIn(Room room) {
        room.setStatus(RoomStatus.OCCUPIED);
        // Additional logic for check-in process
    }

    public void checkOut(Room room) {
        room.setStatus(RoomStatus.AVAILABLE);
        // Additional logic for check-out process
    }

    public void changeRoomStatus(Room room, RoomStatus status) {
        room.setStatus(status);
    }

    public void changeRoomPrice(Room room, double price) {
        room.setPrice(price);
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void changeServicePrice(Service service, double price) {
        service.setPrice(price);
    }

    public void addService(Service service) {
        services.add(service);
    }
}
