package com.example.ufficio.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="employees")
public class Employees {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "employeeNumber")  
  private Integer employeeNumber; 

  
  @Column(name= "lastName")
  private String lastName;

  @Column(name= "firstName")
  private String firstName;

  @Column(name= "extension")
  private String extension;

  @Column(name= "email")
  private String email;


  @Column(name= "officeCode")
  private Integer officeCode;

  @Column(name= "reportsTo")
  private Integer reportsTo;

  @Column(name= "jobTitle")
  private String jobTitle;

  public Integer getEmployeeNumber() {
    return employeeNumber;
  }

  public void setEmployeeNumber(Integer employeeNumber) {
    this.employeeNumber = employeeNumber;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getExtension() {
    return extension;
  }

  public void setExtension(String extension) {
    this.extension = extension;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getOfficeCode() {
    return officeCode;
  }

  public void setOfficeCode(Integer officeCode) {
    this.officeCode = officeCode;
  }

  public Integer getReportsTo() {
    return reportsTo;
  }

  public void setReportsTo(Integer reportsTo) {
    this.reportsTo = reportsTo;
  }

  public String getJobTitle() {
    return jobTitle;
  }

  public void setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
  }






}
