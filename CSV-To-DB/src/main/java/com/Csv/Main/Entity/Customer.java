package com.Csv.Main.Entity;

import com.opencsv.bean.CsvBindByPosition;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGen")
    @SequenceGenerator(name = "seqGen", sequenceName = "seq", initialValue = 1)
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@CsvBindByPosition(position = 1)
	private String customerId;
	
	@CsvBindByPosition(position = 2)
	private String firstName;
	
	@CsvBindByPosition(position = 3)
	private String company;
	
	@CsvBindByPosition(position = 4)
	private String city;
	
	@CsvBindByPosition(position = 5)
	private String country;
	
	@CsvBindByPosition(position = 6)
	private String phone1;
	
	@CsvBindByPosition(position = 7)
	private String phone2;
	
	@CsvBindByPosition(position = 8)
	private String email;
	
	@CsvBindByPosition(position = 9)
	private String subscriptionDate;
	
	@CsvBindByPosition(position = 10)
	private String website;
	
	
}
