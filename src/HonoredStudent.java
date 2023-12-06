
public class HonoredStudent extends Student
{

	/**
	 * Constructor
	 * @param name
	 * @param ID
	 */
	public HonoredStudent(String name, int ID)
	{
		super(name, ID);
	}

	/**
	 * toString method
	 * @return String
	 */
	@Override
	public String toString()
	{
		return super.getID() + "-" + super.getName() + "-Honored-" + getGrade();
	}

	/**
	 * @return String contains student information seperated by "|"
	 */
	@Override
	public String getNameAndID()
	{
		return "ID: " + super.getID() + " | Name: " + super.getName()
				+ " | Grade: " + super.getGrade() + "% | " + "Honored";
	}

}
