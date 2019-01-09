import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public abstract class ParkingManager extends ParkingSlot{
    protected Garage cityParking;


    /* return list of levels of garage*/
    private List<Level> getLevels() {
        return cityParking.getLevels();
    }

    /*Get all available Slot in the garage*/
    public List<ParkingSlot> getAllSlots(){
        final List<ParkingSlot> result = new ArrayList<>();
        for (Level level: getLevels()){
            for (ParkingSlot slot: level.getSlots()){
                if (!slot.isOccupied()){
                    result.add(slot);
                }
            }
        }
        return result;
    }

    /*release a parking's slot*/
    public void setSlotFree(int slotNumber){
        for (ParkingSlot slot: getAllSlots()){
            if (slot.getSlotNumber() == slotNumber){
                slot.setOccupied(false);
            }
        }
    }

    /*list of non occupied slot*/
    public List<ParkingSlot> getAvailableSlots(){
        final List<ParkingSlot> result = new ArrayList<>();
        for (Level level: getLevels()){
            for (ParkingSlot slot: level.getSlots()){
                if (!slot.isOccupied()){
                    result.add(slot);
                }
            }
        }
        return result;
    }

    private ParkingSlot pickRandomSlot() {
        final List<ParkingSlot> availableSlots = getAvailableSlots();
        if (getAvailableSlots().size() > 0){
            final int randomNum = ThreadLocalRandom.current().nextInt(1, availableSlots.size());
            return availableSlots.get(randomNum);
        } else {
            return null;
        }

    }

    /*Return all parked vehilcle*/
    public  Map<String, List<Integer>> getVehiclesParked(){
        return cityParking.getVehicleParkedList();
    }

    /*Park a Vehicle and a the vehicle in parkedVehicles and set the slot as occuppied*/
    public void parkVehicleInSlot(String licensePlate){
        final ParkingSlot freeSlot =  pickRandomSlot();
        if (freeSlot == null){
            System.out.println("No Spot available");
        } else {
            /*Set the slot as occupied*/
            freeSlot.setOccupied(true);
            final List<Integer> parkingSlotId = Arrays.asList(freeSlot
                    .getSlotNumber(), getLevelByParkingSlot(freeSlot)
                    .getLevelNumber());
            /*add the vehicle in the parked vehicle list*/
            cityParking.addVehicleInParking(licensePlate, parkingSlotId);
        }
    }

    /*Find a Vehicle in the garage */
    public List<Integer> findVehicleInParking(String licensePlate){
        return getVehiclesParked().get(licensePlate);
    }

    /*Remove a vehicle from the garage*/
    public void removeVehicleFromParking(String licensePlate){
        Map<String, List<Integer>> vehicleParkedList = getVehiclesParked();
        List<Integer> toReleaseSlot = vehicleParkedList.get(licensePlate);
        cityParking.removeVehicleInParking(licensePlate);
        /*Release the slot*/
        setSlotFree(toReleaseSlot.get(0));
    }

    public Level getLevelByParkingSlot(ParkingSlot parkingSlot){
        for (Level level: getLevels()){
            if (level.getSlots().contains(parkingSlot)){
                return level;
            }
        }
        return null;
    }

}
