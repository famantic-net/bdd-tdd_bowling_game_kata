Feature: Share state between step classes

  @ScenarioWorld
  Scenario: Change state
    When We call the start method
    Then The state has changed to started

