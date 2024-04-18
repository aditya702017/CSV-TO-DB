package com.Csv.Main.Service;

import org.springframework.stereotype.Service;
import com.Csv.Main.Entity.Customer;
import com.Csv.Main.Repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;


@Service
public class CSVService {

	@Value("${spring.jpa.properties.hibernate.jdbc.batch_size}")
	private int batchSize;

	@Autowired
	private CustomerRepo customerRepository;

	private final String folderPath = "C:\\Users\\adity\\Videos";


	@Scheduled(fixedRate = 60000)// Scan every minute
	public void scanCsvFolderAndProcess() {
		File folder = new File(folderPath);
		File[] files = folder.listFiles((dir, name) -> name.endsWith(".csv"));
		if (files != null) {
			for (File file : files) {
				processCsvFile(file);
			}
		}
	}

	//processing csv files to db 
	private void processCsvFile(File csvFile) {

		//converting csv files to list of customers using OpenCSV
		List<Customer> customers = null;
		try {
			customers = new CsvToBeanBuilder(new FileReader(csvFile))
					.withType(Customer.class)
					.build()
					.parse();


			// Save the list of CsvData objects to the database
			System.out.println((java.time.LocalTime.now()));
			
			for (int i = 0; i < customers.size(); i += batchSize) {
				if( i+ batchSize > customers.size()){
					List<Customer> books1 = customers.subList(i, customers.size() - 1);
					customerRepository.saveAll(books1);
					break;
				}
				List<Customer> books1 = customers.subList(i, i + batchSize);
				customerRepository.saveAll(books1);
			}
			
			System.out.println((java.time.LocalTime.now()));
		}
		catch (IllegalStateException | FileNotFoundException e) {
			e.printStackTrace();
		}


	}
}



