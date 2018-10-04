import java.util.Scanner;

public class Student 
{
	int rollNo;
	String name;
	int sem;
	int[] marks = new int[10];
	int numberOfSubjects;
	float averageMarks;

	public Student(int inputSubjects)
	{
		numberOfSubjects = inputSubjects;
	}

	public void setData()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter the Student Details :");
		System.out.print("\nName     : ");
		name = sc.nextLine();
		System.out.print("\nRollNo   : ");
		rollNo = sc.nextInt();
		System.out.print("\nSemester : ");
		sem = sc.nextInt();

		System.out.print("\nEnter the marks :");
		for(int i = 0 ; i < numberOfSubjects ; i++) 
		{
			System.out.print("\nM" + (i + 1) + " : ");
			marks[i] = sc.nextInt();	
		}
	}

	public void calculateAverage()
	{
		int sum = 0;
		for(int i = 0 ; i < numberOfSubjects ; i++)
			sum += marks[i];
		averageMarks = (float)sum / (float)numberOfSubjects;
	}

	public void getData()
	{
		System.out.println("\nSTUDENT DETAILS");
		System.out.println("Name      : " + name);
		System.out.println("RollNo    : " + rollNo);
		System.out.println("Semester  : " + sem);
		System.out.println("Marks : ");
		for (int i = 0 ; i < numberOfSubjects ; i++) 
			System.out.print("\nM" + (i + 1) + " = " + marks[i]);
		calculateAverage();
		System.out.println("\nAverage : " + averageMarks);
	}  
}