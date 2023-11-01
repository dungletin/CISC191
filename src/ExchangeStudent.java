
public class ExchangeStudent extends Student
{
	private final String type = "Exchange";

	public ExchangeStudent(String name, int ID)
	{
		super(name, ID);
	}

	@Override
	public String toString()
	{
		return super.getID() + "-" + super.getName() + "-" + type;
	}
}
