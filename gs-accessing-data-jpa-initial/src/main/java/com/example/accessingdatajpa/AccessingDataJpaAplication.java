package com.example.accessingdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaAplication {

  private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaAplication.class);

  public static void main(String[] args) {
    SpringApplication.run(AccessingDataJpaAplication.class);
  }

  @Bean
  public CommandLineRunner demo(MainRepository repository) {
    return (args) -> {
      // save a few customers
    	repository.save(new Customer("Tony", "Perez"));
		repository.save( new Customer("Dante", "Miren"));
		repository.save(new Customer("Kim", "Jones"));
		repository.save(new Customer("Michael", "Klepper"));
      
      log.info("Customers found with findAll():");
      log.info("-------------------------------");
      for (Main customer : repository.findAll()) {
        log.info(customer.toString());
      }
      log.info("");

      // fetch an individual customer by ID
      Main customer = repository.findById(1L);
      log.info("Customer found with findById(1L):");
      log.info("--------------------------------");
      log.info(customer.toString());
      log.info("");

      // fetch customers by last name
      log.info("Customer found with findByLastName('Perez'):");
      log.info("--------------------------------------------");
      repository.findByLastName("Perez").forEach(perez -> {
        log.info(perez.toString());
      });
      // for (Customer bauer : repository.findByLastName("Bauer")) {
      //  log.info(bauer.toString());
      // }
      log.info("");
    };
  }

}