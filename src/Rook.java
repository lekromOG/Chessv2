public class Rook extends Piece {
    public Rook(String color, int x, int y) {
        super("Rook", color, x, y);
    }

    @Override
    public boolean isValidMove(Position newPosition, final Board board) {
        int xDistance = Math.abs(newPosition.getRow() - this.getX());
        int yDistance = Math.abs(newPosition.getCol() - this.getY());

        return isWithinBounds(newPosition) && (xDistance == 0 || yDistance == 0);
    }
}