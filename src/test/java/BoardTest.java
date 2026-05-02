import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void allMovesValidOnNewBoard() {
        for (int i = 1; i <= 9; i++) {
            assertTrue(board.isValidMove(i));
        }
    }

    @Test
    void outOfBoundsMoveIsInvalid() {
        assertFalse(board.isValidMove(0));
        assertFalse(board.isValidMove(10));
    }

    @Test
    void takenCellIsInvalidMove() {
        board.placeMove(5, 'X');
        assertFalse(board.isValidMove(5));
    }

    @Test
    void noWinnerOnNewBoard() {
        assertEquals(' ', board.checkWinner());
    }

    @Test
    void xWinsTopRow() {
        board.placeMove(1, 'X');
        board.placeMove(2, 'X');
        board.placeMove(3, 'X');
        assertEquals('X', board.checkWinner());
    }

    @Test
    void oWinsMiddleRow() {
        board.placeMove(4, 'O');
        board.placeMove(5, 'O');
        board.placeMove(6, 'O');
        assertEquals('O', board.checkWinner());
    }

    @Test
    void xWinsFirstColumn() {
        board.placeMove(1, 'X');
        board.placeMove(4, 'X');
        board.placeMove(7, 'X');
        assertEquals('X', board.checkWinner());
    }

    @Test
    void oWinsMainDiagonal() {
        board.placeMove(1, 'O');
        board.placeMove(5, 'O');
        board.placeMove(9, 'O');
        assertEquals('O', board.checkWinner());
    }

    @Test
    void xWinsAntiDiagonal() {
        board.placeMove(3, 'X');
        board.placeMove(5, 'X');
        board.placeMove(7, 'X');
        assertEquals('X', board.checkWinner());
    }

    @Test
    void boardNotFullOnStart() {
        assertFalse(board.isFull());
    }

    @Test
    void boardIsFullWhenAllCellsTaken() {
        char[] players = {'X', 'O', 'X', 'O', 'X', 'O', 'O', 'X', 'O'};
        for (int i = 1; i <= 9; i++) {
            board.placeMove(i, players[i - 1]);
        }
        assertTrue(board.isFull());
    }

    @Test
    void drawWhenBoardFullWithNoWinner() {
        // X O X
        // X X O
        // O X O  — no winner
        board.placeMove(1, 'X');
        board.placeMove(2, 'O');
        board.placeMove(3, 'X');
        board.placeMove(4, 'X');
        board.placeMove(5, 'X');
        board.placeMove(6, 'O');
        board.placeMove(7, 'O');
        board.placeMove(8, 'X');
        board.placeMove(9, 'O');
        assertEquals(' ', board.checkWinner());
        assertTrue(board.isFull());
    }
}
