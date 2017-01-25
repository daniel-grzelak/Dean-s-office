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

import daniel.grzelak.classes.University;
import daniel.grzelak.database.Database;

public class PanelInsertUniversity extends JPanel implements ActionListener{
	
	private JButton btnInsert;
	private JButton btnCancel;

	private JLabel lName;
	private JLabel lAddress;
	private JLabel lMail;
	private JLabel lPhone;
	
	private JTextField tfName;
	private JTextField tfAddress;
	private JTextField tfMail;
	private JTextField tfPhone;
	private PanelUniversity panel;
	public PanelInsertUniversity(University u, PanelUniversity panel) {
		super(new BorderLayout());
		
		this.panel = panel;
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
		
		lAddress = new JLabel("Address: ");
		tfAddress = new JTextField(10);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		panelUp.add(lAddress, gbc);
		gbc.gridx = 2;
		gbc.gridy = 1;
		panelUp.add(tfAddress, gbc);
		
		lMail = new JLabel("Mail: ");
		tfMail = new JTextField(10);
		gbc.gridx = 0;
		gbc.gridy = 2;
		panelUp.add(lMail, gbc);
		gbc.gridx = 2;
		gbc.gridy = 2;
		panelUp.add(tfMail, gbc);
		
		lPhone = new JLabel("Phone: ");
		tfPhone = new JTextField(10);
		gbc.gridx = 0;
		gbc.gridy = 3;
		panelUp.add(lPhone, gbc);
		gbc.gridx = 2;
		gbc.gridy = 3;
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

	
	private void insertUniversity() throws Exception {
		if (tfName.getText().isEmpty()) {
			throw new Exception("NAME FIELD EMPTY");
		}
		if (tfAddress.getText().isEmpty()) {
			throw new Exception("ADDRESS FIELD EMPTY");
		}
		if (tfMail.getText().isEmpty()) {
			throw new Exception("MAIL FIELD EMPTY");
		}
		if (tfPhone.getText().isEmpty()) {
			throw new Exception("PHONE FIELD EMPTY");
		}
		
		University u = new University(0, tfName.getText(), tfAddress.getText(), tfMail.getText(), tfPhone.getText());
		Database.insertUniversity(u);
		panel.afterInsert();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnInsert)
		{
			try {
				insertUniversity();
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
