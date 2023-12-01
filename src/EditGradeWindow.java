import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditGradeWindow extends JFrame implements ActionListener
{
	private JPanel tittlePanel;
	private JLabel titleLabel;
	private JLabel gradeLabel;
	private JPanel panel;
	private JTextField gradeTextField;
	private JButton saveButton;
	private JPanel buttonPanel;
	private JButton exitButton;
	private StudentInformation studentInfo;
	private int index;

	public EditGradeWindow(StudentInformation studentInfo, int index)
	{
		this.studentInfo = studentInfo;
		this.index = index;
		tittlePanel = new JPanel();
		titleLabel = new JLabel("Edit Student Grade");
		tittlePanel.add(titleLabel);
		buttonPanel = new JPanel();
		saveButton = new JButton("Save");
		saveButton.addActionListener(this);
		exitButton = new JButton("Exit");
		exitButton.addActionListener(this);
		buttonPanel.add(saveButton);
		buttonPanel.add(exitButton);
		setLayout(new BorderLayout());

		add(tittlePanel, BorderLayout.NORTH);
		createPanel();
		add(panel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);

		// set the program to end when the window is closed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// display the window
		setVisible(true);
		// set size
		pack();

	}

	/**
	 * Method create panel
	 */
	public void createPanel()
	{

		gradeLabel = new JLabel("Please enter grade");
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(150, 50));

		gradeTextField = new JTextField();
		gradeTextField.setPreferredSize(new Dimension(80, 20));
		panel.add(gradeLabel);
		panel.add(gradeTextField);
		panel.setLayout(new FlowLayout());

	}

	public boolean isValidGrade(String text)
	{
		char[] chars = text.toCharArray();
		for (char character : chars)
		{
			if (Character.isDigit(character))
			{
				int grade = Integer.valueOf(text);
				if (grade > 100 || grade < 0)
				{
					return false;
				}
				else
				{
					return true;
				}

			}
		}
		return false;

	}

	/*
	 * Controller for button
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == exitButton)
		{
			System.exit(0);
		}

		if (e.getSource() == saveButton)
		{
			
			String grade = gradeTextField.getText();
			
			if (!isValidGrade(grade))
			{
				titleLabel.setText("Something Wrong");
			} else
			{
				studentInfo.setGrade(Integer.valueOf(grade),index);
				
				new Controller(new GUIView());
				dispose();
			}
		}
	}

}
