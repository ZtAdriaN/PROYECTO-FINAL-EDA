import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import model.*;

public class SistemaFrame extends JFrame {
    public SistemaFrame() {
        setTitle("Registro de Trámite - ULima");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 2, 5, 5));

        JTextField txtId = new JTextField();
        JTextField txtPrioridad = new JTextField();
        JTextField txtDNI = new JTextField();
        JTextField txtNombre = new JTextField();
        JTextField txtTelefono = new JTextField();
        JTextField txtEmail = new JTextField();
        JTextField txtAsunto = new JTextField();
        JTextField txtDocumento = new JTextField();
        JLabel lblInicio = new JLabel(LocalDateTime.now().toString());
        JLabel lblFin = new JLabel("No finalizado");

        panel.add(new JLabel("ID Expediente:"));
        panel.add(txtId);
        panel.add(new JLabel("Prioridad:"));
        panel.add(txtPrioridad);
        panel.add(new JLabel("DNI Interesado:"));
        panel.add(txtDNI);
        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);
        panel.add(new JLabel("Teléfono:"));
        panel.add(txtTelefono);
        panel.add(new JLabel("Email:"));
        panel.add(txtEmail);
        panel.add(new JLabel("Asunto:"));
        panel.add(txtAsunto);
        panel.add(new JLabel("Documento:"));
        panel.add(txtDocumento);
        panel.add(new JLabel("Inicio:"));
        panel.add(lblInicio);
        panel.add(new JLabel("Finalización:"));
        panel.add(lblFin);

        JButton btnRegistrar = new JButton("Registrar Trámite");
        btnRegistrar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Trámite registrado correctamente.");
            lblFin.setText(LocalDateTime.now().toString());
        });

        add(panel, BorderLayout.CENTER);
        add(btnRegistrar, BorderLayout.SOUTH);
    }
}