
public class TutoringStudent extends Student
{

	public TutoringStudent(String name, int ID)
	{
		super(name, ID);
	}

	@Override
	public String toString()
	{
		return super.getID() + "-" + super.getName() + "-Tutoring-"
				+ super.getGrade();
	}

	@Override
	public String getNameAndID()
	{
		return "ID: " + super.getID() + " | Name: " + super.getName()
				+ " | Grade: " + super.getGrade() + "% | " + "Tutoring";
	}
}
