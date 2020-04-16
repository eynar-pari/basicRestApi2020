Feature: Example 1

  @ExampleTest
  Scenario: test

    Given I have connection with Todo.ly
    When I send a POST request to projects.json end point with the json
    """
   {
          "Content": "CUCUMBER2",
          "Icon": 1
   }
    """
    Then the response code should be 200
    And I expected the CUCUMBER2 is displayed in json response

    And I save the attribute Id in the variable : ID_PROYECTO

    When I send a PUT request to projects/ID_PROYECTO.json end point with the json
    """
    {
          "Content": "CUCUMBER2 UPDATE",
          "Icon": 1
    }
    """
    Then the response code should be 200
    And I expected the CUCUMBER2 UPDATE is displayed in json response
