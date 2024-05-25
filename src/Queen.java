public class Queen extends Piece { // Queen class that extends the Piece class
    public Queen(String color, int x, int y) {
        super("Queen", color, x, y);
    }  // Constructor for the Queen class

    @Override
    public boolean isValidMove(Position newPosition, final Board board) { // Checks if the move is valid
        if (!isWithinBounds(newPosition)) { // If the new position is not within the bounds of the board
            return false; // The move is invalid
        }

        int xDirection = Integer.signum(newPosition.getRow() - this.getX()); // Returns -1 if the new position is to the left, 0 if it's in the same column, and 1 if it's to the right
        int yDirection = Integer.signum(newPosition.getCol() - this.getY()); // Returns -1 if the new position is below, 0 if it's in the same row, and 1 if it's above

        if (Math.abs(newPosition.getRow() - this.getX()) != Math.abs(newPosition.getCol() - this.getY()) && newPosition.getRow() != this.getX() && newPosition.getCol() != this.getY()) { // If the move is not diagonal and not horizontal or vertical
            return false; // Queen can't move unless the move is horizontal, vertical, or diagonal
        }

        int xPosition = this.getX() + xDirection; // The x position of the next square in the path
        int yPosition = this.getY() + yDirection; // The y position of the next square in the path

        while (xPosition != newPosition.getRow() || yPosition != newPosition.getCol()) { // While the next square in the path is not the new position
            if (board.getPieceAtPosition(new Position(xPosition, yPosition)) != null) { // If there is a piece in the path
                return false; // There is a piece in the path
            }
            xPosition += xDirection; // Move to the next square in the path
            yPosition += yDirection; // Move to the next square in the path
        }

        return true; // The move is valid
    }
}