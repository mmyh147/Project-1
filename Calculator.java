import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    private static ArrayList<Double> resultsList = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            printMenu();
            choice = getUserChoice();

            switch (choice) {
                case 1:
                     addition();
                    break;
                case 2:
                    subtraction();
                    break;
                case 3:
                    multiplication();
                    break;
                case 4:
                    division();
                    break;
                case 5:
                    modulus();
                    break;
                case 6:
                    findMin();
                    break;
                case 7:
                    findMax();
                    break;
                case 8:
                    findAverage();
                    break;
                case 9:
                    printLastResult();
                    break;
                case 10:
                    printAllResults();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 0);
    }

    public static void printMenu() {
        System.out.println("Calculator Menu:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Modulus");
        System.out.println("6. Find Minimum (Enter three numbers)");
        System.out.println("7. Find Maximum (Enter three numbers)");
        System.out.println("8. Find Average");
        System.out.println("9. Print Last Result");
        System.out.println("10. Print All Results");
        System.out.println("0. Exit");
    }

    public static int getUserChoice() {
        System.out.print("Enter your choice number: ");
        try {
            return input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            input.next();
            return -1;
        }
    }

    public static void addition() {
        System.out.println("Enter the first number: ");
        double num1 = getNumber();
        System.out.println("Enter the second number: ");
        double num2 = getNumber();
        double result = num1 + num2;
        addToResultsList(result);
        System.out.println("Addition result: " + result);
    }

    public static void subtraction() {
        System.out.println("Enter the first number: ");
        double num1 = getNumber();
        System.out.println("Enter the second number: ");
        double num2 = getNumber();
        double result = num1 - num2;
        addToResultsList(result);
        System.out.println("Subtraction result: " + result);
    }

    public static void multiplication() {
        System.out.println("Enter the first number: ");
        double num1 = getNumber();
        System.out.println("Enter the second number: ");
        double num2 = getNumber();
        double result = num1 * num2;
        addToResultsList(result);
        System.out.println("Multiplication result: " + result);
    }

    public static void division() {
        System.out.println("Enter the first number: ");
        double num1 = getNumber();
        System.out.println("Enter the second number: ");
        double num2 = getNumber();
        if (num2 == 0) {
            System.out.println("Division by zero is not allowed.");
            return;
        }
        double result = num1 / num2;
        addToResultsList(result);
        System.out.println("Division result: " + result);
    }

    private static void modulus() {
        System.out.println("Enter the number: ");
        double num1 = getNumber();
        System.out.println("Enter the Modulus: ");
        double num2 = getNumber();
        double result = num1 % num2;
        addToResultsList(result);
        System.out.println("Modulus result: " + result);
    }

    private static void findMin() {
        System.out.println("Enter the first number: ");
        double num1 = getNumber();
        System.out.println("Enter the second number: ");
        double num2 = getNumber();
        System.out.println("Enter the third number: ");
        double num3 = getNumber();
        double result = Math.min(Math.min(num1, num2), num3);
        addToResultsList(result);
        System.out.println("Minimum result: " + result);

    }

    private static void findMax() {
        System.out.println("Enter the first number: ");
        double num1 = getNumber();
        System.out.println("Enter the second number: ");
        double num2 = getNumber();
        System.out.println("Enter the third number: ");
        double num3 = getNumber();
        double result = Math.max(Math.max(num1, num2), num3);
        addToResultsList(result);
        System.out.println("Maximum result: " + result);
    }

    private static void findAverage() {
        System.out.println("Enter the first number: ");
        double num1 = getNumber();
        System.out.println("Enter the second number: ");
        double num2 = getNumber();
        System.out.println("Enter the third number: ");
        double num3 = getNumber();
        double result = (num1 + num2 + num3) / 3;
        addToResultsList(result);
        System.out.println("Average result: " + result);

    }

    private static void printLastResult() {
        if(resultsList.isEmpty()){
            System.out.println("There are no results!");
        }else{

            System.out.println("Last Result: " + resultsList.getLast());
        }
    }

    private static void printAllResults() {
        if (resultsList.isEmpty()) {
            System.out.println("No results available.");
        } else {
            System.out.println("All Results:");
            for (Double result : resultsList) {
                System.out.println(result);
            }
        }
    }

    private static double getNumber() {
        while (true) {
            try {
                return input.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                input.next();
            }
        }
    }

    private static void addToResultsList(double result) {

        resultsList.add(result);
    }
}
