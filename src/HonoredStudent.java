/**
 * Lead Author(s):
 * 
 * @author Tien Dung Le
 * @author Meidyn Nguyen
 * 
 * 
 *         References:
 *         Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented
 *         Problem Solving.
 *         Retrieved from
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 * 
 *         Version/date: 12/12/2023
 * 
 *         Responsibilities of class: Honored Student class
 * 
 */
public class HonoredStudent extends Student
{

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param ID
	 */
	public HonoredStudent(String name, int ID)
	{
		super(name, ID);
	}

	/**
	 * toString method
	 * 
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

	/**
	 * Method calculate grade for honored student
	 * Honored student will receive 10% extra
	 */
	@Override
	public int calculateGrade(int grade)
	{
		int newGrade = grade * 110 / 100;
		if (newGrade > 100)
		{
			return 100;
		}

		return newGrade;
	}

}
