import java.util.*;

public class Student
{
	int rno;
	float fee;

	Student()
	{
		rno = 0;
		fee = 0.0f;
	}
	
	Student(int x, float y)
	{
		rno = x;
		fee = y;
	}

	Student(int x)
	{
		rno = x;
	}

	void setData()
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("\nEnter Roll No.	: ");
		rno = sc.nextInt();

		System.out.println("\nEnter Student Fee	: ");
		fee = sc.nextFloat();
	}

	void getData()
	{
		System.out.println("\n_______________");
		System.out.println("STUDENT DETAILS");
		System.out.println("---------------");
		System.out.println("\nRollNo.	: " + rno);
		System.out.println("Fees	: " + fee);
	}
}