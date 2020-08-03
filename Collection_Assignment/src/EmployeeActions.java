import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class EmployeeActions {
	
	static ArrayList<Employee> employeeList = new ArrayList<Employee>();
	static ArrayList<Department> departmentList = new ArrayList<Department>();
	static ArrayList<Address> addressList = new ArrayList<Address>();

	public static void main (String args[]) throws IOException{
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		
		while (true){
			
			System.out.println("Enter your choice of operation:");
			System.out.println ("1. Save Unique Emloyee");
			System.out.println("2. Sort Employee");
			System.out.println("3. Exit");
			
			int ch = Integer.parseInt(br.readLine());
			switch (ch){
			
			case 1: saveUniqueEmployee(); break;
			case 2: System.out.println("Enter your choice:");
					System.out.println("a. By EmployeeId \n"
									 + "b. By FirstName \n"
									 + "c. By LastName \n"
									 + "d. By Salary \n"
									 + "e. By Address \n"
									 + "f. By Department");
					String ch1 = br.readLine();
					switch (ch1){
					
					case "a": sortByEmployeeId(); break;
					case "b": sortByFirstName(); break;
					case "c": sortByLastName(); break;
					case "d": sortbySalary(); break;
					case "e": sortByAddress(); break;
					case "f": sortByDepartment(); break;
					
					default: System.out.println("Invalid Input!!!");
					}
					break;
				
			case 3: System.exit(0);
			
			default: System.out.println("Invalid Input!!!");		
			}
		}
		
		
	}

	private static void sortByDepartment() {
		Collections.sort(employeeList, new Comparator<Employee>() {
		    public int compare(Employee one, Employee other) {
		        return one.getDepartment().compareTo(other.getDepartment());
		    }
		}); 
	}

	private static void sortByAddress() {
		Collections.sort(employeeList, new Comparator<Employee>() {
		    public int compare(Employee one, Employee other) {
		        return one.getAddress().compareTo(other.getAddress());
		    }
		});
	}

	private static void sortbySalary() {
		Collections.sort(employeeList, Employee.COMPARE_BY_SALARY);
	}

	private static void sortByLastName() {
		Collections.sort(employeeList, Employee.COMPARE_BY_LAST_NAME);
	}

	private static void sortByFirstName() {
		Collections.sort(employeeList, Employee.COMPARE_BY_FIRST_NAME);
	}

	private static void sortByEmployeeId() {
		Collections.sort(employeeList, Employee.COMPARE_BY_EMPLOYEE_ID);	
	}

	private static void saveUniqueEmployee() throws IOException{
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		Employee emp = new Employee();
		Address add = new Address();
		Department dep = new Department();
		int departmentId = 1;
		int addressId = 1;
		int countLetter = 0;
		int countDigits = 0;
		
		System.out.println("Enter employee details:");
		System.out.println("Enter EmployeeId:");
		String employeeId = br.readLine();
		
		if (employeeId.length() == 8 ){
			for (int i = 0; i < employeeId.length(); i++) {
				   if (Character.isLetter(employeeId.charAt(i)))
				   countLetter++;
				   
				   if (Character.isDigit(employeeId.charAt(i)))
				        countDigits++;
				}
			if (countLetter == 2 && countDigits == 5){
				emp.setEmployeeId(employeeId);
			}
		}
		else{
			System.out.println("Please enter valid EmployeeId");
		}
		countLetter = 0;
		
		System.out.println("Enter FirstName:");
		String firstName = br.readLine();
		
		for (int i = 0; i < firstName.length(); i++) {
			   if (Character.isLetter(firstName.charAt(i)))
			   countLetter++;
		}
		if (countLetter == firstName.length())
			emp.setFirstName(firstName);
		else
			System.out.println("Please Enter valid First Name");
		
		countLetter = 0;
		
		System.out.println("Enter LastName:");
		String lastName = br.readLine();
		
		for (int i = 0; i < lastName.length(); i++) {
			   if (Character.isLetter(lastName.charAt(i)))
			   countLetter++;
		}
		if (countLetter == lastName.length())
			emp.setLastName(lastName);
		else
			System.out.println("Please Enter valid Last Name");
		countLetter = 0;
		
		System.out.println("Enter Salary:");
		String salary = br.readLine();
		
		if ( Integer.parseInt(salary) >= 20000 && Integer.parseInt(salary) <= 500000)
			emp.setSalary(salary);
		else
			System.out.println("Please Enter valid Salary");
		
		System.out.println("Enter Date of Joining:");
		String dateOfJoining = br.readLine();
		
		if (validateDate(dateOfJoining))
			emp.setDateOfJoining(dateOfJoining);
		else
			System.out.println("Please Enter valid Date");
		
//		System.out.println("Enter DepartmentId:");
//		String departmentId = br.readLine();
		System.out.println("Enter DepartmentName:");
		String departmentName = br.readLine();
		System.out.println("Enter DepartmentLocation:");
		String location = br.readLine();
//		System.out.println("Enter AddressId:");
//		String addressId = br.readLine();
		System.out.println("Enter AddressLine1:");
		String addressLine1 = br.readLine();
		System.out.println("Enter City:");
		String city = br.readLine();
		System.out.println("Enter State:");
		String state = br.readLine();
		
		add.setAddressId(addressId++);
		add.setAddressLine1(addressLine1);
		add.setCity(city);
		add.setState(state);
		emp.setAddress(add);
		addressList.add(add);
		
		dep.setDepartmentId(departmentId++);
		dep.setDepartmentName(departmentName);
		dep.setLocation(location);
		emp.setDepartment(dep);
		departmentList.add(dep);
		
		employeeList.add(emp);
	}
	
	@SuppressWarnings("deprecation")
	public static boolean validateDate(String dateOfJoining){
		Date enteredDate=null;
	    try
	    {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    enteredDate = sdf.parse(dateOfJoining);
	    }catch (Exception ex)
	    {
	        System.out.println ("Enter date in DD/MM/YYYY format");
	    }
	    Date currentDate = new Date();      
	    if(enteredDate.after(currentDate) || enteredDate.getDate() == currentDate.getDate()){
	        return true;
	    }else
	    	return false;
	}
}
