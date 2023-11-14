package dev.gabrielsena.manager;

import dev.gabrielsena.service.ScheduledService;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;

public class ServiceScheduler {

    private ArrayList<ScheduledService> scheduledServices;

    public ServiceScheduler(ArrayList<ScheduledService> scheduledServices) {
        this.scheduledServices = scheduledServices;
    }

    public ArrayList<ScheduledService> getScheduledServices() {
        return scheduledServices;
    }

    public void addScheduledService(ScheduledService scheduledService) {
        this.scheduledServices.add(scheduledService);
    }

    private boolean alreadyScheduled(Date time) {
        return this.scheduledServices.stream().anyMatch(scheduledService -> scheduledService.getTime().getTime() == time.getTime());
    }

    public ArrayList<Date> getAvailableScheduledServiceDate(Instant last, ArrayList<Date> available, int counter) {
        if (counter > 24) {
            return available;
        }
        Date time = new Date(last.toEpochMilli());
        Instant nextTime = last.plus(1, ChronoUnit.HOURS);
        if (!this.alreadyScheduled(time)) {
            available.add(time);
        }
        return this.getAvailableScheduledServiceDate(nextTime, available, ++counter);
    }

    public ArrayList<Date> getAvailableScheduledServiceDate() {
        return this.getAvailableScheduledServiceDate(Instant.now().truncatedTo(ChronoUnit.HOURS), new ArrayList<>(), 0);
    }
}
