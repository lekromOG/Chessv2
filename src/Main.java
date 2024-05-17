import java.util.Scanner;

public class Main {
    public static Board board = new Board();
    public static void main(String[] args) {
        String currentPlayer = "White";
        Scanner scanner = new Scanner(System.in);

        while (true) {
            board.display();
            Piece pieceToMove = null;
            Position newPosition = null;

            while (pieceToMove == null || newPosition == null) {
                if (pieceToMove == null) {
                    System.out.println(currentPlayer + "'s turn. Enter piece to move (format: x1,y1):");
                    String input = scanner.nextLine();
                    String[] piecePosition = input.split(",");
                    int pieceX = Integer.parseInt(piecePosition[0]);
                    int pieceY = Integer.parseInt(piecePosition[1]);
                    System.out.println("pieceX: " + pieceX + ", pieceY: " + pieceY);
                    pieceToMove = board.getPieceAtPosition(new Position(pieceX, pieceY));
                    System.out.println("name: " + pieceToMove.getName() + ", color: " + pieceToMove.getColor() + ", x: " + pieceToMove.getX() + ", y: " + pieceToMove.getY() + ", isAlive: " + pieceToMove.isAlive());

                    if (pieceToMove == null || !pieceToMove.getColor().equals(currentPlayer)) {
                        System.out.println("Invalid piece selection, try again.");
                        pieceToMove = null;
                    }
                } else {
                    System.out.println("Enter new position for " + pieceToMove.getName() + " (format: x2,y2):");
                    String input = scanner.nextLine();
                    String[] movePosition = input.split(",");
                    int moveX = Integer.parseInt(movePosition[0]);
                    int moveY = Integer.parseInt(movePosition[1]);
                    newPosition = new Position(moveX, moveY);

                    if (!pieceToMove.isValidMove(newPosition, board)) {
                        System.out.println("Invalid move, try again.");
                        newPosition = null;
                        pieceToMove = null;
                        continue;
                    }

                    if (!board.isPositionEmpty(newPosition)) {
                        Piece pieceAtNewPosition = board.getPieceAtPosition(newPosition);
                        if (pieceAtNewPosition.getColor().equals(currentPlayer)) {
                            System.out.println("Cannot capture your own piece, try again.");
                            newPosition = null;
                            pieceToMove = null;
                        }else{
                            pieceAtNewPosition.kill();
                        }
                    }
                }


            }

            try {
                board.movePiece(pieceToMove, newPosition);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            // Switch players
            currentPlayer = currentPlayer.equals("White") ? "Black" : "White";
            checkIfBlackKingIsAlive();
            checkIfWhiteKingIsAlive();
            if(!checkIfWhiteKingIsAlive()){
                System.out.println("Black wins");
                break;
            }else if(!checkIfBlackKingIsAlive()){
                System.out.println("White wins");
                break;
            }
        }
    }
    public static boolean checkIfWhiteKingIsAlive(){
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (board.board[i][j] != null && board.board[i][j].getName().equals("King") && board.board[i][j].getColor().equals("White")) {
                        return true;
                    }
                }
            }
        return false;
    }
    public static boolean checkIfBlackKingIsAlive(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board.board[i][j] != null && board.board[i][j].getName().equals("King") && board.board[i][j].getColor().equals("Black")) {
                    return true;
                }
            }
        }
        return false;
    }
}