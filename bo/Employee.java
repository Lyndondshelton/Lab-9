package edu.iup.cosc210.company.bo;

import java.time.LocalDate;

/**
 * An Employee of a Company.
 * 
 * @author David T. Smith
 */
public class Employee {
	private int employeeNumber;
	private String firstName;
	private String lastName;
	private String deptCode;
	private LocalDate hireDate;
	private char employeeType;
	private double salary;
	private double hourlyRate;
	private short vacationDays;
	private byte training;
	private Department department;
	
	/**
	 * Constructor for Employee
	 * 
	 * @param employeeNumber
	 *            - the employee's id number
	 * @param firstName
	 *            - first name of the employee
	 * @param lastName
	 *            - last name of the employee
	 * @param deptCode
	 *            - department code of the employee's department
	 * @param hireDate
	 *            - the date the employee was hired
	 * @param employeeType
	 *            - indicates if an employee is Exempt ('E'), salaried ('S'),
	 *              or hourly ('H')
	 * @param salary           
	 *            - the employee's salary
	 * @param hourlyRate          
	 *            - the employee's hourlyRate
	 * @param vacationDays
	 *            - the number of vacation days
	 * @param training
	 *            - a byte using bits to indicated the training the employee has
	 *            received
	 */
	public Employee(int employeeNumber, String firstName, String lastName,
			String deptCode, LocalDate hireDate, char employeeType, double salary,
			double hourlyRate, short vacationDays, byte training) {
		super();
		this.employeeNumber = employeeNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.deptCode = deptCode;
		this.hireDate = hireDate;
		this.employeeType = employeeType;
		this.salary = salary;
		this.hourlyRate = hourlyRate;
		this.vacationDays = vacationDays;
		this.training = training;
	}

	/**
	 * Get the employee number
	 * 
	 * @return - the employee number
	 */
	public int getEmployeeNumber() {
		return employeeNumber;
	}

	/**
	 * Get the employee's first name
	 * 
	 * @return - the employee's first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Get the employee's last name
	 * 
	 * @return - the employee's last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Get the department code of the employee
	 * 
	 * @return - the department code of the employee
	 */
	public String getDeptCode() {
		return deptCode;
	}

	/**
	 * Get the employee's hire date as a string of the form mm/dd/yyyy.
	 * 
	 * @return - returns the employee's hire date
	 */
	public LocalDate getHireDate() {
		return hireDate;
	}

	/**
	 * Get the employee's type E for  exempt, S for salaried, H for hourly
	 * 
	 * @return - the employee's type
	 */
	public char getEmployeeType() {
		return employeeType;
	}
	
	/**
	 * Get the employee's salary
	 * 
	 * @return - the employee's salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * Get the employee's hourly rate
	 * 
	 * @return - the employee's hourly rate
	 */
	public double getHourlyRate() {
		return hourlyRate;
	}

	/**
	 * Get the number of vacation days for an employee
	 * 
	 * @return - the number of vacation days an employee has
	 */
	public short getVacationDays() {
		return vacationDays;
	}

	/**
	 * Get the encoded training byte.
	 * 
	 * @return - a byte whose bits indicate training the employee has received
	 */
	public byte getTraining() {
		return training;
	}

	/** 
	 * Get the Employee's department.  May be null until department is assigned.
	 *
	 * @return the Employee's department
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * Set the employee's department.  This will also set the department code.
	 * 
	 * @param department the employee's new department
	 */
	public void setDepartment(Department department) {
		if (department != getDepartment()) {
			if (getDepartment() != null) {
				getDepartment().removeEmployee(this);
			}
			department.addEmployee(this);
			this.department = department;
			this.deptCode = department.getDeptCode();

		}
	}
}
