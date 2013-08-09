$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("com/throwmeaquote/category/CategoryDao.feature");
formatter.feature({
  "id": "category-administration",
  "description": "In order to create categories for the user to select\nAs a site administrator, \nI want to be able to save and edit categories",
  "name": "Category administration",
  "keyword": "Feature",
  "line": 1
});
formatter.scenario({
  "id": "category-administration;save-new-category",
  "description": "",
  "name": "Save new category",
  "keyword": "Scenario",
  "line": 6,
  "type": "scenario"
});
formatter.step({
  "name": "I save a new category with a description of \"Varmint Hunters\"",
  "keyword": "When ",
  "line": 7
});
formatter.match({
  "arguments": [
    {
      "val": "Varmint Hunters",
      "offset": 45
    }
  ],
  "location": "CategoryDaoSteps.I_save_a_new_category_with_a_description_of(String)"
});
formatter.result({
  "duration": 81682954,
  "status": "passed"
});
formatter.step({
  "name": "the category should have an id greater than 0",
  "keyword": "Then ",
  "line": 8
});
});