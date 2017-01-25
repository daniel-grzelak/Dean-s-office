package daniel.grzelak.panels;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import daniel.grzelak.classes.Student;
import daniel.grzelak.classes.StudentUniversity;
import daniel.grzelak.classes.University;
import daniel.grzelak.classes.Entry;
import daniel.grzelak.database.Database;
import daniel.grzelak.models.CustomComboBoxModel;

public class PanelEntry extends JPanel implements ActionListener {

	private JButton btnLeft;
	private JButton btnRight;
	private JButton btnDel;
	private JButton btnInsert;
	private JLabel lIdStudent;
	private JLabel lName;
	private JLabel lSurname;
	private JLabel lAge;
	private JLabel lStudyYear;
	private JLabel lMail;
	private JLabel lPhone;
	private JTextField tfId;
	private CustomComboBoxModel cbStudentComboBoxModel;
	private JComboBox<Integer> cIdStudent;
	private JTextField tfName;
	private JTextField tfSurname;
	private JTextField tfAge;
	private JTextField tfStudyYear;
	private JTextField tfMail;
	private JTextField tfPhone;
	private JLabel lIdUniversity;
	private JLabel lNameU;
	private JLabel lAddress;
	private JLabel lMailU;
	private JLabel lPhoneU;
	private CustomComboBoxModel cbUniversityComboBoxModel;
	private JComboBox<Integer> cIdUniversity;
	private JTextField tfNameU;
	private JTextField tfAddress;
	private JTextField tfMailU;
	private JTextField tfPhoneU;

	private JLabel lName2;
	private JLabel lSurname2;
	private JLabel lAge2;
	private JLabel lStudyYear2;
	private JLabel lMail2;
	private JLabel lPhone2;
	private JTextField tfName2;
	private JTextField tfSurname2;
	private JTextField tfAge2;
	private JTextField tfStudyYear2;
	private JTextField tfMail2;
	private JTextField tfPhone2;
	private JLabel lNameU2;
	private JLabel lAddress2;
	private JLabel lMailU2;
	private JLabel lPhoneU2;
	private JTextField tfNameU2;
	private JTextField tfAddress2;
	private JTextField tfMailU2;
	private JTextField tfPhoneU2;
	
	private static List<StudentUniversity> studentsUniversities;
	private int idx; 
	public PanelEntry() {

		super(new BorderLayout());

		btnLeft = new JButton("<<<");
		btnLeft.addActionListener(this);
		btnRight = new JButton(">>>");
		btnRight.addActionListener(this);
		btnDel = new JButton("Delete");
		btnDel.addActionListener(this);
		btnInsert = new JButton("Insert");
		btnInsert.addActionListener(this);
		lIdStudent = new JLabel("Student ID: ");
		lName = new JLabel("Name: ");
		lSurname = new JLabel("Surname: ");
		lAge = new JLabel("Age: ");
		lStudyYear = new JLabel("Study year: ");
		lMail = new JLabel("Mail: ");
		lPhone = new JLabel("Phone: ");
		lIdUniversity = new JLabel("University ID: ");
		lNameU = new JLabel("University name: ");
		lAddress = new JLabel("Address: ");
		lMailU = new JLabel("Mail: ");
		lPhoneU = new JLabel("Phone: ");
		cbStudentComboBoxModel = new CustomComboBoxModel(Database.selectStudentIds());
		cIdStudent = new JComboBox<>(cbStudentComboBoxModel);
		cIdStudent.addActionListener(this);
		cbUniversityComboBoxModel = new CustomComboBoxModel(Database.selectUniversityIds());
		cIdUniversity = new JComboBox<>(cbUniversityComboBoxModel);
		cIdUniversity.addActionListener(this);
		tfId = new JTextField(10);
		tfName = new JTextField(10);
		tfSurname = new JTextField(10);
		tfAge = new JTextField(10);
		tfStudyYear = new JTextField(10);
		tfMail = new JTextField(10);
		tfPhone = new JTextField(10);
		tfNameU = new JTextField(10);
		tfAddress = new JTextField(10);
		tfMailU = new JTextField(10);
		tfPhoneU = new JTextField(10);
		
		lName2 = new JLabel("Imie: ");
		lSurname2 = new JLabel("Nazwisko: ");
		lAge2 = new JLabel("Wiek: ");
		lStudyYear2 = new JLabel("Rok studiow: ");
		lMail2 = new JLabel("Mail: ");
		lPhone2 = new JLabel("Telefon: ");
		lNameU2 = new JLabel("Nazwa: ");
		lAddress2 = new JLabel("Adres: ");
		lMailU2 = new JLabel("Mail: ");
		lPhoneU2 = new JLabel("Telefon: ");

		tfName2 = new JTextField(10);
		tfSurname2 = new JTextField(10);
		tfAge2 = new JTextField(10);
		tfStudyYear2 = new JTextField(10);
		tfMail2 = new JTextField(10);
		tfPhone2 = new JTextField(10);
		tfNameU2 = new JTextField(10);
		tfAddress2 = new JTextField(10);
		tfMailU2 = new JTextField(10);
		tfPhoneU2 = new JTextField(10);
		
		JPanel panelButtons = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelButtons.add(btnLeft, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		panelButtons.add(tfId, gbc);
		tfId.setEditable(false);

		gbc.gridx = 2;
		gbc.gridy = 0;
		panelButtons.add(btnRight, gbc);

		JPanel panelUp = new JPanel(new GridBagLayout());
		GridBagConstraints gbc0 = new GridBagConstraints();

		gbc0.gridx = 0;
		gbc0.gridy = 0;
		panelUp.add(lName, gbc0);
		gbc0.gridx = 1;
		gbc0.gridy = 0;
		panelUp.add(tfName, gbc0);
		gbc0.gridx = 3;
		gbc0.gridy = 0;
		panelUp.add(lNameU, gbc0);
		gbc0.gridx = 4;
		gbc0.gridy = 0;
		panelUp.add(tfNameU, gbc0);

		gbc0.gridx = 0;
		gbc0.gridy = 1;
		panelUp.add(lSurname, gbc0);
		gbc0.gridx = 1;
		gbc0.gridy = 1;
		panelUp.add(tfSurname, gbc0);
		gbc0.gridx = 3;
		gbc0.gridy = 1;
		panelUp.add(lAddress, gbc0);
		gbc0.gridx = 4;
		gbc0.gridy = 1;
		panelUp.add(tfAddress, gbc0);

		gbc0.gridx = 0;
		gbc0.gridy = 2;
		panelUp.add(lAge, gbc0);
		gbc0.gridx = 1;
		gbc0.gridy = 2;
		panelUp.add(tfAge, gbc0);
		gbc0.gridx = 3;
		gbc0.gridy = 2;
		panelUp.add(lMailU, gbc0);
		gbc0.gridx = 4;
		gbc0.gridy = 2;
		panelUp.add(tfMailU, gbc0);

		gbc0.gridx = 0;
		gbc0.gridy = 3;
		panelUp.add(lStudyYear, gbc0);
		gbc0.gridx = 1;
		gbc0.gridy = 3;
		panelUp.add(tfStudyYear, gbc0);
		gbc0.gridx = 3;
		gbc0.gridy = 3;
		panelUp.add(lPhoneU, gbc0);
		gbc0.gridx = 4;
		gbc0.gridy = 3;
		panelUp.add(tfPhoneU, gbc0);

		gbc0.gridx = 0;
		gbc0.gridy = 4;
		panelUp.add(lMail, gbc0);
		gbc0.gridx = 1;
		gbc0.gridy = 4;
		panelUp.add(tfMail, gbc0);

		gbc0.gridx = 0;
		gbc0.gridy = 5;
		panelUp.add(lPhone, gbc0);
		gbc0.gridx = 1;
		gbc0.gridy = 5;
		panelUp.add(tfPhone, gbc0);

		JPanel panelButtonsUp = new JPanel(new GridBagLayout());
		GridBagConstraints gbc1 = new GridBagConstraints();

		gbc1.gridx = 2;
		gbc1.gridy = 0;
		panelButtonsUp.add(btnDel, gbc1);
		
		JPanel panelDown = new JPanel(new GridBagLayout());
		GridBagConstraints gbc2 = new GridBagConstraints();
		
		gbc2.gridx = 0;
		gbc2.gridy = 0;
		panelDown.add(lIdStudent, gbc2);
		gbc2.gridx = 1;
		gbc2.gridy = 0;
		panelDown.add(cIdStudent, gbc2);
		gbc2.gridx = 3;
		gbc2.gridy = 0;
		panelDown.add(lIdUniversity, gbc2);
		gbc2.gridx = 4;
		gbc2.gridy = 0;
		panelDown.add(cIdUniversity, gbc2);
		
		gbc2.gridx = 0;
		gbc2.gridy = 1;
		panelDown.add(lName2, gbc2);
		gbc2.gridx = 1;
		gbc2.gridy = 1;
		panelDown.add(tfName2, gbc2);
		gbc2.gridx = 3;
		gbc2.gridy = 1;
		panelDown.add(lNameU2, gbc2);
		gbc2.gridx = 4;
		gbc2.gridy = 1;
		panelDown.add(tfNameU2, gbc2);

		gbc2.gridx = 0;
		gbc2.gridy = 2;
		panelDown.add(lSurname2, gbc2);
		gbc2.gridx = 1;
		gbc2.gridy = 2;
		panelDown.add(tfSurname2, gbc2);
		gbc2.gridx = 3;
		gbc2.gridy = 2;
		panelDown.add(lAddress2, gbc2);
		gbc2.gridx = 4;
		gbc2.gridy = 2;
		panelDown.add(tfAddress2, gbc2);

		gbc2.gridx = 0;
		gbc2.gridy = 3;
		panelDown.add(lAge2, gbc2);
		gbc2.gridx = 1;
		gbc2.gridy = 3;
		panelDown.add(tfAge2, gbc2);
		gbc2.gridx = 3;
		gbc2.gridy = 3;
		panelDown.add(lMailU2, gbc2);
		gbc2.gridx = 4;
		gbc2.gridy = 3;
		panelDown.add(tfMailU2, gbc2);

		gbc2.gridx = 0;
		gbc2.gridy = 4;
		panelDown.add(lStudyYear2, gbc2);
		gbc2.gridx = 1;
		gbc2.gridy = 4;
		panelDown.add(tfStudyYear2, gbc2);
		gbc2.gridx = 3;
		gbc2.gridy = 4;
		panelDown.add(lPhoneU2, gbc2);
		gbc2.gridx = 4;
		gbc2.gridy = 4;
		panelDown.add(tfPhoneU2, gbc2);

		gbc2.gridx = 0;
		gbc2.gridy = 5;
		panelDown.add(lMail2, gbc2);
		gbc2.gridx = 1;
		gbc2.gridy = 5;
		panelDown.add(tfMail2, gbc2);

		gbc2.gridx = 0;
		gbc2.gridy = 6;
		panelDown.add(lPhone2, gbc2);
		gbc2.gridx = 1;
		gbc2.gridy = 6;
		panelDown.add(tfPhone2, gbc2);
		
		JPanel panelButtonsDown = new JPanel(new GridBagLayout());
		GridBagConstraints gbc3 = new GridBagConstraints();

		gbc3.gridx = 2;
		gbc3.gridy = 0;
		panelButtonsDown.add(btnInsert, gbc3);
		
		JPanel comboUp = new JPanel(new BorderLayout());
		comboUp.add(panelUp, BorderLayout.PAGE_START);
		comboUp.add(panelButtonsUp, BorderLayout.CENTER);
		JPanel comboDown = new JPanel(new BorderLayout());
		comboDown.add(panelDown, BorderLayout.PAGE_START);
		comboDown.add(panelButtonsDown, BorderLayout.CENTER);
		add(panelButtons, BorderLayout.PAGE_START);
		add(comboUp, BorderLayout.CENTER);
		add(comboDown, BorderLayout.PAGE_END);
		
		studentsUniversities = Database.innerJoin();
		fillPanelUniversityDown((Integer)(cIdUniversity.getSelectedItem()));
		fillPanelStudentDown((Integer)(cIdStudent.getSelectedItem()));
		fillPanel();
		idx = 0;

	}
	
	private void fillPanel() {
		if (studentsUniversities.isEmpty())
		{
			tfId.setText("");
			tfNameU.setText("");
			tfAddress.setText("");
			tfMailU.setText("");
			tfPhoneU.setText("");
			tfName.setText("");
			tfSurname.setText("");
			tfAge.setText("");
			tfStudyYear.setText("");
			tfMail.setText("");
			tfPhone.setText("");
		}
		else
		{
			tfId.setText(studentsUniversities.get(idx).getId() + "");
			tfNameU.setText(studentsUniversities.get(idx).getNameU());
			tfAddress.setText(studentsUniversities.get(idx).getAddress());
			tfMailU.setText(studentsUniversities.get(idx).getMailU());
			tfPhoneU.setText(studentsUniversities.get(idx).getPhoneU());
			tfName.setText(studentsUniversities.get(idx).getName());
			tfSurname.setText(studentsUniversities.get(idx).getSurname());
			tfAge.setText(studentsUniversities.get(idx).getAge() + "");
			tfStudyYear.setText(studentsUniversities.get(idx).getStudyYear() + "");
			tfMail.setText(studentsUniversities.get(idx).getMailS());
			tfPhone.setText(studentsUniversities.get(idx).getPhoneS());
		}
		
		
	}
	
	public void afterDelete()
	{
		studentsUniversities = Database.innerJoin();
		idx = studentsUniversities.size() - 1;
		fillPanel();
	}
	

	
	private void fillPanelStudentDown(int id) {
		List<Student> students = Database.selectStudent();
		
		id = (Integer)cIdStudent.getSelectedItem();
		
		for (Student s : students)
		{
			if (s.getId() == id)
			{
				tfName2.setText(s.getName());
				tfSurname2.setText(s.getSurname());
				tfAge2.setText((s.getAge() + ""));
				tfStudyYear2.setText(s.getStudyYear() + "");
				tfMail2.setText(s.getMail());
				tfPhone2.setText(s.getPhone());
			}
		}
	}

	private void fillPanelUniversityDown(int id) {
		List<University> universities = Database.selectUniversity();
		
		id = (Integer)cIdUniversity.getSelectedItem();
		
		for (University u : universities) {
			if (u.getId() == id) {
				tfNameU2.setText(u.getNameU());
				tfAddress2.setText(u.getAddress());
				tfMailU2.setText(u.getMailU());
				tfPhoneU2.setText(u.getPhoneU());
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLeft) {
			idx--;
			if (idx < 0)
			{
				idx = studentsUniversities.size() - 1;
			}
			fillPanel();

		} else if (e.getSource() == btnRight) {
			
			idx++;
			if (idx >= studentsUniversities.size())
			{
				idx = 0;
			}
			fillPanel();

		} else if (e.getSource() == btnInsert) {
			
			Database.insertEntry(new Entry(0, (Integer)(cIdStudent.getSelectedItem()), (Integer)(cIdUniversity.getSelectedItem())));
			studentsUniversities = Database.innerJoin();
			afterDelete();
		} else if (e.getSource() == btnDel) {
			if (!tfId.getText().isEmpty()) {
				
			
			Database.deleteEntry(Integer.parseInt(tfId.getText()));
			studentsUniversities = Database.innerJoin();
			if (idx >= studentsUniversities.size()) {
				idx--;
			}
			afterDelete(); 
			}
		} else if (e.getSource() == cIdStudent) {
			fillPanelStudentDown((Integer)(cIdStudent.getSelectedItem()));
			
		}
		else if (e.getSource() == cIdUniversity) {
			fillPanelUniversityDown((Integer)(cIdUniversity.getSelectedItem()));
		}
	}

	}


