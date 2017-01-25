package daniel.grzelak.panels;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import daniel.grzelak.classes.Student;
import daniel.grzelak.database.Database;

public class PanelInsertStudent extends JPanel implements ActionListener{

	private JButton btnInsert;
	private JButton btnCancel;

	private JLabel lName;
	private JLabel lSurname;
	private JLabel lAge;
	private JLabel lStudyYear;
	private JLabel lMail;
	private JLabel lPhone;
	
	private JTextField tfName;
	private JTextField tfSurname;
	private JTextField tfAge;
	private JTextField tfStudyYear;
	private JTextField tfMail;
	private JTextField tfPhone;
	
	public PanelInsertStudent()
	{
		super(new BorderLayout());
		
		JPanel panelUp = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		lName = new JLabel("Name: ");
		tfName = new JTextField(10);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelUp.add(lName, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		panelUp.add(tfName, gbc);
		
		lSurname = new JLabel("Surname: ");
		tfSurname = new JTextField(10);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		panelUp.add(lSurname, gbc);
		gbc.gridx = 2;
		gbc.gridy = 1;
		panelUp.add(tfSurname, gbc);
		
		lAge = new JLabel("Age: ");
		tfAge = new JTextField(10);
		gbc.gridx = 0;
		gbc.gridy = 2;
		panelUp.add(lAge, gbc);
		gbc.gridx = 2;
		gbc.gridy = 2;
		panelUp.add(tfAge, gbc);
		
		lStudyYear = new JLabel("Study year:");
		tfStudyYear = new JTextField(10);
		gbc.gridx = 0;
		gbc.gridy = 3;
		panelUp.add(lStudyYear, gbc);
		gbc.gridx = 2;
		gbc.gridy = 3;
		panelUp.add(tfStudyYear, gbc);
		
		lMail = new JLabel("Mail:");
		tfMail = new JTextField(10);
		gbc.gridx = 0;
		gbc.gridy = 4;
		panelUp.add(lMail, gbc);
		gbc.gridx = 2;
		gbc.gridy = 4;
		panelUp.add(tfMail, gbc);
		
		lPhone = new JLabel("Phone");
		tfPhone = new JTextField(10);
		gbc.gridx = 0;
		gbc.gridy = 5;
		panelUp.add(lPhone, gbc);
		gbc.gridx = 2;
		gbc.gridy = 5;
		panelUp.add(tfPhone, gbc);
		
		add(panelUp, BorderLayout.CENTER);
		
		JPanel buttons = new JPanel(new GridBagLayout());
		GridBagConstraints gbc1 = new GridBagConstraints();
		
		btnInsert = new JButton("Insert");
		btnInsert.addActionListener(this);
		gbc1.gridx = 0;
		gbc1.gridy = 0;
		buttons.add(btnInsert, gbc1);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(this);
		gbc1.gridx = 3;
		gbc1.gridy = 0;
		buttons.add(btnCancel, gbc1);
		
		add(buttons, BorderLayout.PAGE_END);
	}
	
	private void insertStudent() throws Exception
	{
		if (tfName.getText().isEmpty())
		{
			throw new Exception("NAME FIELD EMPTY");
		}
		if (tfSurname.getText().isEmpty())
		{
			throw new Exception("SURNAME FIELD EMPTY");
		}
		if (tfAge.getText().isEmpty()) {
			throw new Exception("AGE FIELD EMPTY");
		}
		if (tfStudyYear.getText().isEmpty()) {
			throw new Exception("STUDY YEAR FIELD EMPTY");
		}
		if (tfMail.getText().isEmpty()) {
			throw new Exception("MAIL FIELD EMPTY");
		}
		if (tfPhone.getText().isEmpty()) {
			throw new Exception("PHONE FIELD EMPTY");
		}
		
		Student s = new Student(0, tfName.getText(), tfSurname.getText(), Integer.parseInt(tfAge.getText()), Integer.parseInt(tfStudyYear.getText()), tfMail.getText(), tfPhone.getText());
		Database.insertStudent(s);
		PanelStudent.setStudents(Database.selectStudent());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnInsert)
		{
			try {
				insertStudent();
				JFrame f = (JFrame)(getRootPane().getParent());
				f.dispose();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
		else if (e.getSource() == btnCancel)
		{
			JFrame f = (JFrame)(getRootPane().getParent());
			f.dispose();
		}
		
	}
}
