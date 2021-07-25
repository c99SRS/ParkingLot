package models.parking;

import models.common.Address;
import models.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Parkinglot {

    private String parkingLotId;
    private Address address;

    private List<ParkingFloor> parkingFloors;
    private List<ExitTerminal> exitTerminals;
    private List<EntryTerminal> entryTerminals;
    private ParkingFloor parkingFloor;

    public static Parkinglot INSTANCE = new Parkinglot();

    public Parkinglot() {
        parkingLotId = UUID.randomUUID().toString();
        parkingFloors = new ArrayList<>();
        exitTerminals = new ArrayList<>();
        entryTerminals = new ArrayList<>();
        parkingFloor = new ParkingFloor(parkingLotId);
    }


    // checking parking full
    public boolean isFull() {
        boolean isFull=false;
        for (ParkingFloor parkingFloor: parkingFloors){
            if (parkingFloor.isFloorFull())
                isFull = true;
        }
        return isFull;
    }

    public boolean canPark(VehicleType vehicleType) {

        ParkingSpotType parkingSlotType = parkingFloor.getSpotForVehicle(vehicleType);
        for (ParkingFloor floor : parkingFloors) {
            if (floor.canPark(parkingSlotType))
                return true;
        }
        return false;
    }

    public ParkingSpot getParkingSpot(VehicleType vehicleType) {

        ParkingSpot parkingSpot = parkingFloor.getSpot(vehicleType);

        if (parkingSpot != null)
            return parkingSpot;

        return null;
    }

    public ParkingSpot vacateParkingSpot(String parkingSpotId){

        for (ParkingFloor parkingFloor: getParkingFloors()){
            ParkingSpot parkingSpot = parkingFloor.vacateSpot(parkingSpotId);
            if (parkingSpot != null)
                return parkingSpot;
        }
        return null;
    }


    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public List<ExitTerminal> getExitTerminals() {
        return exitTerminals;
    }

    public void setExitTerminals(List<ExitTerminal> exitTerminals) {
        this.exitTerminals = exitTerminals;
    }

    public List<EntryTerminal> getEntryTerminals() {
        return entryTerminals;
    }

    public void setEntryTerminals(List<EntryTerminal> entryTerminals) {
        this.entryTerminals = entryTerminals;
    }

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }

    @Override
    public String toString() {
        return "Parkinglot{" +
                "parkingLotId='" + parkingLotId + '\'' +
                ", address=" + address +
                ", parkingFloors=" + parkingFloors +
                ", exitTerminals=" + exitTerminals +
                ", entryTerminals=" + entryTerminals +
                ", parkingFloor=" + parkingFloor +
                '}';
    }
}
