package com.throwmeaquote.category;

import org.hibernate.Session;
import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.throwmeaquote.category.bo.CategoryBo;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CategoryAdministrationSteps {
	Category category;
	Category subCategory;
	CategoryBo categoryBo;
	ApplicationContext appContext = new ClassPathXmlApplicationContext(
			"spring/config/BeanLocations.xml");
	Session session;

	@Before
	public void setContext() {
		categoryBo = (CategoryBo) appContext.getBean("categoryBo");
	}

	@When("^I save a new category with a description of \"([^\"]*)\"$")
	public void I_save_a_new_category_with_a_description_of(String description)
			throws Throwable {
		category = new Category(description);

		categoryBo.save(category);
	}

	@Then("^the category should have an id greater than (\\d+)$")
	@Transactional
	public void the_category_should_have_an_id_greater_than(Long id)
			throws Throwable {
		Category retrievedCategory = categoryBo.findById(category.getId());
		Assert.assertTrue(retrievedCategory.getId() > id);
	}

	@Then("^the category should have a description of \"([^\"]*)\"$")
	public void the_category_should_have_a_description_of(String description)
			throws Throwable {
		Category retrievedCategory = categoryBo.findById(category.getId());
		Assert.assertEquals(description, retrievedCategory.getDescription());
	}

	@Given("^a new category with a description of \"([^\"]*)\"$")
	public void a_new_category_with_a_description_of(String description)
			throws Throwable {
		category = new Category(description);

		categoryBo.save(category);
	}

	@When("^I modify the category to have a description of \"([^\"]*)\"$")
	public void I_modify_the_category_to_have_a_description_of(
			String description) throws Throwable {
		category.setDescription(description);
		categoryBo.save(category);
	}

	@When("^I delete the category$")
	public void I_delete_the_category() throws Throwable {
		Long id = category.getId();
		Assert.assertTrue(id > 0);
		categoryBo.delete(category);
		Category deletedCategory = categoryBo.findById(id);
		Assert.assertNull(deletedCategory);
	}

	@Then("^the category no longer exists$")
	public void the_category_no_longer_exists() throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@When("^I add a sub-category with a description of \"([^\"]*)\"$")
	public void I_add_a_sub_category_with_a_description_of(String description)
			throws Throwable {
		subCategory = new Category(description);
		category.addChild(subCategory);
		categoryBo.save(category);
	}

	@Then("^the category should contain the sub-category$")
	public void the_category_should_contain_the_sub_category() throws Throwable {
		
		Assert.assertTrue(category.contains(subCategory));
		Assert.assertEquals(category.getId(), subCategory.getParentId());
		
	}

	@After
	public void destroyContext() {

	}
}
