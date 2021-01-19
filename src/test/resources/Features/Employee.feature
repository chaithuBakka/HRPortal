@smoketest
Feature: Validate the employee page feature
  Scenario Outline: Validate the employee page feature
    Given User Opens HRPortal in the browser "url"
    When User enters username as "username" and password as "password"
    Then User clicks Login button
    Then User enters employeeName as "<empName>" and department Id as "<DepartmentId>"
    Then Click on search btn
    Then employees table should not be empty
    Then employee names should match search value "maria"
    Then Select the radio button of the given employee "Francisco Maria"
    Then Click employee details
    And Close Browser

    Examples:
      | empName | DepartmentId   |
      | test1   | IT             |

