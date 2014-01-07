Feature: Validating behavior of the author business object
	
Scenario: Save new author
	Given an instance of AuthorBo
	When I save a new author on AuthorBo
	Then the save method will be called on AuthorDao 1 time

Scenario: Modify author
	Given an instance of AuthorBo
	When I save a new author on AuthorBo
	And I modify the author description
	Then the save method will be called on AuthorDao 2 times
	
Scenario: Delete author
	Given an instance of AuthorBo
	When I save a new author on AuthorBo
	And then delete the author
	Then the delete method will be called on AuthorDao 1 time
	