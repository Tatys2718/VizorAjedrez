package View;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ChessBoard extends JPanel {

    private JButton[][] buttons = new JButton[8][8];

    public ChessBoard() {
        setLayout(new GridLayout(8, 8));

        // Crear los botones y añadirlos al tablero y a la matriz
        for (int fila = 0; fila < 8; fila++) {

            for (int col = 0; col < 8; col++) {

                JButton casilla = new JButton();

                // Alternar colores como un tablero de ajedrez
                if ((fila + col) % 2 == 0) {
                    casilla.setBackground(new Color(125, 0, 32, 255));  // Casilla VINOTINTO
                    casilla.setBorder(new LineBorder(new Color(128, 0, 32), 2));
                } else {
                    casilla.setBackground(Color.BLACK);   // Casilla negra
                    casilla.setBorder(new LineBorder(Color.BLACK, 2));
                }

                buttons[fila][col] = casilla;  // Guardar el botón en la matriz

                this.add(casilla);      // Añadir el botón al panel
            }
        }
    }

    public JButton getCasilla(int fila, int col) {
        if (fila >= 0 && fila < 8 && col >= 0 && col < 8) {
            return buttons[fila][col];
        } else {
            throw new IndexOutOfBoundsException("Coordenadas fuera del tablero");
        }
    }
}
