@CalculatorTest
Feature: Calculator

  Background:
    Given the user is on Swedbank loan calculator page

  Scenario: loan is not available for the customer
    When the user inserts "5000" amount to desirable loan field
    And the user presses Calculate button
    Then "Atsižvelgdami į Jūsų nurodytas mėnesio pajamas, paskolos suteikti negalime." message is shown

  Scenario Outline: loan is not available for the customer with big amount
    When the user inserts "<Amount>" amount to desirable loan field
    And the user presses Calculate button
    Then "<Message>" message is shown

    Examples:
      | Amount | Message                                                                     |
      | 6000   | Atsižvelgdami į Jūsų nurodytas mėnesio pajamas, paskolos suteikti negalime. |