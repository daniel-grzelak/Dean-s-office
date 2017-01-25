package daniel.grzelak.models;

import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;


public class CustomComboBoxModel  extends AbstractListModel<Integer>  implements ComboBoxModel<Integer>{
	
	private List<Integer> ids;
	private Integer selectedId;
	
	public CustomComboBoxModel(List<Integer> ids) {
		this.ids = ids;
		if (this.ids != null)
		{
			selectedId = ids.get(0);
		}
	}
	
	
	
	public void updateIds(List<Integer> ids) {
		this.ids = ids;
	}
	
	@Override
	public Integer getElementAt(int index) {
		return ids.get(index);
	}

	@Override
	public int getSize() {
		return ids.size();
	}

	@Override
	public Object getSelectedItem() {
		return selectedId;
	}

	@Override
	public void setSelectedItem(Object anItem) {
		selectedId = (Integer)anItem;
		
	}


}
