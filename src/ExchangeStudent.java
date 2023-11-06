
public class ExchangeStudent extends Student
{

	public ExchangeStudent(String name, int ID)
	{
		super(name, ID);
	}

	@Override
	public String toString()
	{
		return super.getID() + "-" + super.getName() + "-Exchange";
	}
}
