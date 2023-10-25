
public class Student
{
	private String name;
	private final int ID;
	private static int counter;


	public Student(String name)
	{
		//generate a new ID for student
		generateID();
		this.name = name;
		this.ID = counter;
	}

	private void generateID()
	{
		counter++;
	}
	
	public String toString()
	{
		return ID + "-" + name + "-Regular";
	}
	
	public int getID()
	{
		return ID;
	}
	
	public String getName()
	{
		return name;
	}

}
