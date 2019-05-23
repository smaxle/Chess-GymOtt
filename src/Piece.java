
public enum Piece {
	WHITE_KNIGHT(Color.WHITE), WHITE_KING(Color.WHITE), WHITE_ROOK(Color.WHITE), WHITE_PAWN(Color.WHITE),
	WHITE_QUEEN(Color.WHITE), WHITE_BISHOP(Color.WHITE), EMPTY(Color.NONE), BLACK_KNIGHT(Color.BLACK),
	BLACK_KING(Color.BLACK), BLACK_ROOK(Color.BLACK), BLACK_PAWN(Color.BLACK), BLACK_QUEEN(Color.BLACK),
	BLACK_BISHOP(Color.BLACK);

	Color color;

	Piece(Color color) {
		this.color = color;
	}
}
