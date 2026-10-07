package com.pmis_practice;
import java.util.*;
public class Example9 {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 System.out.print("Enter a number: ");
		 int a = sc.nextInt();
		 System.out.print("Enter b number: ");
		 int b = sc.nextInt();
		 System.out.print("Enter n number: ");
		 int n = sc.nextInt();
		 
		 int GCD = 1;
		 for(int i =1;i<=n;i++)
		 {
			 if(a%i == 0 && b%i == 0)
			 {
				 GCD = i;
			 }
		 }
		 
		 System.out.println("GCD : "+GCD);
	}

}
