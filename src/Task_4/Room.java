package Task_4;

class Room {
    private final int roomNumber;
    private RoomStatus status;
    private double price;

    public Room(int roomNumber, double price) {
        this.roomNumber = roomNumber;
        this.status = RoomStatus.AVAILABLE;
        this.price = price;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
