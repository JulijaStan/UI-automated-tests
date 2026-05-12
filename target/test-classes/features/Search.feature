Feature: Search bar visibility and functionality
  The search bar should be visible and function correctly.

  Background:
    Given I am on the home page

    Scenario: Search bar is visible on the home page
      Then The search bar should be visible on the home page
      And The search bar should be enabled

      Scenario: Search bar is visible on Contact us page
      When I click on "Contact us" button
      Then I should be on Contact us page
      Then The search bar should be visible on the home page
      And The search bar should be enabled

    Scenario Outline: Search for a valid product
      When I enter "<keyword>" in the search bar
      And I click the search button
      Then I should see search results

        Examples:
            | keyword   |
            | Desktop   |
            | Computer  |
            | Book      |

#The search input requires at least 3 characters to perform a search.
    Scenario Outline: Search with less than 3 characters
      When I enter "<keyword>" in the search bar
      And I click the search button
      Then I should see a message indicating minimum length

      Examples:
        | keyword   |
        | bo        |
        | !!        |
        | 12        |

    Scenario: Search with an empty query
      When I leave the search bar empty
      And I click the search button
      Then I should see alert with message
      And I click "OK" button on alert

    Scenario: Search using Advanced search
      When I enter "Com" in the search bar
      And I click the search button
      Then I should see search results
      And I click on "Advanced search" option
      When I select "Computers >> Desktops" category from dropdown
      And I click the search button