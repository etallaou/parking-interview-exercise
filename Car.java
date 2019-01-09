public class Car extends Vehicle{
    private int neededSpace = 2;

    public Car(String licensePlate) {
        super(licensePlate);
    }

    public int getNeededSpace() {
        return neededSpace;
    }

    public String getInfo() {
        return "Car " + "\n" + " licensePlate" + getLicensePlate();
    }
}
