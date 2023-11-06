
public class HonoredStudent extends Student
{

	public HonoredStudent(String name, int ID)
	{
		super(name, ID);
	}

	@Override
	public String toString()
	{
		return super.getID() + "-" + super.getName() + "-Honored";
	}

}
