package com.corptec.etl.dataManipulation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.corptec.etl.dataManipulation.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
