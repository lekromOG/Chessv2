public class Position { // This class is used to represent a position on the board
    private int row; // The row of the position
    private int col; // The column of the position

    public Position(int row, int col) { // Constructor
        this.row = row; // The row of the position
        this.col = col; // The column of the position
    }

    public int getRow() {
        return row;
    } // getRow Method

    public int getCol() {
        return col;
    } // getCol Method
}
