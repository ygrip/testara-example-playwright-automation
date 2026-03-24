@Sanity @SwagLabsPage
Feature: Test on swaglabs page

  Scenario: Add to cart and checkout items
    Given Yunaz using chrome in desktop
    When he open "swaglabs" page
    Then he is in "swaglabs" page
    When he type value "properties(swaglabs.standard_user)" to "username field"
    And he type value "properties(swaglabs.password)" to "password field"
    And he click the "button login"
    Then he wait until "inventory container" is visible
    When he do "add product 'Sauce Labs Fleece Jacket' to cart"
    And he do "add product 'Sauce Labs Backpack' to cart"
    And he click the "shopping cart"
    Then he wait until "cart items" is visible
    And he see that
      | actual                              | validation | expectation                                         |
      | alltextof(cart items name)          | CONTAINS   | ["Sauce Labs Fleece Jacket", "Sauce Labs Backpack"] |
      | sum(alltextof(cart items quantity)) | EQUAL      | 2                                                   |
    When he click the "button checkout"
    And he type value "Yunaz" to "input first name"
    And he type value "Ramadhan" to "input last name"
    And he type value "random(6,NUMERIC)" to "input postal code"
    And he click the "button continue"
    Then he wait until "cart items" is visible
    When he click the "button finish"
    Then he wait until "checkout complete" is visible
    And he see that
      | actual                    | validation    | expectation               |
      | textof(checkout complete) | CONTAINS_TEXT | Thank you for your order! |
