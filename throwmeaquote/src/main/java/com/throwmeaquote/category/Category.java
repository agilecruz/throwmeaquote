package com.throwmeaquote.category;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="CATEGORY", catalog = "wholesomequotes", uniqueConstraints = 
	{@UniqueConstraint(columnNames = "ID")}
)
public class Category {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id = 0L;
	//private List<Category> subCategories = new ArrayList<Category>();
	
	@Column(name = "DESCRIPTION", unique = false, nullable = false, length = 100)
	private String description;
	
	@Column(name="PARENT_ID", unique=false, nullable=false)
	private Long parentId = 0L;
	
	public Category(){}
	
	public Category(String description) {
		this.description = description;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return id;
	}

	public void setParentId(Long id) {
		this.id = id;
	}

	
	public String getDescription(){
		return description;
	}

	public void setDescription(String description){
		this.description = description;
	}
	
	

	/*public boolean contains(Category subCategory) {
		return subCategories.contains(subCategory);
	}

	public void addChild(Category subCategory) {
		subCategories.add(subCategory);
	}*/
}
