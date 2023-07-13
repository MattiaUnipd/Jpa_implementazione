package com.mattia_stage.Jpa_Implementazione;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpaImplementazioneApplicationTests {
	
	@Autowired
	CustomerRepository repo;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void saveTest() {
		repo.save(new Customer("Jack", "Black", "jackblack@gmail.com"));
		repo.save(new Customer("Marie", "Black", "marieblack@gmail.com"));
		repo.save(new Customer("Jodie", "Black", "jodieblack@gmail.com"));
		repo.save(new Customer("Steph", "Jordan", "stephjordan@gmail.com"));
		repo.save(new Customer("Marie", "Jordan", "mariejordan@gmail.com"));
	}
	
	@Test
	public void findByIdTest() {
		Customer jack = new Customer((long)1,"Jack", "Black", "jackblack@gmail.com");
		assertEquals(true,jack.equals(repo.findById((long)1)));
	}
	
	@Test
	public void findByFirstNameTest()
	{
		Customer black = new Customer(2,"Marie", "Black", "marieblack@gmail.com");
		Customer jordan = new Customer(5,"Marie", "Jordan", "mariejordan@gmail.com");
		
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(black);
		customers.add(jordan);
		
		assertEquals(customers,repo.findByFirstName("Marie"));
	}
	
	@Test
	public void findByLastNameTest()
	{
		Customer jack = new Customer(1, "Jack", "Black", "jackblack@gmail.com");
		Customer marie = new Customer(2, "Marie", "Black", "marieblack@gmail.com");
		Customer jodie = new Customer(3, "Jodie", "Black", "jodieblack@gmail.com");
		
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(jack);
		customers.add(marie);
		customers.add(jodie);
		
		assertEquals(customers,repo.findByLastName("Black"));
	}
	
	@Test
	public void lastNameCountTest() {
		assertEquals(3,repo.countByLastName("Black"));
	}
	
	@Test
	public void existsByEmailTest()
	{
		assertEquals(true, repo.existsByEmail("jackblack@gmail.com"));
	}
	
	@Test
	public void mailDoesNotExistTest()
	{
		assertEquals(false, repo.existsByEmail("testemail@gmail.com"));
	}

}
