package daniel.grzelak.panels;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import daniel.grzelak.database.Database;
import daniel.grzelak.models.CustomComboBoxModelString;

public class PanelStatistics extends JPanel{
	
	private JLabel lOldest;
	private JLabel lYoungest;
	private JLabel lAverage;
	private JLabel lYearCount;
	private JLabel lCitiesCount;
	private JTextField tfOldest;
	private JTextField tfYoungest;
	private JTextField tfAverage;
	private JComboBox<String> cYearCount;
	private CustomComboBoxModelString cbYearCount;
	private JComboBox<String> cCitiesCount;
	private CustomComboBoxModelString cbCitiesCount;
	
	public PanelStatistics() {
		super(new BorderLayout());
		
		lOldest = new JLabel("Oldest student: ");
		lYoungest = new JLabel("Youngest student: ");
		lAverage = new JLabel("Average student age: ");
		lYearCount = new JLabel("Amount of students on given year: ");
		lCitiesCount = new JLabel("Amount of students in given city: ");
		tfOldest = new JTextField(30);
		tfYoungest = new JTextField(30);
		tfAverage = new JTextField(30);
		
		cbCitiesCount = new CustomComboBoxModelString(Database.studentsInCities());
		cCitiesCount = new JComboBox<>(cbCitiesCount);
		cbYearCount = new CustomComboBoxModelString(Database.studentsOnYear());
		cYearCount = new JComboBox<>(cbYearCount);

		JPanel up = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		up.add(lOldest, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		up.add(tfOldest, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		up.add(lYoungest, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
		up.add(tfYoungest, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		up.add(lAverage, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 2;
		up.add(tfAverage, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		up.add(lYearCount, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 3;
		up.add(cYearCount, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		up.add(lCitiesCount, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 4;
		up.add(cCitiesCount, gbc);
		
		fillPanel();
		add(up, BorderLayout.CENTER);
	}

	public void fillPanel() {
	
		tfOldest.setText(Database.oldestStudent().toString());
		tfYoungest.setText(Database.youngestStudent().toString());
		tfAverage.setText(Database.averageAge() + "");
	}
	
	

}
