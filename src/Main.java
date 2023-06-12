package Task_2;

public class Main {
    public static void main(String[] args) {
        FlowerShop flowerShop = new FlowerShop();

        // Add flowers to the bouquet
        flowerShop.addFlower(new Rose());
        flowerShop.addFlower(new Lily());

        // Display the bouquet
        System.out.println("Bouquet:");
        flowerShop.displayBouquet();

        // Calculate and display the cost of the bouquet
        double bouquetCost = flowerShop.calculateBouquetCost();
        System.out.println("Bouquet Cost: $" + bouquetCost);
    }
}
