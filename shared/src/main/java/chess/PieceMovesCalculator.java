package chess;

import java.util.ArrayList;

public interface PieceMovesCalculator {
    public ArrayList<ChessMove>  pieceMoves(ChessBoard board, ChessPosition position);
}
