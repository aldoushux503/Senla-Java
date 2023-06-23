package example.hotel.sort.impl;

import example.hotel.Room;
import example.hotel.Service;
import example.hotel.sort.SortingTemplate;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class ServicePriceSorting extends SortingTemplate<Service> {

    public ServicePriceSorting(Collection<Service> services) {
        super(services);
    }

    @Override
    protected void performSort(List<Service> serviceList) {
        serviceList.sort(Comparator.comparingDouble(Service::getPrice));
    }
}
