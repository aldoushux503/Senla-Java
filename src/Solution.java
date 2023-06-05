package Task_1;

import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        int randomNumber = generateRandomNumber();
        int sumOfDigits = calculateSumOfDigits(randomNumber);

        System.out.println("Random Number: " + randomNumber);
        System.out.println("Sum of Digits: " + sumOfDigits);
    }

    // Method to generate a random three-digit natural number
    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(900) + 100; // Generates a random number between 100 and 999 (inclusive)
    }

    // Method to calculate the sum of the digits in a given number
    public static int calculateSumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10; // Extracts the last digit and adds it to the sum
            number /= 10; // Removes the last digit from the number
        }
        return sum;
    }
}
