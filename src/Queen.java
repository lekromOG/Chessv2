public class Queen extends Piece {
    public Queen(String color, int x, int y) {
        super("Queen", color, x, y);
    }

    @Override
    public boolean isValidMove(Position newPosition) {
        int xDistance = Math.abs(newPosition.getRow() - this.getX());
        int yDistance = Math.abs(newPosition.getCol() - this.getY());

        return isWithinBounds(newPosition) && (xDistance == yDistance || xDistance == 0 || yDistance == 0);
    }
}