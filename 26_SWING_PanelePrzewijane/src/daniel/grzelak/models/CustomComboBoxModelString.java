package daniel.grzelak.models;

import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class CustomComboBoxModelString extends AbstractListModel<String> implements ComboBoxModel<String>{
	
	private List<String> strings;
	private String selectedString;
	public CustomComboBoxModelString(List<String> strings) {
		this.strings = strings;

		if (this.strings != null)
		{
			selectedString = strings.get(0);
		}
	}
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return strings.size();
	}

	@Override
	public String getElementAt(int index) {
		// TODO Auto-generated method stub
		return strings.get(index);
	}

	@Override
	public void setSelectedItem(Object anItem) {
		selectedString = (String)anItem;
		
	}

	@Override
	public Object getSelectedItem() {
		return selectedString;
	}

}
