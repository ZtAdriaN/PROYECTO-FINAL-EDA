package ui;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class PanelSeguimiento extends JPanel {
    private JTextArea historialArea;
    private JTextField txtIdBuscar;
    private JTextField txtNuevaDep;

    public PanelSeguimiento() {
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout());
        txtIdBuscar = new JTextField(10);
        JButton btnBuscar = new JButton("Buscar");

        topPanel.add(new JLabel("ID Expediente:"));
        topPanel.add(txtIdBuscar);
        topPanel.add(btnBuscar);

        historialArea = new JTextArea(10, 50);
        historialArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(historialArea);

        JPanel bottomPanel = new JPanel(new FlowLayout());
        txtNuevaDep = new JTextField(15);
        JButton btnAñadir = new JButton("Añadir Movimiento");

        bottomPanel.add(new JLabel("Nueva Dependencia:"));
        bottomPanel.add(txtNuevaDep);
        bottomPanel.add(btnAñadir);

        btnBuscar.addActionListener(e -> {
            String id = txtIdBuscar.getText();
            historialArea.setText("Historial del expediente " + id + ":\n");
            historialArea.append("Recepcionado en Mesa de Partes - " + LocalDateTime.now() + "\n");
        });

        btnAñadir.addActionListener(e -> {
            String nuevaDep = txtNuevaDep.getText();
            historialArea.append("Movido a " + nuevaDep + " - " + LocalDateTime.now() + "\n");
            txtNuevaDep.setText("");
        });

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }
}
