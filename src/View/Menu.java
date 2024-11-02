package View;
import javax.swing.*;
import java.awt.*;
public class Menu extends JPanel {
    private JButton next;
    private JButton prev;
    public Menu() {
        setLayout(null);
        next = new JButton("Next");
        prev = new JButton("Prev");

        next.setContentAreaFilled(true);
        next.setBorderPainted(true);
        next.setFocusPainted(false);

        prev.setContentAreaFilled(true);
        prev.setBorderPainted(true);
        prev.setFocusPainted(false);

        // Asegurar un color visible para el texto
        next.setForeground(Color.RED);
        prev.setForeground(Color.RED);

        next.setFont(new Font("Times new roman", Font.BOLD, 15));
        prev.setFont(new Font("Times new roman", Font.BOLD, 15));

        next.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        prev.setBorder(BorderFactory.createLineBorder(Color.RED, 2));

        // Establecer color de fondo de ser necesario
        next.setBackground(Color.BLACK);
        prev.setBackground(Color.BLACK);

        // Establecer tamaño y posición del botón
        next.setBounds(170,70,80,58);
        prev.setBounds(170,140,80,58);

        // Registrar los botones para escuchar eventos de clic
        this.add(next);
        this.add(prev);

        next.setVisible(true);
        prev.setVisible(true);
    }
    public void paintComponent(Graphics g) {
        Dimension tamanio = getSize();
        ImageIcon imagen = new ImageIcon(new ImageIcon(getClass().getResource("/View/utils/images/menuBotoneAjedrez.png")).getImage());
        g.drawImage(imagen.getImage(), 0, 0, tamanio.width, tamanio.height, null);
    }
    public JButton getNextButton() {
        return next;
    }
    public JButton getPrevButton() {
        return prev;
    }
}
