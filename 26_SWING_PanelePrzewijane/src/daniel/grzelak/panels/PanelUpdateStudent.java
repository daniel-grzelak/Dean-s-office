package daniel.grzelak.panels;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import daniel.grzelak.classes.Student;
import daniel.grzelak.database.Database;

public class PanelUpdateStudent extends JPanel implements ActionListener{

	private JButton btnUpdate;
	private JButton btnCancel;
	private JLabel lId;
	private JLabel lName;
	private JLabel lSurname;
	private JLabel lAge;
	private JLabel lStudyYear;
	private JLabel lMail;
	private JLabel lPhone;
	private JTextField tfId;
	private JTextField tfName;
	private JTextField tfSurname;
	private JTextField tfAge;
	private JTextField tfStudyYear;
	private JTextField tfMail;
	private JTextField tfPhone;
	private PanelStudent panel;
	
	public PanelUpdateStudent(Student s, PanelStudent panel)
	{
		super(new BorderLayout());
		
		this.panel = panel;
		
		JPanel panelUp = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		lId = new JLabel("Id");
		tfId = new JTextField(10);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelUp.add(lId, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		panelUp.add(tfId, gbc);
		
		lName = new JLabel("Name: ");
		tfName = new JTextField(10);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panelUp.add(lName, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
		panelUp.add(tfName, gbc);
		
		lSurname = new JLabel("Surname: ");
		tfSurname = new JTextField(10);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		panelUp.add(lSurname, gbc);
		gbc.gridx = 2;
		gbc.gridy = 2;
		panelUp.add(tfSurname, gbc);
		
		lAge = new JLabel("Age: ");
		tfAge = new JTextField(10);
		gbc.gridx = 0;
		gbc.gridy = 3;
		panelUp.add(lAge, gbc);
		gbc.gridx = 2;
		gbc.gridy = 3;
		panelUp.add(tfAge, gbc);
		
		lStudyYear = new JLabel("Study year: ");
		tfStudyYear = new JTextField(10);
		gbc.gridx = 0;
		gbc.gridy = 4;
		panelUp.add(lStudyYear, gbc);
		gbc.gridx = 2;
		gbc.gridy = 4;
		panelUp.add(tfStudyYear, gbc);
		
		lMail = new JLabel("Mail: ");
		tfMail = new JTextField(10);
		gbc.gridx = 0;
		gbc.gridy = 5;
		panelUp.add(lMail, gbc);
		gbc.gridx = 2;
		gbc.gridy = 5;
		panelUp.add(tfMail, gbc);
		
		lPhone = new JLabel("Phone: ");
		tfPhone = new JTextField(10);
		gbc.gridx = 0;
		gbc.gridy = 6;
		panelUp.add(lPhone, gbc);
		gbc.gridx = 2;
		gbc.gridy = 6;
		panelUp.add(tfPhone, gbc);
		
		add(panelUp, BorderLayout.CENTER);
		
		JPanel buttons = new JPanel(new GridBagLayout());
		GridBagConstraints gbc1 = new GridBagConstraints();
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(this);
		gbc1.gridx = 0;
		gbc1.gridy = 0;
		buttons.add(btnUpdate, gbc1);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(this);
		gbc1.gridx = 3;
		gbc1.gridy = 0;
		buttons.add(btnCancel, gbc1);
		
		add(buttons, BorderLayout.PAGE_END);
		
		tfId.setEditable(false);
		
		tfId.setText(s.getId() + "");
		tfName.setText(s.getName());
		tfSurname.setText(s.getSurname());
		tfAge.setText(String.valueOf(s.getAge()));
		tfStudyYear.setText(String.valueOf(s.getStudyYear()));
		tfMail.setText(s.getMail());
		tfPhone.setText(s.getPhone());
	}

	
	public void updateStudent() {
		Student s = new Student(Integer.parseInt(tfId.getText()), tfName.getText(), tfSurname.getText(), Integer.parseInt(tfAge.getText()), Integer.parseInt(tfStudyYear.getText()), tfMail.getText(), tfPhone.getText());
		Database.updateStudent(s);
		PanelStudent.setStudents(Database.selectStudent());
		panel.updateAll();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnUpdate) {
			updateStudent();
		}
		JFrame f = (JFrame)(getRootPane().getParent());
		f.dispose();
		
		
	}
}
