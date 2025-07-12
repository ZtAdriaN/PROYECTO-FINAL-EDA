package ui;
import javax.swing.*;
import java.awt.*;

public class SistemaTabbedFrame extends JFrame {
    public SistemaTabbedFrame() {
        setTitle("Sistema de Trámite ULima - Panel Principal");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabs = new JTabbedPane();

        tabs.addTab("Registro de Expediente", new PanelRegistro());
        tabs.addTab("Seguimiento de Expediente", new PanelSeguimiento());
        tabs.addTab("Finalización de Trámite", new PanelFinalizacion());
        tabs.addTab("Alertas Automáticas", new PanelAlertas());

        add(tabs);
    }
}
