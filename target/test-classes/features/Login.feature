@login
Feature: User should be able to login

  Scenario: Login as a user
    Given the user is on the login page
    When the users enter the user information
    Then the user should be able to login
