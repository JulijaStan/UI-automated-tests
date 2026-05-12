Feature: Wish list visibility and accessibility
    As a user
    I want to be able to see and access the wish list from any page

  Background:
    Given I am on the home page

  Scenario: Wish list icon is visible
    Then The wish list icon should be visible on the home page
    When I click on the wish list icon
    And I should be redirected to the Wishlist page

  Scenario: Wish list link is visible and clickable on contact us page
    When I click on "Contact us" button
    Then I should be on Contact us page
    When I click on the wish list icon
    Then I should be redirected to the Wishlist page

  Scenario: Wish list link is visible and clickable on any first-level category page
    When I click on "Computers" category
    Then I should be on Computers category page
    When I click on the wish list icon
    Then I should be redirected to the Wishlist page

  Scenario: Wish list link is visible and clickable on any subcategory page
    When I click on "Desktops" subcategory under "Computers"
    Then I should be on "Desktops" subcategory page
    When I click on the wish list icon
    Then I should be redirected to the Wishlist page