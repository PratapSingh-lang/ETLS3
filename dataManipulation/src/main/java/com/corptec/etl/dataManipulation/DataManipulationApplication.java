package com.corptec.etl.dataManipulation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.corptec.etl.dataManipulation.helper.CustomerDataGenerator;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class DataManipulationApplication {

	 @Autowired
	 private CustomerDataGenerator customerDataGenerator;
	 
	public static void main(String[] args) {
		SpringApplication.run(DataManipulationApplication.class, args);
	}

	@PostConstruct
    public void init() {
        // Call the method to generate and save data to CSV
        customerDataGenerator.generateAndSaveDataAsCSV();
    }
}
