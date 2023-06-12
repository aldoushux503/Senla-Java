import java.util.Objects;

public class Service {
    private final String serviceName;
    private double price;

    public Service(String serviceName, double price) {
        this.serviceName = serviceName;
        this.price = price;
    }

    public Service(Service service) {
        this.serviceName = service.getServiceName();
        this.price = service.getPrice();
    }

    public String getServiceName() {
        return serviceName;
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
        Service service = (Service) o;
        return Double.compare(service.price, price) == 0 && Objects.equals(serviceName, service.serviceName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceName, price);
    }

    @Override
    public String toString() {
        return "Service: Name - %s, Price - %.1f".formatted(this.getServiceName(), this.getPrice());
    }
}
