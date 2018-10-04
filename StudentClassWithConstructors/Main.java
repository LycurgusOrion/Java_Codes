/****************************

	Program to create:
		-Student class
		-Initialize for 3 Students
		-Using default and parameterized 
			Constructors

****************************/

class Main
{
	public static void main(String[] args) 
	{
		System.out.println("\n__________");
		System.out.println("Student 1:");
		System.out.println("----------");
		Student S1 = new Student();
		S1.getData();
		S1.setData();
		S1.getData();

		System.out.println("\n__________");
		System.out.println("Student 2:");
		System.out.println("----------");
		Student S2 = new Student(44, 558309.0f);
		S2.getData();
		S2.setData();
		S2.getData();
		
		System.out.println("\n__________");
		System.out.println("Student 3:");
		System.out.println("----------");
		Student S3 = new Student(10);
		S3.getData();
		S3.setData();
		S3.getData();
	}
}