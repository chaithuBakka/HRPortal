
Feature: Validate the search page feature
  Scenario Outline:
    Given User Opens HRPortal in the browser "url"
    When User enters username as "username" and password as "password"
    Then User clicks Login button
    Then User enters employeeName as "<empName>" and department Id as "<DepartmentId>"
    And Click on search btn

    Examples:
    | empName | DepartmentId   |
    | test1   | IT             |
    | test1   | Human Resources|
    | test3   | Marketing      |
    | test4   | Sales          |

