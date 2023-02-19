Feature: To Create new Vet with different specialities
  Use the endpoint POST /api/vet in petclinic API create new Vets with a specialization

  Scenario Outline: Create new Vet with different specialities
    When a request to create a new vet is made with valid request payload in "<jsonFile>"
    Then verify the response <statusCode> is returned and vetid is created

    Examples: 
      | jsonFile                                        | statusCode |
      | src/test/resources/Vet_Valid_dentistry_201.json |        201 |
      | src/test/resources/Vet_Valid_radiology_201.json |        201 |
      | src/test/resources/Vet_Valid_surgery_201.json   |        201 |
