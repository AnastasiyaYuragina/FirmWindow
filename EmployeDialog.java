package lesson6.newFirm;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JButton;

public class EmployeDialog extends JFrame {

	private static final long serialVersionUID = 1L;
	Firm firm;
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtPatronymic;
	private JButton btnToAnother;
	private JLabel lblNewDepartment;
	private JComboBox<String> comboBox;

	
		public EmployeDialog(Firm firm) {
			super("IFrame #");
			this.firm = firm;
			getContentPane().setForeground(new Color(0, 0, 0));
			getContentPane().setBackground(new Color(211, 211, 211));
			getContentPane().setLayout(null);
			setSize(300, 300);
			// Set the window's location.
			setLocation(0, 0);
			
			JLabel lblName = new JLabel("Name");
			lblName.setBounds(50, 10, 150, 15);
			getContentPane().add(lblName);
			
			txtName = new JTextField();
			txtName.setBounds(50, 30, 150, 25);
			getContentPane().add(txtName);
			
			JLabel lblSurname = new JLabel("Surname");
			lblSurname.setBounds(50, 60, 150, 15);
			getContentPane().add(lblSurname);
			
			txtSurname = new JTextField();
			txtSurname.setBounds(50, 80, 150, 25);
			getContentPane().add(txtSurname);
			
			JLabel lblPatronymic = new JLabel("Patronymic");
			lblPatronymic.setBounds(50, 110, 150, 15);
			getContentPane().add(lblPatronymic);
			
			txtPatronymic = new JTextField();
			txtPatronymic.setBounds(50, 130, 150, 25);
			getContentPane().add(txtPatronymic);
			
			lblNewDepartment = new JLabel("New department");
			lblNewDepartment.setBounds(50, 160, 150, 15);
			getContentPane().add(lblNewDepartment);
			
			comboBox = new JComboBox<String>();
			comboBox.setBounds(50, 185, 150, 20);
			ArrayList<Department> listDep = firm.getListDepartment();
			for(int i = 0; i < listDep.size(); i++) {
				comboBox.addItem(listDep.get(i).getNameDepartment());
			}
			getContentPane().add(comboBox);
			
			btnToAnother = new JButton("Employee to another department");
			btnToAnother.setBounds(30, 220, 250, 25);
			btnToAnother.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					onClickAnotherDep();
				}
			});
			getContentPane().add(btnToAnother);	

		}

		private void onClickAnotherDep() {
			String name = txtName.getText();
			String surname = txtSurname.getText();
			String patronymic = txtPatronymic.getText();
			
			if(firm.setDepartmentForEmployee(name, surname, patronymic, comboBox.getSelectedItem().toString())) {
				txtName.setText("");
				txtSurname.setText("");
				txtPatronymic.setText("");
			} else {
				JOptionPane.showMessageDialog(getContentPane(),
					    "Department not changed",
					    "Error",
					    JOptionPane.ERROR_MESSAGE);
			}
			saveFirmToFile(firm);
		}
		
		private void saveFirmToFile(Firm firm) {
			String fileName = "fitm.txt";
			try {
				FileWriter fileWriter = new FileWriter(fileName);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				ArrayList<Employee> newlist = firm.getAllEmployees();
				for (Employee employee : newlist) {
					bufferedWriter.write(employee.toString());
					bufferedWriter.newLine();
				}	
				bufferedWriter.close();
				
			} catch (IOException e) {
				JOptionPane.showMessageDialog(getContentPane(),
						"Error writing to file",
					    "Error",
					    JOptionPane.ERROR_MESSAGE);
			}
		}
}
