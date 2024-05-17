public class Pawn extends Piece {
    private boolean hasMoved = false;
    public Pawn(String color, int x, int y) {
        super("Pawn", color, x, y);
        this.hasMoved = false;
    }

    @Override
    public boolean isValidMove(Position newPosition, final Board board) {
        if (super.getColor().equals("White")) {
            System.out.println(super.getX() + " " + super.getY() + " " + newPosition.getRow() + " " + newPosition.getCol());
            System.out.println(hasMoved);
            if(!hasMoved) {
                if (newPosition.getRow() == super.getX() + 2 && newPosition.getCol() == super.getY()) {
                    hasMoved = true;
                    return true;
                } else if (newPosition.getRow() == super.getX() + 1 && newPosition.getCol() == super.getY()) {
                    hasMoved = true;
                    return true;
                } else if (newPosition.getRow() == super.getX() + 1 && newPosition.getCol() == super.getY() + 1) {
                    return true;
                } else if (newPosition.getRow() == super.getX() - 1 && newPosition.getCol() == super.getY() + 1) {
                    return true;
                }
            }
        } else if (super.getColor().equals("Black")) {
            if (!hasMoved && newPosition.getRow() == super.getX() - 2 && newPosition.getCol() == super.getY()) {
                hasMoved = true;
                return true;
            } else if (newPosition.getRow() == super.getX() - 1 && newPosition.getCol() == super.getY()) {
                hasMoved = true;
                return true;
            } else if (newPosition.getRow() == super.getX() + 1 && newPosition.getCol() == super.getY() - 1) {
                return true;
            } else if (newPosition.getRow() == super.getX() - 1 && newPosition.getCol() == super.getY() - 1) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void move(int x, int y) {
        super.move(x, y);
        this.hasMoved = true;
    }
}