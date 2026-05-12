Feature: Shopping Cart visibility, accessibility and functionality
  As a user
  I want to be able to add items to my shopping cart, remove items from it, and customize gift cards

    Background:
        Given I am on the home page

    Scenario: Shopping cart is visible on the home page
      When I click on "Shopping cart" link
      Then The shopping cart should be visible on the page

    Scenario: Add item to shopping cart and check the total price
      When I enter "Book" in the search bar
      And I click the search button
      Then I should see search results
      And I click "Add to cart" for the first item in the search results
      When I click on "Shopping cart" link
      Then I should see "Book" in the shopping cart
      And The total price in the shopping cart should appear correctly

    Scenario: Remove item from shopping cart and check count of items
      When I enter "Book" in the search bar
      And I click the search button
      Then I should see search results
      And I click "Add to cart" for the first item in the search results
      When I click on "Shopping cart" link
      Then I should see "Book" in the shopping cart
      When I click on check box to choose "Book" in the shopping cart
      And I click on "Update shopping cart" button in the shopping cart
      Then I should not see "Book" in the shopping cart

    Scenario Outline: Add Gift Card with provided information
      When I enter "Gift Card" in the search bar
      And I click the search button
      Then I should see search results
      And I click "Add to cart" for the first item in the search results
      Then I should be redirected to the card customization page
      When I enter recipient "<name>"
      And I enter "<senderName>"
      And I enter "<message>" for the gift card
      When I click on "Add to cart" button on the customization page
      And I click on "Shopping cart" link
      Then I should see "Gift Card" in the shopping cart

      Examples:
        | name  | senderName | message                  |
        | Ann   | Mike       | Happy New Year!          |
        | Marry | Bob        | Hello, Marry! Thank you! |

    Scenario: Add Gift Card with empty fields to check error messages
      When I enter "Gift Card" in the search bar
      And I click the search button
      Then I should see search results
      And I click "Add to cart" for the first item in the search results
      Then I should be redirected to the card customization page
      When I leave the name field empty
      When I leave the sender name field empty
      When I leave the message field empty
      When I click on "Add to cart" button on the customization page
      Then I should see error message on the customization page
