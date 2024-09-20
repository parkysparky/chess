package chess;

import java.util.HashSet;
import java.util.Collection;

public class RookMovesCalculator implements PieceMovesCalculator {
    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition position){
//        System.out.println("RookMovesCalculator running");
        ChessPiece piece = board.getPiece(position);

        Collection<ChessMove> moves = new HashSet<>();
        int j = position.getRow();;
        int i = position.getColumn();
        while(j < 8){ //U direction
            ++j;
            ChessPosition endPosition = new ChessPosition(j, i);
            if(null == board.getPiece(endPosition)){
                moves.add(new ChessMove(position, endPosition, null));
            } else if (piece.getTeamColor() == board.getPiece(endPosition).getTeamColor()) {
                break;
            } else {
                moves.add(new ChessMove(position, endPosition, null));
                break;
            }
        }
        j = position.getRow();;
        while(i < 8){ //R direction
            ++i;
            ChessPosition endPosition = new ChessPosition(j, i);
            if(null == board.getPiece(endPosition)){
                moves.add(new ChessMove(position, endPosition, null));
            } else if (piece.getTeamColor() == board.getPiece(endPosition).getTeamColor()) {
                break;
            } else {
                moves.add(new ChessMove(position, endPosition, null));
                break;
            }
        }
        i = position.getColumn();
        while(j > 1){ //D direction
            --j;
            ChessPosition endPosition = new ChessPosition(j, i);
            if(null == board.getPiece(endPosition)){
                moves.add(new ChessMove(position, endPosition, null));
            } else if (piece.getTeamColor() == board.getPiece(endPosition).getTeamColor()) {
                break;
            } else {
                moves.add(new ChessMove(position, endPosition, null));
                break;
            }
        }
        j = position.getRow();;
        while(i > 1){ //L direction
            --i;
            ChessPosition endPosition = new ChessPosition(j, i);
            if(null == board.getPiece(endPosition)){
                moves.add(new ChessMove(position, endPosition, null));
            } else if (piece.getTeamColor() == board.getPiece(endPosition).getTeamColor()) {
                break;
            } else {
                moves.add(new ChessMove(position, endPosition, null));
                break;
            }
        }

        return moves;
    }
}
