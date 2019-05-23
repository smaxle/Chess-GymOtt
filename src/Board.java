import java.util.ArrayList;

public class Board {
	/**
	 * asdassd
	*/
	final static int BOARD_SIZE = 8;

	Piece[][] board = new Piece[BOARD_SIZE][BOARD_SIZE];
	int halfturn;

	Board(String fen) {
		int column = 0;
		int row = 0;
		for (char c : fen.toCharArray()) {
			switch (c) {

			// New row
			case '/':
				column = 0;
				row++;
				break;

			// King
			case 'K':
				board[column][row] = Piece.WHITE_KING;
				column++;
				break;
			case 'k':
				board[column][row] = Piece.BLACK_KING;
				column++;
				break;

			// Queen
			case 'Q':
				board[column][row] = Piece.WHITE_QUEEN;
				column++;
				break;
			case 'q':
				board[column][row] = Piece.BLACK_QUEEN;
				column++;
				break;

			// Bishop
			case 'B':
				board[column][row] = Piece.WHITE_BISHOP;
				column++;
				break;
			case 'b':
				board[column][row] = Piece.BLACK_BISHOP;
				column++;
				break;

			// Knight
			case 'N':
				board[column][row] = Piece.WHITE_KNIGHT;
				column++;
				break;
			case 'n':
				board[column][row] = Piece.BLACK_KNIGHT;
				column++;
				break;

			// Rook
			case 'R':
				board[column][row] = Piece.WHITE_ROOK;
				column++;
				break;
			case 'r':
				board[column][row] = Piece.BLACK_ROOK;
				column++;
				break;

			// Pawn
			case 'P':
				board[column][row] = Piece.WHITE_PAWN;
				column++;
				break;
			case 'p':
				board[column][row] = Piece.BLACK_PAWN;
				column++;
				break;

			default:
				if (Character.isDigit(c)) {
					int emptySquaresLeft = Character.getNumericValue(c);
					while (emptySquaresLeft > 0) {
						emptySquaresLeft--;
						board[column][row] = Piece.EMPTY;
						column++;
					}
				} else {
					throw new IllegalArgumentException();
				}
			}
		}
	}

	/**
	 * Returns which kind of piece currently occupies the specified square.
	 */
	public Piece pieceAt(int column, int row) {
		return board[column][row];
	}
	
	public ArrayList<Integer> arrayOfPieceLocations(Color color) {
		ArrayList<Integer> returnPositions = new ArrayList<Integer>();
		for(int row = 0; row < BOARD_SIZE; row++) {
			for(int column = 0; column < BOARD_SIZE; column++) {
				if(pieceAt(column, row).color == color) {
					returnPositions.add(column);
					returnPositions.add(row);
				}
			}
		}
		return returnPositions;
	}
	

}
