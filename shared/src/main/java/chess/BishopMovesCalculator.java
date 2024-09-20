package chess;

import java.util.HashSet;
import java.util.Collection;

public class BishopMovesCalculator implements PieceMovesCalculator {

    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition position){
//        System.out.println("BishopMovesCalculator running");

        ChessPiece piece = board.getPiece(position);

        Collection<ChessMove> moves = new HashSet<>();
        int j = position.getRow();;
        int i = position.getColumn();
        while(i < 8 && j < 8){ //UR direction
            ++i;
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
        i = position.getColumn();
        while(i < 8 && j > 1){ //DR direction
            ++i;
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
        i = position.getColumn();
        while(i > 1 && j > 1){ //DL direction
            --i;
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
        i = position.getColumn();
        while(i > 1 && j < 8){ //UL direction
            --i;
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

        return moves;
    }
}
