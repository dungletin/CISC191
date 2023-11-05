import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

public class Controller
{

	private GUIView view;
	private Student student;

	/**
	 * Constructor
	 * 
	 * @param view
	 */
	public Controller(GUIView view)
	{
		this.view = view;
		view.registerActionListener(new ExitListener(), new AddStudentButtonListener(), new RemoveButtonListener());
		
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
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				view.getStudentInfo().removeStudent(view.getIndex((JButton) e.getSource()));
				new Controller(new GUIView());
				view.dispose();
			}
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	
	
}
