package Controller;
import View.Menu;
import Utils.Sonido;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuController implements ActionListener {
    private Menu menu;
    private ReaderPGN readerPGN;
    private ChessController chessController;
    private int contadorClicks = 0;
    private boolean isRewinding = false; // Indica si estamos retrocediendo
    private Sonido musica;
    private Sonido click;

    public MenuController(Menu menu, ReaderPGN readerPGN, ChessController chessController) {
        this.menu = menu;
        this.readerPGN = readerPGN;
        this.chessController = chessController;

        musica = new Sonido("/Resources/multimedia/ajedrezMusic.wav");
        click = new Sonido("/Resources/multimedia/sonidoClick.wav");
        musica.reproducirEnBucle();

        // Registrar los escuchadores de los botones
        this.menu.getNextButton().addActionListener(this);
        this.menu.getPrevButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menu.getNextButton()) {
            click.reproducir();
            if (contadorClicks < readerPGN.getMovements().size()) {
//                MoveController moveController = new MoveController();
                if (isRewinding) {
                    // Si estamos en modo retroceso, no duplicamos en el historial
                    chessController.setSkippingHistory(true);
                    isRewinding = false; // Resetear la bandera de retroceso
                }
                System.out.println("MOVIMIENTO OBTENIDO:" + readerPGN.getMovements().get(contadorClicks)
                        + "==========================================================================");
                chessController.movePiece(readerPGN.getMovements().get(contadorClicks), contadorClicks);
                chessController.setSkippingHistory(false);
                contadorClicks++;
            }else{
                System.out.println("No hay más movimientos.");
            }
        } else if (e.getSource() == menu.getPrevButton()) {
            click.reproducir();
            if (contadorClicks > 0) {
                chessController.undoMove();
                contadorClicks--; // Ajusta el contador para retroceder correctamente
                isRewinding = true;
            } else {
                System.out.println("No hay movimientos previos.");
        }
    }
    }
}
