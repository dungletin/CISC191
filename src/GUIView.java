import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Lead Author(s):
 * 
 * @author Tien Dung Le
 * @author Meidyn Nguyen
 * 
 * 
 *         References:
 *         Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented
 *         Problem Solving.
 *         Retrieved from
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 * 
 *         Version/date: 12/12/2023
 * 
 *         Responsibilities of class: The main window
 *         window
 * 
 */
public class GUIView extends JFrame
{

	private JPanel mainPanel;

	private JButton addButton;
	private ArrayList<Student> students;
	private final JLabel titleLabel = new JLabel("Class Information");
	private JButton exitButton;
	private JPanel northPanel;
	private JPanel southPanel;

	private JLabel[] infoLabels;
	private ArrayList<JButton> removeButtons;
	private ArrayList<JPanel> panelsOfStudent;
	private JButton[] editButtons;
	private StudentInformation studentInfo;

	/**
	 * Constructor
	 */
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

		// set the program to end when the window is closed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// display the window
		setVisible(true);
		pack();
	}

	/**
	 * method creates panel
	 */
	public void createPanel()
	{

		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(0, 1));
		createLabel();
		addPanel();

	}

	/**
	 * method creates the label of student information
	 * Each component will have its index by the line
	 */
	public void createLabel()
	{

		infoLabels = new JLabel[students.size()];
		removeButtons = new ArrayList<JButton>();
		panelsOfStudent = new ArrayList<JPanel>();
		editButtons = new JButton[students.size()];

		// for loop to create label base on the students array
		for (int i = 0; i < students.size(); i++)
		{
			// create labels remove buttons and panels of students
			infoLabels[i] = new JLabel();
			removeButtons.add(new JButton("Remove"));

			panelsOfStudent.add(new JPanel());
			editButtons[i] = new JButton("Edit Grade");

			// set the text for label
			infoLabels[i].setText(students.get(i).getNameAndID());
			// add label and remove button into the panel
			panelsOfStudent.get(i).add(infoLabels[i]);
			panelsOfStudent.get(i).add(editButtons[i]);
			panelsOfStudent.get(i).add(removeButtons.get(i));

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
			mainPanel.add(panelsOfStudent.get(i));
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
	 * 
	 * @return StudentInforMation
	 */
	public StudentInformation getStudentInfo()
	{
		return studentInfo;
	}

	/**
	 * Method register all of the listeners for button
	 */
	public void registerActionListener(Controller.ExitListener exitListener,
			Controller.AddStudentButtonListener addListener,
			Controller.RemoveButtonListener removeListener,
			Controller.EditButtonListener editListener)
	{
		exitButton.addActionListener(exitListener);
		addButton.addActionListener(addListener);
		for (JButton removeButton : removeButtons)
		{
			removeButton.addActionListener(removeListener);
		}
		for (JButton editButton : editButtons)
		{
			editButton.addActionListener(editListener);
		}
	}

	/**
	 * Method get index by the line in the window to access the component by its
	 * index
	 */
	public int getIndex(JButton button)
	{
		JPanel panel;
		for (int i = 0; i < panelsOfStudent.size(); i++)
		{
			panel = panelsOfStudent.get(i);
			Component[] components = panel.getComponents();

			for (Component component : components)
			{
				if (component.equals(button))
				{
					return i;
				}
			}
		}
		return -1;
	}

	/**
	 * method reset the main panel and remove the component from the panel by
	 * its index
	 * 
	 * @param index
	 */
	public void refreshMainPanel(int index)
	{
		mainPanel.remove(index);
		panelsOfStudent.remove(index);
		removeButtons.remove(index);
		mainPanel.revalidate();
		mainPanel.repaint();
	}
}
