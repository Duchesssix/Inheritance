package com.company;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {

        //declare and initialize variables
        Scanner scanner = new Scanner(System.in); // to get user input
        int selection = 0;
        String buffer = "";
        boolean exit = false; //user indicates end of program


        do {
            //display menu options
            System.out.println("\nEnter selection");
            System.out.println("1. Residential");
            System.out.println("2. Commercial");
            System.out.println("3. Exit");

            //get user menu selection
            //selection retrieved as a string and converted to int to consume newline
            buffer = scanner.nextLine();
            selection = Integer.parseInt(buffer);

            switch(selection) {
                case 1:  //Create residential Customer
                    Residential.getResidentialInfo();
                    Residential cust1 = new Residential (Customer.getCustName(), Customer.getCustPhone(),
                            Customer.getCustAddress(), Customer.getSqFootage(),
                            Residential.getResRate(), Residential.getSenior());
                    cust1.printAllRes();
                    selection = 0;
                    break;
                case 2: //Create commercial Customer
                    Commercial.getCommercialInfo();
                    Commercial comm1 = new Commercial (Customer.getCustName(), Customer.getCustPhone(),
                            Customer.getCustAddress(), Customer.getSqFootage(),
                            Commercial.getComRate(), Commercial.getPropertyName(), Commercial.getMulti());
                    comm1.printAllCom();
                    break;
                case 3:  //exit program
                    exit = true;
                    break;
                default:  //invalid selection
                    System.out.println("Invalid selection, please try again.");
                    break;
            }
        }while(!exit);

    }


}
