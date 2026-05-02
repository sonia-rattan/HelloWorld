import { useState } from "react";
import Square from "./components/Square";
import {
  checkWinner,
  getWinningLine,
  isBoardFull,
  emptyBoard,
  type Player,
  type Board,
} from "./game";
import "./App.css";

export default function App() {
  const [board, setBoard] = useState<Board>(emptyBoard());
  const [current, setCurrent] = useState<Player>("X");
  const [history, setHistory] = useState<{ board: Board; player: Player }[]>([]);

  const winner = checkWinner(board);
  const winLine = getWinningLine(board);
  const draw = !winner && isBoardFull(board);
  const gameOver = !!winner || draw;

  function handleClick(index: number) {
    if (gameOver || board[index]) return;
    const next = board.slice() as Board;
    next[index] = current;
    setHistory((h) => [...h, { board: board.slice() as Board, player: current }]);
    setBoard(next);
    setCurrent(current === "X" ? "O" : "X");
  }

  function handleUndo() {
    if (history.length === 0) return;
    const prev = history[history.length - 1];
    setHistory((h) => h.slice(0, -1));
    setBoard(prev.board);
    setCurrent(prev.player);
  }

  function handleReset() {
    setBoard(emptyBoard());
    setCurrent("X");
    setHistory([]);
  }

  let statusText: string;
  if (winner) {
    statusText = `Player ${winner} wins!`;
  } else if (draw) {
    statusText = "It's a draw!";
  } else {
    statusText = `Player ${current}'s turn`;
  }

  return (
    <div className="app">
      <h1 className="title">Tic-Tac-Toe</h1>

      <div className={`status ${winner ? `winner-${winner}` : draw ? "draw" : `turn-${current}`}`}>
        {statusText}
      </div>

      <div className="board">
        {board.map((cell, i) => (
          <Square
            key={i}
            value={cell}
            onClick={() => handleClick(i)}
            highlight={!!winLine?.includes(i)}
            disabled={gameOver}
          />
        ))}
      </div>

      <div className="controls">
        <button className="btn secondary" onClick={handleUndo} disabled={history.length === 0}>
          Undo
        </button>
        <button className="btn primary" onClick={handleReset}>
          New Game
        </button>
      </div>
    </div>
  );
}