
public class TutoringStudent extends Student
{

	public TutoringStudent(String name, int ID)
	{
		super(name, ID);
	}

	@Override
	public String toString()
	{
		return super.getID() + "-" + super.getName() + "-Tutoring";
	}
}
