import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
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
		try
		{
			readFile();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Method read the file and add information that has been read in to the
	 * student array list
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 * 
	 */
	public void readFile() throws FileNotFoundException, IOException
	{
		BufferedReader reader = null;
		try
		{
			reader = new BufferedReader(new FileReader("text.txt"));
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
				int grade = Integer.valueOf(info[3]);

				// check the third word in the line to see the type and create
				// it by that type
				if (type.equals("Exchange"))
				{
					student = new ExchangeStudent(name, ID);
					student.setGrade(grade);
				}
				else if (type.equals("Honored"))
				{
					student = new HonoredStudent(name, ID);
					student.setGrade(grade);

				}
				else if (type.equals("Tutoring"))
				{
					student = new TutoringStudent(name, ID);
					student.setGrade(grade);

				}
				else
				{
					student = new Student(name, ID);
					student.setGrade(grade);
				}

				students.add(student);
			}
		}
		catch (FileNotFoundException e)
		{
			throw e;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			reader.close();

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
	 * 
	 * @throws IOException
	 */
	public void addStudent(Student student) throws IOException
	{

		students.add(student);

		File outFile = new File("text.txt");
		FileWriter fWriter = new FileWriter(outFile);
		PrintWriter pWriter = new PrintWriter(fWriter);
		for (int i = 0; i < students.size(); i++)
		{
			pWriter.println(students.get(i).toString());
		}

		pWriter.close();

	}

	/**
	 * Method write the student info into the list
	 * 
	 * @throws IOException
	 */
	public void writeFile() throws IOException
	{
		File outFile = new File("text.txt");
		FileWriter fWriter = new FileWriter(outFile);
		PrintWriter pWriter = new PrintWriter(fWriter);
		for (int i = 0; i < students.size(); i++)
		{
			pWriter.println(students.get(i).toString());

		}
		pWriter.close();
	}

	/**
	 * Method remove the student then rewrite the student info into the file
	 * 
	 * @param index
	 * @throws IOException
	 */
	public void removeStudent(int index) throws IOException
	{

		students.remove(index);

		File outFile = new File("text.txt");
		FileWriter fWriter = new FileWriter(outFile);
		PrintWriter pWriter = new PrintWriter(fWriter);
		for (int i = 0; i < students.size(); i++)
		{
			pWriter.println(students.get(i).toString());
		}

		pWriter.close();

	}

	/**
	 * method checks if the id exists in the class
	 * 
	 * @param ID
	 * @return true if it exists otherwise return false
	 */
	public boolean containID(int ID)
	{
		for (Student student : students)
		{
			if (ID == student.getID())
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * method set grade for student
	 */
	public void setGrade(int grade, int index)
	{
		
		int newGrade = students.get(index).calculateGrade(grade);
		students.get(index).setGrade(newGrade);
		try
		{
			writeFile();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
