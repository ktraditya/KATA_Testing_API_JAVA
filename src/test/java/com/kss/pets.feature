Feature: Pets APIs

  Scenario Outline: create a vet for each of the specialities
    When I want to create vet with "<firstname>","<lastname>","<specaility>" and <id>
    Then I should be able to create vet

    Examples: 
      | firstname | lastname | specaility | id |
      | john      | chambers | radiology  |  1 |
      | steve     | jobs     | dentistry  |  3 |
      | mary      | manny    | surgery    |  2 |
