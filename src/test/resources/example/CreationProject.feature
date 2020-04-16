Feature: Projects


  # comentarios

  @Regression @SmokeTest
  Scenario Outline: Create Project

    Given I have connection with Todo.ly
    When I send a POST request to projects.json end point with the json
    """
    {
      "Content":"<nombreProject>",
      "Icon":"<numeroIcon>"
    }
    """
    Then the response code should be 200
    And I expected the <nombreProject> is displayed in json response

    Examples:
    # 1ra fila nombres de variables
    # para usar las variables , debemos utilizarlos entre simbolos de <> en el test
    | nombreProject   | numeroIcon |
    | EynarCucumber   | 1          |
   |  EynarCucumber2  | 2          |
    | EynarCucumber3  | 3          |




