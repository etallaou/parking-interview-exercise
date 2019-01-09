import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Garage {
    private String GarageName;
    private List<Level> levels = new ArrayList<>();
    private Map<String, List<Integer>> vehicleParkedList = new HashMap();

    public Garage(String garageName) {
        this.GarageName = garageName;
    }

    public void addVehicleInParking(String licensePlate, List<Integer> parkingSlotId){
        vehicleParkedList.put(licensePlate, parkingSlotId);
    }

    public Map<String, List<Integer>> getVehicleParkedList() {
        return vehicleParkedList;
    }

    public void removeVehicleInParking(String licensePlate){
        vehicleParkedList.remove(licensePlate);
    }

    public String getGarageName() {
        return GarageName;
    }

    public List<Level> getLevels() {
        return levels;
    }

    public void addLevel(Level level) {
        levels.add(level);
    }
    public void deleteLevel(Level level) {
        levels.remove(level);
    }

}
