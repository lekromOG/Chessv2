import java.util.Scanner; // Import the Scanner class

public class Main { // Main class
    public static Board board = new Board(); // Create a new Board object
    public static void main(String[] args) { // main Method
        String currentPlayer = "White"; // The current player is white
        Scanner scanner = new Scanner(System.in); // Create a new Scanner object

        while (true) { // Infinite loop
            board.display(); // Display the board
            Piece pieceToMove = null; // Initialize pieceToMove to null
            Position newPosition = null; // Initialize newPosition to null

            while (pieceToMove == null || newPosition == null) { // While pieceToMove is null or newPosition is null
                if (pieceToMove == null) { // If pieceToMove is null
                    System.out.println(currentPlayer + "'s turn. Enter piece to move (format: x1,y1):"); // Print the current player's turn and prompt the user to enter the piece to move
                    String input = scanner.nextLine(); // Read the user's input
                    String[] piecePosition = input.split(","); // Split the input by commas
                    int pieceX = Integer.parseInt(piecePosition[0]); // Parse the x position
                    int pieceY = Integer.parseInt(piecePosition[1]); // Parse the y position
                    System.out.println("pieceX: " + pieceX + ", pieceY: " + pieceY); // Print the x and y positions
                    pieceToMove = board.getPieceAtPosition(new Position(pieceX, pieceY)); // Get the piece at the specified position
                    System.out.println("name: " + pieceToMove.getName() + ", color: " + pieceToMove.getColor() + ", x: " + pieceToMove.getX() + ", y: " + pieceToMove.getY() + ", isAlive: " + pieceToMove.isAlive());  // Print the piece's name, color, x position, y position, and whether it's alive

                    if (pieceToMove == null || !pieceToMove.getColor().equals(currentPlayer)) { // If the piece is null or the piece's color is not the current player's color
                        System.out.println("Invalid piece selection, try again."); // Print "Invalid piece selection, try again."
                        pieceToMove = null; // Set pieceToMove to null
                    }  // If the piece is null or the piece's color is not the current player's color
                } else { // If pieceToMove is not null
                    System.out.println("Enter new position for " + pieceToMove.getName() + " (format: x2,y2):"); // Print "Enter new position for [piece name] (format: x2,y2):"
                    String input = scanner.nextLine(); // Read the user's input
                    String[] movePosition = input.split(","); // Split the input by commas
                    int moveX = Integer.parseInt(movePosition[0]); // Parse the x position
                    int moveY = Integer.parseInt(movePosition[1]); // Parse the y position
                    newPosition = new Position(moveX, moveY); // Create a new Position object with the parsed x and y positions

                    if (!pieceToMove.isValidMove(newPosition, board)) { // If the move is not valid
                        System.out.println("Invalid move, try again."); // Print "Invalid move, try again."
                        newPosition = null; // Set newPosition to null
                        pieceToMove = null; // Set pieceToMove to null
                        continue; // Continue to the next iteration of the loop
                    }

                    if (!board.isPositionEmpty(newPosition)) { // If the new position is not empty
                        Piece pieceAtNewPosition = board.getPieceAtPosition(newPosition); // Get the piece at the new position
                        if (pieceAtNewPosition.getColor().equals(currentPlayer)) { // If the piece at the new position is the same color as the current player
                            System.out.println("Cannot capture your own piece, try again."); // Print "Cannot capture your own piece, try again."
                            newPosition = null; // Set newPosition to null
                            pieceToMove = null; // Set pieceToMove to null
                        }else{ // If the piece at the new position is not the same color as the current player
                            pieceAtNewPosition.kill(); // Kill the piece at the new position
                        }
                    }
                }


            }

            try { // Try block
                board.movePiece(pieceToMove, newPosition);  // Move the piece to the new position
            } catch (IllegalArgumentException e) { // Catch block for IllegalArgumentException
                System.out.println(e.getMessage()); // Print the exception message
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