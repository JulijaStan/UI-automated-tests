Feature: The “Login” & "Registration" links are visible on all pages and accessible to the user.

  Background:
    Given I am on the home page

    Scenario: Login visibility and accessibility
      When I click on "Contact us" button
      Then I click on the Login link
      Then I should be redirected to the Login page

    Scenario: Registration visibility and accessibility
      When I click on "Contact us" button
      When I click on the Register link
      Then I should be redirected to the Registration page

    Scenario: Login link is visible and clickable on any first-level category page
      When I click on "Computers" category
      Then I click on the Login link
      Then I should be redirected to the Login page

    Scenario: Registration link is visible and clickable on any first-level category page
      When I click on "Computers" category
      When I click on the Register link
      Then I should be redirected to the Registration page

