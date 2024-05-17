public abstract class Piece {
    private String name;
    private String color;
    private int x;
    private int y;
    private boolean isAlive;

    public Piece(String name, String color, int x, int y) {
        this.name = name;
        this.color = color;
        this.x = x;
        this.y = y;
        this.isAlive = true;
    }

    public abstract boolean isValidMove(Position newPosition, final Board board);

    protected boolean isWithinBounds(Position position) {
        return position.getRow() >= 0 && position.getRow() < 8 &&
                position.getCol() >= 0 && position.getCol() < 8;
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void kill() {
        this.isAlive = false;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isAlive() {
        return isAlive;
    }
}
