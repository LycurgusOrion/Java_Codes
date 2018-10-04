//Program to reverse a number

import java.util.*;

public class ClassFive 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("\nEnter any number : ");
		int a = scan.nextInt();
		
		int x = a;
		int rev = 0;
		while(x > 0)
		{
			rev = x % 10 + rev * 10;
			x /= 10;
		}
		
		System.out.println("\nThe reverse of " + a + " is " + rev);
	}
}