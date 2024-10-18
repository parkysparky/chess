package chess;

import java.util.HashSet;
import java.util.Collection;

public class KingMovesCalculator implements PieceMovesCalculator {
    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition position){
//        System.out.println("KingMovesCalculator running");

        Collection<ChessMove> moves = new HashSet<>();

        int j = position.getColumn();
        int i = position.getRow();

        ChessPosition endPosition = new ChessPosition(i+1, j+1);
        if(isValid(board, position, endPosition)){
            moves.add(new ChessMove(position, endPosition, null));
        }
        endPosition = new ChessPosition(i, j+1);
        if(isValid(board, position, endPosition)){
            moves.add(new ChessMove(position, endPosition, null));
        }
        endPosition = new ChessPosition(i-1, j+1);
        if(isValid(board, position, endPosition)){
            moves.add(new ChessMove(position, endPosition, null));
        }
        endPosition = new ChessPosition(i-1, j);
        if(isValid(board, position, endPosition)){
            moves.add(new ChessMove(position, endPosition, null));
        }
        endPosition = new ChessPosition(i-1, j-1);
        if(isValid(board, position, endPosition)){
            moves.add(new ChessMove(position, endPosition, null));
        }
        endPosition = new ChessPosition(i, j-1);
        if(isValid(board, position, endPosition)){
            moves.add(new ChessMove(position, endPosition, null));
        }
        endPosition = new ChessPosition(i+1, j-1);
        if(isValid(board, position, endPosition)){
            moves.add(new ChessMove(position, endPosition, null));
        }
        endPosition = new ChessPosition(i+1, j);
        if(isValid(board, position, endPosition)){
            moves.add(new ChessMove(position, endPosition, null));
        }

        return moves;
    }

    private boolean isOutOfBounds(ChessPosition endPosition){
        int i = endPosition.getColumn();
        int j = endPosition.getRow();

        if(1 > i || 1 > j){ return true;}
        if(8 < i || 8 < j){ return true;}
        return false;
    }

    private boolean isValid(ChessBoard board, ChessPosition startPosition, ChessPosition endPosition) {
        if(isOutOfBounds(endPosition)) { //check bounds
            return false;
        }
        if (board.getPiece(endPosition) != null) { //null protection
            if (board.getPiece(endPosition).getTeamColor() == board.getPiece(startPosition).getTeamColor()){ //check color
                return false;
            }
        }
        return true;
    }
}
