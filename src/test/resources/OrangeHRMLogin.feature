Feature: login to application OrangrHRM

Scenario: login with valid 
Given User is on HRMLogin page
    When User enters username as "<username>" and password as "<password>"
    Then User should be able to login sucessfully and new page open

Examples:
| username   | password |
|  Admin     | admin123 |
| bbbbb      | Test@153 |
| ccccc      | Test@111 |
   