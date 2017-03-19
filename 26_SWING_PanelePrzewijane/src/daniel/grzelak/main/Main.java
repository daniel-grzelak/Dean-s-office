package daniel.grzelak.main;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;

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
		Database.insertUser(new User(0, "admin", "admin1234", "admin"));
		Database.insertUser(new User(0, "user", "user1234", "user"));

		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
			 try {
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UnsupportedLookAndFeelException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGui();
			}
		});


		


	}

}
