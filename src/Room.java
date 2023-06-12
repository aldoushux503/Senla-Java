import java.util.Objects;

class Room {
    private final int roomNumber;
    private RoomStatus status;
    private double price;

    public Room(int roomNumber, double price) {
        this.roomNumber = roomNumber;
        this.status = RoomStatus.AVAILABLE;
        this.price = price;
    }

    public Room(Room room) {
        this.roomNumber = room.getRoomNumber();
        this.status = room.getStatus();
        this.price = room.getPrice();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return roomNumber == room.roomNumber && Double.compare(room.price, price) == 0 && status == room.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, status, price);
    }

    @Override
    public String toString() {
        return "Room %d: Status - %s, Price - %.1f".formatted(this.getRoomNumber(), this.getStatus(), this.getPrice());
    }
}
