import java.util.Date;
import java.util.Objects;

class Room {
    private final int roomNumber;
    private RoomStatus status;
    private double price;
    private int capacity;
    private int stars;
    private Guest guest;

    public Room(int roomNumber, double price, int capacity, int stars) {
        this.roomNumber = roomNumber;
        this.status = RoomStatus.AVAILABLE;
        this.price = price;
        this.capacity = capacity;
        this.stars = stars;
    }

    public Room(Room room) {
        this.roomNumber = room.roomNumber;
        this.status = room.status;
        this.price = room.price;
        this.capacity = room.capacity;
        this.stars = room.stars;
        this.guest = room.guest;
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

    public int getCapacity() {
        return capacity;
    }

    public int getStars() {
        return stars;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public boolean isAvailableOnDate(Date date) {
        if (status != RoomStatus.AVAILABLE) {
            return false;
        }
        if (guest == null) {
            return true;
        }
        Date checkOutDate = guest.getCheckOutDate();
        return checkOutDate.before(date);
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
