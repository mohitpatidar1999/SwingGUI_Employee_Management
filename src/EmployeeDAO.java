import java.util.*;
import java.util.Properties;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.sql.*;
public class EmployeeDAO {
	EmployeeDAO dao;
	Connection con=null;
	EmployeeDAO() throws Exception{
		Properties props=new Properties();
		props.load(new FileInputStream("demoproperties.txt"));
		String dburl=props.getProperty("dburl");
		String user=props.getProperty("root");
		String password=props.getProperty("password");
		con=DriverManager.getConnection(dburl,"root",password);
		System.out.println("Connected successfully to "+dburl);
	}
	
	public List<Employee> getAllEmployee() throws SQLException{
		List<Employee> list=new ArrayList<>();
		
		Statement st=null;
		ResultSet rs=null;
		try {
			st = con.createStatement();
			rs=st.executeQuery("select * from employee order by empid");
			
			while(rs.next()) {
				Employee temp=convertRowToEmployee(rs);
				//System.out.println(temp.department);
				list.add(temp);
				
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		st.close();
		//rs.close();
		return null;
			
	}
	
	public List<Employee> getEmployee(String lastname) throws SQLException{
		List<Employee> list=new ArrayList<>();
		
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			lastname+="%";
			st = con.prepareStatement("select * from employee where last_name like ? order by empid");
			st.setString(1, lastname);
			rs=st.executeQuery();
			
			while(rs.next()) {
				Employee temp=convertRowToEmployee(rs);
				list.add(temp);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
		st.close();
		rs.close();
		}
		return null;
		
	}
	public void addEmployee(Employee theEmployee) throws SQLException {
		PreparedStatement st=null;
				try {
					st=con.prepareStatement("insert into employee(empid,last_name,first_name,email,department,salary) values(?,?,?,?,?,?)");
					st.setString(5, theEmployee.department());
					st.setString(2, theEmployee.get_last_name());
					st.setString(3, theEmployee.get_first_name());
					st.setString(4, theEmployee.get_email());
					st.setLong(6, theEmployee.salary());
					st.setInt(1, theEmployee.getID());
					st.executeUpdate();
				}
				finally {
					st.close();
				}
	}
	
	public void updateEmployee(Employee theEmployee) throws SQLException {
		PreparedStatement st=null;
				try {
					st=con.prepareStatement("update employee set first_name=?,last_name=?,email=?,department=?,salary=? where empid=?");
					st.setString(1, theEmployee.get_first_name());
					st.setString(2, theEmployee.get_last_name());
					st.setString(3, theEmployee.get_email());
					st.setString(4, theEmployee.department());
					st.setLong(5, theEmployee.salary());
					st.setInt(6, theEmployee.getID());
					st.executeUpdate();
				}
				finally {
					st.close();
				}
	}
	
	public void deleteEmployee(int employeeid) throws SQLException {
		PreparedStatement st=null;
		try {
			st=con.prepareStatement("delete from employee where empid=?");
			st.setInt(1, employeeid);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			st.close();
		}
		
	}
	Employee convertRowToEmployee(ResultSet r) {
		int empid;
		String last_name;
		String first_name;
		String email;
		String department;
		Long salary;
		
		
		try {
			empid=r.getInt("empid");
			last_name=r.getString("last_name");
			first_name=r.getString("first_name");
			email=r.getString("email");
			department=r.getString("department");
			salary=r.getLong("salary");
			Employee e=new Employee(empid,last_name,first_name,email,department,salary);
			return e;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}
	public static void main(String args[]) throws Exception {
		EmployeeDAO dao=new EmployeeDAO();
		System.out.println(dao.getEmployee("patidar"));
	}
}
