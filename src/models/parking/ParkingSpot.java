package models.parking;

public class ParkingSpot {

    private String parkingSlotId;
    private boolean isFree;
    private ParkingSpotType parkingSpotType;
    private String assignedVehicleId;

    public ParkingSpot(String parkingSpotId, ParkingSpotType parkingSpotType)
    {
        this.parkingSpotType = parkingSpotType;
        this.parkingSlotId  = parkingSpotId;
    }
    public void setAssignedVehicleToSpot(String vehicleId){
        this.assignedVehicleId = vehicleId;
    }

    public void freeSpot(){
        this.isFree = true;
    }


    public String getParkingSlotId() {
        return parkingSlotId;
    }

    public void setParkingSlotId(String parkingSlotId) {
        this.parkingSlotId = parkingSlotId;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public ParkingSpotType getParkingSpotType() {
        return parkingSpotType;
    }

    public void setParkingSpotType(ParkingSpotType parkingSpotType) {
        this.parkingSpotType = parkingSpotType;
    }

    public String getAssignedVehicleId() {
        return assignedVehicleId;
    }

    public void setAssignedVehicleId(String assignedVehicleId) {
        this.assignedVehicleId = assignedVehicleId;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "parkingSlotId='" + parkingSlotId + '\'' +
                ", isFree=" + isFree +
                ", parkingSpotType=" + parkingSpotType +
                ", assignedVehicleId='" + assignedVehicleId + '\'' +
                '}';
    }

}
