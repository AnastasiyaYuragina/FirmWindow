package lesson6.newFirm;

import java.util.ArrayList;

public class Department {
	private String nameDepartment;
	private ArrayList<Employee> listEmployee;
	private Manager manager;

	public Department(String nameDepartment) {
		this.nameDepartment = nameDepartment;
		listEmployee = new ArrayList<Employee>();
	}

	public boolean addManager(Manager manager) {
		if(this.manager == null) {
			this.manager = manager;
			return true;
		} else {
			return false;
		}
	}

	public String getNameDepartment() {
		return nameDepartment;
	}

	public boolean addEmployee(Employee employee) {
			if (listEmployee.add(employee)) {
				return true;
			}else {
				return false;
			}
	}
	
	public boolean fireEmployee(Employee employee) {
		if(employee == null) {
			return false;
		}else {
			listEmployee.remove(employee);
			return true;
		}
	}

	public ArrayList<Employee> getAllEmployees() {
		ArrayList<Employee> copy = new ArrayList<Employee>(listEmployee);
		return copy;
	}

}
