package edu.iup.cosc210.company.ui;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import edu.iup.cosc210.company.bo.CompanyManager;
import edu.iup.cosc210.company.bo.Employee;

/**
 * The class EmployeeTableModelAdapter is a subclass of the super
 * AbstractTableModel and implements the interface TableModel
 * 
 * @author LyndonShelton
 *
 */
public class EmployeeTableModelAdapter extends AbstractTableModel implements TableModel {
	private CompanyManager cm;

	/**
	 * The constructor for the EmployeeTableModelAdapter, passes in values for type
	 * CompanyManager
	 * 
	 * @param cm
	 *            is an object of the CompanyManager class
	 */
	public EmployeeTableModelAdapter(CompanyManager cm) {
		super();
		this.cm = cm;
	}

	@Override
	public int getRowCount() {
		return cm.getCompany().getNoEmployees();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "ID";
		case 1:
			return "FirstName";
		case 2:
			return "LastName";
		case 3:
			return "Department";

		}
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return String.class;
		case 1:
			return String.class;
		case 2:
			return String.class;
		case 3:
			return String.class;
		}
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Employee employee = cm.getCompany().getEmployee(rowIndex);

		switch (columnIndex) {
		case 0:
			return employee.getEmployeeNumber();
		case 1:
			return employee.getFirstName();
		case 2:
			return employee.getLastName();
		case 3:
			return employee.getDepartment().getDeptName();
		}
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

	}

}
