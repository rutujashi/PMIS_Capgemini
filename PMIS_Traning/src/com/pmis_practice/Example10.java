package com.pmis_practice;
//10. Write a program to print Fibonacci series of n terms where n is input by user : 0 1 1 2 3 5 8 13 21 .....  In the Fibonacci series, a number is the sum of the previous 2 numbers that came before it. 
import java.util.*;
public class Example10 {

	public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
	  System.out.print("Enter n number: ");
	  int n = sc.nextInt();
	  
	  int a = 0;
      int b = 1;

      System.out.print("Fibonacci Series:");

      for (int i = 1; i <= n; i++) {
          System.out.print(a + " ");

          int c = a + b;
          a = b;
          b = c;

	}
	}
}
