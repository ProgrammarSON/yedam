package TEST_DB;

import java.util.Formatter;

public class EmployeeDTO {
	private String employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String jobId;
	private String hireDate;
	
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
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
	
	@Override
	public String toString() {
		Formatter fm = new Formatter();
		String result = fm.format("%6s\t %-10s\t %-10s\t %-10s\t %-10s\t %-10s\t", 
				employeeId,firstName,lastName,email,jobId,hireDate).toString();
		
	//	return "employeeDTO [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
	//			+ ", email=" + email + "]";
		return result;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
