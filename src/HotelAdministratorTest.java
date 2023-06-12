package Task_4;

public class HotelAdministratorTest {
    public static void main(String[] args) {
        // Create an instance of the HotelAdministrator
        HotelAdministrator administrator = new HotelAdministrator();

        // Create some rooms
        Room room1 = new Room(101, 100.0);
        Room room2 = new Room(102, 150.0);

        // Add rooms to the administrator
        administrator.addRoom(room1);
        administrator.addRoom(room2);

        // Change the status and price of a room
        administrator.changeRoomStatus(room1, RoomStatus.OCCUPIED);
        administrator.changeRoomPrice(room2, 200.0);

        // Create some services
        Service service1 = new Service("Room Cleaning", 20.0);
        Service service2 = new Service("Laundry", 15.0);

        // Add services to the administrator
        administrator.addService(service1);
        administrator.addService(service2);

        // Change the price of a service
        administrator.changeServicePrice(service2, 18.0);

        // Perform check-in and check-out
        administrator.checkIn(room1);
        administrator.checkOut(room1);

        // Print the room and service details
        System.out.println("Room 1: Number - " + room1.getRoomNumber() + ", Status - " + room1.getStatus() + ", Price - " + room1.getPrice());
        System.out.println("Room 2: Number - " + room2.getRoomNumber() + ", Status - " + room2.getStatus() + ", Price - " + room2.getPrice());
        System.out.println("Service 1: Name - " + service1.getServiceName() + ", Price - " + service1.getPrice());
        System.out.println("Service 2: Name - " + service2.getServiceName() + ", Price - " + service2.getPrice());
    }
}

