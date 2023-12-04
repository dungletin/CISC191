
public class ExchangeStudent extends Student
{

	public ExchangeStudent(String name, int ID)
	{
		super(name, ID);
	}

	@Override
	public String toString()
	{
		return super.getID() + "-" + super.getName() + "-Exchange-"
				+ super.getGrade();
	}

	@Override
	public String getNameAndID()
	{
		return "ID: " + super.getID() + " | Name: " + super.getName()
				+ " | Grade: " + super.getGrade() + "% | " + "Exchange";
	}
}
