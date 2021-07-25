package models.parking;

import models.common.TicketStatus;
import models.exception.CannotParkVehicleException;
import models.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.UUID;

public class EntryTerminal extends Terminal{

    public EntryTerminal(String id) {
        super(id);
    }

    public ParkingTicket getParkingTicket(Vehicle vehicle){
        
        if (!Parkinglot.INSTANCE.canPark(vehicle.vehicleType))
            return new CannotParkVehicleException("Unable to park the vehicle !!");
        
        ParkingSpot parkingSpot = Parkinglot.INSTANCE.getParkingSpot(vehicle.vehicleType);
        
        if (parkingSpot != null)
           return buildTicket(parkingSpot,vehicle);
        
        return null;
    }

    private ParkingTicket buildTicket(ParkingSpot parkingSpot, Vehicle vehicle) {

        ParkingTicket parkingTicket = new ParkingTicket();
        parkingTicket.setTicketNo(UUID.randomUUID().toString());
        parkingTicket.setEntryTime(LocalDateTime.now());
        parkingTicket.setTicketStatus(TicketStatus.ACTIVE);
        parkingTicket.setLicenseNo(vehicle.getLicenseNo());
        parkingTicket.setVehicleNo(vehicle.getLicenseNo());

        return parkingTicket;
    }


}
