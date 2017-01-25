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

import daniel.grzelak.classes.University;
import daniel.grzelak.database.Database;

public class PanelUniversity extends JPanel implements ActionListener {

	private JButton btnLeft;
	private JButton btnRight;
	private JButton btnInsert;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JLabel lName;
	private JLabel lAddress;

	private JLabel lMail;
	private JLabel lPhone;
	private JTextField tfId;
	private JTextField tfName;
	private JTextField tfAddress;

	private JTextField tfMail;
	private JTextField tfPhone;
	
	private List<University> universities;
	private int idx; 
	
	
	public PanelUniversity() {

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
		lAddress = new JLabel("Address: ");

		lMail = new JLabel("Mail: ");
		lPhone = new JLabel("Phone: ");
		tfId = new JTextField(10);
		tfId.setEditable(false);
		tfName = new JTextField(30);
		tfName.setEditable(false);
		tfAddress = new JTextField(30);
		tfAddress.setEditable(false);

		tfMail = new JTextField(30);
		tfMail.setEditable(false);
		tfPhone = new JTextField(12);
		tfPhone.setEditable(false);

		JPanel panelUp = new JPanel(new GridBagLayout());
		GridBagConstraints gbc1 = new GridBagConstraints();


		gbc1.weightx = 1;
		gbc1.weighty = 1;
		
		
		gbc1.gridx = 0;
		gbc1.gridy = 0;
		panelUp.add(btnLeft, gbc1);

		gbc1.gridx = 1;
		gbc1.gridy = 0;
		panelUp.add(tfId, gbc1);

		gbc1.gridx = 2;
		gbc1.gridy = 0;
		panelUp.add(btnRight, gbc1);

		JPanel panelMiddle = new JPanel(new GridBagLayout());
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.weightx = 1;
		gbc2.weighty = 1;
		
		gbc2.gridx = 0;
		gbc2.gridy = 0;
		panelMiddle.add(lName, gbc2);

		gbc2.gridx = 2;
		gbc2.gridy = 0;
		panelMiddle.add(tfName, gbc2);

		gbc2.gridx = 0;
		gbc2.gridy = 1;
		panelMiddle.add(lAddress, gbc2);

		gbc2.gridx = 2;
		gbc2.gridy = 1;
		panelMiddle.add(tfAddress, gbc2);

		gbc2.gridx = 0;
		gbc2.gridy = 2;
		panelMiddle.add(lMail, gbc2);

		gbc2.gridx = 2;
		gbc2.gridy = 2;
		panelMiddle.add(tfMail, gbc2);

		gbc2.gridx = 0;
		gbc2.gridy = 3;
		panelMiddle.add(lPhone, gbc2);

		gbc2.gridx = 2;
		gbc2.gridy = 3;
		panelMiddle.add(tfPhone, gbc2);

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
		add(panelMiddle, BorderLayout.CENTER);
		add(panelDown, BorderLayout.PAGE_END);
		
		universities = Database.selectUniversity();
		idx = 0;
		fillPanel();
	}
	
	public void updateAll() {
		universities = Database.selectUniversity();
		tfId.setText(universities.get(idx).getId() + "");
		tfName.setText(universities.get(idx).getNameU());
		tfAddress.setText(universities.get(idx).getAddress());
		tfMail.setText(universities.get(idx).getMailU());;
		tfPhone.setText(universities.get(idx).getPhoneU());
	}
	
	public void afterInsert()
	{
		universities = Database.selectUniversity();
		idx = universities.size() - 1;
		updateAll();
	}
	
	private void fillPanel()
	{
		tfId.setText(String.valueOf(universities.get(idx).getId()));
		tfName.setText(universities.get(idx).getNameU());
		tfAddress.setText(universities.get(idx).getAddress());
		tfMail.setText(universities.get(idx).getMailU());
		tfPhone.setText(universities.get(idx).getPhoneU());
		
	}
	
	private void showInsertWindow()
	{
		JFrame frame = new JFrame("INSERT STUDENT");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		University u = new University(Integer.parseInt(tfId.getText()), tfName.getText(), tfAddress.getText(), tfMail.getText(), tfPhone.getText());
		PanelInsertUniversity panelInsertUniversity = new PanelInsertUniversity(u, this);

		panelInsertUniversity.setVisible(true);
		frame.setContentPane(panelInsertUniversity); 
		
		
		frame.setVisible(true);
		frame.setResizable(true); 
		frame.pack();
		frame.setLocationRelativeTo(null);
		
		
	}
	
	private void showUpdateWindow() {
		JFrame frame = new JFrame("UPDATE STUDENT");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		
		University u = new University(Integer.parseInt(tfId.getText()), tfName.getText(), tfAddress.getText(), tfMail.getText(), tfPhone.getText());
		PanelUpdateUniversity panelUpdateUniversity = new PanelUpdateUniversity(u, this);

		panelUpdateUniversity.setVisible(true);
		frame.setContentPane(panelUpdateUniversity); 
		
		
		frame.setVisible(true);
		frame.setResizable(true); 
		frame.pack();
		frame.setLocationRelativeTo(null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnLeft) {
			idx--;
			if (idx < 0)
			{
				idx = universities.size() - 1;
			}
			fillPanel();
			
		}else if (e.getSource() == btnRight) {
			idx++;
			if (idx >= universities.size())
			{
				idx = 0;
			}
			fillPanel();
			
		} else if (e.getSource() == btnInsert) {
			showInsertWindow();

		} else if (e.getSource() == btnUpdate) {
			showUpdateWindow();

		} else if (e.getSource() == btnDelete) {
			if (!tfId.getText().isEmpty())
			{	
				Database.deleteUniversity(Integer.parseInt(tfId.getText()));
				universities = Database.selectUniversity();
				if (idx >= universities.size())
				{
					idx--;
				}
				fillPanel();
			}
			
		}

	}

}

