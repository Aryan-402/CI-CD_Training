Feature: Login functionality

  Scenario Outline: Successful login with valid credentials
    Given I am on the login page
    When I enter <username> as username and <password> as password
    And I click the Login button
    Then I should be redirected to the welcome page
    Examples:
      | username | password   |
      | "testuser"  | "password123" |

