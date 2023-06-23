package com.example.hotel;

import java.util.Date;

public class GuestService extends Service {
    private Date date;

    public GuestService(Service service, Date date) {
        super(service);
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
