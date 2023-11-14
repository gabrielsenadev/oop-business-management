package dev.gabrielsena.service;

import java.util.Date;

public class ScheduledService {

    private Date time;

    private int clientId;

    public ScheduledService(Date time, int clientId) {
        this.time = time;
        this.clientId = clientId;
    }

    public Date getTime() {
        return time;
    }

    public int getClientId() {
        return clientId;
    }
}
