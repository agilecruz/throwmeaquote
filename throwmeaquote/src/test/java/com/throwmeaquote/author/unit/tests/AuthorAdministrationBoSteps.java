package com.throwmeaquote.author.unit.tests;

import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.throwmeaquote.author.Author;
import com.throwmeaquote.author.bo.AuthorBo;
import com.throwmeaquote.author.bo.impl.AuthorBoImpl;
import com.throwmeaquote.author.dao.AuthorDao;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@ContextConfiguration
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback = true)
@Transactional
public class AuthorAdministrationBoSteps {
	AuthorBo authorBo;
	AuthorDao authorDao;
	Author author;

	@Before
	public void setContext() {
		authorDao = Mockito.mock(AuthorDao.class);
		authorBo = new AuthorBoImpl(authorDao);
		author = createdUhAuthor();
	}
	
	private Author createdUhAuthor() {
		Author author = new Author();
		author.setFirstName("Bubba");
		author.setLastName("Jones");
		
		return author;
	}

	@Given("^an instance of AuthorBo$")
	public void an_instance_of_AuthorBo() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@When("^I save a new author on AuthorBo$")
	public void I_save_a_new_author_on_AuthorBo() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Then("^the save method will be called on AuthorDao (\\d+) time$")
	public void the_save_method_will_be_called_on_AuthorDao_time(int arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@When("^I modify the author description$")
	public void I_modify_the_author_description() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Then("^the save method will be called on AuthorDao (\\d+) times$")
	public void the_save_method_will_be_called_on_AuthorDao_times(int arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@When("^then delete the author$")
	public void then_delete_the_author() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Then("^the delete method will be called on AuthorDao (\\d+) time$")
	public void the_delete_method_will_be_called_on_AuthorDao_time(int arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

}
