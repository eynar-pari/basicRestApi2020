Feature: Item

  Scenario: Creation, Update, Delete, Get

    Given I have connection with Todo.ly
    When I send a POST request to items.json end point with the json
    """
   {
          "Content": "ItemC"
   }
    """
    Then the response code should be 200
    And I expected a json response equal to
    """
    {
        "Id": "IGNORE",
        "Content": "ItemC",
        "ItemType": 1,
        "Checked": false,
        "ProjectId": null,
        "ParentId": null,
        "Path": "",
        "Collapsed": false,
        "DateString": null,
        "DateStringPriority": 0,
        "DueDate": "",
        "Recurrence": null,
        "ItemOrder": null,
        "Priority": 4,
        "LastSyncedDateTime": "IGNORE",
        "Children": [],
        "DueDateTime": null,
        "CreatedDate": "IGNORE",
        "LastCheckedDate": null,
        "LastUpdatedDate": "IGNORE",
        "Deleted": false,
        "Notes": "",
        "InHistory": false,
        "SyncClientCreationId": null,
        "DueTimeSpecified": true,
        "OwnerId": "IGNORE"
    }
    """
    And I save the attribute Id in the variable : ID_ITEM
    When I send a PUT request to items/ID_ITEM.json end point with the json
    """
    {
          "Content": "Item UPDATE"
    }
    """
    Then the response code should be 200
    And I expected a json response equal to
    """
     {
          "Id":"ID_ITEM",
          "Content": "Item UPDATE"
    }
    """
    When I send a DELETE request to items/ID_ITEM.json end point with the json
    """
    """
    And the response code should be 200
    Then I send a GET request to items/ID_ITEM.json end point with the json
    """
    """
    And the response code should be 200
    And I expected a json response equal to
    """
     {
          "Id":"ID_ITEM",
          "Content": "Item UPDATE",
          "Deleted": true
    }
    """



