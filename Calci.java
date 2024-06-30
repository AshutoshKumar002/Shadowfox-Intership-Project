import java.util.Scanner;

public class Calci {
    
    public static void basicOperations(Scanner scanner) {
        System.out.println("\nBasic Operations:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Enter choice (1/2/3/4): ");
        int choice = scanner.nextInt();

        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        switch (choice) {
            case 1:
                System.out.println("Result: " + num1 + " + " + num2 + " = " + (num1 + num2));
                break;
            case 2:
                System.out.println("Result: " + num1 + " - " + num2 + " = " + (num1 - num2));
                break;
            case 3:
                System.out.println("Result: " + num1 + " * " + num2 + " = " + (num1 * num2));
                break;
            case 4:
                if (num2 != 0) {
                    System.out.println("Result: " + num1 + " / " + num2 + " = " + (num1 / num2));
                } else {
                    System.out.println("Error! Division by zero.");
                }
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }
    }

    public static void scientificCalculations(Scanner scanner) {
        System.out.println("\nScientific Calculations:");
        System.out.println("1. Square Root");
        System.out.println("2. Exponentiation");
        System.out.print("Enter choice (1/2): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter number: ");
                double num = scanner.nextDouble();
                System.out.println("Result: √" + num + " = " + Math.sqrt(num));
                break;
            case 2:
                System.out.print("Enter base number: ");
                double base = scanner.nextDouble();
                System.out.print("Enter exponent: ");
                double exponent = scanner.nextDouble();
                System.out.println("Result: " + base + "^" + exponent + " = " + Math.pow(base, exponent));
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }
    }

    public static void unitConversions(Scanner scanner) {
        System.out.println("\nUnit Conversions:");
        System.out.println("1. Temperature (Celsius to Fahrenheit and vice versa)");
        System.out.println("2. Currency (USD to EUR and vice versa)");
        System.out.print("Enter choice (1/2): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Convert (1) Celsius to Fahrenheit or (2) Fahrenheit to Celsius: ");
                int tempChoice = scanner.nextInt();
                if (tempChoice == 1) {
                    System.out.print("Enter temperature in Celsius: ");
                    double celsius = scanner.nextDouble();
                    double fahrenheit = (celsius * 9 / 5) + 32;
                    System.out.println(celsius + "°C = " + fahrenheit + "°F");
                } else if (tempChoice == 2) {
                    System.out.print("Enter temperature in Fahrenheit: ");
                    double fahrenheit = scanner.nextDouble();
                    double celsius = (fahrenheit - 32) * 5 / 9;
                    System.out.println(fahrenheit + "°F = " + celsius + "°C");
                } else {
                    System.out.println("Invalid Input");
                }
                break;
            case 2:
                System.out.print("Enter amount: ");
                double amount = scanner.nextDouble();
                System.out.print("Convert (1) USD to EUR or (2) EUR to USD: ");
                int currencyChoice = scanner.nextInt();
                double conversionRate = 0.85; // Example rate, update as needed
                if (currencyChoice == 1) {
                    double euros = amount * conversionRate;
                    System.out.println("$" + amount + " = €" + euros);
                } else if (currencyChoice == 2) {
                    double usd = amount / conversionRate;
                    System.out.println("€" + amount + " = $" + usd);
                } else {
                    System.out.println("Invalid Input");
                }
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Console Calculator ---");
            System.out.println("1. Basic Operations");
            System.out.println("2. Scientific Calculations");
            System.out.println("3. Unit Conversions");
            System.out.println("4. Exit");
            System.out.print("Enter choice (1/2/3/4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    basicOperations(scanner);
                    break;
                case 2:
                    scientificCalculations(scanner);
                    break;
                case 3:
                    unitConversions(scanner);
                    break;
                case 4:
                    System.out.println("Exiting the calculator. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
    }
}
    

