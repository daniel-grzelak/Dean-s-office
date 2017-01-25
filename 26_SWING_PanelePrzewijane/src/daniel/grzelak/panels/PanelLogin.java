package daniel.grzelak.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import daniel.grzelak.database.Database;

public class PanelLogin extends JPanel implements ActionListener {

	private JLabel lLogin;
	private JLabel lPassword;
	private JTextField tfLogin;
	private JTextField tfPassword;
	private JButton bLogin;
	private JButton bCancel;

	public PanelLogin() {
		super(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		lLogin = new JLabel("Login: ");
		lPassword = new JLabel("Password: ");
		tfLogin = new JTextField(10);
		tfPassword = new JPasswordField(10);
		bLogin = new JButton("Log in");
		bCancel = new JButton("Cancel");

		gbc.gridx = 0;
		gbc.gridy = 0;
		add(lLogin, gbc);

		gbc.gridx = 2;
		gbc.gridy = 0;
		add(tfLogin, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		add(lPassword, gbc);

		gbc.gridx = 2;
		gbc.gridy = 1;
		add(tfPassword, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		add(bLogin, gbc);
		bLogin.addActionListener(this);

		gbc.gridx = 2;
		gbc.gridy = 2;
		add(bCancel, gbc);
		bCancel.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bLogin) {
			String login = tfLogin.getText();
			String password = tfPassword.getText();
			if (Database.userMatcher(login, password) == true) {
				JFrame frame = (JFrame) getRootPane().getParent();
				frame.dispose();

				javax.swing.SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						JFrame frame = new JFrame("Dean's office");
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						PanelMain panel = new PanelMain();
						panel.setVisible(true);
						frame.setJMenuBar(panel.createMenu());
						frame.setContentPane(panel);
						frame.setVisible(true);
						frame.setResizable(true);
						frame.pack();
						frame.setLocationRelativeTo(null);
					}
				});

			} else {
				JOptionPane.showMessageDialog(new JFrame(), "There is no such user.", "The information you provided cannot be used to log in.",
						JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getSource() == bCancel) {
			JFrame frame = (JFrame) getRootPane().getParent();
			frame.dispose();
		}

	}

}
