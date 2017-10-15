package com.company;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Commercial extends Customer{
    //declare all subclass variables as private
    private static String propertyName = "";
    private static boolean multi = false;
    private static double comRate = 0.00;

    private static Scanner scanner = new Scanner(System.in); // to get user input
    DecimalFormat priceFormatter = new DecimalFormat("$#,###.00"); //setting currency format

    //create subclass constructor
    public Commercial(String custName, String custPhone, String custAddress, double sqFootage,
                      double comRate, String propertyName, boolean multi) {

        super(custName, custPhone, custAddress, sqFootage);
        this.comRate = comRate;
        this.propertyName = propertyName;
        this.multi = multi;
    }

    //create subclass getters and setters for data access
    public static String getPropertyName() {

        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public static double getComRate() {
        return comRate;
    }

    public void setComRate(double comRate) {
        this.comRate = comRate;
    }
    public static boolean getMulti() {
        return multi;
    }

    public void setMulti(boolean multi) {
        this.multi = multi;
    }

    //subclass method to get commercial customer data from user via console
    public static void getCommercialInfo() {
        String buffer = "";
        Customer.getCustomerInfo();
        System.out.println("Please enter property name: ");
        propertyName = scanner.nextLine();

        System.out.println("Are multiple properties owned (Y/N): ");
        buffer = scanner.nextLine();
        char answer = buffer.charAt(0);
        if (answer == 'Y' || answer == 'y') {
            multi = true;
        } else {
            multi = false;
        }
    }

    //subclass method to calculate commercial weekly rate
    public static double calculateCommercialRate(double sqFootage, boolean multi) {
        double Rrate = 0.00;

        //if commercial customer has multiple properties, reduce weekly rate by 10%
        if (multi == false) {
            Rrate = sqFootage * 5.00;
            return Rrate;
        } else {
            Rrate = (sqFootage * 5.00) * .90;
            return Rrate;
        }

    }

    //subclass method to print commercial customer data to console
    public void printAllCom() {
        Customer.printAll();
        System.out.println("\nProperty Name: " + propertyName +
                "\nMultiple Properties: " + multi +
                "\nWeekly Commercial Rate: " + priceFormatter.format(calculateCommercialRate(getSqFootage(), multi)));
        if (multi == true) {
            System.out.println("\nA 10% discount for multiple properties has been applied to this commercial customer.");
        }
    }
}
