public class Employee
{
	int id;
	String name;
	float sal;
	String dept;

	Employee(int id, String name, float sal, String dept)
	{
		this.id = id;
		this.name = name;
		this.sal = sal;
		this.dept = dept;
	}

	Employee(ResultSet rs)
	{
		id = rs.getInt(1);
		name = rs.getString(2);
		sal = rs.getInt(3);
		dept = rs.getString(4);
	}
}