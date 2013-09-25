Feature: Validating behavior of the category business object
	
Scenario: Save new category
	Given an instance of CategoryBo
	When I save a new category on CategoryBo
	Then the save method will be called on CategoryDao 1 time

Scenario: Modify category
	Given an instance of CategoryBo
	When I save a new category on CategoryBo
	And I modify the category description
	Then the save method will be called on CategoryDao 2 times
	
Scenario: Delete category
	Given an instance of CategoryBo
	When I save a new category on CategoryBo
	And then delete the category
	Then the delete method will be called on CategoryDao 1 time
	