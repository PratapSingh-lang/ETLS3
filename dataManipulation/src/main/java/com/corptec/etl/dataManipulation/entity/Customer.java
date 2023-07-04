/**
 * 
 */
package com.corptec.etl.dataManipulation.entity;


import lombok.Data;

import java.util.Date;

/**
 * @author bhanu.pratap
 *
 */
//@Entity
//@Table(name = "customers")
@Data
public class Customer {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "customer_id")
    private Long customerId;

//    @Column(name = "name")
    private String name;

//    @Column(name = "surname")
    private String surname;

//    @Column(name = "gender")
    private String gender;

//    @Column(name = "age")
    private int age;

//    @Column(name = "region")
    private String region;

//    @Column(name = "job_classification")
    private String jobClassification;

//    @Column(name = "date_joined")
    private Date dateJoined;

//    @Column(name = "balance")
    private double balance;
}

