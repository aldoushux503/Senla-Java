
import java.util.*;

public class HotelAdministrator {
    private Map<Integer, Room> rooms;
    private Map<String, Service> services;

    public HotelAdministrator() {
        this.rooms = new HashMap<>();
        this.services = new HashMap<>();
    }

    public void checkIn(Room room) {
        rooms.get(room.getRoomNumber()).setStatus(RoomStatus.OCCUPIED);
    }

    public void checkOut(Room room) {
        rooms.get(room.getRoomNumber()).setStatus(RoomStatus.AVAILABLE);
    }

    public void changeRoomStatus(Room room, RoomStatus status) {
        rooms.get(room.getRoomNumber()).setStatus(status);
    }

    public void changeRoomPrice(Room room, double price) {
        rooms.get(room.getRoomNumber()).setPrice(price);
    }

    public void addRoom(Room room) {
        rooms.putIfAbsent(room.getRoomNumber(), new Room(room));
    }

    public void changeServicePrice(Service service, double price) {
        services.get(service.getServiceName()).setPrice(price);
    }

    public void addService(Service service) {
        services.putIfAbsent(service.getServiceName(), new Service(service));
    }

    public Map<Integer, Room> getRooms() {
        return new HashMap<>(rooms);
    }

    public void setRooms(Map<Integer, Room> rooms) {
        this.rooms = new HashMap<>(rooms);
    }

    public Map<String, Service> getServices() {
        return new HashMap<>(services);
    }

    public void setServices(Map<String, Service> services) {
        this.services = new HashMap<>(services);
    }
}
