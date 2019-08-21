package edu.iup.cosc210.company.ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import edu.iup.cosc210.company.bo.CompanyManager;

/**
 * The class EmployeeFrame is a subclass of the super JFrame and will create a
 * JFrame that will print all employees in the company files
 * 
 * @author Lyndon Shelton
 *
 */
public class EmployeeFrame extends JFrame {
	private EmployeeTableModelAdapter employeeAdapter;

	/**
	 * the constructor for the class EmployeeFrame
	 * 
	 * @param cm
	 *            is an object of the CompanyManager class
	 */
	public EmployeeFrame(CompanyManager cm) {
		super("Company");
		setSize(600, 400);
		setLocation(30, 30);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		employeeAdapter = new EmployeeTableModelAdapter(cm);
		JTable employeeTable = new JTable(employeeAdapter);

		getContentPane().add(new JScrollPane(employeeTable));
	}

	/**
	 * the main method for the class EmployeeFrame will run the program and create
	 * the JFrame with the employee spreadsheet
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		if (args.length == 0) {
			System.out.println("Usage: java edu.iup.cosc210.bo.CompanyManager [Department File] [Employee file]");
			System.exit(-1);
		}
		CompanyManager cm = new CompanyManager();
		try {
			cm.loadDepts(args[0]);
			cm.loadEmployees(args[1]);
			new EmployeeFrame(cm).setVisible(true);
		} catch (FileNotFoundException e) {
			System.out.println("File " + args[0] + " not found");
			System.exit(-1);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
