# Tic-Tac-Toe

A console-based Tic-Tac-Toe game for two players, written in Java.

## How to Play

- Two players take turns: **X** always goes first
- The board is numbered 1–9, left to right, top to bottom
- Enter a number to place your mark in that cell
- First player to get 3 in a row (horizontally, vertically, or diagonally) wins
- If all 9 cells are filled with no winner, it's a draw

## Board Layout

```
 1 | 2 | 3
-----------
 4 | 5 | 6
-----------
 7 | 8 | 9
```

## Example Game

```
=== Tic-Tac-Toe ===

 1 | 2 | 3
-----------
 4 | 5 | 6
-----------
 7 | 8 | 9

Player X, enter a number (1-9): 5

 1 | 2 | 3
-----------
 4 | X | 6
-----------
 7 | 8 | 9

Player O, enter a number (1-9): 1

 O | 2 | 3
-----------
 4 | X | 6
-----------
 7 | 8 | 9

Player X, enter a number (1-9): 3

 O | 2 | X
-----------
 4 | X | 6
-----------
 7 | 8 | 9

Player O, enter a number (1-9): 9

 O | 2 | X
-----------
 4 | X | 6
-----------
 7 | 8 | O

Player X, enter a number (1-9): 7

 O | 2 | X
-----------
 4 | X | 6
-----------
 X | 8 | O

Player X wins!
```

## Project Structure

```
src/
├── main/java/
│   ├── Main.java    # Entry point
│   ├── Game.java    # Game loop and player turns
│   └── Board.java   # Grid logic, win/draw detection
└── test/java/
    └── BoardTest.java  # JUnit 5 unit tests
```

## Requirements

- Java 21+
- Gradle 9+

## Running the Game

```bash
gradle run
```

Or run `Main.java` directly from IntelliJ using the **Run** button.

## Running the Tests

```bash
gradle test
```

### Test Coverage

| Test | Description |
|------|-------------|
| `allMovesValidOnNewBoard` | All 9 cells are open at the start |
| `outOfBoundsMoveIsInvalid` | Positions 0 and 10 are rejected |
| `takenCellIsInvalidMove` | Cannot play on an already-taken cell |
| `noWinnerOnNewBoard` | Fresh board has no winner |
| `xWinsTopRow` | Row win detection for X |
| `oWinsMiddleRow` | Row win detection for O |
| `xWinsFirstColumn` | Column win detection |
| `oWinsMainDiagonal` | Diagonal (1→5→9) win |
| `xWinsAntiDiagonal` | Diagonal (3→5→7) win |
| `boardNotFullOnStart` | New board is not full |
| `boardIsFullWhenAllCellsTaken` | Full board detected correctly |
| `drawWhenBoardFullWithNoWinner` | Draw scenario with no winner |
