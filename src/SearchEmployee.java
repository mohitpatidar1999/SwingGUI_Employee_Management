import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.util.List;
public class SearchEmployee extends JFrame{
	JLabel l1;
	JTextField t1;
	JPanel mainPanel,j1,j2;
	JScrollPane scrollPane;
	
	JTable table=new JTable();
	Object model=table.getModel();
	
	JButton b1,add,update,delete;
	SearchEmployee s;
	SearchEmployee() throws Exception{
		
		EmployeeDAO ed=new EmployeeDAO();
		
		
		setBounds(500,200,1000,600);
		setLayout(null);
		setTitle("Employee Searching");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//upr ka panel
		
		mainPanel=new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBounds(500,200,965,800);
		setContentPane(mainPanel);
		//mainPanel.setBorder(new EmptyBorder(5,5,5,5));
		//mainPanel.setLayout(new BorderLayout(100,100));
		//j1.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));
		
		j1=new JPanel();
		j1.setLayout(null);
		j1.setBounds(10, 5, 965, 150);
		mainPanel.add(j1);
		//FlowLayout flowLayout=(FlowLayout) j1.getLayout();
		//flowLayout.setAlignment(FlowLayout.LEFT);
		
		
		//Label
		
		l1=new JLabel("Enter employee name");
		l1.setFont(new Font("Verdana",Font.PLAIN,20));
		l1.setBounds(20,35,250,50);
		j1.add(l1);
		
		//Text Field
		t1=new JTextField();
		t1.setBounds(275, 45, 200, 30);
		t1.setFont(new Font("Verdana",Font.PLAIN,19));
		j1.add(t1);
		
		try {
			
			List<Employee> employees=null;
			String lastName=t1.getText();
			if(lastName!=null&&lastName.trim().length()>0) {
				employees=ed.getEmployee(lastName);
			}
			else {
				employees=ed.getAllEmployee();
			}
			EmployeeTableModel model=new EmployeeTableModel(employees);
			table.setModel(model);
			//table.setFont(new Font("Verdana",Font.LAYOUT_RIGHT_TO_LEFT,16));
			for(Employee temp:employees) {
				System.out.println(temp);
			}
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			//JOptionPane.showMessageDialog(SearchEmployee.this,"Eroor:"+e1,"Eroor");
		}
		
		b1=new JButton("Search");
		b1.setBounds(490,45,170,30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Verdana",Font.CENTER_BASELINE,18));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					List<Employee> employees=null;
					String lastName=t1.getText();
					if(lastName!=null&&lastName.trim().length()>0) {
						employees=ed.getEmployee(lastName);
					}
					else {
						employees=ed.getAllEmployee();
					}
					EmployeeTableModel model=new EmployeeTableModel(employees);
					table.setModel(model);
					//table.setFont(new Font("Verdana",Font.LAYOUT_RIGHT_TO_LEFT,16));
					for(Employee temp:employees) {
						System.out.println(temp);
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					//JOptionPane.showMessageDialog(SearchEmployee.this,"Eroor:"+e1,"Eroor");
				}
			}
		});
		j1.add(b1);
		
		add=new JButton("Add Employee");
		add.setBounds(10,510,180,30);
		add.setBackground(Color.BLACK);
		add.setForeground(Color.WHITE);
		add.setFont(new Font("Verdana",Font.CENTER_BASELINE,15));
		add.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				JDialog d1;
				JLabel l1,l2,l3,l4,l5,l6;
				JTextField t1,t2,t3,t4,t6;
				JButton done;
				JComboBox<?> t5;
				//EmployeeDAO e;
				try {
					d1=new JDialog(s,"Add Emoloyee");
					d1.setLayout(null);
					d1.setBounds(600, 300, 700, 400);
					
					l1=new JLabel("Employee ID");
					l1.setBounds(100, 10, 150, 30);
					l1.setFont(new Font("Verdana",Font.BOLD,17));
					
					t1=new JTextField();
					t1.setBounds(270,10,200,30);
					t1.setFont(new Font("Verdana",Font.PLAIN,17));
					
					l2=new JLabel("First Name");
					l2.setBounds(100, 50, 150, 30);
					l2.setFont(new Font("Verdana",Font.BOLD,17));
					
					t2=new JTextField();
					t2.setBounds(270,50,200,30);
					t2.setFont(new Font("Verdana",Font.PLAIN,17));
					
					
					l3=new JLabel("Last Name");
					l3.setBounds(100, 90, 150, 30);
					l3.setFont(new Font("Verdana",Font.BOLD,17));
					
					t3=new JTextField();
					t3.setBounds(270,90,200,30);
					t3.setFont(new Font("Verdana",Font.PLAIN,17));
					
					
					l4=new JLabel("Email");
					l4.setBounds(100, 130, 150, 30);
					l4.setFont(new Font("Verdana",Font.BOLD,17));
					
					t4=new JTextField();
					t4.setBounds(270,130,200,30);
					t4.setFont(new Font("Verdana",Font.PLAIN,17));
					
					l5=new JLabel("Department");
					l5.setBounds(100, 170, 150, 30);
					l5.setFont(new Font("Verdana",Font.BOLD,17));
					
					String departments[]= {"HR","Engineering","Legal"};
					t5=new JComboBox<Object>(departments);
					t5.setBounds(270,170,200,30);
					t5.setFont(new Font("Verdana",Font.PLAIN,17));

					l6=new JLabel("Salary");
					l6.setBounds(100, 210, 150, 30);
					l6.setFont(new Font("Verdana",Font.BOLD,17));
					
					t6=new JTextField();
					t6.setBounds(270,210,200,30);
					t6.setFont(new Font("Verdana",Font.PLAIN,17));
					
					done=new JButton("Done");
					done.setBounds(290,280,100,30);
					done.setFont(new Font("Verdana",Font.CENTER_BASELINE,17));
					done.setBackground(Color.BLACK);
					done.setForeground(Color.WHITE);
					d1.add(done);
					
					
					d1.add(l1);
					d1.add(l2);
					d1.add(l3);
					d1.add(l4);
					d1.add(l5);
					d1.add(l6);
					
					d1.add(t1);
					d1.add(t2);
					d1.add(t3);
					d1.add(t4);
					d1.add(t5);
					d1.add(t6);
					
					
					d1.setVisible(true);
					
					
					
					done.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							
							
							int id=Integer.parseInt(t1.getText());
							String first=t2.getText();
							String last=t3.getText();
							String email=t4.getText();
							String department=t5.getName();
							Long salary=Long.parseLong(t6.getText());
							
							Employee temp=new Employee(id,last,first,email,department,salary);
							
							try {
								//e=new EmployeeDAO();
								ed.addEmployee(temp);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							d1.setVisible(false);
							//table.repaint();
							
							((AbstractTableModel) model).fireTableDataChanged();
							JOptionPane.showMessageDialog(done, "Emoloyee Added Successfully");
						}
					});
					
					
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					//JOptionPane.showMessageDialog(SearchEmployee.this,"Eroor:"+e1,"Eroor");
				}
			}
		});
		mainPanel.add(add);
		
		
		update=new JButton("Update Employee");
		update.setBounds(380,510,180,30);
		update.setBackground(Color.BLACK);
		update.setForeground(Color.WHITE);
		update.setFont(new Font("Verdana",Font.CENTER_BASELINE,15));
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				if(table.getSelectionModel().isSelectionEmpty()) {
					JOptionPane.showMessageDialog(update, "Please select any row");
				}
				else {
				
					JDialog d1;
					JLabel l1,l2,l3,l4,l5,l6;
					JTextField t1,t2,t3,t4,t6;
					JButton done;
					JComboBox<?> t5;
					int empid;
					String last_name;
					String first_name;
					String email;
					String department;
					Long salary;
					//EmployeeDAO e;
					try {
						d1=new JDialog(s,"Update Emoloyee");
						d1.setLayout(null);
						d1.setBounds(600, 300, 700, 400);
						
						l1=new JLabel("Employee ID");
						l1.setBounds(100, 10, 150, 30);
						l1.setFont(new Font("Verdana",Font.BOLD,17));
						
						t1=new JTextField();
						t1.setBounds(270,10,200,30);
						t1.setFont(new Font("Verdana",Font.PLAIN,17));
						
						l2=new JLabel("First Name");
						l2.setBounds(100, 50, 150, 30);
						l2.setFont(new Font("Verdana",Font.BOLD,17));
						
						t2=new JTextField();
						t2.setBounds(270,50,200,30);
						t2.setFont(new Font("Verdana",Font.PLAIN,17));
						
						
						l3=new JLabel("Last Name");
						l3.setBounds(100, 90, 150, 30);
						l3.setFont(new Font("Verdana",Font.BOLD,17));
						
						t3=new JTextField();
						t3.setBounds(270,90,200,30);
						t3.setFont(new Font("Verdana",Font.PLAIN,17));
						
						
						l4=new JLabel("Email");
						l4.setBounds(100, 130, 150, 30);
						l4.setFont(new Font("Verdana",Font.BOLD,17));
						
						t4=new JTextField();
						t4.setBounds(270,130,200,30);
						t4.setFont(new Font("Verdana",Font.PLAIN,17));
						
						l5=new JLabel("Department");
						l5.setBounds(100, 170, 150, 30);
						l5.setFont(new Font("Verdana",Font.BOLD,17));
						
						String departments[]= {"HR","Engineering","Legal"};
						
						t5=new JComboBox(departments);
						t5.setBounds(270,170,200,30);
						t5.setFont(new Font("Verdana",Font.PLAIN,17));

						l6=new JLabel("Salary");
						l6.setBounds(100, 210, 150, 30);
						l6.setFont(new Font("Verdana",Font.BOLD,17));
						
						t6=new JTextField();
						t6.setBounds(270,210,200,30);
						t6.setFont(new Font("Verdana",Font.PLAIN,17));
						
						done=new JButton("Done");
						done.setBounds(290,280,100,30);
						done.setFont(new Font("Verdana",Font.CENTER_BASELINE,17));
						done.setBackground(Color.BLACK);
						done.setForeground(Color.WHITE);
						d1.add(done);
						
						
						d1.add(l1);
						d1.add(l2);
						d1.add(l3);
						d1.add(l4);
						d1.add(l5);
						d1.add(l6);
						
						d1.add(t1);
						d1.add(t2);
						d1.add(t3);
						d1.add(t4);
						d1.add(t5);
						d1.add(t6);
						
						int rowIndex=table.getSelectedRow();
						
						empid=(int)table.getValueAt(rowIndex,0);
						last_name=table.getModel().getValueAt(rowIndex,1).toString();
						first_name=table.getValueAt(rowIndex,2).toString();
						email=(String) table.getValueAt(rowIndex,3);
						department=(String) table.getValueAt(rowIndex,4);
						salary=(Long) table.getValueAt(rowIndex,5);
						
						t1.setText(String.valueOf(empid));
						t1.setEditable(false);
						t2.setText(first_name);	
						t3.setText(last_name);
						t4.setText(email);
						
						t6.setText(String.valueOf(salary));
						
						d1.setVisible(true);
						
						done.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								
								
								int id=Integer.parseInt(t1.getText());
								String first=t2.getText();
								String last=t3.getText();
								String email=t4.getText();
								String department=t5.getName();
								Long salary=Long.parseLong(t6.getText());
								
								Employee temp=new Employee(id,last,first,email,department,salary);
								
								try {
									//e=new EmployeeDAO();
									ed.updateEmployee(temp);
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								d1.setVisible(false);
								//table.repaint();
								
								((AbstractTableModel) model).fireTableDataChanged();
								JOptionPane.showMessageDialog(done, "Emoloyee Updated Successfully");
								table.repaint();
							}
						});
						
					}
					catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					//JOptionPane.showMessageDialog(SearchEmployee.this,"Eroor:"+e1,"Eroor");
					}
				}
			}
		});
		mainPanel.add(update);
		
		delete=new JButton("Delete Employee");
		delete.setBounds(760,510,180,30);
		delete.setBackground(Color.BLACK);
		delete.setForeground(Color.WHITE);
		delete.setFont(new Font("Verdana",Font.CENTER_BASELINE,15));
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if(table.getSelectionModel().isSelectionEmpty()) {
						JOptionPane.showMessageDialog(SearchEmployee.this, "Please select any row");
					}
					else{
						 int response=JOptionPane.showConfirmDialog(SearchEmployee.this,"Delete this employee?", "Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					 if(response==JOptionPane.YES_OPTION) {
						 ed.deleteEmployee((int) table.getValueAt(table.getSelectedRow(), 0));
					 }
					 else {
						 
					 }
						
					}
				}catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					//JOptionPane.showMessageDialog(SearchEmployee.this,"Eroor:"+e1,"Eroor");
				}
			}
		});
		mainPanel.add(delete);
		Border b=new LineBorder(Color.black,5);
		mainPanel.setBorder(b);
		
		
		j2=new JPanel();
		j2.setLayout(null);
		j2.setBounds(5, 155, 965, 340);
		mainPanel.add(j2);
		
		scrollPane=new JScrollPane();
		scrollPane.setBounds(5, 5, 957, 340);
		j2.add(scrollPane);
		//scrollPane.setLayout(null);
		//scrollPane.setPreferredSize(new Dimension(965,440));
		//scrollPane.setLayout(new BorderLayout());
		
		
		scrollPane.setViewportView(table);
		
		
		
		
		
		setVisible(true);
		//validate();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchEmployee se,s;
		try {
			se = new SearchEmployee();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
