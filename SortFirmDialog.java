package lesson6.newFirm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class SortFirmDialog extends JFrame{
	Firm firm;
	Comparator<Employee> comboBox1 = null;
	Comparator<Employee> comboBox2 = null;
	Comparator<Employee> comboBox3 = null;
	Comparator<Employee> comboBox4 = null;
	Comparator<Employee> comboBox5 = null;
	JComboBox<Comparator<Employee>> comboBoxSort1 = new JComboBox<Comparator<Employee>>();
	JComboBox<Comparator<Employee>> comboBoxSort2 = new JComboBox<Comparator<Employee>>();
	JComboBox<Comparator<Employee>> comboBoxSort3 = new JComboBox<Comparator<Employee>>();
	JComboBox<Comparator<Employee>> comboBoxSort4 = new JComboBox<Comparator<Employee>>();
	JComboBox<Comparator<Employee>> comboBoxSort5 = new JComboBox<Comparator<Employee>>();
	ArrayList<Comparator<Employee>> list = new ArrayList<Comparator<Employee>>();
	
	public SortFirmDialog(Firm firm) {
		super("IFrame #");
		this.firm = firm;
		getContentPane().setForeground(new Color(0, 0, 0));
		getContentPane().setBackground(new Color(211, 211, 211));
		getContentPane().setLayout(null);
		setSize(300, 300);
		// Set the window's location.
		setLocation(0, 0);
		
		list.add(null);
		list.add(Employee.SORT_BY_NAME);
		list.add(Employee.SORT_BY_NAME_REVERSED);
		list.add(Employee.SORT_BY_SURNAME);
		list.add(Employee.SORT_BY_SURNAME_REVERSED);
		list.add(Employee.SORT_BY_PATRONYMIC);
		list.add(Employee.SORT_BY_PATRONYMIC_REVERSED);
		list.add(Employee.SORT_BY_SALARY);
		list.add(Employee.SORT_BY_SALARY_REVERSED);
		list.add(Employee.SORT_BY_BANK_ACCOUNT);
		list.add(Employee.SORT_BY_BANK_ACCOUNT_REVERSED);
		list.add(Employee.SORT_BY_SEX);
		list.add(Employee.SORT_BY_SEX_REVERSED);
		comboBoxSort1.setBounds(20, 10, 200, 25);
		comboBoxSort2.setBounds(20, 40, 200, 25);
		comboBoxSort3.setBounds(20, 70, 200, 25);
		comboBoxSort4.setBounds(20, 100, 200, 25);
		comboBoxSort5.setBounds(20, 130, 200, 25);
		getContentPane().add(comboBoxSort1);
		getContentPane().add(comboBoxSort2);
		getContentPane().add(comboBoxSort3);
		getContentPane().add(comboBoxSort4);
		getContentPane().add(comboBoxSort5);
		for(int i = 0; i < list.size(); i++) {
			comboBoxSort1.addItem(list.get(i));
			comboBoxSort2.addItem(list.get(i));
			comboBoxSort3.addItem(list.get(i));
			comboBoxSort4.addItem(list.get(i));
			comboBoxSort5.addItem(list.get(i));
		}
			comboBox1 = (Comparator<Employee>) comboBoxSort1.getSelectedItem();
			comboBox2 = (Comparator<Employee>) comboBoxSort2.getSelectedItem();
			comboBox3 = (Comparator<Employee>) comboBoxSort3.getSelectedItem();
			comboBox4 = (Comparator<Employee>) comboBoxSort4.getSelectedItem();
			comboBox5 = (Comparator<Employee>) comboBoxSort5.getSelectedItem();
		
		JButton btnSort = new JButton("Sort");
		btnSort.setBounds(20, 160, 100, 25);
		btnSort.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onClickSort();
			}
		});
		getContentPane().add(btnSort);	
		
	}
	
	private void onClickSort() {
		firm.getAllEmployeesSorted(comboBox1.thenComparing(comboBox2).thenComparing(comboBox3).thenComparing(comboBox4).thenComparing(comboBox5));
	}
}
