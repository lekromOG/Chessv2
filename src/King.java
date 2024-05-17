public class King extends Piece {
    public King(String color, int x, int y) {
        super("King", color, x, y);
    }

    @Override
    public boolean isValidMove(Position newPosition, final Board board) {
        int xDistance = Math.abs(newPosition.getRow() - this.getX());
        int yDistance = Math.abs(newPosition.getCol() - this.getY());

        return isWithinBounds(newPosition) && (xDistance <= 1 && yDistance <= 1);
    }
}