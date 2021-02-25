Feature: Register by given countryName and area

  Scenario Outline: A user registers with country and area of interest selection (other data is selected randomly)
    Given user clicks to UBS logins-UBS Neo-Register with UBS Neo
    When user fills the necessary information by country: "<countryName>" and area of interest: "<areaOfInterest>"
    And user clicks to submit button
    Then it is seen that url changes as the registration is completed

    Examples:
      | countryName | areaOfInterest |
      | Latvia      | Cash Equities  |
      | Bahamas     | FX             |

