package ui;
import javax.swing.*;
import java.awt.*;

public class LoginBackgroundPanel extends JPanel {
    private Image fondo;

    public LoginBackgroundPanel() {
        //Esta línea asegura que cargue desde el classpath
        this.fondo = new ImageIcon(getClass().getResource("/ui/fondo.png")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Pintar imagen como fondo redimensionado
        g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);

        //Dibujar capa blanca semitransparente encima
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(new Color(255, 255, 255, 180)); // opacidad 180 de 255
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.dispose();
    }
}
