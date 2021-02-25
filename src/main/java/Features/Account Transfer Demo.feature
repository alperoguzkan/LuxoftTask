Feature: Account Transfer Demo

  Scenario Outline: A user goes to demo ebanking link and make a mock account transfer
    Given user clicks to UBS logins
    And user clicks to E-Banking Switzerland
    And click Trial E-Banking demo
    Then clicks to new
    And clicks to account transfer
    And makes a transaction for Daniel Gerber's konto to his sparkonto with amount of "<amount>" CHF and the note: "<note>"

    Examples:
      | amount | note          |
      | 1000   | Rent          |
      | 2000   | Personal Debt |

