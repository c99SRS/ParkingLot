package models.repository;

import models.exception.InvalidParkingFloorException;
import models.exception.InvalidParkinglotException;
import models.parking.*;

import java.util.*;

public class ParkingLotRepository {

    public Map<String, Parkinglot> parkinglotMap = new HashMap<>();
    public List<Parkinglot> parkinglotList = new ArrayList<>();


    public Parkinglot addParkingLot(Parkinglot parkinglot){
        parkinglotMap.put(parkinglot.getParkingLotId(),parkinglot);
        parkinglotList.add(parkinglot);

        return parkinglot;
    }


    public Parkinglot getParkinglot(String parkinglotId){
        return parkinglotMap.get(parkinglotId);
    }

    public ParkingFloor addParkingFloor(String parkingLotId, ParkingFloor parkingFloor){

        Parkinglot parkinglot = parkinglotMap.get(parkingLotId);

        if (parkinglot == null )
            throw new InvalidParkinglotException("Invalid Parking Id !!");

        Optional<ParkingFloor> optionalParkinglot =
                parkinglot.getParkingFloors().stream().filter(parkingFloor1 -> parkingFloor1.getFloorId().equalsIgnoreCase(parkingFloor.getFloorId())).findFirst();

        if (optionalParkinglot.isPresent())
            return optionalParkinglot.get();

        parkinglot.getParkingFloors().add(parkingFloor);
        return parkingFloor;
    }

    public ParkingSpot addParkingSpot(String parkinglotId, String parkingfloorId, ParkingSpot parkingSpot){

        Parkinglot parkinglot = parkinglotMap.get(parkinglotId);

        if (parkinglot == null )
            throw new InvalidParkinglotException("Invalid parking lot");

        Optional<ParkingFloor> floor =
                parkinglot.getParkingFloors().stream().filter(parkingFloor1 -> parkingFloor1.getFloorId().equalsIgnoreCase(parkingfloorId)).findFirst();

        if (!floor.isPresent())
            throw new InvalidParkingFloorException("Invalid Parking floor");

        Optional<ParkingSpot> optParkingSpot = floor.get().getParkingSpots().get(parkingSpot.getParkingSlotId()).stream()
                    .filter(pSpot ->pSpot.getParkingSlotId().equalsIgnoreCase(parkingSpot.getParkingSlotId())).findFirst();

        if (optParkingSpot.isPresent())
            return optParkingSpot.get();

        floor.get().getParkingSpots().get(parkingSpot.getParkingSpotType()).add(parkingSpot);
        return parkingSpot;
    }

    public EntryTerminal addEntryTerminal(String parkingLotId, EntryTerminal entryTerminal){

       Parkinglot parkinglot  = parkinglotMap.get(parkingLotId);

       if (parkinglot == null)
           throw new InvalidParkinglotException("Invalid parking lot");

       Optional<EntryTerminal> optTerminal =
               parkinglot.getEntryTerminals().stream().filter( entryTerminal1 -> entryTerminal1.getId().equalsIgnoreCase(entryTerminal.getId()) ).findFirst();

       if (optTerminal.isPresent())
           return optTerminal.get();

       parkinglotMap.get(parkingLotId).getEntryTerminals().add(entryTerminal);

        return entryTerminal;
    }

    public ExitTerminal addExitTerminal(String parkingLotId, ExitTerminal exitTerminal){

        Parkinglot parkinglot  = parkinglotMap.get(parkingLotId);

        if (parkinglot == null)
            throw new InvalidParkinglotException("Invalid parking lot");

        Optional<ExitTerminal> optTerminal =
                parkinglot.getExitTerminals().stream().filter( exitTerminal1 -> exitTerminal1.getId().equalsIgnoreCase(exitTerminal.getId()) ).findFirst();

        if (optTerminal.isPresent())
            optTerminal.get();

        parkinglotMap.get(parkingLotId).getExitTerminals().add(exitTerminal);

        return exitTerminal;
    }




}
