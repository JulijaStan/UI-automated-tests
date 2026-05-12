Feature: Logo visibility and Home page redirection
  The logo should be visible on any pages and clicking it should redirect to the home page.

  Background:
    Given I am on the home page

    Scenario: Logo is visible on Contact us page
      When I click on "Contact us" button
      Then I should be on Contact us page
      And The logo should be visible on the page
      When I click on the logo
      Then I should be redirected to the home page

    Scenario: Logo is visible on any first-level category page
        When I click on "Computers" category
        Then I should be on Computers category page
        And The logo should be visible on the page
        When I click on the logo
        Then I should be redirected to the home page

    Scenario: Logo is visible on any subcategory page
        When I click on "Desktops" subcategory under "Computers"
        Then I should be on "Desktops" subcategory page
        And The logo should be visible on the page
        When I click on the logo
        Then I should be redirected to the home page
