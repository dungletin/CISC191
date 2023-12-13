import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

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
 *         Responsibilities of class: Controller for the button in the main
 *         window
 * 
 */
public class Controller
{

	private GUIView view;

	/**
	 * Constructor
	 * 
	 * @param view
	 */
	public Controller(GUIView view)
	{
		this.view = view;
		view.registerActionListener(new ExitListener(),
				new AddStudentButtonListener(), new RemoveButtonListener(),
				new EditButtonListener());
	}

	/**
	 * Exit Button which exit the system
	 */
	public class ExitListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}

	/**
	 * AddStudent Button Listener
	 */
	public class AddStudentButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{

			new AddStudentWindow(view.getStudentInfo());
			view.dispose();
		}
	}

	/**
	 * Remove button listener which remove the student from the list
	 */
	public class RemoveButtonListener implements ActionListener
	{

		/**
		 * Method remove the student from the class
		 * Remove student in student list by getting the index of the remove
		 * button in the array of removebutton
		 * then use that index to remove the student in the student ArrayList
		 */
		@Override
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				int index = view.getIndex((JButton) e.getSource());
				// remove student in the array list
				view.getStudentInfo().removeStudent(index);

				// new Controller(new GUIView());
				// view.dispose();
				// remove component from the panel by the JButton index
				// view.removePanelOfStudent(index);
				view.refreshMainPanel(index);

			}
			catch (IOException e1)
			{
				e1.printStackTrace();
			}
		}

	}

	/**
	 * EditButtonListener which allows user to edit grade
	 */
	public class EditButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			int index = view.getIndex((JButton) e.getSource());
			new EditGradeWindow(view.getStudentInfo(), index);
			view.dispose();
		}

	}

}
