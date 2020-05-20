package com.example.accessingdatajpa;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MainRepository extends CrudRepository<Main, Long> {
	
	List<Main> findByLastName(String lastName);

	  Main findById(long id);

	void save(Customer customer);

}
