
public class Employee {
	int empid;
	String last_name;
	String first_name;
	String email;
	String department;
	Long salary;
	
	Employee(int empid,String last_name,String first_name,String email,String department,Long salary){
		super();
		this.empid=empid;
		this.last_name=last_name;
		this.first_name=first_name;
		this.email=email;
		this.department=department;
		this.salary=salary;
	}
	public String toString() {
		return empid+" "+last_name+" "+first_name+" "+email+" "+department+" "+salary;
	}
	int getID(){
		return empid;
	}
	String get_last_name() {
		return last_name;
	}
	String get_first_name() {
		return first_name;
	}
	String get_email() {
		return email;
	}
	String department() {
		return department;
	}
	Long salary() {
		return salary;
	}
}
