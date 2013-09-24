package com.throwmeaquote.category;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="CATEGORY", catalog = "wholesomequotes", uniqueConstraints = 
	{@UniqueConstraint(columnNames = "ID")}
)
public class Category implements Serializable {
	private static final long serialVersionUID = -7628174870133912798L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long categoryId = 0L;
	
	@Column(name = "DESCRIPTION", unique = false, nullable = false, length = 100)
	private String description;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="PARENT_ID")
	private Category parent; //figure out a way to get this mapping without have to refer to the parent
	
	@OneToMany(mappedBy="parent")
	private List<Category> subCategories = new ArrayList<Category>();
	
	public Category(){}
	
	public Category(String description) {
		this.description = description;
	}
	
	public Long getId() {
		return categoryId;
	}

	public Long getParentId() {
		return parent.getId();
	}

	public void setParent(Category parent){
		this.parent = parent;
		parent.addChild(this);
	}
	
	public String getDescription(){
		return description;
	}

	public void addChild(Category child) {
		subCategories.add(child);
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public boolean contains(Category subCategory) {
		return subCategories.contains(subCategory);
	}
}
