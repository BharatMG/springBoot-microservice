package com.xworkz.demo11.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "PatientDetails")

public class HospitalDTO {
	@Id
	private Integer id;

	@NotBlank(message = "Name is not blank")
	private String patientName;
	
	@NotEmpty
	private String gender;
	
	@Min(value = 18, message = "Minimum value is 18 only")
	@Max(value = 65, message = "Maximum value is 65 only")
	private Integer age;
	
	@Max(value = 10, message = "mobile number is 10 digits only")
	private Long mobileNumber;

	public HospitalDTO() {
		// TODO Auto-generated constructor stub
	}

	public HospitalDTO(int id, String patientName, String gender, int age, Long mobileNumber) {
		super();
		this.id = id;
		this.patientName = patientName;
		this.gender = gender;
		this.age = age;
		this.mobileNumber = mobileNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "HospitalDTO [id=" + id + ", patientName=" + patientName + ", gender=" + gender + ", age=" + age
				+ ", mobileNumber=" + mobileNumber + "]";
	}
}
