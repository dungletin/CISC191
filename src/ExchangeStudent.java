
public class ExchangeStudent extends Student
{
	private final String type = "Exchange";

	public ExchangeStudent(String name)
	{
		super(name);
	}

	
	@Override
	public String toString()
	{
		return super.getID() + "-" + super.getName() + "-" + type;
	}
}
