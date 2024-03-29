package restauraunt;

import java.util.Scanner;

public class Restaurant {
    private static final int MAX_ITEMS = 100;  // Maximum number of food items
    private static String[] foodItems = new String[MAX_ITEMS];
    private static double[] foodPrices = new double[MAX_ITEMS];
    private static int numItems = 0;

    private static String[] orderItems = new String[MAX_ITEMS];
    private static double[] orderPrices = new double[MAX_ITEMS];
    private static int numOrderItems = 0;
public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int choice;
    double bill = 0;

    // Initialize menu with some items and their prices
    addItem(" Pilau", 80);
    addItem("ugali matumbo", 40);
    addItem("managu Beef", 150);
    addItem("Sprite", 80);
    addItem("Coke", 70);
    addItem("Fanta", 100);
    addItem("delmonte", 250);

    System.out.println("Welcome to our restaurant! Please select an option:");
    do {
        // Print menu
        System.out.println("1. View Menu");
        System.out.println("2. Add Item to Order");
        System.out.println("3. View Order");
        System.out.println("4. Pay with Mobile Money");
        System.out.println("0. Exit");

        // Get user's choice
        choice = input.nextInt();

        // Handle user's choice
        switch (choice) {
            case 1:
                // Print menu
                System.out.println("Menu:");
                for (int i = 0; i < numItems; i++) {
                    System.out.println((i + 1) + ". " + foodItems[i] + " - " + foodPrices[i] + " KSH");
                }
                break;
            case 2:
                // Add item to order
                System.out.println("Enter item number:");
                int itemNum = input.nextInt();
                if (itemNum > 0 && itemNum <= numItems) {
                    System.out.println("Enter quantity:");
                    int quantity = input.nextInt();
                    bill += foodPrices[itemNum - 1] * quantity;
                    System.out.println(quantity + " " + foodItems[itemNum - 1] + "(s) added to order.");
                } else {
                    System.out.println("Invalid item number.");
                }
                break;
            case 3:
                // View order
                System.out.println("Your Order:");
                if (bill == 0) {
                    System.out.println("No items in order.");
                } else {
                    System.out.println("Total bill: " + bill + " KSH");
                }
                break;
            case 4:
                // Pay with mobile money
                if (bill == 0) {
                    System.out.println("No items in order.");
                } else {
                    System.out.println("Enter mobile money number:");
                    String mobileMoney = input.next();
                    System.out.println("You have paid " + bill + " KSH with " + mobileMoney + ".");
                    bill = 0;
                }
                break;
            case 0:
                // Exit
                System.out.println("Thank you for visiting our restaurant!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    } while (choice != 0);
}

   private static void addItem(String name, double price) {
    if (numItems < MAX_ITEMS) {
        foodItems[numItems] = name;
        foodPrices[numItems] = price;
        numItems++;
    } else {
        System.out.println("Sorry, maximum items reached.");
    }
}

}


