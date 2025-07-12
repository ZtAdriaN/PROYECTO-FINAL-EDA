package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import model.*;
import tda.*;

public class PanelRegistro extends JPanel {
    private static int contadorExpedientes = 1;

    public PanelRegistro() {
        setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(8, 2, 5, 5));

        JLabel lblId = new JLabel("ID Expediente:");
        JTextField txtId = new JTextField();
        txtId.setEditable(true);

        JLabel lblPrioridad = new JLabel("Prioridad:");
        JComboBox<String> comboPrioridad = new JComboBox<>(new String[]{"Alta", "Media", "Baja"});

        JTextField txtDNI = new JTextField();
        JTextField txtNombre = new JTextField();
        JTextField txtTelefono = new JTextField();
        JTextField txtEmail = new JTextField();
        JTextField txtAsunto = new JTextField();
        JTextField txtDocumento = new JTextField();

        form.add(lblId); form.add(txtId);
        form.add(lblPrioridad); form.add(comboPrioridad);
        form.add(new JLabel("DNI:")); form.add(txtDNI);
        form.add(new JLabel("Nombre:")); form.add(txtNombre);
        form.add(new JLabel("Teléfono:")); form.add(txtTelefono);
        form.add(new JLabel("Email:")); form.add(txtEmail);
        form.add(new JLabel("Asunto:")); form.add(txtAsunto);
        form.add(new JLabel("Documento Referencia:")); form.add(txtDocumento);

        JButton btnRegistrar = new JButton("Registrar Trámite");

        btnRegistrar.addActionListener(e -> {
            String id = txtId.getText();
            String prioridad = (String) comboPrioridad.getSelectedItem();
            String dni = txtDNI.getText();
            String nombre = txtNombre.getText();
            String tel = txtTelefono.getText();
            String email = txtEmail.getText();
            String asunto = txtAsunto.getText();
            String docRef = txtDocumento.getText();

            Documento doc = new Documento("Ref", docRef);
            Interesado persona = new Interesado(nombre, dni);
            Dependencia dep = new Dependencia("Mesa de Partes", 1);

            Expediente expediente = new Expediente(id, prioridad, asunto, doc, persona, dep);
            ListaDobleExpedientes.agregar(expediente);

            JOptionPane.showMessageDialog(this, "Trámite registrado correctamente.");

            txtId.setText(""); txtDNI.setText(""); txtNombre.setText(""); txtTelefono.setText("");
            txtEmail.setText(""); txtAsunto.setText(""); txtDocumento.setText("");
        });

        add(form, BorderLayout.CENTER);
        add(btnRegistrar, BorderLayout.SOUTH);
    }
}
