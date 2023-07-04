/**
 * 
 */
package com.corptec.etl.dataManipulation.entity;


import lombok.Data;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author bhanu.pratap
 *
 */
@Entity
@Table(name = "customers")
@Data
@JsonPropertyOrder({ "Customer_ID", "Name", "Surname", "Gender", "Age", "Region", "Job_Classification", "Date_Joined", "Balance" })
public class Customer {

	    @Id
//	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "customer_id")
	  private Long customerId;
	
	//  @Column(name = "name")
	  private String name;
	
	//  @Column(name = "surname")
	  private String surname;
	
	//  @Column(name = "gender")
	  private String gender;
	
	//  @Column(name = "age")
	  private int age;
	
	//  @Column(name = "region")
	  private String region;
	
	//  @Column(name = "job_classification")
	  private String jobClassification;
	
	//  @Column(name = "date_joined")
	  private Date dateJoined;
	
	//  @Column(name = "balance")
	  private double balance;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getJobClassification() {
		return jobClassification;
	}

	public void setJobClassification(String jobClassification) {
		this.jobClassification = jobClassification;
	}

	public Date getDateJoined() {
		return dateJoined;
	}

	public void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", surname=" + surname + ", gender=" + gender
				+ ", age=" + age + ", region=" + region + ", jobClassification=" + jobClassification + ", dateJoined="
				+ dateJoined + ", balance=" + balance + "]";
	}

	  
    
    
}

