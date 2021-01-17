Feature: HR Portal Login

  Scenario:
    Given User Opens HRPortal in the browser "url"
    When User enters username as "username" and password as "password"
    And User clicks Login button
    Then Login should succeed


