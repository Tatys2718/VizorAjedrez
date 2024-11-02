package Model;

import javax.swing.*;

public class Pawn extends Piece{
    public Pawn(){};

    public Pawn(int positionRow, int positionColumn, boolean isRed, ImageIcon image) {
        super(positionRow, positionColumn, isRed, image);
    }

    @Override
    public boolean validMove(int destRow, int destColumn, Piece[][] pieces) {
        // Movimiento hacia adelante de 1 o 2 casillas desde la posición inicial
        int rowDirection = isRed() ? 1 : -1;

        // Obtener la fila y columna actuales
        int currentRow = getPositionRow();
        int currentColumn = getPositionColumn();

        // Movimiento de 1 casilla adelante
        if (currentColumn == destColumn && currentRow + rowDirection == destRow) {
            return true;
        }

        // Movimiento de 2 casillas adelante desde la posición inicial
        if ((isRed() && currentRow == 1) || (!isRed() && currentRow == 6)) {
            // Asegúrate de que el movimiento hacia dos filas adelante es válido
            if (currentColumn == destColumn && currentRow + 2 * rowDirection == destRow) {
                return true;
            }
        }

        // Movimiento de captura en diagonal
        if (Math.abs(currentColumn - destColumn) == 1 && currentRow + rowDirection == destRow) {
            // Verificar si hay una pieza en la posición diagonal
            Piece targetPiece = pieces[destRow][destColumn];
            if (targetPiece != null && targetPiece.isRed() != this.isRed()) {
                return true;
            }
        }

        return false;
    }
    @Override
    public Piece clone() {
        return new Pawn(this.getPositionRow(), this.getPositionColumn(), this.isRed(), new ImageIcon(this.getImage().getImage()));
    }


}
