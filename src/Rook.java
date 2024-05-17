public class Rook extends Piece {
    public Rook(String color, int x, int y) {
        super("Rook", color, x, y);
    }

    @Override
    public boolean isValidMove(Position newPosition, final Board board) {
        if (!isWithinBounds(newPosition)) {
            return false;
        }

        int xDirection = Integer.signum(newPosition.getRow() - this.getX());
        int yDirection = Integer.signum(newPosition.getCol() - this.getY());

        if (xDirection != 0 && yDirection != 0) {
            return false; // Rook can't move diagonally
        }

        int xPosition = this.getX() + xDirection;
        int yPosition = this.getY() + yDirection;

        while (xPosition != newPosition.getRow() || yPosition != newPosition.getCol()) {
            if (board.getPieceAtPosition(new Position(xPosition, yPosition)) != null) {
                return false; // There is a piece in the path
            }
            xPosition += xDirection;
            yPosition += yDirection;
        }

        return true;
    }
}