import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

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
				new AddStudentButtonListener(), new RemoveButtonListener());

	}

	/**
	 * Exit Button Listener
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


	public class RemoveButtonListener implements ActionListener
	{

		/**
		 * Method remove the student from the class
		 * Remove student in student list by getting the index of the remove button in the array of removebutton
		 * then use that index to remove the student in the student ArrayList
		 */
		@Override
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				int index = view.getIndex((JButton) e.getSource());
				//remove student in the array list
				view.getStudentInfo()
						.removeStudent(index);
				
				
//				new Controller(new GUIView());
//				view.dispose();
				//remove component from the panel by the JButton index
//				view.removePanelOfStudent(index);
				view.refreshMainPanel(index);
			
			}
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

}
