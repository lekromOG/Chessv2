public class Rook extends Piece { // Rook class extends Piece class
    public Rook(String color, int x, int y) {
        super("Rook", color, x, y);
    } // Rook constructor that takes in a color, x, and y and calls the super constructor with the type "Rook", the color, and the x and y

    @Override
    public boolean isValidMove(Position newPosition, final Board board) {  // isValidMove method that takes in a Position and a Board and returns a boolean
        if (!isWithinBounds(newPosition)) { // If the newPosition is not within the bounds of the board
            return false; // Return false
        }

        int xDirection = Integer.signum(newPosition.getRow() - this.getX()); // 1 if moving right, -1 if moving left (signum returns 1 for positive numbers, -1 for negative numbers, and 0 for 0)
        int yDirection = Integer.signum(newPosition.getCol() - this.getY()); // 1 if moving up, -1 if moving down

        if (xDirection != 0 && yDirection != 0) { // If the move is not horizontal or vertical
            return false; // Rook can't move diagonally
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