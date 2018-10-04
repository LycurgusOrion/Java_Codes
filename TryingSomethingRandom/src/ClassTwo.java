//Program to find even or odd

import java.util.*;

public class ClassTwo 
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("\nEnter any number : ");
		int x = scan.nextInt();
		if(x % 2 == 0)
			System.out.println("\nIts an even number!!!\n");
		else
			System.out.println("\nIts an odd number!!!\n");
	}
}
