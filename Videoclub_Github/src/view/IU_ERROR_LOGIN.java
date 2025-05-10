package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class IU_ERROR_LOGIN extends JFrame {

    private JPanel contentPane;
    private JButton backToLogInBtn;
    private Controler controler = null;

    /**
     * Launch the application.
     */
    public void run() {
        try {
            IU_ERROR_LOGIN frame = new IU_ERROR_LOGIN();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the frame.
     */
    public IU_ERROR_LOGIN() {
        setTitle("Error de Inicio de Sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setResizable(false);

        // Configuración del panel principal
        contentPane = new JPanel();
        contentPane.setBackground(new Color(60, 63, 65)); // Fondo oscuro
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        setContentPane(contentPane);

        // Etiqueta para el mensaje de error
        JLabel lblNewLabel = new JLabel("Correo o contraseña incorrectos. Intente de nuevo.");
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setAlignmentX(CENTER_ALIGNMENT);
        contentPane.add(lblNewLabel);

        // Espaciado después del mensaje
        contentPane.add(Box.createVerticalStrut(20));

        // Botón de aceptar
        backToLogInBtn = new JButton("ACEPTAR");
        backToLogInBtn.setFont(new Font("Arial", Font.BOLD, 14));
        backToLogInBtn.setBackground(new Color(45, 150, 255)); // Azul claro
        backToLogInBtn.setForeground(Color.WHITE);
        backToLogInBtn.setFocusPainted(false);
        backToLogInBtn.setBorderPainted(false);
        backToLogInBtn.setOpaque(true);
        backToLogInBtn.setAlignmentX(CENTER_ALIGNMENT);
        backToLogInBtn.addActionListener(getControler());
        contentPane.add(backToLogInBtn);

        // Espaciado inferior
        contentPane.add(Box.createVerticalStrut(20));
    }

    public void closeWindow() {
        this.dispose();
    }

    private Controler getControler() {
        if (this.controler == null) {
            this.controler = new Controler();
        }
        return this.controler;
    }

    private class Controler implements ActionListener {
        private Controler() {
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(backToLogInBtn)) {
                System.out.println("Volviendo a la pantalla de inicio de sesión...");
                closeWindow();
                IU_LOGIN iulg = new IU_LOGIN();
                iulg.run();
            }
        }
    }
}
