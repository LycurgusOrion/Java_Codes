import java.util.*;
import java.io.*;

public class StudentDetails 
{
	int id;
	int sem;
	String name;
	String address;

	public void setData()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter the Student Details : ");
		System.out.println("\nID       : ");
		id = nextInt();
		System.out.println("\nName     : ");
		name = sc.nextLine();
		System.out.println("\nAddress  : ");
		address = sc.nextLine();
		System.out.println("\nSemester : ");
		sem = sc.nextInt();
		System.out.println("\nStudent details stored successfuly!");
	}

	public void getData()
	{
		System.out.println("\nSTUDENT DETAILS\n");
		System.out.println("\nName 	   : " + name);
		System.out.println("\nID	   : " + id);
		System.out.println("\nAddress  : " + address);
		System.out.println("\nSemester : " + sem);
	}    
}
