package com.throwmeaquote.category.integration.tests;

import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.throwmeaquote.category.Category;
import com.throwmeaquote.category.bo.CategoryBo;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@ContextConfiguration
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback = true)
@Transactional
public class CategoryAdministrationBoSteps {
	Category category;
	Category subCategory;
	CategoryBo categoryBo;
	ApplicationContext appContext = new ClassPathXmlApplicationContext(
			"spring/config/BeanLocations.xml");
	Long categoryIdToDelete;

	@Before
	public void setContext() {
		categoryBo = (CategoryBo) appContext.getBean("categoryBo");
	}

	@Rollback(true)
	@When("^I save a new category with a description of \"([^\"]*)\"$")
	public void I_save_a_new_category_with_a_description_of(String description)
			throws Throwable {
		category = new Category(description);

		categoryBo.save(category);
	}

	@Then("^the category should have an id greater than (\\d+)$")
	public void the_category_should_have_an_id_greater_than(Long id)
			throws Throwable {
		Long idToFind = category.getId();
		Category retrievedCategory = categoryBo.findById(idToFind);
		Assert.assertTrue(retrievedCategory.getId() > id);
	}

	@Then("^the category should have a description of \"([^\"]*)\"$")
	public void the_category_should_have_a_description_of(String description)
			throws Throwable {
		Long id = category.getId();
		Category retrievedCategory = categoryBo.findById(id);
		Assert.assertEquals(description, retrievedCategory.getDescription());
	}

	@Rollback(true)
	@Given("^a new category with a description of \"([^\"]*)\"$")
	public void a_new_category_with_a_description_of(String description)
			throws Throwable {
		category = new Category(description);

		categoryBo.save(category);
	}

	@Rollback(true)
	@When("^I modify the category to have a description of \"([^\"]*)\"$")
	public void I_modify_the_category_to_have_a_description_of(
			String description) throws Throwable {
		category.setDescription(description);
		categoryBo.save(category);
	}

	@When("^I delete the category$")
	public void I_delete_the_category() throws Throwable {
		categoryIdToDelete = category.getId();
		Assert.assertTrue(categoryIdToDelete > 0);
		categoryBo.delete(category);
	}

	@Then("^the category no longer exists$")
	public void the_category_no_longer_exists() throws Throwable {
		Category deletedCategory = categoryBo.findById(categoryIdToDelete);
		Assert.assertNull(deletedCategory);
	}

	@Rollback(true)
	@When("^I add a sub-category with a description of \"([^\"]*)\"$")
	public void I_add_a_sub_category_with_a_description_of(String description)
			throws Throwable {
		subCategory = new Category(description);

		subCategory.setParent(category);

		categoryBo.save(subCategory);
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
