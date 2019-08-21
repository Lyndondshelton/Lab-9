package edu.iup.cosc210.company.io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import edu.iup.cosc210.company.bo.Employee;

/**
 * Helper class to read employees from a binary employee file.  
 * The method readEmployee() returns the next employee from 
 * the employee file.
 * 
 * @author David T. Smith
 */
public class EmployeeInputStream {
	private DataInputStream input;
	
	// declare byte buffers for the ascii fields.
	private byte[] firstNameBytes = new byte[10];
	private byte[] lastNameBytes = new byte[15];
	private byte[] deptCodeBytes = new byte[2];

	/**
	 * Constructor - opens the employee file.
	 * @param fileName - name of the employee file
	 * @throws FileNotFoundException - in the event the file could not be opened
	 */
	public EmployeeInputStream(String fileName) throws FileNotFoundException {
		input = new DataInputStream(new FileInputStream(fileName));
	}

	/**
	 * Read the next employee from the employee file.
	 * @return an employee.  Returns null in the event the end of
	 * the employee file is reached.
	 * @throws IOException
	 */
	public Employee readEmployee() throws IOException {
		// Test for end of file
		if (input.available() == 0) {
			return null;
		}
		
		int employeeNumber = input.readInt();
		
		input.read(firstNameBytes);
		String firstName = new String(firstNameBytes).trim();
		
		input.read(lastNameBytes);
		String lastName = new String(lastNameBytes).trim();
		
		input.read(deptCodeBytes);
		String deptCode = new String(deptCodeBytes);
		
		int month = input.readByte();
		int day = input.readByte();
		int year = input.readShort();
		LocalDate hireDate = LocalDate.of(year, month, day);
		
		char empType = (char) input.readByte();
		
		double salary = input.readDouble();
		double hourlyRate = input.readDouble();

		short vacationDays = input.readShort();
		byte training = input.readByte();

		Employee employee = new Employee(employeeNumber, firstName,
				lastName, deptCode, hireDate, empType, salary, hourlyRate, vacationDays, training);

		return employee;
	}

	/**
	 * Close the employee file
	 * @throws IOException
	 */
	public void close() throws IOException {
		input.close();
	}	
}
