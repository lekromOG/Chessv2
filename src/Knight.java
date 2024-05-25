public class Knight extends Piece { // Knight class that extends Piece
    public Knight(String color, int x, int y) {
        super("Knight", color, x, y);
    } // Constructor

    @Override
    public boolean isValidMove(Position newPosition, final Board board) { // isValidMove Method
        int xDistance = Math.abs(newPosition.getRow() - this.getX()); // Absolute value of the difference between the new position's row and the current position's row
        int yDistance = Math.abs(newPosition.getCol() - this.getY()); // Absolute value of the difference between the new position's column and the current position's column

        return isWithinBounds(newPosition) && ((xDistance == 2 && yDistance == 1) || (xDistance == 1 && yDistance == 2)); // Returns true if the new position is within the bounds of the board and the distance between the new position and the current position is either 2 rows and 1 column or 1 row and 2 columns
    }
}