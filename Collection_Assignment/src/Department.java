
public class Department {
	
	private int departmentId;
	private String departmentName = null;
	private String location = null;
	
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int compareTo(Department department) {
		return departmentName.compareTo(department.departmentName);
	}
	
}
