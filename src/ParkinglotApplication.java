import models.common.Address;
import models.parking.*;
import models.repository.ParkingLotRepository;
import models.vehicle.Vehicle;
import models.vehicle.VehicleType;

public class ParkinglotApplication {


    public static void main(String[] args) {

        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();

        // Test case 1
        Parkinglot parkinglot = parkingLotRepository.addParkingLot(new Parkinglot());
        System.out.println("parking lot: "+ parkinglot.toString());

        // test cae 2
        ParkingFloor parkingFloor1 = new ParkingFloor("1");
        parkingLotRepository.addParkingFloor(parkinglot.getParkingLotId(),parkingFloor1);

        ParkingFloor parkingFloor2 = new ParkingFloor("2");
        parkingLotRepository.addParkingFloor(parkinglot.getParkingLotId(),parkingFloor2);

        ParkingFloor parkingFloor3 = new ParkingFloor("3");
        parkingLotRepository.addParkingFloor(parkinglot.getParkingLotId(),parkingFloor3);

        // Test case 3
        EntryTerminal eterminal1 = new EntryTerminal("1");
        EntryTerminal eterminal2 = new EntryTerminal("2");
        parkingLotRepository.addEntryTerminal(parkinglot.getParkingLotId(), eterminal1);
        parkingLotRepository.addEntryTerminal(parkinglot.getParkingLotId(), eterminal2);

        // Test case 4
        ExitTerminal exitTerminal1 = new ExitTerminal("1");
        ExitTerminal exitTerminal2 = new ExitTerminal("2");
        parkingLotRepository.addExitTerminal(parkinglot.getParkingLotId(), exitTerminal1);
        parkingLotRepository.addExitTerminal(parkinglot.getParkingLotId(), exitTerminal2);

        String floorId = parkinglot.getParkingFloor().getFloorId();
        System.out.println("floorId: " + floorId);

        // Test case 5 add parking spot
        ParkingSpot parkingSpot1 = new ParkingSpot("1",ParkingSpotType.SMALL);
        ParkingSpot parkingSpot2 = new ParkingSpot("2",ParkingSpotType.MEDIUM);
        System.out.println("parkingSpot1: " + parkingSpot1);
        System.out.println("parkingSpot2: " + parkingSpot2);


        parkingLotRepository.addParkingSpot(parkinglot.getParkingLotId(),floorId,parkingSpot1);
        parkingLotRepository.addParkingSpot(parkinglot.getParkingLotId(),floorId,parkingSpot2);


        // Test case 1: check availability
        System.out.println(Parkinglot.INSTANCE.canPark(VehicleType.CAR) );


        // Tes case 6: provide address
        Address address = new Address();
        address.setCity("BBLR");
        address.setLandmark("Near Belandur");
        address.setPinCode("560103");


        // Test case 7: create vehicle
        Vehicle vehicle = new Vehicle("567880", VehicleType.CAR);
        ParkingSpot availableSpot = Parkinglot.INSTANCE.getParkingSpot(vehicle.getVehicleType()); ;

        System.out.println(availableSpot.getParkingSpotType() );
        System.out.println(availableSpot.getParkingSlotId());


    }

}
