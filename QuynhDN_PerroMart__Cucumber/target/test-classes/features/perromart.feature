Feature: PerroMart Demo

  Scenario Outline: Case1: Check cart
    Given I close popup
    When I enter product name "<product>" to search box and click icon search
    And I click choose product "<choosedProduct>"
    And I click Add to cart button and click icon cart
    Then I verify that product "<choosedProduct>" added to the cart is correct
    Examples:
      | product       | choosedProduct                    |
      | Bronco Salmon | Bronco Jerky Salmon Dog Treat 70g |

  Scenario Outline: Case2: Check shipping address
    Given I close popup
    When  I enter product name "<product>" to search box and click icon search
    And I click choose product "<choosedProduct>"
    And I click Add to cart button,close GiftDeals and click icon cart
    And I click check out button
    And I enter "<email>", "<firstName>", "<lastName>", "<address>", "<apartment>", "<portalCode>", "<phone>" and click Continue to shipping
    Then I verify shipping address "<email>", "<address>, <apartment>, Singapore <portalCode>" is correct
    Examples:
      | product      | choosedProduct                                      | email                    | firstName | lastName  | address | apartment | portalCode | phone      |
      | cat wet food | Aatas Cat Finest Daily Skin & Coat Cat Wet Food 80g | nhuquynhk14001@gmail.com | Do        | Nhu Quynh | DaNang  | Fhome     | 569933     | 0765207419 |
