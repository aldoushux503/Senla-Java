package com.example.hotel;

import com.example.hotel.sort.impl.*;

import java.util.*;
import java.util.stream.Collectors;

public class HotelAdministrator {
    private Map<Integer, Room> rooms;
    private Map<String, Service> services;

    private List<Guest> guests;

    public HotelAdministrator() {
        this.rooms = new HashMap<>();
        this.services = new HashMap<>();
        this.guests = new ArrayList<>();
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

    public List<Room> getRooms() {
        return new ArrayList<>(rooms.values());
    }

    public void setRooms(Map<Integer, Room> rooms) {
        this.rooms = new HashMap<>(rooms);
    }

    public List<Service> getServices() {
        return new ArrayList<>(services.values());
    }

    public Service getServiceDetails(Service service) {
        return new Service(services.get(service.getServiceName()));
    }

    public void setServices(Map<String, Service> services) {
        this.services = new HashMap<>(services);
    }

    public List<Guest> getGuests() {
        return new ArrayList<>(guests);
    }

    public void setGuests(List<Guest> guests) {
        this.guests = new ArrayList<>(guests);
    }

    public List<Room> getRoomsSortedByPrice() {
        return new RoomPriceSorting(getRooms()).sortItems();
    }

    public List<Room> getRoomsSortedByCapacity() {
        return new RoomCapacitySorting(getRooms()).sortItems();
    }

    public List<Room> getRoomsSortedByStars() {
        return new RoomStarsSorting(getRooms()).sortItems();
    }

    private List<Room> getAvailableRooms() {
        return rooms.values()
                .stream()
                .filter(room -> room.getStatus() == RoomStatus.AVAILABLE)
                .toList();
    }

    public List<Room> getAvailableRoomsSortedByPrice() {
        return new RoomPriceSorting(getAvailableRooms()).sortItems();
    }

    public List<Room> getAvailableRoomsSortedByCapacity() {
        return new RoomCapacitySorting(getAvailableRooms()).sortItems();
    }

    public List<Room> getAvailableRoomsSortedByStars() {
        return new RoomStarsSorting(getAvailableRooms()).sortItems();
    }


    public List<Guest> getGuestsSortedAlphabetically() {
        return new GuestAlphabeticallySorting(guests).sortItems();
    }

    public List<Guest> getGuestsSortedByCheckOutDate() {
        return new GuestCheckOutDateSorting(guests).sortItems();
    }

    public int getTotalAvailableRooms() {
        return getAvailableRooms().size();
    }

    public int getTotalGuests() {
        return guests.size();
    }

    public List<Room> getAvailableRoomsOnDate(Date date) {
        return getAvailableRooms()
                .stream()
                .filter(r -> r.isAvailableOnDate(date))
                .toList();
    }

    public double getRoomPayment(Room room) {
        return guests.stream()
                .filter(guest -> guest.getRoom().equals(room))
                .mapToDouble(Guest::getTotalPayment)
                .sum();
    }


    public List<Guest> getLastThreeGuests(Room room) {
        return guests.stream()
                .filter(guest -> guest.getRoom() == room)
                .limit(3)
                .collect(Collectors.toList());
    }


    private List<GuestService> getGuestServices() {
        return guests.stream()
                .flatMap(guest -> guest.getServices().stream())
                .collect(Collectors.toList());
    }
    public List<GuestService> getGuestServicesSortedByPrice() {
        return new GuestServicePriceSorting(getGuestServices()).sortItems();
    }

    public List<GuestService> getGuestServicesSortedByDate() {
        return new GuestServiceDateSorting(getGuestServices()).sortItems();
    }

    public List<Service> getServicesSortedByCategory() {
        return new ServiceCategorySorting(getServices()).sortItems();
    }

    public List<Service> getServicesSortedByPrice() {
        return new ServicePriceSorting(getServices()).sortItems();
    }

    public Room getRoomDetails(int roomNumber) {
        return new Room(rooms.get(roomNumber));
    }
}
