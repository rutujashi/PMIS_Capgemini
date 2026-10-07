package com.pmis_practice;
//Write a program to enter the numbers till the user wants and at the end it should display the count of positive, negative and zeros entered. 
import java.util.Scanner;

class  Example7{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int positive = 0;
        int negative = 0;
        int zero = 0;
        char choice;

        do {
            System.out.print("Enter number: ");
            int num = sc.nextInt();

            if (num > 0) 
            {
                positive++;
            } 
            else if (num < 0) 
            {
                negative++;
            } 
            else 
            {
                zero++;
            }

            System.out.print("Do you want to continue? (y/n): ");
            choice = sc.next().charAt(0);

        } 
        while (choice == 'y' || choice == 'Y');

        System.out.println("Positive numbers = " + positive);
        System.out.println("Negative numbers = " + negative);
        System.out.println("Zeros = " + zero);
    }
}
