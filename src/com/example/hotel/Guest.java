package com.example.hotel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Guest {
    private String name;
    private Room room;
    private Date checkOutDate;
    private List<GuestService> services;

    public Guest(String name, Room room, Date checkOutDate) {
        this.name = name;
        this.room = room;
        this.checkOutDate = checkOutDate;
        this.services = new ArrayList<>();
    }

    public double getTotalPayment() {
        double payment = room.getPrice();
        for (GuestService service : services) {
            payment += service.getPrice();
        }
        return payment;
    }

    public String getName() {
        return name;
    }

    public Room getRoom() {
        return room;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public List<GuestService> getServices() {
        return services;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public void setServices(List<GuestService> services) {
        this.services = services;
    }
}
