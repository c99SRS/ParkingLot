package models.parking;

import models.vehicle.VehicleType;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ParkingFloor {

    private int MAX_CAPACITY=5;
    private String floorId;
    private Map<String, ParkingSpot> usedParkingSpot;
    private Map<ParkingSpotType, Deque<ParkingSpot>> parkingSpots;

    public ParkingFloor(String id){
        floorId = id;
        usedParkingSpot = new HashMap<>(MAX_CAPACITY);
        parkingSpots = new HashMap<>();
        parkingSpots.put(ParkingSpotType.LARGE, new ConcurrentLinkedDeque());
        parkingSpots.put(ParkingSpotType.MEDIUM, new ConcurrentLinkedDeque());
        parkingSpots.put(ParkingSpotType.SMALL, new ConcurrentLinkedDeque());
    }

    public ParkingSpotType getSpotForVehicle(VehicleType vehicleType){

        switch (vehicleType){
            case CAR:
                return ParkingSpotType.MEDIUM;
            case TRUCK:
                return ParkingSpotType.LARGE;
            case MOTORCYCLE:
                return ParkingSpotType.SMALL;
            default:
                return ParkingSpotType.VERYLARGE;
        }
    }

    public boolean isFloorFull(){
        if (usedParkingSpot.size() > MAX_CAPACITY)
            return true;
        return false;
    }


    public boolean canPark(VehicleType vehicleType){
        return canPark(getSpotForVehicle(vehicleType));
    }

    public boolean canPark(ParkingSpotType parkingSlotType){
        return parkingSpots.get(parkingSlotType).size() > 0;
    }

    public ParkingSpot getSpot(VehicleType vehicleType){

        if (!canPark(getSpotForVehicle(vehicleType)))
            return null;

        ParkingSpotType parkingSlotType = getSpotForVehicle(vehicleType);
        ParkingSpot parkingSpot = parkingSpots.get(parkingSlotType).poll();

        usedParkingSpot.put(parkingSpot.getParkingSlotId(), parkingSpot);

        return parkingSpot;
    }


    public ParkingSpot vacateSpot(String parkingSpotId) {

        ParkingSpot parkingSpot = usedParkingSpot.remove(parkingSpotId);

        if (parkingSpot != null){
            parkingSpot.freeSpot();

            parkingSpots.get(parkingSpot.getParkingSpotType()).addFirst(parkingSpot);
        }
        return parkingSpot;
    }


    public String getFloorId() {
        return floorId;
    }

    public void setFloorId(String floorId) {
        this.floorId = floorId;
    }

    public Map<String, ParkingSpot> getUsedParkingSpot() {
        return usedParkingSpot;
    }

    public void setUsedParkingSpot(Map<String, ParkingSpot> usedParkingSpot) {
        this.usedParkingSpot = usedParkingSpot;
    }

    public Map<ParkingSpotType, Deque<ParkingSpot>> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(Map<ParkingSpotType, Deque<ParkingSpot>> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }
}
