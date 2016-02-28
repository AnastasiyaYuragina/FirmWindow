package lesson6.newFirm;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JComponent;


public class MainFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtPatronymic;
	private JTextField textSalary;
	private JTextField textBankAccount;
	private JTextField textNameDelete;
	private JTextField textSurnameDelete;
	private JTextField textPatronymicDelete;
//	private JTextField textNameAnother;
//	private JTextField textSurnameAnother;
//	private JTextField textPatronymicAnother;
	public JTextPane textPane;
	private JRadioButton rdbtnMan;
	private JRadioButton rdbtnWoman;
	private JComboBox<String> comboBoxDepartment;
//	private JComboBox<String> comboBoxDepartmentAnother;
	private final String kManager = "Manager";
	private final String kEmployee = "Employee";
	private final String kSalesManager = "Sales manager";
	private JComboBox<String> comboBoxAddEmployee;
	private JComboBox<String> comboBoxFromDepartment;
	private JButton btnUpdate;
//	private JButton btnEmployeeToAnother;
	private JButton btnSortBySalary;
	private JButton btnSortBySurname;
	private JButton btnGiveSalary;
	private JButton btnToAnother;
	private JLabel lblEmployeesFromDepartment;
	private JButton btnSortBySalaryDep;
	private JButton btnGetAllEmlpoyee;
	private JButton btnSortBySurnameDep;
	private JButton btnSalesmanagerSellFor;
	private JButton btnGiveMoneyTo;
	private JTextField textFieldMoney;
	private JButton btnShowSumOn;
	Firm firm = new Firm("Name", "Address Firm", 100_000);
		
	public MainFrame() {
		this.setBounds(10, 10, 1000, 600);
		getContentPane().setLayout(null);
		
		textPane = new JTextPane();
		textPane.setBounds(250, 10, 350, 300);
		textPane.setEditable(false);
		getContentPane().add(textPane);
		
		JLabel lblFireEmployee = new JLabel("Fire Employee");
		lblFireEmployee.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFireEmployee.setBounds(10, 10, 150, 15);
		getContentPane().add(lblFireEmployee);
		
		JLabel lblNameDelete = new JLabel("Name");
		lblNameDelete.setBounds(10, 30, 150, 15);
		getContentPane().add(lblNameDelete);
		
		textNameDelete = new JTextField();
		textNameDelete.setBounds(10, 50, 150, 25);
		getContentPane().add(textNameDelete);
		
		JLabel lblSurmaneDelete = new JLabel("Surmane");
		lblSurmaneDelete.setBounds(10, 80, 150, 15);
		getContentPane().add(lblSurmaneDelete);
		
		textSurnameDelete = new JTextField();
		textSurnameDelete.setBounds(10, 100, 150, 25);
		getContentPane().add(textSurnameDelete);
		
		JLabel lblPatronymicDelete = new JLabel("Patronymic");
		lblPatronymicDelete.setBounds(10, 130, 150, 15);
		getContentPane().add(lblPatronymicDelete);
		
		textPatronymicDelete = new JTextField();
		textPatronymicDelete.setBounds(10, 150, 150, 25);
		getContentPane().add(textPatronymicDelete);
		
		JButton btnFireEmployee = new JButton("Fire employee");
		btnFireEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClickFireEmployee();
			}
		});
		btnFireEmployee.setBounds(10, 180, 150, 25);
		getContentPane().add(btnFireEmployee);
		
//		JLabel lblEmployeeToAnother = new JLabel("Employee to another department");
//		lblEmployeeToAnother.setFont(new Font("Tahoma", Font.BOLD, 11));
//		lblEmployeeToAnother.setBounds(10, 210, 210, 15);
//		getContentPane().add(lblEmployeeToAnother);
//		
//		JLabel lblNameAnother = new JLabel("Name");
//		lblNameAnother.setBounds(10, 230, 230, 15);
//		getContentPane().add(lblNameAnother);
//		
//		textNameAnother = new JTextField();
//		textNameAnother.setBounds(10, 250, 150, 25);
//		getContentPane().add(textNameAnother);
//		
//		JLabel lblSurmaneAnother = new JLabel("Surmane");
//		lblSurmaneAnother.setBounds(10, 280, 150, 15);
//		getContentPane().add(lblSurmaneAnother);
//		
//		textSurnameAnother = new JTextField();
//		textSurnameAnother.setBounds(10, 300, 150, 25);
//		getContentPane().add(textSurnameAnother);
//		
//		JLabel lblPatronymicAnother = new JLabel("Patronymic");
//		lblPatronymicAnother.setBounds(10, 330, 150, 15);
//		getContentPane().add(lblPatronymicAnother);
//		
//		textPatronymicAnother = new JTextField();
//		textPatronymicAnother.setBounds(10, 350, 150, 25);
//		getContentPane().add(textPatronymicAnother);
//		
//		comboBoxDepartmentAnother = new JComboBox<String>();
//		comboBoxDepartmentAnother.setBounds(10, 380, 150, 25);
//		getContentPane().add(comboBoxDepartmentAnother);
//		ArrayList<Department> listDepAnother = firm.getListDepartment();
//		for(int i = 0; i < listDepAnother.size(); i++) {
//			comboBoxDepartmentAnother.addItem(listDepAnother.get(i).getNameDepartment());
//		}
//		
//		btnEmployeeToAnother = new JButton("Employee to another department");
//		btnEmployeeToAnother.setBounds(10, 410, 240, 25);
//		btnEmployeeToAnother.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				onClickAnotherDep();
//			}
//		});
//		getContentPane().add(btnEmployeeToAnother);
		
		
		JLabel lblAddEmployee = new JLabel("Add Employee");
		lblAddEmployee.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddEmployee.setBounds(660, 10, 150, 15);
		getContentPane().add(lblAddEmployee);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(660, 30, 150, 15);
		getContentPane().add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(660, 50, 150, 25);
		getContentPane().add(txtName);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(660, 80, 150, 15);
		getContentPane().add(lblSurname);
		
		txtSurname = new JTextField();
		txtSurname.setBounds(660, 100, 150, 25);
		getContentPane().add(txtSurname);
		
		JLabel lblPatronymic = new JLabel("Patronymic");
		lblPatronymic.setBounds(660, 130, 150, 15);
		getContentPane().add(lblPatronymic);
		
		txtPatronymic = new JTextField();
		txtPatronymic.setBounds(660, 150, 150, 25);
		getContentPane().add(txtPatronymic);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setBounds(660, 180, 150, 15);
		getContentPane().add(lblSalary);
		
		textSalary = new JTextField();
		textSalary.setBounds(660, 200, 150, 25);
		getContentPane().add(textSalary);
		
		JLabel lblBankAccount = new JLabel("Bank Account");
		lblBankAccount.setBounds(660, 230, 150, 15);
		getContentPane().add(lblBankAccount);
		
		textBankAccount = new JTextField();
		textBankAccount.setBounds(660, 250, 150, 25);
		getContentPane().add(textBankAccount);
		
		rdbtnWoman = new JRadioButton("Woman");
		rdbtnWoman.setBounds(660, 280, 75, 25);
		rdbtnWoman.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(rdbtnWoman.isSelected()) {
					rdbtnMan.setSelected(false);
				}
			}
		});
		getContentPane().add(rdbtnWoman);
		
		rdbtnMan = new JRadioButton("Man");
		rdbtnMan.setBounds(740, 280, 100, 25);
		rdbtnMan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(rdbtnMan.isSelected()) {
					rdbtnWoman.setSelected(false);
				}
			}
		});
		getContentPane().add(rdbtnMan);
		
		comboBoxDepartment = new JComboBox<String>();
		comboBoxDepartment.setBounds(660, 310, 150, 25);
		getContentPane().add(comboBoxDepartment);
		addDepartment();
		ArrayList<Department> listDep = firm.getListDepartment();
		for(int i = 0; i < listDep.size(); i++) {
			comboBoxDepartment.addItem(listDep.get(i).getNameDepartment());
		}

		comboBoxAddEmployee = new JComboBox<String>();
		comboBoxAddEmployee.setBounds(660, 345, 150, 25);
		getContentPane().add(comboBoxAddEmployee);
		String[] list = {kEmployee, kManager, kSalesManager};
		for(int i = 0; i < list.length; i++) {
			comboBoxAddEmployee.addItem(list[i]);
		}
		
		JButton btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.setBounds(660, 390, 150, 25);
		btnAddEmployee.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onClickAddEmployee();
			}
		});
		getContentPane().add(btnAddEmployee);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(300, 315, 150, 25);
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayListEmployee(firm.getAllEmployees());
			}
		});
		getContentPane().add(btnUpdate);
		
		btnSortBySalary = new JButton("Sort by salary");
		btnSortBySalary.setBounds(300, 350, 150, 25);
		btnSortBySalary.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onClickSortBySalaryAll();
			}
		});
		getContentPane().add(btnSortBySalary);
		
		btnSortBySurname = new JButton("Sort by surname");
		btnSortBySurname.setBounds(300, 380, 150, 25);
		btnSortBySurname.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onClickSortBySurnameAll();
			}
		});
		getContentPane().add(btnSortBySurname);
		
		btnGiveSalary = new JButton("Give Salary");
		btnGiveSalary.setBounds(300, 410, 150, 25);
		btnGiveSalary.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onClickGiveSalary();
			}
		});
		getContentPane().add(btnGiveSalary);
		
		btnToAnother = new JButton("Employee to another department");
		btnToAnother.setBounds(10, 220, 230, 25);
		btnToAnother.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createFrame();
			}
		});
		getContentPane().add(btnToAnother);	
		
		lblEmployeesFromDepartment = new JLabel("Employees From Department");
		lblEmployeesFromDepartment.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmployeesFromDepartment.setBounds(10, 260, 190, 15);
		getContentPane().add(lblEmployeesFromDepartment);
		
		comboBoxFromDepartment = new JComboBox<String>();
		comboBoxFromDepartment.setBounds(10, 280, 150, 25);
		for(int i = 0; i < listDep.size(); i++) {
			comboBoxFromDepartment.addItem(listDep.get(i).getNameDepartment());
		}
		getContentPane().add(comboBoxFromDepartment);
		
		btnSortBySalaryDep = new JButton("Sort by salary from department");
		btnSortBySalaryDep.setBounds(10, 345, 250, 25);
		btnSortBySalaryDep.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onClickSortBySalaryDep();
			}
		});
		getContentPane().add(btnSortBySalaryDep);
		
		btnGetAllEmlpoyee = new JButton("Get all emlpoyee from department");
		btnGetAllEmlpoyee.setBounds(10, 315, 250, 25);
		btnGetAllEmlpoyee.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onClickListEmployeeFromDep();
			}
		});
		getContentPane().add(btnGetAllEmlpoyee);
		
		btnSortBySurnameDep = new JButton("Sort by surname from department");
		btnSortBySurnameDep.setBounds(10, 380, 250, 25);
		btnSortBySurnameDep.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onClickSortBySurnameDep();
			}
		});
		getContentPane().add(btnSortBySurnameDep);
		
		btnSalesmanagerSellFor = new JButton("Salesmanager sell for 10");
		btnSalesmanagerSellFor.setBounds(300, 440, 200, 25);
		btnSalesmanagerSellFor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onClickSell();
			}
		});
		getContentPane().add(btnSalesmanagerSellFor);
		
		btnGiveMoneyTo = new JButton("Give money to firm");
		btnGiveMoneyTo.setBounds(10, 525, 150, 25);
		btnGiveMoneyTo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onClickAddMoneyToFirm();
			}
		});
		getContentPane().add(btnGiveMoneyTo);
		
		textFieldMoney = new JTextField();
		textFieldMoney.setBounds(10, 495, 150, 25);
		getContentPane().add(textFieldMoney);
		textFieldMoney.setColumns(10);
		
		btnShowSumOn = new JButton("Show sum on bank account firm");
		btnShowSumOn.setBounds(170, 525, 250, 25);
		btnShowSumOn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textPane.setText(firm.getBankAccountFirm());
			}
		});
		getContentPane().add(btnShowSumOn);
		
		JButton btnSort = new JButton("Sort");
		btnSort.setBounds(300, 476, 89, 23);
		getContentPane().add(btnSort);
		btnSort.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				onClickSortFirm();
				
			}
		});

	}
	
	private void onClickAddMoneyToFirm() {
		double money = 0;
		try {
			money = Integer.parseInt(textFieldMoney.getText());
		} catch (NumberFormatException e) {
			dialogError("Incorrect money");
		}
		firm.addBankAccountFirm(money);
	}
	
	private void addDepartment() {
		firm.addDepartment(new Department("IT"));
		firm.addDepartment(new Department("Managers"));
		firm.addDepartment(new Department("Sales"));
	}
	
	private void onClickFireEmployee() {
		String name = textNameDelete.getText();
		String surname = textSurnameDelete.getText();
		String patronymic = textPatronymicDelete.getText();
		if (firm.fireEmployee(name, surname, patronymic)) {
			textNameDelete.setText("");
			textSurnameDelete.setText("");
			textPatronymicDelete.setText("");
		} else {
			dialogError("Employee not fire");
		}
		
		saveFirmToFile(firm);
		displayListEmployee(firm.getAllEmployees());
	}
	
	public void displayListEmployee(ArrayList<Employee> list) {
		String str = ""; 
		for (Employee employee : list) {
			str = str + employee.getClass().getSimpleName() + " " + employee.toString();
		}
		textPane.setText(str);
	}
	
	private void onClickAddEmployee() {		
		Employee employee = null;
		String name = txtName.getText();
		String surname = txtSurname.getText();
		String patronymic = txtPatronymic.getText();
		int salary = 0;
		int bankAccount = 0;
		try {
			salary = Integer.parseInt(textSalary.getText());
		} catch (NumberFormatException e) {
			dialogError("Incorrect salary");
		}
		try {
			bankAccount = Integer.parseInt(textBankAccount.getText());
		} catch (NumberFormatException e) {
			dialogError("Incorrect sum on bank account");
		}
		String sex = "";
		if(rdbtnMan.isSelected() && !rdbtnWoman.isSelected()) {
			sex = Employee.fMan;
		} else if(!rdbtnMan.isSelected() && rdbtnWoman.isSelected()) {
			sex = Employee.fWoman;
		}
		Department department = firm.getDepartmentByName(comboBoxDepartment.getSelectedItem().toString());
		
		if(comboBoxAddEmployee.getSelectedItem().equals(kManager)) {
			employee = new Manager(name, surname, patronymic, salary, bankAccount, sex, department);
		} else if(comboBoxAddEmployee.getSelectedItem().equals(kEmployee)) {
			employee = new Employee(name, surname, patronymic, salary, bankAccount, sex, department);
		} else if(comboBoxAddEmployee.getSelectedItem().equals(kSalesManager)) {
			employee = new SalesManager(name, surname, patronymic, salary, bankAccount, sex, department);
		}
		
		if(firm.addEmployee(employee)) {
			txtName.setText("");
			txtSurname.setText("");
			txtPatronymic.setText("");
			textSalary.setText("");
			textBankAccount.setText("");
			rdbtnMan.setSelected(false);
			rdbtnWoman.setSelected(false);
		} else {
			dialogError("Employee not add");
		}
		saveFirmToFile(firm);
		displayListEmployee(firm.getAllEmployees());
	}
	
	private void onClickGiveSalary() {
		firm.giveSalaryForAll();
		saveFirmToFile(firm);
		displayListEmployee(firm.getAllEmployees());
	}
	
	private void onClickSortBySalaryAll() {
		displayListEmployee(firm.getAllEmployeesOrderedBySalary());
	}
	
	private void onClickSortBySurnameAll() {
		displayListEmployee(firm.getAllEmployeesSortedBySName());
	}
	
	private void onClickListEmployeeFromDep() {
		displayListEmployee(firm.getEmployeesFromDep(comboBoxFromDepartment.getSelectedItem().toString()));
	}
	
	private void onClickSortBySalaryDep() {
		ArrayList<Employee> list = firm.getEmployeesFromDepSortedBySalary(comboBoxFromDepartment.getSelectedItem().toString());
		displayListEmployee(list);
	}
	
	private void onClickSortBySurnameDep() {
		ArrayList<Employee> list = firm.getEmployeesFromDepSortedBySName(comboBoxFromDepartment.getSelectedItem().toString());
		displayListEmployee(list);
	}
	
	private void onClickSell() {
		firm.sellFor10();
		saveFirmToFile(firm);
	}
	
	private void dialogError(String string) {
		JOptionPane.showMessageDialog(getContentPane(),
			    string,
			    "Error",
			    JOptionPane.ERROR_MESSAGE);
	}
	
	private void onClickSortFirm() {
		SortFirmDialog frame = new SortFirmDialog(firm);
		frame.firm = firm;
		frame.setVisible(true);
		// Every JInternalFrame must be added to content pane using JDesktopPane
		this.getContentPane().add(frame);
		frame.toFront();
	}
	
//	private void loadFirmFromFile(Firm firm) {
//		String fileName = "./firm.txt";
//		String line = null;
//		
//		try {
//			FileReader fileReader = new FileReader(fileName);
//			BufferedReader bufferedReader = new BufferedReader(fileReader);
//			while((line = bufferedReader.readLine()) != null) {
//				textPane.setText(line);
//			}
//			bufferedReader.close();
//		} catch (FileNotFoundException e) {
//			dialogError("Unable to open file");
//		} catch (IOException e) {
//			dialogError("Error reading file");
//		}
//	}
	
	private void saveFirmToFile(Firm firm) {
		String fileName = "./firm.txt";
		try {
			FileWriter fileWriter = new FileWriter(fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			ArrayList<Employee> newlist = firm.getAllEmployees();
			for (Employee employee : newlist) {
				bufferedWriter.write(employee.toString());
			}	
			bufferedWriter.close();
			
		} catch (IOException e) {
			dialogError("Error writing to file");
		}
	}
	
	protected void createFrame() {
		EmployeDialog frame = new EmployeDialog(firm);
		frame.firm = firm;
		frame.setVisible(true);
		// Every JInternalFrame must be added to content pane using JDesktopPane
		this.getContentPane().add(frame);
//		try {
//			frame.setSelected(true);
//		} catch (java.beans.PropertyVetoException e) {
//		}
		frame.toFront();
	}
}
