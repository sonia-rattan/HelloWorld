public class Board {
    private char[] cells;

    public Board() {
        cells = new char[9];
        for (int i = 0; i < 9; i++) {
            cells[i] = (char) ('1' + i);
        }
    }

    public void print() {
        System.out.println();
        for (int i = 0; i < 9; i++) {
            System.out.print(" " + cells[i] + " ");
            if (i % 3 < 2) System.out.print("|");
            else if (i < 8) System.out.println("\n-----------");
        }
        System.out.println("\n");
    }

    public boolean isValidMove(int pos) {
        return pos >= 1 && pos <= 9 && cells[pos - 1] != 'X' && cells[pos - 1] != 'O';
    }

    public void placeMove(int pos, char player) {
        cells[pos - 1] = player;
    }

    public char checkWinner() {
        int[][] lines = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}
        };
        for (int[] line : lines) {
            if (cells[line[0]] == cells[line[1]] && cells[line[1]] == cells[line[2]]) {
                return cells[line[0]];
            }
        }
        return ' ';
    }

    public boolean isFull() {
        for (char c : cells) {
            if (c != 'X' && c != 'O') return false;
        }
        return true;
    }
}
