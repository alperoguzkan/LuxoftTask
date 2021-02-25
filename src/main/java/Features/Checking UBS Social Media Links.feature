@explicitLanguageChange
Feature: Checking of if the social media links work

  Scenario Outline: Checking of if the USB social media links are active and navigating to correct page
    Given user clicks to Wealth Management- Your Life goals link
    And selects the "<language>"
    When user clicks to 'Helping you grow your wealth' link
    Then it is being checked no social media link is broken

    Examples:
      | language |
      | English  |
      | Deutsch  |
      | Italiano |


