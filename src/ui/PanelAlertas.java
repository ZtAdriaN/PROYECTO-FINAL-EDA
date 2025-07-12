package ui;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import model.Expediente;
import tda.*;

public class PanelAlertas extends JPanel {
    private JTable tabla;
    private DefaultTableModel modelo;

    public PanelAlertas() {
        setLayout(new BorderLayout());

        modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Prioridad");
        modelo.addColumn("Fecha de Registro");

        tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);

        JButton btnRefrescar = new JButton("Refrescar Alertas");

        btnRefrescar.addActionListener(e -> {
            modelo.setRowCount(0);
            ListaDoble<Expediente> lista = ListaDobleExpedientes.obtener();

            ListaDoble<Expediente> alertas = new ListaDoble<>();
            NodoDoble<Expediente> actual = lista.getCabeza();
            while (actual != null) {
                Expediente exp = actual.valor;
                if (!exp.isFinalizado()) {
                    insertarOrdenado(alertas, exp);
                }
                actual = actual.siguiente;
            }

            NodoDoble<Expediente> nodo = alertas.getCabeza();
            while (nodo != null) {
                Expediente exp = nodo.valor;
                modelo.addRow(new Object[]{
                    exp.getId(), exp.getPrioridad(), exp.getFechaHoraInicio().toString()
                });
                nodo = nodo.siguiente;
            }
        });

        add(scroll, BorderLayout.CENTER);
        add(btnRefrescar, BorderLayout.SOUTH);
    }

    private void insertarOrdenado(ListaDoble<Expediente> lista, Expediente nuevo) {
        NodoDoble<Expediente> nuevoNodo = new NodoDoble<>(nuevo);

        if (lista.getCabeza() == null) {
            lista.setCabeza(nuevoNodo);
            return;
        }

        NodoDoble<Expediente> actual = lista.getCabeza();
        NodoDoble<Expediente> anterior = null;

        while (actual != null) {
            Expediente existente = actual.valor;
            int cmp = compararPrioridad(nuevo.getPrioridad(), existente.getPrioridad());

            if (cmp < 0 || (cmp == 0 && nuevo.getFechaHoraInicio().isBefore(existente.getFechaHoraInicio()))) {
                break;
            }
            anterior = actual;
            actual = actual.siguiente;
        }

        if (anterior == null) {
            nuevoNodo.siguiente = lista.getCabeza();
            lista.setCabeza(nuevoNodo);
        } else {
            nuevoNodo.siguiente = actual;
            anterior.siguiente = nuevoNodo;
        }
    }

    private int compararPrioridad(String p1, String p2) {
        return prioridadValor(p1) - prioridadValor(p2);
    }

    private int prioridadValor(String p) {
        return switch (p.toLowerCase()) {
            case "alta" -> 1;
            case "media" -> 2;
            case "baja" -> 3;
            default -> 4;
        };
    }
}
