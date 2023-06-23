package example.hotel;

import java.util.Date;

public class GuestService {
    private Service service;
    private Date date;

    public GuestService(Service service, Date date) {
        this.service = service;
        this.date = date;
    }

    public Service getService() {
        return service;
    }

    public Date getDate() {
        return date;
    }

    public double getPrice() {
        return service.getPrice();
    }
}
