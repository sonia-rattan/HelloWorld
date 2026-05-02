# Tic-Tac-Toe

A two-player Tic-Tac-Toe game with both a React web UI and a Java console version.

## Web UI (React)

Built with Vite + React + TypeScript. Dark-themed, fully interactive in the browser.

**Features:**
- Click cells to place X or O
- Status pill shows whose turn it is, the winner, or a draw
- Winning cells highlight with a glow
- Undo and New Game buttons

**Run it:**

```bash
cd ui
npm install
npm run dev
```

Then open http://localhost:5173.

## Console Version (Java)

- Two players take turns: **X** always goes first
- The board is numbered 1–9, left to right, top to bottom
- Enter a number to place your mark in that cell
- First player to get 3 in a row (horizontally, vertically, or diagonally) wins
- If all 9 cells are filled with no winner, it's a draw

**Run it:**

```bash
gradle run
```

Or run `Main.java` directly from IntelliJ using the **Run** button.

### Board Layout

```
 1 | 2 | 3
-----------
 4 | 5 | 6
-----------
 7 | 8 | 9
```

## Project Structure

```
├── src/                        # Java console game
│   ├── main/java/
│   │   ├── Main.java           # Entry point
│   │   ├── Game.java           # Game loop and player turns
│   │   └── Board.java          # Grid logic, win/draw detection
│   └── test/java/
│       └── BoardTest.java      # JUnit 5 unit tests
└── ui/                         # React web UI
    └── src/
        ├── game.ts             # Game logic (win detection, board state)
        ├── App.tsx             # Main game component
        └── components/
            └── Square.tsx      # Individual cell button
```

## Requirements

### Java (console)
- Java 21+
- Gradle 9+

### React (web UI)
- Node.js 18+
- npm

## Running Java Tests

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
