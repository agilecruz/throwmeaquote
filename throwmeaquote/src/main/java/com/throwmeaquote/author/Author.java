package com.throwmeaquote.author;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "AUTHOR", catalog = "wholesomequotes", uniqueConstraints = { @UniqueConstraint(columnNames = "ID") })
public class Author {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long authorId = 0L;
	
	@Column(name = "FIRSTNAME", unique = false, nullable = false, length = 100)
	private String firstName;
	
	@Column(name = "LASTNAME", unique = false, nullable = false, length = 100)
	private String lastName;
	
	public Long getId() {
		return authorId;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
}
