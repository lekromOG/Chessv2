import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        String currentPlayer = "White";
        Scanner scanner = new Scanner(System.in);

        while (board.getPieceAtPosition(new Position(0, 4)).isAlive() && board.getPieceAtPosition(new Position(7, 4)).isAlive()) {
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
                    pieceToMove = board.getPieceAtPosition(new Position(pieceX, pieceY));

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

                    if (!pieceToMove.isValidMove(newPosition) || !board.isPositionEmpty(newPosition)) {
                        System.out.println("Invalid move, try again.");
                        newPosition = null;
                        pieceToMove = null;  // Add this line
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
        }

        board.display();
        System.out.println("Game over!");
    }
}