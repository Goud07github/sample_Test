package in.prashuIT.Entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
public class Employee {
	
	 @Id
	 @NotBlank(message = "Employee ID is required")
	 @Pattern(regexp = "E\\d{3}", message = "Employee ID must follow the format 'E123'")
	 private String employeeId;
	 
	 @NotBlank(message = "First name is required")
	 private String firstName;
	 
	 @NotBlank(message = "Last name is required")
	 private String lastName;
	 
	 @NotBlank(message = "Email is required")
	 @Email(message = "Invalid email format")
	 private String email;
	
	 @ElementCollection
	 @Size(min = 1, message = "At least one phone number is required")
	 private List<@Pattern(regexp = "\\d{10}", message = "Phone numbers must be 10 digits") String> phoneNumbers;
	 
	 @NotNull(message = "Date of joining is required")
	  private LocalDate doj;
	 
	 @NotNull(message = "Salary is required")
	 @Positive(message = "Salary must be positive")
	 private Double salary;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	
}
