package models.parking;

import models.common.TicketStatus;

import java.time.LocalDateTime;

public class ParkingTicket {

    private String ticketNo;
    private String licenseNo;
    private String vehicleNo;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private double amount;
    private TicketStatus ticketStatus;
    private String allocatedSpotId;


    public String getAllocatedSpotId() {
        return allocatedSpotId;
    }

    public void setAllocatedSpotId(String allocatedSpotId) {
        this.allocatedSpotId = allocatedSpotId;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
