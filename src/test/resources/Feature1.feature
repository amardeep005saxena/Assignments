Feature: Assignment1

  Scenario: Purchase Order with website
    Given Website is accessible with "http://automationpractice.com/index.php"
    When select and order the product
    Then  order completed successfully


