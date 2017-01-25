package daniel.grzelak.panels;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import daniel.grzelak.classes.StudentUniversity;
import daniel.grzelak.database.Database;
import daniel.grzelak.models.CustomComboBoxModel;
import daniel.grzelak.models.CustomListModel;
import daniel.grzelak.models.CustomTableModel;

public class PanelTable extends JPanel implements ActionListener{
	private CustomTableModel ctm;
	private JTable table;
	private JCheckBox cbName;
	private JCheckBox cbSurname;
	private JCheckBox cbAge;
	private JCheckBox cbStudyYear;
	private JLabel lFromAge;
	private JLabel lToAge;
	private JLabel lFromYear;
	private JLabel lToYear;
	private JList<String> liName;
	private JList<String> liSurname;
	private CustomListModel clmName;
	private CustomListModel clmSurname;
	private JComboBox<Integer> cFromAge;
	private JComboBox<Integer> cToAge;
	private JComboBox<Integer> cFromYear;
	private JComboBox<Integer> cToYear;
	private CustomComboBoxModel ccbmFromAge;
	private CustomComboBoxModel ccbmToAge;
	private CustomComboBoxModel ccbmFromYear;
	private CustomComboBoxModel ccbmToYear;
	private JButton bFilter;
	private JButton bReset;
	
	
	
	public PanelTable() {
		super(new BorderLayout());
		List<StudentUniversity> studentsUniversities = Database.innerJoin();
		List<String> headers = new ArrayList<>(Arrays.asList(
				new String[]{"ID", "NAME", "SURNAME", "AGE", "STUDY YEAR", "STUDENT MAIL", "STUDENT PHONE",
						"UNIVERSITY NAME", "ADDRESS", "UNIVERSITY MAIL", "UNIVERSITY PHONE"}));
		ctm = new CustomTableModel(studentsUniversities, headers);
		table = new JTable(ctm);
		add(new JScrollPane(table), BorderLayout.PAGE_START);
		
		JPanel filters = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		cbName = new JCheckBox("Imie: ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		filters.add(cbName, gbc);
		
		clmName = new CustomListModel(Database.namesList());
		liName = new JList<String>(clmName);
		gbc.gridx = 1;
		gbc.gridy = 0;
		filters.add(new JScrollPane(liName), gbc);
		
		cbSurname = new JCheckBox("Nazwisko: ");
		gbc.gridx = 3;
		gbc.gridy = 0;
		filters.add(cbSurname, gbc);
		
		clmSurname = new CustomListModel(Database.surnamesList());
		liSurname = new JList<String>(clmSurname);
		gbc.gridx = 4;
		gbc.gridy = 0;
		filters.add(new JScrollPane(liSurname), gbc);
		
		cbAge = new JCheckBox("Wiek: ");
		gbc.gridx = 0;
		gbc.gridy = 1;
		filters.add(cbAge, gbc);
		
		lFromAge = new JLabel("od");
		gbc.gridx = 1;
		gbc.gridy = 1;
		filters.add(lFromAge, gbc);
		
		ccbmFromAge = new CustomComboBoxModel(Database.ageList());
		cFromAge = new JComboBox<>(ccbmFromAge);
		cFromAge.addActionListener(this);
		gbc.gridx = 2;
		gbc.gridy = 1;
		filters.add(cFromAge, gbc);
		
		lToAge = new JLabel("do");
		gbc.gridx = 3;
		gbc.gridy = 1;
		filters.add(lToAge, gbc);
		
		
		ccbmToAge = new CustomComboBoxModel(Database.ageList());
		cToAge = new JComboBox<>(ccbmToAge);
		cToAge.addActionListener(this);
		gbc.gridx = 4;
		gbc.gridy = 1;
		filters.add(cToAge, gbc);
		
		cbStudyYear = new JCheckBox("Rok studiow: ");
		gbc.gridx = 0;
		gbc.gridy = 2;
		filters.add(cbStudyYear, gbc);
		
		lFromYear = new JLabel("od");
		gbc.gridx = 1;
		gbc.gridy = 2;
		filters.add(lFromYear, gbc);
		
		ccbmFromYear = new CustomComboBoxModel(Database.yearsList());
		cFromYear = new JComboBox<>(ccbmFromYear);
		cFromYear.addActionListener(this);
		gbc.gridx = 2;
		gbc.gridy = 2;
		filters.add(cFromYear, gbc);
		
		lToYear = new JLabel("do");
		gbc.gridx = 3;
		gbc.gridy = 2;
		filters.add(lToYear, gbc);
		
		ccbmToYear = new CustomComboBoxModel(Database.yearsList());
		cToYear = new JComboBox<>(ccbmToYear);
		cToYear.addActionListener(this);
		gbc.gridx = 4;
		gbc.gridy = 2;
		filters.add(cToYear, gbc);
		
		bFilter = new JButton("Filter");
		bFilter.addActionListener(this);
		gbc.gridx = 0;
		gbc.gridy = 4;
		filters.add(bFilter, gbc);
		
		bReset = new JButton("Reset");
		bReset.addActionListener(this);
		gbc.gridx = 1;
		gbc.gridy = 4;
		filters.add(bReset, gbc);
		add(filters, BorderLayout.CENTER);
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bFilter) {
			ctm.update(Database.downloadData(
					cbName.isSelected(), 
					liName.getSelectedValuesList(), 
					cbSurname.isSelected(), 
					liSurname.getSelectedValuesList(), 
					cbAge.isSelected(), 
					(Integer)ccbmFromAge.getSelectedItem(), 
					(Integer)ccbmToAge.getSelectedItem(), 
					cbStudyYear.isSelected(), 
					(Integer)ccbmFromYear.getSelectedItem(), 
					(Integer)ccbmToYear.getSelectedItem()));
			table.updateUI();
		}else if (e.getSource() == bReset) {
			ctm.update(Database.innerJoin());
			table.updateUI();
			
		}else if (e.getSource() == cFromAge) {
			int age = (Integer)cFromAge.getSelectedItem();
			List<Integer> lista = Database.ageList();
			Collections.sort(lista);
			int pos = Collections.binarySearch(lista, age);
			ccbmToAge.updateIds(lista.subList(pos, lista.size()-1));
			cToAge.updateUI();
			
		}else if (e.getSource() == cToAge) {
			int age = (Integer)cToAge.getSelectedItem();
			List<Integer> lista = Database.ageList();
			Collections.sort(lista);
			int pos = Collections.binarySearch(lista, age);
			ccbmFromAge.updateIds(lista.subList(pos, lista.size()-1));
			cFromAge.updateUI();
			
		}else if (e.getSource() == cFromYear) {
			int year = (Integer)cFromYear.getSelectedItem();
			List<Integer> lista = Database.yearsList();
			Collections.sort(lista);
			int pos = Collections.binarySearch(lista, year);
			ccbmToYear.updateIds(lista.subList(pos, lista.size()-1));
			cToYear.updateUI();
		}else if (e.getSource() == cToYear) {
			int year = (Integer)cToYear.getSelectedItem();
			List<Integer> lista = Database.yearsList();
			Collections.sort(lista);
			int pos = Collections.binarySearch(lista, year);
			ccbmFromYear.updateIds(lista.subList(pos, lista.size()-1));
			cFromYear.updateUI();
		}
		
	}

}
