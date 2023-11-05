import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
	// private GUIView view;
	private StudentInformation studentInfo;
	private JComboBox<String> comboBox;
	private JPanel northPanel;
	private JLabel titleLabel;

	public AddStudentWindow(StudentInformation studentInfo)
	{
		this.studentInfo = studentInfo;
		createPanel();
		setLayout(new BorderLayout());
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		add(northPanel, BorderLayout.NORTH);
		// set the size
		setSize(300, 300);

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
		String[] comboOptions = { "Regular", "Exchange", "Honored",
				"Tutoring" };
		comboBox = new JComboBox<String>(comboOptions);

		// name panel
		JPanel namePanel = new JPanel();
		namePanel.add(nameLabel);
		namePanel.add(nameTextField);

		// ID panel
		JPanel IDPanel = new JPanel();
		IDPanel.add(IDLabel);
		IDPanel.add(IDTextField);

		// combo box Panel
		JPanel comboBoxPanel = new JPanel();
		comboBoxPanel.add(comboBox);

		// Add components into center panel
		centerPanel.setLayout(new GridLayout(3, 1));
		centerPanel.add(namePanel);
		centerPanel.add(IDPanel);
		centerPanel.add(comboBoxPanel);

		// create south panel
		southPanel = new JPanel();
		exitButton = new JButton("Exit");
		addButton = new JButton("Add");
		addButton.addActionListener(this);
		southPanel.add(exitButton);
		southPanel.add(addButton);

		// create north panel
		northPanel = new JPanel();
		titleLabel = new JLabel("Please enter student infomation:");
		northPanel.add(titleLabel);

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == addButton)
		{

			String name = nameTextField.getText();
			int ID = Integer.parseInt(IDTextField.getText());
			String type = (String) comboBox.getSelectedItem();
			Student student;
			if (type.equals("Exchange"))
			{
				student = new ExchangeStudent(name, ID);
			}
			else if (type.equals("Honored"))
			{
				student = new HonoredStudent(name,ID);
			}
			else if (type.equals("Tutoring"))
			{
				student = new TutoringStudent(name,ID);
			}
			else
			{
				student = new Student(name, ID);
			}

			try
			{
				studentInfo.addStudent(student);

				new GUIView();
				dispose();
			}
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}

}
