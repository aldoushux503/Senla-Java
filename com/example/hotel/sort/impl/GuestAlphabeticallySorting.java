package example.hotel.sort.impl;

import example.hotel.Guest;
import example.hotel.sort.SortingTemplate;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class GuestAlphabeticallySorting extends SortingTemplate<Guest> {

    public GuestAlphabeticallySorting(Collection<Guest> guests) {
        super(guests);
    }

    @Override
    protected void performSort(List<Guest> guestList) {
        guestList.sort(Comparator.comparing(Guest::getName));
    }
}

