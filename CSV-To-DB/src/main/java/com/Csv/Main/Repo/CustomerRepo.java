package com.Csv.Main.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Csv.Main.Entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

}
