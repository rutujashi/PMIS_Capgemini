package com.pmis_practice;
//4. Write a function that takes in the radius as input and returns the circumference of a circle. 
import java.util.*;
public class Example4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Radius: ");
		int r = sc.nextInt();
		
		fun1(r);
	}
	static void fun1(int r)
	{
		float c =(float)( 2 * 3.14 *r);
		System.out.println("Circumference of a circle: "+c);
	}

}
