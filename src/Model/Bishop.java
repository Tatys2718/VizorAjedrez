package Model;

import javax.swing.*;

public class Bishop extends Piece {
    public Bishop(int positionRow, int positionColumn, boolean isWhite, ImageIcon image) {
        super(positionRow, positionColumn, isWhite, image);
    }

    @Override
    public boolean validMove(int destRow, int destColumn, Piece[][] pieces) {
        // Obtener la fila y columna actuales
        int currentRow = getPositionRow();
        int currentColumn = getPositionColumn();

        // Verificar que el destino esté en la misma diagonal
        if (Math.abs(destRow - currentRow) != Math.abs(destColumn - currentColumn)) {
            return false; // No se mueve en diagonal
        }

        // Determinar la dirección del movimiento
        int rowDirection = (destRow - currentRow) > 0 ? 1 : -1; // 1 si se mueve hacia abajo, -1 si hacia arriba
        int columnDirection = (destColumn - currentColumn) > 0 ? 1 : -1; // 1 si se mueve hacia la derecha, -1 si hacia la izquierda

        // Verificar si hay piezas bloqueando el camino
        int tempRow = currentRow + rowDirection;
        int tempColumn = currentColumn + columnDirection;
        while (tempRow != destRow && tempColumn != destColumn) {
            if (pieces[tempRow][tempColumn] != null) {
                return false; // Hay una pieza bloqueando el camino
            }
            tempRow += rowDirection;
            tempColumn += columnDirection;
        }

        // Verificar si la casilla de destino está ocupada
        Piece targetPiece = pieces[destRow][destColumn];
        // Si la casilla está vacía o tiene una pieza del oponente, el movimiento es válido
        return targetPiece == null || targetPiece.isRed() != this.isRed();
    }
    @Override
    public Piece clone() {
        return new Bishop(this.getPositionRow(), this.getPositionColumn(), this.isRed(), new ImageIcon(this.getImage().getImage()));
    }
}
