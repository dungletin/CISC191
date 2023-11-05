import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class StudentInformation
{

	private ArrayList<Student> students = new ArrayList<Student>();

	/**
	 * Constructor
	 */
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
				
				String name = info[1];
				int ID = Integer.valueOf(info[0]);
				String type = info[2];

				// check the third word in the line to see the type and create
				// it by that type
				if (type.equals("Exchange"))
				{
					student = new ExchangeStudent(name, ID);
				}
				else if (type.equals("Honored"))
				{
					student = new HonoredStudent(name, ID);

				}
				else if (type.equals("Tutoring"))
				{
					student = new TutoringStudent(name,ID);

				}
				else
				{
					student = new Student(name, ID);
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

	/**
	 * The method get the array list of student
	 * 
	 * @return ArrayList of Student
	 */

	public ArrayList<Student> getStudentList()
	{
		return students;
	}
	
	/**
	 * Add student
	 * @throws IOException 
	 */
	public void addStudent(Student student) throws IOException 
	{
		students.add(student);
		File outFile = new File("text.txt");
		FileWriter fWriter = new FileWriter(outFile);
		PrintWriter pWriter = new PrintWriter(fWriter);
		for(int i = 0; i < students.size(); i++)
		{
			pWriter.println(students.get(i).toString());
		}
		
		pWriter.close();
		
	}
	

}
