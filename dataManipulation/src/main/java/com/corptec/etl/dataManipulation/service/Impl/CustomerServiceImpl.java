package com.corptec.etl.dataManipulation.service.Impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corptec.etl.dataManipulation.Repository.CustomerRepository;
import com.corptec.etl.dataManipulation.entity.Customer;
import com.corptec.etl.dataManipulation.service.CustomerService;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
    private EntityManager entityManager;
    
		@Override
		@Transactional
	    public void saveCustomersFromCsv(String csvFilePath, int batchSize) throws IOException {
	        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
	        	
	        	// Skip the header line
	            reader.readLine();
	            String line;
	            List<Customer> customerBatch = new ArrayList<>();

	            while ((line = reader.readLine()) != null) {
	                String[] fields = line.split(",");
	                System.out.println("id is : " + fields[0]);
	                System.out.println( Long.parseLong(fields[0]));
	                Customer customer = new Customer();
	                customer.setCustomerId(Long.parseLong(fields[0]));
	                customer.setName(fields[1]);
	                customer.setSurname(fields[2]);
	                customer.setGender(fields[3]);
	                customer.setAge(Integer.parseInt(fields[4]));
	                customer.setRegion(fields[5]);
	                customer.setJobClassification(fields[6]);
	                customer.setDateJoined(new Date(fields[7]));
	                customer.setBalance(Double.parseDouble(fields[8]));

	                customerBatch.add(customer);

	                if (customerBatch.size() % batchSize == 0) {
	                    saveBatch(customerBatch);
	                    customerBatch.clear();
	                }
	            }

	            // Save the remaining records (less than batchSize)
	            if (!customerBatch.isEmpty()) {
	                saveBatch(customerBatch);
	            }
	        }
		}
		
		@Transactional
	    private void saveBatch(List<Customer> customerBatch) {
	        customerRepository.saveAll(customerBatch);
	    }
		
//	    @Transactional
//	    private void saveBatch(List<Customer> customerBatch) {
//	        for (Customer customer : customerBatch) {
//	            entityManager.persist(customer);
//	        }
//	        entityManager.flush();
//	        entityManager.clear();
//
//	}

}
