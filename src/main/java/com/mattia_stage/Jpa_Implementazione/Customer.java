package com.mattia_stage.Jpa_Implementazione;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String firstName;
	private String lastName;
	private String email;
	
	protected Customer() {}
	
	public Customer(String firstName, String lastName, String email)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	//creato a scopo di test
	public Customer(long id, String firstName, String lastName, String email)
	{
		this.id=id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	@Override 
	public String toString()
	{
		return String.format(
				"Customer[id=%d, firstName=%s, lastName=%s, email=%s", id, 				firstName, lastName, email);
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(o==this) return true;
		if (o==null || !(o instanceof Customer)) return false;
		
		Customer compare = (Customer) o;
		return (this.id == compare.id && this.firstName.equals(compare.firstName) && this.lastName.equals(compare.lastName)&& this.email.equals(compare.email));
	}

	public Long getId() {
		return id;
	}


	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public String getEmail() {
		return email;
	}
	
}
