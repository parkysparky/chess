package chess;

import java.util.ArrayList;
import java.util.Collection;

public class KingMovesCalculator implements PieceMovesCalculator {
    @Override
    public ArrayList<ChessMove> pieceMoves(ChessBoard board, ChessPosition position){
//        System.out.println("KingMovesCalculator running");

        ChessPiece piece = board.getPiece(position);

        ArrayList<ChessMove> moves = new ArrayList<>();
        int j = position.getRow();;
        int i = position.getColumn();
        while(i < 8 && j < 8){ //UR direction
            ++i;
            ++j;
            ChessPosition endPosition = new ChessPosition(j, i);
            if(null == board.getPiece(endPosition)){
                moves.add(new ChessMove(position, endPosition, piece.getPieceType()));
                break;
            } else if (piece.getTeamColor() == board.getPiece(endPosition).getTeamColor()) {
                break;
            } else {
                moves.add(new ChessMove(position, endPosition, piece.getPieceType()));
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
                moves.add(new ChessMove(position, endPosition, piece.getPieceType()));
                break;
            } else if (piece.getTeamColor() == board.getPiece(endPosition).getTeamColor()) {
                break;
            } else {
                moves.add(new ChessMove(position, endPosition, piece.getPieceType()));
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
                moves.add(new ChessMove(position, endPosition, piece.getPieceType()));
                break;
            } else if (piece.getTeamColor() == board.getPiece(endPosition).getTeamColor()) {
                break;
            } else {
                moves.add(new ChessMove(position, endPosition, piece.getPieceType()));
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
                moves.add(new ChessMove(position, endPosition, piece.getPieceType()));
                break;
            } else if (piece.getTeamColor() == board.getPiece(endPosition).getTeamColor()) {
                break;
            } else {
                moves.add(new ChessMove(position, endPosition, piece.getPieceType()));
                break;
            }
        }
        j = position.getRow();;
        i = position.getColumn();
        while(j < 8){ //U direction
            ++j;
            ChessPosition endPosition = new ChessPosition(j, i);
            if(null == board.getPiece(endPosition)){
                moves.add(new ChessMove(position, endPosition, piece.getPieceType()));
                break;
            } else if (piece.getTeamColor() == board.getPiece(endPosition).getTeamColor()) {
                break;
            } else {
                moves.add(new ChessMove(position, endPosition, piece.getPieceType()));
                break;
            }
        }
        j = position.getRow();;
        while(i < 8){ //R direction
            ++i;
            ChessPosition endPosition = new ChessPosition(j, i);
            if(null == board.getPiece(endPosition)){
                moves.add(new ChessMove(position, endPosition, piece.getPieceType()));
                break;
            } else if (piece.getTeamColor() == board.getPiece(endPosition).getTeamColor()) {
                break;
            } else {
                moves.add(new ChessMove(position, endPosition, piece.getPieceType()));
                break;
            }
        }
        i = position.getColumn();
        while(j > 1){ //D direction
            --j;
            ChessPosition endPosition = new ChessPosition(j, i);
            if(null == board.getPiece(endPosition)){
                moves.add(new ChessMove(position, endPosition, piece.getPieceType()));
                break;
            } else if (piece.getTeamColor() == board.getPiece(endPosition).getTeamColor()) {
                break;
            } else {
                moves.add(new ChessMove(position, endPosition, piece.getPieceType()));
                break;
            }
        }
        j = position.getRow();;
        while(i > 1){ //L direction
            --i;
            ChessPosition endPosition = new ChessPosition(j, i);
            if(null == board.getPiece(endPosition)){
                moves.add(new ChessMove(position, endPosition, piece.getPieceType()));
                break;
            } else if (piece.getTeamColor() == board.getPiece(endPosition).getTeamColor()) {
                break;
            } else {
                moves.add(new ChessMove(position, endPosition, piece.getPieceType()));
                break;
            }
        }

        return moves;
    }
}
