package Model;

public class Move {
    private Piece origin;
    private int destinoCol;
    private int destinoRow;

    public Move(Piece origin, int destinoCol, int destinoRow) {
        this.origin = origin;
        this.destinoCol = destinoCol;
        this.destinoRow = destinoRow;
    }

    public Piece getOrigin() {return origin;}

    public int getDestinoCol() {
        return destinoCol;
    }

    public int getDestinoRow() {
        return destinoRow;
    }

    @Override
    public String toString() {
        return " to " + destinoCol + "," + destinoRow;
    }
}

