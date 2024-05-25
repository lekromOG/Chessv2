public class Bishop extends Piece {
    public Bishop(String color, int x, int y) {
        super("Bishop", color, x, y);
    }

    @Override
    public boolean isValidMove(Position newPosition, final Board board) {
        if (!isWithinBounds(newPosition)) {
            return false;
        }

        int xDirection = Integer.signum(newPosition.getRow() - this.getX()); // 1 if moving right, -1 if moving left (signum returns 1 for positive numbers, -1 for negative numbers, and 0 for 0)
        int yDirection = Integer.signum(newPosition.getCol() - this.getY()); // 1 if moving up, -1 if moving down

        if (Math.abs(newPosition.getRow() - this.getX()) != Math.abs(newPosition.getCol() - this.getY())) {
            return false; // Bishop can't move unless the move is diagonal
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