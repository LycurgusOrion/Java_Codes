//Program to print table of any number

import java.util.*;

public class ClassThree 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("\nEnter any number : ");
		int x = scan.nextInt();
		for(int i = 1 ; i <= 10 ; i++)
			System.out.println(x + " x " + i + " = " + (x * i));
	}
}
