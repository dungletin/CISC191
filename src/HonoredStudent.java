
public class HonoredStudent extends Student
{

	private final String type = "Honored";
	public HonoredStudent(String name)
	{
		super(name);
	}
	
	
	
	
	@Override
	public String toString()
	{
		return super.getID() + "-" + super.getName() + "-" + type;
	}

}
