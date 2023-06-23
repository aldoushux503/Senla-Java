package example.hotel.sort;

import example.hotel.Room;

import java.util.*;

public abstract class SortingTemplate<T> {
    protected Collection<T> items;

    public SortingTemplate(Collection<T> items) {
        this.items = items;
    }

    public List<T> sortItems() {
        List<T> itemList = new ArrayList<>(items);
        performSort(itemList);
        return itemList;
    }

    protected abstract void performSort(List<T> itemList);
}
