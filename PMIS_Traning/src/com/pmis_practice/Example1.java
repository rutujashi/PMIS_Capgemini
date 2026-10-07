package com.pmis_practice;
//1. Enter 3 numbers from the user & make a function to print their average. 

import java.util.*;

class Example1 {

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter First Number:");
	        int num1 = sc.nextInt();

	        System.out.print("Enter Second Number:");
	        int num2 = sc.nextInt();

	        System.out.print("Enter Third Number:");
	        int num3 = sc.nextInt();

	        avg(num1, num2, num3);
	    }

	    static void avg(int a, int b, int c) 
	    {
	        int avg = (a + b + c) / 3;
	        System.out.println("Average:- "+avg);
	    }
}


