package com.pmis_practice;
//8. Two numbers are entered by the user, x and n. Write a function to find the value of one number raised to the power of another i.e. 𝑥 𝑛 .
import java.util.*;
public class Example8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter n number: ");
		double n = sc.nextDouble();
		System.out.print("Enter x number: ");
		double x = sc.nextDouble();
		
		double pow = Math.pow(n, x);
		System.out.println("Power : "+pow);

	}

}
