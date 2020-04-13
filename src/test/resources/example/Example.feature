Feature: Example

  @ExampleTest
  Scenario: test

    Given I have connection with Todo.ly
    When I send a POST request to projects.json end point with the json
    """
   {
          "Content": "TEST",
          "Icon": 1
   }
    """
    Then the response code should be 200