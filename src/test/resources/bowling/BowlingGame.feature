Feature: Testing bowling

  @OtherGame
  Scenario: Gutterball game
    When All balls miss all pins
    Then Game score is zero

  @Ignore
  @BowlingGame
  Scenario Outline: Game with first frame spare and next roll <nextRoll>
    When First frame is a spare
    And Next roll is a <nextRoll>
    And The rest from frame <frame> are gutterballs
    Then Game score is <gameScore>
    Examples:
    |frame|nextRoll|gameScore|
    |3     |3       |16       |
    |3     |10      |30       |

  @BowlingGame
  Scenario: Game when first and second roll are strike and rest gutter balls
    When First roll is a strike
    And Second Roll is a strike
    And The rest from frame 3 are gutterballs
    Then Game score is 30

  @BowlingGame
  Scenario: Test random play
    #When Play is 5,5 3,7 2,8 9,1 4,5 3,7 8,2 9,1 10 5,5,10
    When Play is
      |5,5|3,7|2,8|9,1|4,5|3,7|8,2|9,1|10|5,5,10|
    Then Game score is 164

  @BowlingGame
  Scenario: Test random play
    When Play is
      |5,5|3,7|2,8|9,1|4,5|3,7|8,2|9,1|10|5,4|
    Then Game score is 152

  @BowlingGame
  Scenario Outline: Random play
    When Play is <f0> <f1> <f2> <f3> <f4> <f5> <f6> <f7> <f8> <f9>
    Then Game score is <gameScore>
    Examples:
      |f0   |f1   |f2   |f3   |f4   |f5   |f6   |f7   |f8   |f9      |gameScore|
      |1,0  |1,0  |1,0  |1,0  |1,0  |1,0  |1,0  |1,0  |1,0  |1,0     |10       |
      |0,0  |0,0  |0,0  |0,0  |0,0  |0,0  |0,0  |0,0  |0,0  |10,10,10|30       |
      |10   |10   |10   |10   |10   |10   |10   |10   |10   |10,10,10|300      |
      |5,5  |3,7  |2,8  |9,1  |4,5  |3,7  |8,2  |9,1  |10   |5,5,10  |164      |
