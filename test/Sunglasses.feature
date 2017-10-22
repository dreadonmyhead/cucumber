@SunglassesTest
Feature: default currency verification ordering the most expensive sunglasses from asos shop

  Scenario Outline: the user changes default currency, orders the most expensive sunglasses and verifies bag currency
    Given the user is on Asos home page
    And default currency is "<DefaultCurrency>"
    When the user searches for the "sunglasses"
    And the user sorts search results from high to low
    And the user selects the first result
    And the user add item to the bag
    Then item with "<BagCurrency>" is shown in the bag

    Examples:
      | DefaultCurrency | BagCurrency |
      | EUR             | €           |
      | USD             | $           |
      | RMB             | ¥           |
      | GBP             | £           |