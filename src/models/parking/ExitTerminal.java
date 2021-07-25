package models.parking;

import java.time.Duration;
import java.time.LocalDateTime;

public class ExitTerminal extends Terminal{

    public ExitTerminal(String id) {
        super(id);
    }

    public ParkingTicket scanAndVacate(ParkingTicket parkingTicket){

        ParkingSpot parkingSpot = Parkinglot.INSTANCE.vacateParkingSpot(parkingTicket.getAllocatedSpotId());
        parkingTicket.setAmount(CalculateCost(parkingTicket,parkingSpot.getParkingSpotType()) );
        return parkingTicket;
    }

    private double CalculateCost(ParkingTicket parkingTicket, ParkingSpotType parkingSpotType) {

        Duration duration = Duration.between(parkingTicket.getEntryTime(), LocalDateTime.now());

        long hours = duration.toHours();
        if (hours ==0)
            hours=1;

        double amount = hours * new HourlyCost().getCost(parkingSpotType);
        return amount;
    }

}
