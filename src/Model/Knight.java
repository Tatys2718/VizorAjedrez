package Model;
import javax.swing.*;

public class Knight extends Piece{
    public Knight(int positionRow, int positionColumn, boolean isWhite, ImageIcon image) {

        super(positionRow, positionColumn, isWhite, image);
    }

    @Override
    public boolean validMove(int destRow, int destColumn, Piece[][] pieces) {
        // Obtener la fila y columna actuales
        int currentRow = getPositionRow();
        int currentColumn = getPositionColumn();

        // Calcular las diferencias de fila y columna
        int rowDifference = Math.abs(destRow - currentRow);
        int columnDifference = Math.abs(destColumn - currentColumn);

        // Verificar el movimiento en "L"
        if ((rowDifference == 2 && columnDifference == 1) || (rowDifference == 1 && columnDifference == 2)) {
            // Verificar si la casilla de destino está ocupada
            Piece targetPiece = pieces[destRow][destColumn];
            // Si la casilla está vacía o tiene una pieza del oponente, el movimiento es válido
            return targetPiece == null || targetPiece.isRed() != this.isRed();
        }

        // Si el movimiento no es válido según las reglas del caballo, devolver false
        return false;
    }
    @Override
    public Piece clone() {
        return new Knight(this.getPositionRow(), this.getPositionColumn(), this.isRed(), new ImageIcon(this.getImage().getImage()));
    }

}
