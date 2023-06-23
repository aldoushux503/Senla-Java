package example.hotel.sort.impl;

import example.hotel.Room;
import example.hotel.sort.SortingTemplate;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class RoomStarsSorting extends SortingTemplate<Room> {
    public RoomStarsSorting(Collection<Room> rooms) {
        super(rooms);
    }


    @Override
    protected void performSort(List<Room> roomList) {
        roomList.sort(Comparator.comparingInt(Room::getStars));
    }
}
