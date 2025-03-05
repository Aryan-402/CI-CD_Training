Feature: User Signup

  Scenario: Successful signup with valid details
    Given I am on the signup page
    When I enter "testuser" as username
    And I enter "testuser@gmail.com" as email
    And I enter "password123" as password
    And I click the Signup button
    Then I should be redirected to the login page