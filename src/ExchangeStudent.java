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
 *         Responsibilities of class: Exchanged student class
 * 
 */
public class ExchangeStudent extends Student
{
	/**
	 * Constructor
	 * 
	 * @param name
	 * @param ID
	 */
	public ExchangeStudent(String name, int ID)
	{
		super(name, ID);
	}

	/**
	 * Method converts object to String
	 * 
	 * @return String
	 */
	@Override
	public String toString()
	{
		return super.getID() + "-" + super.getName() + "-Exchange-"
				+ super.getGrade();
	}

	/**
	 * Method returns information
	 */
	@Override
	public String getNameAndID()
	{
		return "ID: " + super.getID() + " | Name: " + super.getName()
				+ " | Grade: " + super.getGrade() + "% | " + "Exchange";
	}
}
