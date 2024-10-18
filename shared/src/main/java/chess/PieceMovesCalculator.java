package chess;

import java.util.HashSet;
import java.util.Collection;

public interface PieceMovesCalculator {
    public Collection<ChessMove>  pieceMoves(ChessBoard board, ChessPosition position);
}
