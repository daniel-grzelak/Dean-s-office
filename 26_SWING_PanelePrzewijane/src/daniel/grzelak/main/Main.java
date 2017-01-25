package daniel.grzelak.main;

import javax.swing.JFrame;

import daniel.grzelak.classes.Entry;
import daniel.grzelak.classes.Student;
import daniel.grzelak.classes.StudentUniversity;
import daniel.grzelak.classes.University;
import daniel.grzelak.classes.User;
import daniel.grzelak.database.Database;
import daniel.grzelak.panels.PanelLogin;

public class Main {

	public static void createAndShowGui() {
		JFrame frame = new JFrame("Log in panel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PanelLogin panel = new PanelLogin();
		panel.setVisible(true);
		frame.setContentPane(panel);
		frame.setVisible(true);
		frame.setResizable(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
	}

	public static void main(String[] args) {

		Database.connect();
		Database.createTables();

		  
		 
		  
		 
	
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGui();
			}
		});

		

		


	}

}
