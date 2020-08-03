import java.util.Comparator;

public class Employee {
	
	private String firstName = null;
	private String lastName = null;
	private String salary = null;
	private String dateOfJoining = null;
	private Department department = null;
	private Address Address = null;
	private String employeeId = null;
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Address getAddress() {
		return Address;
	}
	public void setAddress(Address address) {
		Address = address;
	}
	
	public static Comparator<Employee> COMPARE_BY_SALARY = new Comparator<Employee>() {
        public int compare(Employee one, Employee other) {
            return one.salary.compareTo(other.salary);
        }
    };
    
    public static Comparator<Employee> COMPARE_BY_LAST_NAME = new Comparator<Employee>() {
        public int compare(Employee one, Employee other) {
            return one.lastName.compareTo(other.lastName);
        }
    };
    
    public static Comparator<Employee> COMPARE_BY_FIRST_NAME = new Comparator<Employee>() {
        public int compare(Employee one, Employee other) {
            return one.firstName.compareTo(other.firstName);
        }
    };
    
    public static Comparator<Employee> COMPARE_BY_EMPLOYEE_ID = new Comparator<Employee>() {
        public int compare(Employee one, Employee other) {
            return one.employeeId.compareTo(other.employeeId);
        }
    };

}
