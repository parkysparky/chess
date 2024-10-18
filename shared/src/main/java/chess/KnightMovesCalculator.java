package chess;

import java.util.HashSet;
import java.util.Collection;

public class KnightMovesCalculator implements PieceMovesCalculator {
    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition position){
//        System.out.println("KnightMovesCalculator running");

        Collection<ChessMove> moves = new HashSet<>();

        int j = position.getColumn();
        int i = position.getRow();

        ChessPosition endPosition = new ChessPosition(i + 1, j + 2);
        if(isValid(board, position, endPosition)){
            moves.add(new ChessMove(position, endPosition, null));
        }
        endPosition = new ChessPosition(i + 2, j + 1);
        if(isValid(board, position, endPosition)){
            moves.add(new ChessMove(position, endPosition, null));
        }
        endPosition = new ChessPosition(i + 2, j - 1);
        if(isValid(board, position, endPosition)){
            moves.add(new ChessMove(position, endPosition, null));
        }
        endPosition = new ChessPosition(i + 1, j - 2);
        if(isValid(board, position, endPosition)){
            moves.add(new ChessMove(position, endPosition, null));
        }
        endPosition = new ChessPosition(i - 1, j - 2);
        if(isValid(board, position, endPosition)){
            moves.add(new ChessMove(position, endPosition, null));
        }
        endPosition = new ChessPosition(i - 2, j - 1);
        if(isValid(board, position, endPosition)){
            moves.add(new ChessMove(position, endPosition, null));
        }
        endPosition = new ChessPosition(i - 2, j + 1);
        if(isValid(board, position, endPosition)){
            moves.add(new ChessMove(position, endPosition, null));
        }
        endPosition = new ChessPosition(i - 1, j + 2);
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
