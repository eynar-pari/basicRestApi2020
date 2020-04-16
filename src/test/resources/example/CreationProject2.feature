Feature: Projects

  # comentarios

  Background: comun
    Given I have connection with Todo.ly

  @Regression @SmokeTest
  Scenario: Create Project

    When I send a POST request to projects.json end point with the json
    """
    {
      "Content":"EynarBack",
      "Icon":"1"
    }
    """
    Then the response code should be 200
    And I expected the EynarBack is displayed in json response


  @Regression @SmokeTest
  Scenario: Create Project

    When I send a POST request to projects.json end point with the json
    """
    {
      "Content":"EynarBackG",
      "Icon":"1"
    }
    """
    Then the response code should be 200
    And I expected the EynarBackG is displayed in json response




