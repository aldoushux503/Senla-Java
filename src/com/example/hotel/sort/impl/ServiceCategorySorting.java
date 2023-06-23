package com.example.hotel.sort.impl;

import com.example.hotel.Service;
import com.example.hotel.sort.SortingTemplate;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class ServiceCategorySorting extends SortingTemplate<Service> {

    public ServiceCategorySorting(Collection<Service> services) {
        super(services);
    }

    @Override
    protected void performSort(List<Service> serviceList) {
        serviceList.sort(Comparator.comparing(Service::getServiceName));
    }
}
