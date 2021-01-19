@Regression
Feature: HR Portal Login

  @Regression
  Scenario: Validate the login page with valid credentials
    Given User Opens HRPortal in the browser "url"
    When User enters username as "username" and password as "password"
    And User clicks Login button
    Then Login should succeed
    And Close Browser

  @ignore
  Scenario: Validate the login page with invalid credentials
    Given User Opens HRPortal in the browser "url"
    When User enters username as "username" and password as "password"
    And User should be displayed with error message