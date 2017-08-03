// This is the entity class that maps to MySQL (ORM)

package patient.info.office.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="patients")
public class Patient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="patient_id")
	private int patientID;
	
	@Column(name="first_name")
	@NotEmpty(message="is required")
	private String firstName;

	@Column(name="last_name")	
	@NotEmpty(message="is required")
	private String lastName;
	
	@Column(name="address")
	@NotEmpty(message="is required")
	private String address;
	
	@Column(name="city")
	@NotEmpty(message="is required")
	private String city;
	
	@NotEmpty(message="is required")
	@Size(min=2, max=2, message="Enter only 2 characters")
	@Column(name="state")
	private String state;
	
	@Column(name="zip")
	private String zip;
	
	@Column(name="phone")	
	private String phone;
	
	@Column(name="email")
	private String email;
	
	@Column(name="dob")
	private Date dob;
	
	@Column(name="reason")
	private String reason;
	
	@Column(name="allergies")
	private String allergies;
	
	@Column(name="emp_status")
	private String empStatus;

	@Column(name="visit_date")	
	private Date visitDate;
	
	public Patient(){		
	}
	
	public int getPatientID() {
		return patientID;
	}

	public void setPatientID(int patientID) {
		this.patientID = patientID;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public String getEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	@Override
	public String toString() {
		return "Patient [patientID=" + patientID + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + ", city=" + city + ", state=" + state + ", zip=" + zip + ", phone=" + phone + ", email="
				+ email + ", dob=" + dob + ", reason=" + reason + ", allergies=" + allergies + ", empStatus="
				+ empStatus + ", visitDate=" + visitDate + "]";
	}
}
