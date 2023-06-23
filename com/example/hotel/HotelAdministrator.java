package example.hotel;

import java.util.*;

public class HotelAdministrator {
    private Map<Integer, Room> rooms;
    private Map<String, Service> services;

    private List<Guest> guests;

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

    public List<Room> getRoomsSortedByPrice() {
        List<Room> roomList = new ArrayList<>(rooms.values());
        roomList.sort(Comparator.comparingDouble(Room::getPrice));
        return roomList;
    }

    public List<Room> getRoomsSortedByCapacity() {
        List<Room> roomList = new ArrayList<>(rooms.values());
        roomList.sort(Comparator.comparingInt(Room::getCapacity));
        return roomList;
    }

    public List<Room> getRoomsSortedByStars() {
        List<Room> roomList = new ArrayList<>(rooms.values());
        roomList.sort(Comparator.comparingInt(Room::getStars));
        return roomList;
    }


    public List<Room> getAvailableRoomsSortedByPrice() {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms.values()) {
            if (room.getStatus() == RoomStatus.AVAILABLE) {
                availableRooms.add(room);
            }
        }
        availableRooms.sort(Comparator.comparingDouble(Room::getPrice));
        return availableRooms;
    }

    public List<Room> getAvailableRoomsSortedByCapacity() {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms.values()) {
            if (room.getStatus() == RoomStatus.AVAILABLE) {
                availableRooms.add(room);
            }
        }
        availableRooms.sort(Comparator.comparingInt(Room::getCapacity));
        return availableRooms;
    }

    public List<Room> getAvailableRoomsSortedByStars() {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms.values()) {
            if (room.getStatus() == RoomStatus.AVAILABLE) {
                availableRooms.add(room);
            }
        }
        availableRooms.sort(Comparator.comparingInt(Room::getStars));
        return availableRooms;
    }

    public List<Guest> getGuestsSortedAlphabetically() {
        List<Guest> sortedGuests = new ArrayList<>(guests);
        sortedGuests.sort(Comparator.comparing(Guest::getName));
        return sortedGuests;
    }

    public List<Guest> getGuestsSortedByCheckOutDate() {
        List<Guest> sortedGuests = new ArrayList<>(guests);
        sortedGuests.sort(Comparator.comparing(Guest::getCheckOutDate));
        return sortedGuests;
    }
    public int getTotalAvailableRooms() {
        int count = 0;
        for (Room room : rooms.values()) {
            if (room.getStatus() == RoomStatus.AVAILABLE) {
                count++;
            }
        }
        return count;
    }

    public int getTotalGuests() {
        return guests.size();
    }

    public List<Room> getAvailableRoomsOnDate(Date date) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms.values()) {
            if (room.isAvailableOnDate(date)) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public double getRoomPayment(Room room) {
        double payment = 0;
        for (Guest guest : guests) {
            if (guest.getRoom() == room) {
                payment += guest.getTotalPayment();
            }
        }
        return payment;
    }

    public List<Guest> getLastThreeGuests(Room room) {
        List<Guest> lastThreeGuests = new ArrayList<>();
        for (Guest guest : guests) {
            if (guest.getRoom() == room) {
                lastThreeGuests.add(guest);
                if (lastThreeGuests.size() >= 3) {
                    break;
                }
            }
        }
        return lastThreeGuests;
    }

    public List<GuestService> getGuestServicesSortedByPrice() {
        List<GuestService> guestServices = new ArrayList<>();
        for (Guest guest : guests) {
            guestServices.addAll(guest.getServices());
        }
        guestServices.sort(Comparator.comparingDouble(GuestService::getPrice));
        return guestServices;
    }

    public List<Service> getServicesSortedByPrice() {
        List<Service> serviceList = new ArrayList<>(services.values());
        serviceList.sort(Comparator.comparingDouble(Service::getPrice));
        return serviceList;
    }

    public Room getRoomDetails(int roomNumber) {
        return new Room(rooms.get(roomNumber));
    }
}
