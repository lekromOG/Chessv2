public class King extends Piece { // King class that extends Piece
    public King(String color, int x, int y) {
        super("King", color, x, y);
    } // Constructor

    @Override
    public boolean isValidMove(Position newPosition, final Board board) { // isValidMove Method
        int xDistance = Math.abs(newPosition.getRow() - this.getX()); // Absolute value of the difference between the new position's row and the current position's row
        int yDistance = Math.abs(newPosition.getCol() - this.getY()); // Absolute value of the difference between the new position's column and the current position's column

        return isWithinBounds(newPosition) && (xDistance <= 1 && yDistance <= 1); // Returns true if the new position is within the bounds of the board and the distance between the new position and the current position is less than or equal to 1
    }
}