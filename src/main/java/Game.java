import java.util.Scanner;

public class Game {
    private Board board;
    private char currentPlayer;
    private Scanner scanner;

    public Game() {
        board = new Board();
        currentPlayer = 'X';
        scanner = new Scanner(System.in);
    }

    public void play() {
        System.out.println("=== Tic-Tac-Toe ===");
        while (true) {
            board.print();
            int move = getMove();
            board.placeMove(move, currentPlayer);
            char winner = board.checkWinner();
            if (winner != ' ') {
                board.print();
                System.out.println("Player " + winner + " wins!");
                break;
            }
            if (board.isFull()) {
                board.print();
                System.out.println("It's a draw!");
                break;
            }
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
        scanner.close();
    }

    private int getMove() {
        while (true) {
            System.out.print("Player " + currentPlayer + ", enter a number (1-9): ");
            try {
                int move = Integer.parseInt(scanner.nextLine().trim());
                if (board.isValidMove(move)) return move;
                System.out.println("Invalid move, try again.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number between 1 and 9.");
            }
        }
    }
}
