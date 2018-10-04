import java.io.*;
import java.util.*;

public class CurveFitting
{
	public static void main(String args[])
	{
		try
		{
			Scanner sc = new Scanner(new File("data.txt"));
			// FileInputStream fin = new FileInputStream("data.txt");
	
			int MAXR = Integer.parseInt(args[0]);
			int MAXC = Integer.parseInt(args[1]);
	
			double[][] a = new double[MAXR][MAXC];
	
			System.out.println("Enter the matrix...");
			for(int i = 0 ; i < MAXR ; i++)
			{
				for(int j = 0 ; j < 2 ; j++)
				{
					// a[i][j] = sc.nextDouble();
					a[i][j] = sc.nextDouble();
					System.out.println(a[i][j]);
				}
			}
			
			for(int i = 0 ; i < MAXR ; i++)
			{
				for(int j = 2 ; j < MAXC ; j++)
				{
					if(j == 2)
						//x * y
						a[i][j] = a[i][0] * a[i][1];
					else if(j == 3)
						//x^2
						a[i][j] = a[i][0] * a[i][0];
					else if(j == 4)
						//x^2 * y
						a[i][j] = a[i][0] * a[i][0]  * a[i][1];
					else if(j == 5)
						//x^3
						a[i][j] = a[i][0] * a[i][0] * a[i][0];
					else if(j == 6)
						//x^4
						// a[i][j] = a[i][0] * a[i][0] * a[i][0] * a[i][0];
						a[i][j] = a[i][0] * a[i][1] * a[i][1];
					else if(j == 7)
						// a[i][j] = a[i][0] * a[i][6];
						a[i][j] = a[i][0] * a[i][0] * a[i][1] * a[i][1];

					int x = (int)(a[i][j] * Math.pow(10, 2));
					a[i][j] = x / Math.pow(10, 2);
				}
			}

			
			System.out.println("x\ty\txy\tx^2\tx^2y\tx^3\tx^4");
			for(int i = 0 ; i < MAXR ; i++)
			{
				for(int j = 0 ; j < MAXC ; j++)
				{
					System.out.print(a[i][j] + "\t");
				}
				
				System.out.println();
			}
			
			// System.out.println("Sum...");
			for(int i = 0 ; i < MAXC ; i++)
			{
				double sum = 0;
				for(int j = 0 ; j < MAXR ; j++)
				{
					sum += a[j][i];
					// System.out.print(a[j][i] + " ");
					
				}
				int x = (int) (sum * Math.pow(10, 2));
				sum = x / Math.pow(10, 2);
				System.out.print(sum + "\t");
			}
			System.out.println();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}
}