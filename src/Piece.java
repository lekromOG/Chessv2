public abstract class Piece {
    private String name; // "Pawn", "Knight", "Bishop", "Rook", "Queen", "King"
    private String color; // "White", "Black"
    private int x;
    private int y;
    private boolean isAlive; // true, false

    public Piece(String name, String color, int x, int y) { // Constructor
        this.name = name; // "Pawn", "Knight", "Bishop", "Rook", "Queen", "King"
        this.color = color; // "White", "Black"
        this.x = x;
        this.y = y;
        this.isAlive = true; // true
    }

    public abstract boolean isValidMove(Position newPosition, final Board board); // Abstract method

    protected boolean isWithinBounds(Position position) { // Helper method can be used by all subclasses
        return position.getRow() >= 0 && position.getRow() < 8 &&
                position.getCol() >= 0 && position.getCol() < 8;
    }

    public void move(int x, int y) { // move Method
        this.x = x;
        this.y = y;
    }

    public void kill() {
        this.isAlive = false;
    } // kill Method

    public String getName() {
        return name;
    } // getName Method

    public String getColor() {
        return color;
    } // getColor Method

    public int getX() {
        return x;
    } // getX Method

    public int getY() {
        return y;
    } // getY Method

    public boolean isAlive() {
        return isAlive;
    } // isAlive Method
}
