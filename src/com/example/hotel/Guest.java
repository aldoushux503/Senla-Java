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

    public double getTotalPayment() {
        double payment = room.getPrice();
        for (GuestService service : services) {
            payment += service.getPrice();
        }
        return payment;
    }
}
