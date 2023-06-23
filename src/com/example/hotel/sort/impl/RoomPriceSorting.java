package com.example.hotel.sort.impl;

import com.example.hotel.Room;
import com.example.hotel.sort.SortingTemplate;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class RoomPriceSorting extends SortingTemplate<Room> {
    public RoomPriceSorting(Collection<Room> rooms) {
        super(rooms);
    }

    @Override
    protected void performSort(List<Room> roomList) {
        roomList.sort(Comparator.comparingDouble(Room::getPrice));
    }
}
