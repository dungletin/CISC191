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
 *         Responsibilities of class: Student class will be the parent class an
 *         other types of student can be
 *         inherited by student class
 * 
 */
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
	 * @return the student information seperated by "|"
	 */
	public String getNameAndID()
	{
		return "ID: " + ID + " | Name: " + name + " | Grade: " + grade + "% | "
				+ "Regular";
	}

	/**
	 * @return String the information of student seperated by "-"
	 */
	public String toString()
	{
		return ID + "-" + name + "-Regular-" + getGrade();
	}

	/**
	 * Method return ID
	 * 
	 * @return ID
	 */
	public int getID()
	{
		return ID;
	}

	/**
	 * Method set grade
	 * 
	 * @param grade
	 */
	public void setGrade(int grade)
	{
		this.grade = grade;
	}

	/**
	 * Method return name
	 * 
	 * @return name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Method return the grade
	 * 
	 * @return grade
	 */
	public int getGrade()
	{
		return this.grade;
	}

	/**
	 * Method that calculates the grade
	 * 
	 * @return new grade
	 */
	public int calculateGrade(int newGrade)
	{
		return newGrade;
	}

}
