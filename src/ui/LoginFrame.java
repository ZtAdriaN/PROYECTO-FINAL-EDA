package ui;
import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    public LoginFrame() {
        setTitle("Login - Sistema de Trámite ULima");
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel de fondo con imagen
        LoginBackgroundPanel fondo = new LoginBackgroundPanel();
        fondo.setLayout(new GridBagLayout()); // Para centrar elementos

        // === LOGO DE LA UNIVERSIDAD ===
        JLabel logoLabel = new JLabel();
        logoLabel.setIcon(new ImageIcon(getClass().getResource("/ui/logo.png")));

        GridBagConstraints gbcLogo = new GridBagConstraints();
        gbcLogo.gridx = 0;
        gbcLogo.gridy = 0;
        gbcLogo.insets = new Insets(20, 0, 20, 0);
        gbcLogo.anchor = GridBagConstraints.CENTER;
        fondo.add(logoLabel, gbcLogo);

        // === PANEL DE LOGIN ===
        JPanel loginPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        loginPanel.setOpaque(false); // Transparente para ver fondo

        JTextField txtUsuario = new JTextField();
        JPasswordField txtClave = new JPasswordField();
        JLabel lblMensaje = new JLabel("", JLabel.CENTER);

        JButton btnLogin = new JButton("Iniciar Sesión");
        btnLogin.addActionListener(e -> {
            String user = txtUsuario.getText().trim();
            String pass = new String(txtClave.getPassword()).trim();

            if (user.equals("admin") && pass.equals("ulima")) {
                new SistemaTabbedFrame().setVisible(true);
                dispose();
            } else {
                lblMensaje.setText("Usuario o contraseña incorrectos");
            }
        });

        loginPanel.add(new JLabel("Usuario:"));
        loginPanel.add(txtUsuario);
        loginPanel.add(new JLabel("Contraseña:"));
        loginPanel.add(txtClave);
        loginPanel.add(new JLabel(""));
        loginPanel.add(btnLogin);
        loginPanel.add(new JLabel(""));
        loginPanel.add(lblMensaje);

        // Agregar loginPanel debajo del logo
        GridBagConstraints gbcForm = new GridBagConstraints();
        gbcForm.gridx = 0;
        gbcForm.gridy = 1;
        gbcForm.anchor = GridBagConstraints.CENTER;
        fondo.add(loginPanel, gbcForm);

        setContentPane(fondo);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true));
    }
}
