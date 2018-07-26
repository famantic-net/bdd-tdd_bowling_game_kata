Feature: Testing bowling

  @BowlingGame
  Scenario: Gutterball game
    When All balls miss all pins
    Then Game score is zero

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
     When First roll is a srike
     And Second Roll is a strike
     And The rest from frame 2 are gutterballs
     Then Game score is 20

   @BowlingGame
   Scenario Outline: Random play
     When Play is <f0> <f1> <f2> <f3> <f4> <f5> <f6> <f7> <f8> <f9>
     Then Game score is <gameScore>
     Examples:
     |f0   |f1   |f2   |f3   |f4   |f5   |f6   |f7   |f8   |f9      |gameScore|
     |1,0  |1,0  |1,0  |1,0  |1,0  |1,0  |1,0  |1,0  |1,0  |1,0     |10       |
     |0,0  |0,0  |0,0  |0,0  |0,0  |0,0  |0,0  |0,0  |0,0  |10,10,10|30       |
     |10,10|10,10|10,10|10,10|10,10|10,10|10,10|10,10|10,10|10,10,10|300      |
     |5,5  |3,7  |2,8  |9,1  |4,5  |3,7  |8,2  |9,1  |10,0 |5,5,10  |159      |
