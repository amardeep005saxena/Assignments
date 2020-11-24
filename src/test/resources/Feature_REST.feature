Feature: Feature file for REST API assignment!

  Scenario: To create new employee entry
    When Adding a new employee with name "Amar" and age "22" and salary "2500"
    Then addition successful with status code 200
    And the details of created employee are valid


  Scenario: To get the employee details  and validate no duplicate Ids
    Given all the employee details
    When extract all the ids
    Then validate no duplicate ids
    And print ID and name of employees
