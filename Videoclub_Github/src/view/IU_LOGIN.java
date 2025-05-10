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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.GestorUsuarios;

public class IU_LOGIN extends JFrame {

    private JPanel contentPane;
    private JTextField correoArea;
    private JTextField passwordArea;
    private Controler controler = null;
    private JButton logButton;

    /**
     * Launch the application.
     */
    public void run() {
        try {
            IU_LOGIN frame = new IU_LOGIN();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the frame.
     */
    public IU_LOGIN() {
        setTitle("Inicio de Sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        setResizable(false);

        // Configuración del panel principal
        contentPane = new JPanel();
        contentPane.setBackground(new Color(60, 63, 65)); // Fondo oscuro
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        setContentPane(contentPane);

        // Espaciado superior
        contentPane.add(Box.createVerticalStrut(20));

        // Etiqueta para email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 14));
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setAlignmentX(CENTER_ALIGNMENT);
        contentPane.add(emailLabel);

        // Campo de texto para email
        correoArea = new JTextField(20);
        correoArea.setMaximumSize(correoArea.getPreferredSize());
        correoArea.setAlignmentX(CENTER_ALIGNMENT);
        contentPane.add(correoArea);
        correoArea.addActionListener(getControler());

        // Espaciado entre elementos
        contentPane.add(Box.createVerticalStrut(10));

        // Etiqueta para password
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setAlignmentX(CENTER_ALIGNMENT);
        contentPane.add(passwordLabel);

        // Campo de texto para password
        passwordArea = new JTextField(20);
        passwordArea.setMaximumSize(passwordArea.getPreferredSize());
        passwordArea.setAlignmentX(CENTER_ALIGNMENT);
        contentPane.add(passwordArea);
        passwordArea.addActionListener(getControler());

        // Espaciado entre elementos
        contentPane.add(Box.createVerticalStrut(20));

        // Botón de login
        logButton = new JButton("ACCEDER");
        logButton.setFont(new Font("Arial", Font.BOLD, 14));
        logButton.setBackground(new Color(45, 150, 255)); // Azul claro
        logButton.setForeground(Color.WHITE);
        logButton.setFocusPainted(false);
        logButton.setBorderPainted(false);
        logButton.setOpaque(true);
        logButton.setAlignmentX(CENTER_ALIGNMENT);
        logButton.addActionListener(getControler());
        contentPane.add(logButton);

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
            if (e.getSource().equals(logButton)) {
                // CHECKEAR Y PROCEDER CON EL LOGIN
                String email = correoArea.getText();
                String password = passwordArea.getText();

                boolean logInCorrecto = GestorUsuarios.getGUsuarios().checkLogIn(email, password);
                boolean esAdmin = GestorUsuarios.getGUsuarios().esAdmin(email);

                if (logInCorrecto) {
                    // PASA A MENU PRINCIPAL
                    System.out.println("hago close y abro menu");
                    closeWindow();

                    IU_MENU iueli = new IU_MENU(email, esAdmin);
                    iueli.run();
                } else {
                    // MOSTRAR PANTALLA DE ERROR
                    System.out.println("hago close y abro error");
                    closeWindow();
                    IU_ERROR_LOGIN iueli = new IU_ERROR_LOGIN();
                    iueli.run();
                }
            }
        }
    }
}
