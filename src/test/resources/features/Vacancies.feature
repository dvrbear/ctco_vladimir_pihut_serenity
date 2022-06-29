@Run
Feature: Vacancies

  Scenario: Verify count of automation tester professional skills
    Given open main page
    When goto vacancies
    And goto test automation engineer
    Then count of skills should be equal to : 8

  Scenario Outline: Automation tester professional skills should not be equal to <count>
    Given open main page
    When goto vacancies
    And goto test automation engineer
    Then count of skills should not be equal to : <count>
    Examples:
      | count |
      | 0     |
      | 7     |
      | 10    |
