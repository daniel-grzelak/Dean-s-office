package daniel.grzelak.models;

import java.util.List;

import javax.swing.AbstractListModel;

public class CustomListModel extends AbstractListModel<String>{

	private List<String> list;
	
	public CustomListModel(List<String> list) {
		this.list = list;
	}
	
	public void updateLista(List<String> list) {
		this.list = list;
	}
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public String getElementAt(int index) {
		// TODO Auto-generated method stub
		return list.get(index);
	}

}
