/* Program to find the 
 * sum of digits
 * of a given number
*/

import java.util.*;

public class ClassFour
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("\nEnter any number : ");
		int a = scan.nextInt();
		
		int x = a;
		int sum = 0;
		while(x > 0)
		{
			sum += x % 10;
			x /= 10;
		}
		
		System.out.println("\nThe sum of digits of " + a + " is " + sum);
	}
}
