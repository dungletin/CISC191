import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StudentInformation
{
	private ArrayList<Student> students = new ArrayList<Student>();

	public StudentInformation()

	{
		readFile();
	}

	/**
	 * Method read the file and add information that has been read in to the
	 * student array list
	 * 
	 */
	public void readFile()
	{
		try
		{
			BufferedReader reader = new BufferedReader(
					new FileReader("text.txt"));
			String line;
			while ((line = reader.readLine()) != null)
			{
				// split the line into a string array between "-"
				String[] info = line.split("-");

				// in the text file the second string of the line is the name
				// use the name to create a new student object
				// then add student into the array
				Student student;
				if (info[2].equals("Exchange"))
				{
					student = new ExchangeStudent(info[1]);
				}
				else if (info[2].equals("Honored"))
				{
					student = new HonoredStudent(info[1]);

				}
				else if (info[2].equals("Tutoring"))
				{
					student = new TutoringStudent(info[1]);

				}
				else
				{
					student = new Student(info[1]);
				}

				students.add(student);
			}
			reader.close();

		}
		catch (IOException e)
		{

			e.printStackTrace();
		}
	}

	public ArrayList<Student> getStudentList()
	{
		return students;
	}
}
