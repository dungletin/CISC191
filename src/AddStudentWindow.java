import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddStudentWindow extends JFrame implements ActionListener
{
	private JPanel centerPanel;
	private JLabel nameLabel;
	private JTextField nameTextField;
	private JLabel IDLabel;
	private JTextField IDTextField;
	private JButton addButton;
	private JButton exitButton;
	private JPanel southPanel;
//	private GUIView view;
	private StudentInformation studentInfo;

	public AddStudentWindow(StudentInformation studentInfo)
	{
		this.studentInfo = studentInfo;
		createPanel();
		setLayout(new BorderLayout());
		add(centerPanel,BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		
		// set the size
		setSize(200, 200);

		// set the program to end when the window is closed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// display the window
		setVisible(true);
	}

	/**
	 * Create Panel
	 */
	public void createPanel()
	{
		centerPanel = new JPanel();
		nameLabel = new JLabel("Name:");
		nameTextField = new JTextField(10);
		IDLabel = new JLabel("ID:");
		IDTextField = new JTextField(10);
		
		//name panel
		JPanel namePanel = new JPanel();
		namePanel.add(nameLabel);
		namePanel.add(nameTextField);
		
		//ID panel
		JPanel IDPanel = new JPanel();
		IDPanel.add(IDLabel);
		IDPanel.add(IDTextField);
		
		centerPanel.setLayout(new GridLayout(2,1));
		centerPanel.add(namePanel);
		centerPanel.add(IDPanel);
	

		
		
		southPanel = new JPanel();
		exitButton = new JButton("Exit");
		addButton = new JButton("Add");
		addButton.addActionListener(this);
		southPanel.add(exitButton);
		southPanel.add(addButton);
		

	}
	
	
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == addButton)
		{
			Student student = new Student(nameTextField.getText(),Integer.parseInt(IDTextField.getText()));
			try
			{
				studentInfo.addStudent(student);
			}
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	
	

}
