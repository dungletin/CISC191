import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GUIView extends JFrame
{

	private JPanel mainPanel;
	private JTextArea infoTextArea;
	private JButton addButton;
	private StudentInformation studentInfo;
	private ArrayList<Student> students;
	private final int WINDOW_WIDTH = 400;
	private final int WINDOW_HEIGHT = 400;
	private JTextArea ta;
	private JScrollPane sp;
	private String text;
	private JLabel welcomeLabel;
	private JButton exitButton;


	public GUIView(StudentInformation studentInfo)
	{
		
		this.studentInfo = studentInfo;
		students = studentInfo.getStudentList();
		
		//create panel
		createPanel();
		add(mainPanel);
		
		
		// set the size
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// set the program to end when the window is closed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// display the window
		setVisible(true);
	}
	
	
	/**
	 * method creates panel
	 */
	
	public void createPanel()
	{
		mainPanel = new JPanel();
		welcomeLabel = new JLabel("Student Information:");
		mainPanel.add(welcomeLabel);
		ta = new JTextArea(5, 30);
		ta.setEditable(false);
		ta.setText(createText());
		sp = new JScrollPane(ta);
		mainPanel.add(sp);
		
		addButton = new JButton("Add Student");
		mainPanel.add(addButton);
		exitButton = new JButton("Exit");
		mainPanel.add(exitButton);
		
	
		
	}
	
	
	public String createText()
	{
		for(Student student: students)
		{
			if(students.indexOf(student)==0)
			{
				text = student.toString();
			} else
			{
				text = text +"\n" + student;
			}
			
		}
		return text;
	}
	
	

}
