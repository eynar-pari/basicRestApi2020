Feature: User

  Scenario: Usersss

    Given I have connection with Todo.ly
    When I send a GET request to authentication/token.json end point with the json
    """
    """
    Then the response code should be 200
    And I expected a json response equal to
    """
    {
      "TokenString": "IGNORE",
      "UserEmail": "eynar.pari@gmail.com",
      "ExpirationTime": "IGNORE"
    }
    """
    And I save the attribute TokenString in the variable : TOKEN
    When  I send a DELETE request to authentication/token.json end point with token
    """
    TOKEN
    """
    Then the response code should be 200
    When  I send a GET request to authentication/isauthenticated.json end point with token
    """
    TOKEN
    """
    Then the response code should be 200
    And I expected the false is displayed in json response




