package lesson6.newFirm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Firm {

	private String name;
	private String address;
	private double bankAccount;
	private ArrayList<Employee> listEmployee;
	private ArrayList<Department> listDepartment;
	
	public Firm(String name, String address, double bankAccount) {
		this.name = name;
		this.address = address;
		this.bankAccount = bankAccount;
		listEmployee = new ArrayList<Employee>();
		listDepartment = new ArrayList<Department>();
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getName() {
		return name;
	}
	
	public void addDepartment (Department department) {
		listDepartment.add(department);
	}
	
	public ArrayList<Department> getListDepartment() {
		ArrayList<Department> copy = new ArrayList<Department>(listDepartment);
		return copy;
	}
	
	public Department getDepartmentByName(String name) {
		for (Department department : listDepartment) {
			if(department.getNameDepartment().equals(name)) {
				return department;
			}
		}
		return null;
	}

	public void addBankAccountFirm(double money) {
		this.bankAccount += money;
	}
	public String getBankAccountFirm() {
		String s = bankAccount + "";
		return s;
	}
	
	public boolean addEmployee(Employee employee) {
		boolean isUserInBD = false;
		for (Employee employee2 : listEmployee) {
			if(employee.getSurname() == employee2.getSurname() && employee.getName() == employee2.getName() ) {
				isUserInBD = true;
			}
		}
		if(isUserInBD == false){
			listEmployee.add(employee);
			employee.getDepartment().addEmployee(employee);
			return true;
		}
		return false;
	}

	public boolean fireEmployee(String name, String surname, String patronymic) {
		Employee employee = findEmployee(name, surname, patronymic);

		if(employee == null) {
			return false;
		} else if(employee.getDepartment().fireEmployee(employee)) {
			listEmployee.remove(employee);
			return true;
		} else {
			return false;
		}
	}

	public Employee findEmployee(String name, String surname, String patronymic) {

		for(int i = 0; i < listEmployee.size(); i++) {
			Employee indexOfEmployee = listEmployee.get(i);
			boolean bName = indexOfEmployee.getName().equals(name);
			boolean bSurname = indexOfEmployee.getSurname().equals(surname);
			boolean bPatronymic = indexOfEmployee.getPatronymic().equals(patronymic);
			
			if(bName && bSurname && bPatronymic) {
				return indexOfEmployee;
			}
		}
		return null;
	}

	public boolean setDepartmentForEmployee(String name, String surname, String patronymic, String departmentName) {
		Employee employee = findEmployee(name, surname, patronymic);
		boolean isSet = false;
		
		if(employee == null) {
			isSet = false;
		} else if(employee.getDepartment().fireEmployee(employee)) {
			for (Department department : listDepartment) {
				if(department.getNameDepartment().equals(departmentName)) {
					employee.setDepartment(department);
					department.addEmployee(employee);
					isSet = true;
				} 
			} 
		} else {
			isSet = false;
		}
		return isSet;
	}
	
	public void giveSalaryForAll(){
		for (Employee employee : listEmployee) {
			double salarys = employee.getSalary();
			double currenBankAccount = bankAccount;
			currenBankAccount -= salarys;
			if(currenBankAccount >= 0) {
				employee.pay(salarys);
				bankAccount -= salarys;
			} 
		}
	}

	public ArrayList<Employee> getAllEmployees() {
		ArrayList<Employee> copy = new ArrayList<Employee>(listEmployee);
		return copy;
	}
	
	public ArrayList<Employee> getEmployeesFromDep(String departmentName) {
		for (Department department : listDepartment) {
			if(departmentName == department.getNameDepartment()) {
				ArrayList<Employee> copy = new ArrayList<Employee>(department.getAllEmployees());
				return copy;
			}
		}
		return null;
	}
	
	public ArrayList<Employee> getEmployeesFromDepSorted(String departmentName, Comparator<Employee> comparator) {
		for (Department department : listDepartment) {
			if(departmentName == department.getNameDepartment()) {
				ArrayList<Employee> copy = new ArrayList<Employee>(department.getAllEmployees());
				Collections.sort(copy, comparator);
				return copy;
			}
		}
		return null;
	}
	
	public ArrayList<Employee> getEmployeesFromDepSortedBySalary(String departmentName) {
		for (Department department : listDepartment) {
			if(departmentName == department.getNameDepartment()) {
				ArrayList<Employee> copy = new ArrayList<Employee>(department.getAllEmployees());
				Collections.sort(copy, Employee.Comparators.salaryCompare);
				return copy;
			}
		}
		return null;
	}
	
	public ArrayList<Employee> getEmployeesFromDepSortedBySName(String departmentName) {
		for (Department department : listDepartment) {
			if(departmentName == department.getNameDepartment()) {
				ArrayList<Employee> copy = new ArrayList<Employee>(department.getAllEmployees());
				Collections.sort(copy, Employee.Comparators.surnameCompare);
				return copy;
			}
		}
		return null;
	}

	public ArrayList<Employee> getAllEmployeesSorted(Comparator<Employee> comparator) {
		ArrayList<Employee> copy = new ArrayList<Employee>(listEmployee);
		Collections.sort(copy, comparator);
		return copy;
	}
	
	public ArrayList<Employee> getAllEmployeesOrderedBySalary() {
		ArrayList<Employee> copy = new ArrayList<Employee>(listEmployee);
		Collections.sort(copy, Employee.Comparators.salaryCompare);
		return copy;
	}
	
	public ArrayList<Employee> getAllEmployeesSortedBySName() {
		ArrayList<Employee> copy = new ArrayList<Employee>(listEmployee);
		Collections.sort(copy, Employee.Comparators.surnameCompare);
		return copy;
	}
	
	public void sellFor10() {
		for (Employee employee : listEmployee) {
			if(employee instanceof SalesManager) {
				((SalesManager) employee).setSumSales(10_000);
			}
		}
	}
	
	public String toString(ArrayList<Employee> list) {
		String stringEmployee = "";
		for (Employee employee : list) {
			stringEmployee = stringEmployee + employee.toString() + "";
		} 
		return stringEmployee;
	}
}

