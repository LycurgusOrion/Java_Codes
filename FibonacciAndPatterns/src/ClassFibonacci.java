//Program to print the first 
//n Fibonacci Series

import java.util.*;

public class ClassFibonacci 
{
	public static void main(String[] args) 
	{
	    Scanner scan = new Scanner(System.in);
	    System.out.print("Enter n : ");
	    int n = scan.nextInt();
	    int a = 0;
	    int b = 1;
	    System.out.print(a + " " + b + " ");
	    for(int i = 0 ; i < n ; i++)
	    {
	    	int t = a + b;
	    	a = b;
	    	b = t;
	    	System.out.print(t + " ");
	    }	
	}    
}
