package com.example.hotel.sort.impl;

import com.example.hotel.GuestService;
import com.example.hotel.sort.SortingTemplate;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class GuestServicePriceSorting extends SortingTemplate<GuestService> {

    public GuestServicePriceSorting(Collection<GuestService> guestServices) {
        super(guestServices);
    }

    @Override
    protected void performSort(List<GuestService> guestServiceList) {
        guestServiceList.sort(Comparator.comparingDouble(GuestService::getPrice));
    }
}