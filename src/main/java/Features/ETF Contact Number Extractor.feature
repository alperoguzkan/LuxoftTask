Feature: ETF Contact Number Extractor

  Scenario: A preregistered user logs in to the application
    Given user clicks to Asset Management
    And user clicks to Product And Capabilities
    And user clicks to Contact us
    Then user clicks ETF Contacts
    And verify it redirects to contacts page
    And the number is written to etfContactNumber.txt

