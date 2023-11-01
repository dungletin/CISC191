
public class TutoringStudent extends Student
{

	private final String type = "Tutoring";

	public TutoringStudent(String name, int ID)
	{
		super(name, ID);
	}

	@Override
	public String toString()
	{
		return super.getID() + "-" + super.getName() + "-" + type;
	}
}
