package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IU_ACCESO extends JFrame {
    private JButton logInButton;
    private JPanel contentPane;
    private JButton registerButton;
    private Controler controler = null;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    IU_ACCESO frame = new IU_ACCESO();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public IU_ACCESO() {
        setTitle("Acceso a la Aplicación");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setResizable(false);

        // Panel principal
        contentPane = new JPanel();
        contentPane.setBackground(new Color(60, 63, 65)); // Fondo oscuro
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS)); // Diseño vertical
        setContentPane(contentPane);

        // Botón de login
        logInButton = new JButton("LOG IN");
        logInButton.setAlignmentX(CENTER_ALIGNMENT);
        logInButton.setFont(new Font("Arial", Font.BOLD, 16));
        logInButton.setBackground(new Color(45, 150, 255)); // Azul claro
        logInButton.setForeground(Color.WHITE); // Texto blanco
        logInButton.setFocusPainted(false);
        logInButton.setBorderPainted(false);
        logInButton.setOpaque(true);
        logInButton.setBorder(new EmptyBorder(10, 20, 10, 20)); // Espaciado interno
        logInButton.addActionListener(this.getControler());
        contentPane.add(logInButton);

        // Separación entre botones
        contentPane.add(new JPanel() {{
            setOpaque(false);
            setBorder(new EmptyBorder(10, 0, 10, 0)); // Espacio entre botones
        }});

        // Botón de registro
        registerButton = new JButton("REGISTER");
        registerButton.setAlignmentX(CENTER_ALIGNMENT);
        registerButton.setFont(new Font("Arial", Font.BOLD, 16));
        registerButton.setBackground(new Color(45, 150, 255)); // Azul claro
        registerButton.setForeground(Color.WHITE); // Texto blanco
        registerButton.setFocusPainted(false);
        registerButton.setBorderPainted(false);
        registerButton.setOpaque(true);
        registerButton.setBorder(new EmptyBorder(10, 20, 10, 20)); // Espaciado interno
        registerButton.addActionListener(this.getControler());
        contentPane.add(registerButton);
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
            if (e.getSource().equals(logInButton)) {
                // Iniciar una ventana de login
                closeWindow();
                IU_LOGIN iulg = new IU_LOGIN();
                iulg.run();
            }

            if (e.getSource().equals(registerButton)) {
                // Iniciar una ventana de registro
                closeWindow();
                IU_REGISTRO iur = new IU_REGISTRO();
                iur.run();
            }
        }
    }
}
