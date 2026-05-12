Feature: Footer visibility and correct navigation
  The footer should be visible on any pages

Background:
  Given I am on the home page

  Scenario: Footer is visible on Contact Us page
    When I click on "Contact us" button
    Then I should be on Contact us page
    And The footer should be visible on the page

  Scenario: Footer is visible on any first-level category page
    When I click on "Computers" category
    Then I should be on Computers category page
    And The footer should be visible on the page

  Scenario: Footer is visible on subcategory page
    When I click on "Desktops" subcategory under "Computers"
    Then I should be on "Desktops" subcategory page
    And The footer should be visible on the page

  Scenario Outline: Information links navigate correctly
    When I click on footer link "<link>" under Information
    Then I should be redirected to "<expected_url_part>"

    Examples:
      | link               | expected_url_part   |
      | Sitemap            | sitemap             |
      | Shipping & returns | shipping-returns    |
      | Privacy notice     | privacy-policy      |
      | Conditions of Use  | conditions-of-use   |
      | About us           | about-us            |
      | Contact us         | contactus           |

  Scenario Outline: Customer service links navigate correctly
    When I click on footer link "<link>" under Customer service
    Then I should be redirected to "<expected_url_part>"

    Examples:
      | link                     | expected_url_part        |
      | Search                   | search                   |
      | News                     | news                     |
      | Blog                     | blog                     |
      | Recently viewed products | recentlyviewedproducts   |
      | Compare products list    | compareproducts          |
      | New products             | newproducts              |


  Scenario Outline: My account links navigate correctly
    When I click on footer link "<link>" under My account
    Then I should be redirected to "<expected_url_part>"

    Examples:
      | link          | expected_url_part                       |
      | My account    | login?ReturnUrl=%2fcustomer%2finfo      |
      | Orders        | login?ReturnUrl=%2fcustomer%2forders    |
      | Addresses     | login?ReturnUrl=%2fcustomer%2faddresses |
      | Shopping cart | cart                                    |
      | Wishlist      | wishlist                                |

  Scenario Outline: Follow us links navigate correctly
    When I click on footer link "<link>" under Follow us
    Then I should be redirected to "<expected_url_part>"

    Examples:
      | link        | expected_url_part |
      | Facebook    | facebook          |
      | Twitter     | x                 |
      | RSS         | rss               |
      | YouTube     | youtube           |
      | Google+     | google            |

  Scenario: Footer copyright and powered by block are visible and correct
    Then The footer copyright text should be visible
    And The Powered by link should navigate correctly