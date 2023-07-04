package com.corptec.etl.dataManipulation;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.corptec.etl.dataManipulation.helper.CustomerDataGenerator;
import com.corptec.etl.dataManipulation.helper.GetDataFromS3;
import com.corptec.etl.dataManipulation.service.CustomerService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class DataManipulationApplication {

	 @Autowired
	 private CustomerDataGenerator customerDataGenerator;
	 @Autowired
	 private CustomerService customerService;
	 @Autowired
	 private GetDataFromS3  getDataFromS3;
	public static void main(String[] args) {
		SpringApplication.run(DataManipulationApplication.class, args);
	}

	@PostConstruct
    public void init() {
        // Call the method to generate and save data to CSV
//        customerDataGenerator.generateAndSaveDataAsCSV();
		try {
			getDataFromS3.execute();
			dumpToDb();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	
	public void dumpToDb() {
//		CustomerService customerService = context.getBean(CustomerService.class);

        // Define your batch size (e.g., 1000)
        int batchSize = 1000;
        File file = new File("customer.csv");
        // Call the method with the CSV file path and the batch size
        try {
            customerService.saveCustomersFromCsv(file.getAbsolutePath(), batchSize);
            System.out.println("Data insertion completed successfully!");
        } catch (IOException e) {
            System.err.println("Error occurred while reading the CSV file: " + e.getMessage());
        } finally {
//            context.close();
        }
	}
	
}
