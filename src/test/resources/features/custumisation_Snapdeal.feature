Feature: Check the user can access the search bar

@smoke
  Scenario: Verify that the user should be able to search a product
    Given  the user navigates to home page
    When  the user enter the product name
    Then the products results should be displayed

@regression
    Scenario: Verify that user is able to enter the pincode after search result is displayed for kurti
      Given user navigates to home page
      When the user enter the product name and clicks on the enter your pincode button
      Then it will show the  search result  for entered pincode

@pincode
    Scenario: Verify that user is able to enter invalid pincode after search result is displayed
      Given the user navigates to the home page
      When the user enter the product name and clicks on the enter your pincode button and trying to enter invalid pincode
      Then it will show the related search result is available for entered pincode or not

    Scenario Outline:  Verify that the user is able to search two products
      Given the user navigate to home page
      When the user enter the "<product>"
      Then the products "<result>" should be displayed
      Examples:
      | product  | result                         |
      | kurti    | Showing 10000+ items for kurti |
      | jeans    | Showing 3366 items for jeans   |

