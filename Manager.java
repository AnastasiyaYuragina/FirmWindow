package lesson6.newFirm;

public class Manager extends Employee {

	public Manager(String name, String surname, String patronymic, double salary, double bankAccount, String sex,
			Department department) {
		super(name, surname, patronymic, salary, bankAccount, sex, department);
		department.addManager(this);
	}

	public double getSalary() {
		double salary = super.getSalary();
		return salary + (50 * (getDepartment().getAllEmployees().size() - 1));
	}
}
