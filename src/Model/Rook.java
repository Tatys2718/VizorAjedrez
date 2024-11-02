package Model;

import javax.swing.*;

public class Rook extends Piece{
    public Rook(int positionRow, int positionColumn, boolean isWhite, ImageIcon image) {
        super(positionRow, positionColumn, isWhite, image);
    }

    @Override
    public boolean validMove(int destRow, int destColumn, Piece[][] pieces) {
        // Obtener la fila y columna actuales
        int currentRow = getPositionRow();
        int currentColumn = getPositionColumn();

        // Verificar que el movimiento es vertical u horizontal
        if (currentRow == destRow || currentColumn == destColumn) {
            // Verificar si hay piezas bloqueando el camino
            int rowDirection = (destRow - currentRow) == 0 ? 0 : (destRow - currentRow) > 0 ? 1 : -1;
            int columnDirection = (destColumn - currentColumn) == 0 ? 0 : (destColumn - currentColumn) > 0 ? 1 : -1;

            int tempRow = currentRow + rowDirection;
            int tempColumn = currentColumn + columnDirection;

            while (tempRow != destRow || tempColumn != destColumn) {
                if (pieces[tempRow][tempColumn] != null) {
                    return false; // Hay una pieza bloqueando el camino
                }
                tempRow += rowDirection;
                tempColumn += columnDirection;
            }

            // Verificar si la casilla de destino está ocupada
            Piece targetPiece = pieces[destRow][destColumn];
            return targetPiece == null || targetPiece.isRed() != this.isRed();
        }
        return false; // Movimiento no válido
    }
    @Override
    public Piece clone() {
        return new Rook(this.getPositionRow(), this.getPositionColumn(), this.isRed(), new ImageIcon(this.getImage().getImage()));
    }
}
