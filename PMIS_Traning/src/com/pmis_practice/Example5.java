package com.pmis_practice;
//5. Write a function that takes in age as input and returns if that person is eligible to vote or not. A person of age > 18 is eligible to vote.
import java.util.*;
public class Example5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter age : ");
		int age = sc.nextInt();
		fun2(age);
	}
	static void fun2(int age)
	{
		if(age > 18)
		{
			System.out.println("Person is eligible to vote.");
		}
		else
		{
			System.out.println("Person is Not eligible to vote.");
		}
	}

}
