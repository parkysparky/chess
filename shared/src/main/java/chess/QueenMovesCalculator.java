package chess;

import java.util.ArrayList;
import java.util.Collection;

public class QueenMovesCalculator implements PieceMovesCalculator {
    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition position){
//        System.out.println("QueenMovesCalculator running");

        PieceMovesCalculator bishopMoves = new BishopMovesCalculator();
        PieceMovesCalculator rookMoves = new RookMovesCalculator();
        Collection<ChessMove> moves = new ArrayList<>(bishopMoves.pieceMoves(board, position));
        moves.addAll(rookMoves.pieceMoves(board, position));

        return moves;
    }
}
