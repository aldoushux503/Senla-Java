package Task_2;

import java.util.ArrayList;
import java.util.List;

public class FlowerShop {
    private List<Flower> bouquet;

    public FlowerShop() {
        bouquet = new ArrayList<>();
    }

    public void addFlower(Flower flower) {
        bouquet.add(flower);
    }

    public double calculateBouquetCost() {
        double totalCost = 0.0;

        for (Flower flower : bouquet) {
            totalCost += flower.getPrice();
        }

        return totalCost;
    }

    public void displayBouquet() {
        for (Flower flower : bouquet) {
            System.out.println(flower.getName() + ": " + flower.getDescription());
        }
    }
}
