package Model;

import javax.swing.*;

public class King extends Piece{
    public King(int positionRow, int positionColumn, boolean isWhite, ImageIcon image) {
        super(positionRow, positionColumn, isWhite, image);
    }

    @Override
    public boolean validMove(int destRow, int destColumn, Piece[][] pieces) {
        // Obtener la fila y columna actuales
        int currentRow = getPositionRow();
        int currentColumn = getPositionColumn();

        // Verificar que el movimiento es de una sola casilla en cualquier dirección
        if (Math.abs(destRow - currentRow) <= 1 && Math.abs(destColumn - currentColumn) <= 1) {
            // Verificar si la casilla de destino está ocupada por una pieza del mismo color
            Piece targetPiece = pieces[destRow][destColumn];
            return targetPiece == null || targetPiece.isRed() != this.isRed();
        }
        return false; // Movimiento no válido
    }
    @Override
    public Piece clone() {
        return new King(this.getPositionRow(), this.getPositionColumn(), this.isRed(), new ImageIcon(this.getImage().getImage()));
    }
}
