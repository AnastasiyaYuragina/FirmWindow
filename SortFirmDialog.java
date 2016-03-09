package lesson6.newFirm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SortFirmDialog extends JFrame{
	private static final long serialVersionUID = 1L;
	Firm firm;
	MainFrame mainFrame = new MainFrame();
	Map<String, Comparator<Employee>> map = new HashMap<String, Comparator<Employee>>();
	Comparator<Employee> comboBox1 = null;
	Comparator<Employee> comboBox2 = null;
	Comparator<Employee> comboBox3 = null;
	Comparator<Employee> comboBox4 = null;
	Comparator<Employee> comboBox5 = null;
	JComboBox<String> comboBoxSort1 = new JComboBox<String>();
	JComboBox<String> comboBoxSort2 = new JComboBox<String>();
	JComboBox<String> comboBoxSort3 = new JComboBox<String>();
	JComboBox<String> comboBoxSort4 = new JComboBox<String>();
	JComboBox<String> comboBoxSort5 = new JComboBox<String>();
	public Comparator<Employee> comparator = null;
	
	public SortFirmDialog(Firm firm) {
		super("IFrame #");
		this.firm = firm;
		getContentPane().setForeground(new Color(0, 0, 0));
		getContentPane().setBackground(new Color(211, 211, 211));
		getContentPane().setLayout(null);
		setSize(300, 300);
		// Set the window's location.
		setLocation(0, 0);

		map.put("", null);
		map.put("name", Employee.SORT_BY_NAME);
		map.put("name reversed", Employee.SORT_BY_NAME_REVERSED);
		map.put("surname", Employee.SORT_BY_SURNAME);
		map.put("surname reversed", Employee.SORT_BY_SURNAME_REVERSED);
		map.put("patronymic", Employee.SORT_BY_PATRONYMIC);
		map.put("patronymic reversed", Employee.SORT_BY_PATRONYMIC_REVERSED);
		map.put("salary", Employee.SORT_BY_SALARY);
		map.put("salary reversed", Employee.SORT_BY_SALARY_REVERSED);
		map.put("bank account", Employee.SORT_BY_BANK_ACCOUNT);
		map.put("bank account reversed", Employee.SORT_BY_BANK_ACCOUNT_REVERSED);
		map.put("sex", Employee.SORT_BY_SEX);
		map.put("sex reversed", Employee.SORT_BY_SEX_REVERSED);

		comboBoxSort1.setBounds(20, 10, 250, 25);
		comboBoxSort2.setBounds(20, 40, 250, 25);
		comboBoxSort3.setBounds(20, 70, 250, 25);
		comboBoxSort4.setBounds(20, 100, 250, 25);
		comboBoxSort5.setBounds(20, 130, 250, 25);
		getContentPane().add(comboBoxSort1);
		getContentPane().add(comboBoxSort2);
		getContentPane().add(comboBoxSort3);
		getContentPane().add(comboBoxSort4);
		getContentPane().add(comboBoxSort5);

		Object[] mapKey = map.keySet().toArray();

		for(int i = 0; i < mapKey.length; i++) {
			comboBoxSort1.addItem(mapKey[i].toString());
			comboBoxSort2.addItem(mapKey[i].toString());
			comboBoxSort3.addItem(mapKey[i].toString());
			comboBoxSort4.addItem(mapKey[i].toString());
			comboBoxSort5.addItem(mapKey[i].toString());
		}
		comboBoxSort2.setEnabled(false);
		comboBoxSort3.setEnabled(false);
		comboBoxSort4.setEnabled(false);
		comboBoxSort5.setEnabled(false);

		comboBoxSort1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!comboBoxSort1.getSelectedItem().equals("")) {
					comboBox1 = map.get(comboBoxSort1.getSelectedItem());
					comboBoxSort2.setEnabled(true);
				} else {
					comboBoxSort2.setSelectedItem(null);
					comboBoxSort2.setEnabled(false);
				}
			}
		});
		comboBoxSort2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!comboBoxSort2.getSelectedItem().equals("")) {
					comboBox2 = map.get(comboBoxSort2.getSelectedItem());
					comboBoxSort3.setEnabled(true);
				} else {
					comboBoxSort3.setSelectedItem(null);
					comboBoxSort3.setEnabled(false);
				}
			}
		});
		comboBoxSort3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!comboBoxSort3.getSelectedItem().equals("")) {
					comboBox3 = map.get(comboBoxSort3.getSelectedItem());
					comboBoxSort4.setEnabled(true);
				} else {
					comboBoxSort4.setSelectedItem(null);
					comboBoxSort4.setEnabled(false);
				}
			}
		});
		comboBoxSort4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!comboBoxSort4.getSelectedItem().equals("")) {
					comboBox4 = map.get(comboBoxSort4.getSelectedItem());
					comboBoxSort5.setEnabled(true);
				} else {
					comboBoxSort5.setSelectedItem(null);
					comboBoxSort5.setEnabled(false);
				}
			}
		});
		comboBoxSort5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!comboBoxSort5.getSelectedItem().equals("")) {
					comboBox5 = map.get(comboBoxSort5.getSelectedItem());
				}
			}
		});


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
		int count = 0;
		if(comboBox1 == null){
			dialogError();
		} else {
			while(count < 5) {
				comparator = comboBox1;
				if(comboBox2 != null) {
					comparator = comparator.thenComparing(comboBox2);
				} else {
					count = 5;  
				}
				if(comboBox3 != null) {
					comparator = comparator.thenComparing(comboBox3);
				} else {
					count = 5;  
				}
				if(comboBox4 != null) {
					comparator = comparator.thenComparing(comboBox4);
				} else {
					count = 5;  
				}
				if(comboBox5 != null) {
					comparator = comparator.thenComparing(comboBox5);
				} else {
					count = 5;  
				}
				count++;
			}
		}
		mainFrame.displayListEmployee(firm.getAllEmployeesSorted(comparator));
	}

	private void dialogError() {
		JOptionPane.showMessageDialog(getContentPane(),
				"Sort type is empty",
				"Error",
				JOptionPane.ERROR_MESSAGE);
	}
}
