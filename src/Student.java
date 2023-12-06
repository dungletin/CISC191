
public class Student
{
	private String name;
	private int ID;
	private int grade;

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param ID
	 */
	public Student(String name, int ID)
	{
		this.name = name;
		this.ID = ID;
	}

	/**
	 * 
	 * @return
	 */
	public String getNameAndID()
	{
		return "ID: " + ID + " | Name: " + name + " | Grade: " + grade + "% | "
				+ "Regular";
	}

	public String toString()
	{
		return ID + "-" + name + "-Regular-" + getGrade();
	}

	public int getID()
	{
		return ID;
	}

	public void setGrade(int grade)
	{
		this.grade = grade;
	}

	public String getName()
	{
		return name;
	}

	public int getGrade()
	{
		return this.grade;
	}

}
