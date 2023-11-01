import java.awt.BorderLayout;
import java.awt.GridLayout;
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

	private JButton addButton;
	private ArrayList<Student> students;
	private final int WINDOW_WIDTH = 400;
	private final int WINDOW_HEIGHT = 400;
	private String text;
	private final JLabel titleLabel = new JLabel("Class Information");
	private JButton exitButton;
	private JPanel northPanel;
	private JPanel southPanel;

	private int numberOfStudents;
	private JLabel[] infoLabels;
	private JButton[] removeButtons;
	private JPanel[] panelsOfStudent;
	private JButton[] editButtons;
	private StudentInformation studentInfo;

	public GUIView()
	{
		studentInfo = new StudentInformation();
		students = studentInfo.getStudentList();

		// set layout
		setLayout(new BorderLayout());
		// create panel
		createPanel();
		createNorthAndSouthPanel();

		add(mainPanel, BorderLayout.CENTER);
		add(northPanel, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
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
		mainPanel.setLayout(new GridLayout(students.size(), 1));
		createLabel();
		addPanel();

	}

	/**
	 * method creates the label of student information
	 */
	public void createLabel()
	{
		infoLabels = new JLabel[students.size()];
		removeButtons = new JButton[students.size()];
		panelsOfStudent = new JPanel[students.size()];
		editButtons = new JButton[students.size()];
		
		// for loop to create label base on the students array
		for (int i = 0; i < students.size(); i++)
		{
			// create labels remove buttons and panels of students
			infoLabels[i] = new JLabel();
			removeButtons[i] = new JButton("Remove");
			panelsOfStudent[i] = new JPanel();
			editButtons[i] = new JButton("Edit");

			// set the text for label
			infoLabels[i].setText(students.get(i).getNameAndID());
			// add label and remove button into the panel
			panelsOfStudent[i].add(infoLabels[i]);
			panelsOfStudent[i].add(editButtons[i]);
			panelsOfStudent[i].add(removeButtons[i]);
		
		}

	}

	/**
	 * method adds labels in to the main panel
	 */
	public void addPanel()
	{
		for (int i = 0; i < students.size(); i++)
		{
			// mainPanel.add(infoLabels[i]);
			// mainPanel.add(removeButtons[i]);
			mainPanel.add(panelsOfStudent[i]);
		}
	}

	/**
	 * method create north and south panel
	 */
	public void createNorthAndSouthPanel()
	{

		// North Panel contains a Student Information label
		northPanel = new JPanel();
		northPanel.add(titleLabel);

		// South Panel contain
		southPanel = new JPanel();
		exitButton = new JButton("Exit");
		addButton = new JButton("Add Student");
		southPanel.add(exitButton);
		southPanel.add(addButton);
	}
	
	/**
	 * get student info
	 */
	public StudentInformation getStudentInfo()
	{
		return studentInfo;
	}

	/**
	 * Method exit ActionListener
	 */

	public void registerActionListener(Controller.ExitListener exitListener, Controller.AddStudentButtonListener addListener)
	{
		exitButton.addActionListener(exitListener);
		addButton.addActionListener(addListener);
	}

}
