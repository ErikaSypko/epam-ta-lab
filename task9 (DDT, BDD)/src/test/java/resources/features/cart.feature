Feature: cart
  As a user
  I want to be able to add items to the cart
  So I can store items for later payment

  Scenario Outline: Add item to cart
    Given User searches for the category <category> of goods
    When User filters goods by brand <brand>
    And User sorts goods by price descending
    And User selects first good
    And User clicks Add to Bag button
    Then User checks price is less than the given price <price>

    Examples:
      | category   | brand   | price  |
      | Ноутбуки   | Apple   | 65000  |
      | Телефоны   | Samsung | 65000  |
      | Телевизоры | LG      | 250000 |
      | Пылесосы   | Bosch   | 25000  |
      | Фены       | Philips | 10000  |
