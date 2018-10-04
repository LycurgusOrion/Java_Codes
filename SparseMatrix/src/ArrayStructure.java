import java.util.Scanner;

public class ArrayStructure 
{
	Scanner sc = new Scanner(System.in);
	
	private int[] anArray = new int[100];

	private int arraySize;

	public void getArray()
	{
		System.out.print("\nEnter the array size : ");
		arraySize = sc.nextInt();

		for(int i = 0 ; i < arraySize ; i++) 
			anArray[i] = (int)(Math.random() * 90) + 10;
	}

	public void printArray()
	{
		System.out.println("\nThis is the array : ");

		for(int i = 0 ; i < arraySize ; i++)
		{
			System.out.print("| " + i + " |");
			System.out.print("| " + anArray[i] + " |\n");
		} 
	}

	protected

	public void sortArray()
	{
		for(int i = 0 ;i < arraySize ; i++)
		{
					
		}
	}
}
