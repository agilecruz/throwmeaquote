Feature: Category administration
	In order to create categories for the user to select
	As a site administrator, 
	I want to be able to save and edit categories

Scenario: Save new category
	When I save a new category with a description of "Varmint Hunters"
	Then the category should have an id greater than 0
	And the category should have a description of "Varmint Hunters"

Scenario: Modify category
	Given a new category with a description of "How to trim chicken beaks"
	When I modify the category to have a description of "How To"
	Then the category should have a description of "How To"
	
Scenario: Delete category
	When I save a new category with a description of "Wabba Wabba"
	And I delete the category
	Then the category no longer exists
	
Scenario: Saving a sub-category
	When I save a new category with a description of "How To"
	And I add a sub-category with a description of "Trim Chicken Beaks"
	Then the category should contain the sub-category
	