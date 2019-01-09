public abstract class ParkingSlot{
    private int slotNumber;
    private boolean isOccupied;


    public int getSlotNumber(){
        return slotNumber;
    }

    public boolean isOccupied(){
        return isOccupied;
    }

    public void setOccupied(boolean b){
        this.isOccupied = b;
    };
}
