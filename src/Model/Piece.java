package Model;
import javax.swing.*;

public abstract class Piece {
    private int positionRow;
    private int positionColumn;
    private ImageIcon image;
    private boolean isRed;

    public Piece(){};

    public Piece(int positionRow, int positionColumn, boolean isWhite, ImageIcon image){
        this.positionRow = positionRow;
        this.positionColumn = positionColumn;
        this.isRed = isWhite;
        this.image = image;
    }

    
    public boolean validMove (int destRow, int destColumn, Piece[][] pieces){
        return true;
    };
    //El movimiento que debe tener la ficha

    public void changePosition(int positionRow, int positionColumn){
        this.positionRow = positionRow;
        this.positionColumn = positionColumn;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public ImageIcon getImage(){
        return image;
    }


    public int getPositionRow() {
        return positionRow;
    }

    public int getPositionColumn() {
        return positionColumn;
    }

    public boolean isRed() {
        return isRed;
    }

    public abstract Piece clone();
}
