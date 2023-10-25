import java.util.List;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
public class EmployeeTableModel extends AbstractTableModel {

	private final int empidcolumn=0;
	private final int lastnamecolumn=1;
	private final int firstnamecolumn=2;
	private final int emailcolumn=3;
	private final int departmentcolumn=4;
	private final int salarycolumn=5;
	
	String columnNames[]= {"EmoloyeeID","Last Name","First Name","Email","Department","Salary"};
	List<Employee> employees;
	EmployeeTableModel(List<Employee> theEmployee){
		employees=theEmployee;
	}
	
	public String getColumnName(int col) {
		return columnNames[col];
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return employees.size();
	}


	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		Employee temp=employees.get(row);
		switch(col) {
		case empidcolumn:
			return temp.getID();
		case lastnamecolumn:
			return temp.get_last_name();
		case firstnamecolumn:
			return temp.get_first_name();
		case emailcolumn:
			return temp.get_email();
		case departmentcolumn:
			return temp.department();
		case salarycolumn:
			return temp.salary();
		default:
			return temp.get_last_name();
		}
	}
	
	public Class getColumnClass(int c) {
		return getValueAt(0,c).getClass();
		
	}

}
