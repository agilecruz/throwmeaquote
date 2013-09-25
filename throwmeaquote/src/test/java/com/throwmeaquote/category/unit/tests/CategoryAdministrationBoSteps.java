package com.throwmeaquote.category.unit.tests;

import org.mockito.Mockito;

import com.throwmeaquote.category.Category;
import com.throwmeaquote.category.bo.CategoryBo;
import com.throwmeaquote.category.bo.impl.CategoryBoImpl;
import com.throwmeaquote.category.dao.CategoryDao;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CategoryAdministrationBoSteps {
	CategoryBo categoryBo;
	CategoryDao categoryDao;
	Category category = new Category("It don\'t matter much");

	@Before
	public void setContext() {
		categoryDao = Mockito.mock(CategoryDao.class);
		categoryBo = new CategoryBoImpl(categoryDao);
	}
	
	@Given("^an instance of CategoryBo$")
	public void given_an_instance_of_CategoryBo()
			throws Throwable {
		//this was created in the @Before method
	}
	
	@When("^I save a new category on CategoryBo$")
	public void when_i_save_a_new_category()
			throws Throwable {
		categoryBo.save(category);
	}
	
	@When("^I modify the category description$")
	public void when_i_modify_the_category_description(){
		category.setDescription("whatevs man");
		categoryBo.save(category);
	}
	
	@When("^then delete the category$")
	public void then_delete_the_category() throws Throwable {
	    categoryBo.delete(category);
	}

	@Then("^the delete method will be called on CategoryDao (\\d+) times?$")
	public void the_delete_method_will_be_called_on_CategoryDao_time(int times) throws Throwable {
		Mockito.verify(categoryDao).delete(Mockito.any(Category.class));
		Mockito.times(times);
	}
	
	@Then("^the save method will be called on CategoryDao (\\d+) times?$")
	public void then_the_save_method_will_be_called(int numTimes){
		Mockito.verify(categoryDao, Mockito.times(numTimes)).save(Mockito.any(Category.class));
	}
}
