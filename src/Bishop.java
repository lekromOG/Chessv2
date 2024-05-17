public class Bishop extends Piece {
    public Bishop(String color, int x, int y) {
        super("Bishop", color, x, y);
    }

    @Override
    public boolean isValidMove(Position newPosition) {
        int xDistance = Math.abs(newPosition.getRow() - this.getX());
        int yDistance = Math.abs(newPosition.getCol() - this.getY());

        return isWithinBounds(newPosition) && (xDistance == yDistance);
    }
}