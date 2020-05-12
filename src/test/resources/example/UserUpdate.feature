Feature: User

  Scenario: Usersss
    Given I have connection with Todo.ly
    When I send a POST request to user/0.json end point with the json
    """
    {
          "FullName": "Eynar"
    }
    """
    Then the response code should be 200
    And I expected a json response equal to
    """
    {
      "Email":"eynar.pari@gmail.com",
      "Password":null,
      "FullName":"Eynar"
    }
    """
