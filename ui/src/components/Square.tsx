import type { Cell } from "../game";
import "./Square.css";

interface Props {
  value: Cell;
  onClick: () => void;
  highlight: boolean;
  disabled: boolean;
}

export default function Square({ value, onClick, highlight, disabled }: Props) {
  return (
    <button
      className={`square ${value ?? ""} ${highlight ? "highlight" : ""}`}
      onClick={onClick}
      disabled={disabled || value !== null}
    >
      {value}
    </button>
  );
}