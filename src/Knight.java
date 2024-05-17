public class Knight extends Piece {
    public Knight(String color, int x, int y) {
        super("Knight", color, x, y);
    }

    @Override
    public boolean isValidMove(Position newPosition, final Board board) {
        int xDistance = Math.abs(newPosition.getRow() - this.getX());
        int yDistance = Math.abs(newPosition.getCol() - this.getY());

        return isWithinBounds(newPosition) && ((xDistance == 2 && yDistance == 1) || (xDistance == 1 && yDistance == 2));
    }
}