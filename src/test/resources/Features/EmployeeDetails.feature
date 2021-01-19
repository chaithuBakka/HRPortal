@E2E
Feature: Validate employee details page test
  Scenario Outline: validate the positive scenarios
    Given User Opens HRPortal in the browser "url"
    When User enters username as "username" and password as "password"
    Then User clicks Login button
    Then User enters employeeName as "<empName>" and department Id as "<DepartmentId>"
    Then Click on search btn
    Then employees table should not be empty
    Then employee names should match search value "maria"
    Then Select the radio button of the given employee "Francisco Maria"
    Then Click employee details
    Then validate the selected employee details on employeeDetails page "<empName>" "<empTitle>"
    Then Update the Salary of the employee "<updateSalary>"
    Then Update the department name of employee to "<department>" and "<description>"
    And Click updateEmployee
    And Close Browser

    Examples:
      | empName        | DepartmentId   | empTitle         |  updateSalary | department  | description |
      | Maria Anders   | IT             | Sales Associate  |  120000       | Marketing   | test        |

