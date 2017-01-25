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

import daniel.grzelak.classes.University;
import daniel.grzelak.database.Database;

public class PanelUpdateUniversity extends JPanel implements ActionListener{
	
	private JButton btnUpdate;
	private JButton btnCancel;
	private JLabel lId;
	private JLabel lName;
	private JLabel lAddress;
	private JLabel lMail;
	private JLabel lPhone;
	private JTextField tfId;
	private JTextField tfName;
	private JTextField tfAddress;
	private JTextField tfMail;
	private JTextField tfPhone;
	private PanelUniversity panel;


		
		public PanelUpdateUniversity(University u, PanelUniversity panel) {
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
			
			lAddress = new JLabel("Address: ");
			tfAddress = new JTextField(10);
			
			gbc.gridx = 0;
			gbc.gridy = 2;
			panelUp.add(lAddress, gbc);
			gbc.gridx = 2;
			gbc.gridy = 2;
			panelUp.add(tfAddress, gbc);
			
			lMail = new JLabel("Mail: ");
			tfMail = new JTextField(10);
			gbc.gridx = 0;
			gbc.gridy = 3;
			panelUp.add(lMail, gbc);
			gbc.gridx = 2;
			gbc.gridy = 3;
			panelUp.add(tfMail, gbc);
			
			lPhone = new JLabel("Phone: ");
			tfPhone = new JTextField(10);
			gbc.gridx = 0;
			gbc.gridy = 4;
			panelUp.add(lPhone, gbc);
			gbc.gridx = 2;
			gbc.gridy = 4;
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
			
			tfId.setText(u.getId() + "");
			tfName.setText(u.getNameU());
			tfAddress.setText(u.getAddress());
			tfMail.setText(u.getMailU());
			tfPhone.setText(u.getPhoneU());
	}
		
		public void updateUniversity() {
			University u = new University(Integer.parseInt(tfId.getText()), tfName.getText(), tfAddress.getText(), tfMail.getText(), tfPhone.getText());
			Database.updateUniversity(u);
			panel.updateAll();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnUpdate) {
				updateUniversity();
			}
			JFrame f = (JFrame)(getRootPane().getParent());
			f.dispose();
			
			
		}
		
		

}
