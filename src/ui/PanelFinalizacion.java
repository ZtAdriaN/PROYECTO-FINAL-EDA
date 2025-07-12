package ui;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import model.Expediente;
import tda.ListaDobleExpedientes;
import tda.NodoDoble;

public class PanelFinalizacion extends JPanel {
    private JTextField txtId;
    private JTextArea datosExpediente;
    private JTextField txtDocumentoFinal;
    private JLabel lblFechaFinal;
    private Expediente expedienteActual; // Guardamos el expediente encontrado

    public PanelFinalizacion() {
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout());
        txtId = new JTextField(10);
        JButton btnBuscar = new JButton("Buscar");

        topPanel.add(new JLabel("ID Expediente:"));
        topPanel.add(txtId);
        topPanel.add(btnBuscar);

        datosExpediente = new JTextArea(8, 40);
        datosExpediente.setEditable(false);
        JScrollPane scroll = new JScrollPane(datosExpediente);

        JPanel centerPanel = new JPanel(new GridLayout(3, 2));
        txtDocumentoFinal = new JTextField();
        lblFechaFinal = new JLabel("No finalizado");

        JButton btnFinalizar = new JButton("Marcar como Finalizado");

        centerPanel.add(new JLabel("Documento Final:"));
        centerPanel.add(txtDocumentoFinal);
        centerPanel.add(new JLabel("Fecha Finalización:"));
        centerPanel.add(lblFechaFinal);
        centerPanel.add(new JLabel(""));
        centerPanel.add(btnFinalizar);

        // Acción Buscar
        btnBuscar.addActionListener(e -> {
            String id = txtId.getText().trim();
            expedienteActual = null;

            NodoDoble<Expediente> nodo = ListaDobleExpedientes.obtener().getCabeza();
            while (nodo != null) {
                if (nodo.valor.getId().equalsIgnoreCase(id)) {
                    expedienteActual = nodo.valor;
                    break;
                }
                nodo = nodo.siguiente;
            }

            if (expedienteActual != null) {
                datosExpediente.setText("ID: " + expedienteActual.getId() + "\n"
                        + "Prioridad: " + expedienteActual.getPrioridad() + "\n"
                        + "Asunto: " + expedienteActual.getAsunto() + "\n"
                        + "Interesado: " + expedienteActual.getInteresado().getNombre() + "\n"
                        + "Documento: " + expedienteActual.getDocumento().getReferencia() + "\n"
                        + "Estado: " + (expedienteActual.isFinalizado() ? "Finalizado" : "En proceso"));
                lblFechaFinal.setText(expedienteActual.isFinalizado()
                        ? expedienteActual.getFechaHoraFin().toString() : "No finalizado");
            } else {
                datosExpediente.setText("Expediente no encontrado.");
                lblFechaFinal.setText("No finalizado");
            }
        });

        // Acción Finalizar
        btnFinalizar.addActionListener(e -> {
            if (expedienteActual != null && !expedienteActual.isFinalizado()) {
                expedienteActual.marcarFinalizado();
                expedienteActual.getDocumento().setResultado(txtDocumentoFinal.getText());
                String fecha = LocalDateTime.now().toString();
                lblFechaFinal.setText(fecha);
                JOptionPane.showMessageDialog(this, "Expediente marcado como finalizado.");
            } else {
                JOptionPane.showMessageDialog(this, "Debe buscar un expediente válido o ya está finalizado.");
            }
        });

        add(topPanel, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.SOUTH);
    }
}
