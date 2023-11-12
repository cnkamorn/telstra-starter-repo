Feature : Sim Card Activator

  Scenario: Functional Sim Card can activate
    Given a correct Sim Card
    When a request has been submitted
    Then The sim card is activated and is recorded to the database

  Scenario: Broken Sim Card can't activate
    Given a broken Sim Card
    When a request has been submitted
    Then The sim card is not activated and is recorded to the database

