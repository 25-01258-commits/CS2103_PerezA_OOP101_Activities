import java.util.Scanner;

public class Canteen {

    public static void calculate() {
        double[] prices = { 80.00, 120.00, 100.00, 70.00, 90.00 };
        int totalQuantity = 0;
        double totalBeforeDiscount = 0.00;
        double totalDiscount = 0.00;

        Scanner input = new Scanner(System.in);
        char orderAgain = 'Y';

        while (orderAgain == 'Y') {
            System.out.print("\nEnter item number: ");
            int itemNumber = input.nextInt();

            System.out.print("Enter quantity: ");
            int quantity = input.nextInt();

            if (itemNumber < 1 || itemNumber > prices.length || quantity < 1 || quantity > 10) {
                System.out.println("\nInvalid order! Please enter a valid item and quantity.");
            } else {
                double orderSubtotal = prices[itemNumber - 1] * quantity;
                char studentAnswer;

                do {
                    System.out.print("Are you a student? (Y/N): ");
                    studentAnswer = input.next().toUpperCase().charAt(0);
                    if (studentAnswer != 'Y' && studentAnswer != 'N') {
                        System.out.println("Invalid answer, please enter Y or N.");
                    }
                } while (studentAnswer != 'Y' && studentAnswer != 'N');

                double discountRate = 0.00;
                if (studentAnswer == 'Y' && orderSubtotal >= 500.00) {
                    discountRate = 0.15;
                } else if (orderSubtotal >= 500.00) {
                    discountRate = 0.05;
                } else if (studentAnswer == 'Y') {
                    discountRate = 0.10;
                }

                double orderDiscount = orderSubtotal * discountRate;
                double orderTotal = orderSubtotal - orderDiscount;
                totalQuantity += quantity;
                totalBeforeDiscount += orderSubtotal;
                totalDiscount += orderDiscount;

                System.out.printf("\nSubtotal: $%.2f%n", orderSubtotal);
                System.out.printf("Discount: $%.2f%n", orderDiscount);
                System.out.printf("Order total: $%.2f%n", orderTotal);
            }

            do {
                System.out.print("\nDo you want to order again? (Y/N): ");
                orderAgain = input.next().toUpperCase().charAt(0);
                if (orderAgain != 'Y' && orderAgain != 'N') {
                    System.out.println("Invalid answer, please enter Y or N.");
                }
            } while (orderAgain != 'Y' && orderAgain != 'N');
        }

        System.out.println("\n===== ORDER SUMMARY =====");
        System.out.println("Total items: " + totalQuantity);
        System.out.printf("Total before discount: $%.2f%n", totalBeforeDiscount);
        System.out.printf("Total discount: $%.2f%n", totalDiscount);
        System.out.printf("Final amount: $%.2f%n", totalBeforeDiscount - totalDiscount);
        input.close();
    }

    public static void showMenu() {
        System.out.println("=====     M E N U     =====");
        System.out.printf("1. %-16s - $%7.2f%n", "Burger", 80.00);
        System.out.printf("2. %-16s - $%7.2f%n", "Pizza", 120.00);
        System.out.printf("3. %-16s - $%7.2f%n", "Chicken", 100.00);
        System.out.printf("4. %-16s - $%7.2f%n", "Sandwich", 70.00);
        System.out.printf("5. %-16s - $%7.2f%n", "Hotdog", 90.00);
    }

    public static void main(String[] args) {
        showMenu();
        calculate();
    }
}
