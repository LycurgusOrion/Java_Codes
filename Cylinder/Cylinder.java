public class Cylinder
{
	float r;
	float l;
	float x;
	float sa;
	float vlm;
	float pi;
	float totalCost;

	Cylinder(float radius, float length, float cost)
	{
		System.out.println("\nConstructing Cylinder...");
		r = radius;
		l = length;
		x = cost;
		pi = 3.142857f;
	}

	~ Cylinder()
	{
		System.out.println("\nThank You for your Co-operation");
		System.out.println("Destroying Cylinder...");
	}

	void calculateParameters()
	{
		sa = 2 * pi * r * (r + l);
		
		vlm = pi * r * r * l;

		totalCost = x * sa;
	}
}