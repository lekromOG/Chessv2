public class Pawn extends Piece { // Pawn class that extends Piece
    private boolean hasMoved = false; // boolean variable hasMoved
    public Pawn(String color, int x, int y) { // Constructor
        super("Pawn", color, x, y); // Calls the constructor of the superclass
        this.hasMoved = false; // Sets hasMoved to false
    }

    @Override
    public boolean isValidMove(Position newPosition, final Board board) { // isValidMove Method
        if (super.getColor().equals("White")) { // If the piece is white
            if(!hasMoved && newPosition.getRow() == super.getX() + 2 && newPosition.getCol() == super.getY() && board.getPieceAtPosition(new Position(super.getX() + 1, super.getY())) == null) { // If the pawn hasn't moved and the new position is 2 rows down and there is no piece in the way
                hasMoved = true; // Set hasMoved to true
                return true; // Return true
            } else if (newPosition.getRow() == super.getX() + 1 && newPosition.getCol() == super.getY()) { // If the new position is 1 row down
                hasMoved = true; // Set hasMoved to true
                return true; // Return true
            } else if (newPosition.getRow() == super.getX() + 1 && newPosition.getCol() == super.getY() + 1) { // If the new position is 1 row down and 1 column to the right
                return true; // Return true
            } else if (newPosition.getRow() == super.getX() - 1 && newPosition.getCol() == super.getY() + 1) { // If the new position is 1 row up and 1 column to the right
                return true; // Return true
            }
        } else if (super.getColor().equals("Black")) { // If the piece is black
            if (!hasMoved && newPosition.getRow() == super.getX() - 2 && newPosition.getCol() == super.getY() && board.getPieceAtPosition(new Position(super.getX() - 1, super.getY())) == null) { // If the pawn hasn't moved and the new position is 2 rows up and there is no piece in the way
                hasMoved = true; // Set hasMoved to true
                return true; // Return true
            } else if (newPosition.getRow() == super.getX() - 1 && newPosition.getCol() == super.getY()) { // If the new position is 1 row up
                hasMoved = true; // Set hasMoved to true
                return true; // Return true
            } else if (newPosition.getRow() == super.getX() + 1 && newPosition.getCol() == super.getY() - 1) { // If the new position is 1 row down and 1 column to the left
                return true; // Return true
            } else if (newPosition.getRow() == super.getX() - 1 && newPosition.getCol() == super.getY() - 1) { // If the new position is 1 row up and 1 column to the left
                return true; // Return true
            }
        }
        return false; // Return false
    }

    @Override
    public void move(int x, int y) { // move Method
        super.move(x, y); // Calls the move method of the superclass
        this.hasMoved = true; // Set hasMoved to true
    }
}