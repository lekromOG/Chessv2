public class Queen extends Piece {
    public Queen(String color, int x, int y) {
        super("Queen", color, x, y);
    }

    @Override
    public boolean isValidMove(Position newPosition, final Board board) {
        if (!isWithinBounds(newPosition)) {
            return false;
        }

        int xDirection = Integer.signum(newPosition.getRow() - this.getX());
        int yDirection = Integer.signum(newPosition.getCol() - this.getY());

        if (Math.abs(newPosition.getRow() - this.getX()) != Math.abs(newPosition.getCol() - this.getY()) && newPosition.getRow() != this.getX() && newPosition.getCol() != this.getY()) {
            return false; // Queen can't move unless the move is horizontal, vertical, or diagonal
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