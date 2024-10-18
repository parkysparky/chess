package chess;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

/**
 * For a class that can manage a chess game, making moves on a board
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessGame {
    TeamColor activePlayer = TeamColor.WHITE;
    ChessBoard chessBoard = new ChessBoard();

    public ChessGame() {
        this.chessBoard.resetBoard();
    }

    /**
     * @return Which team's turn it is
     */
    public TeamColor getTeamTurn() {
        return activePlayer;
    }

    /**
     * Set's which teams turn it is
     *
     * @param team the team whose turn it is
     */
    public void setTeamTurn(TeamColor team) {
        activePlayer = team;
    }

    public void swapTeamTurn() {
        if(TeamColor.WHITE == getTeamTurn()){
            setTeamTurn(TeamColor.BLACK);
        }
        if(TeamColor.BLACK == getTeamTurn()){
            setTeamTurn(TeamColor.WHITE);
        }
    }

    /**
     * Enum identifying the 2 possible teams in a chess game
     */
    public enum TeamColor {
        WHITE,
        BLACK
    }

    /**
     * Gets a valid moves for a piece at the given location
     *
     * @param startPosition the piece to get valid moves for
     * @return Set of valid moves for requested piece, or null if no piece at
     * startPosition
     */
    public Collection<ChessMove> validMoves(ChessPosition startPosition) {
        throw new RuntimeException("Not implemented");

        //testMove()
        //undoTestMove()
    }

    /**
     * Makes a move in a chess game
     *
     * @param move chess move to preform
     * @throws InvalidMoveException if move is invalid
     */
    public void makeMove(ChessMove move) throws InvalidMoveException {
        ChessPosition startPosition = move.getStartPosition();
        ChessPiece currentPiece = chessBoard.getPiece(startPosition);
        if(getTeamTurn() != currentPiece.getTeamColor()){
            throw new InvalidMoveException("Not your turn bub >:(");
        }
        //check if real move
        Collection<ChessMove> validMovesList = validMoves(startPosition);
        if (validMovesList.stream().anyMatch(move::equals)) {   //TEST: negate the bool and put exception in if block and move below
            chessBoard.removePiece(startPosition);
            chessBoard.addPiece(move.getEndPosition(), currentPiece);
            swapTeamTurn();
        } else {
            throw new InvalidMoveException("Illegal Move");
        }

    }

    /**
     * Determines if the given team is in check
     *
     * @param teamColor which team to check for check
     * @return True if the specified team is in check
     */
    public boolean isInCheck(TeamColor teamColor) {
        //iterate over board
            //find the king
            //find all oponentmoves
        ChessPosition kingPosition = new ChessPosition(1, 1); //may bug out
        Collection<ChessMove> oponentMoves = new HashSet<>();
        boolean inCheck = false;
        for(int i = 1; i <= 8; i++) {
            for(int j = 1; j <= 8; j++) {
                if((null != chessBoard.getPiece(new ChessPosition(j, i))) &&
                        (ChessPiece.PieceType.KING == chessBoard.getPiece(new ChessPosition(j, i)).getPieceType()) &&
                        (teamColor == chessBoard.getPiece(new ChessPosition(j, i)).getTeamColor()) ) {
                    kingPosition = new ChessPosition(j, i);
                }
                if((null != chessBoard.getPiece(new ChessPosition(j, i))) &&
                        (teamColor != chessBoard.getPiece(new ChessPosition(j, i)).getTeamColor()) ) {
                    oponentMoves.addAll(chessBoard.getPiece(new ChessPosition(j, i)).pieceMoves(chessBoard, new ChessPosition(j, i)));
                }
            }
        }
        for(ChessMove move : oponentMoves) {
            if(kingPosition.equals(move.getEndPosition())){
                inCheck = true;
                break;
            }
        }
        return inCheck;
    }

    /**
     * Determines if the given team is in checkmate
     *
     * @param teamColor which team to check for checkmate
     * @return True if the specified team is in checkmate
     */
    public boolean isInCheckmate(TeamColor teamColor) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Determines if the given team is in stalemate, which here is defined as having
     * no valid moves
     *
     * @param teamColor which team to check for stalemate
     * @return True if the specified team is in stalemate, otherwise false
     */
    public boolean isInStalemate(TeamColor teamColor) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Sets this game's chessboard with a given board
     *
     * @param board the new board to use
     */
    public void setBoard(ChessBoard board) {
        chessBoard = board;
    }

    /**
     * Gets the current chessboard
     *
     * @return the chessboard
     */
    public ChessBoard getBoard() {
        return chessBoard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessGame chessGame = (ChessGame) o;
        return activePlayer == chessGame.activePlayer && Objects.equals(chessBoard, chessGame.chessBoard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(activePlayer, chessBoard);
    }

    @Override
    public String toString() {
        return "ChessGame{" +
                "activePlayer=" + activePlayer +
                ", chessBoard=" + chessBoard +
                '}';
    }
}
