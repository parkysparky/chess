package chess;

import java.util.ArrayList;
import java.util.Collection;

public class PawnMovesCalculator implements PieceMovesCalculator {
    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition position){
//        System.out.println("PawnMovesCalculator running");

        Collection<ChessMove> moves = new ArrayList<>();

        int i = position.getColumn();
        int j = position.getRow();

        ChessPiece piece = board.getPiece(position);
        if(ChessGame.TeamColor.WHITE == piece.getTeamColor()){
            if(2 == j){ //double move at start
                ChessPosition endPosition = new ChessPosition(j+2, i);
                if(null == board.getPiece(endPosition)){
                    moves.add(new ChessMove(position, endPosition, null));
                }
            }
            ChessPosition endPosition = new ChessPosition(j+1, i);
            if(null == board.getPiece(endPosition)){ //normal move
                moves.add(new ChessMove(position, endPosition, null));
            }
        }
        if(ChessGame.TeamColor.BLACK == piece.getTeamColor()){
            if(7 == j){ //double move at start
                ChessPosition endPosition = new ChessPosition(j-2, i);
                if(null == board.getPiece(endPosition)){
                    moves.add(new ChessMove(position, endPosition, null));
                }
            }
            ChessPosition endPosition = new ChessPosition(j-1, i);
            if(null == board.getPiece(endPosition)){ //normal move
                moves.add(new ChessMove(position, endPosition, null));
            }
        }


        return moves;
    }
    private void addPromotionMoves(ChessPosition startPosition, ChessPosition endPosition, Collection<ChessMove> moves){ //check this adds to the same collection
        moves.add(new ChessMove(startPosition, endPosition, ChessPiece.PieceType.BISHOP));
        moves.add(new ChessMove(startPosition, endPosition, ChessPiece.PieceType.KNIGHT));
        moves.add(new ChessMove(startPosition, endPosition, ChessPiece.PieceType.ROOK));
        moves.add(new ChessMove(startPosition, endPosition, ChessPiece.PieceType.QUEEN));
    }
}
