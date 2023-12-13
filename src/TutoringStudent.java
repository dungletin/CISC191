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
 *         Responsibilities of class: Tutoring Student class
 * 
 */
public class TutoringStudent extends Student
{
	/**
	 * Constructor
	 * 
	 * @param name
	 * @param ID
	 */
	public TutoringStudent(String name, int ID)
	{
		super(name, ID);
	}

	/**
	 * Method convert object to String
	 * 
	 * @return information of the student separated by "-"
	 */
	@Override
	public String toString()
	{
		return super.getID() + "-" + super.getName() + "-Tutoring-"
				+ super.getGrade();
	}

	/**
	 * Method return information of the student separated by "|"
	 * 
	 * @return String
	 */
	@Override
	public String getNameAndID()
	{
		return "ID: " + super.getID() + " | Name: " + super.getName()
				+ " | Grade: " + super.getGrade() + "% | " + "Tutoring";
	}
}
