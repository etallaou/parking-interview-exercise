import java.util.ArrayList;
import java.util.List;

public class Level {
    private int levelNumber;
    private List<ParkingSlot> slots = new ArrayList<>();
    private long occupiedCount;

    public List<ParkingSlot> getSlots() {
        return slots;
    }

    public Level(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public long getOccupiedCount() {
        return occupiedCount;
    }

    public long getFreeSlotCount() {
        return slots.size() - occupiedCount;
    }

    public boolean isAvailable() {
        return getFreeSlotCount() > 0;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setSlots(List<ParkingSlot> slots) {
        this.slots = slots;
    }

    public void addSlot(ParkingSlot slot) {
        slots.add(slot);
    }

    public void removeSlot(ParkingSlot slot) {
        slots.remove(slot);
    }



    @Override    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Level level = (Level) o;

        return levelNumber == level.levelNumber;

    }

    @Override    public int hashCode() {
        return (int) (levelNumber ^ (levelNumber >>> 32));
    }
}
