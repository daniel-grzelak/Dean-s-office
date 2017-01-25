package daniel.grzelak.panels;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import daniel.grzelak.classes.Student;
import daniel.grzelak.database.Database;

public class PanelStudent extends JPanel implements ActionListener{

	private JButton btnLeft;
	private JButton btnRight;
	private JButton btnInsert;
	private JButton btnUpdate;
	private JButton btnDelete;
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
	
	private static List<Student> students;
	private int idx;
	
	
	public static void setStudents(List<Student> students) {
		PanelStudent.students = students;
		
	}
	
	public void updateAll()
	{
		tfId.setText(students.get(idx).getId() + "");
		tfName.setText(students.get(idx).getName());
		tfSurname.setText(students.get(idx).getSurname());
		tfAge.setText(students.get(idx).getAge() + "");
		tfStudyYear.setText(students.get(idx).getStudyYear() + "");
		tfMail.setText(students.get(idx).getMail());
		tfPhone.setText(students.get(idx).getPhone());
		
	}

	public PanelStudent() {
		
		super(new BorderLayout());
		
		btnLeft = new JButton("<<<");
		btnLeft.addActionListener(this);
		btnRight = new JButton(">>>");
		btnRight.addActionListener(this);
		btnInsert = new JButton("Insert");
		btnInsert.addActionListener(this);
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(this);
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(this);
		lName = new JLabel("Name: ");
		lSurname = new JLabel("Surname: ");
		lAge = new JLabel("Age: ");
		lStudyYear = new JLabel("Study year: ");
		lMail = new JLabel("Mail: ");
		lPhone = new JLabel("Phone: ");
		tfId = new JTextField(10);
		tfId.setEditable(false);
		tfName = new JTextField(30);
		tfName.setEditable(false);
		tfSurname = new JTextField(30);
		tfSurname.setEditable(false);
		tfAge = new JTextField(3);
		tfAge.setEditable(false);
		tfStudyYear = new JTextField(1);
		tfStudyYear.setEditable(false);
		tfMail = new JTextField(30);
		tfMail.setEditable(false);
		tfPhone = new JTextField(12);
		tfPhone.setEditable(false);
		
		JPanel panelUp = new JPanel(new GridBagLayout());
		GridBagConstraints gbc1 = new GridBagConstraints();
		
		gbc1.gridx = 0;
		gbc1.gridy = 0;
		panelUp.add(btnLeft, gbc1);
		
		gbc1.gridx = 1;
		gbc1.gridy = 0;
		panelUp.add(tfId, gbc1);
		
		gbc1.gridx = 2;
		gbc1.gridy = 0;
		panelUp.add(btnRight, gbc1);
		
		JPanel panelSrodek = new JPanel(new GridBagLayout());
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.gridx = 0;
		gbc2.gridy = 0;
		panelSrodek.add(lName, gbc2);
		
		gbc2.gridx = 2;
		gbc2.gridy = 0;
		panelSrodek.add(tfName, gbc2);
		
		gbc2.gridx = 0;
		gbc2.gridy = 1;
		panelSrodek.add(lSurname, gbc2);
		
		gbc2.gridx = 2;
		gbc2.gridy = 1;
		panelSrodek.add(tfSurname, gbc2);
		
		gbc2.gridx = 0;
		gbc2.gridy = 2;
		panelSrodek.add(lAge, gbc2);
		
		gbc2.gridx = 2;
		gbc2.gridy = 2;
		panelSrodek.add(tfAge, gbc2);
		
		gbc2.gridx = 0;
		gbc2.gridy = 3;
		panelSrodek.add(lStudyYear, gbc2);
		
		gbc2.gridx = 2;
		gbc2.gridy = 3;
		panelSrodek.add(tfStudyYear, gbc2);
		
		gbc2.gridx = 0;
		gbc2.gridy = 4;
		panelSrodek.add(lMail, gbc2);
		
		
		gbc2.gridx = 2;
		gbc2.gridy = 4;
		panelSrodek.add(tfMail, gbc2);
		
		
		gbc2.gridx = 0;
		gbc2.gridy = 5;
		panelSrodek.add(lPhone, gbc2);
		
		
		gbc2.gridx = 2;
		gbc2.gridy = 5;
		panelSrodek.add(tfPhone, gbc2);
		
		JPanel panelDown = new JPanel(new GridBagLayout());
		GridBagConstraints gbc3 = new GridBagConstraints();
		
		gbc3.gridx = 0;
		gbc3.gridy = 0;
		panelDown.add(btnInsert, gbc3);
		
		gbc3.gridx = 1;
		gbc3.gridy = 0;
		panelDown.add(btnDelete, gbc3);
		
		gbc3.gridx = 2;
		gbc3.gridy = 0;
		panelDown.add(btnUpdate, gbc3);
		
		add(panelUp, BorderLayout.PAGE_START);
		add(panelSrodek, BorderLayout.CENTER);
		add(panelDown, BorderLayout.PAGE_END);
		
		students = Database.selectStudent();
		idx = 0;
		fillPanel();
	}
	
	private void fillPanel()
	{
		if (students.isEmpty())
		{
			tfId.setText("");
			tfName.setText("");
			tfSurname.setText("");
			tfAge.setText("");
			tfStudyYear.setText("");
			tfMail.setText("");
			tfPhone.setText("");
		}
		else
		{
			tfId.setText(String.valueOf(students.get(idx).getId()));
			tfName.setText(students.get(idx).getName());
			tfSurname.setText(students.get(idx).getSurname());
			tfAge.setText(String.valueOf(students.get(idx).getAge()));
			tfStudyYear.setText(String.valueOf(students.get(idx).getStudyYear()));
			tfMail.setText(students.get(idx).getMail());
			tfPhone.setText(students.get(idx).getPhone());
		}
		
	}
	
	private void showInsertWindow()
	{
		JFrame frame = new JFrame("INSERT STUDENT");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		PanelInsertStudent panelInsertStudent = new PanelInsertStudent();

		panelInsertStudent.setVisible(true);
		frame.setContentPane(panelInsertStudent); 
		
		
		frame.setVisible(true);
		frame.setResizable(false); 
		frame.pack();
		frame.setLocationRelativeTo(null);
		
		
	}
	
	private void showUpdateWindow() {
		JFrame frame = new JFrame("UPDATE STUDENT");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		Student s = new Student(
				Integer.parseInt(tfId.getText()), 
				tfName.getText(), 
				tfSurname.getText(), 
				Integer.parseInt(tfAge.getText()), 
				Integer.parseInt(tfStudyYear.getText()), 
				tfMail.getText(), 
				tfPhone.getText()
		);
		
		PanelUpdateStudent panelUpdateStudent = new PanelUpdateStudent(s, this);
		panelUpdateStudent.setVisible(true);
		frame.setContentPane(panelUpdateStudent); 
		
		
		frame.setVisible(true);
		frame.setResizable(false); 
		frame.pack();
		frame.setLocationRelativeTo(null);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnLeft) {
			idx--;
			if (idx < 0)
			{
				idx = students.size() - 1;
			}
			fillPanel();
			
		}else if (e.getSource() == btnRight) {
			idx++;
			if (idx >= students.size())
			{
				idx = 0;
			}
			fillPanel();
			
		}else if(e.getSource() == btnInsert) {
			showInsertWindow();

			
		}else if(e.getSource() == btnUpdate) {
			showUpdateWindow();
			
		}else if(e.getSource() == btnDelete) {
			if (!tfId.getText().isEmpty())
			{	
				Database.deleteStudent(Integer.parseInt(tfId.getText()));
				students = Database.selectStudent();
				if (idx >= students.size())
				{
					idx--;
				}
				fillPanel();
			}
		}
		
	}

}

