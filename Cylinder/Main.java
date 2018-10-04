/************************************

	Program to calculate:
		-Surface Area
		-Volume and
		-Cost of building a Cylinder
	Given:
		-Radius
		-Length of it

*************************************/

public class Main 
{
	public static void main(String[] args) 
	{
		if(args.length != 3)
		{
			System.out.println("errror : invalid arguments");
			return;
		}

		Cylinder C = new Cylinder(Float.valueOf(args[0]), Float.valueOf(args[1]), Float.valueOf(args[2]));

		C.calculateParameters();

		System.out.println("\nRadius		= " + C.r + "m");
		System.out.println("Length		= " + C.l + "m");

		System.out.println("Surface Area 	= " + C.sa + "m^2");
		System.out.println("Volume 		= " + C.vlm + "m^3");
		System.out.println("Cost		= " + "INR "+ C.totalCost + "/-");
	}
}
