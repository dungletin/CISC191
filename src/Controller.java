import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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
		view.registerActionListener(new ExitListener(), new AddStudentButtonListener());
		
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
	 * Add Student Button Listener
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
	
}
