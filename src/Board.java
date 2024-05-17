public class Board {
    private Piece[][] board;

    public Board() {
        board = new Piece[8][8];
        initializeBoard();
    }

    private void initializeBoard() {
        // Initialize white pieces
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn("Pawn", 1, i);
        }
        board[0][0] = new Rook("White",  0, 0);
        board[0][7] = new Rook("White",  0, 7);
        board[0][1] = new Knight("White",  0, 1);
        board[0][6] = new Knight("White",  0, 6);
        board[0][2] = new Bishop("White",  0, 2);
        board[0][5] = new Bishop("White",  0, 5);
        board[0][3] = new Queen("White",  0, 3);
        board[0][4] = new King("White",  0, 4);

        // Initialize black pieces
        for (int i = 0; i < 8; i++) {
            board[6][i] = new Pawn("Black", 6, i);
        }
        board[7][0] = new Rook("Black", 0, 7);
        board[7][7] = new Rook("Black", 7, 7);
        board[7][1] = new Knight("Black",  7, 1);
        board[7][6] = new Knight("Black", 7, 6);
        board[7][2] = new Bishop("Black",  7, 2);
        board[7][5] = new Bishop("Black",  7, 5);
        board[7][3] = new Queen("Black", 7, 3);
        board[7][4] = new King("Black",  7, 4);

        // Initialize empty spaces
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = null;
            }
        }
    }

    public void display() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print("- ");
                } else {
                    System.out.print(board[i][j].getName().charAt(0) + " ");
                }
            }
            System.out.println();
        }
    }

    public void movePiece(Piece piece, Position newPosition) {
        Position oldPosition = new Position(piece.getX(), piece.getY());
        if (isPositionEmpty(newPosition) && piece.isValidMove(newPosition)) {
            board[oldPosition.getRow()][oldPosition.getCol()] = null;
            board[newPosition.getRow()][newPosition.getCol()] = piece;
            piece.move(newPosition.getRow(), newPosition.getCol());
        } else {
            throw new IllegalArgumentException("Invalid move");
        }
    }

    public Piece getPieceAtPosition(Position position) {
        return board[position.getRow()][position.getCol()];
    }
    public boolean isPositionEmpty(Position position) {
        return board[position.getRow()][position.getCol()] == null;
    }
}