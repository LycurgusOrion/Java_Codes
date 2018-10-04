//Program to print 
//the given Pattern

import java.util.*;

public class ClassPatterns 
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the number of rows : ");
		int n = scan.nextInt();
		
		for(int i = 0 ; i < n ; i++)
		{
			for(int x = n ; x > i ; x--)
				System.out.print(" ");
			for(int j = 0 ; j < i ; j++)
				System.out.print("* ");
			System.out.print("\n");
		}
		
		System.out.println("\nNext Pattern : ");

		for(int k = 0 ; k < n ; k++)
		{
			for(int y = n ; y > k ; y--)
				System.out.print(" ");
			for(int l = 0 ; l < k ; l++)
				System.out.print("* ");
			System.out.print("\n");
		}
		for(int a = n ; a > 0 ; a--)
		{
			for(int z = n ; z > a ; z--)
				System.out.print(" ");
			for(int b = a ; b > 0 ; b--)
				System.out.print("* ");
			System.out.print("\n");
		}
	}    
}
