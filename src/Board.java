public class Board { // Board class
    public Piece[][] board; // 2D array of Piece objects

    public Board() { // Constructor
        board = new Piece[8][8]; // 8x8 board
        initializeBoard(); // Initialize the board
    }

    private void initializeBoard() { // initializeBoard Method
        // Initialize white pieces
        for (int i = 0; i < 8; i++) { // Loop through the columns
            board[1][i] = new Pawn("White", 1, i); // Create a new white pawn at row 1 and column i
        }
        board[0][0] = new Rook("White",  0, 0); // Create a new white rook at row 0 and column 0
        board[0][7] = new Rook("White",  0, 7); // Create a new white rook at row 0 and column 7
        board[0][1] = new Knight("White",  0, 1); // Create a new white knight at row 0 and column 1
        board[0][6] = new Knight("White",  0, 6); // Create a new white knight at row 0 and column 6
        board[0][2] = new Bishop("White",  0, 2); // Create a new white bishop at row 0 and column 2
        board[0][5] = new Bishop("White",  0, 5); // Create a new white bishop at row 0 and column 5
        board[0][3] = new Queen("White",  0, 3); // Create a new white queen at row 0 and column 3
        board[0][4] = new King("White",  0, 4); // Create a new white king at row 0 and column 4

        // Initialize black pieces
        for (int i = 0; i < 8; i++) { // Loop through the columns
            board[6][i] = new Pawn("Black", 6, i); // Create a new black pawn at row 6 and column i
        }
        board[7][0] = new Rook("Black", 0, 7); // Create a new black rook at row 7 and column 0
        board[7][7] = new Rook("Black", 7, 7); // Create a new black rook at row 7 and column 7
        board[7][1] = new Knight("Black",  7, 1); // Create a new black knight at row 7 and column 1
        board[7][6] = new Knight("Black", 7, 6); // Create a new black knight at row 7 and column 6
        board[7][2] = new Bishop("Black",  7, 2); // Create a new black bishop at row 7 and column 2
        board[7][5] = new Bishop("Black",  7, 5); // Create a new black bishop at row 7 and column 5
        board[7][3] = new Queen("Black", 7, 3); // Create a new black queen at row 7 and column 3
        board[7][4] = new King("Black",  7, 4); // Create a new black king at row 7 and column 4

        // Initialize empty spaces
        for (int i = 2; i < 6; i++) { // Loop through the rows
            for (int j = 0; j < 8; j++) { // Loop through the columns
                board[i][j] = null; // Set the space to null
            }
        }
    }

    public void display() { // display Method
        for (int i = 0; i < 8; i++) { // Loop through the rows
            for (int j = 0; j < 8; j++) {   // Loop through the columns
                if (board[i][j] == null) { // If the space is empty
                    System.out.print(" - "); // Print a dash
                } else { // If the space is not empty
                    System.out.print(String.valueOf(board[i][j].getName().charAt(0)) + String.valueOf(board[i][j].getColor().charAt(0) + " ")); // Print the first letter of the piece's name and the first letter of the piece's color
                }
            }
            System.out.println(); // Print a new line
        }
    }

    public void movePiece(Piece piece, Position newPosition) { // movePiece Method
        Position oldPosition = new Position(piece.getX(), piece.getY()); // Create a new Position object with the piece's current position
        board[oldPosition.getRow()][oldPosition.getCol()] = null; // Set the old position to null
        board[newPosition.getRow()][newPosition.getCol()] = piece; // Set the new position to the piece
        piece.move(newPosition.getRow(), newPosition.getCol()); // Move the piece to the new position
    }

    public Piece getPieceAtPosition(Position position) {
        return board[position.getRow()][position.getCol()];
    } // getPieceAtPosition Method
    public boolean isPositionEmpty(Position position) {
        return board[position.getRow()][position.getCol()] == null;
    } // isPositionEmpty Method
}