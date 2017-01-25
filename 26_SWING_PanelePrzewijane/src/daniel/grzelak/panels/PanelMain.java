package daniel.grzelak.panels;

import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class PanelMain extends JPanel implements ActionListener {

	private PanelStudent panelStudent;
	private PanelUniversity panelUniversity;
	private PanelEntry panelEntry;
	private PanelStatistics panelStatistics;
	private PanelTable panelTable;

	public PanelMain() {
		super(new CardLayout());

		panelStudent = new PanelStudent();
		panelUniversity = new PanelUniversity();
		panelEntry = new PanelEntry();
		panelStatistics = new PanelStatistics();
		panelTable = new PanelTable();
		

		add(panelStudent, "STUDENT");
		add(panelUniversity, "UNIVERSITY");
		add(panelEntry, "ENTRY");
		add(panelStatistics, "STATISTICS");
		add(panelTable, "TABLE");
		
		
	}

	public JMenuBar createMenu() {
		JMenuBar menuBar = new JMenuBar();

		JMenu panelsMenu = new JMenu("PANELS");

		JMenuItem menuItemStudent = new JMenuItem("STUDENT PANEL");
		menuItemStudent.addActionListener(this);
		menuItemStudent.setActionCommand("STUDENT PANEL");

		JMenuItem menuItemUniversity = new JMenuItem("UNIVERSITY PANEL");
		menuItemUniversity.addActionListener(this);
		menuItemUniversity.setActionCommand("UNIVERSITY PANEL");

		JMenuItem menuItemEntry = new JMenuItem("ENTRY PANEL");
		menuItemEntry.addActionListener(this);
		menuItemEntry.setActionCommand("ENTRY PANEL");
		
		JMenuItem menuItemStatistics = new JMenuItem("STATISTICS PANEL");
		menuItemStatistics.addActionListener(this);
		menuItemStatistics.setActionCommand("STATISTICS PANEL");
		
		JMenuItem menuItemTable = new JMenuItem("TABLE PANEL");
		menuItemTable.addActionListener(this);
		menuItemTable.setActionCommand("TABLE PANEL");
		
		panelsMenu.add(menuItemStudent);
		panelsMenu.add(menuItemUniversity);
		panelsMenu.add(menuItemEntry);
		panelsMenu.add(menuItemStatistics);
		panelsMenu.add(menuItemTable);

		menuBar.add(panelsMenu);

		return menuBar;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("STUDENT PANEL")) {
			CardLayout layout = (CardLayout)getLayout();
			layout.show(this, "STUDENT");

		} else if (e.getActionCommand().equals("UNIVERSITY PANEL")) {
			CardLayout layout = (CardLayout)getLayout();
			layout.show(this, "UNIVERSITY");

		} else if (e.getActionCommand().equals("ENTRY PANEL")) {
			CardLayout layout = (CardLayout)getLayout();
			layout.show(this, "ENTRY");
		}else if (e.getActionCommand().equals("STATISTICS PANEL")) {
			CardLayout layout = (CardLayout)getLayout();
			layout.show(this, "STATISTICS");
		}
		else if (e.getActionCommand().equals("TABLE PANEL")) {
			JFrame frame = new JFrame("TABLE");
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
			PanelTable panel = new PanelTable();
			panel.setVisible(true);
			frame.setContentPane(panel);
			frame.setVisible(true);
			frame.setResizable(true); 
			frame.pack(); 
			frame.setLocation(100, 100);
			frame.setSize((int)(0.75 * Toolkit.getDefaultToolkit().getScreenSize().getWidth()), 700);
			
			
		}
	}

}
