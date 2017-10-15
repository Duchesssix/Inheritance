package com.company;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Residential extends Customer {

    //declare all subclass variables as private
    private static double resRate = 0.00;
    private static boolean senior = false;

    private static Scanner scanner = new Scanner(System.in); // to get user input
    DecimalFormat priceFormatter = new DecimalFormat("$#,###.00"); //setting currency format

    //create subclass constructor
    public Residential(String custName, String custPhone, String custAddress, double sqFootage,
                       double resRate, boolean senior) {

        super(custName, custPhone, custAddress, sqFootage);

        this.resRate = resRate;
        this.senior = senior;
    }

    //create subclass getters and setters for data access
    public static double getResRate() {
        return resRate;
    }

    public void setResRate(double resRate) {
        this.resRate = resRate;
    }

    public static boolean getSenior() {
        return senior;
    }

    public void setSenior(boolean senior) {
        this.senior = senior;
    }

    //subclass method to get residential customer data from user via console
    public static void getResidentialInfo() {
        String buffer = "";
        Customer.getCustomerInfo();
        System.out.println("Is customer a senior citizen (Y/N): ");
        buffer = scanner.nextLine();
        char answer = buffer.charAt(0);

        if (answer == 'Y' || answer == 'y') {
            senior = true;
        } else {
            senior = false;
        }

    }

    //subclass method to calculate residential weekly rate
    public static double calculateResidentialRate(double sqFootage, boolean senior) {
        double Rrate = 0.00;

        //if customer is a senior citizen, reduce weekly rate by 15%
        if (senior == false) {
            Rrate = sqFootage * 6.00;
            return Rrate;
        } else {
            Rrate = (sqFootage * 6.00) * .85;
            return Rrate;
        }

    }

    //subclass method to print residential customer data to console
    public void printAllRes() {
        Customer.printAll();
        System.out.println("\nSenior: " + senior +
                "\nWeekly Residential Rate: " + priceFormatter.format(calculateResidentialRate(getSqFootage(), senior)));

        if (senior == true) {
            System.out.println("\nA 15% senior citizen discount has been applied to this residential customer.");
        }

    }
}
