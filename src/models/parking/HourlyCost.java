package models.parking;

import java.util.HashMap;
import java.util.Map;

public class HourlyCost {

    private Map<ParkingSpotType, Double> hourlyCost = new HashMap<>();

    public  HourlyCost(){
        hourlyCost.put(ParkingSpotType.LARGE,40.0);
        hourlyCost.put(ParkingSpotType.MEDIUM,20.0);
        hourlyCost.put(ParkingSpotType.SMALL,10.0);
        hourlyCost.put(ParkingSpotType.VERYLARGE,50.0);
    }


    public Double getCost(ParkingSpotType parkingSpotType){
        return hourlyCost.get(parkingSpotType);
    }

}
