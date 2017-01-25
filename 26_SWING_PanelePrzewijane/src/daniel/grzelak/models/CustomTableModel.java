package daniel.grzelak.models;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import daniel.grzelak.classes.StudentUniversity;

public class CustomTableModel extends AbstractTableModel{
	private List<StudentUniversity> studentsUniverities;
	private List<String> headers;
	
	public CustomTableModel(List<StudentUniversity> studentsUniversities, List<String> headers) {
		this.studentsUniverities = studentsUniversities;
		this.headers = headers;
	}
	public void update(List<StudentUniversity> studentsUniversities) {
		this.studentsUniverities = studentsUniversities;
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return studentsUniverities.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return headers.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		StudentUniversity su = studentsUniverities.get(rowIndex);
		
		if (columnIndex == 0)
		{
			return su.getId();
		}else if (columnIndex == 1){
			return su.getName();
		}else if (columnIndex == 2){
			return su.getSurname();
		}else if (columnIndex == 3){
			return su.getAge();
		}else if (columnIndex == 4){
			return su.getStudyYear();
		}else if (columnIndex == 5){
			return su.getMailS();
		}else if (columnIndex == 6){
			return su.getPhoneS();
		}else if (columnIndex == 7){
			return su.getNameU();
		}else if (columnIndex == 8){
			return su.getAddress();
		}else if (columnIndex == 9){
			return su.getMailU();
		}else {
			return su.getPhoneU();
		}
	}
	
	@Override
	public String getColumnName(int column) {
		return headers.get(column);
	}

}
